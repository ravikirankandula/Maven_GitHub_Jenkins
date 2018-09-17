package mypackage1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_Selenium2 {
	@BeforeTest
	public void BeforeTest1()
	{
		System.out.println("BeforeTest1");
	}
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite1");
	}
	@BeforeClass
	public void beforeclass1()
	{
		System.out.println("beforeClass1");
	}
	@BeforeMethod
	public void beforemethod1()
	{
		System.out.println("beforemethod1");
	}
	@Test(groups= {"Smoke"})
	public void iostestcase1()
	{
		System.out.println("iostestcase1");
	}
	
	@Test
	public void iostestcase2()
	{
		System.out.println("iostestcase2");
	}
	
	@Test
	public void iostestcase3()
	{
		System.out.println("iostestcase3");
	}
	
	@AfterMethod
	public void AfterMethod1()
	{
		System.out.println("AfterMethod1");
	}
	@AfterClass
	public void afterclass1()
	{
		System.out.println("afterClass1");
	}
	
	@AfterTest
	public void afterTest1()
	{
		System.out.println("afterTest1");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite1");
	}

	@Test
	public void testnglisternetsfailed()
	{
		Assert.assertTrue(false);
	}

}
