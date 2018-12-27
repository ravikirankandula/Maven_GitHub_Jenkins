package objectrepository.Social;

import org.openqa.selenium.By;

public class POM_Loginpage {
	
	//cloud Signin page
		public static final By signinbtn=By.name("Sign in");
		
		public static final By cloudsigninbtn=By.xpath("//android.widget.Button[contains(@content-desc, 'Sign In')]");
		public static final By cluduname=By.xpath("//android.view.View[@index='1']/android.widget.EditText[@index='1']");
		public static final By cludupwd=By.xpath("//android.view.View[@index='2']/android.widget.EditText[@index='1']");
		public static final By Allow1=By.xpath("//android.widget.Button[@index='1']");
		public static final By dontAllow=By.xpath("//android.widget.Button[contains(@content-desc, 'Don't Allow')]");
		public static final By Allow=By.xpath("//android.widget.Button[contains(@content-desc, 'Allow')]");
		public static final By profileaccess=By.xpath("//android.widget.CheckBox[@content-desc, 'Profile Access']");
		//public static final By dontAllow=By.xpath("//android.widget.Button[@index='0']");
		public static final By srchtextbox=By.id("com.infor.mingle:id/searchInput");
		public static final By Menubar=By.xpath("//android.widget.ImageButton[@index='0']");
		public static final By signout=By.name("Sign out");
		public static final By errormessage=By.name("Service is not available, please contact the server administrator.");
		
	//force Logout
		public static final By apps=By.xpath("//android.widget.TextView[@content-desc='Apps']");
		public static final By mingle=By.name("Infor Ming.le");
		
   //OP Signin page
		
		public static final By op=By.xpath("//android.view.View[contains(@content-desc, 'usalvwcoqa10usalvwcoqa10')]");
		public static final By opsigninbtn=By.xpath("//android.view.View[contains(@content-desc, 'SIGN IN')]");
		public static final By opsigninbtn1=By.xpath("//android.view.View[@index='4']");
		
		public static final By opuname=By.xpath("//android.view.View[@index='2']/android.widget.EditText[@index='0']");
		public static final By oppwd=By.xpath("//android.view.View[@index='3']/android.widget.EditText[@index='0']");
		public static final By continu=By.name("Continue");
		
}
		
