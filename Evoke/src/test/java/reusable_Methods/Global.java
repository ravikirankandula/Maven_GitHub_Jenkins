/**
 * 
 */
package reusable_Methods;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import actions.Actions;
import objectRepository_EvokeApplication.Global_Objects;
import utility.Utility;


public class Global {
	 WebDriver driver,driver1;
	
		 /****************SignIn***************/
		 public static void login(String user,String pwd)
		 {
			 HashMap<String, String> testData=Utility.getConfigData();
			 String env=testData.get("ENVIRONMENT").toUpperCase().toString();
			 System.out.println(env);
			 switch(env)
			 {
			 	
			 case "QA":
			 	{
					 try {
						
						  Actions.clearText(Global_Objects.obj_Username," clear UserName Details");
						  Actions.type(Global_Objects.obj_Username, user, "UserName Details");
						  Actions.type(Global_Objects.obj_pwd, pwd, "Password Details");
						  Actions.click(Global_Objects.obj_signin, "Click On Login Button"); 
						 // Actions.pause(5);
						  
						 // Actions.impwait();
						 // break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw e;
					}
					 break;
				 
			 	}
				 
			 	case "DEV":
			 	{
			 		 try {
							
						  Actions.clearText(Global_Objects.obj_Username," clear UserName Details");
						  Actions.type(Global_Objects.obj_Username, user, "UserName Details");
						  Actions.type(Global_Objects.obj_pwd, pwd, "Password Details");
						  Actions.click(Global_Objects.obj_signin, "Click On Login Button"); 
						 // Actions.pause(5);
						 
						 // Actions.impwait();
						 // break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw e;
					}
					 break;
			 	}
			 	
			 	case "UAT":
			 	{
			 		 try {
							
						  Actions.clearText(Global_Objects.obj_Username," clear UserName Details");
						  Actions.type(Global_Objects.obj_Username, user, "UserName Details");
						  Actions.type(Global_Objects.obj_pwd, pwd, "Password Details");
						  Actions.click(Global_Objects.obj_signin, "Click On Login Button"); 
						 // Actions.pause(5);
						 
						 // Actions.impwait();
						 // break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw e;
					}
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
		 
			/****************SignOut***************/
			 public static void logOut(){
				 try {
					 
					 Actions.switchToDefaultContent();	
					 //Actions.pause(5);
					 Actions.click(Global_Objects.Obj_Welcome, "Click On WelcomeUser Menu"); 
					 //Actions.pause(2);
					 Actions.click(Global_Objects.obj_Logout, "Click On SignOut");
					 Actions.logger.log(LogStatus.INFO,"User SuccessFully Logged Out");
					 Actions.log4j.info("User SuccessFully Logged Out");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw e;
				}     
			 }
		
}
