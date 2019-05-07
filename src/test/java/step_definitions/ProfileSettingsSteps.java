/**
 * 
 */
package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author ravibadugu
 *
 */
public class ProfileSettingsSteps {
	
	public IOSDriver<IOSElement> driver;
	public WebDriverWait wait;
	
	AccountSettingsPage AccountSettings;
	ProfileSettingsPage profile;
	CommonMethods common;
	SettingsMainPage settings;
	//InAppNotificationSettingsPage NotificationSettings;
	
	public ProfileSettingsSteps()
    {
		driver = Launcher.driver;
		wait = Launcher.wait;
    	AccountSettings = new AccountSettingsPage(driver);
    	profile = new ProfileSettingsPage(driver);
    	common = new CommonMethods(driver);
    	settings = new SettingsMainPage(driver);
    	//NotificationSettings = new InAppNotificationSettingsPage(driver);
    }
	
	@When("I edit profile")
	public void I_edit_profile() throws Throwable {
		System.out.println("Executing: I edit profile");
		common.TapOn(settings.ProfileEditButton);
	}
		
	// ToDo - extend it in the future
	@When("^I update (.*?) on profile page$")
	public void I_update_field_on_profile_page(String field) throws Throwable {
		System.out.println("Executing: When I update "+field+" on profile page");
		switch (field) {
		case "Date Of Birth": 
			profile.BirthdayProfileSettings.click();
			break;
		case "Gender": 
			profile.GenderProfileSettings.click();
			break;
		case "Height": 
			profile.HeightProfileSettings.click();
			common.scroll(driver, "vertically", 0.7, 0.8);
			common.DoneButton.click();
			break;
		case "Location": 
			profile.LocationProfileSettings.click();
			profile.UpdateLocationButton.click();
			int isAllowed = driver.findElementsById("Allow").size();
			if (isAllowed > 0) {
				common.TapOn(common.AllowButton);
			}
			break;
		}
	}

	@When("^I set Motivation to (.*?)$")
	public void I_set_motivation_in_settings(String motivation) throws Throwable {
		System.out.println("Executing: When I set Motivation to "+motivation);
		common.TapOn(profile.UpdateMotivationLabel);
		// Swipe one by one first top, then bottom, until correct motivation set
		wait.until(ExpectedConditions.visibilityOf(profile.UpdateMotivationValue));
		String selectedMotivation = profile.UpdateMotivationValue.getAttribute("label");
		if (selectedMotivation.equals(motivation)) {
			common.TapOn(common.SaveNavButton);
			Thread.sleep(3000);
			return;
		}
		for (int i = 0; i < 6; i++) {
			System.out.println("Looping to top number "+i);
			common.tapByCoordinates(driver, 150, 368);
			selectedMotivation = profile.UpdateMotivationValue.getAttribute("label");
			if (selectedMotivation.equals(motivation)) {
				// Some motivations need extra settings
				if (motivation.equals("Manage my diabetes")) {
					common.TapOn(profile.UpdateMotivationMedication);
					common.TapOn(common.SaveNavButton);
					Thread.sleep(2000);
				}
				if (selectedMotivation.equals("Diabetes Prevention")) {
					common.TapOn(profile.UpdateMotivationHba1c);
					common.TapOn(common.SaveNavButton);
					Thread.sleep(2000);
				}
				common.TapOn(common.SaveNavButton);
				common.AssertIsDisplayed(profile.ChangeJourneyWarningOnSave);
				common.TapOn(profile.YesSureButton);
				Thread.sleep(3000);
				return;
			}			
		}
		for (int i = 0; i < 6; i++) {
			System.out.println("Looping to bottom number "+i);
			common.tapByCoordinates(driver, 150, 448);
			
			selectedMotivation = profile.UpdateMotivationValue.getAttribute("label");
			if (selectedMotivation.equals(motivation)) {
				// Some motivations need extra settings
				if (motivation.equals("Manage my diabetes")) {
					common.TapOn(profile.UpdateMotivationMedication);
					common.TapOn(common.SaveNavButton);
					Thread.sleep(2000);
				}
				if (selectedMotivation.equals("Diabetes Prevention")) {
					common.TapOn(profile.UpdateMotivationHba1c);
					common.TapOn(common.SaveNavButton);
					Thread.sleep(2000);
				}
				common.TapOn(common.SaveNavButton);
				common.AssertIsDisplayed(profile.ChangeJourneyWarningOnSave);
				common.TapOn(profile.YesSureButton);
				Thread.sleep(3000);
				return;
			}			
		}
	}
	
	@When("^I ensure Motivation is not (.*?)$")
	public void I_ensure_motivation_is_not(String motivation) throws Throwable {
		System.out.println("Executing: When I ensure Motivation is not "+motivation);
		common.TapOn(profile.UpdateMotivationLabel);
		wait.until(ExpectedConditions.visibilityOf(profile.UpdateMotivationValue));
		// Swipe one by one first top, then bottom, until correct motivation set
		String selectedMotivation = profile.UpdateMotivationValue.getAttribute("label");
		if (selectedMotivation.equals(motivation)) {
			for (int i = 0; i < 6; i++) {
				System.out.println("Looping to top number "+i);
				common.tapByCoordinates(driver, 150, 368);
				selectedMotivation = profile.UpdateMotivationValue.getAttribute("label");
				if (!selectedMotivation.equals(motivation)) {
					// To facilitate test - we ignore the motivations with extra settings
					if (selectedMotivation.equals("Manage my diabetes") || selectedMotivation.equals("Diabetes Prevention")) {
						System.out.println("Skipping the motivation: "+selectedMotivation);
						continue;
					}
					else {
						common.TapOn(common.SaveNavButton);
						common.AssertIsDisplayed(profile.ChangeJourneyWarningOnSave);
						common.TapOn(profile.YesSureButton);
						System.out.println("Newly set motivation: "+selectedMotivation);
						Thread.sleep(3000);
						return;
					}					
				}			
			}
			for (int i = 0; i < 6; i++) {
				System.out.println("Looping to bottom number "+i);
				common.tapByCoordinates(driver, 150, 448);
				selectedMotivation = profile.UpdateMotivationValue.getAttribute("label");
				if (!selectedMotivation.equals(motivation)) {
					// To facilitate test - we ignore the motivations with extra settings
					if (selectedMotivation.equals("Manage my diabetes") || selectedMotivation.equals("Diabetes Prevention")) {
						System.out.println("Skipping the motivation: "+selectedMotivation);
						continue;
					}
					else {
						common.TapOn(common.SaveNavButton);
						common.AssertIsDisplayed(profile.ChangeJourneyWarningOnSave);
						common.TapOn(profile.YesSureButton);
						System.out.println("Newly set motivation: "+selectedMotivation);
						Thread.sleep(3000);
						return;
					}
					
				}			
			}
		}
		else {
			common.TapOn(common.SaveNavButton);
			Thread.sleep(3000);
			System.out.println("Motivation change not needed. Current motivation: "+selectedMotivation);
			return;
		}
	}


}
