package com.qaprosoft.carina.demo.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.api.PostUserCreationMethod;
import com.qaprosoft.carina.demo.api.PostUserMethod;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracHomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracLoginPageBase;
import com.qaprosoft.carina.demo.utils.M1CloudActivities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateUserAPIStepdef extends CucumberRunner {

	PostUserCreationMethod user = null;
	Response rs = null;

	@Given("^Post endpoint given$")
	public void startMethod() throws Exception {
		user = new PostUserCreationMethod();
	}

	@When("^Enter Username and Job$")
	public void enterdetails() {
		user.addParameter("name", "sample");
		user.addParameter("job", "test");
	}

	@Then("^Post the api$")
	public void postAPI() {
		rs = user.callAPI();
	}

	@And("^Get response$")
	public void getResponseTime() {
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);
	}

}
