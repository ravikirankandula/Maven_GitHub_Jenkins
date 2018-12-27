package resusablemethods;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Window;


import actions.Actions;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.Social.POM_Connections;
import objectrepository.Social.POM_Loginpage;
import objectrepository.Social.POM_Posts;
import utility.Utility;


public class RU_Connections {
	
	public static String text;
	public static String getdata;
	public static Dimension size;
	static int startx, starty, endx, endy;
	
	
	public static void Connections_Navigation()
	{
		Actions.click(POM_Loginpage.Menubar);
		Actions.Mobile_waitforelement(POM_Loginpage.signout);
		Actions.click(POM_Connections.connectionspage);
		Actions.Mobile_waitforelement(POM_Loginpage.srchtextbox);
		Actions.pause(2);
		
	}
	
	public static void swipepage1()
	{
		Actions.Mobile_swipe(1063,1652,2,1664,5000);
		Actions.Mobile_swipe(1063,1652,2,1664,5000);
		Actions.Mobile_swipe(1063,1652,2,1664,5000);
	}
	
	public static void swipepage()
	{
		
		size=Utility.driver.manage().window().getSize();
		System.out.println("size of device:"+size);
		startx=(int) (size.width*0.99);
		endx=(int)(size.width*0.10);
		starty=size.height/2;
		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
		//swipe from right to left
		Utility.driver.swipe(startx, starty, endx, starty, 10000);
		Utility.driver.swipe(startx, starty, endx, starty, 10000);
		Utility.driver.swipe(startx, starty, endx, starty, 15000);
		
	}
	
	public static void switchtoposts()
	{
		Actions.Mobile_waitforelement(POM_Connections.psttitle);
		Actions.click(POM_Connections.psttitle);
		
	}
	public static void DirectoryVerification()
	{
		Actions.mobile_StoreandMatch(POM_Connections.dirctorypage, "Directory");
	}
	public static void Dir_serachusr(String input)
	{
		Actions.type(POM_Connections.Dir_Src, input);
		Actions.pause(2);
	}
	public static void clickuser()
	{
		Actions.click(POM_Connections.Dir_UserItem);
		Actions.Mobile_waitforelement(POM_Posts.posts);
		Actions.Mobile_waitforelement(POM_Connections.titletext);
		Actions.pause(2);
		
	}
	
	public static void disconnect()
	{
		Actions.click(POM_Connections.connected);
		Actions.Mobile_waitforelement(POM_Connections.disconnect);
		Actions.click(POM_Connections.disconnect);
		Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
		Actions.click(POM_Posts.popup_Yes);
		
	}
	
