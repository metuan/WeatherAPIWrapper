package com.tieto.wro.java.a17.wunderground.rest;


import com.google.gson.Gson;
import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.weather.WeatherService;
import com.tieto.wro.java.a17.wunderground.weather.WundergroundResponseTransformer;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *]
 * @author rodzikar
 */
@Path("/")
public class WeatherResource {
    private WundergroundClient wundergroundClient = new WundergroundClient("http://api.wunderground.com/api/31c81b32dea6da45/conditions/");
    private WundergroundResponseTransformer wundergroundResponseTransformer = new WundergroundResponseTransformer();
    private WeatherService weatherService = new WeatherService(wundergroundClient, wundergroundResponseTransformer);
    private Gson gson = new Gson();
    private Logger logger = Logger.getLogger(WeatherResource.class.getName());

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getInfoAboutApp() {
        logger.info("Accesing blank space - show info about app");
        return Response.status(200).entity("There is nothing to show here." + "\n" +
                                                    "Go to /weather or /weather/{city}" + "\n"+
                                                    "Made by KR.").build();
    }

    @GET
    @Path("/weather")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeatherFromAllowedCities() throws Exception {
        String json = gson.toJson(weatherService.getCitiesWeathers());
        logger.info("Status - 200. Downloaded weathers for all citites");
        return Response.status(200).entity(json).type(MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("weather/{city}")
    public Response getWeatherFromGivenCity(@PathParam("city") String city) throws Exception {
        try {
            String json = gson.toJson(weatherService.getCityWeather(city));
            return Response.status(200).entity(json).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception e) {
            return Response.status(404).entity("Service does not provide weather for given city: " + city).build();
        }
    }

}
