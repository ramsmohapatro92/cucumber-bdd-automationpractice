package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
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
	
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signinButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// 2. Constructor of the class

	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions :features of the page(behavior) in the form of public method

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void isForgotPasswordLinkClickable() {
		driver.findElement(forgotPwdLink).click();
	}

	/**
	 * 
	 * @param username
	 * 
	 *                 username derived from feature
	 *                 file-->stepdefination--->methodcall
	 * 
	 */

	public void enterUserName(String username) {
		driver.findElement(emailID).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickSignIn() {
		driver.findElement(signinButton).click();
	}
	
	public Accountspage doLogin(String username,String pwd)
	{
		System.out.println("login with "+username+" "+pwd);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signinButton).click();
		return new Accountspage(driver);
	}

}
