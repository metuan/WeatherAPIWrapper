package com.tieto.wro.java.a17.wunderground.test.java; /**
 * Created by KR.
 */
import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import com.tieto.wro.java.a17.wunderground.rest.WeatherResource;
import com.tieto.wro.java.a17.wunderground.weather.CityWeather;
import com.tieto.wro.java.a17.wunderground.weather.WeatherService;
import com.tieto.wro.java.a17.wunderground.weather.WundergroundResponseTransformer;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {

    private WundergroundClient testerClient;
    private CityWeather cityWeather;
    private CityWeather cityWeather1;
    private WeatherService testerService;
    private WundergroundResponseTransformer testerTransformer;
    private Logger logger = Logger.getLogger(WeatherServiceTest.class.getName());


    @Before
    public void setUp() throws Exception {
        logger.info("SERVICE TESTS INITLLIAZED");
        testerClient = mock(WundergroundClient.class);
        SingleResponse singleResponse = setUpTestResponse();
        cityWeather = setUpTestWeather();
        testerTransformer = mock(WundergroundResponseTransformer.class);
        testerService = new WeatherService(testerClient, testerTransformer);

        when(testerTransformer.transform(singleResponse)).thenReturn(cityWeather);
        when(testerClient.getWeather("poland", "gdansk")).thenReturn(singleResponse);

        cityWeather1 = testerService.getCityWeather("gdansk");
    }

    private CityWeather setUpTestWeather() {
        CityWeather cw = new CityWeather();
        cw.setLocation("Gdansk, Poland");
        cw.setTemperatureCelsius((float) 20.0);
        cw.setRelativeHumidity("79%");
        cw.setWindDirection("SW");
        cw.setWeather("Partly Cloudy");
        cw.setWindString("Calm");
        cw.setWeatherDate("Last Updated on July 20, 12:06 PM CEST");
        return cw;
    }
    private SingleResponse setUpTestResponse() {
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.setCurrentObservation(new SingleResponse.CurrentObservation());
        singleResponse.getCurrentObservation().setDisplayLocation(new SingleResponse.CurrentObservation.DisplayLocation());
        singleResponse.getCurrentObservation().getDisplayLocation().setFull("Gdansk, Poland");
        singleResponse.getCurrentObservation().setTempC((float) 20.0);
        singleResponse.getCurrentObservation().setRelativeHumidity("79%");
        singleResponse.getCurrentObservation().setWindDir("SW");
        singleResponse.getCurrentObservation().setWeather("Partly Cloud");
        singleResponse.getCurrentObservation().setWindString("Calm");
        singleResponse.getCurrentObservation().setObservationTime("Last Updated on July 20, 12:06 PM CEST");
        return singleResponse;
    }




    @Test
    public void test_supported_city_string_location() throws Exception {
        Assert.assertEquals(testerService.getCityWeather("gdansk").getLocation(), cityWeather.getLocation());
    }

    @Test
    public void test_supported_city_float_temperature() throws Exception {

        Assert.assertEquals(testerService.getCityWeather("gdansk").getTemperatureCelsius(), cityWeather.getTemperatureCelsius(), 0.01);
    }

    @Test(expected = RuntimeException.class)
    public void test_unsupported_city() throws Exception {
        testerService.getCityWeather("krakow");
    }
    @Test
    public void test_constructor_class() {
        WeatherService ws1 = new WeatherService(new WundergroundClient("Byl co 123"), new WundergroundResponseTransformer());
    }

    @Test
    public void test_supported_city_same_object() throws Exception {
        Assert.assertSame(testerService.getCityWeather("gdansk"), cityWeather);
    }

    @Test
    public void is_building_the_service() {
        Assert.assertNotNull(testerService);
    }
    @Test
    public void is_mocking_the_transformer() {
        Assert.assertNotNull(testerTransformer);
    }
    @Test
    public void is_mocking_the_Client() {
        Assert.assertNotNull(testerClient);
    }

}
