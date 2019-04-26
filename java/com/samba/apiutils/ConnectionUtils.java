package com.samba.apiutils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class ConnectionUtils {

	final static Logger logger = Logger.getLogger(ConnectionUtils.class);

	public static JSONObject callAPI(String url) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		JSONObject jsonResponse = null;
		try {
			HttpGet getRequest = new HttpGet(url);
			HttpResponse response = httpClient.execute(getRequest);
			jsonResponse = new JSONObject(EntityUtils.toString(response.getEntity()));
		} catch (Exception ex) {
			logger.error("Issue hitting the API " + ex.getMessage());
		}

		return jsonResponse;
	}

}
