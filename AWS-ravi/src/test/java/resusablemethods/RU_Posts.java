package resusablemethods;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import actions.Actions;
import objectrepository.Social.POM_Connections;
import objectrepository.Social.POM_Loginpage;
import objectrepository.Social.POM_Posts;


public class RU_Posts {
	static String text, text1;
	
	public static void NewPost(String pstmsg)
	{	
		Actions.click(POM_Posts.composebtn);

		Actions.Mobile_waitforelement(POM_Posts.posttext);
		Actions.type(POM_Posts.posttext,pstmsg);
		selectlocation();
		Actions.click(POM_Posts.sendpst);
		Actions.Mobile_waitforelement(POM_Posts.waitforpst);
	}
	
	public static void composepost(String pstmsg)
	{
		Actions.click(POM_Posts.composebtn);
		Actions.Mobile_waitforelement(POM_Posts.posttext);
		Actions.type(POM_Posts.posttext,pstmsg);
	}
	
	public static void Attachment()
	{
		/*Actions.click(POM_Posts.fileAttach);
		Actions.Mobile_waitforelement(POM_Posts.Docs);
		Actions.click(POM_Posts.Docs);
		if(Actions.verifyElementPresent(POM_Posts.Gallery_Menu))
		{
			Actions.click(POM_Posts.Gallery_Menu);
		}
		Actions.Mobile_waitforelement(POM_Posts.images);
		Actions.click(POM_Posts.images);
		Actions.click(POM_Posts.sdcard);
		Actions.click(POM_Posts.slctimg);
		Actions.pause(2);
		Actions.verifyElementPresent(POM_Posts.longpressAttmnt);*/
		
		Actions.click(POM_Posts.cameraicon);
		Actions.Mobile_waitforelement(POM_Posts.photolib);
		Actions.click(POM_Posts.photolib);
		if(Actions.verifyElementPresent(POM_Posts.selctpic))
		{
			Actions.click(POM_Posts.selctpic);
			Actions.pause(2);
		}
		else
		{
			System.out.println("No photo is present");
			Actions.Mobile_AKC_BACK();
		}
		
		
		
			
			
	}
	
	public static void postwithAttachment(String pstmsg)
	{
		
	    text=pstmsg+UUID.randomUUID().toString();
		Actions.click(POM_Posts.composebtn);
		Actions.Mobile_waitforelement(POM_Posts.posttext);
		
		Actions.type(POM_Posts.posttext,text);
		//Attachment();
		
		Actions.click(POM_Posts.sendpst);
		Actions.Mobile_waitforelement(POM_Posts.waitforpst);
		Actions.pause(1);
		Actions.mobile_StoreandMatch(POM_Posts.editpost,text);
	}
	
	public static void EditPost()
	{
		Actions.click(POM_Posts.editpost);
		Actions.Mobile_waitforelement(POM_Posts.deletebtn);
	}
	
	public static void sendpost()
	{
		Actions.click(POM_Posts.sendpst);
		Actions.Mobile_waitforelement(POM_Posts.waitforpst);
		Actions.verifyElement(POM_Posts.waitforpst);
	}
	public static void Likepost(String matchvalue )
	{
		Actions.click(POM_Posts.ivlikes);
		Actions.Mobile_waitforelement(POM_Posts.tvlikes);
		EditPost();
		Actions.mobile_StoreandMatch(POM_Posts.tvlikes, matchvalue);
	}
	
