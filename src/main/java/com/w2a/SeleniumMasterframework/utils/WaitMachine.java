package com.w2a.SeleniumMasterframework.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMachine {

	private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

	public static void waitForElementToPresent(By locator) {

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void waitForElementToDisplayed(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(null));
	}

	public static void waitForElementToClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

}
