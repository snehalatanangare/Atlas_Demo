package com.qaprosoft.carina.demo.utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import com.qaprosoft.carina.core.foundation.utils.R;


public class M1CloudActivities {
	
	Logger LOGGER = Logger.getLogger(M1CloudActivities.class);
	public String token;
	Properties prop = new Properties();
	
	public String getToken() throws Exception{
		RestAssured.baseURI = "https://qkm1.qualitykiosk.com/api";
		RequestSpecification httpRequest = RestAssured.given();
		String userName = R.CONFIG.getProperties().getProperty("userName");
		String password = R.CONFIG.getProperties().getProperty("password");
		httpRequest.authentication().basic(userName, password);
	    httpRequest.header("Authorization", "Basic cWttMS5zdXBwb3J0QHF1YWxpdHlraW9zay5jb206M2dtNnp0NXdicndyajgyYnB3ODRkNjh3");
	    									
	    
	    Response response = httpRequest.get("/access");
	    ResponseBody body = response.getBody();
	    String bodyStringValue = body.asString();
	    JSONObject jobj = new JSONObject(response.asString());
	    JSONObject robj = jobj.getJSONObject("result");
	    token = robj.getString("token");
	    return token;
	}
	
	public void checkDeviceAvailability(String PlatformName, String DeviceName) throws Exception{
		String devices;
		RestAssured.baseURI = "https://qkm1.qualitykiosk.com/api";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("token", token); 
		requestParams.put("duration", 10);
		requestParams.put("platform", PlatformName);
		requestParams.put("available_now", "true");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toString());
		
	    Response response = httpRequest.post("/devices");
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    devices = jsonPathEvaluator.get("models");
	    
	    if(!devices.contains("DeviceName"))
	    	{
	    		LOGGER.info("Device not available");
	    	}
	    else{
	    	
	    }
	   	}
	
	public String propertiesFile(String jenkinsJobEnvironment){
		//System.out.println(System.getProperty("stageName"));
		String propName = null;

		if(jenkinsJobEnvironment.equals("DEV")){
//			propName = "Samsung_Galaxy_J5_Prime.properties";
//			propName = "Oneplus_7_Android_9e.properties";
			propName = "Samsung_Galaxy_J7_Prime.properties";
		}
		else if(jenkinsJobEnvironment.equals("QA")){
//			propName = "Oneplus_7_Android_9.properties";
			propName = "Samsung_Galaxy_J7_Prime.properties";
		}
		else{
		//	propName = "Oneplus_7_Android_9.properties";
//			propName = "Oneplus_7_Android_9.properties";
			propName = "Oneplus_7_Android_9.properties";
		}
		return propName;
	}

	
}
