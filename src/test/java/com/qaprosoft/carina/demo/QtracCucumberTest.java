package com.qaprosoft.carina.demo;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberBaseTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;

import cucumber.api.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features/Qtrac.feature",
        glue = "com.qaprosoft.carina.demo.cucumber.steps",
        		format={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
        )

public class QtracCucumberTest extends CucumberBaseTest {
	@BeforeTest
	//@Parameters({"DeviceName"})
	public void setCustCaps() throws Exception{
		MobileContextUtils mobile = new MobileContextUtils();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = mobile.setCapabilities("Samsung_Galaxy_J4_Plus.properties");
		getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host"));
	}}
