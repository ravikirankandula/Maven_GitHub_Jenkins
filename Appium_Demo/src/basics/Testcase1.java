package basics;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Testcase1 extends Base{
	
	public static void main(String[] args) throws Exception {
		
		//AndroidDriver<AndroidElement> driver=(AndroidDriver<AndroidElement>) LaunchApp();
		driver.findElementByXPath("//android.widget.textview[@text='Preferences']").click();
		driver.findElementById("checkbox").click();
		driver.findElements(By.className("android.widget.button")).get(1).click();
		driver.findElementByAndroidUIAutomator("(attribute(value))").click();
		//(text(\"views\"))
		
		driver.findElementsByAndroidUIAutomator("new uiSelector.clickable(true)").size();
		
		
		WebElement we1=driver.findElementByAndroidUIAutomator("new uiSelector.clickable(true)");
		
		TouchAction t=new TouchAction(driver);
		//t.tap(TapOptions.tapOptions().withElement(element(we1))).perform();
		
		t.tap(TapOptions.tapOptions().withElement(element(we1))).perform();
		t.longPress(LongPressOptions.longPressOptions().withElement(element(we1)).withDuration(Duration.ofSeconds(3))).release().perform();
		
		
	}

	private static ElementOption element(WebElement we1) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
