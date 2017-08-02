package com.tieto.wro.java.a17.wunderground.weather;

import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import org.apache.log4j.Logger;

/**
 * Created by KR.
 */
public class WundergroundResponseTransformer {

    private static Logger logger = Logger.getLogger(WundergroundResponseTransformer.class);

    public CityWeather transform(IResponse response) throws Exception {
        if (response instanceof SingleResponse) {
            SingleResponse uniqueSingleResponse = (SingleResponse) response;
            CityWeather cityWeatherBasedOnResponse = new CityWeather();
            cityWeatherBasedOnResponse.setLocation(uniqueSingleResponse.getCurrentObservation().getDisplayLocation().getFull());
            cityWeatherBasedOnResponse.setTemperatureCelsius(uniqueSingleResponse.getCurrentObservation().getTempC());
            cityWeatherBasedOnResponse.setRelativeHumidity(uniqueSingleResponse.getCurrentObservation().getRelativeHumidity());
            cityWeatherBasedOnResponse.setWindDirection(uniqueSingleResponse.getCurrentObservation().getWindDir());
            cityWeatherBasedOnResponse.setWeather(uniqueSingleResponse.getCurrentObservation().getWeather());
            cityWeatherBasedOnResponse.setWindString(uniqueSingleResponse.getCurrentObservation().getWindString());
            cityWeatherBasedOnResponse.setWeatherDate(uniqueSingleResponse.getCurrentObservation().getObservationTime());
            logger.info("Response transformed");
            return cityWeatherBasedOnResponse;
        }
        else {
            logger.error("Response transformer failed");
            throw new RuntimeException("Can not transform to CityWeather class");
        }
    }
}
