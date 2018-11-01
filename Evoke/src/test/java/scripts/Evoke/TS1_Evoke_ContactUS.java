package scripts.Evoke;

import java.util.HashMap;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import actions.Actions;
import objectRepository_EvokeApplication.Evoke_ContactUS_Objects;
import objectRepository_EvokeApplication.Evoke_Insights_Objects;
import reusable_Methods.Global;
import utility.Utility;

public class TS1_Evoke_ContactUS {


	WebDriver driver;
	ExtentTest logger;
	Global global;
	private Utility utl;
	public static String className;
	String clName=this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1).trim()+".";
	

	@BeforeMethod
	public void setup()
	{
		
		utl=new Utility();//logger=utl.initTest(clName+Thread.currentThread().getStackTrace()[1].getMethodName().toString());
		//new Actions();
		
		

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
	


	@Test(priority=1)
	public void testscript1() {

		try{
			
			logger=utl.initTest(clName+Thread.currentThread().getStackTrace()[1].getMethodName().toString());
			new Actions();
			
			//Global.login(username,pwd);
			
			Actions.click(Evoke_ContactUS_Objects.contactus, "click on Contact US Link");
			Actions.explicitWait_VisibilityOfElement(Evoke_ContactUS_Objects.email);
			Actions.type(Evoke_ContactUS_Objects.firstname, firstname, "Enter text in FirstName");
			Actions.type(Evoke_ContactUS_Objects.lastname, lastname, "Enter text in LastName");
			Actions.type(Evoke_ContactUS_Objects.email, email, "Enter text in Email");
			Actions.type(Evoke_ContactUS_Objects.phone, phone, "Enter text in Phone");
			Actions.type(Evoke_ContactUS_Objects.how_can_we_help_, howcanihelp, " Enter text in how can we help ");
			Actions.click(Evoke_ContactUS_Objects.submit, "click on Submit");

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
			@Test(priority=2)
			public void testscript2()
			{
				try{	
					//LOGIN
					//Global.login(username,pwd);
					logger=utl.initTest(clName+Thread.currentThread().getStackTrace()[1].getMethodName().toString());
					new Actions();
					
					Actions.moveTo(Evoke_Insights_Objects.Insights, "Move to Insights");
					
					Actions.pause(1);
					
					Actions.click(Evoke_Insights_Objects.casestuides, "click on Case Studies");
					
					Actions.verifytext(Evoke_Insights_Objects.header_CaseStudies, "Learn how we helped global enterprises with our simplified software solutions");
					

				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			
			finally{
				//DRIVER CLOSE
				System.out.println("driver close");
				Actions.driverClose();
			}
		
	}
	}



