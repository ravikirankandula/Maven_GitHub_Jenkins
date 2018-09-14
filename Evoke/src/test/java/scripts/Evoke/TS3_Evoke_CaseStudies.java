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
import objectRepository_EvokeApplication.Evoke_Insights_DownloadWhitePaper;
import objectRepository_EvokeApplication.Evoke_Insights_Objects;
import reusable_Methods.Global;
import utility.Utility;

public class TS3_Evoke_CaseStudies  {


	WebDriver driver;
	ExtentTest logger;
	Global global;
	private Utility utl;
	public static String className;
	

	@BeforeMethod
	public void setup()
	{
		System.out.println("2nd test case");
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


	HashMap<String, String> testData=Utility.getTestData();
	
	String whitepaper_name=testData.get("whitepaper_name");
	
	String whitepaper_Email=testData.get("whitepaper_Email");
	
	String whitepaper_phonenumber=testData.get("whitepaper_phonenumber");
	
	String whitepaper_comments=testData.get("whitepaper_comments");
	
	
	@org.testng.annotations.Test
	public void test() {

		try{	
			//LOGIN
			//Global.login(username,pwd);
			
			Actions.moveTo(Evoke_Insights_Objects.Insights, "Move to Insights");
			
			Actions.pause(1);
			
			Actions.click(Evoke_Insights_Objects.casestuides, "click on Case Studies");
			
			Actions.explicitWait_VisibilityOfElement(Evoke_Insights_DownloadWhitePaper.downloadwhitepaperlink);
			
			Actions.moveTo(Evoke_Insights_DownloadWhitePaper.downloadwhitepaperlink, " Move to whitepaper under link");
			
			Actions.click(Evoke_Insights_DownloadWhitePaper.downloadwhitepaperlink, "click on whitepaper under link");
			
			Actions.waitfortextpresent(Evoke_Insights_DownloadWhitePaper.fillupformheader, "Please fill-up the form to download our White Paper");
			
			Actions.type(Evoke_Insights_DownloadWhitePaper.txtname, whitepaper_name, " Enter text name ");
			 
			Actions.type(Evoke_Insights_DownloadWhitePaper.txtemail, whitepaper_Email, "Enter text email");
			
			Actions.type(Evoke_Insights_DownloadWhitePaper.txtphne, whitepaper_phonenumber, "Enter text phone");
			
			Actions.type(Evoke_Insights_DownloadWhitePaper.txtarea, whitepaper_comments, "Enter text area");
			
			Actions.click(Evoke_Insights_DownloadWhitePaper.fillup_submit, "click on Submit button");
			
			Actions.pause(3);
			

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
