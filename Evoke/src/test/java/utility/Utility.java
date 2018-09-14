/**
 * 
 */
package utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import actions.Actions;
import objectRepository_EvokeApplication.Global_Objects;


public class Utility {

	public final static String RpPath=System.getProperty("user.dir");
	private static WebDriver driver;
	private static Utility utl;

	protected static void setDriver(WebDriver driver) {
		Utility.driver = driver;

	}


	public static String browser1, browser=null, Env=null;



	public static  ExtentReports report=null;
	public static ExtentTest logger,logger2;


	public static int count;

	@BeforeSuite
	public void startReport()
	{

		Utility.initReport();
		try{
			deleteZip();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void endReport()  
	{
		try{
			Utility.closeReport();
		}catch (Exception e) {

		}

		try {
			Utility.zipReport(zipSrc,zipDst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Utility.execute("./logReport.zip");


	}


	@BeforeTest
	@Parameters("browser")
	public void setUpBrowser(String browser) 
	{

		Utility.browser=browser;

	}

	public static WebDriver getDriver()
	{
		if(driver==null){
			Actions.logger.log(LogStatus.INFO, "Browser is going to be launch : ");
			Actions.log4j.info("Browser is going to be launch : ");
			if(browser==null || browser.equalsIgnoreCase("chrome"))
			{	

				System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
				/*ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");*/
				String downloadFilepath =RpPath+"\\Downloads";
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				chromePrefs.put("safebrowsing.enabled", "true"); 

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--allow-running-insecure-content");
				options.setExperimentalOption("prefs", chromePrefs);
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(cap); 

				//driver=new ChromeDriver(); 
				Utility.browser1="Chrome";
			}
			else if(browser.equalsIgnoreCase("ie"))
			{	
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				//  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability("requireWindowFocus", false);
				capabilities.setCapability("nativeEvents", false);    
				//capabilities.setCapability("unexpectedAlertBehaviour", "accept");
				//capabilities.setCapability("ignoreProtectedModeSettings", true);
				//capabilities.setCapability("disable-popup-blocking", true);
				capabilities.setCapability("enablePersistentHover", true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
				System.setProperty("webdriver.ie.driver",".\\lib\\IEDriverServer.exe");

				//System.setProperty("webdriver.ie.driver","C:\\Users\\lkanthu\\Downloads\\Windows7-KB2990999-x64.msu");
				driver=new InternetExplorerDriver(capabilities);
				Utility.browser1="Internet Explorer";
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{				
				System.setProperty("webdriver.gecko.driver",".\\lib\\geckodriver.exe");
				driver=new FirefoxDriver();
				Utility.browser1="Firefox";


			}
			else
			{
				Utility.browser1="Chrome";
				System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
				/*ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver=new ChromeDriver(chromeOptions); */
				driver=new ChromeDriver(); 

			}

			HashMap<String, String> configData=Utility.getConfigData();
			//TESTDATA
			String url=configData.get("URL");
			System.out.println("URL IS : "+url);
			driver.get(url);
			driver.manage().window().maximize();
			Actions.log4j.info("Browser is launched in : \""+Utility.browser1+"\" Browser And URL : "+url);
			Actions.logger.log(LogStatus.INFO, "Browser launched in : "+Utility.browser);
			Actions.logger.log(LogStatus.INFO, "Launched url is : "+url);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			return driver;
		}
		return driver;
	}

	/*
	 * 
	 * Code to Capture Screen shot
	 */
	public static String getScreenshot()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		Date date = new Date();

		String df=dateFormat.format(date);
		String path="./logs/"+time+"/screens/error"+df+".png";
		
		String path2="./screens/error"+df+".png";
		File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(src, new File(path));
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return path2;
	}
	public static String appendScreenshot()
	{
		String path=getScreenshot();
		return logger.addScreenCapture(path);
		//test.log(LogStatus.FAIL, "Verification Failed");

	}


	public  ExtentTest initTest(String name)
	{

		report.loadConfig(new File(RpPath+"\\extent-config.xml"));
		return logger=report.startTest(name);

	}
	public static String time=Utility.getTime();
	public static String getTime()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy_HH_mm");
		return dateFormat1.format(now);
	}
	public static String getDate()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat1.format(now);
	}

	public static  void initReport()
	{


		report=new ExtentReports(RpPath+"\\logs\\"+time+"\\extent.html",false);
	}
	public static void closeReport()
	{

		report.flush();

	}


	public static String getValuesFromPropertiesFile(String propertiesFileName, String key) {
		try
		{			
			FileInputStream fis = new FileInputStream(new File(RpPath+"\\"+propertiesFileName+".properties"));    			
			Properties prop=new Properties();
			prop.load(fis);
			return prop.get(key).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}





	public static HashMap<String, String> getTestData() {
		Properties prop = new Properties();
		HashMap<String, String> propvals = new HashMap<String, String>();
		try {

			/* input = Utility.class
		 .getResourceAsStream(RpPath+"testdata.properties");*/
			FileInputStream fis = new FileInputStream(new File(RpPath+"\\testdata.properties"));   
			prop.load(fis);
			Set<String> propertyNames = prop.stringPropertyNames();
			for (String Property : propertyNames) {
				propvals.put(Property, prop.getProperty(Property));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propvals;
	}

	public static HashMap<String, String> getConfigData() {
		Properties prop = new Properties();
		HashMap<String, String> propvals = new HashMap<String, String>();
		try {

			/* input = Utility.class
			 .getResourceAsStream(RpPath+"testdata.properties");*/
			FileInputStream fis = new FileInputStream(new File(RpPath+"\\config.properties"));   
			prop.load(fis);
			Set<String> propertyNames = prop.stringPropertyNames();
			for (String Property : propertyNames) {
				propvals.put(Property, prop.getProperty(Property));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propvals;
	}

	 public static String report() throws IOException{
		 
		 Utility.getDriver().get(RpPath+"\\logs\\extent.html");
		 Utility.getDriver().findElement(Global_Objects.ExtentReports_Dashboard).click();
		   File scrFile = ((TakesScreenshot)Utility.getDriver()). getScreenshotAs(OutputType.FILE);
		   //The below method will save the screen shot in d drive with name "screenshot.png"
		   String file=RpPath+"\\logs\\screenshot.png";
		      FileUtils.copyFile(scrFile, new File(RpPath+"\\logs\\screenshot.png"));
		      Utility.getDriver().close();
		return file;
	 }

	 private static String zipSrc=RpPath+"\\logs\\"+time;

     // Destination for Zip file
     private static String zipDst=RpPath+"\\logReport.zip";
     
     public static void zipReport(String sourceDirPath, String zipFilePath) throws IOException {
    	 
          Path p = Files.createFile(Paths.get(zipFilePath));

          ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p));
          try {
              Path pp = Paths.get(sourceDirPath);
              Files.walk(pp)
                .filter(path -> !Files.isDirectory(path))
                .forEach(path -> {
                    String sp = path.toAbsolutePath().toString().replace(pp.toAbsolutePath().toString(), "").replace(path.getFileName().toString(), "");
                    ZipEntry zipEntry = new ZipEntry(sp + "/" + path.getFileName().toString());
                    try {
                        zs.putNextEntry(zipEntry);
                        zs.write(Files.readAllBytes(path));
                        zs.closeEntry();
                  } catch (Exception e) {
                      System.err.println(e);
                  }
                });
          } finally {
              zs.close();
          }
      }
     public static void deleteZip()
     {
    	File f=new File(zipDst);
    	f.delete();
    	Actions.log4j.info("Existing Zip File is Deleted");
    	//Actions.logger.log(LogStatus.INFO, "Existing Zip File is Deleted");
    	
    	
    	 
     }





	public static void execute(String reportFileName)  {
		String to = "rkandula@evoketechnologies.com";
		//greg.smart@infor.com,marcio.debarros@infor.com,narahari.ankam@infor.com

		// Sender's email ID needs to be mentioned
		String from ="ravikiranchowdary21@gmail.com";
		/*      final String username = "lavanya.kanthu@infor.com";
 	        final String password = "**********";*/

		Properties props = new Properties();
		//props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp-relay.infor.com");
		props.put("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(props);
		/*  Session session = Session.getInstance(props,
 	          new javax.mail.Authenticator() {
 	            protected PasswordAuthentication getPasswordAuthentication() {
 	                return new PasswordAuthentication(username, password);
 	            }
 	          });*/

		WebDriver driver1;
		try {

			//Utility.driver=null;
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
			driver1=new ChromeDriver();
			driver1.manage().window().maximize();
			Actions.pause(2);
			driver1.get(RpPath+"\\logs\\"+time+"\\extent.html");
			driver1.findElement(Global_Objects.ExtentReports_Dashboard).click();
			Actions.pause(2);
			String passCount= driver1.findElement(By.xpath("//span[text()='Tests View']/../following::div[3]/descendant::span[2]")).getText();
			String failCount= driver1.findElement(By.xpath("//span[text()='Tests View']/../following::div[4]/descendant::span[2]")).getText();
			int pass=Integer.parseInt(passCount);
			int fail=Integer.parseInt(failCount);
			int toal=pass+fail;
			String totalCount=String.valueOf(toal).toString();
			File scrFile = ((TakesScreenshot)driver1). getScreenshotAs(OutputType.FILE);
			//The below method will save the screen shot in d drive with name "screenshot.png"
			String file=RpPath+"\\logs\\"+time+"\\screenshot.png";
			FileUtils.copyFile(scrFile, new File(RpPath+"\\logs\\"+time+"\\screenshot.png"));
			driver1.close();


			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			HashMap<String, String> configData=Utility.getConfigData();
			// Set Subject: header field
			//  message.setSubject("Mingle Automation Test Report : "+configData.get("ENVIRONMENT")+"  "+"Pass Count:"+passCount+" "+"Fail Count:"+failCount+" "+"Total Count:"+totalCount);
			message.setSubject("Mingle Automation Test Report : "+configData.get("ENVIRONMENT")+"  "+"Total Scripts : "+totalCount+" Passed Scripts : "+passCount+" "+" Failed Scripts : "+failCount);
			// This mail has 2 part, the BODY and the embedded image
			Multipart  multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H2>Mingle Automation Test Report: Environment: "+configData.get("ENVIRONMENT")+" Browser : "+Utility.browser1+"</H2><img src=\"cid:image\">";
			//String htmlText="<H1>Mingle Automation Test Report: ENV"+configData.get("ENVIRONMENT")+"Browser:"+"</H1><img src=\"cid:image\">";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(
					file);

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

			//  String filename = "SendAttachment.java";//change accordingly  
			DataSource source = new FileDataSource(reportFileName);  
			messageBodyPart2.setDataHandler(new DataHandler(source));
			String s=reportFileName.substring(reportFileName.indexOf(".")+1).trim();

			messageBodyPart2.setFileName(s);  


			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart2);

			// put everything together
			message.setContent(multipart);
			// Send message
			Transport.send(message);



		} catch (Exception e) {
			Actions.log4j.info("************* Email not Sent ********************** : "+e);
			throw new RuntimeException(e);
		}


		Actions.log4j.info("***************** Email Sent Successfully ***************");

	}

	//UPLOAD FILE
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			//Setting clipboard with file location
			Actions.pause(2);
			setClipboardData(fileLocation);
			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.delay(1500);
			/*robot.keyPress(KeyEvent.VK_CONTROL);
   	            robot.keyPress(KeyEvent.VK_V);
   	            robot.keyRelease(KeyEvent.VK_V);
   	            robot.keyRelease(KeyEvent.VK_CONTROL);
   	            robot.keyPress(KeyEvent.VK_ENTER);
   	            robot.keyRelease(KeyEvent.VK_ENTER);*/
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);

			// Release Enter
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);


			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	public static class MyException extends Exception{
		String str1;
		public MyException(String str2) {
			str1=str2;
		}
		public String toString(){ 
			return ("Exception : "+str1) ;
		}
	}
}

