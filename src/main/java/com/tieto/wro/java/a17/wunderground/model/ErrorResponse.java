package com.tieto.wro.java.a17.wunderground.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="termsofService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="features">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="feature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="error">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"version",
		"termsofService",
		"features",
		"error"
})
@XmlRootElement(name = "response")
public class ErrorResponse implements IResponse {

	protected float version;
	@XmlElement(required = true)
	protected String termsofService;
	@XmlElement(required = true)
	protected com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Features features;
	@XmlElement(required = true)
	protected com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Error error;

	/**
	 * Gets the value of the version property.
	 *
	 */
	public float getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 *
	 */
	public void setVersion(float value) {
		this.version = value;
	}

	/**
	 * Gets the value of the termsofService property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getTermsofService() {
		return termsofService;
	}

	/**
	 * Sets the value of the termsofService property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setTermsofService(String value) {
		this.termsofService = value;
	}

	/**
	 * Gets the value of the features property.
	 *
	 * @return
	 *     possible object is
	 *     {@link com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Features }
	 *
	 */
	public com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Features getFeatures() {
		return features;
	}

	/**
	 * Sets the value of the features property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Features }
	 *
	 */
	public void setFeatures(com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Features value) {
		this.features = value;
	}

	/**
	 * Gets the value of the error property.
	 *
	 * @return
	 *     possible object is
	 *     {@link com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Error }
	 *
	 */
	public com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Error getError() {
		return error;
	}

	/**
	 * Sets the value of the error property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Error }
	 *
	 */
	public void setError(com.tieto.wro.java.a17.wunderground.model.ErrorResponse.Error value) {
		this.error = value;
	}


	/**
	 * <p>Java class for anonymous complex type.
	 *
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 *
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 *
	 *
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"type",
			"description"
	})
	public static class Error {

		@XmlElement(required = true)
		String type;
		@XmlElement(required = true)
		String description;

		/**
		 * Gets the value of the type property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getType() {
			return type;
		}

		/**
		 * Sets the value of the type property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setType(String value) {
			this.type = value;
		}

		/**
		 * Gets the value of the description property.
		 *
		 * @return
		 *     possible object is
		 *     {@link String }
		 *
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the value of the description property.
		 *
		 * @param value
		 *     allowed object is
		 *     {@link String }
		 *
		 */
		public void setDescription(String value) {
			this.description = value;
		}

	}


	/**
	 * <p>Java class for anonymous complex type.
	 *
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 *
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="feature" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 *
	 *
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"feature"
	})
	public static class Features {

		@XmlElement(required = true)
		String feature;

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
