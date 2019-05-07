/**
 * 
 */
package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.HelpAndSupportPage;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class HelpAndSupportSteps {
	
	public IOSDriver<IOSElement> driver;
	HelpAndSupportPage helpandsupport;
	CommonMethods common;
	
	public HelpAndSupportSteps()
    {
		driver = Launcher.driver;
    	helpandsupport = new HelpAndSupportPage(driver);
    	common = new CommonMethods(driver);
    }

}
