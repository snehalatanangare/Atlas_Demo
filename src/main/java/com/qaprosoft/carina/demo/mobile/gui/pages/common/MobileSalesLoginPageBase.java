package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class MobileSalesLoginPageBase extends AbstractPage {

	public MobileSalesLoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void login(String _username, String _password);
	
	public abstract void homePage();
	
	//public abstract void leadList();
	
	public abstract void logout();

}
