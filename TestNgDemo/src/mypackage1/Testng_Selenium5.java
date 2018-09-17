package mypackage1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng_Selenium5 {

@Parameters({"url", "username", "pwd"})	
@Test
public void human1(String url1, String username1, String pwd)
{
	System.out.println("Sleeping");
	System.out.println(url1);
	System.out.println(username1);
	System.out.println(pwd);
}

@Test
public void human2()
{
	System.out.println("eating");
}

@Test
public void human3()
{
	System.out.println("dancing");
}

@Test
public void human4()
{
	System.out.println("singing");
}

}
