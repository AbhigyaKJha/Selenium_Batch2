package com.w2a.SeleniumMasterframework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.w2a.SeleniumMasterframework.testsetup.TestSetup;

public class ExtentReportManager extends TestSetup {

	private static ExtentSparkReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest extentTest;

	public synchronized static ExtentReports initExtentReport() {
		htmlReporter = new ExtentSparkReporter(prop.getProperty("testReportPath") + prop.getProperty("testReportName"));
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("UI Test Report");
		htmlReporter.config().setReportName("Selenium Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;

	}
	
	public static ExtentReports getExtent()
	{
		return ExtentReportManager.extent;
	}
	
	public static ExtentTest getExtentTest()
	{
		return ExtentReportManager.extentTest;
	}
	
	public static void createExtentTest(String testCaseName) {
		extentTest=ExtentReportManager.getExtent().createTest(testCaseName);
	}
	
	
	
	
	
	
	
	

}
