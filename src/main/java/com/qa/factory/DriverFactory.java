package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is : " + browser);

		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			break;

		case "MSEdge":
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
			break;

		default:
			System.out.println(" Setup a valid browser name "+ browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver(); 
		
	}
	
	/**
	 * A method to return the proper driver which is stored in the 
	 * Thread local reference variable using .get() method
	 */
	
	public static WebDriver getDriver()
	{
		return tldriver.get();
		
	}

}
