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
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class androidkeyevents extends Base {
	
	public static void main(String[] args) throws Exception {
		
		//AndroidDriver<AndroidElement>driver=(AndroidDriver<AndroidElement>) LaunchApp();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.currentActivity());
		
		System.out.println(driver.getContext());
		
		System.out.println(driver.getOrientation());
		
		System.out.println(driver.isDeviceLocked());
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
	}

}
