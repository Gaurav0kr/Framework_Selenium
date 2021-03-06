package com.learnautomation.testcases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;


public class LoginTestCRM extends BaseClass {
	
	
	
	@Test
	public void loginApp()
	{
		logger=report.createTest("Login to CRM");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		loginpage.loginToCRM(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		Helper.captureScreenshot(driver);
		
		logger.pass("Login success");
	}
}