	public static void sendConnectionrequest()
	{
		 getdata=Utility.driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).getText();
		System.out.println(getdata);
		 switch(getdata)
		 {
		 case "Connect":
		 	{
		 		Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.rqstsent);
				Actions.verifyElement(POM_Connections.rqstsent);
			    break;
		 	}
		 case "Request Sent":
		 	{ 
		 		Actions.click(POM_Connections.rqstsent);
		 		Actions.Mobile_waitforelement(POM_Connections.cancelrqst);
		 		Actions.click(POM_Connections.cancelrqst);
		 		Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.rqstsent);
				Actions.verifyElement(POM_Connections.rqstsent);
			    break;
		 	}
		 case "Connected":
		 	{
		 		Actions.click(POM_Connections.connected);
				Actions.Mobile_waitforelement(POM_Connections.disconnect);
				Actions.click(POM_Connections.disconnect);
				Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
				Actions.click(POM_Posts.popup_Yes);
				Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.rqstsent);
				Actions.verifyElement(POM_Connections.rqstsent);
		 		
			    break;
		 	}
		 default:
		 	{
		 		System.out.println("No Matched getData Found");
		 		
		 	}
			 
		 }
	}
	
	
	
	public static void FollowUser1()
	{
		Actions.Mobile_waitforelement(POM_Connections.psttitle);
		if(Actions.verifyElementPresent(POM_Connections.following))
		{
			Actions.pause(2);
			Actions.click(POM_Connections.following);
			Actions.Mobile_waitforelement(POM_Connections.unfolw);
			Actions.click(POM_Connections.unfolw);
			
		}
		Actions.Mobile_waitforelement(POM_Connections.conct);
		Actions.click(POM_Connections.conct);
		Actions.Mobile_waitforelement(POM_Connections.folw);
		Actions.click(POM_Connections.folw);
		Actions.Mobile_waitforelement(POM_Connections.following);
		
		
	}
	
	public static void FollowUser()
	{
		getdata=Utility.driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).getText();
		System.out.println(getdata);
		 switch(getdata)
		 {
		 case "Connect":
		 	{
		 		Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.folw);
				Actions.click(POM_Connections.folw);
				Actions.Mobile_waitforelement(POM_Connections.following);
			    break;
		 	}
		 case "Following":
		 	{
			    break;
		 	}
		 case "Request Sent":
		 	{
		 		Actions.click(POM_Connections.cancelrqst);
		 		Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.folw);
				Actions.click(POM_Connections.folw);
				Actions.Mobile_waitforelement(POM_Connections.following);
			    break;
		 	}
		 case "Connected":
		 	{
		 		Actions.click(POM_Connections.connected);
				Actions.Mobile_waitforelement(POM_Connections.disconnect);
				Actions.click(POM_Connections.disconnect);
				Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
				Actions.click(POM_Posts.popup_Yes);
				Actions.Mobile_waitforelement(POM_Connections.conct);
				Actions.click(POM_Connections.conct);
				Actions.Mobile_waitforelement(POM_Connections.folw);
				Actions.click(POM_Connections.folw);
				Actions.Mobile_waitforelement(POM_Connections.following);
		 		
			    break;
		 	}
		 default:
		 	{
		 		System.out.println("No Matched getData Found");
		 		
		 	}
			 
		 }
	}
	
	public static void UnFollowUser()
	{
		Actions.Mobile_waitforelement(POM_Connections.psttitle);
		if(Actions.verifyElementPresent(POM_Connections.following))
		{
			Actions.pause(2);
			Actions.click(POM_Connections.following);
			Actions.Mobile_waitforelement(POM_Connections.unfolw);
			Actions.click(POM_Connections.unfolw);
			
		}
		Actions.pause(3);
		
		
	}

	public static void F2f()
	{
		Actions.click(POM_Connections.Ficon);
		Actions.Mobile_waitforelement(POM_Connections.folw);
		Actions.click(POM_Connections.folw);
		
	}
	public static void UnF2f()
	{
		Actions.click(POM_Connections.Ficon);
		Actions.Mobile_waitforelement(POM_Connections.unfolw);
		Actions.click(POM_Connections.unfolw);
		
	}
	
	public static void FtoDisconnect()
	{
		Actions.click(POM_Connections.Ficon);
		Actions.Mobile_waitforelement(POM_Connections.disconnect);
	    Actions.click(POM_Connections.disconnect);
	    Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
		Actions.click(POM_Posts.popup_Yes);
	    
	}
	
	public static void switchToGroups()
	{
		Actions.click(POM_Connections.Groups);
		Actions.pause(4);
		
	}
	
	public static void verifygroupinfo()
	{
		Actions.Mobile_waitforelement(POM_Connections.department);
		Actions.verifyElement(POM_Connections.department);
		Actions.verifyElement(POM_Connections.skills);
		Actions.verifyElement(POM_Connections.grouptypeID);
		Actions.verifyElement(POM_Connections.Statusid);
		Actions.Mobile_scrolltoexact("Updated Date");
		Actions.verifyElement(POM_Connections.Admin);
		Actions.verifyElement(POM_Connections.isonlyAdmin);
		Actions.verifyElement(POM_Connections.createdDate);
		Actions.verifyElement(POM_Connections.update);
		
		
	}
	
	public static void groupTypeID(String matchvalue1, String matchvalue2)
	{
		Actions.Mobile_scrolltoexact("Department");
		Actions.mobile_StoreandMatch(POM_Connections.publicname, matchvalue1);
		Actions.mobile_Longpress(POM_Connections.grouptypeID);
		Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
		Actions.click(POM_Posts.popup_Yes);
		Actions.Mobile_waitforelement(POM_Connections.privatename);
		Actions.mobile_StoreandMatch(POM_Connections.privatename, matchvalue2);
		Actions.mobile_Longpress(POM_Connections.grouptypeID);
		Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
		Actions.click(POM_Posts.popup_Yes);
		Actions.Mobile_waitforelement(POM_Connections.publicname);
	}
	
	public static void sendgroupReqst(String user)
	{
		Actions.click(POM_Connections.GrpInviteUsr);
		Actions.Mobile_waitforelement(POM_Connections.GrpUsr_search);
		Actions.type(POM_Connections.GrpUsr_search, user);
		Actions.pause(2);
		Actions.click(POM_Connections.userchkbox);
		Actions.click(POM_Connections.ok);
		
	}
	
	public static void members(String user1, String user2)
	{
		Actions.click(POM_Connections.members);
		List<WebElement> membernames=Utility.driver.findElements(By.id("com.infor.mingle:id/tvItemName"));
		for(int i=0; i<membernames.size();i++)
		{
			String text=membernames.get(i).getText();
			System.out.println(text);
			if(text.contains(user1) || text.contains(user2))
			{
				System.out.println("Members are present");
			}
			else
			{
				System.out.println("No users found or users not in the list");
			}
		}
		Actions.verifyElement(POM_Connections.Dir_UserItem);
	}
	
	public static void GroupPost(String pstmsg)
	{
		switchtoposts();
		text=pstmsg+UUID.randomUUID().toString();
		Actions.click(POM_Connections.grpmsge);
		Actions.Mobile_waitforelement(POM_Posts.posttext);
		Actions.type(POM_Posts.posttext, text);
		RU_Posts.Attachment();
		Actions.mobile_Longpress(POM_Posts.longpressAttmnt);
		Actions.Mobile_waitforelement(POM_Posts.DltCmnt);
		Actions.click(POM_Posts.deletebtn);
		Actions.Mobile_waitforelement(POM_Posts.popup_Yes);
		Actions.click(POM_Posts.popup_Yes);
		Actions.pause(2);
		RU_Posts.selectlocation();
		Actions.click(POM_Posts.prvcydropdown);
		Actions.click(POM_Posts.sendpst);
		Actions.pause(5);
		
		
    }
	public static void verifyPost()
	{
		Actions.mobile_StoreandMatch(POM_Posts.editpost,text);
	}
	


}
