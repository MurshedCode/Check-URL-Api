package com.murshedcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UrlHttpRequestTest {

	private UrlHttpRequest UrlHttpRequestUnderTest = null;

	@BeforeEach
	void setUp() throws Exception {
		UrlHttpRequestUnderTest = new UrlHttpRequest();
	}


	@Test
	void testURL() throws Exception {
		String strUrl = "https://google.com";

		try {
			URL url = new URL(strUrl);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.connect();

			assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}


	// checking return array from Get request

	@Test
	void testGetContentOk() throws Exception {
		String url = "https://paypal.com";
		long[] stautsArray = UrlHttpRequestUnderTest.getStatus(url);	
		assertEquals("Valid url should return 200 for array elemnt", HttpURLConnection.HTTP_OK, stautsArray[0]);
	}



	@Test
	void testDoesNotGetContentOk() throws Exception {
		String url = "http:// not.exists.bbc.co.uk";
		long[] stautsArray = UrlHttpRequestUnderTest.getStatus(url);	
		assertEquals("Invalid URL should return 0 for array element", 0, stautsArray[0]);
	}


	/**
	 * A JSONObject can be created with no content
	 */
	@Test
	public void emptyJsonObject() {
		JSONObject jsonObject = new JSONObject();
		assertTrue("jsonObject should be empty", jsonObject.isNull("url"));
	}



	@Test 
	void testNullJsonObject() {
		JSONObject actualResponseObject = null;
		try {
			actualResponseObject = 	UrlHttpRequestUnderTest.getJsonObject("https://paypal.com");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(actualResponseObject.isNull("Content_length")){  //returns true only if json is not null
			boolean result = false;
			assertEquals("For valid url content length can not be null", false, result);
		}
	}



	@Test 
	void testNullJsonObjectDate() {
		JSONObject actualResponseObject = null;
		try {
			actualResponseObject = 	UrlHttpRequestUnderTest.getJsonObject("http://www.bbc.co.uk/iplayer");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(actualResponseObject.isNull("Date")){  //returns true only if json is not null
			boolean result = false;
			assertEquals("For valid url Date can not be null", false, result);
		}
	}



	@Test 
	void testNullJsonObjectStatusCode() {
		JSONObject actualResponseObject = null;
		try {
			actualResponseObject = 	UrlHttpRequestUnderTest.getJsonObject("http://www.bbc.co.uk/iplayer");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(actualResponseObject.isNull("Status_code")){  //returns true only if json is not null
			boolean result = false;
			assertEquals("For valid url Status_code can not be null", false, result);
		}
	}



	@Test
	public void verifyJsonObjectSimilar() {
		JSONObject JsonObj1 = null;
		JSONObject JsonObj2 = null;
		try {
			JsonObj1 = UrlHttpRequestUnderTest.getJsonObject("https://paypal.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			JsonObj2 = UrlHttpRequestUnderTest.getJsonObject("http://www.bbc.co.uk/iplayer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (JsonObj1.equals(JsonObj2)) {
			boolean result = false;
			assertEquals("For valid url two JsonObjetc can not be similar...", false, result);
		}


	}




	@Test
	void testJsonObject()throws Exception {

		String url = "https://paypal.com";

		JSONObject actualResponseObject = null;
		long[] urLStatus = UrlHttpRequestUnderTest.getStatus(url);
		// Create Json Object and print in console

		actualResponseObject = new JSONObject();
		actualResponseObject.put("URL", url);
		actualResponseObject.put("Status_code", urLStatus[0]);
		actualResponseObject.put("Date", new Date (urLStatus[1]));
		actualResponseObject.put("Content_length", urLStatus[2]);


		//String url1 = (String) 


		// @Test Catch Exception invalid URL

		// @ Test connection timeout 



	}




}
