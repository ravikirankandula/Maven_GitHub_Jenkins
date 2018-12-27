
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		WebElement Dropdwn=driver.findElement(By.id("continents"));
		
		Select slctdopwn=new Select(Dropdwn);
		
		int size=slctdopwn.getOptions().size();
		
		for(int i=0; i<size; i++)

		{
			String alloptions=slctdopwn.getOptions().get(i).getText();
			
			System.out.println("Drodown options:"+i+alloptions);
			
			if(alloptions.contains("Australia"))
			{
				slctdopwn.selectByIndex(i);
				break;
			}
			

			
		}
		driver.quit();
		
		

	}

}
