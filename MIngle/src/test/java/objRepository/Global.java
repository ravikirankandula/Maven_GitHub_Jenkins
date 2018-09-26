/**
 * 
 */
package objRepository;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.Actions;
//import objRepository.Social.ShellHeader;
import utility.Utility;


public class Global {
	 WebDriver driver,driver1;
	
		/****************Locator***************/
	 public static final	 By submit=By.id("submit");
	 public static final	 By submitOP=By.id("submitButton");
	 public static final	 By opQA=By.xpath("//span[contains(text(),'usalvwcoqa10')]");
	 public static final	 By user=By.id("name");
	 public static final	 By userOP=By.id("userNameInput");
	 public static final	 By pwdOP=By.id("passwordInput");
	 public static final	 By pwd=By.id("password");
	// public static final	 By pwd=By.xpath("//input[@name='pf.pass']");
	// public static final     By socialFrame=By.xpath("//iframe[@name='social_8f80541c-c921-4d2a-8036-d8d7f425284c']");
	 public static final     By socialCLFrame=By.xpath("//iframe[contains(@name,'social_')]");
	 public static final     By homePagesCLFrame=By.xpath("//iframe[contains(@name,'homepages_')]");
	 public static final     By mingleCLFrame=By.xpath("//iframe[contains(@name,'Mingle')]");
	 public static final	 By yes=By.xpath("//button[text()='Yes']");
	 public static final	 By no=By.xpath("//button[text()='No']");
	 public static final	 By dashBorad=By.xpath("//a[@class='dashboard-view']");
	 public static final     By MinglePageLoading_BookMarks=By.xpath("//div[@data-ng-controller='MingleAppController']/descendant::div[contains(@class,'busy-overlay ng-scope ng-hide')]");
	 public static final     By MinglePageLoading_social=By.xpath("//div[@data-bind-id='infor-mingle-pageloader' and contains(@style,'display: none;')]");
	 public static final     By IONCLFrame=By.xpath("//iframe[contains(@name,'ionapi_')]");
	 public static final	 By save=By.xpath("//button[contains(text(),'Save')]"); 
	 public static final     By MinglePageLoading_Admin=By.xpath("//div[@data-ng-if='showAddApplication()']/following::div[3]/following::div[2][@class='busy-overlay ng-scope ng-hide']");
	 public static final     By saveSucessTooltip=By.xpath("//div[@class='infor-save-success-tooltip']");
	 public static final     By MinglePageLoading_IONAPI=By.xpath("//div[@data-ng-controller='appController']/descendant::div[2][@class='busy-overlay ng-scope ng-hide']");
	  
	 
		 /****************Constructor***************/
		/* public Global(WebDriver driver){
				
				this.driver=driver;
				//driver1=Utility.getDriver();
			}
		 */
		 
		/****************SignOut***************/
//		 public static void logOut(){
//			 Actions.switchToDefaultContent();	
//			 //Actions.pause(2);
//			 Actions.click(ShellHeader.userMenu, "Click On User Menu"); 
//			 //Actions.pause(2);
//			 Actions.click(ShellHeader.signOut, "Click On SignOut");     
//		 }
		//To Handle Confirmation PopUp Like Yes/No 
		 public static void acceptConfirmation()
		 {
			 if(Actions.verifyElementPresent(yes, "Confirmation Prompt"))
			 {
				 Actions.click(yes, "Click On Yes");   
				 Global.minglePageLoad_Social();
			 }
			 
		 }
		 public static void declineConfirmation()
		 {
			 if(Actions.verifyElementPresent(no, "Confirmation Prompt"))
			 {
				 Actions.click(no, "Click On NO");   
				 Global.minglePageLoad_Social();
			 }
			 
		 }
		 /****************SignIn***************/
		 public static void login(String user,String pwd)
		 {
			 HashMap<String, String> testData=Utility.getConfigData();
			 String env=testData.get("ENVIRONMENT").toUpperCase();
			 System.out.println(env);
			 switch(env)
			 {
			 	
			 	case "CLOUD":
			 	{
			 		  Actions.type(Global.user, user, "UserName Details");
					  Actions.type(Global.pwd, pwd, "Password Details");
					  Actions.click(submit, "Click On Submit Button"); 
					  Actions.pause(3);
					  break;
				 
			 	}
			 	case "OP":
			 	{
			 		if(Actions.verifyElementPresent(opQA, "Verify Presence of QA Link")) { 
			 		Actions.click(opQA, "Click On QA Button");
			 		}
			 		  Actions.type(userOP, user, "UserName Details");
					  Actions.type(pwdOP, pwd, "Password Details");
					  Actions.click(submitOP, "Click On Submit Button");
					  Actions.pause(3);
					  break;
				 
			 	}
			 	default:
			 	{
			 		try{
			 		// throwing user defined custom exception
			 	          throw new Utility.MyException("Value of ENVIRONMENT is not Set properly."+ "\nYou have set ENVIRONMENT="+testData.get("ENVIRONMENT")+ ".\nKindly set ENVIRONMENT=CLOUD or ENVIRONMENT=OP in the config.Properties File");
			 	          
			 	          
			 	       }
			 	       catch(Utility.MyException exp){
			 	         exp.printStackTrace();
			 	        Actions.log4j.error(exp);
			 	        System.exit(1);
			 	       }
			 	}
			 		
			 }
			 
		 }
		 public static void minglePageLoad_BookMarks()
		 {
			 Actions.pause(2);
			 Actions.verifyElementPresent(Global.MinglePageLoading_BookMarks, "Waiting for page to Load");
		 }
		 public static void minglePageLoad_Social()
		 {
			 Actions.pause(2);
			 Actions.verifyElementPresent(Global.MinglePageLoading_social, "Waiting for page to load");
		 }
		 
		 public static void minglePageLoad_Admin()
		 {
			 Actions.pause(2);
			 Actions.verifyElementPresent(Global.MinglePageLoading_Admin, "Waiting for complete Loading");
		 }
		 public static void verifySaveSuccesstooltipMsg()
		 {
			 
			 Actions.verifyElement(saveSucessTooltip, "Verify Save Success Message");
		 }
		 
		 public static void minglePageLoad_IONAPI()
		 {
			 Actions.pause(2);
			 Actions.verifyElementPresent(Global.MinglePageLoading_IONAPI, "Waiting for complete Loading");
		 }
}
