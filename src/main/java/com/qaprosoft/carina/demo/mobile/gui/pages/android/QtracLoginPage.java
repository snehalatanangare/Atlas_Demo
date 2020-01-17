package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracLoginPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = QtracLoginPageBase.class)
public class QtracLoginPage extends QtracLoginPageBase{
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
	private ExtendedWebElement username;

	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
	private ExtendedWebElement pwd;
    
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.Button")
	private ExtendedWebElement loginbtn;
	
	@FindBy(xpath="//*[@text='log in SIGN IN']")
	private ExtendedWebElement signinbtn;
	
	public QtracLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void login(String name, String password) {
		username.type(name);
		pwd.type(password);
	}

	@Override
	public void clickonSignin() {
		signinbtn.clickIfPresent();
	}

	@Override
	public void clickonLoginBtn() {
		loginbtn.clickIfPresent();
	}

}
