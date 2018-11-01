package basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class APIDEMO extends Base{
	
	
		
		@Test
		public void AndroidTestCase1() throws Exception {
		
		//driver=(AndroidDriver<AndroidElement>) LaunchApp();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Views\"))"));
		
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Views\"))");
		
		
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"android:id/text1\"))"));
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(index(21))"));
		
		driver.findElement(By.xpath("//*[@index='21']")).click();
		
		driver.findElement(By.className("android.widget.TextView")).getText().contains("Views/Popup Menu");
		
		driver.findElement(By.className("android.widget.Button")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(MobileBy.xpath("//*[@resource-id='android:id/title'][@text='Edit']")).click();
		
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Share\")").click();
		
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		
		driver.closeApp();
		
		driver.startActivity(new Activity("com.example.android.apis", ".ApiDemos"));
		
		}
		
		
		
	
		
		
		
	

}
