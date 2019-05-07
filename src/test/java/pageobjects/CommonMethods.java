package pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.runtime.Timeout;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import pageobjects.*;
import step_definitions.Launcher;

public class CommonMethods {
	public IOSDriver driver;
	public WebDriverWait wait;
	static TouchAction ta;
	static MultiTouchAction mta;
	static Dimension dimensions;
	public DateFormat dateFormat;
	
	LoginPage login; 
	PreOnboarding preon;
	ProgressPage progress;
	ActionPlanPage plan;
	ChallengePage challenge;
	LibraryPage library;
	AccountSettingsPage account;
	TrackersPage trackers;
	SettingsMainPage settings;
	ProfileSettingsPage profile;
	SecurityAndPrivacy security;
	RewardsPage rewards;
	RegistrationandOnboardingPage register;
	InAppNotificationSettingsPage notification;
	HelpAndSupportPage help;
	JourneysObjects journey;
	
	public CommonMethods(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		driver = Launcher.driver;	
		wait = Launcher.wait;
    	login = new LoginPage(driver);
    	preon = new PreOnboarding(driver);
    	progress = new ProgressPage(driver);
    	plan = new ActionPlanPage(driver);
    	challenge = new ChallengePage(driver);
    	library = new LibraryPage(driver);
    	account = new AccountSettingsPage(driver);
    	trackers = new TrackersPage(driver);
    	settings = new SettingsMainPage(driver);
    	profile = new ProfileSettingsPage(driver);
    	security = new SecurityAndPrivacy(driver);
    	rewards = new RewardsPage(driver);
    	register = new RegistrationandOnboardingPage(driver);
    	notification = new InAppNotificationSettingsPage(driver);
    	help =  new HelpAndSupportPage(driver);
    	journey = new JourneysObjects(driver);
	}
	
	// Elements
	
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar")
	public IOSElement PageNavTitle;
	public int NumberOfOccurance;
	
	@iOSFindBy(xpath="//XCUIElementTypeOther[@name=\"Account\"]")
	public IOSElement AccountMainHeaderTitle;
	
	@iOSFindBy(id="Close")
	public IOSElement CloseNavButton;
	
	@iOSFindBy(id="Edit")
	public IOSElement EditNavButton;
	
	@iOSFindBy(id="Save")
	public IOSElement SaveNavButton;
	
	@iOSFindBy(id="OK")
	public IOSElement OKButton;
	
	@iOSFindBy(id="Ok")
	public IOSElement OkButton;
	
	@iOSFindBy(id="Done")
	public IOSElement DoneButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeActivityIndicator[@name=\"In progress\"]")
	public IOSElement InProgressIndicator;
	
	@iOSFindBy(id="Allow")
	public IOSElement AllowButton;
	
	@iOSFindBy(id = "icon more")
	public IOSElement OverflowMenu;
	
	@iOSFindBy(id="Continue")
	public IOSElement ContinueButton;
	
	@iOSFindBy(id="Skip")
	public IOSElement SkipButton;
	
	@iOSFindBy(id="Next")
	public IOSElement NextButton;
	
	// Methods
	
	public void TapOn(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void AssertTextOfElement(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String elementText = element.getAttribute("label");
		assertTrue("This is what we are looking for: "+elementText+"\nAnd this is what we match to: "+text, elementText.contains(text));
	}
	
	public void AssertIsDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		assertTrue("FAIL! Element "+element+" not displayed",element.isDisplayed());
	}
	
	public void tapByCoordinates(IOSDriver driver, int startX, int startY) {
		ta = new TouchAction(driver);
		ta.tap(startX, startY).perform();
	}
	
	public void scroll(IOSDriver driver, String direction, double startPartOfPage, double endPartOfPage) {
		dimensions = driver.manage().window().getSize();
		ta = new TouchAction(driver);
    	mta = new MultiTouchAction(driver);
		Double screenScrollStart = null;
		Double screenScrollEnd = null;
		int scrollStart = 0;
		int scrollEnd = 0;
		switch (direction) {
		case "vertically":
			screenScrollStart = dimensions.getHeight() * startPartOfPage;
			screenScrollEnd = dimensions.getHeight() * endPartOfPage;
			break;
		case "horizontally":
			screenScrollStart = dimensions.getWidth() * startPartOfPage;
			screenScrollEnd = dimensions.getWidth() * endPartOfPage;
			break;
		}
		scrollStart = screenScrollStart.intValue();
		scrollEnd = screenScrollEnd.intValue();
		ta.press(20, scrollStart).waitAction(1000).moveTo(20, scrollEnd).release();
		mta.add(ta).perform();
	}
	
	public void scrollPage(IOSDriver driver, String direction) {
		// scroll page to the bottom
		ta = new TouchAction(driver);
    	mta = new MultiTouchAction(driver);
		dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.7;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		if (direction == "bottom") {
			for (int i = 0; i < 2; i++) {
				ta.press(20, scrollStart).waitAction(1000).moveTo(20, scrollEnd).release();
				mta.add(ta).perform();
			}
		}
		else if (direction == "top") {
			for (int i = 0; i < 2; i++) {
				ta.press(20, scrollEnd).waitAction(1000).moveTo(20, scrollStart).release();
				mta.add(ta).perform();
			}
		}
		else {
			System.out.println("Direction not recognised");
		}
		System.out.println("Scrolling ended");
	}
	
