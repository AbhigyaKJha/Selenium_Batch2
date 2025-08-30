package com.w2a.SeleniumMasterframework.testsetup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.w2a.SeleniumMasterframework.utils.DriverManager;
import com.w2a.SeleniumMasterframework.utils.ExcelReader;
import com.w2a.SeleniumMasterframework.utils.ExtentReportManager;
import com.w2a.SeleniumMasterframework.utils.PropertyFileManager;

public class TestSetup {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/TestCaseData.xlsx");

	@BeforeSuite
	public synchronized void testSetup() {

		prop = PropertyFileManager.intializePropertyFile();
		extent = ExtentReportManager.initExtentReport();
	}

	@BeforeMethod
	public void beforeMethod() {

		driver = DriverManager.createDriver("firefox");
		driver.get(prop.getProperty("testURL"));

	}

	@AfterMethod
	public void tearDown() {
		DriverManager.destroyDriver(driver);
	}

}
