package RM_TransAmerica;

import OR_TransAmerica.WelcomePage;
import actions.Actions;
//import objRepository.Social.ShellHeaderShareOverlay;

public class TransAmerica_Search {
	
	public static void Serach(String srchword)
	{
		Actions.verifyElement(WelcomePage.Navbar_Sear, "Wait till Search Element present on the page");
		Actions.click(WelcomePage.Navbar_Sear, "Click on Search From Navigation bar");
		Actions.verifyElement(WelcomePage.Srch_query, "Wait till Search QUery Element present");
		Actions.type(WelcomePage.srch_Go, srchword, "Click on Serach Go");
		Actions.verifyElement(WelcomePage.srch_Results, "Wait for Search Results appeared");
		
			
	}

}
