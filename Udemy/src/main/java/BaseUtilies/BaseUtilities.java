package BaseUtilies;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseUtilities {
	
	public static WebDriver driver;
	public static Properties testdata;
	 public static ExtentReports extentreport=null;
	 public static ExtentTest logger,logger2;
	 public static String browser;
	
	private static String RpPath=System.getProperty("user.dir");

	static String time=BaseUtilities.generatetime();
	
	protected static void setDriver(WebDriver driver) {
		BaseUtilities.driver = driver;

	}
	
	@BeforeSuite
	public  void extentreportsintiate()throws Exception
	{
		System.out.println("Intialize all reports");
		extentreport=new ExtentReports(".\\Extent_Logs\\"+generatedate()+"\\extent.html", true);
		
		
	}
	
	@AfterSuite
	public void closeExtentreports()
	{
		
		extentreport.close();
	}


	
	public static WebDriver intialisedriver()throws Exception
	{
		
		
		//System.out.println(".\\TestData.properties");
		
		
		Properties testdata=new Properties();
		testdata.load(new FileInputStream(RpPath+"\\TestData.properties"));
		String browsername=testdata.getProperty("browser");
		System.out.println(browsername);
		if(driver==null) {
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Libs\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\Libs\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else
		{
			System.setProperty("webdriver.gecko.driver", ".\\Libs\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(testdata.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		return driver;
		}
		return driver;
		
	}
	
	public void PropertiesFile_Setup()
	{
		try {
			
		Properties testdata=new Properties();
		 testdata.load(new FileInputStream(RpPath+"\\TestData.properties"));
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public  ExtentTest initTest(String name)
	{

		extentreport.loadConfig(new File(RpPath+"\\Resources\\extent-config.xml"));
		return logger=extentreport.startTest(name);

	}
	
	public static void quitdriver()
	{
	    driver.quit();
	    setDriver(null);
	}
	
	public void waitforelement(By by)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.presenceOfElementLocated((By) by));
	}
	
	public static String generatedate()
	{
		
		DateFormat df= new SimpleDateFormat("dd-MM-yyyy_HH_mm_SS");
		Date dt=new Date();
		String finalDate=df.format(dt);
		System.out.println(finalDate);
		return finalDate;
	}
	
	
	
	public static String generatetime()
	{
		String time;
		DateFormat df= new SimpleDateFormat("HH_mm_SS");
		Date dt=new Date();
		return time=df.format(dt);
		
	}
	
	public void getScreenshot(String Result) throws IOException
	{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshotFile, new File(".\\Screenshots\\"+generatedate()+"_"+Result+"_"+"Screenshot.png"));
		
	}
	
}
