package ExcelProcessing;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

import com.junit.testBase.TestBase;



public class TestUtil extends TestBase {
	static String testcase = "LoginTest";
	static String sheetName = "TestCases";
	static String positiveData;
	static boolean checkFlag=true;
	static String yesNo;
	static int number;
	
	
	public static void main(String []args) throws IOException{		
		initialize();
		Object[][] data =  getData(testcase);
		for(int i=0; i<data.length; i++){
			positiveData = (String)((Hashtable)data[i][0]).get("positiveData");
			number = Integer.parseInt((String)((Hashtable)data[i][0]).get("boolean"));  ;
			System.out.println("print the yesNo " + number);
			System.out.println(checkPositive(number));
		 
			
			
		}
		//Print the global username;
		//System.out.println("print the username gloabal " + username);
		
		//testing the excel sheet 
		System.out.println(xlsData1.getRowCount("TestCase"));
		System.out.println(xlsData1.getCellData("TestCases","RunMode", 2));
		//run isSkip
		if(isSkip(testcase,sheetName)){
			System.out.println("test to be skipped");
		};
	}
	
	
	public static boolean checkPositive(int yesNo){
		try {
			//if(checkFlag)
			int a =100;
			int b = yesNo;
			int c;
			c= a/b;
			
			return true;
				 
		} catch (Throwable e) {
			System.out.println("it is not a yes");
			return false;
		}
		
		
	}
	
	// the check if a test case is runnable	
	public static boolean isSkip(String testCaseName, String sheetName){
		int rows = xlsData1.getRowCount(sheetName);
		for(int rowNum=0; rowNum<=rows; rowNum++){
			if(testCaseName.equals(xlsData1.getCellData(sheetName,"TCID", rowNum))){
				if(xlsData1.getCellData(sheetName,"RunMode", rowNum).equals("Y")){
					System.out.println("this test is runnable");
					return false;
					
				}else {
					System.out.println("this is not runnable");
					return true;
				}
			}			
		}
		System.out.println("didn't go into forloop and if loop");
		return false;
		
	}
	
	
	public static Object [][] getData(String testcaseName){		
		int rows = xlsData1.getRowCount(testcaseName)-1;
		int cols = xlsData1.getColumnCount(testcaseName);
		System.out.println("print the rows and cols " + rows + "---- " + cols);		
		
		if(rows<=0){
		Object[][] testdata = new Object[1][0];
	    return testdata;		
	    }
		
		
		rows = xlsData1.getRowCount(testcaseName);
		System.out.println("print the rows and cols X2 " + rows + "---- " + cols);	
		Object[][] obj_data = new Object[rows-1][cols];
		int i=0;
		for(int rowNum=2; rowNum<=rows; rowNum++){
			Hashtable<String,String> hashData = new Hashtable<String,String>();
			for(int colNum=0; colNum<cols; colNum++){				
				//data[rowNum-2][colNum] = xlsData1.getCellData(testcaseName, colNum, rowNum);
				//data[rowNum-2][colNum] = xlsData1.getCellData(testcaseName, colNum,1);
				String col = xlsData1.getCellData(testcaseName, colNum,1);
				String data = xlsData1.getCellData(testcaseName, colNum, rowNum);
				//System.out.print(obj_data[rowNum-2][colNum]+ "  " + obj_data[rowNum-2][colNum]+ " ");
				System.out.print(col+ "  " + data+ " ");
				hashData.put(col, data);
			}
			System.out.println();
			obj_data[i][0] = hashData;
			i++;
		}		
		return obj_data;		
	}
	
	
	public static void loginFxn(String username, String passwrd){
		System.out.println("logining in with username and password " + username + "and" + passwrd );
		
	}
	
	public static void executeKeyword(){
		
	}
	
	
	
}