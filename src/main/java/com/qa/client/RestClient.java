package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	//1. Get Method
		public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);		//http get request
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);			//hit the get url
		
		// 1.Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code = "+statusCode);
		
		// 2.JSON String
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("JSON response from responseString"+ responseJson);
		
		// 3.All Headers
		Header[] headersArray = httpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header : headersArray ) {
			allHeaders.put(header.getName(), header.getValue() );
		}
		System.out.println("Headers Array : "+allHeaders);
		
			
		}

}
		
		
