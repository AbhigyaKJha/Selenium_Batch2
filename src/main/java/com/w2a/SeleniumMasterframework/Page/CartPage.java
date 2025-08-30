package com.w2a.SeleniumMasterframework.Page;

import org.openqa.selenium.By;

import com.w2a.SeleniumMasterframework.testsetup.TestSetup;
import com.w2a.SeleniumMasterframework.utils.ElementUtils;

public class CartPage extends TestSetup{
	
	private By CartPageHeader=By.className("subheader");
	
	
	public boolean isCartPageHeaderDisplayed()
	{
		return  ElementUtils.getWebElement(CartPageHeader).isDisplayed();
	}

}
