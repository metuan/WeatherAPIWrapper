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

	private static final Logger LOGGER = Logger.getLogger(WundergroundClient.class);
	private URL baseURL;

	public WundergroundClient(URL baseURL) {
		this.baseURL = baseURL;
	}

	private WebTarget getTargetToResource(String url) {
		Client client = ClientBuilder.newClient();
		LOGGER.info("Created WebTarget");
		return client.target(url);
	}

	private Response preparingResponseToReadEntity(String url) throws MalformedURLException {
		WebTarget weatherResource = getTargetToResource(url);
		Invocation.Builder prepareExecution = weatherResource.request(MediaType.TEXT_XML);
		Response response = prepareExecution.get();
		response.bufferEntity();
		return response;
	}

//    SingleResponse getSingleResponseFromMultipleChoices(String uniqueURL) throws MalformedURLException {
//        WebTarget weatherResource = getTargetToResource(uniqueURL);
//        Invocation.Builder prepareExecution = weatherResource.request(MediaType.TEXT_XML);
//        Response uniqueResponse = prepareExecution.get();
//        uniqueResponse.bufferEntity();
//        LOGGER.info("Unique response is taken from multiple response");
//        return uniqueResponse.readEntity(SingleResponse.class);
//    }

	public IResponse getWeather(String country, String city) throws MalformedURLException {
		String urlToCity = baseURL + "q/" + country + "/" + city + ".xml";
		Response response = preparingResponseToReadEntity(urlToCity);
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

	public IResponse getWeather(String uniqueURL) throws MalformedURLException {
		String url = baseURL + uniqueURL;
		Response response = preparingResponseToReadEntity(url);
		return response.readEntity(SingleResponse.class);
	}
}