	public static void DeletePost()
	{
		EditPost();
		Actions.click(POM_Posts.deletebtn);
		Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
		Actions.click(POM_Posts.popup_Yes);
		Actions.pause(9);
		
	}
	public static void DeleteComment()
	{
		Actions.mobile_Longpress(POM_Posts.Cment_cuUer);
		
		Actions.Mobile_waitforelement(POM_Posts.DltCmnt);
		Actions.click(POM_Posts.deletebtn);
		if(Actions.verifyElementPresent(POM_Posts.popup_Yes))
		{
			Actions.click(POM_Posts.popup_No);
			Actions.mobile_Longpress(POM_Posts.Cment_cuUer);
			Actions.Mobile_waitforelement(POM_Posts.DltCmnt);
			Actions.click(POM_Posts.deletebtn);
		}
		Actions.pause(3);
	}
	public static void EnterComment(String comment)
	{
		text=comment+UUID.randomUUID().toString();
		Actions.type(POM_Posts.inputCmnt, text);
	}
	
	public static void sendcomment()
	{
		Actions.click(POM_Posts.sendCmnt);
		Actions.Mobile_waitforelement(POM_Posts.Cment_cuUer);
		Actions.pause(3);
	}
	public static void Comments_TaggedUser(String tagatRate, String tagusr)
	{
		Actions.type(POM_Posts.inputCmnt, tagatRate);
		Actions.Mobile_waitforelement(POM_Posts.Usrsearch);
	    Actions.click(POM_Posts.Usrsearch);
	    Actions.type(POM_Posts.Usrsearch, tagusr);
	    Actions.pause(2);
	    Actions.click(POM_Connections.Dir_UserItem);
		
	}
	
	
	public static void clicktaguser()
	{
		Actions.click(POM_Posts.Cmnt_tagUsr);
		Actions.Mobile_waitforelement(POM_Connections.psttitle);
		Actions.click(POM_Connections.psttitle);
		Actions.verifyElement(POM_Connections.psttitle);
		
		
	}
	public static void switchtoposts()
	{
		Actions.click(POM_Posts.posts);
		Actions.Mobile_waitforelement(POM_Posts.editpost);
	}
	
	
	public static void Sharepost()
	{
		Actions.Mobile_waitforelement(POM_Posts.sharepost);
		Actions.click(POM_Posts.sharepost);
		Actions.Mobile_waitforelement(POM_Posts.sendpst);
	
	}
	
	
	public static void Sharepost_inputtext(String sharetext)
	{
		text=sharetext+UUID.randomUUID().toString();
		Actions.type(POM_Posts.posttext, text);
	
	}
	
	public static void sendsharedpost()
	{
		
		Actions.click(POM_Posts.sendpst);
		Actions.Mobile_waitforelement(POM_Posts.sharepost);
		backtoprevious();
		Actions.click(POM_Loginpage.Menubar);
		Actions.Mobile_waitforelement(POM_Loginpage.signout);
		Actions.click(POM_Posts.posts);
		Actions.Mobile_waitforelement(POM_Posts.waitforpst);
		Actions.verifyElement(POM_Posts.waitforpst);
		
	}
	
	public static void Connections_Navigation()
	{
		Actions.click(POM_Loginpage.Menubar);
		Actions.Mobile_waitforelement(POM_Loginpage.signout);
		Actions.click(POM_Connections.connectionspage);
		Actions.Mobile_waitforelement(POM_Loginpage.srchtextbox);
		Actions.pause(2);
		
	}
	
	public static void privacyleveldropdown_selectlevel(String object)
	{
		Actions.Mobile_AKC_BACK();
		Actions.click(POM_Posts.prvcydropdown);
		Actions.Mobile_waitforelement(POM_Posts.dropdown_connected);
		Actions.pause(2);
		Actions.click(By.name(object));
		
		
	}
	
	public static void backtoprevious()
	{
		if(Actions.verifyElementPresent(POM_Posts.backtoprev))
		{
			Actions.click(POM_Posts.backtoprev);
		}
	}
	
	public static void postmsgto(String pstmsg, String object)
	{
		text=pstmsg+UUID.randomUUID().toString();
		Actions.click(POM_Posts.composebtn);
		Actions.Mobile_waitforelement(POM_Posts.posttext);
		Actions.type(POM_Posts.posttext, text);
		Actions.Mobile_AKC_BACK();
		Actions.click(POM_Posts.prvcydropdown);
		Actions.Mobile_waitforelement(POM_Posts.dropdown_connected);
		Actions.pause(2);
		Actions.click(By.name(object));
		
	}
	
