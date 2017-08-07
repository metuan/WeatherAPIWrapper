package com.tieto.wro.java.a17.wunderground.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"version",
		"termsofService",
		"features",
		"currentObservation"
})
@XmlRootElement(name = "response")
public class SingleResponse implements IResponse {

	protected float version;
	@XmlElement(required = true)
	protected String termsofService;
	@XmlElement(required = true)
	protected SingleResponse.Features features;
	@XmlElement(name = "current_observation", required = true)
	protected SingleResponse.CurrentObservation currentObservation;


	public float getVersion() {
		return version;
	}

	public void setVersion(float value) {
		this.version = value;
	}

	public String getTermsofService() {
		return termsofService;
	}

	public void setTermsofService(String value) {
		this.termsofService = value;
	}

	public SingleResponse.Features getFeatures() {
		return features;
	}

	public void setFeatures(SingleResponse.Features value) {
		this.features = value;
	}

	public SingleResponse.CurrentObservation getCurrentObservation() {
		return currentObservation;
	}

	public void setCurrentObservation(SingleResponse.CurrentObservation value) {
		this.currentObservation = value;
	}


	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"image",
			"displayLocation",
			"observationLocation",
			"estimated",
			"stationId",
			"observationTime",
			"observationTimeRfc822",
			"observationEpoch",
			"localTimeRfc822",
			"localEpoch",
			"localTzShort",
			"localTzLong",
			"localTzOffset",
			"weather",
			"temperatureString",
			"tempF",
			"tempC",
			"relativeHumidity",
			"windString",
			"windDir",
			"windDegrees",
			"windMph",
			"windGustMph",
			"windKph",
			"windGustKph",
			"pressureMb",
			"pressureIn",
			"pressureTrend",
			"dewpointString",
			"dewpointF",
			"dewpointC",
			"heatIndexString",
			"heatIndexF",
			"heatIndexC",
			"windchillString",
			"windchillF",
			"windchillC",
			"feelslikeString",
			"feelslikeF",
			"feelslikeC",
			"visibilityMi",
			"visibilityKm",
			"solarradiation",
			"uv",
			"precip1HrString",
			"precip1HrIn",
			"precip1HrMetric",
			"precipTodayString",
			"precipTodayIn",
			"precipTodayMetric",
			"icon",
			"iconUrl",
			"forecastUrl",
			"historyUrl",
			"obUrl"
	})
	public static class CurrentObservation {

		@XmlElement(required = true)
		protected SingleResponse.CurrentObservation.Image image;
		@XmlElement(name = "display_location", required = true)
		protected SingleResponse.CurrentObservation.DisplayLocation displayLocation;
		@XmlElement(name = "observation_location", required = true)
		protected SingleResponse.CurrentObservation.ObservationLocation observationLocation;
		@XmlElement(required = true)
		protected String estimated;
		@XmlElement(name = "station_id", required = true)
		protected String stationId;
		@XmlElement(name = "observation_time", required = true)
		protected String observationTime;
		@XmlElement(name = "observation_time_rfc822", required = true)
		protected String observationTimeRfc822;
		@XmlElement(name = "observation_epoch")
		protected int observationEpoch;
		@XmlElement(name = "local_time_rfc822", required = true)
		protected String localTimeRfc822;
		@XmlElement(name = "local_epoch")
		protected int localEpoch;
		@XmlElement(name = "local_tz_short", required = true)
		protected String localTzShort;
		@XmlElement(name = "local_tz_long", required = true)
		protected String localTzLong;
		@XmlElement(name = "local_tz_offset")
		protected short localTzOffset;
		@XmlElement(required = true)
		protected String weather;
		@XmlElement(name = "temperature_string", required = true)
		protected String temperatureString;
		@XmlElement(name = "temp_f")
		protected float tempF;
		@XmlElement(name = "temp_c")
		protected float tempC;
		@XmlElement(name = "relative_humidity", required = true)
		protected String relativeHumidity;
		@XmlElement(name = "wind_string", required = true)
		protected String windString;
		@XmlElement(name = "wind_dir", required = true)
		protected String windDir;
		@XmlElement(name = "wind_degrees")
		protected short windDegrees;
		@XmlElement(name = "wind_mph")
		protected float windMph;
		@XmlElement(name = "wind_gust_mph")
		protected float windGustMph;
		@XmlElement(name = "wind_kph")
		protected float windKph;
		@XmlElement(name = "wind_gust_kph")
		protected float windGustKph;
		@XmlElement(name = "pressure_mb")
		protected short pressureMb;
		@XmlElement(name = "pressure_in")
		protected float pressureIn;
		@XmlElement(name = "pressure_trend")
		protected byte pressureTrend;
		@XmlElement(name = "dewpoint_string", required = true)
		protected String dewpointString;
		@XmlElement(name = "dewpoint_f")
		protected byte dewpointF;
		@XmlElement(name = "dewpoint_c")
		protected byte dewpointC;
		@XmlElement(name = "heat_index_string", required = true)
		protected String heatIndexString;
		@XmlElement(name = "heat_index_f", required = true)
		protected String heatIndexF;
		@XmlElement(name = "heat_index_c", required = true)
		protected String heatIndexC;
		@XmlElement(name = "windchill_string", required = true)
		protected String windchillString;
		@XmlElement(name = "windchill_f", required = true)
		protected String windchillF;
		@XmlElement(name = "windchill_c", required = true)
		protected String windchillC;
		@XmlElement(name = "feelslike_string", required = true)
		protected String feelslikeString;
		@XmlElement(name = "feelslike_f")
		protected float feelslikeF;
		@XmlElement(name = "feelslike_c")
		protected float feelslikeC;
		@XmlElement(name = "visibility_mi", required = true)
		protected String visibilityMi;
		@XmlElement(name = "visibility_km", required = true)
		protected String visibilityKm;
		protected short solarradiation;
		@XmlElement(name = "UV")
		protected float uv;
		@XmlElement(name = "precip_1hr_string", required = true)
		protected String precip1HrString;
		@XmlElement(name = "precip_1hr_in")
		protected float precip1HrIn;
		@XmlElement(name = "precip_1hr_metric")
		protected byte precip1HrMetric;
		@XmlElement(name = "precip_today_string", required = true)
		protected String precipTodayString;
		@XmlElement(name = "precip_today_in")
		protected float precipTodayIn;
		@XmlElement(name = "precip_today_metric")
		protected byte precipTodayMetric;
		@XmlElement(required = true)
		protected String icon;
		@XmlElement(name = "icon_url", required = true)
		@XmlSchemaType(name = "anyURI")
		protected String iconUrl;
		@XmlElement(name = "forecast_url", required = true)
		protected String forecastUrl;
		@XmlElement(name = "history_url", required = true)
		protected String historyUrl;
		@XmlElement(name = "ob_url", required = true)
		protected String obUrl;

		/**
		 * Gets the value of the image property.
		 *
		 * @return
		 *     possible object is
		 *     {@link SingleResponse.CurrentObservation.Image }
		 *
		 */
		public SingleResponse.CurrentObservation.Image getImage() {
			return image;
		}

		/**
		 * Sets the value of the image property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link SingleResponse.CurrentObservation.Image }
		 *
		 */
		public void setImage(SingleResponse.CurrentObservation.Image value) {
			this.image = value;
		}

		/**
		 * Gets the value of the displayLocation property.
		 *
		 * @return
		 *     possible object is
		 *     {@link SingleResponse.CurrentObservation.DisplayLocation }
		 *
		 */
		public SingleResponse.CurrentObservation.DisplayLocation getDisplayLocation() {
			return displayLocation;
		}

		/**
		 * Sets the value of the displayLocation property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link SingleResponse.CurrentObservation.DisplayLocation }
		 *
		 */
		public void setDisplayLocation(SingleResponse.CurrentObservation.DisplayLocation value) {
			this.displayLocation = value;
		}

		/**
		 * Gets the value of the observationLocation property.
		 *
		 * @return
		 *     possible object is
		 *     {@link SingleResponse.CurrentObservation.ObservationLocation }
		 *
		 */
		public SingleResponse.CurrentObservation.ObservationLocation getObservationLocation() {
			return observationLocation;
		}

		/**
		 * Sets the value of the observationLocation property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link SingleResponse.CurrentObservation.ObservationLocation }
		 *
		 */
		public void setObservationLocation(SingleResponse.CurrentObservation.ObservationLocation value) {
			this.observationLocation = value;
		}

		/**
		 * Gets the value of the estimated property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getEstimated() {
			return estimated;
		}

		/**
		 * Sets the value of the estimated property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setEstimated(String value) {
			this.estimated = value;
		}

		/**
		 * Gets the value of the stationId property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getStationId() {
			return stationId;
		}

		/**
		 * Sets the value of the stationId property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setStationId(String value) {
			this.stationId = value;
		}

		/**
		 * Gets the value of the observationTime property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getObservationTime() {
			return observationTime;
		}

		/**
		 * Sets the value of the observationTime property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setObservationTime(String value) {
			this.observationTime = value;
		}

		/**
		 * Gets the value of the observationTimeRfc822 property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getObservationTimeRfc822() {
			return observationTimeRfc822;
		}

		/**
		 * Sets the value of the observationTimeRfc822 property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setObservationTimeRfc822(String value) {
			this.observationTimeRfc822 = value;
		}

		/**
		 * Gets the value of the observationEpoch property.
		 *
		 */
		public int getObservationEpoch() {
			return observationEpoch;
		}

		/**
		 * Sets the value of the observationEpoch property.
		 *
		 */
		public void setObservationEpoch(int value) {
			this.observationEpoch = value;
		}

		/**
		 * Gets the value of the localTimeRfc822 property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getLocalTimeRfc822() {
			return localTimeRfc822;
		}

		/**
		 * Sets the value of the localTimeRfc822 property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setLocalTimeRfc822(String value) {
			this.localTimeRfc822 = value;
		}

		/**
		 * Gets the value of the localEpoch property.
		 *
		 */
		public int getLocalEpoch() {
			return localEpoch;
		}

		/**
		 * Sets the value of the localEpoch property.
		 *
		 */
		public void setLocalEpoch(int value) {
			this.localEpoch = value;
		}

		/**
		 * Gets the value of the localTzShort property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getLocalTzShort() {
			return localTzShort;
		}

		/**
		 * Sets the value of the localTzShort property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setLocalTzShort(String value) {
			this.localTzShort = value;
		}

		/**
		 * Gets the value of the localTzLong property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getLocalTzLong() {
			return localTzLong;
		}

		/**
		 * Sets the value of the localTzLong property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setLocalTzLong(String value) {
			this.localTzLong = value;
		}

		/**
		 * Gets the value of the localTzOffset property.
		 *
		 */
		public short getLocalTzOffset() {
			return localTzOffset;
		}

		/**
		 * Sets the value of the localTzOffset property.
		 *
		 */
		public void setLocalTzOffset(short value) {
			this.localTzOffset = value;
		}

		/**
		 * Gets the value of the weather property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getWeather() {
			return weather;
		}

		/**
		 * Sets the value of the weather property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setWeather(String value) {
			this.weather = value;
		}

		/**
		 * Gets the value of the temperatureString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getTemperatureString() {
			return temperatureString;
		}

		/**
		 * Sets the value of the temperatureString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setTemperatureString(String value) {
			this.temperatureString = value;
		}

		/**
		 * Gets the value of the tempF property.
		 *
		 */
		public float getTempF() {
			return tempF;
		}

		/**
		 * Sets the value of the tempF property.
		 *
		 */
		public void setTempF(float value) {
			this.tempF = value;
		}

		/**
		 * Gets the value of the tempC property.
		 *
		 */
		public float getTempC() {
			return tempC;
		}

		/**
		 * Sets the value of the tempC property.
		 *
		 */
		public void setTempC(float value) {
			this.tempC = value;
		}

		/**
		 * Gets the value of the relativeHumidity property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getRelativeHumidity() {
			return relativeHumidity;
		}

		/**
		 * Sets the value of the relativeHumidity property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setRelativeHumidity(String value) {
			this.relativeHumidity = value;
		}

		/**
		 * Gets the value of the windString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getWindString() {
			return windString;
		}

		/**
		 * Sets the value of the windString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setWindString(String value) {
			this.windString = value;
		}

		/**
		 * Gets the value of the windDir property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getWindDir() {
			return windDir;
		}

		/**
		 * Sets the value of the windDir property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setWindDir(String value) {
			this.windDir = value;
		}

		/**
		 * Gets the value of the windDegrees property.
		 *
		 */
		public short getWindDegrees() {
			return windDegrees;
		}

		/**
		 * Sets the value of the windDegrees property.
		 *
		 */
		public void setWindDegrees(short value) {
			this.windDegrees = value;
		}

		/**
		 * Gets the value of the windMph property.
		 *
		 */
		public float getWindMph() {
			return windMph;
		}

		/**
		 * Sets the value of the windMph property.
		 *
		 */
		public void setWindMph(float value) {
			this.windMph = value;
		}

		/**
		 * Gets the value of the windGustMph property.
		 *
		 */
		public float getWindGustMph() {
			return windGustMph;
		}

		/**
		 * Sets the value of the windGustMph property.
		 *
		 */
		public void setWindGustMph(float value) {
			this.windGustMph = value;
		}

		/**
		 * Gets the value of the windKph property.
		 *
		 */
		public float getWindKph() {
			return windKph;
		}

		/**
		 * Sets the value of the windKph property.
		 *
		 */
		public void setWindKph(float value) {
			this.windKph = value;
		}

		/**
		 * Gets the value of the windGustKph property.
		 *
		 */
		public float getWindGustKph() {
			return windGustKph;
		}

		/**
		 * Sets the value of the windGustKph property.
		 *
		 */
		public void setWindGustKph(float value) {
			this.windGustKph = value;
		}

		/**
		 * Gets the value of the pressureMb property.
		 *
		 */
		public short getPressureMb() {
			return pressureMb;
		}

		/**
		 * Sets the value of the pressureMb property.
		 *
		 */
		public void setPressureMb(short value) {
			this.pressureMb = value;
		}

		/**
		 * Gets the value of the pressureIn property.
		 *
		 */
		public float getPressureIn() {
			return pressureIn;
		}

		/**
		 * Sets the value of the pressureIn property.
		 *
		 */
		public void setPressureIn(float value) {
			this.pressureIn = value;
		}

		/**
		 * Gets the value of the pressureTrend property.
		 *
		 */
		public byte getPressureTrend() {
			return pressureTrend;
		}

		/**
		 * Sets the value of the pressureTrend property.
		 *
		 */
		public void setPressureTrend(byte value) {
			this.pressureTrend = value;
		}

		/**
		 * Gets the value of the dewpointString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getDewpointString() {
			return dewpointString;
		}

		/**
		 * Sets the value of the dewpointString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setDewpointString(String value) {
			this.dewpointString = value;
		}

		/**
		 * Gets the value of the dewpointF property.
		 *
		 */
		public byte getDewpointF() {
			return dewpointF;
		}

		/**
		 * Sets the value of the dewpointF property.
		 *
		 */
		public void setDewpointF(byte value) {
			this.dewpointF = value;
		}

		/**
		 * Gets the value of the dewpointC property.
		 *
		 */
		public byte getDewpointC() {
			return dewpointC;
		}

		/**
		 * Sets the value of the dewpointC property.
		 *
		 */
		public void setDewpointC(byte value) {
			this.dewpointC = value;
		}

		/**
		 * Gets the value of the heatIndexString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getHeatIndexString() {
			return heatIndexString;
		}

		/**
		 * Sets the value of the heatIndexString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setHeatIndexString(String value) {
			this.heatIndexString = value;
		}

		/**
		 * Gets the value of the heatIndexF property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getHeatIndexF() {
			return heatIndexF;
		}

		/**
		 * Sets the value of the heatIndexF property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setHeatIndexF(String value) {
			this.heatIndexF = value;
		}

		/**
		 * Gets the value of the heatIndexC property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getHeatIndexC() {
			return heatIndexC;
		}

		/**
		 * Sets the value of the heatIndexC property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setHeatIndexC(String value) {
			this.heatIndexC = value;
		}

		/**
		 * Gets the value of the windchillString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getWindchillString() {
			return windchillString;
		}

		/**
		 * Sets the value of the windchillString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setWindchillString(String value) {
			this.windchillString = value;
		}

		/**
		 * Gets the value of the windchillF property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getWindchillF() {
			return windchillF;
		}

		/**
		 * Sets the value of the windchillF property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setWindchillF(String value) {
			this.windchillF = value;
		}

		/**
		 * Gets the value of the windchillC property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getWindchillC() {
			return windchillC;
		}

		/**
		 * Sets the value of the windchillC property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setWindchillC(String value) {
			this.windchillC = value;
		}

		/**
		 * Gets the value of the feelslikeString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getFeelslikeString() {
			return feelslikeString;
		}

		/**
		 * Sets the value of the feelslikeString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setFeelslikeString(String value) {
			this.feelslikeString = value;
		}

		/**
		 * Gets the value of the feelslikeF property.
		 *
		 */
		public float getFeelslikeF() {
			return feelslikeF;
		}

		/**
		 * Sets the value of the feelslikeF property.
		 *
		 */
		public void setFeelslikeF(float value) {
			this.feelslikeF = value;
		}

		/**
		 * Gets the value of the feelslikeC property.
		 *
		 */
		public float getFeelslikeC() {
			return feelslikeC;
		}

		/**
		 * Sets the value of the feelslikeC property.
		 *
		 */
		public void setFeelslikeC(float value) {
			this.feelslikeC = value;
		}

		/**
		 * Gets the value of the visibilityMi property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getVisibilityMi() {
			return visibilityMi;
		}

		/**
		 * Sets the value of the visibilityMi property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setVisibilityMi(String value) {
			this.visibilityMi = value;
		}

		/**
		 * Gets the value of the visibilityKm property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getVisibilityKm() {
			return visibilityKm;
		}

		/**
		 * Sets the value of the visibilityKm property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setVisibilityKm(String value) {
			this.visibilityKm = value;
		}

		/**
		 * Gets the value of the solarradiation property.
		 *
		 */
		public short getSolarradiation() {
			return solarradiation;
		}

		/**
		 * Sets the value of the solarradiation property.
		 *
		 */
		public void setSolarradiation(short value) {
			this.solarradiation = value;
		}

		/**
		 * Gets the value of the uv property.
		 *
		 */
		public float getUV() {
			return uv;
		}

		/**
		 * Sets the value of the uv property.
		 *
		 */
		public void setUV(float value) {
			this.uv = value;
		}

		/**
		 * Gets the value of the precip1HrString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getPrecip1HrString() {
			return precip1HrString;
		}

		/**
		 * Sets the value of the precip1HrString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setPrecip1HrString(String value) {
			this.precip1HrString = value;
		}

		/**
		 * Gets the value of the precip1HrIn property.
		 *
		 */
		public float getPrecip1HrIn() {
			return precip1HrIn;
		}

		/**
		 * Sets the value of the precip1HrIn property.
		 *
		 */
		public void setPrecip1HrIn(float value) {
			this.precip1HrIn = value;
		}

		/**
		 * Gets the value of the precip1HrMetric property.
		 *
		 */
		public byte getPrecip1HrMetric() {
			return precip1HrMetric;
		}

		/**
		 * Sets the value of the precip1HrMetric property.
		 *
		 */
		public void setPrecip1HrMetric(byte value) {
			this.precip1HrMetric = value;
		}

		/**
		 * Gets the value of the precipTodayString property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getPrecipTodayString() {
			return precipTodayString;
		}

		/**
		 * Sets the value of the precipTodayString property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setPrecipTodayString(String value) {
			this.precipTodayString = value;
		}

		/**
		 * Gets the value of the precipTodayIn property.
		 *
		 */
		public float getPrecipTodayIn() {
			return precipTodayIn;
		}

		/**
		 * Sets the value of the precipTodayIn property.
		 *
		 */
		public void setPrecipTodayIn(float value) {
			this.precipTodayIn = value;
		}

		/**
		 * Gets the value of the precipTodayMetric property.
		 *
		 */
		public byte getPrecipTodayMetric() {
			return precipTodayMetric;
		}

		/**
		 * Sets the value of the precipTodayMetric property.
		 *
		 */
		public void setPrecipTodayMetric(byte value) {
			this.precipTodayMetric = value;
		}

		/**
		 * Gets the value of the icon property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getIcon() {
			return icon;
		}

		/**
		 * Sets the value of the icon property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setIcon(String value) {
			this.icon = value;
		}

		/**
		 * Gets the value of the iconUrl property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getIconUrl() {
			return iconUrl;
		}

		/**
		 * Sets the value of the iconUrl property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setIconUrl(String value) {
			this.iconUrl = value;
		}

		/**
		 * Gets the value of the forecastUrl property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getForecastUrl() {
			return forecastUrl;
		}

		/**
		 * Sets the value of the forecastUrl property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setForecastUrl(String value) {
			this.forecastUrl = value;
		}

		/**
		 * Gets the value of the historyUrl property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getHistoryUrl() {
			return historyUrl;
		}

		/**
		 * Sets the value of the historyUrl property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setHistoryUrl(String value) {
			this.historyUrl = value;
		}

		/**
		 * Gets the value of the obUrl property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getObUrl() {
			return obUrl;
		}

		/**
		 * Sets the value of the obUrl property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setObUrl(String value) {
			this.obUrl = value;
		}


		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = {
				"full",
				"city",
				"state",
				"stateName",
				"country",
				"countryIso3166",
				"zip",
				"magic",
				"wmo",
				"latitude",
				"longitude",
				"elevation"
		})
		public static class DisplayLocation {

			@XmlElement(required = true)
			protected String full;
			@XmlElement(required = true)
			protected String city;
			@XmlElement(required = true)
			protected String state;
			@XmlElement(name = "state_name", required = true)
			protected String stateName;
			@XmlElement(required = true)
			protected String country;
			@XmlElement(name = "country_iso3166", required = true)
			protected String countryIso3166;
			protected byte zip;
			protected short magic;
			protected short wmo;
			protected float latitude;
			protected float longitude;
			protected float elevation;

			/**
			 * Gets the value of the full property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getFull() {
				return full;
			}

			/**
			 * Sets the value of the full property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setFull(String value) {
				this.full = value;
			}

			/**
			 * Gets the value of the city property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getCity() {
				return city;
			}

			/**
			 * Sets the value of the city property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setCity(String value) {
				this.city = value;
			}

			/**
			 * Gets the value of the state property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getState() {
				return state;
			}

			/**
			 * Sets the value of the state property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setState(String value) {
				this.state = value;
			}

			/**
			 * Gets the value of the stateName property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getStateName() {
				return stateName;
			}

			/**
			 * Sets the value of the stateName property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setStateName(String value) {
				this.stateName = value;
			}

			/**
			 * Gets the value of the country property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getCountry() {
				return country;
			}

			/**
			 * Sets the value of the country property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setCountry(String value) {
				this.country = value;
			}

			/**
			 * Gets the value of the countryIso3166 property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getCountryIso3166() {
				return countryIso3166;
			}

			/**
			 * Sets the value of the countryIso3166 property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setCountryIso3166(String value) {
				this.countryIso3166 = value;
			}

			/**
			 * Gets the value of the zip property.
			 *
			 */
			public byte getZip() {
				return zip;
			}

			/**
			 * Sets the value of the zip property.
			 *
			 */
			public void setZip(byte value) {
				this.zip = value;
			}

			/**
			 * Gets the value of the magic property.
			 *
			 */
			public short getMagic() {
				return magic;
			}

			/**
			 * Sets the value of the magic property.
			 *
			 */
			public void setMagic(short value) {
				this.magic = value;
			}

			/**
			 * Gets the value of the wmo property.
			 *
			 */
			public short getWmo() {
				return wmo;
			}

			/**
			 * Sets the value of the wmo property.
			 *
			 */
			public void setWmo(short value) {
				this.wmo = value;
			}

			/**
			 * Gets the value of the latitude property.
			 *
			 */
			public float getLatitude() {
				return latitude;
			}

			/**
			 * Sets the value of the latitude property.
			 *
			 */
			public void setLatitude(float value) {
				this.latitude = value;
			}

			/**
			 * Gets the value of the longitude property.
			 *
			 */
			public float getLongitude() {
				return longitude;
			}

			/**
			 * Sets the value of the longitude property.
			 *
			 */
			public void setLongitude(float value) {
				this.longitude = value;
			}

			/**
			 * Gets the value of the elevation property.
			 *
			 */
			public float getElevation() {
				return elevation;
			}

			/**
			 * Sets the value of the elevation property.
			 *
			 */
			public void setElevation(float value) {
				this.elevation = value;
			}

		}



		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = {
				"url",
				"title",
				"link"
		})
		public static class Image {

			@XmlElement(required = true)
			@XmlSchemaType(name = "anyURI")
			protected String url;
			@XmlElement(required = true)
			protected String title;
			@XmlElement(required = true)
			@XmlSchemaType(name = "anyURI")
			protected String link;

			/**
			 * Gets the value of the url property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getUrl() {
				return url;
			}

			/**
			 * Sets the value of the url property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setUrl(String value) {
				this.url = value;
			}

			/**
			 * Gets the value of the title property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getTitle() {
				return title;
			}

			/**
			 * Sets the value of the title property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setTitle(String value) {
				this.title = value;
			}

			/**
			 * Gets the value of the link property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getLink() {
				return link;
			}

			/**
			 * Sets the value of the link property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setLink(String value) {
				this.link = value;
			}

		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = {
				"full",
				"city",
				"state",
				"country",
				"countryIso3166",
				"latitude",
				"longitude",
				"elevation"
		})
		public static class ObservationLocation {

			@XmlElement(required = true)
			protected String full;
			@XmlElement(required = true)
			protected String city;
			@XmlElement(required = true)
			protected String state;
			@XmlElement(required = true)
			protected String country;
			@XmlElement(name = "country_iso3166", required = true)
			protected String countryIso3166;
			protected float latitude;
			protected float longitude;
			@XmlElement(required = true)
			protected String elevation;

			/**
			 * Gets the value of the full property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getFull() {
				return full;
			}

			/**
			 * Sets the value of the full property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setFull(String value) {
				this.full = value;
			}

			/**
			 * Gets the value of the city property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getCity() {
				return city;
			}

			/**
			 * Sets the value of the city property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setCity(String value) {
				this.city = value;
			}

			/**
			 * Gets the value of the state property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getState() {
				return state;
			}

			/**
			 * Sets the value of the state property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setState(String value) {
				this.state = value;
			}

			/**
			 * Gets the value of the country property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getCountry() {
				return country;
			}

			/**
			 * Sets the value of the country property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setCountry(String value) {
				this.country = value;
			}

			/**
			 * Gets the value of the countryIso3166 property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getCountryIso3166() {
				return countryIso3166;
			}

			/**
			 * Sets the value of the countryIso3166 property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setCountryIso3166(String value) {
				this.countryIso3166 = value;
			}

			/**
			 * Gets the value of the latitude property.
			 *
			 */
			public float getLatitude() {
				return latitude;
			}

			/**
			 * Sets the value of the latitude property.
			 *
			 */
			public void setLatitude(float value) {
				this.latitude = value;
			}

			/**
			 * Gets the value of the longitude property.
			 *
			 */
			public float getLongitude() {
				return longitude;
			}

			/**
			 * Sets the value of the longitude property.
			 *
			 */
			public void setLongitude(float value) {
				this.longitude = value;
			}

			/**
			 * Gets the value of the elevation property.
			 *
			 * @return
			 *     possible object is
			 *     {@link String }
			 *
			 */
			public String getElevation() {
				return elevation;
			}

			/**
			 * Sets the value of the elevation property.
			 *
			 * @param value
			 *     allowed object is
			 *     {@link String }
			 *
			 */
			public void setElevation(String value) {
				this.elevation = value;
			}

		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"feature"
	})
	public static class Features {

		@XmlElement(required = true)
		protected String feature;

		/**
		 * Gets the value of the feature property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getFeature() {
			return feature;
		}

		/**
		 * Sets the value of the feature property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setFeature(String value) {
			this.feature = value;
		}

	}

}
