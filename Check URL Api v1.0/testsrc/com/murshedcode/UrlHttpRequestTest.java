package com.murshedcode;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

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
	
	
	// @Test Catch Exception invalid URL
	
	
	// @ Test connection timeout 
	
	@Test
	void testJsonObject()throws Exception {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
