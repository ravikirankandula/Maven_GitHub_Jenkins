package aws_social.social;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;


import actions.Actions;
import objectrepository.Social.Global;
import resusablemethods.RU_Login_Logout;
import resusablemethods.RU_Posts;
import testdata.ConfigData;
import testdata.TestData;
import utility.Utility;

public class TS9_Location_LikeDeletePost_13505_13507 extends Utility
{

	String usr1=ConfigData.USER1;
	String usr2=ConfigData.USER2;
	String usr3=ConfigData.USER3;
	String pwd=ConfigData.PASSWORD;
	String srchuser2=ConfigData.srchuser2;
	String srchuser1=ConfigData.srchuser1;
	String object_connected=TestData.prvcy_dropdpwn_Connected;
	String obj_public=TestData.prvcy_dropdpwn_public;
	String obj_tagged=TestData.prvcy_dropdpwn_taggedUsrGrp;
	String pstmsg=TestData.Txt_posttext;	
	String sharetext=TestData.Txt_Sharetext;
	String tagatRate=TestData.typeattherate;
	String tagusrMatch=ConfigData.taguser;
	String count=TestData.Count;
	

	@Test
	public void locationandLike() throws Exception
	{

		try{
			
			
			new Actions(Utility.driver);
			Global.login_Env(usr1, pwd);
			RU_Posts.NewPost(pstmsg);
			RU_Posts.Likepost(count);
			RU_Posts.backtoprevious();
			RU_Posts.DeletePost();
			RU_Login_Logout.CloudLogout();
			
			}
		catch(Exception e)
		{
			System.out.println("enable:Force Logout ");
			System.out.println(e.getMessage());
			RU_Login_Logout.forceLogout();	
		}

	}

}
