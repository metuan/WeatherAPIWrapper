package com.tieto.wro.java.a17.wunderground.client;

import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;

/**
 * Created by KR.
 */
public class WundergroundClient {

    static final String URL_ADRESS_WITH_API_KEY = "http://api.wunderground.com/api/31c81b32dea6da45/conditions";
    private String baseURL;

    public WundergroundClient(String baseURL) {
        this.baseURL = baseURL;
    }

    private WebTarget getTargetToResource(String URL) {
        Client client = ClientBuilder.newClient();
        return client.target(URL);
    }

    private Response buildAPIWeatherClientFromUserInput(String URL) throws MalformedURLException {
        WebTarget weatherResource = getTargetToResource(URL);
        Invocation.Builder prepareExecution = weatherResource.request(MediaType.TEXT_XML);
        Response response = prepareExecution.get();
        response.bufferEntity();
        return response;
    }

    SingleResponse getResponseFromMultipleChoices(String uniqueURL) throws MalformedURLException {
        WebTarget weatherResource = getTargetToResource(uniqueURL);
        Invocation.Builder prepareExecution = weatherResource.request(MediaType.TEXT_XML);
        Response uniqueResponse = prepareExecution.get();
        uniqueResponse.bufferEntity();
        return uniqueResponse.readEntity(SingleResponse.class);
    }

    public IResponse getWeather(String country, String city) throws MalformedURLException {
        String URLToCity = baseURL + "q/" + country + "/" + city + ".xml";
        Response response = buildAPIWeatherClientFromUserInput(URLToCity);
        SingleResponse maybeSingleResponse = response.readEntity(SingleResponse.class);
        if (maybeSingleResponse.getCurrentObservation() == null) {
            MultipleResponse maybeMultipleResponse = response.readEntity(MultipleResponse.class);
            if (maybeMultipleResponse.getResults() == null) {
                return response.readEntity(ErrorResponse.class);
            } else {
                return maybeMultipleResponse;
            }
        }
        return maybeSingleResponse;
    }


}
