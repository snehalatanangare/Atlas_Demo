package com.qaprosoft.carina.demo.cucumber.steps;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracHomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracLoginPageBase;
import com.qaprosoft.carina.demo.utils.M1CloudActivities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetUserAPIStepdef extends CucumberRunner {

	QtracLoginPageBase Login = null;
	QtracHomePageBase Home = null;

	@Given("^Get endpoint given$")
	public void LoginPage() throws Exception {
		System.out.println("Appliction launched");
		M1CloudActivities mobile = new M1CloudActivities();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = mobile.setCapabilities("Samsung_Galaxy_J4_Plus.properties");
		//getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host"));
		Login = initPage(getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host")), QtracLoginPageBase.class);
	}

	@When("^Get api$")
	public void enterdetails() {
		System.out.println("test start");
		Login.clickonSignin();
		Login.login("testqk", "Quality@123");
	}

	@Then("^Get User response$")
	public void ClickOnLoginBtn() {
		Login.clickonLoginBtn();
	}

}
