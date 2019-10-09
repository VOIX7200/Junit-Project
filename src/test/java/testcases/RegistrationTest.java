package testcases;

import java.io.IOException;
import java.util.Set;

import javax.mail.Session;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.junit.testBase.TestBase;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

//@RunWith(DataProviderRunner.class)
public class RegistrationTest extends TestBase {
	//This test is going to use Excel data and Junit to Register Mutiple
	//Users on Quikr.com  and After That, we will do the login Test
	
	@Before
	public void setUp() throws IOException{	
		System.out.println("enter before");
	initialize();		
	}
	
	@Test
	//@UseDataProvider("regTestData")
	public void registrationTest() throws InterruptedException{
		// Resgitration at Quikr
		String env = CONFIG.getProperty("env");
		//String env = "yah";
		String url = CONFIG.getProperty("testSiteUrl_"+env);
		driver.get(url);
		//click regitration link 
		findElement("qk_login_reg_link_xpath").click();
		Thread.sleep(3000);
		Set<String> winHand = driver.getWindowHandles();
		System.out.println("print no of wins " + winHand.size());
		//click signup link 
		findElement("qk_reg_button_css").click();
		//Input Data into the form 
		//Name
		findElement("qk_reg_name_input_css").sendKeys("John Kezac");
		//Phone
		findElement("qk_reg_phone_input_css").sendKeys("07986534431");
		//Email
		findElement("qk_reg_email_input_css").sendKeys("nuffgood@yahoo.co.uk");
		
		//pwd
		findElement("qk_reg_pwd_input_css").sendKeys("Wakedahellup1");
		//confpwd
		findElement("qk_reg_confpwd_input_css").sendKeys("Wakedahellup1");
		//CheckBox
	    findElement("qk_reg_checkbox_input_css").click();
		//Actions build = new Actions(driver);
		//build.moveToElement(driver.findElement(By.id("confirm"))).contextClick().build().perform();
		//Finally create button
		findElement("qk_reg_create_acc_button_css").click();
		Thread.sleep(60000);
		
		 
		
		
				 
				//qk_reg_name_input_css=#fullname
				//qk_reg_phone_input_css=#phone
				//qk_reg_pwd_input_css=#emailidFromPopUp
				//qk_reg_confpwd_input_css=#confirmPassword
				//qk_reg_checkbox_input_xpath=//div/input[@type='checkbox']
				//qk_reg_create_acc_button_css=#reCaptchaRequestRegister
		
		 
		
		
	}
	
	@DataProvider	
	public static Object[][] regTestData(){
		
		return new Object[][]{{},{}
				
		};
		
	}
	
	
	

}
