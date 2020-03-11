package com.Load.Testing.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.FrameworkUtility;

public class HomePage extends BasePage {
	FrameworkUtility utility = new FrameworkUtility();

	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css ="input[name='origin']")
	public WebElement originStation;
	
	@FindBy(css ="input[name='destination']")
	public WebElement destinationStation;
	
	@FindBy(id="bookingModule-submit")
	public WebElement bookingSubmit;
	
	@FindBy(css="#aa-leavingOn")
	public WebElement departDate;
	
	@FindBy(css= "#aa-returningFrom")
	public WebElement returnDate;
	
	@FindBy(css= "select[name='adults']")
	public WebElement AdultsList;
	
	@FindBy(css= "select[name='children']")
	public WebElement childranList;
	
	
	@FindBy(css="li.errorMessage")
	public WebElement errors;
	
	
	
	
	
	public void enterFromToStations(String source, String Destination,String fromdate, String todate, String adultsslists,String childranlists) throws InterruptedException{
		
		System.out.println("landed in home page............................");
		utility.enterText(originStation, source);
		utility.enterText(destinationStation, Destination);
		utility.enterText(departDate, fromdate);
		utility.enterText(returnDate, todate);
		utility.selectItemFromListByValue(AdultsList, adultsslists);
		utility.selectItemFromListByValue(childranList, childranlists);
		utility.clickElement(bookingSubmit);
		
		
	}
	
	public boolean  erroeMessage(){
		boolean error_flag= false;
		List<WebElement> erroemessages = driver.findElements(By.cssSelector("li.errorMessage"));
		for(WebElement l: erroemessages){
			if ((l.getText().equalsIgnoreCase("Please provide us with a departure city and try again."))|| (l.getText().equalsIgnoreCase("Please provide us with a return city and try again."))){
				return error_flag=true;
			}
		}
		return error_flag;
		
	}
	
}
