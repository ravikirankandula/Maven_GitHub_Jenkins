package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartupPage  {
	
	public WebDriver driver;
	
	public StartupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By login=By.xpath("//*[contains(text(), 'Login')]");
	
	By feautredcourse=By.xpath("//h2");
	
	By contacttab=By.xpath("//li[8]/a");
	
	By navibar=By.xpath("//li[7/a");
	
	//Contact
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
		
	public WebElement getTitle()
	{
		return driver.findElement(feautredcourse);
	}
	
	public WebElement getcontactTab()
	{
		return driver.findElement(contacttab);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navibar);
	}

}
