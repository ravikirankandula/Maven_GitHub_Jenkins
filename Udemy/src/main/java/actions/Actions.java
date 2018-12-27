package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilies.BaseUtilities;


public class Actions extends BaseUtilities {
	
	public static WebElement locator,source,destination;
	 
	 public static Logger log4j =  LogManager.getRootLogger();
	 
	 public static ExtentTest logger;
	 
	 public static BaseUtilities utility;
	 
	private static String className, className2;
	
	public Actions()
	{
		utility=new BaseUtilities();
		logger=utility.logger;
		className2 = new Exception().getStackTrace()[1].getClassName();
		this.className= this.className2.substring(this.className2.lastIndexOf(".")+1).trim();
	}
	
	
	public static void click(By by,String description) throws Exception{
		try{
			
			locator = driver.findElement(by);
			locator.click();
			logger.log(LogStatus.INFO, description);
			log4j.info(className2+":"+description);
		}
		catch(Exception e){
		 e.printStackTrace();
	
		 logger.log(LogStatus.FAIL, description+" ->:Exception is :"+e);
		 log4j.error(className2+":"+description);
			throw e;
		}
	}
	
	public static void type(By by,String input, String description) throws Exception{
		try{
			
			locator = driver.findElement(by);
			locator.sendKeys(input);
			logger.log(LogStatus.INFO, description);
			log4j.info(className2+":"+description);
		}
		catch(Exception e){
		 e.printStackTrace();
	
		 logger.log(LogStatus.FAIL, description+" ->:Exception is :"+e);
		 log4j.error(className2+":"+description);
			throw e;
		}
	}

}
