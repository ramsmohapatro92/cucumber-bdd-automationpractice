package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accountspage {

	private WebDriver driver;

	/**
	 * @author Ram S Mohapatro
	 * @since April 2021
	 * 
	 *        3 things to be maintained under Individual pages 1. By locators 2. one
	 *        constructor to initialize driver 3. Page actions
	 * 
	 *        Concept of Encapsulation will be used where locators will be private
	 *        and will be accessed by the public methods
	 * 
	 */

	// 1. By locators are type private<> Object repository

	private By accountsections = By.xpath("//div[@id='center_column']//span");

	// 2. Constructor of the class

	public Accountspage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions :features of the page(behavior) in the form of public method

	public int getAccountSectionCount() {
		int size = driver.findElements(accountsections).size();
		return size;
	}

	public List<String> getAccountSectionsList() {
		List<String> accountlist = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountsections);

		for (WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountlist.add(text);
		}

		return accountlist;
	}
	
	public String accountsPageTitle()
	{
		return driver.getTitle();
	}

}
