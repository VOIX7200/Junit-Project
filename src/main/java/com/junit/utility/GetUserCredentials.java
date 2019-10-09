package com.junit.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
@RunWith(Parameterized.class)
public class GetUserCredentials {
	public String username1;
	public String password1;
	public GetUserCredentials(String username1, String password1){
		this.username1=username1;
		this.password1=password1;		
	}
	
	@Test
	public void displayData(){
		System.out.println(username1+"--"+ password1);
		
	}
	
	//static int totalNoOfLines;
	//Object [][] data;

//public static void main(String[] args) throws ParseException, IOException {
	
	@Parameters
	public static Collection<Object[]> getUserCreds() throws IOException{
		//Use type as Collection or Iteratable
		
		//https://howtodoinjava.com/junit/how-to-write-parameterized-testcases-with-junit-4/
     //String username;
   //  String password;
	 int totalNoOfLines;
	 Object [][] data = null;
		
 
//final File f = new File(GetUserCredentials.class.getProtectionDomain().getCodeSource().getLocation().getPath());

//BufferedReader br = new BufferedReader(new FileReader(f +"/../src/ExcelData/userdetails.csv"));
	final File f = new File(System.getProperty("user.dir")+ "/ExecutionInfo/userdetails.csv");
	BufferedReader br = new BufferedReader(new FileReader(f));
    totalNoOfLines = 0;
   
    String line =  null;
 
    HashMap<String,String> map = new HashMap<String, String>();
    data = new Object[5][2];
    while((line=br.readLine())!=null){
    totalNoOfLines++;
    
        if  (totalNoOfLines > 1) {
            String arr[] = line.split(",");
            map.put(arr[0], arr[1]);
       // }
   // }
      //data = new Object[5][2];
       // if  (totalNoOfLines > 1) {
        	
     //  for(int j =0;j<totalNoOfLines;j++ ){
    Random rn = new Random();
   int randomNumber = rn.nextInt(map.size()); 
  //  int randomNumber = rn.nextInt(map.size()+1-1)+1;
   // int randomNumber = rn.nextInt(map.size()+1);


    ArrayList<String> keys = new ArrayList<String>(map.keySet());
   // Hashtable <String,String> hast = new Hashtable<String,String>();
    String username = keys.get(randomNumber);   
     String password =(String)map.get(username);
     System.out.println(username +":" + password);
     
    data[totalNoOfLines-2][0]= username;
    data[totalNoOfLines-2][1]= password;
    //data = new Object[5][2];
   // Object XX= data[j-2][0]= username;
   // Object SS = data[j-2][1]= password;
    
  // System.out.println("XX N SS " + XX + "--" + SS);
    // hast.put("username",username);
   //  hast.put("password",password);

    
      // }
      }
    }
	return Arrays.asList(data);
}
}