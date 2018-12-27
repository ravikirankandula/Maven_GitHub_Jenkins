package objectrepository.Social;

import org.openqa.selenium.By;

public class POM_ManualQRCodeEntry {

	//Setting page
	
	public static final By username=By.id("com.infor.mingle:id/txtUserName");
	public static final By Settings_ionApicheckbox=By.id("com.infor.mingle:id/imgCheck");
	public static final By settings_btn=By.name("Settings");
	public static final By Cancelbtn=By.name("Cancel");
	public static final By AddProfile=By.name("Add Profile");
	
	//Manual QR code entry
	public static final By profilename=By.id("com.infor.mingle:id/eMProfileName");
	public static final By profile_Clientid=By.id("com.infor.mingle:id/eMClientId");
	public static final By profile_Clientsecrt=By.id("com.infor.mingle:id/eMClientSecret");
	public static final By profile_ionapihostaddress=By.id("com.infor.mingle:id/eMIonApiHostAddress");
	public static final By profile_serveraddrss=By.id("com.infor.mingle:id/eMServerAddress");
	public static final By profile_AuthEndpnt=By.id("com.infor.mingle:id/eMAuthorizationEndPoint");
	public static final By profile_tokenEndpnt=By.id("com.infor.mingle:id/eMTokenEndPoint");
	public static final By profile_recovationEndpnt=By.id("com.infor.mingle:id/eMRecovationEndPoint");
	public static final By profile_TentID=By.id("com.infor.mingle:id/emTenantID");
	public static final By profile_Environment=By.id("com.infor.mingle:id/eMEnvironment");
	public static final By savesettings=By.id("com.infor.mingle:id/action_save");
	public static final By goback=By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	public static final By signinbtn=By.name("Sign in");
	public static final By profile=By.id("com.infor.mingle:id/txtname");
	
	
	
}
