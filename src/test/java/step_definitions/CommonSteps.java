/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSElement;

import com.sun.jna.platform.win32.Advapi32Util.Account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import pageobjects.*;

/**
 * @author rado
 *
 */
public class CommonSteps {

	public IOSDriver<IOSElement> driver;
	LoginPage login;
	PreOnboarding preon;
	ProgressPage progress;
	ActionPlanPage plan;
	ChallengePage challenge;
	LibraryPage library;
	AccountSettingsPage account;
	TrackersPage trackers;
	CommonMethods common;
	SettingsMainPage settings;
	ProfileSettingsPage profile;
	SecurityAndPrivacy security;
	RewardsPage rewards;
	RegistrationandOnboardingPage register;
	TimelinePage timeline;
	InAppNotificationSettingsPage notification;
	HelpAndSupportPage help;
	JourneysObjects journey;


	public CommonSteps() {
		driver = Launcher.driver;
		login = new LoginPage(driver);
		preon = new PreOnboarding(driver);
		progress = new ProgressPage(driver);
		plan = new ActionPlanPage(driver);
		challenge = new ChallengePage(driver);
		library = new LibraryPage(driver);
		account = new AccountSettingsPage(driver);
		trackers = new TrackersPage(driver);
		common = new CommonMethods(driver);
		settings = new SettingsMainPage(driver);
		profile = new ProfileSettingsPage(driver);
		security = new SecurityAndPrivacy(driver);
		rewards = new RewardsPage(driver);
		register = new RegistrationandOnboardingPage(driver);
		timeline = new TimelinePage(driver);
		notification = new InAppNotificationSettingsPage(driver);
		help = new HelpAndSupportPage(driver);
		journey = new JourneysObjects(driver);
	}

	@Given("^I am logged in with email: \'(.*?)\' and password: \'(.*?)\'( and do not skip the FTE page)?$")
	public void I_am_logged_in_with_credentials(String email, String password, String skip) throws Throwable {
		System.out.println("Executing: Given I am logged in with email: "+email+" and password: "+password+" "+skip);
		String username = email;
		String pswd = password;
		common.TapOn(preon.SkipButton);
		Thread.sleep(5000);
		
		// Switch to Login, if not already there
		int isTYEScreenAHA = driver.findElementsById("Already have an account? Log in").size();
		if (isTYEScreenAHA > 0) {
			System.out.println("Switching from Signup to Login page...");
			common.TapOn(login.alreadyHaveAccount);
			Thread.sleep(5000);
		}

		login.enterEmail(username).enterPassword(pswd);
		common.TapOn(login.loginbutton);
		Thread.sleep(3000);

		int isTYEScreenSkip = driver.findElementsById("Skip").size();
		if (isTYEScreenSkip > 0) {
			System.out.println("Skipping 'Track Your Exercise - skip' screen");
			common.TapOn(trackers.TapOnSkipButtonInTrackYourExercise);
			Thread.sleep(3000);
		}

		int isTYEScreenNext = driver.findElementsById("Next").size();
		if (isTYEScreenNext > 0) {
			System.out.println("Skipping 'Track Your Exercise - next' screen");
			common.TapOn(trackers.TapOnNextButtonInTrackyourExerciseScreen);
			Thread.sleep(3000);
		}

		common.TapOn(login.NotRightNowButton);

		if (skip == null) {
			Thread.sleep(6000);
			int isFTE = driver.findElementsById("Skip").size();
			if (isFTE > 0) {
				System.out.println("Skipping 'FTE' screen");
				common.TapOn(common.SkipButton);
			}
		}
	}

	@When("^I enter \'(.*?)\' page$")
	public void I_enter_page(String page) throws Throwable {
		System.out.println("Executing: When I enter "+page+" page");
		Thread.sleep(5000);
		switch (page) {
		case "Progress":
			common.TapOn(progress.NavProgressButton);
			common.AssertIsDisplayed(progress.ProgressPageHeaderTitle);
			break;
		case "Home":
			common.TapOn(timeline.NavHome);
			break;
		case "Plans":
			common.TapOn(plan.navPlansButton);
			break;
		case "Plan":
			common.TapOn(journey.navPlanButton);
			break;
		case "Challenges":
			common.TapOn(challenge.challengesbutton);
			break;
		case "Library":
			common.TapOn(library.NavLibrary);
			break;
		case "Connected trackers":
			common.TapOn(account.AccountIcon);
			common.TapOn(trackers.TapOnConnectedTrackers);
			break;
		case "Settings":
			common.TapOn(account.AccountIcon);
			break;
		case "Account Settings":
			common.TapOn(account.AccountIcon);
			common.TapOn(settings.AccountEditButton);
			break;
		case "Profile Settings":
			common.TapOn(account.AccountIcon);
			common.TapOn(settings.ProfileEditButton);
			break;
		case "Security and Privacy Settings":
			common.TapOn(account.AccountIcon);
			common.TapOn(settings.SecurityAndPrivacyButton);
			break;
		case "Notifications Settings":
			common.TapOn(account.AccountIcon);
			common.TapOn(settings.NotificationsButton);
			break;
		case "Help":
			common.TapOn(account.AccountIcon);
			common.TapOn(help.HelpAndSupportButton);
			break;
		}
	}

