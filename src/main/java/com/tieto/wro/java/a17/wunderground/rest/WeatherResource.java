package com.tieto.wro.java.a17.wunderground.rest;


import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.weather.WeatherService;
import com.tieto.wro.java.a17.wunderground.weather.WundergroundResponseTransformer;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;


/**
 *]
 * @author rodzikar
 */
@Path("/")
public class WeatherResource {

	private static final String LOCALHOST_MOCK = "http://localhost:8089/";
	private static final String API_WUNDERGROUND = "http://api.wunderground.com/api/31c81b32dea6da45/conditions/";

	private WundergroundClient wundergroundClient = new WundergroundClient(new URL(API_WUNDERGROUND));
	private WundergroundResponseTransformer wundergroundResponseTransformer = new WundergroundResponseTransformer();
	private WeatherService weatherService = new WeatherService(wundergroundClient, wundergroundResponseTransformer);
	private Logger logger = Logger.getLogger(WeatherResource.class.getName());
	private ObjectMapper objectMapper = new ObjectMapper().configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

	public WeatherResource() throws IOException {
	}


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getInfoAboutApp() {
		logger.info("Accesing blank space - show info about app");
		return Response.status(Response.Status.OK).entity("There is nothing to show here." + "\n"
				+ "Go to /weather or /weather/{city}" + "\n"
				+ "Made by KR.").build();
	}

	@GET
	@Path("/weather")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWeatherFromAllowedCities() throws Exception {
		String json = objectMapper.writeValueAsString(weatherService.getCitiesWeathers());
		return Response.status(Response.Status.OK).entity(json).type(MediaType.APPLICATION_JSON).build();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("weather/{city}")
	public Response getWeatherFromGivenCity(@PathParam("city") String city) throws Exception {
		try {
			String cityIgnoreCase = city.toLowerCase();
			String json = objectMapper.writeValueAsString(weatherService.getCityWeather(cityIgnoreCase));
			logger.info("Returning valid response");
			return Response.status(Response.Status.OK).entity(json).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			logger.error("Return invalid response");
			return Response.status(Response.Status.NOT_FOUND).entity("Service doesnt provide: " + city).build();
		}
	}

}
