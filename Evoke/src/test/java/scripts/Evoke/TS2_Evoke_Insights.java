package scripts.Evoke;

import java.util.HashMap;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;

import actions.Actions;
import objectRepository_EvokeApplication.Evoke_ContactUS_Objects;
import objectRepository_EvokeApplication.Evoke_Insights_Objects;
import reusable_Methods.Global;
import utility.Utility;

public class TS2_Evoke_Insights  {


	WebDriver driver;
	ExtentTest logger;
	Global global;
	private Utility utl;
	public static String className;
	

	@BeforeMethod
	public void setup()
	{
		
		utl=new Utility();
		logger=utl.initTest(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1).trim());
		new Actions();
		

	}
	@AfterMethod
	public void tearDown() 
	{

		Utility.report.endTest(logger);
		Utility.report.flush();
	}


	HashMap<String, String> configData=Utility.getConfigData();

	String username=configData.get("UserName");

	String pwd=configData.get("Password");

	HashMap<String, String> testData=Utility.getTestData();
	
	String firstname=testData.get("fname");
	String lastname=testData.get("lname");
	String email=testData.get("Email");
	String phone=testData.get("phone");
	String howcanihelp=testData.get("howcanihelp");
	


	@org.testng.annotations.Test
	public void test() {

		try{	
			//LOGIN
			//Global.login(username,pwd);
			Actions.explicitWait_VisibilityOfElement(Evoke_ContactUS_Objects.deletecookies);
			Actions.click(Evoke_ContactUS_Objects.deletecookies, "click on Contact US Link");
			Actions.moveTo(Evoke_Insights_Objects.Insights, "Move to Insights");
			
			Actions.pause(1);
			
			Actions.click(Evoke_Insights_Objects.casestuides, "click on Case Studies");
			
			Actions.verifytext(Evoke_Insights_Objects.header_CaseStudies, "Learn how we helped global enterprises with our simplified software solutions");
			

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			try{

				//LOGOUT
				//.logOut();

			}
			catch (Exception e) {

			}
			finally{
				//DRIVER CLOSE
				System.out.println("driver close");
				Actions.driverClose();
			}
		}
	}

}
