package com.qaprosoft.carina.demo.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.demo.gui.pages.EasyTravelBookingConfirmationPage;
import com.qaprosoft.carina.demo.gui.pages.EasyTravelBookingPage;
import com.qaprosoft.carina.demo.gui.pages.EasyTravelHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class EasyTravelStepdef extends CucumberRunner{
	 
	EasyTravelHomePage easyTravelHomePage=null;
	EasyTravelBookingPage easyTravelBookingPage=null;
	EasyTravelBookingConfirmationPage easyTravelConfirmationPage=null;
	
	
	@Given("^Open the browser$")
	public boolean homepage(){
		easyTravelHomePage = new EasyTravelHomePage(getDriver());
		easyTravelHomePage.open();
	        return easyTravelHomePage.isPageOpened();
	}

	
	@Then("^click on loginicon$")
	public void clickonLOgin() {
		easyTravelHomePage.clickonLogin();
	}

	
	@Then("^Enter Username and Password and click on login button$")
	public void enter_Username_and_Password_and_click_on_login_buttton()  {
		easyTravelHomePage.login("john@doe.com", "quark@123");
	}

	
	@Then("^Fill the journey details and click on search button$")
	public void fill_the_journey_details_and_click_on_serach_buttton()  {
		easyTravelBookingPage = new EasyTravelBookingPage(getDriver());
		easyTravelBookingPage.enterJourneydetails("Dubai");
	}

	@And("^click on booknow$")
	public void click_on_booknow() {
		easyTravelBookingPage.booknow();
	}

	
	@And("^click on next button for hotel confirmation$")
	public void click_on_next_button()  {
		easyTravelBookingPage.hotelConfirmation();
	}

	
	@And("^Enter the card details and click on next button$")
	public void enter_the_card_details_and_click_on_next_button() {
		easyTravelConfirmationPage = new EasyTravelBookingConfirmationPage(getDriver());
		easyTravelConfirmationPage.hotelPayment("1234567890", "joe", "123");
	}

	
	@Then("^click on finish button$")
	public void click_on_finish_button()  {
		easyTravelConfirmationPage.clickFinish();
	}

	
}
