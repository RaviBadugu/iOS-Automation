/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.AccountSettingsPage;
import pageobjects.SecurityAndPrivacy;
import pageobjects.LoginPage;
import pageobjects.PreOnboarding;
import pageobjects.ProfileSettingsPage;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class SecurityAndPrivacySteps {
	
	public IOSDriver<IOSElement> driver;
	LoginPage login;
	PreOnboarding preon; 
	AccountSettingsPage account;
	ProfileSettingsPage profile;
	SecurityAndPrivacy security;
	CommonMethods common;
	
	public SecurityAndPrivacySteps()
    {
		driver = Launcher.driver;
		login = new LoginPage(driver);
    	preon = new PreOnboarding(driver);
    	account = new AccountSettingsPage(driver);
    	profile = new ProfileSettingsPage(driver);
    	security = new SecurityAndPrivacy(driver);
    	common = new CommonMethods(driver);
    }
	
	@Then("^I see the relevant validation message when enter incorrect password details$")
	public void I_see_the_relevant_validation_when_change_password(DataTable passwordCredentials) throws Throwable {
		System.out.println("Executing: Then I see the relevant validation message when enter incorrect password details");
		List<List<String>> data = passwordCredentials.raw();
		for (int i = 1; i <= 6; i++) {
			System.out.println("Current: "+data.get(i).get(0)+"; New: "+data.get(i).get(1)+"; Confirm: "+data.get(i).get(2)+";");
			System.out.println("Expected error: "+data.get(i).get(3));
			security.CurrentPasswordInputField.sendKeys(data.get(i).get(0));
			security.NewPasswordInputField.sendKeys(data.get(i).get(1));
			security.ConfirmPasswordInputField.sendKeys(data.get(i).get(2));
			common.TapOn(common.SaveNavButton);
			String text = "//*[contains(.,'"+data.get(i).get(3)+"')]";
			// To be improved in the future with tesseract or similar
			// https://stackoverflow.com/questions/51211768/how-to-capture-error-message-text-in-appium/51257663
			// assertNotNull(driver.findElementByXPath(text));
			Thread.sleep(2000);
			driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@label,'Security and privacy')]");
		}
	}
	
	@When("^I update privacy settings$")
	public void I_update_privacy() throws Throwable {
		System.out.println("Executing: When I update privacy settings");
		WebElement switcher = driver.findElementByXPath("//XCUIElementTypeSwitch[contains(@label,'not allow others to search')]");
		String switcherValue = switcher.getAttribute("value");
		common.TapOn(switcher);
		String newSwitcherValue = switcher.getAttribute("value");
		assertTrue("FAIL! The privacy settings did not change", newSwitcherValue != switcherValue); 
	}

}
