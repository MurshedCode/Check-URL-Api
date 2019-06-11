package com.murshedcode;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;

/**
 *  This is helper class with utility methods implementation to fetch url header response data 
 * - Create an array elements with response 
 * - create Json object for each URL. 
 * 
 * @author Murshed
 */



public class UrlHttpRequest {
	
	int responsecode = 0 ;
	int contentlength  = 0;
	long date = 0;

	
	public static long[] getStatus(String url) {
		
		long[] stautsArray = new long[4];

		try {

			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000); // timeout after 10 seconds
			connection.connect();


			stautsArray[0] = connection.getResponseCode();
			BufferedInputStream bif = new BufferedInputStream(connection.getInputStream());
			stautsArray[1] = bif.available();
			stautsArray[2] =  connection.getDate();

		} catch (MalformedURLException e) {
		}
		catch (Exception e) {
			System.out.println(url + "\t\t Erorr: invalid url... " + e.getMessage()); 
		}
		return stautsArray;
	}
	
	
	static JSONObject getJsonObject(String url) throws Exception{
		JSONObject responseObject = null;
		long[] urLStatus = getStatus(url);
		// Create Json Object and print in console

		responseObject = new JSONObject();
		responseObject.put("URL", url);
		responseObject.put("Status_code", urLStatus[0]);
		responseObject.put("Date", new Date (urLStatus[1]));
		responseObject.put("Content_length", urLStatus[2]);


		// Can check response type and print response as Json Object

		System.out.println(responseObject);

		return responseObject;  // to check and implement unit test on return object

	}
}
