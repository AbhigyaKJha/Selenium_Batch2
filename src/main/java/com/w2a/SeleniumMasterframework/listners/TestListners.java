package com.w2a.SeleniumMasterframework.listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.SeleniumMasterframework.utils.ExtentReportManager;
import com.w2a.SeleniumMasterframework.utils.TestUtils;

public class TestListners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.createExtentTest(result.getName());
		String logMessage = "<b>" + "<i>" + "Execution of " + result.getName() + " Started" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(logMessage, ExtentColor.GREY);
		ExtentReportManager.getExtentTest().info(m);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logMessage = "<b>" + "<i>" + "This Test Case Got Passed" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(logMessage, ExtentColor.GREEN);
		ExtentReportManager.getExtentTest().info(m);

	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			TestUtils.captureScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(TestUtils.screenShotPath + TestUtils.screenShotName);
		ExtentReportManager.getExtentTest().fail(MediaEntityBuilder
				.createScreenCaptureFromPath(TestUtils.screenShotPath + TestUtils.screenShotName).build());

		String logMessage = "<b>" + "<i>" + "This Test Case Got Failed" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(logMessage, ExtentColor.RED);
		ExtentReportManager.getExtentTest().info(m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logMessage = "<b>" + "<i>" + "This Test Case Got Skipped" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(logMessage, ExtentColor.ORANGE);
		ExtentReportManager.getExtentTest().info(m);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.getExtent().flush();

	}

}
