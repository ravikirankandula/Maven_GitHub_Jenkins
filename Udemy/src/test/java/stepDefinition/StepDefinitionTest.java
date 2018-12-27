package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LoginPage;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import BaseUtilies.BaseUtilities;
import actions.Actions;

@RunWith(Cucumber.class)
public class StepDefinitionTest {
	ExtentTest loggertest;
	private BaseUtilities base;
	
   
    @Given("^intialize browser with chrome$")
    public void intialize_browser_with_chrome() throws Throwable {
    	
    	System.out.println("ravi");
    	 base=new BaseUtilities();
         base.intialisedriver();
    	
    }

  
    @When("^user enters some input \"([^\"]*)\" in searchbox$")
    public void user_enters_some_input_something_in_searchbox(String strArg1) throws Throwable {
    	try {

			loggertest=base.initTest(this.getClass().getName());
			new Actions();
			Actions.type(LoginPage.obj_searchtextbox, "ravi", "Entered text in searchbox");
			Actions.click(LoginPage.obj_googlesearchbtn, "click on googlesearchbutton");
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
  //@AfterMethod
    @Then("^Search should be appeared$")
    public void search_should_be_appeared() throws Throwable {
    	BaseUtilities.extentreport.endTest(loggertest);
		BaseUtilities.extentreport.flush();
    }

 //@AfterClass
    @And("^navigate to the \"([^\"]*)\" site$")
    public void navigate_to_the_something_site(String strArg1) throws Throwable {
    	BaseUtilities.quitdriver();
    }

}