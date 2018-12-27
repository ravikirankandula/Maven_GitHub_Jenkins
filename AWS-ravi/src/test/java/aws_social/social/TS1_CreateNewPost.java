package aws_social.social;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.Actions;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.Social.Global;
import objectrepository.Social.POM_Posts;
import resusablemethods.RU_Login_Logout;
import resusablemethods.RU_Posts;
import resusablemethods.RU_QRProcess;
import testdata.ConfigData;
import testdata.TestData;
import utility.Utility;

public class TS1_CreateNewPost extends Utility{
	
	Actions act;
	String Addprofile=ConfigData.Addprofile;
	String profileName=ConfigData.Txt_ProfileName;
	String clientID=ConfigData.Txt_ClientID;
	String clientSecret=ConfigData.Txt_ClientSecret;
	String IONAPIHostAdress=ConfigData.Txt_IonApiHostAdress;
	String securityAuth=ConfigData.Txt_SecurityAuthorizationServerAddress;
	String AuthEndpnt=ConfigData.Txt_AuthorizationEndpoint;
	String scrolltext=ConfigData.scrll_text_testconction;
	String tokenEndpnt=ConfigData.Txt_TokenEndpoint;
	String revocationEndpnt=ConfigData.Txt_RevocationEndpoint;
	String TenanatID=ConfigData.Txt_TenantID;
	String EnviornmentVariables=ConfigData.Txt_EnvironmentVariable;
	

	String usr1=ConfigData.USER1;
	String pwd=ConfigData.PASSWORD;
	String pstmsg=TestData.Txt_posttext;

	public AndroidDriver driver;

	
	@Test
	public void CreateNewPost()
	{
	try
	{
		new Actions(Utility.driver);
		Global.login_Env(usr1, pwd);
		RU_Posts.postwithAttachment(pstmsg);
		act.takeScreenshot();
		//Actions.verifyElement(POM_Posts.imgaftrpst);
		RU_Login_Logout.CloudLogout();
		
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		act.takeScreenshot();
	}
	}
	
	
}
