package step_definitions;



import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.PreOnboarding;
import pageobjects.CommonMethods;

public class PreOnboardingSteps{
	
	public IOSDriver<IOSElement> driver;
	PreOnboarding preon;
	CommonMethods common;
	 
	public PreOnboardingSteps()
    {
    	driver = Launcher.driver;
    	preon = new PreOnboarding(driver);
    	common = new CommonMethods(driver);
    }

}