	// ToDo
	@Then("^I am on \'(.*?)\' page$")
	public void I_am_on_page(String expectedPage) throws Throwable {
		System.out.println("Executing: Then I am on "+expectedPage+" page");
		Thread.sleep(3000);
		switch (expectedPage) {
		case "Login":
			driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@label,'Login to')]");
			break;
		case "Start Login":
			common.TapOn(preon.SkipButton);
			Thread.sleep(5000);
			int isTYEScreenAHA = driver.findElementsById("Already have an account? Log in").size();
			if (isTYEScreenAHA > 0) {
				System.out.println("Switching from Signup to Login page...");
				common.TapOn(login.alreadyHaveAccountButton);
				Thread.sleep(5000);
			}
			driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@label,'Login to')]");
			break;
		case "Preonboarding":
			assertTrue("FAIL! Preonboarding page not displayed", common.SkipButton.isDisplayed());
			break;
		case "Terms and Conditions view":
			Thread.sleep(5000);
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[contains(@name,'TermsAndConditionsView')]");
			break;
		case "Terms and Conditions webview":
			Thread.sleep(4000);
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[contains(@name,'LegalPolicyView')]");
			break;
		case "Data Privacy":
			Thread.sleep(5000);
			driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Data Privacy\"]");
			break;
		case "Data Privacy webview":
			Thread.sleep(5000);
			driver.findElementsByXPath("//XCUIElementTypeOther[@name=\"article\"][XCUIElementTypeOther[contains(@name,'Privacy Policy')]]");
			break;
		case "Signup":
			common.TapOn(preon.SkipButton);
			Thread.sleep(5000);
			// Switch to Registration page (if not there already)
			// Disabled until freely register
