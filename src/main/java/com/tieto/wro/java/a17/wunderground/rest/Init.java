package com.tieto.wro.java.a17.wunderground.rest;

import com.tieto.wro.java.a17.wunderground.weather.WeatherService;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;

public class Init extends ResourceConfig {

	public Init() throws IOException {
		packages("com.tieto.wroc.java.a17.wunderground.rest.WeatherResource");
		register(WeatherResource.class);
		packages("com.tieto.wro.java.a17.wunderground.weather.WeatherService");
		WeatherService.initializeMapOfLocations();
	}
}
