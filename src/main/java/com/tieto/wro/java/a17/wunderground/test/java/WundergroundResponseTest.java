package com.tieto.wro.java.a17.wunderground.test.java;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.tieto.wro.java.a17.wunderground.client.*;
import com.tieto.wro.java.a17.wunderground.model.*;
import com.tieto.wro.java.a17.wunderground.weather.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static net.jadler.Jadler.*;

/**
 * Created by KR.
 */
public class WundergroundResponseTest {

    private static final String SINGLE_RESPONSE_CITY = "warszawa";
    private static final String MUTLITPLE_RESPONSE_CITY = "krakow";
    private static final String ERROR_RESPONSE_CTY = "xdxdasdas";
    private static final String COUNTRY = "poland";
    private WundergroundClient wc;
    private WundergroundResponseTransformer wrt;
    private Logger logger = Logger.getLogger(WeatherServiceTest.class.getName());

    private String convertXMLFileToString(String fileName) throws FileNotFoundException {
        return new Scanner(new File(fileName).getAbsoluteFile()).useDelimiter("\\Z").next();
    }

    @Before
    public void setUp() {
        logger.info("RESPONSE TRANSFORMER TESTS INITLLIAZED");
        initJadler();
        wc = new WundergroundClient("http://localhost:" + port() + "/");
        wrt = new WundergroundResponseTransformer();

    }

    @After
    public void tearDown() {
        closeJadler();
    }

    @Test
    public void check_if_floating_point_temperature_is_the_same() throws Exception {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\WarszawaResponse.xml");
        String URLToSingleResponse = "/q/poland/warszawa.xml";
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToSingleResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);
        IResponse response = wc.getWeather(COUNTRY, SINGLE_RESPONSE_CITY);
        SingleResponse respnse = (SingleResponse) response;
        CityWeather cw = wrt.transform(response);
        Assert.assertNotNull(cw);
        Assert.assertEquals(cw.getTemperatureCelsius(), respnse.getCurrentObservation().getTempC(), 0.1);
    }

    @Test
    public void check_if_string_description_is_the_same() throws Exception {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\WarszawaResponse.xml");
        String URLToSingleResponse = "/q/poland/warszawa.xml";
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToSingleResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);

        IResponse response = wc.getWeather(COUNTRY, SINGLE_RESPONSE_CITY);
        SingleResponse uniqueSingleResposne = (SingleResponse) response;
        CityWeather cw = wrt.transform(response);
        Assert.assertNotNull(cw);
        Assert.assertEquals(cw.getWeather(), uniqueSingleResposne.getCurrentObservation().getWeather());
    }

    @Test
    public void check_if_string_location_is_the_same() throws Exception {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\WarszawaResponse.xml");
        String URLToSingleResponse = "/q/poland/warszawa.xml";
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToSingleResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);

        IResponse response = wc.getWeather(COUNTRY, SINGLE_RESPONSE_CITY);
        SingleResponse singleResponse = (SingleResponse) response;
        CityWeather cw = wrt.transform(response);
        Assert.assertNotNull(cw);
        Assert.assertEquals(cw.getLocation(), singleResponse.getCurrentObservation().getDisplayLocation().getFull());
    }

    @Test(expected = RuntimeException.class)
    public void check_if_exception_is_thrown_with_error_response() throws Exception {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\ErrorResponse.xml");
        String URLToSingleResponse = "/q/poland/" + ERROR_RESPONSE_CTY + ".xml";
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToSingleResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);

        IResponse response = wc.getWeather(COUNTRY, ERROR_RESPONSE_CTY);
        ErrorResponse errorResponse = (ErrorResponse) response;
        CityWeather cw = wrt.transform(errorResponse);
        Assert.assertNull(cw);
    }

    @Test(expected = RuntimeException.class)
    public void check_if_exception_is_thrown_with_mutiple_response() throws Exception {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\ErrorResponse.xml");
        String URLToSingleResponse = "/q/poland/" + MUTLITPLE_RESPONSE_CITY + ".xml";
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToSingleResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);

        IResponse response = wc.getWeather(COUNTRY, MUTLITPLE_RESPONSE_CITY);
        MultipleResponse multipleResponse = (MultipleResponse) response;
        CityWeather cw = wrt.transform(multipleResponse);
        Assert.assertNull(cw);
    }
}
