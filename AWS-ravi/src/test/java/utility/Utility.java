package utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import actions.Actions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import resusablemethods.RU_QRProcess;
import testdata.ConfigData;

public class Utility {
	public static AndroidDriver driver;
	Actions act;
	String Addprofile=ConfigData.Addprofile;
	String profileName=ConfigData.Txt_ProfileName;
	String clientID=ConfigData.Txt_ClientID;
	String clientSecret=ConfigData.Txt_ClientSecret;
	String IONAPIHostAdress=ConfigData.Txt_IonApiHostAdress;
	String securityAuth=ConfigData.Txt_SecurityAuthorizationServerAddress;
	String AuthEndpnt=ConfigData.Txt_AuthorizationEndpoint;
	String scrolltext=ConfigData.scrll_text_testconction;
	String tokenEndpnt=ConfigData.Txt_TokenEndpoint;
	String revocationEndpnt=ConfigData.Txt_RevocationEndpoint;
	String TenanatID=ConfigData.Txt_TenantID;
	String EnviornmentVariables=ConfigData.Txt_EnvironmentVariable;
	

	 @BeforeSuite
	    public void setUpAppium() throws MalformedURLException {

	        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	        URL url = new URL(URL_STRING);

	        //Use a empty DesiredCapabilities object
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("autoWebview", false);
	        capabilities.setCapability("setWebContentsDebuggingEnabled", true);
	        capabilities.setCapability("noReset", true);
	        capabilities.setCapability("autoAcceptAlerts", false);
	        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,true);

	        driver = new AndroidDriver<MobileElement>(url, capabilities);

	        //Use a higher value if your mobile elements take time to show up
	        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	        
	    }
	 
	 @AfterSuite
	    public void tearDownAppium() {
	        driver.quit();
	    }
	 
	 
	@BeforeClass
	public void MQRcode()
	{
		new Actions(Utility.driver);
		RU_QRProcess.IonAPI_Setting(Addprofile);
		RU_QRProcess.QRCodeManualEntry(scrolltext, profileName, clientID, clientSecret, IONAPIHostAdress, securityAuth, AuthEndpnt, tokenEndpnt, revocationEndpnt, TenanatID, EnviornmentVariables);
		act.takeScreenshot();
	}
	
	@AfterClass
    public void restartApp() {
        driver.resetApp();
    }
	 
	 
	

}
