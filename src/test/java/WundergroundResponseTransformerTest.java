import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import com.tieto.wro.java.a17.wunderground.weather.CityWeather;
import com.tieto.wro.java.a17.wunderground.weather.WundergroundResponseTransformer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import static net.jadler.Jadler.*;

/**
 * Created by KR.
 */
public class WundergroundResponseTransformerTest {

	private static final String SINGLE_RESPONSE_CITY = "warszawa";
	private static final String MULTIPLE_RESPONSE_CITY = "krakow";
	private static final String ERROR_RESPONSE_CTY = "xdxdasdas";
	private static final String COUNTRY = "poland";
	private WundergroundClient wc;
	private WundergroundResponseTransformer wrt;
	private CityWeather cw;

	private SingleResponse singleResponse;

	private String convertXMLFileToString(String fileName) throws FileNotFoundException {
		return new Scanner(new File(fileName).getAbsoluteFile()).useDelimiter("\\Z").next();
	}

	@Before
	public void setUp() throws Exception {
		initJadler();
		String contentOfXML = convertXMLFileToString("src/test/java/resource/WarszawaResponse.xml");
		String URLToSingleResponse = "/q/poland/warszawa.xml";
		wc = new WundergroundClient(new URL("http://localhost:" + port() + "/"));
		wrt = new WundergroundResponseTransformer();
		onRequest()
				.havingMethodEqualTo("GET")
				.havingPathEqualTo(URLToSingleResponse)
				.respond()
				.withBody(contentOfXML)
				.withContentType("application/XML")
				.withStatus(200);
		IResponse iResponse = wc.getWeather(COUNTRY, SINGLE_RESPONSE_CITY);
		singleResponse = (SingleResponse) iResponse;
		cw = wrt.transform(singleResponse);
	}

	@After
	public void tearDown() {
		closeJadler();
	}

	@Test
	public void check_if_floating_point_temperature_is_the_same() throws Exception {
		Assert.assertNotNull(cw);
		Assert.assertEquals(cw.getTemperatureCelsius(), singleResponse.getCurrentObservation().getTempC(), 0.1);
	}

	@Test
	public void check_if_string_description_is_the_same() throws Exception {
		Assert.assertNotNull(cw);
		Assert.assertEquals(cw.getWeather(), singleResponse.getCurrentObservation().getWeather());
	}

	@Test
	public void check_if_string_location_is_the_same() throws Exception {
		Assert.assertNotNull(cw);
		Assert.assertEquals(cw.getLocation(), singleResponse.getCurrentObservation().getDisplayLocation().getFull());
	}

	@Test(expected = RuntimeException.class)
	public void check_if_exception_is_thrown_with_error_response() throws Exception {
		IResponse response = wc.getWeather(COUNTRY, ERROR_RESPONSE_CTY);
		ErrorResponse errorResponse = (ErrorResponse) response;
		CityWeather cw = wrt.transform(errorResponse);
		Assert.assertNull(cw);
	}

	@Test(expected = RuntimeException.class)
	public void check_if_exception_is_thrown_with_multiple_response() throws Exception {
		IResponse response = wc.getWeather(COUNTRY, MULTIPLE_RESPONSE_CITY);
		MultipleResponse multipleResponse = (MultipleResponse) response;
		CityWeather cw = wrt.transform(multipleResponse);
		Assert.assertNull(cw);
	}
}
