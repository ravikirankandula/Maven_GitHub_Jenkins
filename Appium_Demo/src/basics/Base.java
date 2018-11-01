package basics;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	static AndroidDriver<AndroidElement> driver;
	AppiumDriverLocalService service;
	@BeforeSuite
	public void startAppiumServer() throws Exception
	{
		 service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		Thread.sleep(5000);
		//your test scripts logic...
		
	}

	@AfterSuite
	public void stopAppiumServer()
	{
		service.stop();
	}
	@BeforeTest
	public AndroidDriver<AndroidElement> LaunchApp() throws Exception
	{
		
		String filepath=System.getProperty("user.dir");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.FULL_RESET, false);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
		//dc.setCapability(MobileCapabilityType.APP_ACTIVITY, filepath+"\\ApiDemos.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public interface AndroidMobileCapabilityType extends CapabilityType  {
		  
		   String APP_ACTIVITY = "appActivity";
		   String APP_PACKAGE = "appPackage";
		  // String APP_WAIT_ACTIVITY = "appWaitActivity";
	
	}
	
	public static void startactivity(String packname, String activiyname) {
        try {
        	Activity activity = new Activity(packname, activiyname);
            ((AndroidDriver) driver).startActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
