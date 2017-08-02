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

    private final static CitiesFileReader citiesFileReader = new CitiesFileReader();
    private final WundergroundClient wundergroundClient;
    private static HashMap<String, String> CONTAINER_OF_ALLOWED_CITIES;
    private final WundergroundResponseTransformer wundergroudResponseTransformer;
    private static final Logger logger = Logger.getLogger(WeatherResource.class.getName());


    public WeatherService(WundergroundClient wundergroundClient, WundergroundResponseTransformer wundergroudResponseTransformer) throws IOException {
        this.wundergroudResponseTransformer = wundergroudResponseTransformer;
        this.wundergroundClient = wundergroundClient;
    }

    public static void initializeMapOfLocations() throws IOException {
        logger.info("Initialized map of locations");
        if (System.getProperty("weather.citiesFile") == null) {
            CONTAINER_OF_ALLOWED_CITIES = citiesFileReader.getMapOfLocations("src\\main\\resources\\cities.json");
        }
        else {
            CONTAINER_OF_ALLOWED_CITIES = citiesFileReader.getMapOfLocations(System.getProperty("weather.citiesFile"));
        }
    }

    public CityWeather getCityWeather(String city) throws Exception {
        if (!CONTAINER_OF_ALLOWED_CITIES.containsKey(city)) {
            logger.error("Can not find city with given name or service is not provided" + "[" + city + "]");
            throw new RuntimeException();
        }
        else {
            String uniqueURL = CONTAINER_OF_ALLOWED_CITIES.get(city);
            SingleResponse singleResponse = (SingleResponse) wundergroundClient.getWeather(uniqueURL);
            logger.info("Downloading weather for " + city);
            return wundergroudResponseTransformer.transform(singleResponse);
        }
    }
    public List<CityWeather> getCitiesWeathers() throws Exception {
        List<CityWeather> listOfWeathersInGivenCities = new ArrayList<>();

        for (String city : CONTAINER_OF_ALLOWED_CITIES.keySet()) {
            SingleResponse singleResponse = (SingleResponse) wundergroundClient.getWeather(CONTAINER_OF_ALLOWED_CITIES.get(city));
            CityWeather cityWeatherInUniqueCity = wundergroudResponseTransformer.transform(singleResponse);
            listOfWeathersInGivenCities.add(cityWeatherInUniqueCity);
        }
        return listOfWeathersInGivenCities;
    }
}
