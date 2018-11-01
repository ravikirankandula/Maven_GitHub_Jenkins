package basics;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base2 {

	static AppiumDriver<AndroidElement> driver;
	public static AppiumDriver<AndroidElement> LaunchApp() throws MalformedURLException {
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.FULL_RESET, false);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");  
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		return driver;
		
	}
	
	
	
}
