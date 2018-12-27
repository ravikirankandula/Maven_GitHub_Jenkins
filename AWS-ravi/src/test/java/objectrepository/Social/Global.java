/**
 * 
 */
package objectrepository.Social;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Actions;
import io.appium.java_client.android.AndroidDriver;
import testdata.ConfigData;


public class Global {
	
	public static WebDriverWait wait;
	static int count = 1;
	static AndroidDriver driver;
	
	public Global(AndroidDriver driver)
	{
		this.driver=driver;
	
	}
	

	public static void login_Env(String usrname, String pwd) {
		//HashMap<String, String> testData = Utility.getConfigData();
		String env = ConfigData.ENVIRONMENT;
		System.out.println(env);
		switch (env) {

		case "CLOUD": {
			Actions.Mobile_waitforelement(POM_Loginpage.signinbtn);
			Actions.click(POM_Loginpage.signinbtn);
			Actions.Mobile_waitforelement(POM_Loginpage.cloudsigninbtn);
			Actions.Mobile_waitforelement(POM_Loginpage.cluduname);
			Actions.Mobile_waitforelement(POM_Loginpage.cludupwd);
			Actions.click(POM_Loginpage.cluduname);
			Actions.type(POM_Loginpage.cluduname, usrname);
			Actions.type(POM_Loginpage.cludupwd, pwd);
			Actions.click(POM_Loginpage.cloudsigninbtn);
			Actions.Mobile_waitforelement(POM_Loginpage.Allow);
			Actions.Mobile_swipeBottomtoTop();
			Actions.click(POM_Loginpage.Allow1);
//			if (Actions.verifyElementPresent(POM_Loginpage.errormessage)) {
//				Actions.click(POM_Connections.ok);
//				Actions.Mobile_waitforelement(POM_Loginpage.signinbtn);
//				Actions.click(POM_Loginpage.signinbtn);
//				Actions.Mobile_waitforelement(POM_Loginpage.cloudsigninbtn);
//				Actions.Mobile_waitforelement(POM_Loginpage.cluduname);
//				Actions.Mobile_waitforelement(POM_Loginpage.cludupwd);
//				Actions.click(POM_Loginpage.cluduname);
//				Actions.type(POM_Loginpage.cluduname, usrname);
//				Actions.type(POM_Loginpage.cludupwd, pwd);
//				Actions.click(POM_Loginpage.cloudsigninbtn);
////				Actions.Mobile_waitforelement(POM_Loginpage.dontAllow, "Wait for Allow");
//				Actions.Mobile_scrolltoexact("Allow");
//				Actions.click(POM_Loginpage.Allow);
//
//			}
			Actions.Mobile_waitforelement(POM_Loginpage.srchtextbox);
			break;
		}
		case "OP": {
			Actions.Mobile_waitforelement(POM_Loginpage.signinbtn);
			Actions.click(POM_Loginpage.signinbtn);
			if (Actions.verifyElementPresent(POM_Loginpage.continu)) {
				Actions.click(POM_Loginpage.continu);
				if (Actions.verifyElementPresent(POM_Loginpage.continu)) {
					Actions.click(POM_Loginpage.continu);
				}
			}
			Actions.Mobile_waitforelement(POM_Loginpage.op);
			Actions.click(POM_Loginpage.op);
			Actions.Mobile_waitforelement(POM_Loginpage.opsigninbtn);
			Actions.Mobile_waitforelement(POM_Loginpage.opuname);
			Actions.Mobile_waitforelement(POM_Loginpage.oppwd);
			Actions.click(POM_Loginpage.opuname);
			Actions.type(POM_Loginpage.opuname, usrname);
			Actions.type(POM_Loginpage.oppwd, pwd);
			Actions.Mobile_AKC_Enter();
			// Utility.getDriver().tap(1, 1000, 1690, 2000);

			//Actions.Mobile_waitforelement(POM_Loginpage.dontAllow, "Wait for Allow");
			Actions.Mobile_scrolltoexact("Allow");
			Actions.click(POM_Loginpage.Allow);
			if (Actions.verifyElementPresent(POM_Loginpage.errormessage)) {
				Actions.click(POM_Connections.ok);
				Actions.Mobile_waitforelement(POM_Loginpage.signinbtn);
				Actions.click(POM_Loginpage.signinbtn);
				Actions.Mobile_waitforelement(POM_Loginpage.op);
				Actions.click(POM_Loginpage.op);
				Actions.Mobile_waitforelement(POM_Loginpage.opsigninbtn);
				Actions.Mobile_waitforelement(POM_Loginpage.opuname);
				Actions.Mobile_waitforelement(POM_Loginpage.oppwd);
				Actions.click(POM_Loginpage.opuname);
				Actions.type(POM_Loginpage.opuname, usrname);
				Actions.type(POM_Loginpage.oppwd, pwd);
				Actions.Mobile_AKC_Enter();
				// Utility.getDriver().tap(1, 1000, 1690, 2000);

				//Actions.Mobile_waitforelement(POM_Loginpage.dontAllow, "Wait for Allow");
				Actions.Mobile_scrolltoexact("Allow");
				Actions.click(POM_Loginpage.Allow);
			}

			Actions.Mobile_waitforelement(POM_Loginpage.srchtextbox);
			Actions.pause(2);
			break;
		}

		default: {
			try {
				// throwing user defined custom exception
				throw new Exception("Value of ENVIRONMENT is not Set properly."
						+ "\nYou have set ENVIRONMENT=" + ConfigData.ENVIRONMENT
						+ ".\nKindly set ENVIRONMENT=CLOUD or ENVIRONMENT=OP in the config.Properties File");

			} catch (Exception exp) {
				exp.printStackTrace();
				
				System.exit(1);
			}
		}
		}

	}

	

}
