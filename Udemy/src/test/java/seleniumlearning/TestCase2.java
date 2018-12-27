package seleniumlearning;

import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentTest;

import BaseUtilies.BaseUtilities;
import actions.Actions;
import pageObjects.LoginPage;

public class TestCase2  {

	ExtentTest loggertest;
	private BaseUtilities base;
	

	@BeforeClass
	public void browsersetup() throws Exception
	{
		
        base=new BaseUtilities();
        base.intialisedriver();
        

	}

	@Test
	public void testcase()
	{
		try {

			loggertest=base.initTest(this.getClass().getName());
			new Actions();
			Actions.type(LoginPage.obj_searchtextbox, "ravi", "Entered text in searchbox");
			Actions.click(LoginPage.obj_googlesearchbtn, "click on googlesearchbutton");
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testcase2()
	{
		try {

			loggertest=base.initTest(this.getClass().getName());
			new Actions();
			Actions.type(LoginPage.obj_searchtextbox, "kiran", "Entered text in searchbox");
			Actions.click(LoginPage.obj_googlesearchbtn, "click on googlesearchbutton");
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			BaseUtilities.quitdriver();
		}
	}

	@AfterMethod
	public void teardown()
	{
		BaseUtilities.extentreport.endTest(loggertest);
		BaseUtilities.extentreport.flush();
	}
}
