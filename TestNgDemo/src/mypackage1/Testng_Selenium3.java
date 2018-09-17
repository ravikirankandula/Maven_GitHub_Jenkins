package mypackage1;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_Selenium3 {

	@BeforeTest
	public void beforeTest1()
	{
		System.out.println("this is my before test method");
	}
	
	@Test
	public void windows1()
	{
		System.out.println("windows1");
	}
	
	@Test
	public void widnows2()
	{
		System.out.println("widnows2");
	}
	@Test(groups= {"Smoke"})
	public void windows3()
	{
		System.out.println("windows3");
	}
	
	@BeforeSuite
	public void beforeSuite1()
	{
		System.out.println("this is my before Suite method");
	}
}
