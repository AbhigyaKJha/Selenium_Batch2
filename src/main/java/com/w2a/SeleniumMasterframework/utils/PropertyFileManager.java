package com.w2a.SeleniumMasterframework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {

	private static Properties prop;
	private static FileInputStream fis;

	public static Properties intializePropertyFile() {
		prop = new Properties();
		try {
			fis = new FileInputStream(Constants.PROPERTY_FILES + Constants.QA_PROPERTY_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

}