	public static void taggeduserpost(String tagatRate, String tagusr, String object )
	{
		
		Actions.click(POM_Posts.composebtn);
		Actions.Mobile_waitforelement(POM_Posts.posttext);
		Actions.type(POM_Posts.posttext, tagatRate);
	    Actions.Mobile_waitforelement(POM_Posts.Usrsearch);
	    Actions.click(POM_Posts.Usrsearch);
	    Actions.type(POM_Posts.Usrsearch, tagusr);
	    Actions.pause(2);
	    Actions.click(POM_Connections.Dir_UserItem);
	    Actions.Mobile_AKC_BACK();
		Actions.click(POM_Posts.prvcydropdown);
		Actions.Mobile_waitforelement(POM_Posts.dropdown_connected);
		Actions.pause(2);
		Actions.click(By.name(object));
	  
	}
	
	public static void colleaguepost(String pstmsg)
	{
		text=pstmsg+UUID.randomUUID().toString();
		Actions.click(POM_Posts.posts);
		Actions.click(POM_Connections.connected);
		Actions.Mobile_waitforelement(POM_Connections.disconnect);
		
		Actions.click(POM_Connections.sendpvtmsg);
		Actions.Mobile_waitforelement(POM_Posts.posttext);
		Actions.type(POM_Posts.posttext,text);
		RU_Posts.Attachment();
		RU_Posts.selectlocation();
		RU_Posts.nonclickableprivate();
		RU_Posts.sendpost();
		
		//RU_Posts.backtoprevious();
			
	}

	
	public static void verifyPost(String description)
	{
		Actions.mobile_StoreandMatch(POM_Posts.editpost,text);
	}
	
	public static void selectlocation()
	{
		Actions.Mobile_waitforelement(POM_Posts.Location);
		Actions.click(POM_Posts.Location);
		Actions.verifyElement(POM_Posts.Location);
	}
	
	public static void nonclickableprivate()
	{
		Actions.click(POM_Connections.privatename);
	
	}
	
	public static void shareimge(String ToAdd, String subject, String composebody)
	{
		Actions.click(POM_Posts.imglink);
		Actions.Mobile_waitforelement(POM_Posts.shareimg);
		Actions.click(POM_Posts.shareimg);
		if(Actions.verifyElementPresent(POM_Posts.Email))
		{
		Actions.Mobile_waitforelement(POM_Posts.Email);
		Actions.click(POM_Posts.Email);
		Actions.pause(2);
		Actions.type(POM_Posts.ToAdd, ToAdd);
		Actions.type(POM_Posts.subject, subject);
		Actions.type(POM_Posts.cmposeBody, composebody);
		Actions.click(POM_Posts.sendmail);
		Actions.pause(4);
		}
		else{
			System.out.println("Email Related Configuration was not set");
		}
		
	}
	
	public static void userppnavigation()
	{
		Actions.click(POM_Loginpage.Menubar);
		Actions.click(POM_Posts.userpic);
		Actions.Mobile_waitforelement(POM_Posts.backtoprev);
	}
	public static void Selectpropfilepic()
	{
		
		Actions.click(POM_Posts.userpic);
		Actions.Mobile_waitforelement(POM_Posts.photolib);
		Actions.click(POM_Posts.photolib);
		Actions.click(POM_Posts.Gallery_Menu);
	    Actions.Mobile_waitforelement(POM_Posts.images);
	    Actions.click(POM_Posts.images);
	    Actions.click(POM_Posts.sdcard);
	    Actions.click(POM_Posts.slctimg);
	    Actions.pause(2);
	    Actions.verifyElement(POM_Posts.userpic);
	}
	
	
	

}
