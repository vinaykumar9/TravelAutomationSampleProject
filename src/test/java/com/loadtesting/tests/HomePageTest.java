package com.loadtesting.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Load.Testing.pages.BasePage;
import com.Load.Testing.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends BaseTest {
	HomePage home;

	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
    BasePage.initilization();
	home = new HomePage();

	}

	
	@Test(priority=1)
	public void traveeling_mode() throws InterruptedException{
		logger = extent.startTest("travelling from one location to another location");
		System.out.println(driver.getCurrentUrl());
		home.enterFromToStations("Miami (MIA), Florida, USA","Dallas/Fort Worth (DFW), Texas, USA","13/02/2020","19/02/2020","5","1");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS, "travelling from one location to another location");

}
	
	
	@Test(priority=2)
	public void travellingwithoutStartName() throws InterruptedException{
		logger = extent.startTest("travelling from location");

		System.out.println(driver.getCurrentUrl());
		home.enterFromToStations("","Dallas/Fort Worth (DFW), Texas, USA","13/02/2020","19/02/2020","5","1");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean expected = home.erroeMessage();
		Assert.assertEquals(true, expected);
		logger.log(LogStatus.PASS, "travelling from location");
}
	
@Test(priority=3)
public void VerifyHomePageTitle(){
    String title = home.getTitle();
    System.out.println(title);
    Assert.assertEquals(title, "Airline Tickets and Airline Reservations from American Airlines | aa.com");
	logger.log(LogStatus.FAIL, "VerifyHomePageTitle");

}
   

	@AfterMethod
	public void getResult(ITestResult result){
	      driver.close();

		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
   
/*   @AfterMethod
	public void tear_method(){
	   System.out.println("after ,method......................");
      driver.close();
	}*/


}