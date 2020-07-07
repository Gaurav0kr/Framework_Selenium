package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass extends ExcelDataProvider {

	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void seupsuit() {
		
	Reporter.log("Setting up report and Test is ready", true);
	excel = new ExcelDataProvider();
	
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Report/FreeCRM_"+Helper.getCurrentDateTime()+".html")); 
	
	report = new ExtentReports();      
	report.attachReporter(extent);
	
	Reporter.log("Setting up report and Test can be started", true);
	
	}
	@BeforeTest
	public void setup() 
	{
	driver = BrowserFactory.startApplication(driver, "Chrome", excel.getStringData(1, 0, 0));
	}

	
	  @AfterTest
	  public void tearDown() throws InterruptedException
	  {
		 Thread.sleep(3000);
		  BrowserFactory.quitBrowser(driver); 
	}
	  
	 @AfterMethod
	 public void teardownMethod(ITestResult result) throws IOException
	 {
		 if(result.getStatus()==ITestResult.FAILURE)
		 {
			// Helper.captureScreenshot(driver);
			 
			 logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		 }
		 else if(result.getStatus()==ITestResult.SUCCESS)
	 {
			 Helper.captureScreenshot(driver);
			 
			 logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		 	 
	 }
			
	  report.flush();
		 
	 }

}
