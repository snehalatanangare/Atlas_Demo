package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MobileSalesLoginPageBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MobileSalesLoginPageBase.class)
public class MobileSalesLoginPage extends MobileSalesLoginPageBase {

	Logger LOGGER = Logger.getLogger(MobileSalesLoginPage.class);

	@FindBy(xpath = "//android.widget.EditText[@resource-id='username']")
	private ExtendedWebElement nameInputField;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='password']")
	private ExtendedWebElement passwordInputField;

	@FindBy(xpath = "//android.widget.Button[@resource-id='loginButton']")
	private ExtendedWebElement loginBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='validateMessage']")
	private ExtendedWebElement alertMsg;

	@FindBy(xpath = "//android.view.View[@resource-id='okButton']")
	private ExtendedWebElement okBtn;

	By MenuBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Menu\")");

	By salesdiaryBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Sales Diary\")");

	By logoutBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Logout\")");

	By logoutOKBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"OK\")");

	public MobileSalesLoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String _username, String _password) {
		nameInputField.type(_username);
		passwordInputField.type(_password);
		loginBtn.click();
		alertMsg.pause(25);
		LOGGER.info("Alert message: " + alertMsg.getText());
		okBtn.click();
	}

	public void homePage() {
		driver.findElement(MenuBtn).click();
		driver.findElement(salesdiaryBtn).click();
	}

	public void logout() {
		driver.findElement(logoutBtn).click();
		driver.findElement(logoutOKBtn).click();
	}
}
