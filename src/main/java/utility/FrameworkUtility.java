package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.Load.Testing.pages.BasePage;

public class FrameworkUtility extends BasePage {
	
	
	public FrameworkUtility(){
		super();
	}
	
	
	public void enterText(WebElement webelement, String value) {
		//BasePage.forElementVisibility(webelement);
		webelement.clear();
		webelement.sendKeys(value);
	}
	
	
	public void clickElement(WebElement webelement) {
	  BasePage.forElementVisibility(webelement);
	  webelement.click();
		}
		
	public void selectItemFromListByValue(WebElement webelement, String value) throws InterruptedException  {
		BasePage.forElementVisibility(webelement);
		select = new Select(webelement);
		select.selectByValue(value);
	}
	
	public void selectItemFromListByText(WebElement webelement, String text) throws InterruptedException  {
		BasePage.forElementVisibility(webelement);
		select = new Select(webelement);
		select.selectByValue(text);
	}
	
	
	public void selectItemFromListByIndex(WebElement webelement, String index) throws InterruptedException  {
		BasePage.forElementVisibility(webelement);
		select = new Select(webelement);
		select.selectByValue(index);
	}
	
	public String getCurrentUrl() {
	    return driver.getCurrentUrl();
	 }
	
	
}

