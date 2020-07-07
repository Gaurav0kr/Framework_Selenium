package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	//this a commit test by Gaurav
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(xpath="//input[@name='email1']") WebElement uname;
	
	@FindBy(xpath="//input[@name='password']") WebElement pass;
	
	@FindBy(xpath="//div[text()='Login']") WebElement logInButton;
	public void loginToCRM(String usernameApplication, String passwordApplication)
	{
		try {
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("got exception while login");
		}
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		logInButton.click();}
}
