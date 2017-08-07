package com.tieto.wro.java.a17.wunderground.weather;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class CitiesFileReader {

	public HashMap<String, String> getMapOfLocations(String url) throws IOException {
		FileInputStream readContentOfFile = new FileInputStream(url);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(readContentOfFile, new TypeReference<HashMap<String, String>>() { });
	}
}
