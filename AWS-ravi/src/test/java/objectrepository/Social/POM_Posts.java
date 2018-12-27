package objectrepository.Social;

import org.openqa.selenium.By;

public class POM_Posts {
   public static final By posts=By.name("Posts");
	public static final By composebtn=By.id("com.infor.mingle:id/btnCompose");
	public static final By posttext=By.id("com.infor.mingle:id/txtNewPost");
	public static final By sendpst=By.id("com.infor.mingle:id/action_send");
	public static final By waitforpst=By.name("Just Now");
	
	//Attachment
	
	public static final By cameraicon=By.id("com.infor.mingle:id/btnAttachment");
	public static final By selctpic=By.xpath("//android.widget.ImageView[@index='0']");
	public static final By fileAttach=By.id("com.infor.mingle:id/btnFileAttachment");
	public static final By Docs=By.name("Documents");
	public static final By Gallery_Menu=By.xpath("//android.widget.ImageButton[@content-desc='Show roots']");
	public static final By images=By.name("Images");
	public static final By sdcard=By.id("com.android.documentsui:id/date");
	public static final By slctimg=By.id("com.android.documentsui:id/date");
	
	public static final By imgaftrpst=By.id("com.infor.mingle:id/iconPhotos");
	public static final By longpressAttmnt=By.xpath("//android.widget.ImageView[@index='0']");
	
	
	//Delete Post
	
	public static final By editpost=By.id("com.infor.mingle:id/tvMsgText");
	public static final By deletebtn=By.id("com.infor.mingle:id/action_delete");
	public static final By sharepost=By.id("com.infor.mingle:id/action_share_post");
	public static final By popup_Yes=By.name("Yes");
	public static final By popup_No=By.name("No");
	
	//privacy levels
	
	public static final By prvcydropdown=By.id("com.infor.mingle:id/btnPrivacyLevel");
	public static final By popup_cancel=By.name("Cancel");
	public static final By dropdown_connected=By.name("Connected Users");
	
	//tagg users search
	public static final By Usrsearch=By.id("com.infor.mingle:id/txtSearch");
	
	//back to previous
	public static final By backtoprev=By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	
	//location
	public static final By Location=By.id("com.infor.mingle:id/btnLocation");
	
	//Like post
	public static final By ivlikes=By.id("com.infor.mingle:id/ivLikes");
	
	public static final By tvlikes=By.id("com.infor.mingle:id/tvLikes");
	
	//Comments
	public static final By inputCmnt=By.id("com.infor.mingle:id/txtNewComment");
	public static final By sendCmnt=By.id("com.infor.mingle:id/btnSend");
	public static final By Cment_cuUer=By.id("com.infor.mingle:id/tvCommentCurrentUser");
	public static final By tvComments=By.id("com.infor.mingle:id/tvComments");
	public static final By DltCmnt=By.name("Delete");
	public static final By Cmnt_tagUsr=By.id("com.infor.mingle:id/tvCommentCU");
	
	//Share attachment
	
	public static final By imglink=By.id("com.infor.mingle:id/iconPhotos");
	public static final By shareimg=By.id("com.infor.mingle:id/icon");
	public static final By Email=By.name("Email");
	public static final By ToAdd=By.id("com.android.email:id/to");
	public static final By subject=By.id("com.android.email:id/subject");
	public static final By cmposeBody=By.id("com.android.email:id/body");
	public static final By sendmail=By.id("com.android.email:id/send");

   //user profile pic
	
	public static final By userpic=By.id("com.infor.mingle:id/ivAvatar");
	public static final By photolib=By.name("Photo Library");
	
}
