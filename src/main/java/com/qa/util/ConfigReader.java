package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/**
	 * This method is to load properties from config.properties file
	 * Here prop is a private member belongs to config reader class.
	 * we are taking help of init_prop() to return the prop details
	 * @return
	 */

	public Properties init_prop() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("src\\test\\resources\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		
		return prop;

	}

}
