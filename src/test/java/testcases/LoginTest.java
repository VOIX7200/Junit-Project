package testcases;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

 


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

 

//https://stackoverflow.com/questions/24431889/type-mismatch-cannot-convert-from-classparameterized-to-class-extends-runne
//@RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class LoginTest {
	String username;
	String passwrd;
	String browser;
	String runMode;
	
	
	public LoginTest(String username, String passwrd, String browser, String runMode){
		this.username=username;
		this.passwrd=passwrd;
		this.browser=browser;
		this.runMode=runMode;
		
	}
	@Test
	//@Parameters(name="getData2")
	public void loginTest(){
		if(runMode.equals("N"))
			Assert.fail();
			//throw new SkipException("Skipping this test");
		System.out.println("Display Data " + "username: " + username + " password: " + passwrd + " browser: " + browser );
		
	}
	
	//@Parameters
	public static Collection<Object[]> getData(){
		Object [][] data = new Object[3][3];
		
		// 1st row
		  data[0][0] = "Jnakasi";
		  data[0][1] = "password1";
		  data[0][2] = "mozilla";
		
		
		// 2nd row
		  data[1][0] = "Bkanasi";
		  data[1][1] = "password1";
		  data[1][2] = "chrome";
		
		// 3rd row
		  data[2][0] = "Akanasi";
		  data[2][1] = "password1";
		  data[2][2] = "edge";
		
		
		
		return Arrays.asList(data);
		
		
		
	}
	
	
	
	@Parameters
	public static List<Object[]> getData2(){
		Object [][] data = new Object[][]{{"Hello","This","Jol","N"},
				{"Hello","This","Jol","Y"},
				{"Hello","This","Jol","N"}
		};
		
		// 1st row
		 // data[0][0] = "Jnakasi";
		//  data[0][1] = "password1";
		 // data[0][2] = "mozilla";
		
		
		// 2nd row
		//  data[1][0] = "Bkanasi";
		//  data[1][1] = "password1";
		//  data[1][2] = "chrome";
		
		// 3rd row
		//  data[2][0] = "Akanasi";
		//  data[2][1] = "password1";
		 // data[2][2] = "edge";
		
		
		
		//return new Object[][]{("fgff","ryr")}
		return Arrays.asList(data);
				
		 
		
		
		
	}


}
