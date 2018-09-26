package OR_TransAmerica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	
	WebDriver driver;
	 
	
	/****************Locator***************/
	 public static final By Navbar_Sear=By.xpath("//li[@data-menu='search']");
	 public static final By Srch_query=By.id("nav-search-query1");
	 public static final By srch_Go=By.id("searchBtn");
	 public static final By srch_Results=By.xpath("//h2");

}
