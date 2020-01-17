package com.qaprosoft.carina.demo.gui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class EasyTravelHomePage extends AbstractPage{
	
	
	 Logger LOGGER = Logger.getLogger(EasyTravelHomePage.class);
	 
	  
	    @FindBy(xpath="//a[@class='iceCmdLnk button']")
	    private ExtendedWebElement loginIcon;
	    
	    @FindBy(xpath="//input[@id='loginForm:username']")
	    private ExtendedWebElement username;
	    
	    @FindBy(xpath="//input[@id='loginForm:password']")
	    private ExtendedWebElement password;
	    
	    @FindBy(xpath="//input[@class='iceCmdBtn commonButton orangeButton4 orangeLoginButton orangeLoginSubmit']")
	    private ExtendedWebElement loginbtn;
	    
    public EasyTravelHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickonLogin() {
		loginIcon.click();
	}
	 
	public void login(String uname,String pwd) {
		username.type(uname);
		password.type(pwd);
		loginbtn.click();
	}
	
}
