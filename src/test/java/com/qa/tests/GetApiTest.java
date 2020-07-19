package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase{
	
	TestBase testBase;
	String url;
	String apiUrl;
	String uri;
	RestClient restClint;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		url = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURl");
		
		uri = url + apiUrl;
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		restClint = new RestClient();
		restClint.get(uri);
	}
	
	

}
