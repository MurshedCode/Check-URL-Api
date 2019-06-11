package com.murshedcode;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

	
	
	// checking return array from Get request
	@Test
	void testValidUrlStatus() {
		
		String url = "https://paypal.com";
		long[] stautsArray = UrlHttpRequestUnderTest.getStatus(url);	
		assertEquals(HttpURLConnection.HTTP_OK, stautsArray[0]);
		
	}

	
	@Test
	void testInValidUrlStatus() {
		
		String url = "http://not.exists.bbc.co.uk";
		long[] stautsArray = UrlHttpRequestUnderTest.getStatus(url);	
		assertEquals(HttpURLConnection.HTTP_UNSUPPORTED_TYPE, stautsArray[0]);
		
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
	        System.err.println("Error creating HTTP connection");
	        e.printStackTrace();
	        throw e;
	    }
	}
	
	
	
	
	
	
}
