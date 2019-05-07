/**
 * 
 */
package step_definitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.AccountSettingsPage;
import pageobjects.LoginPage;
import pageobjects.PreOnboarding;
import pageobjects.TrackersPage;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class TrackersSteps {
	
	public IOSDriver<IOSElement> driver;
	LoginPage login;
	PreOnboarding preon; 
	AccountSettingsPage AccountSettings;
	TrackersPage trackers;
	CommonMethods common;
	
	@SuppressWarnings("unchecked")
	public TrackersSteps()
    {
		driver = Launcher.driver;
		login = new LoginPage(driver);
    	preon = new PreOnboarding(driver);
    	AccountSettings = new AccountSettingsPage(driver);
    	trackers = new TrackersPage(driver);
    	common = new CommonMethods(driver);
    }
	

	@When("^I tap on Connected Trackers option$")
	public void I_tap_on_Connected_Trackers_option() throws Throwable {
		System.out.println("Executing When");
		trackers.TappingOnConnectedTrackers();
	}

	@Then("^I Should navigate to Trackers Screen$")
	public void I_Should_navigate_to_Trackers_Screen() throws Throwable {
		System.out.println("Executing Then");
		trackers.VerifyingTrackersPageTittle("Trackers");
	}

	@Then("^I Should see list of trackers in Recommended and More Trackers section with Connected trackers section if any connected$")
	public void I_Should_see_list_of_trackers_in_Recommended_and_More_Trackers_section_with_Connected_trackers_section_if_any_connected() throws Throwable {
		System.out.println("Executing Then");
		trackers.VerifyingRecommendedTrackersSection("RECOMMENDED TRACKERS");
		trackers.VerifyingMoreTrackersSection("MORE TRACKERS");
	}
	
	@When("^I connect (.*?) tracker$")
	public void I_connect_tracker(String tracker) throws Throwable {
		System.out.println("Executing When");
		Thread.sleep(12000);
		int isConnected = driver.findElementsByXPath("//XCUIElementTypeCell/XCUIElementTypeButton[@name='Connect'][../XCUIElementTypeStaticText[@name='"+tracker+"']]").size();
		if (isConnected < 1) {
			WebElement DisconnectButton = driver.findElementByXPath("//XCUIElementTypeCell/XCUIElementTypeButton[@name='Disconnect'][../XCUIElementTypeStaticText[@name='"+tracker+"']]");
			common.TapOn(DisconnectButton);
			Thread.sleep(5000);
		}
		switch (tracker) {
		case "Fitbit":
			common.TapOn(trackers.ConnectButtonFitbit);
			Thread.sleep(10000);
			trackers.FitbitWebViewLoginTextField.sendKeys("radoslaw+2@tictrac.com");
			trackers.FitbitWebViewPasswordTextField.sendKeys("tictrac2012");
			common.TapOn(trackers.FitbitWebViewLoginButton);
			//to be removed when issue fixed
			WebElement DoneButtonWebView = driver.findElementById("Done");
			common.TapOn(DoneButtonWebView);
			// End of issue to delete
			Thread.sleep(10000);
			break;
		case "Apple Health":
			common.TapOn(trackers.ConnectButtonAppleHealth);
			Thread.sleep(5000);
			common.TapOn(trackers.AppleHealthTurnAllCategoriesOnButton);
			common.TapOn(trackers.AppleHealthAllowButton);
			Thread.sleep(5000);
			int SyncingAH = driver.findElementsByXPath("//XCUIElementTypeCell/XCUIElementTypeButton[contains(@name,'Syncing')][../XCUIElementTypeStaticText[@name='"+tracker+"']]").size();
			while (SyncingAH > 0) {
				Thread.sleep(3000);
			}
			break;
		}
	}
	
	@Then("^the (.*?) tracker is connected$")
	public void tracker_is_connected(String tracker) throws Throwable {
		System.out.println("Executing Then");
		WebElement DisconnectButton = driver.findElementByXPath("//XCUIElementTypeCell/XCUIElementTypeButton[@name='Disconnect'][../XCUIElementTypeStaticText[@name='"+tracker+"']]");
		common.AssertIsDisplayed(DisconnectButton);
	}

	@Then("^Once I login It Should navigate back to Trackers screen with Disconnect button update on connected tracker$")
	public void Once_I_login_It_Should_navigate_back_to_Trackers_screen_with_Disconnect_button_update_on_connected_tracker() throws Throwable {
		System.out.println("Executing Then");
		//trackers.VerifyingDisconnectBtnTextInFitbitTracker("Disconnect");
		
	}

	//@Trackers3
	@When("^I tap on Disconnect button next to any connected tracker$")
	public void I_tap_on_Disconnect_button_next_to_any_connected_tracker() throws Throwable {
		System.out.println("Executing When");
		trackers.TappingOnDisconnectButtonInFitbit();
	}

	@Then("^I should see the tracker disconneted and button update change from disconnect to connect$")
	public void I_should_see_the_tracker_disconneted_and_button_update_change_from_disconnect_to_connect() throws Throwable {
		System.out.println("Executing Then");
		trackers.VerifyingConnectBtnInTrackerScreen("Connect");
	}

	@When("^I go the trackers page and click the more info link$")
	public void I_go_the_trackers_page_and_click_the_more_info_link() throws Throwable {
		System.out.println("Executing When");
		common.TapOn(trackers.TapOnTracksWorkButton);
		
	}

	@Then("^I should be taken to the tracker information page$")
	public void I_should_be_taken_to_the_tracker_information_page() throws Throwable {
		System.out.println("Executing Then");
		common.AssertTextOfElement(trackers. VerifyTrackerInfoTitle, "How trackers work in the app");
		

	}
	
	

}
