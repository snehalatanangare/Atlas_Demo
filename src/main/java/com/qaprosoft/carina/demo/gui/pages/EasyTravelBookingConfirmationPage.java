package com.qaprosoft.carina.demo.gui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class EasyTravelBookingConfirmationPage extends AbstractPage{
	
	
	 Logger LOGGER = Logger.getLogger(EasyTravelBookingConfirmationPage.class);
	 
	    @FindBy(xpath="//input[@id='iceform:creditCardNumber']")
	    private ExtendedWebElement cardno;
	    
	    @FindBy(xpath="//input[@id='iceform:creditCardOwner']")
	    private ExtendedWebElement cardowner;
	    
	    @FindBy(xpath="//select[@id='iceform:expirationMonth']/option[text()='January']")
	    private ExtendedWebElement expmonth;
	    
	    @FindBy(xpath="//select[@id='iceform:expirationYear']/option[text()='2023']")
	    private ExtendedWebElement expyear;
	    
	    @FindBy(xpath="//input[@id='iceform:verificationNumber']")
	    private ExtendedWebElement verificationnum;
	    
	    @FindBy(xpath="//input[@id='iceform:bookPaymentNext']")
	    private ExtendedWebElement paymentnxtbtn;
	    
	    
	    @FindBy(xpath="//*[@id='iceform:j_idt77']")
	    private ExtendedWebElement text;
	    
	    @FindBy(xpath="//input[@id='iceform:bookFinishFinish']")
	    private  ExtendedWebElement finishbtn;
	    

    public EasyTravelBookingConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public void hotelPayment(String cardnum,String ownername,String num) {
		cardno.type(cardnum);
		cardowner.type(ownername);
		expmonth.click();
		expyear.click();
		verificationnum.type(num);
		paymentnxtbtn.click();
		text.getText();
	}
	
	public void clickFinish() {
		finishbtn.click();
	}
}
