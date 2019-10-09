package com.junit.utility;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import com.junit.testBase.TestBase;

public class TestUtil extends TestBase {
	
	//do Login Function
	public void doLogin(){
		
	}
	
	
	public void doRegistration(){
		
		if(isLoggedIn){
			return;
		}
		//Find registrationLink and click on It
		
	}
	
	public static boolean checkLoginErrorText(String errorText){
		
		try {
			String actualErrorText = driver.findElement(By.cssSelector("div[role='alert']")).getText();
			return actualErrorText.contains(errorText);
			
		} catch (NoSuchElementException e) {
			return false;
		}
		
		
	}
	
	public static String getUsernameText(String usrn){
		return driver.findElement(By.xpath("//span[text()='"+usrn+"']")).getText();
	}
	
	//
	
	
	

}
