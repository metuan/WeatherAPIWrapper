package com.tieto.wro.java.a17.wunderground.weather;

/**
 * Created by KR.
 */
public class CityWeather {

	private String location;
	private float temperatureCelsius;
	private String relativeHumidity;
	private String windDirection;
	private String weather;
	private String windString;
	private String weatherDate;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getTemperatureCelsius() {
		return temperatureCelsius;
	}

	public void setTemperatureCelsius(float temperatureCelsius) {
		this.temperatureCelsius = temperatureCelsius;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWindString() {
		return windString;
	}

	public void setWindString(String windString) {
		this.windString = windString;
	}

	public String getWeatherDate() {
		return weatherDate;
	}

	public void setWeatherDate(String weatherDate) {
		this.weatherDate = weatherDate;
	}

	@Override
	public String toString() {
		return  "location: " + this.location + "\n"
				+ "tempC: " + this.temperatureCelsius + "\n"
				+ "relative humidty: " + this.relativeHumidity + "\n"
				+ "wind direction: " + this.windDirection + "\n"
				+ "weather: " + this.weather + "\n"
				+ "wind description: " + this.windString + "\n"
				+ this.weatherDate;
	}
}
