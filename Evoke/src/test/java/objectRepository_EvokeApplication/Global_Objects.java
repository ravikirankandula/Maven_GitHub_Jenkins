package objectRepository_EvokeApplication;

import org.openqa.selenium.By;

public class Global_Objects {
	
	//******************LOGIN PAGE**********************
	public static final By obj_Username=By.id("txtUsername");
	
	public static final By obj_pwd=By.id("txtPassword");
	
	public static final By obj_signin=By.id("btnLogin");
	
	//*******************LOGOUT*************************
	
	public static final By Obj_Welcome=By.partialLinkText("Welcome Admin");
	
	public static final By obj_Logout=By.partialLinkText("Logout");
	
	//************Extent Report***********************
	
	public static final By ExtentReports_Dashboard=By.xpath("//a[@class='dashboard-view']");
}
