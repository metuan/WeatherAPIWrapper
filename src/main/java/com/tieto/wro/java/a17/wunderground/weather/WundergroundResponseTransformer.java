package com.tieto.wro.java.a17.wunderground.weather;

import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import org.apache.log4j.Logger;

/**
 * Created by KR.
 */
public class WundergroundResponseTransformer {

	private static Logger logger = Logger.getLogger(WundergroundResponseTransformer.class);

	public CityWeather transform(IResponse response) throws Exception {
		if (response instanceof SingleResponse) {
			SingleResponse sRespond = (SingleResponse) response;
			CityWeather cityWeatherRespond = new CityWeather();
			cityWeatherRespond.setLocation(sRespond.getCurrentObservation().getDisplayLocation().getFull());
			cityWeatherRespond.setTemperatureCelsius(sRespond.getCurrentObservation().getTempC());
			cityWeatherRespond.setRelativeHumidity(sRespond.getCurrentObservation().getRelativeHumidity());
			cityWeatherRespond.setWindDirection(sRespond.getCurrentObservation().getWindDir());
			cityWeatherRespond.setWeather(sRespond.getCurrentObservation().getWeather());
			cityWeatherRespond.setWindString(sRespond.getCurrentObservation().getWindString());
			cityWeatherRespond.setWeatherDate(sRespond.getCurrentObservation().getObservationTime());
			logger.info("Response transformed");
			return cityWeatherRespond;
		} else {
			logger.error("Response transformer failed");
			throw new RuntimeException("Can not transform to CityWeather class");
		}
	}
}
