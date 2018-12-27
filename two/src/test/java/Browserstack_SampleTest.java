

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browserstack_SampleTest {

	

		public static final String USERNAME = "ravikiran29";
		  public static final String AUTOMATE_KEY = "C4CyWQAT7tbaf8dXn3eT";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		  public static void main(String[] args) throws Exception {

		    DesiredCapabilities caps = new DesiredCapabilities();
		  
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "64");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("resolution", "1366x768");
		    caps.setCapability("browserstack.debug", "true");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    
		    String sessionid=((RemoteWebDriver)driver).getSessionId().toString();
		    System.out.println("Session ID : " +sessionid);
		    
		    driver.get("http://toolsqa.com/automation-practice-form/");
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies();
			
			driver.manage().window().maximize();
			//"""C:\Users\rkandula\Desktop\ImpData.txt"" ""C:\Users\rkandula\Desktop\string.png"""
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			driver.findElement(By.id("photo")).sendKeys("C:\\Users\\rkandula\\Desktop\\ImpData.txt");
			Thread.sleep(3000);
			
			driver.findElement(By.id("tool-0")).click();
			
			driver.quit();
			
			
			
		  }

}
