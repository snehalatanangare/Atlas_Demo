package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public  abstract class QtracLoginPageBase extends AbstractPage{

	public QtracLoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void login(String name, String password);

	public abstract void clickonSignin();

	public abstract void clickonLoginBtn();



}
