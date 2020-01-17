package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qk.m1cloud.UploadAPK;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import static com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils.getDriver;

public class MobileContextUtils {

    private static final Logger LOGGER = Logger.getLogger(MobileContextUtils.class);
    UploadAPK uploadAPK = new UploadAPK();
    
    private WebDriver getDriverSafe() {
        WebDriver driver = getDriver();
        if (driver instanceof EventFiringWebDriver) {
            driver = ((EventFiringWebDriver) driver).getWrappedDriver();
        }
        return driver;
    }

    public void switchMobileContext(View context) {
        AppiumDriver<?> driver = (AppiumDriver<?>) getDriverSafe();
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(driver::getContextHandles);
        String desiredContext = "";
        boolean isContextPresent = false;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                desiredContext = cont;
                isContextPresent = true;
            }
            LOGGER.info(cont);
        }
        if (!isContextPresent) {
            throw new NotFoundException("Desired context is not present");
        }
        LOGGER.info("Switching to context : " + context.getView());
        driver.context(desiredContext);
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB("WEBVIEW_unknown");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }
    
    public DesiredCapabilities setCapabilities(String DeviceName) throws Exception{
    	if(R.CONFIG.getProperties().getProperty("uploadAPK").equals("true")){
			uploadAPK.Upload_apk();
		}
    	LOGGER.info("DeviceName: "+DeviceName);
		Properties prop = new Properties();
			String propFile = DeviceName;
		String path = "src/main/resources/m1Cloud/android/"+propFile;
		
		InputStream input = new FileInputStream(path);
		prop.load(input);
		
		
	//	DesiredCapabilities capabilities = new DesiredCapabilities();
		/*capabilities.setCapability("Capability_Username",prop.getProperty("Capability_Username"));
		capabilities.setCapability("Capability_ApiKey",prop.getProperty("Capability_ApiKey"));
		capabilities.setCapability("Capability_ApplicationName", prop.getProperty("Capability_ApplicationName"));
		capabilities.setCapability("Capability_DurationInMinutes", prop.getProperty("Capability_DurationInMinutes"));
		capabilities.setCapability("Capability_DeviceFullName",prop.getProperty("Capability_DeviceFullName"));
		//capabilities.setCapability("deviceType",prop.getProperty("deviceType"));
		capabilities.setCapability("deviceType","MOBILE");
		capabilities.setCapability("mobilePlatformName",prop.getProperty("platformName"));
		capabilities.setCapability("appActivity",prop.getProperty("appActivity"));
		capabilities.setCapability("newCommandTimeout", 600);
		  capabilities.setCapability("launchTimeout", 90000);
		  capabilities.setCapability("unicodeKeyboard", true);
		  capabilities.setCapability("resetKeyboard", true);
	//	capabilities.setCapability("unicodeKeyboard", true);
	//	capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("appPackage",prop.getProperty("appPackage"));
		capabilities.setCapability("autoGrantPermissions", true);
	//	capabilities.setCapability("noSign", true);
	//	capabilities.setCapability("devicePool", DeviceList);
		capabilities.setCapability("systemPort", new Random().nextInt(100)+1024);
		capabilities.setCapability("automationName", "UiAutomator2");*/
		
		  /*DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("Capability_Username",prop.getProperty("Capability_Username")); //username used for loging to m1
		  capabilities.setCapability("Capability_ApiKey",prop.getProperty("Capability_ApiKey"));//password used for loging to m1
		  capabilities.setCapability("Capability_ApplicationName", "Qtrac.apk");
		  capabilities.setCapability("Capability_DurationInMinutes", 60);
		  capabilities.setCapability("Capability_DeviceFullName",prop.getProperty("Capability_DeviceFullName")); 
		  capabilities.setCapability("appPackage",prop.getProperty("appPackage"));
		  capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
		  capabilities.setCapability("deviceType",prop.getProperty("deviceType"));
		  capabilities.setCapability("platformName",prop.getProperty("platformName"));
		  capabilities.setCapability("newCommandTimeout", 600);
		  capabilities.setCapability("launchTimeout", 90000);
		  capabilities.setCapability("unicodeKeyboard", true);
		  capabilities.setCapability("resetKeyboard", true);
		  capabilities.setCapability("systemPort", new Random().nextInt(100)+1024);
		  capabilities.setCapability("automationName", "UiAutomator2");*/
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
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noSign", true);
		R.CONFIG.getProperties().setProperty("deviceName", prop.getProperty("Capability_DeviceFullName"));
		
		/*try{
			getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host"));
			
		}catch(Exception e){
			LOGGER.info(e.getMessage());
		}*/
		/*}
		device_count++;*/
		return capabilities;
	
    }
}