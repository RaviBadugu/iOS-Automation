package step_definitions;

/**
 * @author ravibadugu
 *
 */
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ActionPlanPage;
import pageobjects.CommonMethods;

public class ActionPlanSteps {
	
	public IOSDriver<IOSElement> driver;
	ActionPlanPage actionPlan;
	CommonMethods common;
	
	public ActionPlanSteps()
    {
		driver = Launcher.driver;
    	actionPlan = new ActionPlanPage(driver);
    	common = new CommonMethods(driver);
    	
    }
	
	
}


