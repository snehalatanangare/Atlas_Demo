package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracHomePageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = QtracHomePageBase.class)
public class QtracHomePage extends QtracHomePageBase{
	
	@FindBy(xpath="//*[@text='menu']")
	private ExtendedWebElement menubtn;
	
	@FindBy(xpath="//*[@text='speedometer Error Dashboard']")
	private ExtendedWebElement speedometer;

	@FindBy(xpath="//*[contains(@text,'speedometer Page Bucket Dashboard')]")
	private ExtendedWebElement pagebucket;
	
	public QtracHomePage(WebDriver driver) {
		super(driver);
	}
	

	@Override
	public void clickSpeedometerDashbord() {
		menubtn.click();
		speedometer.click();
	}

	@Override
	public void clickPageBucketDashborad() {
		menubtn.click();
		pagebucket.click();
	}
	

}
