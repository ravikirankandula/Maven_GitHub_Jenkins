package resusablemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import actions.Actions;
import objectrepository.Social.POM_Loginpage;


public class RU_Login_Logout {
	static WebDriverWait wait;
	//Cloud Login
	
	
	//Cloud Logout
	public static void CloudLogout()
	{
		
		
		Actions.click(POM_Loginpage.Menubar);
		Actions.Mobile_waitforelement(POM_Loginpage.signout);
		Actions.click(POM_Loginpage.signout);
		Actions.Mobile_waitforelement(POM_Loginpage.signinbtn);	
			
	}
	
	public static void forceLogout()
	{
		
		Actions.pause(2);
		Actions.Mobile_AKC_HOME();
		Actions.click(POM_Loginpage.apps);
		Actions.click(POM_Loginpage.mingle);
		Actions.pause(2);
		CloudLogout();
			
	}
	
	
}
