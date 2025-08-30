package com.w2a.SeleniumMasterframework.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.SeleniumMasterframework.Page.LoginPage;
import com.w2a.SeleniumMasterframework.Page.ProductPage;
import com.w2a.SeleniumMasterframework.testsetup.TestSetup;
import com.w2a.SeleniumMasterframework.utils.Data;
import com.w2a.SeleniumMasterframework.utils.ExtentReportManager;

public class SauceLabsLoginTest extends TestSetup {

	@Test(dataProviderClass = Data.class,dataProvider = "data")
	public void verifyLoginWithValidCredentials(String UserName, String Password) throws InterruptedException {
		ExtentReportManager.getExtentTest().assignAuthor("Abhigya");
		LoginPage loginPage = new LoginPage();
		ProductPage productPage = loginPage.doLoginWithValidCredentials(UserName, Password);
		AssertJUnit.assertTrue(productPage.isPageHeaderDisplayed());
		AssertJUnit.assertEquals(productPage.getHeaderText(), "Products");
		
	}
	
	@Test(dataProviderClass = Data.class,dataProvider = "data")
	public void verifyLoginWithInValidCredentials(String UserName, String Password) throws InterruptedException {
		ExtentReportManager.getExtentTest().assignAuthor("Abhigya");
		LoginPage loginPage = new LoginPage();
		loginPage = loginPage.doLoginWithInValidCredentials(UserName, Password);
		AssertJUnit.assertTrue(loginPage.isLoginErrorMessageDisplayed());
		
		
	}
}
