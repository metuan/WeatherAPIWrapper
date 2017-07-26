package com.tieto.wro.java.a17.wunderground.weather;

import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import com.tieto.wro.java.a17.wunderground.rest.WeatherResource;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KR.
 */
public class WeatherService {

    private final WundergroundClient wundergroundClient;
    private static final Map<String, String> CONTAINER_OF_ALLOWED_CITIES;
    private final WundergroundResponseTransformer wundergroudResponseTransformer;
    private Logger logger = Logger.getLogger(WeatherResource.class.getName());



    static {
        CONTAINER_OF_ALLOWED_CITIES = new HashMap<>();
        CONTAINER_OF_ALLOWED_CITIES.put("warszawa", "poland");
        CONTAINER_OF_ALLOWED_CITIES.put("gdansk", "poland");
        CONTAINER_OF_ALLOWED_CITIES.put("quebec", "canada");
        CONTAINER_OF_ALLOWED_CITIES.put("barcelona", "spain");
        CONTAINER_OF_ALLOWED_CITIES.put("magdeburg", "germany");
    }

    public WeatherService(WundergroundClient wundergroundClient, WundergroundResponseTransformer wundergroudResponseTransformer) {
        this.wundergroudResponseTransformer = wundergroudResponseTransformer;
        this.wundergroundClient = wundergroundClient;
    }


    public CityWeather getCityWeather(String city) throws Exception {
        if (!CONTAINER_OF_ALLOWED_CITIES.containsKey(city)) {
            logger.error("Can not find city with given name or service is not provided");
            throw new RuntimeException();
        }
        else {
            logger.info("Downloaded weather for " + city);
            String country = CONTAINER_OF_ALLOWED_CITIES.get(city);
            SingleResponse singleResponse = (SingleResponse) wundergroundClient.getWeather(country, city);
            return wundergroudResponseTransformer.transform(singleResponse);
        }
    }
    public List<CityWeather> getCitiesWeathers() throws Exception {
        List<CityWeather> listOfWeathersInGivenCities = new ArrayList<>();
        for (String city : CONTAINER_OF_ALLOWED_CITIES.keySet()) {
            SingleResponse singleResponse = (SingleResponse) wundergroundClient.getWeather(CONTAINER_OF_ALLOWED_CITIES.get(city), city);
            CityWeather cityWeatherInUniqueCity = wundergroudResponseTransformer.transform(singleResponse);
            listOfWeathersInGivenCities.add(cityWeatherInUniqueCity);
        }
        return listOfWeathersInGivenCities;
    }
}
