package com.w2a.SeleniumMasterframework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

	// private static WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}

	public synchronized static WebDriver createDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			DriverManager.setDriver(new ChromeDriver());
			maximizeBrowser();
			applyImplicitWait();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			DriverManager.setDriver(new FirefoxDriver());
			maximizeBrowser();
			applyImplicitWait();

		} else if (browserName.equalsIgnoreCase("safari")) {
			DriverManager.setDriver(new SafariDriver());
			maximizeBrowser();
			applyImplicitWait();

		}
		return DriverManager.getDriver();

	}

	public static void maximizeBrowser() {
		DriverManager.getDriver().manage().window().maximize();
	}

	public static void applyImplicitWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_WAIT_TIME));
	}

	public static void destroyDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}

}
