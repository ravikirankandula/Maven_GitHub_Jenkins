package resusablemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.Actions;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.Social.POM_ManualQRCodeEntry;


public class RU_QRProcess {
	


	public static void IonAPI_Setting(String Addprofile) 
	{
		Actions.click(POM_ManualQRCodeEntry.username);
		Actions.pause(2);
		
		Actions.Mobile_AKC_BACK();
		Actions.click(POM_ManualQRCodeEntry.Settings_ionApicheckbox);
		Actions.click(POM_ManualQRCodeEntry.settings_btn);
		
		Actions.Mobile_waitforelement(POM_ManualQRCodeEntry.Cancelbtn);
		Actions.click(POM_ManualQRCodeEntry.Cancelbtn);
		Actions.Mobile_waitfortext(POM_ManualQRCodeEntry.AddProfile, Addprofile);
			
	}
	
	public static void QRCodeManualEntry(String scrolltext,String profileName, String clientID, String clientSecret, String IONAPIHostAdress, String securityAuth, String AuthEndpnt, String tokenEndpnt, String revocationEndpnt, String TenanatID, String EnviornmentVariables)
	{ 
		
		Actions.type(POM_ManualQRCodeEntry.profilename, profileName);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_Clientid, clientID);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_Clientsecrt, clientSecret);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_ionapihostaddress, IONAPIHostAdress);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_serveraddrss, securityAuth);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_AuthEndpnt, AuthEndpnt);
		Actions.Mobile_scroll(scrolltext);
		Actions.type(POM_ManualQRCodeEntry.profile_tokenEndpnt, tokenEndpnt);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_recovationEndpnt, revocationEndpnt);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_TentID, TenanatID);
		Actions.Mobile_AKC_BACK();
		
		Actions.type(POM_ManualQRCodeEntry.profile_Environment, EnviornmentVariables);
		Actions.Mobile_AKC_BACK();
		
		Actions.click(POM_ManualQRCodeEntry.savesettings);
		Actions.Mobile_waitforelement(POM_ManualQRCodeEntry.goback);
		Actions.verifyElement(POM_ManualQRCodeEntry.profile);
		Actions.click(POM_ManualQRCodeEntry.goback);
		Actions.Mobile_waitforelement(POM_ManualQRCodeEntry.signinbtn);
		
		
			
	}
	
}
