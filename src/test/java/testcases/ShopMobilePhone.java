package testcases;

import junit.framework.Assert;

import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.DEFAULT)
public class ShopMobilePhone {
	
	@Test
	public void test_a_searchForMobile(){
		System.out.println("Searching for Mobile");
	}
	@Test
	public void test_b_selectMobile(){
		System.out.println("Selecting Mobile");
	}
	//@Ignore
	@Test
	public void test_c_checkOut(){
	Assume.assumeTrue(false);
	 
	 
		System.out.println("CheckOut Mobile");
	}

}
