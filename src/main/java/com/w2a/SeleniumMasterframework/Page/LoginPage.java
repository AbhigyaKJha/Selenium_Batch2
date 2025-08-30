package com.w2a.SeleniumMasterframework.Page;

import org.openqa.selenium.By;

import com.w2a.SeleniumMasterframework.testsetup.TestSetup;
import com.w2a.SeleniumMasterframework.utils.ElementUtils;

public class LoginPage extends TestSetup{

	// By Locators for All The Elements
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By loginErrorMessage = By.xpath("//h3[@data-test='error']");

	// Actions method

	public ProductPage doLoginWithValidCredentials(String username, String pwd) {
		ElementUtils.type(userName, username,"UserName");
		ElementUtils.type(password, pwd,"Password");
		ElementUtils.click(loginButton,"LoginButton");
		return new ProductPage();
	}

	public LoginPage doLoginWithInValidCredentials(String username, String pwd) {
		ElementUtils.type(userName, username);
		ElementUtils.type(password, pwd);
		ElementUtils.click(loginButton);
		return this;
		
	
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isLoginErrorMessageDisplayed() {
		return ElementUtils.getWebElement(loginErrorMessage).isDisplayed();
	}
	
	
}
