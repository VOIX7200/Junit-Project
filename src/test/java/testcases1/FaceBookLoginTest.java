package testcases1;

import java.io.IOException;

 

 





import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.junit.testBase.TestBase;
import com.junit.utility.TestUtil;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


@RunWith(DataProviderRunner.class)
public class FaceBookLoginTest extends TestBase{
	
	boolean result;
	String usrn;
	
	@Before
	public void setUp() throws IOException{
   System.out.println("Before Executed");	
		initialize();
		//String env = CONFIG.getProperty("env");
		//String url = CONFIG.getProperty("testSiteUrl_"+env);
		//driver.get(url);	
	}
	
	@Test
	@UseDataProvider("fbData")
	public void faceBookLoginTest(String email,String pwd,String username,String errorText, String positiveData)throws InterruptedException, IOException{
	//public void faceBookLoginTest() throws InterruptedException{
		//Navigate to facebook login page
		//initialize();
		driver.manage().deleteAllCookies();
		
		String env = CONFIG.getProperty("env");
		String url = CONFIG.getProperty("testSiteUrl_"+env);
		driver.get(url);
	
	// Do login function here but do raw for now.
    //email input	 
	findElement("fb_email_Input_css").sendKeys(email);	
	//paswrd input
	findElement("fb_pwd_Input_css").sendKeys(pwd);	
	//click submit
	findElement("fb_login_submit_css").click();
	Thread.sleep(6000);
	//log out
	//findElement("fb_logout_dropdown_css").click();
	//Thread.sleep(6000);
	//findElement("fb_logout_button_xpath").click();
			 
	//findElement("fb_click_home_xpath").click();
	//findElement("fb_click_findFriends_xpath").click();
	//Alert al = driver.switchTo().alert();
	//al.accept();	
	//driver.findElement(By.xpath("//a[text()='Find Friends']")).click();
	//perform verification for flexible results
	
	if(!StringUtils.isBlank(errorText)){
		try {
		  result = TestUtil.checkLoginErrorText(errorText);
		} catch (Exception e) {
			// TODO: handle exception
			if(positiveData.equals("N"))
			Assert.assertTrue("Able to login with wrong credentials", false);
		}
		
		System.out.println("print result " + result);
	     Assert.assertTrue(result);     
	     
	     
	     }else
	     {
	    	System.out.println("Assert UserName is not empty");
	    	try {
	    		usrn = TestUtil.getUsernameText(username);
			} catch (Exception e) {
				if(positiveData.equals("Y"))
					Assert.assertTrue("unable to login with right credentials", false);
			}	    	
	    	Assert.assertTrue(!usrn.isEmpty());
	    	Assert.assertEquals(username, usrn);
	     }
	    	
	    	
	     
	}
	
	//@After
	public void tearDown1() throws IOException{		
		driver.close();
		System.out.println("Close Browser Executed ");
	}
	
	@AfterClass
	public static void tearDown() throws IOException{		
		driver.quit();
	    driver = null;
		System.out.println("Quit Driver Executed ");
	}
	
	//The email address or phone number that you've entered doesn't match any account. Sign up for an account.
	
	//Data Provider
	@DataProvider
	public static Object[][]fbData(){
		return new Object[][]{{"kc@exongroup.co.uk","Oneway114","Kc",null,"Y"},
				//{"","","","null"},
				{"","fucked","Kc","The email address or phone number that","N"},
				{"fucked","","Kc","The email address or phone number that","N"}
		};
	}

}
