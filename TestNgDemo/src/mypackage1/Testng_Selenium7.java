package mypackage1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_Selenium7 {

	@BeforeSuite
	public void bS1()
	{
		System.out.println("beforeSuite");
	}
	
	@BeforeTest
	public void bT1()
	{
		System.out.println("beforeTest");
	}
	@BeforeClass
	public void bc1()
	{
		System.out.println("beforeClass");
	}
	@BeforeMethod
	public void bm1()
	{
		System.out.println("beforeMethod");
	}
	
	@AfterSuite
	public void as1()
	{
		System.out.println("afterSuite");
	}
	@AfterTest
	public void aT1()
	{
		System.out.println("afterTest");
	}
	
	@AfterClass
	public void ac1()
	{
		System.out.println("afterClass");
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
