
package actions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Utility;

public  class Actions extends Utility{
	
	public static ExtentTest logger;
	 public static ExtentReports report=Utility.report;
	 public static Utility utility;
	 static WebElement locator,source,destination;
	 public static boolean makeConnection=false,AcceptConnection=false,postMessage;
	 
		static String text1;
		public static Logger log4j =  LogManager.getRootLogger(); 
		private static String className, className2; 
	public Actions(){
		utility=new Utility();
		logger=utility.logger;
		postMessage=false;
		 className2 = new Exception().getStackTrace()[1].getClassName();
			this.className= this.className2.substring(this.className2.lastIndexOf(".")+1).trim(); 
	 }
 
public static WebElement fluentWait(WebDriver driver, final By locator, int timeoutSeconds,int pollingIntervalSeconds) {
    WebElement foo=null;
    try {
          Wait<WebDriver> wait =
                  new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                  .ignoring(Throwable.class)
                      .pollingEvery(pollingIntervalSeconds, TimeUnit.SECONDS);
                      
                      /*.ignoring(org.openqa.selenium.NoSuchElementException.class)
                      .ignoring(org.openqa.selenium.TimeoutException.class)
                      .ignoring(org.openqa.selenium.StaleElementReferenceException.class)*/
                      
              
               foo = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                  return driver.findElement(locator);
                }
              });
              
              return foo;
    } catch (Exception e) {
         
          return foo;
    	}
    }
      
	  public static void explicitWait_VisibilityOfElement(By by){
 	 		WebDriverWait wait = new WebDriverWait(Utility.getDriver(), 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
 	 	}
	  
	  public static void waitfortextpresent(By by, String text){
	 		WebDriverWait wait = new WebDriverWait(Utility.getDriver(), 20); 
			wait.until(ExpectedConditions.textToBe(by,text));
			
	 	}

	public static void click(By by,String description){
		try{
			 fluentWait(Utility.getDriver(), by, 30, 1);
			locator = Utility.getDriver().findElement(by);
			explicitWait_VisibilityOfElement(by);
			locator.click();
			logger.log(LogStatus.INFO, description);
			log4j.info(className+":"+description);
		}
		catch(Exception e){
		 e.printStackTrace();
	
		 logger.log(LogStatus.FAIL, description+" ->:Exception is :"+e+Utility.appendScreenshot());
						log4j.error(className+":" +description);
			throw e;
		}
	}
	// Use ful for Roll Back Methods
	public static void click1(By by,String description){
		try{
			 fluentWait(Utility.getDriver(), by, 20, 1);
			Utility.getDriver().findElement(by).click();
			logger.log(LogStatus.INFO, description);
			log4j.info(className+":"+description);
		}
		catch(Exception e){
			log4j.error(className+"-> Exception is :"+e);
		}
	}
	public  static void type(By by,String input,String description){
		try{
			 fluentWait(Utility.getDriver(), by, 20, 1);
			locator = Utility.getDriver().findElement(by);
			explicitWait_VisibilityOfElement(by);
			locator.sendKeys(input);
			logger.log(LogStatus.INFO, description+":"+input);
			log4j.info(className+":"+ description+":"+input);
		}
		catch(Exception e){
		 e.printStackTrace();	
		 logger.log(LogStatus.FAIL, description+" ->:Exception is :"+e+Utility.appendScreenshot());
		 log4j.error(className+":"+description);
		
		 throw e;
		}
	}
	public static boolean isEnabled(By by,String description)
	{
		try{
			fluentWait(Utility.getDriver(), by, 10, 1);
			
			Utility.getDriver().findElement(by).isEnabled();
			
				logger.log(LogStatus.INFO, description+" ->: True");
				log4j.info(className+":"+description+" ->: True");
				return true;
		}
		catch(Exception e){
			// e.printStackTrace();		
			log4j.info(className+":"+description+" ->: False");
			 logger.log(LogStatus.INFO, description+" ->: False");
			 
			
			 
			 return false;
		}
	}
	// Use Below Method only inside IF Condition
	public static boolean Verify_ElementPresent(By by,String description)
	{
		try{
			fluentWait(Utility.getDriver(), by, 10, 1);
			
			Utility.getDriver().findElement(by).isDisplayed();
			
				logger.log(LogStatus.INFO, description+" ->: True");
				log4j.info(className+": PASS :- "+description+" ->: True");
				return true;
		}
		catch(Exception e){
			// e.printStackTrace();		
			log4j.info(className+": FAIL :- "+description+" ->: False"); 
			 logger.log(LogStatus.INFO, description+" ->: False");
			 
			
			 
			 return false;
		}
	}
	 //Used to verify the Text inside a Locator with the Expected value
	public static void verifytext(By locator,String expected){
		String actval=null;
	try {
			
		actval=Utility.getDriver().findElement(locator).getText();
			Assert.assertTrue(actval.contains(expected));
			logger.log(LogStatus.PASS, "PASS :- Expected is :"+expected+" And Found is :"+actval);
			log4j.info(className+":"+"PASS: Expected is :"+expected+" And Found is :"+actval);
			} catch (Throwable e) {
				logger.log(LogStatus.FAIL, "Expected is :"+expected+" But Found :"+actval+Utility.appendScreenshot());
				 log4j.error(className+":"+"FAIL:- Expected is :"+expected+" But Found :"+actval);
				 throw e;
			}
	}
	// It is Useful to verify the given Object available or not in the Web page.
	public static void verifyElementDisplayed(By by,String comments){
		
	try {
			fluentWait(Utility.getDriver(), by, 10, 1);
			explicitWait_VisibilityOfElement(by);
			Assert.assertTrue(Utility.getDriver().findElement(by).isDisplayed());
			logger.log(LogStatus.PASS, "PASS :- The Object '"+comments+"' is displayed.");
			log4j.info(className+":"+"The Object '"+comments+"' is displayed.");
			} catch (Throwable e) {
				logger.log(LogStatus.FAIL, "The Object '"+comments+"' is NOT displayed."+Utility.appendScreenshot());
				 log4j.error(className+":"+"FAIL :- The Object '"+comments+", is NOT displayed.");
				 throw e;
			}
	}
	// Used to compare Two String Values
	public static void verifyString(String actual,String expected){
		
		
	try {
			
		Assert.assertTrue(actual.contains(expected));
			logger.log(LogStatus.PASS, "Expected is :"+expected+" And Found is :"+actual);
			log4j.info(className+":"+"PASS :- Expected is :"+expected+" And Found is :"+actual);
			} catch (Throwable e) {
				logger.log(LogStatus.FAIL, "Expected is :"+expected+" But Found :"+actual+Utility.appendScreenshot());
				 log4j.error(className+":"+"FAIL :- Expected is :"+expected+" But Found :"+actual);
				 throw e;
			}
	}
		public static String getText(By by){
		try{
			 fluentWait(Utility.getDriver(), by, 30, 1);
				explicitWait_VisibilityOfElement(by);
			locator = Utility.getDriver().findElement(by);
		
			 text1=locator.getText();
			 log4j.info(className+"Retrived Text Value :"+text1);
			logger.log(LogStatus.INFO, "Retrived Text Value :"+text1);
		}
		catch(Exception e){
		 e.printStackTrace();
	
		 logger.log(LogStatus.FAIL, text1+" ->:Exception is :"+e+Utility.appendScreenshot());
		 log4j.error(className+":"+text1+" ->:Exception is :"+e);
			
			throw e;
		}
		return text1;
	}
	
	
	public static String getTitle()
	{
		String title = Utility.getDriver().getTitle();
		logger.log(LogStatus.INFO, title);
		log4j.info(className+":"+title);
		return title;
	}
	
	
	public static void pause(double d)
	{
		try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			
			
		}
	}
	
	
	
	
	 /****************Driver Closer***************/
	 public static void driverClose(){
		// Utility.getDriver().close();
		
		 Utility.getDriver().quit();
		setDriver(null);
	 }               
	
      public static void switchtoFrame(By by,String description){
    	  try{
 			 fluentWait(Utility.getDriver(), by, 20, 1);
 			locator = Utility.getDriver().findElement(by);
 			Utility.getDriver().switchTo().frame(locator);
 			logger.log(LogStatus.INFO, description);
 			log4j.info(className+":"+description);
 		}
 		catch(Exception e){
 		 e.printStackTrace();
 	
 		 logger.log(LogStatus.FAIL, description+" ->:Exception is :"+e+Utility.appendScreenshot());
 			
	 			log4j.error(className+":"+description+" ->:Exception is :"+e);
	 			throw e;
 		}
    	  
      }
      public static void switchToDefaultContent(){
    	  try{
 			 //fluentWait(Utility.getDriver(), 10, 1);
    		  Utility.getDriver().switchTo().defaultContent();
 			
 		}
 		catch(Exception e){
 		 e.printStackTrace();
 	
 		 logger.log(LogStatus.FAIL, " The Exception in switchtoDefaultContent is :"+e+Utility.appendScreenshot());
 			throw e;
 			
 		}
      }
      
      
      public static void space(){
    	  org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions( Utility.getDriver());
    	  action.sendKeys(Keys.SPACE).build().perform();
      }
      public static void enter(){
    	  org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions( Utility.getDriver());
    	  action.sendKeys(Keys.ENTER).build().perform();
      }
      
      public static void esc(){
    	  org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions( Utility.getDriver());
    	  action.sendKeys(Keys.ESCAPE).perform();
      }
      
      public static void tab(){
    	  org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions( Utility.getDriver());
    	  action.sendKeys(Keys.TAB).perform();
      }
      /****************Drag And Drop***************/
 	 
 	 public static void dragAndDrop(By singleLineText,By singleLineTextDestination,String desc){
 		 try{
 		 source=Utility.getDriver().findElement(singleLineText);
 		 destination=Utility.getDriver().findElement(singleLineTextDestination);
 		 org.openqa.selenium.interactions.Actions  builder = new org.openqa.selenium.interactions.Actions(Utility.getDriver());
 	        Action dragAndDrop = builder.clickAndHold(source)
 	            .moveToElement(destination)
 	            .release(destination)
 	            .build();
 	        dragAndDrop.perform(); 
 	        logger.log(LogStatus.INFO, desc);
 	       log4j.info(className+":"+desc);
 		 }
 		 catch (Exception e) {
 			// TODO: handle exception
	 			log4j.error(className+":"+desc+" ->:Exception is :"+e+Utility.appendScreenshot());
 			 logger.log(LogStatus.FAIL, desc+" ->:Exception is :"+e);
 	 			
 	 			throw e;
 		}
 	        
 	 }
 	 
 	   /****************Move To Element***************/
 	 
 	 	 public static void moveTo(By singleLineTextDestination,String desc){
 	 		 try{
 	 		
 	 			destination=Utility.getDriver().findElement(singleLineTextDestination);
 	 			org.openqa.selenium.interactions.Actions ass = new org.openqa.selenium.interactions.Actions(Utility.getDriver());
				ass.moveToElement(destination).build().perform();

 
 	 	      logger.log(LogStatus.INFO, desc);
 	 	    log4j.info(className+":"+desc);
 	 		 }
 	 		 catch (Exception e) {
 	 			// TODO: handle exception
  	 			log4j.error(className+":"+desc+" ->:Exception is :"+e+Utility.appendScreenshot());
 	 			 logger.log(LogStatus.FAIL, desc+" ->:Exception is :"+e);
 	 	 		
 	 	 			throw e;
 	 		}
 	 	        
 	 	 }

 	 	 public static void action_click(By singleLineTextDestination,String desc){
 	 		 try{
 	 		
 	 			destination=Utility.getDriver().findElement(singleLineTextDestination);
 	 			org.openqa.selenium.interactions.Actions ass = new org.openqa.selenium.interactions.Actions(Utility.getDriver());
				ass.moveToElement(destination).click().build().perform();
				
 
 	 	      logger.log(LogStatus.INFO, desc);
 	 	    log4j.info(className+":"+desc);
 	 		 }
 	 		 catch (Exception e) {
 	 			// TODO: handle exception
  	 			log4j.error(className+":"+desc+" ->:Exception is :"+e+Utility.appendScreenshot());
 	 			 logger.log(LogStatus.FAIL, desc+" ->:Exception is :"+e);
 	 	 		
 	 	 			throw e;
 	 		}
 	 	        
 	 	 }
		 /****************Double Click**************/
 	 	 
 	 	 public static void dblClick(By source,String desc){
 	 		 try{
 	 			explicitWait_VisibilityOfElement(source);
 	 			destination=Utility.getDriver().findElement(source);
 	 			org.openqa.selenium.interactions.Actions ass = new org.openqa.selenium.interactions.Actions(Utility.getDriver());
				ass.moveToElement(destination).doubleClick().build().perform();

 
 	 	      logger.log(LogStatus.INFO, desc);
 	 	    log4j.info(className+":"+desc);
 	 		 }
 	 		 catch (Exception e) {
 	 			// TODO: handle exception
  	 			log4j.error(className+":"+desc+" ->:Exception is :"+e+Utility.appendScreenshot());
 	 			 logger.log(LogStatus.FAIL, desc+" ->:Exception is :"+e);
 	 	 		
 	 	 			throw e;
 	 		}
 	 	        
 	 	 }
 	 	 
 	 	  /****************Select***************/
 	 	 
 	 	 public static void select(By singleLineTextDestination,String val,String desc){
 	 		 try{
 	 		
 	 			destination=Utility.getDriver().findElement(singleLineTextDestination);
 	 			Select dropdown= new Select(destination);
 	 			dropdown.selectByVisibleText(val);
 
 	 	      logger.log(LogStatus.INFO, desc+val);
 	 	    log4j.info(className+":"+desc+val);
 	 		 }
 	 		 catch (Exception e) {
 	 			// TODO: handle exception
 	 			log4j.error(className+":"+desc+val+" ->:Exception is :"+e+Utility.appendScreenshot());
 	 			 logger.log(LogStatus.FAIL, desc+val+" ->:Exception is :"+e);
 	 	 			
 	 	 			throw e;
 	 		}
 	 	        
 	 	 }
 	 	//Use this method for MultiUser Scripts to End The report
 	   //Best Practice Use this method inside @AfterClass
 	 	public static void endScriptReportMU()
 	 	{
 	 		 Utility.report.endTest(logger);
             Utility.report.flush();
 	 	}
 	 	//Use this method for MultiUser Scripts to LogOut & Close Driver Instance
 	   //Best Practice Use this method inside @AfterClass
 	 	
 	 	
       
 	 	public static List<WebElement> findElements(By locator)
 	 	{
 	 		List<WebElement> we=Utility.getDriver().findElements(locator);
 	 		return we;
 	 	}
 	 	public static String getAttribute(By by,String attr)
 	 	{
 	 		try{
 	 		fluentWait(Utility.getDriver(),by,10,1);
 	 		logger.log(LogStatus.INFO, "Getting "+attr+" Value");
 	 	    log4j.info(className+":"+"Getting "+attr+" Value");
 	 		return Utility.getDriver().findElement(by).getAttribute(attr).trim();
 	 		}catch(Exception e)
 	 		{
 	 			logger.log(LogStatus.FAIL, "Got Error while Getting "+attr+" Value");
 	 	 	    log4j.error(className+":"+"Got Error while Getting "+attr+" Value");
 	 			throw e;
 	 		}
 	 	}
 	 	public static String getParentWindowID()
 	 	{
 	 		return Utility.getDriver().getWindowHandle();
 	 	}
 	 	public static String getChildWindowID(String pid)
 	 	{
 	 		Set<String> wids = Utility.getDriver().getWindowHandles();
 	 		String cid = null;
 	 		for(String s:wids)
 	 		{
 	 			if(pid!=s)
 	 				cid=s;
 	 		}
 	 		return cid;
 	 	}
 	 	public static void switchToWindow(String s)
 	 	{
 	 		
 	 		Utility.getDriver().switchTo().window(s); 	
 	 	}
 	 	//Append
 	 	public static String append(By by,String val,String description){
            try{
                   fluentWait(Utility.getDriver(), by, 20, 1);
                   locator = Utility.getDriver().findElement(by);
                   
                   text1=locator.getText();
                   StringBuffer sb=new StringBuffer(text1); 
                    String s=sb.append(val).toString();
                   locator = Utility.getDriver().findElement(by);
                         locator.sendKeys(s);
                   log4j.info(className+":"+text1+s,description);
                   logger.log(LogStatus.INFO, text1+s,description);
            }
            catch(Exception e){
            e.printStackTrace();
     
            logger.log(LogStatus.FAIL, text1+" ->:Exception is :"+e+Utility.appendScreenshot());
            log4j.error(className+":"+text1+" ->:Exception is :"+e);
                   
                   throw e;
            }
            return text1;
     }
 	 	public static void clearText(By by, String comments)
 	 	{
 	 		try{
 	 		 fluentWait(Utility.getDriver(), by, 20, 1);
 	 		Utility.getDriver().findElement(by).clear();
 	 		log4j.info(className+":"+comments);
            logger.log(LogStatus.INFO, comments);
 	 		}catch(Exception e)
 	 		{
 	 			logger.log(LogStatus.FAIL,  "->:Exception is :"+e+Utility.appendScreenshot());
 	            log4j.error(className+":"+" ->:Exception is :"+e);
 	           throw e;
 	 		}
 	 	}
 	 	public static void verifyTextNotPresent(By by, String expected)
 	 	{
 	 		String actual = "dummy";
 	 		try {
 	 			try{
 				fluentWait(Utility.getDriver(), by, 10, 1);
 				actual=Utility.getDriver().findElement(by).getText().trim();
 				}catch(Throwable e)
 				{
 				  
 				}
 				Assert.assertFalse(actual.contains(expected));
 				logger.log(LogStatus.PASS, "The Object '"+expected+"' is NOT displayed.");
 				log4j.info(className+":"+"The Object '"+expected+"' is NOT displayed.");
 				} catch (Throwable e) {
 					logger.log(LogStatus.FAIL, "The Object '"+expected+"' is displayed."+Utility.appendScreenshot());
 					log4j.error(className+":"+"The Object '"+expected+", is displayed.");
 					 throw e;
 				}
 		}
 	 	public static void verifyElementNotPresent(By by, String comments)
 	 	{
 	 		
 	 		
 	 			try{
 				fluentWait(Utility.getDriver(), by, 10, 1);
 				Assert.assertTrue(Utility.getDriver().findElement(by).isDisplayed());
 				logger.log(LogStatus.FAIL, "The Object '"+comments+"' is displayed."+Utility.appendScreenshot());
					log4j.error(className+":"+"The Object '"+comments+", is displayed.");
 				
 				}catch(Throwable e)
 				{
 					logger.log(LogStatus.PASS, "The Object '"+comments+"' is NOT displayed.");
 	 				log4j.info(className+":"+"The Object '"+comments+"' is NOT displayed.");
 	 				
 				}
 				/*Assert.assertFalse(actual.contains(expected));
 				} catch (Throwable e) {
 					logger.log(LogStatus.FAIL, "The Object '"+expected+"' is displayed."+Utility.appendScreenshot());
 					log4j.error(className+":"+"The Object '"+expected+", is displayed.");
 					 throw e;
 				}*/
 		}
 	 	public static void verifyElementNotPresent1(By by, String expected)
 	 	{
 	 		//String actual = "dummy";
 	 		try {
 	 			
 	 			try{
 				fluentWait(Utility.getDriver(), by, 10, 1);
 				List<WebElement> l=Utility.getDriver().findElements(by);
 				for(WebElement we:l)
 				{
 					if(we.getText().contains(expected))
 					{
 						Assert.assertTrue(false);
 					}
 				}
 				//Assert.assertFalse(Utility.getDriver().findElement(by).isDisplayed());
 				}catch(NoSuchElementException e)
 				{
 				  
 				}
 				
 				logger.log(LogStatus.PASS, "The Object '"+expected+"' is NOT displayed.");
 				log4j.info(className+":"+"The Object '"+expected+"' is NOT displayed.");
 				} catch (Throwable e) {
 					logger.log(LogStatus.FAIL, "The Object '"+expected+"' is displayed."+Utility.appendScreenshot());
 					log4j.error(className+":"+"The Object '"+expected+", is displayed.");
 					 throw e;
 				}
 		}
 	 		
 	 public static void scrollToElement(By by)
 	 {
 		 try{
 			 pause(0.5);
 		fluentWait(Utility.getDriver(), by, 10, 1);
 		WebElement element = Utility.getDriver().findElement(by);
 		((JavascriptExecutor) Utility.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
 		log4j.info(className+":"+"Scroll to the Desired Location");
 		 }
 		 catch(Throwable t)
 		 {
 			log4j.error(className+":"+"Scroll to the Desired Location is failed due to :"+t);
 			logger.log(LogStatus.FAIL, "The Exception While Scroll is :"+t+Utility.appendScreenshot());
 		 }
 	 }

 	 	 static String optTxt;
 		public static String getList(By by)
 	 	{
 	 		try{
 	 		 fluentWait(Utility.getDriver(), by, 20, 1);
 	 		
 	 		 WebElement el=Utility.getDriver().findElement(by);
 	 	    List<WebElement> options =el.findElements(By.tagName("option"));
 	 	    System.out.println(options.size());
 	 	    for(WebElement option : options){
 	 	         optTxt = option.getText();
 	 	      /*  System.out.println(optTxt);
 	 	        if(optTxt.contains(partialText)){
 	 	        	System.out.println(option+"In the for loop");
 	 	            option.click();
 	 	            break;
 	 	        }*/
 	 	    }
 	 		log4j.info(className+":"+optTxt);
            logger.log(LogStatus.INFO, optTxt);
 	 		}catch(Exception e)
 	 		{
 	 			logger.log(LogStatus.FAIL,  "->:Exception is :"+e+Utility.appendScreenshot());
 	            log4j.error(className+":"+" ->:Exception is :"+e);
 	           throw e;
 	 		}
			return optTxt;
 	 	}
 		
 		  /****************selectByIndex ***************/
	 	 
	 	 public static void selectByIndex(By singleLineTextDestination,String desc){
	 		 try{
	 		
	 			destination=Utility.getDriver().findElement(singleLineTextDestination);
	 			Select dropdown= new Select(destination);
	 			dropdown.selectByIndex(2);

	 	      logger.log(LogStatus.INFO, desc);
	 	    log4j.info(className+":"+desc);
	 		 }
	 		 catch (Exception e) {
	 			// TODO: handle exception
	 			log4j.error(className+":"+desc+" ->:Exception is :"+e+Utility.appendScreenshot());
	 			 logger.log(LogStatus.FAIL, desc+" ->:Exception is :"+e);
	 	 			
	 	 			throw e;
	 		}
	 	        
	 	 }
	 	 public static void makeElementVisible(String displayValue, By elementLocation)
	 	 {
	 		//fluentWait(Utility.getDriver(), elementLocation, 10, 1);
	 		WebElement elem = Utility.getDriver()
					.findElement(elementLocation);
			String js = "arguments[0].style.display='"+displayValue+"'; arguments[0].style.visibility='visible';";
			((JavascriptExecutor) Utility.getDriver()).executeScript(js, elem);
			log4j.info("Make element visible");
			Actions.pause(2);
	 		 
	 	 }
	 	 
	 	 public static void click_JS(By elementLocation,String desc){
	 		WebElement element =Utility.getDriver()
					.findElement(elementLocation);
	 		JavascriptExecutor executor = (JavascriptExecutor)Utility.getDriver();
	 		executor.executeScript("arguments[0].click();", element);
	 		log4j.info("Click on Element using javaScript"+desc);
	 	 }
	 	 public static boolean isChecked(By elementLocation)
	 	 {
	 		 try{
	 			fluentWait(Utility.getDriver(), elementLocation, 10, 1);
	 			log4j.info("Getting the Check Box Selection Status");
	 			return Utility.getDriver().findElement(elementLocation).isSelected();
	 			 
	 		 }
	 		 catch(Throwable t)
	 		 {
	 			 log4j.error(" Checking Check box status, Exception is :" +t);
	 			logger.log(LogStatus.FAIL, "The Exception is :"+t+Utility.appendScreenshot());
	 			 throw t;
	 		 }
	 		 
	 		 
	 	 }
	 	 
	
	 	 public static void refresh(){
	 		Utility.getDriver().navigate().refresh();
	 	 }
 	 public static void click_JSLocation(By by){

 		 try{
 			 pause(0.5);
 		fluentWait(Utility.getDriver(), by, 10, 1);
 		WebElement element = Utility.getDriver().findElement(by);
 		((JavascriptExecutor) Utility.getDriver()).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
 		element.click();
 		log4j.info(className+":"+"Scroll to the Desired Location");
 		 }
 		 catch(Throwable t)
 		 {
 			log4j.error(className+":"+"Scroll to the Desired Location is failed due to :"+t);
 			logger.log(LogStatus.FAIL, "The Exception While Scroll is :"+t+Utility.appendScreenshot());
 		 }
 	 }
}