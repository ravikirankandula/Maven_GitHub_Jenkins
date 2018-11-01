package basics;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class DragandDrop extends Base {
	
	public static void main(String[] args) throws Exception {
		
		//AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//scrolling
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Views\"))"));
		
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		//longpress - Move to destination - Release it
		Thread.sleep(3000);
		
		
		
		WebElement we1=driver.findElements(By.className("android.view.View")).get(0);
		WebElement we2=driver.findElements(By.className("android.view.View")).get(1);
		
		TouchAction t=new TouchAction(driver);
	
		t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we1)).withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(we2)).release().perform();
		
		//t.longPress(ElementOption.element(we1)).moveTo(ElementOption.element(we2)).release().perform();
		Thread.sleep(3000);
	}

}
