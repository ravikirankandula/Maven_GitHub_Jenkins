
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Google {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");
		
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();       
		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver (handlSSLErr);
		//WebDriver driver=new ChromeDriver(handlSSLErr);
		
		driver.get("http://google.com");
		
		
		
		
		//driver.quit();
		
		

	}
	
	public void getScreenshot() throws IOException
	{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
		
	}

}
