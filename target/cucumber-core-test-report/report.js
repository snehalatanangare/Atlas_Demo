$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Qtrac.feature");
formatter.feature({
  "line": 2,
  "name": "Qtrac login functionality",
  "description": "",
  "id": "qtrac-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@MobileApp"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Verification of login functionality",
  "description": "",
  "id": "qtrac-login-functionality;verification-of-login-functionality",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@demo"
    },
    {
      "line": 5,
      "name": "@Dev"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Open the browser and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Enter Username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "click on login",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "click on speedometer dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "click on Pagebucket dashboard",
  "keyword": "And "
});
formatter.match({
  "location": "QtracStepdef.LoginPage()"
});
formatter.result({
  "duration": 67658062387,
  "status": "passed"
});
formatter.match({
  "location": "QtracStepdef.enterdetails()"
});
formatter.result({
  "duration": 16789827950,
  "status": "passed"
});
formatter.match({
  "location": "QtracStepdef.ClickOnLoginBtn()"
});
formatter.result({
  "duration": 4512599785,
  "status": "passed"
});
formatter.match({
  "location": "QtracStepdef.clickonspeedometerdashboard()"
});
formatter.result({
  "duration": 31531099655,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to detect element: menubtn (By.xpath: //*[@text\u003d\u0027menu\u0027])\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1391)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1345)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:493)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:481)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:472)\r\n\tat com.qaprosoft.carina.demo.mobile.gui.pages.android.QtracHomePage.clickSpeedometerDashbord(QtracHomePage.java:30)\r\n\tat com.qaprosoft.carina.demo.cucumber.steps.QtracStepdef.clickonspeedometerdashboard(QtracStepdef.java:46)\r\n\tat ✽.Then click on speedometer dashboard(src/test/resources/features/Qtrac.feature:10)\r\nCaused by: org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters. (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027QKNBK474\u0027, ip: \u002710.0.75.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {app: /home/radmin/build/raid-dat..., appActivity: com.qk.q_trac.MainActivity, appPackage: com.qk.q_trac, autoGrantPermissions: true, automationName: uiautomator2, databaseEnabled: false, desired: {app: /home/radmin/build/raid-dat..., appActivity: com.qk.q_trac.MainActivity, appPackage: com.qk.q_trac, autoGrantPermissions: true, automationName: uiautomator2, deviceName: 48, deviceType: phone, noSign: true, pCloudy_ApiKey: jfx5ppmbyng7x8mv2z9hvzqz, pCloudy_ApplicationName: Qtrac.apk, pCloudy_DeviceFullName: Samsung_GalaxyJ4Plus_Androi..., pCloudy_DurationInMinutes: 60, pCloudy_Username: nikita.shinde@qualitykiosk.com, platformName: ANDROID, udid: 879ee013}, deviceApiLevel: 27, deviceManufacturer: samsung, deviceModel: SM-J415F, deviceName: 879ee013, deviceScreenDensity: 280, deviceScreenSize: 720x1480, deviceType: phone, deviceUDID: 879ee013, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, noSign: true, pCloudy_ApiKey: jfx5ppmbyng7x8mv2z9hvzqz, pCloudy_ApplicationName: Qtrac.apk, pCloudy_DeviceFullName: Samsung_GalaxyJ4Plus_Androi..., pCloudy_DurationInMinutes: 60, pCloudy_Username: nikita.shinde@qualitykiosk.com, pixelRatio: 1.75, platform: LINUX, platformName: ANDROID, platformVersion: 8.1.0, statBarHeight: 42, takesScreenshot: true, udid: 879ee013, viewportRect: {height: 1354, left: 0, top: 42, width: 720}, warnings: {}, webStorageEnabled: false}\nSession ID: 51f5e27c-4bd0-43e4-8947-6a215fb3ea6e\n*** Element info: {Using\u003dxpath, value\u003d//*[@text\u003d\u0027menu\u0027]}\r\n\tat sun.reflect.GeneratedConstructorAccessor18.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.listener.EventFiringAppiumCommandExecutor.execute(EventFiringAppiumCommandExecutor.java:150)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:61)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByXPath(DefaultGenericMobileDriver.java:151)\r\n\tat io.appium.java_client.AppiumDriver.findElementByXPath(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElementByXPath(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.refindElement(ExtendedWebElement.java:383)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1388)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1345)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:493)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:481)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:472)\r\n\tat com.qaprosoft.carina.demo.mobile.gui.pages.android.QtracHomePage.clickSpeedometerDashbord(QtracHomePage.java:30)\r\n\tat com.qaprosoft.carina.demo.cucumber.steps.QtracStepdef.clickonspeedometerdashboard(QtracStepdef.java:46)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner.feature(CucumberRunner.java:56)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:583)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:648)\r\n\tat org.testng.TestRunner.run(TestRunner.java:505)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:455)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:364)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1137)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1049)\r\n\tat org.testng.TestNG.run(TestNG.java:1017)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:114)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "QtracStepdef.clickonPagebucketdashboard()"
});
formatter.result({
  "status": "skipped"
});
});