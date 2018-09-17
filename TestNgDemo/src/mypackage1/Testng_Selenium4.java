package mypackage1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_Selenium4 {
	
	@Test(priority=2)
	public void cars1()
	{
		System.out.println("cars1");
	}
	
	@Test(dependsOnMethods= {"cars3"})
	public void cars2()
	{
		System.out.println("cars2");
	}
	
	@Test(dependsOnMethods= {"cars1"})
	public void cars3()
	{
		System.out.println("cars3");
	}
	
	@Test(priority=1)
	public void cars4()
	{
		System.out.println("cars4");
	}
	
	@Test(timeOut=5000)
	public void cars6()
	{
		System.out.println("cars6");
	}
	@Test(enabled=false)
	public void cars5()
	{
		System.out.println("cars5");
	}
	
	

}
