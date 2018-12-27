

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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

public class BrokenLinks {

	
public static void main(String[] args) throws InterruptedException {
	

		
	System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.softwaretestingmaterial.com");
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	List<WebElement> alllinks=driver.findElements(By.tagName("a"));
	
	//ArrayList<WebElement> al= (ArrayList<WebElement>) driver.findElements(By.tagName("a"));
	
	System.out.println(alllinks.size());
	
	for(int i=0; i<=alllinks.size(); i++)
	{
		System.out.println(alllinks.get(i).getText());
		String url=alllinks.get(i).getAttribute("href");
		verifylink(url);
		Thread.sleep(2000);
	}
	
}

public static void verifylink(String url)
{
	try
	{
		URL urllink=new URL(url);
		
		HttpURLConnection connection=(HttpURLConnection)urllink.openConnection();
		
		connection.setConnectTimeout(3000);
		
		connection.connect();
		
		if(connection.getResponseCode()==200)
		{
			System.out.println(urllink+" - "+connection.getResponseMessage());
		}
		if(connection.getResponseCode()==400)
		{
			System.out.println(urllink+" - "+connection.getResponseMessage());
		}
		if(connection.getResponseCode()==500)
		{
			System.out.println(urllink+" - "+connection.getResponseMessage());
		}
		if(connection.getResponseCode()==401)
		{
			System.out.println(urllink+" - "+connection.getResponseMessage());
		}
		if(connection.getResponseCode()==404)
		{
			System.out.println(urllink+" - "+connection.getResponseMessage());
		}
		
	}	
		
	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	

}	
	
}