	public String getDateTime(String theFormat) {
		switch (theFormat) {
		case "DateTimeSettingsString": dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");break;		
		}
		Date date = new Date();
		String date1= dateFormat.format(date);
		return date1;
	}
	
	public WebElement elementMatcher(String element) {
		WebElement finalElement = null;
		switch (element) {
		// Common
		case "Close navigation button": finalElement = CloseNavButton; break;
		case "Edit navigation button": finalElement = EditNavButton; break;
		case "Save navigation button": finalElement = SaveNavButton; break;
		case "OK button": finalElement = OKButton; break;
		case "Ok button": finalElement = OkButton; break;
		case "Save button": finalElement = SaveNavButton; break;
		case "Allow button": finalElement = AllowButton; break;
		case "Continue button": finalElement = ContinueButton; break;
		case "Done button": finalElement = DoneButton; break;
		// Registration
		case "TandC link": finalElement = register.TandCLink; break;
		case "Data Privacy link": finalElement = register.PrivacyPolicyLink; break;
		// Progress
		case "Add Goal button": finalElement = progress.AddGoalButton; break;
		case "Progress header": finalElement = progress.ProgressPageHeaderTitle; break;
		case "Fact section": finalElement = progress.FactSectionOnWidgetDetail; break;
		case "First Edit button": finalElement = progress.FirstEditDatapointButton; break;
		case "Delete button": finalElement = progress.DeleteDatapointButton; break;
		// Settings
		case "Account header": finalElement = AccountMainHeaderTitle; break;
		case "user avatar": finalElement = settings.AccountMainUserAvatar; break;
		case "user name": finalElement = settings.AccountMainUsername; break;
		case "user motivation": finalElement = settings.AccountMainUserMotivation; break;
		case "Connected trackers button": finalElement = settings.AccountMainConnectedTrackersNavButton; break;
		case "Friends button": finalElement = settings.AccountMainFriendsNavButton; break;
		case "Help and Support button": finalElement = settings.AccountMainHelpNavButton; break;
		case "Security and Privacy button": finalElement = settings.SecurityAndPrivacyButton; break;
		case "Notifications button": finalElement = settings.NotificationsButton; break;
		case "Account Edit button ": finalElement = settings.AccountEditButton; break;
		case "Profile Edit button": finalElement = settings.ProfileEditButton; break;
		// Account Settings
		case "Height label": finalElement = account.AccountSettingsHeightLabel; break;
		case "Height units switcher": finalElement = account.AccountSettingsHeightUnitsSwitcher; break;
		case "Weight label": finalElement = account.AccountSettingsWeightLabel; break;
		case "Weight units switcher": finalElement = account.AccountSettingsWeightUnitsSwitcher; break;
		case "Distance label": finalElement = account.AccountSettingsDistanceLabel; break;
		case "Distance units switcher": finalElement = account.AccountSettingsDistanceUnitsSwitcher; break;
		case "Export data button": finalElement = account.ExportDataButton; break;
		case "Log out button": finalElement = account.LogOutButton; break;
		case "Close account button": finalElement = account.CloseAccountButton; break;
		case "Notification icon": finalElement = notification.notificationIcon; break;
		case "Account icon": finalElement = account.AccountIcon; break;
		// Profile settings
		case "Email input field": finalElement = profile.EmailInputField; break;
		case "First name input field": finalElement = profile.FirstNameInputField; break;
		case "Last name input field": finalElement = profile.LastNameInputField; break;
		case "Display name input field": finalElement = profile.DisplayNameInputField; break;
		case "Change photo button": finalElement = profile.ChangePhotoButton; break;
		// Security and privacy
		case "Privacy switcher": finalElement = security.PrivacySwitcher; break;
		// Library
		case "Recommended button": finalElement = library.RecommendedSwitchButton; break;
		case "Topics button": finalElement = library.TopicsSwitchButton; break;
		// Challenges
		case "View team members link": finalElement = challenge.teamChallengeTeamMembers ; break;
		case "View Leaderboard link": finalElement = challenge.teamChallengeViewLeaderboard; break;
		case "All posts tab": finalElement = challenge.teamChallengeAllPostsTab; break;
		case "Team posts tab": finalElement = challenge.teamChallengeTeamPostsTab; break;
		// Rewards
		case "Reward Points label": finalElement = rewards.RewardPointsLabel; break;
		case "How to earn points Expander": finalElement = rewards.HowToRewardExpander; break;	
		case "Reward tile": finalElement = rewards.RewardTile; break;
		case "Get this reward button": finalElement = rewards.GetRewardButton; break;
		case "Not enough points button": finalElement = rewards.notEnoughPointsButton; break;
		case "Reward entry header": finalElement = rewards.RewardEntryHeader; break;
		// Login/Register
		case "Forgotten password link": finalElement = login.forgottenPasswordButton; break;
		// PreOnboarding
		case "Next button": finalElement = NextButton; break; 
		case "Skip button": finalElement = SkipButton; break; 
		// Health and Support
		case "Send feedback button": finalElement = help.SendFeedbackButton; break; 
		case "FAQs button": finalElement = help.FAQsButton; break; 
		case "Terms of Use and Privacy Policy button": finalElement = help.TermsOfUseAndPrivacyPolicyButton; break; 
		// Journey Assessment
		case "Get started button": finalElement = journey.getStartedButton; break;
		case "Set up your plan header": finalElement = journey.setupYourPlanTitle; break;
		case "NEXT assessment navigation button": finalElement = journey.NextAssessmentNavButton; break;
		}
		return finalElement;
	}
}
