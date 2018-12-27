package basics;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class Tc4 extends Base {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			//AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Views\"))"));
			
			driver.findElement(By.xpath("//*[@text='Views']")).click();
			
			driver.findElement(By.xpath("//*[@text='Date Widgets']")).click();
			
			driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
			
			driver.findElement(By.xpath("//*[@content-desc='9']")).click();
			
		driver.getContext();
	
			
			WebElement we1= driver.findElement(By.xpath("//*[@content-desc='15']"));
			WebElement we2= driver.findElement(By.xpath("//*[@content-desc='45']"));
			
			
			Point p=driver.findElement(By.xpath("//*[@content-desc='15']")).getLocation();
			
			System.out.println(p.x);
			System.out.println(p.y);
			
			TouchAction t=new TouchAction(driver);
			
			//longpress for 1 second on element 
			//you move to another element - release
			
			//t.longPress(LongPressOptions.longPressOptions().withElement(element(we1)).withDuration(Duration.ofSeconds(2))).moveTo(element(we2)).release().perform();
			
			t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we1)).withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(we2)).release().perform();
			Thread.sleep(4000);
			 
			/*startactivity("com.example.android.apis", ".os.TriggerSensors");
			
			driver.startActivity(new Activity("com.example.android.apis", ".os.TriggerSensors"));*/
			
		
			
			//driver.quit();
			
	}

	
}
