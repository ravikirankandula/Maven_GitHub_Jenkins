package basics;


import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class Tc6_BrowserChromeAutomtate extends Base2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			driver.get("https://www.google.com");
			driver.findElement(By.name("q")).sendKeys("appium");
			
	}
	
	
}
