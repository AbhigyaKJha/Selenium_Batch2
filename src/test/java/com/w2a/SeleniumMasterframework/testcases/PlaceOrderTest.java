package com.w2a.SeleniumMasterframework.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.w2a.SeleniumMasterframework.Page.CartPage;
import com.w2a.SeleniumMasterframework.Page.LoginPage;
import com.w2a.SeleniumMasterframework.Page.ProductPage;
import com.w2a.SeleniumMasterframework.testsetup.TestSetup;
import com.w2a.SeleniumMasterframework.utils.Data;

public class PlaceOrderTest extends TestSetup {

	@Test(dataProviderClass = Data.class, dataProvider = "data")
	public void verifyPlaceOrder(String UserName, String Password, String ProductPageHeader, String Products)
			throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		ProductPage productPage = loginPage.doLoginWithValidCredentials(UserName, Password);
		AssertJUnit.assertTrue(productPage.isPageHeaderDisplayed());
		AssertJUnit.assertEquals(productPage.getHeaderText(), ProductPageHeader);

		productPage.addProductsToCart(Products);
		CartPage cart = productPage.clickOnCartLogo();
		Assert.assertTrue(cart.isCartPageHeaderDisplayed());

		Thread.sleep(5000);

	}

}
