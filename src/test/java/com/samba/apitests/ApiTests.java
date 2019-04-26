
/*
 * We will be leveraging NASA open API for the API test below.
• API that you will be testing: https://api.nasa.gov/planetary/apod
• Example of the actual good case use of the
api: https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY (i.e. note that api_key query
parameters is required for a successful call)
• Please get the necessary API key for the test using https://api.nasa.gov/index.html#apply-for-an-
api-key
   
Tests to be performed:
 1. Ensure that the API requires query parameter API_KEY
 2. Ensure a 200 request status returns following fields in response "date", "copyright"
 3.Ensure response parameters url and hdurl DO NOT contain the same value
 Author -pdatrak
 */
package com.samba.apitests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.samba.apiutils.ConnectionUtils;
import com.samba.apiutils.Constants;
import com.samba.apiutils.Utils;

public class ApiTests {

	@Test
	public void testPositive() 
	{
		String apiURL = Utils.getApplicationURL();
		
		JSONObject response = ConnectionUtils.callAPI(apiURL);
		
		Assert.assertNotNull(response.get("date"), "Date should not be null");
		
		//Assert.assertNotNull(response.get("copyright"), "Copyright should not be null");
		
		Assert.assertNotEquals(response.get("url"),response.get("hdurl"), "Both URL and HDURL should be same");
	}
	
	
	@Test
	public void testInvalidKey() 
	{
		String apiURL = Utils.getApplicationURL(Constants.INVALID_KEY);
		
		JSONObject response = ConnectionUtils.callAPI(apiURL);
		
		JSONObject errorResponse = response.getJSONObject("error");
		
		String code = errorResponse.getString("code");
		
		String message = errorResponse.getString("message");
		
		Assert.assertEquals(code,Constants.ERR_CODE_INVALIDKEY);
		
		Assert.assertEquals(message, Constants.ERR_MSG_INVALIDKEY);

	}

	@Test
	public void testNoKey() 
	{
		String apiURL = Utils.getAppURLWithoutKey();
		
		JSONObject response = ConnectionUtils.callAPI(apiURL);
		
		JSONObject errorResponse = response.getJSONObject("error");
		
		String code = errorResponse.getString("code");
		
		String message = errorResponse.getString("message");
		
		Assert.assertEquals(code, Constants.ERR_CODE_MISSINGKEY);
		
		Assert.assertEquals(message, Constants.ERR_MSG_MISSINGKEY);
		
		System.out.println("Verified all Api tests");
	}
	
}
