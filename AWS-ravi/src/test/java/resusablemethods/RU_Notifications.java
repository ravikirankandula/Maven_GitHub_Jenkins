package resusablemethods;


import actions.Actions;
import objectrepository.Social.POM_Loginpage;
import objectrepository.Social.POM_Notifications;

public class RU_Notifications {
	
	public static void Notification_Navigation()
	{
		Actions.click(POM_Loginpage.Menubar);
		Actions.Mobile_waitforelement(POM_Notifications.Notifications);
		Actions.click(POM_Notifications.Notifications);
		Actions.pause(2);
	}

	public static void AcceptConnectionrequest()
	{
		Notification_Navigation();
		Actions.Mobile_waitforelement(POM_Notifications.AcceptNoti);
		Actions.click(POM_Notifications.AcceptNoti);
		Actions.pause(5);
		
		
	}
	
	public static void Notifications_Arrow()
	{
		Actions.Mobile_waitforelement(POM_Notifications.NotictnArrw);
		Actions.click(POM_Notifications.NotictnArrw);
		
	}
	

}
