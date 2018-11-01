package basics;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class Tc2 extends Base {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			//AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		
			driver.findElement(By.xpath("//*[@text='Views']")).click();
			
			driver.findElement(By.xpath("//*[@text='Date Widgets']")).click();
			
			driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
			
			driver.findElement(By.xpath("//*[@content-desc='9']")).click();
			
			WebElement we1= driver.findElement(By.xpath("//*[@content-desc='15']"));
			WebElement we2= driver.findElement(By.xpath("//*[@content-desc='45']"));
			
			
			TouchAction t=new TouchAction(driver);
			
			//longpress for 1 second on element 
			//you move to another element - release
			
			//t.longPress(LongPressOptions.longPressOptions().withElement(element(we1)).withDuration(Duration.ofSeconds(2))).moveTo(element(we2)).release().perform();
			
			t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we1)).withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(we2)).release().perform();
			Thread.sleep(4000);
			//driver.quit();
			
	}

	
}
