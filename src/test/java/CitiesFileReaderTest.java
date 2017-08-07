import com.tieto.wro.java.a17.wunderground.weather.CitiesFileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class CitiesFileReaderTest {

	private HashMap<String, String> locations;

	@Before
	public void setUp() throws IOException {
		System.setProperty("citiesFile", "src/test/java/resource/cities.json");
		CitiesFileReader citiesFileReader = new CitiesFileReader();
		locations = citiesFileReader.getMapOfLocations(System.getProperty("citiesFile"));
	}
	@Test
	public void read_and_transform_chciago_link() {
		Assert.assertEquals(locations.get("chicago"), "q/zmw:60601.1.99999.xml");
	}
	@Test
	public void read_and_transform_magdeburg_link() {
		Assert.assertEquals(locations.get("magdeburg"), "q/zmw:00000.192.10361.xml");
	}
	@Test
	public void read_and_transform_barcelona_link() {
		Assert.assertEquals(locations.get("barcelona"), "q/zmw:00000.17.08181.xml");
	}
	@Test
	public void read_and_transform_quebec_link() {
		Assert.assertEquals(locations.get("quebec"), "q/zmw:00000.5.71578.xml");
	}
	@Test
	public void read_and_transform_gdansk_link() {
		Assert.assertEquals(locations.get("gdansk"), "q/zmw:00000.141.12140.xml");
	}
	@Test
	public void read_and_transform_warszawa_link() {
		Assert.assertEquals(locations.get("warszawa"),"q/zmw:00000.123.12372.xml");
	}
}
