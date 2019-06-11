package com.murshedcode;

import java.net.MalformedURLException;
import java.util.Scanner;


/**
 * This is main class where user input will be taken as specific format and invoke utility methods from helper class 
 ** and display result as Json format.
 * 
 * @author Murshed
 */



public class UrlContentCheckApp {

	
	public static void main(String[] args) {
		System.out.println("=============The app will take url address as input and test the header response============== "
				+ " \n =================@MurshedCode========================	 ");

		String url ="";
		try {
			System.out.println("\n Enter the urls as Tab delimeter seperated ...........");
			Scanner sc = new Scanner (System.in);
			String inputStirngUrl = sc.nextLine();


			//  taking user input splitting as series of url as array of String

			String delimeter ="\t";				
			String[] splitUrl = inputStirngUrl.split(delimeter);
			System.out.println(" \n The programm will test following list of URL \n ");
			for (int i =0; i< splitUrl.length; i++) {
				url = splitUrl[i];
				System.out.println((i+1) +" "+  url);
				sc.close();
			} 


			// invoking method on listed url
			System.out.println("\n Response header data extraction initialised...\n");
			for (int i =0; i<splitUrl.length; i++) {
				url = splitUrl[i];
				UrlHttpRequest.getJsonObject(url);
			}
		}  catch (MalformedURLException e) {
			System.out.println(" Entre valid url .....Check the input requirement as states instruction on sample input file ...... ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n Process completed......\n");
	}

	
	public void throwAnException() throws Exception {
		try {
			String url = "";
			UrlHttpRequest.getJsonObject(url);
		} catch(Exception e) {
			throw new NullPointerException();
		}
	}

}

