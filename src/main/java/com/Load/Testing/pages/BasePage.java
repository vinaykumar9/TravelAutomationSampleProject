package com.Load.Testing.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import utility.TestUtil;


public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public Select select;
	public static Alert alert;

	
/*	public static void initialisation(){
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.americanairlines.in/intl/in/index.jsp?locale=en_IN");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}*/
	
	//DKUFIGFY

public BasePage() {
	 try {
		 prop = new Properties(	);
		 FileInputStream fin = new FileInputStream("C:\\project_details\\SampleProject\\src\\main\\resources\\config.properties");
		 
         prop.load(fin);
         }
	 catch(FileNotFoundException  e){
		 e.printStackTrace();
	 }
	 catch(IOException e) {
		 e.printStackTrace();
	 }
}
public static void takeScreenShot(String image_name) throws Exception, IOException{
	TakesScreenshot ts = (TakesScreenshot) driver;
    FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\LoadTesting\\Screenshots\\" +image_name+".png"));	
}


public static void initilization() {
	String browser_name = prop.getProperty("browser");
	if(browser_name.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\project_details\\SampleProject\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	else if(browser_name.equalsIgnoreCase("ie")) {
		 System.setProperty("webdriver.ie.driver","C:\\Users\\DELL\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		 }
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implict_time, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
		
}

//public static void navigateToUrl(){
//	driver.get(prop.getProperty("url"));
	 
//}
public static void forElementVisibility(WebElement webelement) {
	wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(webelement));
} 

public void implicitWait(int waitTime) {
	driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
}

public String getTitle(){
	return driver.getTitle();
}


}


