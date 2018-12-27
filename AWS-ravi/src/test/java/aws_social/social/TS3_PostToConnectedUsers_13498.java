/**
 * 
 */
package aws_social.social;

import org.testng.annotations.Test;

import actions.Actions;
import objectrepository.Social.Global;
import objectrepository.Social.POM_Posts;
import resusablemethods.RU_Connections;
import resusablemethods.RU_Login_Logout;
import resusablemethods.RU_Notifications;
import resusablemethods.RU_Posts;
import testdata.ConfigData;
import testdata.TestData;
import utility.Utility;

public class TS3_PostToConnectedUsers_13498 extends Utility{

	
	Actions act;
	String usr1=ConfigData.USER1;
	String pwd=ConfigData.PASSWORD;
	String pstmsg=TestData.Txt_posttext;
	String usr2=ConfigData.USER2;
	String srchuser2=ConfigData.srchuser2;
	String object_connected=TestData.prvcy_dropdpwn_Connected;

	@Test
	public void ConnectionRequest() throws Exception{
		try{
			
			new Actions(Utility.driver);
			Global.login_Env(usr1, pwd);
			RU_Connections.Connections_Navigation();
			RU_Connections.swipepage();
			RU_Connections.DirectoryVerification();
			RU_Connections.Dir_serachusr(srchuser2);
			RU_Connections.clickuser();
			RU_Connections.sendConnectionrequest();
			RU_Posts.backtoprevious();
			RU_Login_Logout.CloudLogout();
			Global.login_Env(usr2, pwd);
			RU_Notifications.AcceptConnectionrequest();
			Actions.mobile_containstext(POM_Posts.editpost, "accepted the request");
			Actions.verifyElement(POM_Posts.editpost); 			
			RU_Login_Logout.CloudLogout();
			Global.login_Env(usr1, pwd);
			RU_Posts.postmsgto(pstmsg,object_connected);
			RU_Posts.sendpost();
			act.takeScreenshot();
			RU_Login_Logout.CloudLogout();
			Global.login_Env(usr2, pwd);
			Actions.pause(5);
			RU_Posts.verifyPost("Connected Post");
			act.takeScreenshot();
			RU_Login_Logout.CloudLogout();
							
		}

		catch(Exception e)
		{
			System.out.println("enable:Force Logout ");
			System.out.println(e.getMessage());
			RU_Login_Logout.forceLogout();	
		}

		finally
		{
			try{
				System.out.println("Rollback");

				Global.login_Env(usr1, pwd);
				RU_Posts.DeletePost();
				RU_Login_Logout.CloudLogout();
				 					 
			}
			catch(Exception e)
			{
				System.out.println("enable:Force Logout ");
				System.out.println(e.getMessage());
				RU_Login_Logout.forceLogout();	
				//Actions.driverClose(); 					
			}
		}

	}	

}
