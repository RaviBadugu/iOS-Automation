/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.AccountSettingsPage;
import pageobjects.InAppNotificationSettingsPage;
import pageobjects.LoginPage;
import pageobjects.PreOnboarding;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class AccountSettingsSteps {
	
	public IOSDriver<IOSElement> driver;
	AccountSettingsPage AccountSettings;
	CommonMethods common;
	
	public AccountSettingsSteps()
    {
		driver = Launcher.driver;
    	AccountSettings = new AccountSettingsPage(driver);
    	common = new CommonMethods(driver);
    }
	
	@Then("^I can change my units settings$")
	public void I_can_change_units_settings(List<String> units) throws Throwable {
		System.out.println("Executing: Then I can change my units settings");
		for (String singleElement : units) {
			driver.findElementByXPath("//XCUIElementTypeButton[@label =\""+singleElement+"\"]").click();
			int numberOfSelectedUnits = driver.findElementsByXPath("//XCUIElementTypeButton[@label = \""+singleElement+"\"][@value='1']").size();
			assertTrue("FAIL! Units: '"+singleElement+"' not selected", numberOfSelectedUnits > 0);
		}
	}

	@Then("^the Export data PopUp disappeared$")
	public void I_should_see_the_PopUp_message_disappeared() throws Throwable {
		System.out.println("Executing: Then the Export data PopUp disappeared");
		Thread.sleep(3000);
		int numberOfPopups = driver.findElementsByXPath("//XCUIElementTypeStaticText[contains(@name,'Your data is being prepared')]").size();
		assertTrue("FAIL! The popup is still displayed", numberOfPopups == 0);
	}

}
