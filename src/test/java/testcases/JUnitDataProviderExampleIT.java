package testcases;

import java.util.Collection;

 


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

//The goals you think are yours have actually been programmed into you by society 
//these finacial goals ..career goals.. are coming from family, role models, algorithtms etc


//https://www.lenar.io/junit-dataprovider-example/
@RunWith(DataProviderRunner.class)
public class JUnitDataProviderExampleIT {

    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {2, 2, 4},
                {10, 1, 11},
                {1000000, -1000000, 0}
        };
    }
    
    @DataProvider
    public static Object[][] sumTestData1() {
        return new Object[][]{
                {2, 2, 4},
                {10, 1, 11},
                {1000000, -1000000, 0}
        };
    }

     
	@Test
    @UseDataProvider("sumTestData1")
    public void dataProviderTest(int a, int b, int expectedSum) {
		System.out.println("Junit is running");
		System.out.println(a+b);
        Assert.assertEquals(expectedSum, a + b);
    }

}