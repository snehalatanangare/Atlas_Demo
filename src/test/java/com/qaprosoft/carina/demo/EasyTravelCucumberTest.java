package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberBaseTest;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/easytravel.feature",
        glue = "com.qaprosoft.carina.demo.cucumber.steps",
        		format={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
        )
public class EasyTravelCucumberTest extends CucumberBaseTest {

}
