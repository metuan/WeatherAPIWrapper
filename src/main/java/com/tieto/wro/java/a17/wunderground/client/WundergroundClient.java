package com.tieto.wro.java.a17.wunderground.client;

import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by KR.
 */
public class WundergroundClient {

    private static final Logger logger = Logger.getLogger(WundergroundClient.class);
    private URL baseURL;

    public WundergroundClient(URL baseURL) {
        logger.info("Created Wunderground client");
        this.baseURL = baseURL;
    }

    private WebTarget getTargetToResource(String URL) {
        Client client = ClientBuilder.newClient();
        logger.info("Created WebTarget");
        return client.target(URL);
    }

    private Response preparingResponseToReadEntity (String URL) throws MalformedURLException {
        WebTarget weatherResource = getTargetToResource(URL);
        Invocation.Builder prepareExecution = weatherResource.request(MediaType.TEXT_XML);
        Response response = prepareExecution.get();
        response.bufferEntity();
        logger.info("Response prepared to read entity");
        return response;
    }

    SingleResponse getSingleResponseFromMultipleChoices(String uniqueURL) throws MalformedURLException {
        WebTarget weatherResource = getTargetToResource(uniqueURL);
        Invocation.Builder prepareExecution = weatherResource.request(MediaType.TEXT_XML);
        Response uniqueResponse = prepareExecution.get();
        uniqueResponse.bufferEntity();
        logger.info("Unique response is taken from multiple response");
        return uniqueResponse.readEntity(SingleResponse.class);
    }

    public IResponse getWeather(String country, String city) throws MalformedURLException {
        logger.info("GetWeather initialized with (" + country + ", " + city + ")");
        String URLToCity = baseURL + "q/" + country + "/" + city + ".xml";
        Response response = preparingResponseToReadEntity(URLToCity);
        SingleResponse maybeSingleResponse = response.readEntity(SingleResponse.class);
        if (maybeSingleResponse.getCurrentObservation() == null) {
            MultipleResponse maybeMultipleResponse = response.readEntity(MultipleResponse.class);
            if (maybeMultipleResponse.getResults() == null) {
                logger.info("Returning error response of (" + country + ", " + city + ")");
                logger.error("Got error reponse with (" + country + ", " + city + ")");
                return response.readEntity(ErrorResponse.class);
            } else {
                logger.info("Returning mutliple response of (" + country + ", " + city + ")");
                return maybeMultipleResponse;
            }
        }
        logger.info("Returning Single response of (" + country + ", " + city + ")");
        return maybeSingleResponse;
    }


}
