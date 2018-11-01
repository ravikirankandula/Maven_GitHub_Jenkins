package basics;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class Tc3 extends Base {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			//AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		
			driver.findElement(By.xpath("//*[@text='Views']")).click();
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));");
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Tabs\"))"));
			
			
			
	}

	
}
