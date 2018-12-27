package aws_social.social;


import org.testng.annotations.Test;
import actions.Actions;
import objectrepository.Social.Global;
import objectrepository.Social.POM_Posts;
import resusablemethods.RU_Login_Logout;
import resusablemethods.RU_Posts;
import testdata.ConfigData;
import testdata.TestData;
import utility.Utility;

public class TS10_Comments_13507_13508_13509 extends Utility
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
	String comment=TestData.AdComment;

	

	@Test
	public void AddComment() throws Exception
	{

		try
		{
			
			new Actions(Utility.driver);	
			Global.login_Env(usr1, pwd);
			RU_Posts.NewPost(pstmsg);
			RU_Posts.EditPost();
			RU_Posts.EnterComment(comment);
			RU_Posts.sendcomment();
			Actions.pause(3);
			Actions.mobile_StoreandMatch(POM_Posts.tvComments, count);
			RU_Posts.DeleteComment();
		}
		catch(Exception e)
		{
			System.out.println("enable:Force Logout ");
			System.out.println(e.getMessage());
			RU_Login_Logout.forceLogout();	
		}
	}

	@Test(dependsOnMethods="AddComment")
	public void Comments_TaggedUser() throws Exception{

		try{
			
			new Actions(Utility.driver);
			RU_Posts.Comments_TaggedUser(tagatRate, srchuser2);
			RU_Posts.sendcomment();
			Actions.pause(4);
			RU_Posts.clicktaguser();
			RU_Posts.backtoprevious();
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
