package scripts.america_Srch;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentTest;

import RM_TransAmerica.TransAmerica_Search;
import actions.Actions;
import objRepository.Global;

import utility.Utility;

public class Ts1_Serach {
	
	ExtentTest logger;
	private Utility utl;
	 HashMap<String, String> testData=Utility.getTestData();
	 HashMap<String, String> configData=Utility.getConfigData();
		
		/*//TESTDATA
		 String userName=configData.get("USER5");	
		 String pwd=configData.get("PASSWORD");
		 String appName=testData.get("TD_ADMIN_TESTAPP");
		 String url=testData.get("UTLITYAPP_URL");
		 String applicationName=appName+RandomStringUtils.randomNumeric(3);*/
	 
	 String srchword=testData.get("src_string");
		
			
	
	@BeforeClass
	public void setUp()
	{
		 utl=new Utility();
		 logger=utl.initTest(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1).trim());
		 new Actions();
	
	}
	@AfterClass
	public void tearDown()
	{
		Utility.report.endTest(logger);
		//Actions.driverClose();
	
	}
	
	


	@org.testng.annotations.Test(priority =1)
	public void create_App(){
		try {
			
			//LOGIN
			TransAmerica_Search.Serach(srchword);
			
			
			//Global.logOut();
		} catch (Exception e) {
			
		}finally
		{
		
			Actions.driverClose();
		}
	}
	

}
