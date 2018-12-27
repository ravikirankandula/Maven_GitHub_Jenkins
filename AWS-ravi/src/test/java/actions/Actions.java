package actions;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;



public class Actions {

	public static WebElement locator;
	public static AndroidDriver driver;
	static Dimension size;
	static int startx, starty, endx, endy;
	public Actions(AndroidDriver driver)
	{

		this.driver=driver;
	}
	public static WebElement fluentWait(WebDriver driver, final By locator, int timeoutSeconds,int pollingIntervalSeconds) {
		WebElement foo=null;
		try {
			Wait<WebDriver> wait =
					new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
					.ignoring(Throwable.class)
					.pollingEvery(pollingIntervalSeconds, TimeUnit.SECONDS);



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
	public static String getAttribute(By by,String attr)
	{
		try{
			fluentWait(driver,by,10,2);

			return driver.findElement(by).getAttribute(attr).trim();
		}catch(Exception e)
		{

			throw e;
		}
	}

	public static void explicitWait_VisibilityOfElement(By by){
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
	}


	public static void clear(By by) {
		try{
			fluentWait(driver, by, 20, 1);
			locator = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 15); 
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			locator.clear();

		}
		catch(Exception e){


			throw e;
		}
	}

	public static void click(By by) {
		try{
		
			fluentWait(driver, by, 20, 1);
			locator = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 15); 
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			locator.click();

		}
		catch(Exception e){


			throw e;
		}
	}


	public static void click1(By by)
	{
		try{
			fluentWait(driver, by, 20, 1);
			locator=driver.findElement(by);

			WebDriverWait wait=new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			locator.click();
		}
		catch(Exception e){

			System.out.println(e.getMessage());

		}
	}


	public static void isEnabled(By by)
	{
		fluentWait(driver, by, 20, 1);
		locator=driver.findElement(by);
		locator.isEnabled();
	}

	public  static void type(By by,String input){
		try{
			fluentWait(driver, by, 20, 1);
			locator = driver.findElement(by);
			locator.sendKeys(input);

		}
		catch(Exception e){
			e.printStackTrace();	


			throw e;
		}
	}


	public static void isSelected(WebDriver driver,By by)
	{
		try{

			fluentWait(driver, by, 20, 1);
			locator = driver.findElement(by);
			locator.isSelected();

		}
		catch(Exception e){
			e.printStackTrace();				


			throw e;
		}
	}
	// Use Below Method only inside IF Condition
	public static boolean verifyElementPresent(By by)
	{
		try{
			fluentWait(driver, by, 7, 1);
			locator = driver.findElement(by);
			locator.isDisplayed();

			return true;
		}
		catch(Exception e){
			// e.printStackTrace();				


			return false;
		}
	}
	public static void verifyElement(By by){

		try {
			fluentWait(driver, by, 10, 1);
			explicitWait_VisibilityOfElement(by);
			Assert.assertTrue(driver.findElement(by).isDisplayed());

		} catch (Throwable e) {

			throw e;
		}
	}

	//Used to verify the Text inside a Locator with the Expected value
	public static void verify(By actual,String expected){
		String actval=null;
		try {

			actval=driver.findElement(actual).getText();
			Assert.assertTrue(actval.contains(expected));

		} catch (Error e) {

			throw e;
		}
	}
	// Used to compare Two String Values
	public static void verifyString(String actual,String expected){

		try {

			Assert.assertTrue(actual.contains(expected));

		} catch (Exception e) {

			throw e;
		}
	}



	public static String getTitle()
	{
		String title = driver.getTitle();

		return title;
	}
	//Not At Completed


	public static void pause(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

		}
	}
	public static void impwait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}



	/****************Driver Closer***************/



	/****************Drag And Drop***************/



	/**************** Methods Used for Mobile***********/
	public static void Mobile_waitforelement(By by)
	{
		try{

			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			locator = driver.findElement(by);
			

		}
		catch(Exception e){

			System.out.println("Element not found");

		}
	}

	public static void Mobile_waitforelement1(String text)
	{
		try{

			WebDriverWait wait = new WebDriverWait(driver,15);
			//wait.until(ExpectedConditions.presenceOfElementLocated(driver.findElementByName(text));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)));
			//locator = driver.findElementByName(text);
			System.out.println("Element found");

		}
		catch(Exception e){

			System.out.println("Element not found");

		}
	}

	public static void Mobile_Clickablelement(By by)
	{
		try{

			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			locator = driver.findElement(by);

		}
		catch(Exception e){



		}
	}
	public static void Mobile_waitfortext(By by,String text)
	{
		try{

			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.textToBePresentInElement(by, text));
			locator = driver.findElement(by);

		}
		catch(Exception e){

			System.out.println(e.getMessage());
		}
	}

	public static void Mobile_scroll(String text)
	{

		try
		{
			driver.scrollTo(text);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}

	public static void Mobile_swipe(int startX,int startY,int EndX,int EndY,int duration)
	{

		try
		{
			driver.swipe(startX, startY, EndX, EndY, duration); 

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}


	public static void Mobile_swipeBottomtoTop()
	{




		size = driver.manage().window().getSize();
		System.out.println(size);

		int starty = (int) (size.height * 0.70);
		//Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.30);
		//Find horizontal point where you wants to swipe. It is in middle of screen width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		//Swipe from Bottom to Top.
		driver.swipe(startx, starty, startx, endy, 2000);



	}



	public static void Mobile_scrolltoexact(String text)
	{

		try
		{
			driver.scrollToExact(text);  

		}
		catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	//AndroidKey Events

	public static void Mobile_AKC_BACK()
	{

		try
		{
			driver.pressKeyCode(AndroidKeyCode.BACK);


		}
		catch (Exception e) {
			// TODO: handle exception

		}
	}
	public static void Mobile_AKC_HOME()
	{

		try
		{
			driver.pressKeyCode(AndroidKeyCode.HOME);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void Mobile_AKC_Enter()
	{

		try
		{
			driver.pressKeyCode(AndroidKeyCode.ENTER);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());;
		}
	}
	public static void mobile_StoreandMatch(By by, String matchvalue)
	{
		String storevalue = null;

		try{
			fluentWait(driver, by, 10, 1);
			locator = driver.findElement(by);
			storevalue=locator.getText();

			if(storevalue.matches(matchvalue))

			{
				System.out.println("Both are matched");
			}
			else{

				System.out.println("Both are not matched");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public static void mobile_Longpress(By by)
	{


		try
		{
			fluentWait(driver, by, 20, 1);
			locator = driver.findElement(by);
			TouchAction act= new TouchAction(driver);
			act.longPress(locator, 5000).perform();

		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	public static boolean takeScreenshot() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String df=dateFormat.format(date);
		String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", df)));
	}

	public static void mobile_containstext(By by, String matchvalue)
	{
		String storevalue = null;


		fluentWait(driver, by, 20, 1);
		locator = driver.findElement(by);
		storevalue=locator.getText();
		if(storevalue.contains(matchvalue))


		{
			System.out.println("Both are matched");
		}
		else{


			driver.switchTo().defaultContent();
		}

	}

	public static boolean verifyElementEnabled(By by)
	{
		try{
			fluentWait(driver, by, 12, 1);
			locator = driver.findElement(by);
			locator.isEnabled();

			return true;
		}
		catch(Exception e){
			// e.printStackTrace();				


			return false;
		}
	}

	public static void Mobile_Tap(int fingers,int duration,int x,int y)
	{
		try
		{
			driver.tap(fingers, x, y, duration);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}	





}
