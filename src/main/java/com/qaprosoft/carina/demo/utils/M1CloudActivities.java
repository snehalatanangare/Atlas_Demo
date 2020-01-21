package com.qaprosoft.carina.demo.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qk.m1cloud.api.POSTUploadAPKMethod;


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
		String propName = null;

		if(jenkinsJobEnvironment.equals("DEV")){
			propName = "Samsung_Galaxy_J7_Prime.properties";
		}
		else if(jenkinsJobEnvironment.equals("QA")){
			propName = "Samsung_Galaxy_J7_Prime.properties";
		}
		else{
			propName = "Oneplus_7_Android_9.properties";
		}
		return propName;
	}

	public void Upload_apk() throws Exception {
		getToken();
		
		POSTUploadAPKMethod uploadAPK = new POSTUploadAPKMethod();
		
		uploadAPK.setHeaders("Content-Type=multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
		uploadAPK.addParameter("token", token);
		uploadAPK.addParameter("filter", "all");
		uploadAPK.addParameter("source_type", "raw");
		
		Response ResUploadAPK = uploadAPK.callAPI();
		LOGGER.info(ResUploadAPK.getStatusCode());
		LOGGER.info(ResUploadAPK.asString());
	}
	
	public DesiredCapabilities setCapabilities(String DeviceName) throws Exception{
    	if(R.CONFIG.getProperties().getProperty("uploadAPK").equals("true")){
			Upload_apk();
		}
    	LOGGER.info("DeviceName: "+DeviceName);
		Properties prop = new Properties();
			String propFile = DeviceName;
		String path = "src/main/resources/m1Cloud/android/"+propFile;
		
		InputStream input = new FileInputStream(path);
		prop.load(input);
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username",prop.getProperty("Capability_Username"));
		capabilities.setCapability("Capability_ApiKey",prop.getProperty("Capability_ApiKey"));
		capabilities.setCapability("Capability_ApplicationName", prop.getProperty("Capability_ApplicationName"));
		capabilities.setCapability("Capability_DurationInMinutes", prop.getProperty("Capability_DurationInMinutes"));
		capabilities.setCapability("Capability_DeviceFullName",prop.getProperty("Capability_DeviceFullName"));
		capabilities.setCapability("deviceType",prop.getProperty("deviceType"));
		capabilities.setCapability("platformName",prop.getProperty("platformName"));
		capabilities.setCapability("automationName",prop.getProperty("automationName"));
		capabilities.setCapability("appActivity",prop.getProperty("appActivity"));
		capabilities.setCapability("appPackage",prop.getProperty("appPackage"));
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noSign", true);
		R.CONFIG.getProperties().setProperty("deviceName", prop.getProperty("Capability_DeviceFullName"));
		
		return capabilities;
	
    }
}