//			int isTYEScreenCA = driver.findElementsById("Create an account").size();
//			if (isTYEScreenCA > 0) {
//				System.out.println("Switching from Login to Signup page...");
//				common.TapOn(register.CreateAnAccountButton);
//				Thread.sleep(5000);
//			}
			break;
		case "Help":
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			assertTrue("FAIL! Home page not displayed", help.FAQsButton.isDisplayed());
			break;
		case "Send feedback":
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			assertTrue("FAIL! Privacy Policy page not displayed", help.SendFeedbackButton.isDisplayed());
			break;
		case "FAQ":
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			assertTrue("FAIL! FAQ page not displayed", help.FAQsButton.isDisplayed());
			break;
		case "Terms of Use and Privacy Policy":
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			assertTrue("FAIL! Terms and Conditions page not displayed", help.TermsOfUseAndPrivacyPolicyButton.isDisplayed());
			break;
		default:
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"" + expectedPage + "\"]");
			break;
		}
	}

	@When("^I tap on the \'(.*?)\'$")
	public void I_tap_on(String tapElement) throws Throwable {
		WebElement tapMe = null;
		System.out.println("Executing: When I tap on the "+tapElement);
		tapMe = common.elementMatcher(tapElement);
		common.TapOn(tapMe);
	}

	@Then("^I( do not)? see the following text on page: \'(.*?)\'$")
	public void I_see_the_text_on_page(String doNot, String searchedText) throws Throwable {
		System.out.println("Executing: Then I see the following text on page: "+searchedText);
		String text = "//*[contains(@value,'" + searchedText + "')]";
		if (doNot == null) {
			assertTrue(driver.findElementsByXPath(text).size() >= 1);
		}
		else {
			Thread.sleep(3000);
			assertTrue("The text is still on page", driver.findElementsByXPath(text).size() < 1);
		}
	}

	@Then("^I should see the following element on page: \'(.*?)\'$")
	public void I_should_see_the_element_on_page(String searchedElement) throws Throwable {
		System.out.println("Executing: Then I should see the following element on page: "+searchedElement);
		WebElement element = null;
		element = common.elementMatcher(searchedElement);
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		assertTrue("FAIL! "+searchedElement+" is not displayed",element.isDisplayed());
	}

	@Then("^I see following elements on page:$")
	public void I_see_elements_table(List<String> searchedElements) throws Throwable {
		System.out.println("Executing: Then I see list of elements on page");
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement element = null;
		for (String singleElement : searchedElements) {
			System.out.println("searching element... "+singleElement);
			element = common.elementMatcher(singleElement);
			assertTrue("FAIL! Following element not displayed: " + singleElement, element.isDisplayed());
		}
	}

	@Then("^I see at least (\\d+) instance of \'(.*?)\' element on page$")
	public void I_see_at_least_number_of_elements(int number, String searchedElement) throws Throwable {
		System.out.println("Executing: Then I see at least "+number+" instance of "+searchedElement+" element on page");
		String element = null;
		switch (searchedElement) {
		case "Progress Widget":
		case "Challenge tile":
		case "Rewards tile":
		case "Timeline card":
			element = "//XCUIElementTypeCell[@visible='true']";
			break;
		case "Tracker name":
			element = "//XCUIElementTypeButton/following-sibling::XCUIElementTypeStaticText";
			break;
		case "Single datapoint":
			element = "//XCUIElementTypeCell";
			break;
		case "Single datapoint with edit":
			element = "//XCUIElementTypeCell/*[contains(@label,'Edit')]";
			break;
		case "item tile":
			element = "//XCUIElementTypeCell";
			break;
		}
		Thread.sleep(3000);
		common.NumberOfOccurance = driver.findElementsByXPath(element).size();
		assertTrue("FAIL! There are "+common.NumberOfOccurance+" elements on page",common.NumberOfOccurance >= number);
	}

	@When("^I type in the following string into (.*?) input field: \'(.*?)\'$")
	public void I_type_in_string_into_input_field(String inputField, String typedString) throws Throwable {
		System.out.println("Executing: When I type in the following string into "+inputField+" input field: "+typedString);
		WebElement inputFieldLocator = null;
		switch (inputField) {
		case "Email":
			inputFieldLocator = profile.EmailInputField;
			break;
		case "First name":
			inputFieldLocator = profile.FirstNameInputField;
			break;
		case "Last name":
			inputFieldLocator = profile.LastNameInputField;
			break;
		case "Display name":
			inputFieldLocator = profile.DisplayNameInputField;
			break;
		case "Current password":
			inputFieldLocator = security.CurrentPasswordInputField;
			break;
		case "New password":
			inputFieldLocator = security.NewPasswordInputField;
			break;
		case "Confirm password":
			inputFieldLocator = security.ConfirmPasswordInputField;
			break;
		}
		inputFieldLocator.clear();
		if (typedString != null && !typedString.isEmpty()) {
			switch (inputField) {
			case "Email":
			case "Current password":
			case "New password":
			case "Confirm password":
				System.out.println("Setting email to: " + typedString);
				inputFieldLocator.sendKeys(typedString);
				break;
			default:
				String StringToType = typedString + common.getDateTime("DateTimeSettingsString");
				System.out.println("Setting value to: " + StringToType);
				inputFieldLocator.sendKeys(StringToType);
				break;
			}
		}
	}

	@Then("^I see following labels on page:$")
	public void I_can_change_units_settings(List<String> labels) throws Throwable {
		System.out.println("Executing: Then I see list of labels on page");
		for (String singleElement : labels) {
			System.out.println("searching for element... "+singleElement);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(4000);
			WebElement searchedLabel = driver
					.findElementByXPath("//XCUIElementTypeStaticText[contains(@label,\"" + singleElement + "\")]");

			// Thread.sleep(2000); insted of Thread.sleep using implicitwait below
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			assertTrue("FAIL! Label missing: " + singleElement, searchedLabel.isDisplayed());
		}
	}

	@When("^I scroll page to the (top|bottom)$")
	public void I_scroll_page_direction(String direction) throws Throwable {
		System.out.println("Executing: When I scroll page to the " + direction);
		switch (direction) {
		case "bottom":
			common.scrollPage(driver, "bottom");
			break;
		case "top":
			common.scrollPage(driver, "top");
			break;
		}
	}
	
	@When("^I scroll page (\\d+) time (up|down)$")
	public void I_scroll_page_times_direction(int times, String direction) throws Throwable {
		System.out.println("Scrolling to direction: '" + direction + "'");
		switch (direction) {
		case "up":
			for (int i = 1; i <= times; i++) {
				common.scroll(driver, "vertically", 0.1, 0.8);
			}
			break;
		case "down":
			for (int i = 1; i <= times; i++) {
				common.scroll(driver, "vertically", 0.9, 0.2);
			}
			break;
		}
	}
}