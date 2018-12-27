

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.mail.iap.Argument;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class elementhighlight {

	
public static void main(String[] args) throws InterruptedException {
	

		
	System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.gmail.com");
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	driver.manage().deleteAllCookies();
	
	driver.manage().window().maximize();
	
	WebElement usname=driver.findElement(By.id("identifierId"));
	
	driver.findElement(By.id("identifieid"));
	
	highlightelement(driver, usname);
	usname.clear();
	usname.sendKeys("ravi");
	
	Thread.sleep(3000);
	WebElement next=driver.findElement(By.id("identifierNext"));
	
	highlightelement(driver, next);
	next.click();
	
}

public static void highlightelement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js= (JavascriptExecutor)driver;
    js.executeScript("arguments[0].setAttribute('style', 'background:yellow; boarder:2px solid red;');", element);	
		
}
}
