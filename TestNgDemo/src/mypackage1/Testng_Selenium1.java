package mypackage1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Testng_Selenium1 {

	
	@Test(groups= {"Smoke"})
	public void Android_1ravi()
	{
		System.out.println("androidfeature1");
	}
	
	@Test(groups= {"Smoke"})
	public void Android_2ravi()
	{
		System.out.println("androidfeature2");
	}
	@Test(groups= {"Regression"})
	public void Android3()
	{
		System.out.println("androidfeature3");
	}
	@Test(groups= {"Regression"})
	public void Android4()
	{
		System.out.println("androidfeature4");
	}
	
	@Test
	public void Android5()
	{
		System.out.println("androidfeature5");
	}
	@Test
	public void Android6()
	{
		System.out.println("androidfeature6");
	}
	
	@Test
	public void myown()
	{
		System.out.println("myown");
	}
	
	@AfterTest
	public void aftertest_last()
	{
		System.out.println("this is my last test method");
	}

	@AfterSuite
	public void afterSuite1()
	{
		System.out.println("this is my last Suite method");
	}

}
