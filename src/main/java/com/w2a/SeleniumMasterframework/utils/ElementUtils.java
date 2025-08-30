package com.w2a.SeleniumMasterframework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.w2a.SeleniumMasterframework.testsetup.TestSetup;

public class ElementUtils extends TestSetup {

	public synchronized static void type(By locator, String value) {
		clear(locator);
		//WaitMachine.waitForElementToPresent(locator);
		driver.findElement(locator).sendKeys(value);
		
	}
	
	public synchronized static void type(By locator, String value,String fieldName) {
		clear(locator);
		//WaitMachine.waitForElementToPresent(locator);
		driver.findElement(locator).sendKeys(value);
		ExtentReportManager.getExtentTest().info("Entered "+"<b>"+value+"</b>"+" in "+fieldName +" field");
		
	}

	public synchronized static void click(By locator) {
		//WaitMachine.waitForElementToClickable(locator);
		driver.findElement(locator).click();
	}
	public synchronized static void click(By locator,String fieldName) {
		//WaitMachine.waitForElementToClickable(locator);
		driver.findElement(locator).click();
		ExtentReportManager.getExtentTest().info("Clicked "+" on "+fieldName +" field");
		
	}

	public synchronized static void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public synchronized static String getElementText(By locator) {
		//WaitMachine.waitForElementToDisplayed(locator);
		return driver.findElement(locator).getText();
	}

	public synchronized static WebElement getWebElement(By locator) {
		//WaitMachine.waitForElementToPresent(locator);
		return driver.findElement(locator);
	}

	public static void selectDropDownWithText(By locator, String text) {
		Select select = new Select(getWebElement(locator));
		select.selectByVisibleText(text);

	}

	public static void selectDropDownWithValue(By locator, String value) {
		Select select = new Select(getWebElement(locator));
		select.selectByVisibleText(value);

	}

}
