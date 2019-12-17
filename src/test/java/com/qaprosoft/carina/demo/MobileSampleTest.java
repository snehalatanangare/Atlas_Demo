package com.qaprosoft.carina.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;



public class MobileSampleTest extends AbstractTest {

	//@BeforeMethod
	public void setCustCaps(String jenkinsJobEnvironment) throws Exception{
		String propFile = propertiesFile(jenkinsJobEnvironment);
		
		String path = "src/main/resources/m1Cloud/android/"+propFile;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(path);
		prop.load(input);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("Capability_Username",prop.getProperty("Capability_Username"));
		capabilities.setCapability("Capability_ApiKey",prop.getProperty("Capability_ApiKey"));
		capabilities.setCapability("Capability_ApplicationName", prop.getProperty("Capability_ApplicationName"));
		capabilities.setCapability("Capability_DurationInMinutes", prop.getProperty("Capability_DurationInMinutes"));
		capabilities.setCapability("Capability_DeviceFullName",prop.getProperty("Capability_DeviceFullName"));
		capabilities.setCapability("deviceType",prop.getProperty("deviceType"));
		capabilities.setCapability("platformName",prop.getProperty("platformName"));
		capabilities.setCapability("automationName",prop.getProperty("automationName"));
		capabilities.setCapability("appActivity",prop.getProperty("appActivity"));
		capabilities.setCapability("appPackage",prop.getProperty("appPackage"));
		R.CONFIG.getProperties().setProperty("deviceName", prop.getProperty("Capability_DeviceFullName"));
		
		getDriver("default", capabilities, R.CONFIG.get("selenium_host"));
	}
	
	public String propertiesFile(String jenkinsJobEnvironment){
		System.out.println(System.getProperty("stageName"));
		String propName = null;

		if(jenkinsJobEnvironment.equals("DEV")){
			propName = "Samsung_Galaxy_Note_8.properties";
		}
		else if(jenkinsJobEnvironment.equals("QA")){
			propName = "Samsung_Galaxy_Note_8.properties";
		}
		else{
			propName = "Samsung_Galaxy_Note_8.properties";
		}
		return propName;
	}
	
    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    //@Parameters(value={"stageName"})
    public void testLoginUser() throws Exception {
    	setCustCaps("UAT");
    	setApplicationPath();
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.selectMaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }

    /*@SuppressWarnings("deprecation")
	@Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    public void testWebView() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        loginPage.login();
        WebViewPageBase webViewPageBase = initPage(getDriver(), WebViewPageBase.class);
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(View.WEB);
        ContactUsPageBase contactUsPage = webViewPageBase.goToContactUsPage();
        contactUsPage.typeName("John Doe");
        contactUsPage.typeEmail("some@email.com");
        contactUsPage.typeQuestion("This is a message");
        contactUsPage.submit();
        Assert.assertTrue(contactUsPage.isSuccessMessagePresent() || contactUsPage.isRecaptchaPresent(),
            "message was not sent or captcha was not displayed");
    }

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    public void testUIElements() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
        UIElementsPageBase uiElements = carinaDescriptionPage.navigateToUIElementsPage();
        final String text = "some text";
        final String date = "22/10/2018";
        final String email = "some@email.com";
        uiElements.typeText(text);
        Assert.assertEquals(uiElements.getText(), text, "Text was not typed");
        uiElements.typeDate(date);
        Assert.assertEquals(uiElements.getDate(), date, "Date was not typed");
        uiElements.typeEmail(email);
        Assert.assertEquals(uiElements.getEmail(), email, "Email was not typed");
        uiElements.swipeToFemaleRadioButton();
        uiElements.checkCopy();
        Assert.assertTrue(uiElements.isCopyChecked(), "Copy checkbox was not checked");
        uiElements.clickOnFemaleRadioButton();
        Assert.assertTrue(uiElements.isFemaleRadioButtonSelected(), "Female radio button was not selected!");
        uiElements.clickOnOtherRadioButton();
        Assert.assertTrue(uiElements.isOthersRadioButtonSelected(), "Others radio button was not selected!");
    }*/

    private void setApplicationPath() {
		String pathToApp;
		String iosPath = "src/main/resources/carinademoexample.zip";
		String androidPath = "src/main/resources/carinademoexample.apk";
		if (Type.ANDROID_PHONE.getFamily().equalsIgnoreCase(R.CONFIG.get("capabilities.platformName")))
			pathToApp = androidPath;
		else 
			pathToApp = iosPath;
		File file = new File(pathToApp);
		Configuration.setMobileApp(file.getAbsolutePath());
	}
}
