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


public class Tc6 extends Base {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//	AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Views\"))"));
			
			driver.findElement(By.xpath("//*[@text='Views']")).click();
			
			int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
			int endX = (int) ((driver.manage().window().getSize().getWidth()) * 0.20);
			
			MobileElement topCharts = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Top Charts']"));
			Point point = topCharts.getLocation();
			int startY = point.y;
			int endY = point.y;

			/*int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
			int endX = (int) ((driver.manage().window().getSize().getWidth()) * 0.20);
*/
			/*TouchAction actions = new TouchAction(driver);
			actions.press(startX, startY).waitAction(Duration.ofSeconds(2)).moveTo(endX, endY).release().perform();*/
			
			
			
	}
	
	
}
