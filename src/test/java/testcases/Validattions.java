package testcases;

 

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
 

 
public class Validattions {
	WebDriver dr;
	//WebDriver driver;
	//Comparing expected values with expected values
	
	@Rule
	public ErrorCollector errcol = new ErrorCollector();
	
	/*@Test
	public void validation(){
		String expectedValue ="A";
		String actualValue ="B";
		System.out.println("Start");
		try {
			Assert.assertEquals(actualValue, expectedValue);
		//} catch (AssertionError e) {
		//} catch (Exception e) { // This doesn't work
		} catch (Throwable e) {
			errcol.addError(e);
			System.out.println("Asssertion Failed: " + e.getMessage());
			// TODO: handle exception
		}
		try {
			Assert.assertTrue("Shit Error Message", 4>12);	
		} catch (Throwable e) {
			errcol.addError(e);
			System.out.println("Asssertion Failed: " + e.getMessage()); 
		}
		
		
		
		
		//Assert.assertTrue("Error Message - element not presetn",isElementPresent());
		//Assert.assertFalse("Error Message - element not present SCREW-YOU",isElementPresent());
		//Assert.assertTrue("Shit Error Message", 4>12);
		//Assert.fail("Fucking Fail This Shit -- The test is a FUGAZEE");
		System.out.println("End");
		//Assert.assertEquals(expectedValue, actualValue);
		
	}
	*/
	@Test
	public void isElementPresentTest(){
		System.out.println("Enter isElementPresent Script");
		System.out.println("user dir " + System.getProperty("user.dir") );
   // WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver32.exe");
	    dr = new ChromeDriver(); //Drivers//geckodriverv0.19.0.exe");
		dr.get("file:///C:/Users/Emman/Desktop/INTERVIEW%20JUNCTION%20BOX/INTERVIEW%20PREPARATION%20FOLDER%20-%20POSTMAN%20CICD%20PIPELINE%20ETC/NEW%20ASHISH%20CODE/NEW%20SELENIUM%20SKELETON%20VIDEOS/TEST_WEBPAGE/index.html");
	// Perform the assertTrue here using isElementPresent 
	// If Assert.assertTrue failing will make the test to stop.
		try {
			Assert.assertTrue("The element is missing ",isElementPresent("//a[@id='TAB1X']"));
		} catch (Throwable e) {
			errcol.addError(e);
			System.out.println("error message display " + e.getMessage());
		}
	     
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Close the driver 
		dr.close();
	
	}	
	
	public boolean isElementPresent(String xpath){
	// System.out.println("this element is present");
	 
	List<WebElement> ls= dr.findElements(By.xpath(xpath));
	 if(ls.size()!=0){
		 System.out.println("this element is present");
		 return true;
		 
	 }else{
		 System.out.println("this element is not present");
		 return false;
		 
	 }	 
 }
 
 
}
