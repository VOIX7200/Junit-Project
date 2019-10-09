package com.junit.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.junit.utility.Xls_Reader;

public class TestBase {
	
	public static Properties CONFIG = null;
	public static Properties OR =null;
	public static WebDriver dr = null;
	public static EventFiringWebDriver driver = null;
	public static boolean isLoggedIn;
	public static Xls_Reader xlsData1;
	
	public static void initialize() throws IOException{
		if(driver == null) {
		//config property file
			CONFIG = new Properties();
			FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\junit\\Config\\config.properties");
			CONFIG.load(fn);
			OR = new Properties();
			fn = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\junit\\Config\\OR.properties");
            OR.load(fn);
        //Initialize the webdriver and EventFriringWebDriver
            if(CONFIG.getProperty("browser").equals("mozilla")){
            	dr = new FirefoxDriver();
            }else if(CONFIG.getProperty("browser").equals("chrome")){
            	//https://www.edureka.co/community/7202/click-allow-notifications-popup-using-selenium-webdriver
            	ChromeOptions options = new ChromeOptions();
            	options.addArguments("--disable-notifications");
            //	dr = new ChromeDriver(options);
            }
           
            
           xlsData1 = new Xls_Reader(System.getProperty("user.dir")+"\\ExecutionInfo\\InputData\\SuiteA.xlsx");
          // driver = new EventFiringWebDriver(dr);
          // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
			
		}
		
		
		
	}
	
	public static WebElement findElement(String objectKey){
		//Single point of processing extraction of objects from the application
		// is happening here.
	try{
		
		if(objectKey.endsWith("_xpath")){
			return driver.findElement(By.xpath(OR.getProperty(objectKey)));
		}else if(objectKey.endsWith("_css")){
			return driver.findElement(By.cssSelector(OR.getProperty(objectKey)));
		}else{
			return driver.findElement(By.xpath(objectKey));
		}
	}catch(NoSuchElementException e){
	 //report error n stop
	}catch(Exception e){
	// report error
		
	}
	return null;
	
	}
	
	
	
	

}
