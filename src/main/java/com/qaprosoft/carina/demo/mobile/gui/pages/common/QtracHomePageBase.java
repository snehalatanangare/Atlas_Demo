package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public  abstract class QtracHomePageBase extends AbstractPage{

	public QtracHomePageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void clickSpeedometerDashbord();

	public abstract void clickPageBucketDashborad();



}
