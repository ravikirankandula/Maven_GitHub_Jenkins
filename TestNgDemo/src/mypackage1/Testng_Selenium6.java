package mypackage1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng_Selenium6 {

	
	@BeforeMethod
	public void bm1()
	{
		System.out.println("beforeMethod");
	}
	
	@AfterMethod
	public void am1()
	{
		System.out.println("afterMethod");
	}
	
	@Test
	public void tm1()
	{
		System.out.println("testMethod1");
	}
	@Test
	public void tm2()
	{
		System.out.println("testMethod2");
	}
	@Test
	public void tm3()
	{
		System.out.println("testMethod3");
	}
	@Test
	public void tm4()
	{
		System.out.println("testMethod4");
	}
}
