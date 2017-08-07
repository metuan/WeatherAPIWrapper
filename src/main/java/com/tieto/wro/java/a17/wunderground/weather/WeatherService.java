package com.tieto.wro.java.a17.wunderground.weather;

import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import com.tieto.wro.java.a17.wunderground.rest.WeatherResource;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KR.
 */
public class WeatherService {

	private static final CitiesFileReader CITIES_FILE_READER = new CitiesFileReader();
	private final WundergroundClient wundergroundClient;
	private static HashMap<String, String> containerOfAllowedCities;
	private final WundergroundResponseTransformer wundergroudResponseTransformer;
	private static final Logger LOGGER = Logger.getLogger(WeatherResource.class.getName());

	public WeatherService(WundergroundClient wc, WundergroundResponseTransformer wrt) throws IOException {
		this.wundergroudResponseTransformer = wrt;
		this.wundergroundClient = wc;
	}
	public static void initializeMapOfLocations() throws IOException {
		LOGGER.info("Initialized map of locations");
		if (System.getProperty("weather.citiesFile") == null) {
			containerOfAllowedCities = CITIES_FILE_READER.getMapOfLocations("src/main/resources/cities.json");
		} else {
			containerOfAllowedCities = CITIES_FILE_READER.getMapOfLocations(System.getProperty("weather.citiesFile"));
		}
	}
	public CityWeather getCityWeather(String city) throws Exception {
		if (!containerOfAllowedCities.containsKey(city)) {
			LOGGER.error("Can not find city with given name or service is not provided" + "[" + city + "]");
			throw new RuntimeException();
		} else {
			String uniqueURL = containerOfAllowedCities.get(city);
			SingleResponse singleResponse = (SingleResponse) wundergroundClient.getWeather(uniqueURL);
			LOGGER.info("Downloading weather for " + city);
			return wundergroudResponseTransformer.transform(singleResponse);
		}
	}
	public List<CityWeather> getCitiesWeathers() throws Exception {
		List<CityWeather> listOfWeathersInGivenCities = new ArrayList<>();
		LOGGER.info("Started to download weathers for all citites");
		for (String city : containerOfAllowedCities.keySet()) {
			SingleResponse respond = (SingleResponse) wundergroundClient.getWeather(containerOfAllowedCities.get(city));
			CityWeather cityWeatherInUniqueCity = wundergroudResponseTransformer.transform(respond);
			listOfWeathersInGivenCities.add(cityWeatherInUniqueCity);
		}
		return listOfWeathersInGivenCities;
	}
}
