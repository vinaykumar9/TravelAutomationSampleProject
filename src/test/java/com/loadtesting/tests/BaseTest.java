package com.loadtesting.tests;

import org.testng.annotations.Test;

import com.Load.Testing.pages.BasePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends BasePage {
	
	ExtentReports extent;
	ExtentTest logger;
	
	
	  @BeforeSuite
	  public void beforeSuite() {
		  
		  System.out.println("before suite..................");
		  
	  }
	  @AfterSuite
	  public void afterSuite() {
		  
		  System.out.println("before suite..................");

	  }
	  
	  
	  

	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("----------------------------before class..................");

			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
            extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));	
	  }

	  
	  @AfterClass
	  public void afterClass() {
			// writing everything to document
			//flush() - to write or update test information to your report. 
		  System.out.println("----------------------------after class..................");

	                extent.flush();
	                //Call close() at the very end of your session to clear all resources. 
	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
	                //Once this method is called, calling any Extent method will throw an error.
	                //close() - To close all the operation
	                extent.close();
	    }  
	  

/*  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }
*/

 

 

 
}
