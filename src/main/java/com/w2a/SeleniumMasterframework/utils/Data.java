package com.w2a.SeleniumMasterframework.utils;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.w2a.SeleniumMasterframework.testsetup.TestSetup;


public class Data extends TestSetup {

	@DataProvider(name = "data")
	public synchronized static Object[][] getData(Method m) {
		// Getting the Sheetname from the className
		String sheetName = m.getDeclaringClass().getSimpleName();//sheetName=SauceLabsLoginTest

		// get the total number of rows in the sheet
		int numberOfRows = excel.getRowCount(sheetName);

		// Getting the name of the testcase which will be executed
		String testCaseName = m.getName();

		int testCaseStartsRowNum = 1;

		for (testCaseStartsRowNum = 1; testCaseStartsRowNum <= numberOfRows; testCaseStartsRowNum++) {
			// get the value of first column of each row
			String testcaseNameInExcel = excel.getCellData(sheetName, 0, testCaseStartsRowNum);

			// Now I will compare the value I am geeting from excel to my
			// testcase name
			if (testcaseNameInExcel.equalsIgnoreCase(testCaseName)) {
				break;
			}
		}

		int testDataStartRowNum = testCaseStartsRowNum + 2;
		int numberOfTestDataRows = 0;

		// I am getting total Number of TestData Row using below while loop and storing
		// it in numberOfTestDataRows variable
		while (!excel.getCellData(sheetName, 0, testDataStartRowNum + numberOfTestDataRows)
				.equalsIgnoreCase("endOfTestData")) {
			numberOfTestDataRows++;// 1

		}

		int headerStartRowNum = testCaseStartsRowNum + 1;
		int totalHeadersCount = 0;
		// Finding out total number of columns
		while (!excel.getCellData(sheetName, totalHeadersCount, headerStartRowNum).equals("")) {
			totalHeadersCount++;// 2
		}

		Object[][] data = new Object[numberOfTestDataRows][totalHeadersCount];// [1][2]
		int r = 0;

		for (int rows = testDataStartRowNum; rows < testDataStartRowNum + numberOfTestDataRows; rows++) // rows=
		{

			for (int cols = 0; cols < totalHeadersCount; cols++) {

				data[r][cols] = excel.getCellData(sheetName, cols, rows);// [1][1]='secret_sauce'

			}
			r++;

		}

		return data;

	}

}
