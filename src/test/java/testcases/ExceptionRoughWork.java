package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import com.junit.testBase.TestBase;

public class ExceptionRoughWork extends TestBase {
	//This test is going to use Excel data and Junit to Register Mutiple
	//Users on Quikr.com  and After That, we will do the login Test
	
	//All Unchecked exceptions are direct sub classes of RuntimeException class.
	
	@Before
	public void setUp() throws IOException{	
		System.out.println("enter before");
	//	initialize();		
	}
	
	@Test
	public void registrationTest() throws IOException{
		 
		try {
			int a = 10, b = 1;
			boolean x;
		System.out.println(a/b);
		} catch (Exception e) {
			System.out.println("fucking catch  " + e.getMessage());
		}
		///int i =0;
		//if(i==0){
		//	//https://beginnersbook.com/2013/04/throw-in-java/
			//throw new ArithmeticException("fuck you");		
			//}		
		//  Read a file 
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\ExecutionInfo\\InputData\\Data.txt");
		int e;
		int count =0;
		while((e = fs.read())!=-1){
			String d = "hello";
			System.out.print((char)e);
			//System.out.println("");
			
			count++;
		}
		System.out.println("" + count);
	}

}
