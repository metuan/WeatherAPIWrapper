package com.tieto.wro.java.a17.wunderground.test.java; /**
 * Created by KR.
 */

import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Scanner;

import static net.jadler.Jadler.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class WundergroundClientTest {

    private static final String SINGLE_RESPONSE_CITY = "warszawa";
    private static final String MUTLITPLE_RESPONSE_CITY = "krakow";
    private static final String ERROR_RESPONSE_CTY = "xdxdasdas";
    private static final String COUNTRY = "poland";
    private WundergroundClient wc;
    private Logger logger = Logger.getLogger(WeatherServiceTest.class.getName());

    private String convertXMLFileToString(String fileName) throws FileNotFoundException {
        return new Scanner(new File(fileName).getAbsoluteFile()).useDelimiter("\\Z").next();
    }

    @Before
    public void setUp() {
        logger.info("CLIENT TESTS INITLLIAZED");
        initJadler();
        wc = new WundergroundClient("http://localhost:" + port() +"/");
    }

    @After
    public void tearDown() {
        closeJadler();
    }

    @Test
    public void check_if_there_is_single_reponse() throws FileNotFoundException, MalformedURLException {
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
        Assert.assertNotNull(response);
        Assert.assertThat(response, instanceOf(SingleResponse.class));
    }

    @Test
    public void check_if_there_is_error_response() throws FileNotFoundException, MalformedURLException {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\ErrorResponse.xml");
        String URLToErrorResponse = "/q/poland/xdxdasdas.xml";

        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToErrorResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);

        IResponse response = wc.getWeather(COUNTRY, ERROR_RESPONSE_CTY);
        Assert.assertNotNull(response);
        Assert.assertThat(response, instanceOf(ErrorResponse.class));
    }

    @Test
    public void check_if_there_is_multiple_response() throws MalformedURLException, FileNotFoundException {
        String contentOfXML = convertXMLFileToString("src\\main\\java\\com\\tieto\\wro\\java\\a17\\wunderground\\test\\resource\\KrakowResponse.xml");
        String URLToErrorResponse = "/q/poland/krakow.xml";

        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo(URLToErrorResponse)
                .respond()
                .withBody(contentOfXML)
                .withContentType("application/XML")
                .withStatus(200);

        IResponse response = wc.getWeather(COUNTRY, MUTLITPLE_RESPONSE_CITY);
        Assert.assertNotNull(response);
        Assert.assertThat(response, instanceOf(MultipleResponse.class));
    }


}
