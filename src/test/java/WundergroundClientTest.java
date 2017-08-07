/**
 * Created by KR.
 */

import com.tieto.wro.java.a17.wunderground.client.WundergroundClient;
import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static net.jadler.Jadler.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class WundergroundClientTest {

	private static final String SINGLE_RESPONSE_CITY = "warszawa";
	private static final String MUTLIPLE_RESPONSE_CITY = "krakow";
	private static final String ERROR_RESPONSE_CTY = "xdxdasdas";
	private static final String COUNTRY = "poland";
	private WundergroundClient wc;

	private String convertXMLFileToString(String fileName) throws FileNotFoundException {
		return new Scanner(new File(fileName).getAbsoluteFile()).useDelimiter("\\Z").next();
	}
	@Before
	public void setUp() throws FileNotFoundException, MalformedURLException {
		initJadler();
		String contentOfXMLSingleResponse = convertXMLFileToString("src/test/java/resource/WarszawaResponse.xml");
		String URLToSingleResponse = "/q/poland/warszawa.xml";
		onRequest()
				.havingMethodEqualTo("GET")
				.havingPathEqualTo(URLToSingleResponse)
				.respond()
				.withBody(contentOfXMLSingleResponse)
				.withContentType("application/XML")
				.withStatus(200);

		String URLToSingleResponseById = "/q/zmw:00000.1041.12435.xml";
		onRequest()
				.havingMethodEqualTo("GET")
				.havingPathEqualTo(URLToSingleResponseById)
				.respond()
				.withBody(contentOfXMLSingleResponse)
				.withContentType("application/XML")
				.withStatus(200);

		String contentOfXMLErrorResponse = convertXMLFileToString("src/test/java/resource/ErrorResponse.xml");
		String URLToErrorResponse = "/q/poland/xdxdasdas.xml";
		onRequest()
				.havingMethodEqualTo("GET")
				.havingPathEqualTo(URLToErrorResponse)
				.respond()
				.withBody(contentOfXMLErrorResponse)
				.withContentType("application/XML")
				.withStatus(200);

		String contentOfXMLMultipleResponse = convertXMLFileToString("src/test/java/resource/KrakowResponse.xml");
		String URLToMultipleResponse = "/q/poland/krakow.xml";
		onRequest()
				.havingMethodEqualTo("GET")
				.havingPathEqualTo(URLToMultipleResponse)
				.respond()
				.withBody(contentOfXMLMultipleResponse)
				.withContentType("application/XML")
				.withStatus(200);



		wc = new WundergroundClient(new URL("http://localhost:" + port() +"/"));
	}
	@After
	public void tearDown() {
		closeJadler();
	}

	@Test
	public void check_if_there_is_single_response() throws FileNotFoundException, MalformedURLException {
		IResponse singleIResponse = wc.getWeather(COUNTRY, SINGLE_RESPONSE_CITY);
		Assert.assertNotNull(singleIResponse);
		Assert.assertThat(singleIResponse, instanceOf(SingleResponse.class));
	}

	@Test
	public void check_if_there_is_error_response() throws FileNotFoundException, MalformedURLException {
		IResponse errorIResponse = wc.getWeather(COUNTRY, ERROR_RESPONSE_CTY);
		Assert.assertNotNull(errorIResponse);
		Assert.assertThat(errorIResponse, instanceOf(ErrorResponse.class));
	}

	@Test
	public void check_if_there_is_multiple_response() throws MalformedURLException, FileNotFoundException {
		IResponse multipleIResponse = wc.getWeather(COUNTRY, MUTLIPLE_RESPONSE_CITY);
		Assert.assertNotNull(multipleIResponse);
		Assert.assertThat(multipleIResponse, instanceOf(MultipleResponse.class));
	}

	@Test
	public void check_if_there_is_error_response_getByID() throws FileNotFoundException, MalformedURLException {
		IResponse singleResponse = wc.getWeather("q/zmw:00000.1041.12435.xml");
		Assert.assertNotNull(singleResponse);
		Assert.assertThat(singleResponse, instanceOf(SingleResponse.class));
	}

}
