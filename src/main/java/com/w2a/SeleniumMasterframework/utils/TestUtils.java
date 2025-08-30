package com.w2a.SeleniumMasterframework.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.SeleniumMasterframework.testsetup.TestSetup;

public class TestUtils extends TestSetup {
	public static String screenShotPath;
	public static String screenShotName;

	public synchronized static void captureScreenShot() throws IOException {
		//screenShotPath = prop.getProperty("ScreenShotPath");
		screenShotPath=System.getProperty("user.dir")+"/Screenshots";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenShotName = d.toString().replace(" ", "_").replace(":", "_") + ".png";
		FileUtils.copyFile(srcFile, new File(screenShotPath + screenShotName));
	}

}
