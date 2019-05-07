/**
 * 
 */
package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * @author ravibadugu
 *
 */
public class TrackersPage {
	
	public TrackersPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(id="Trackers")
	public IOSElement VerifyTrackersPageTittle;
	public TrackersPage VerifyingTrackersPageTittle(String txt) {
		VerifyTrackersPageTittle.getText();
		VerifyTrackersPageTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(id="Connected trackers")
	public IOSElement TapOnConnectedTrackers;
	public TrackersPage TappingOnConnectedTrackers() {
		TapOnConnectedTrackers.click();
		return this;
	}
	
	@iOSFindBy(id="OK")
	public IOSElement TapOnOKButtonInTrackYourExercisescreenPopUp;
	
	@iOSFindBy(id="Don’t Allow")
	public IOSElement TapOnDontAllowButtonInTrackYourExercisescreenPopUp;
	
	@iOSFindBy(id="Track your exercise")
	public IOSElement VerifyTrackYourExercise;
	
	@iOSFindBy(id="Enable mobile")
	public IOSElement VerifyEnablemobileButton;
	
	@iOSFindBy(id="Enable mobile")
	public IOSElement TapOnEnablemobileButton;
	
	@iOSFindBy(id="Your phone can be used to automatically track your steps and exercise")
	public IOSElement VerifyTextInTrackYourExercise;
	
	@iOSFindBy(id="Steps tracker connected!")
	public IOSElement VerifyTextInTrackYourExerciseAfterEnabling;
	
	@iOSFindBy(id="Get personalized updates of your progress and achievements.")
	public IOSElement VerifyTextInGetNotifiedScreen;
	
	@iOSFindBy(id="Skip")
	public IOSElement TapOnSkipButtonInTrackYourExercise;
	
	@iOSFindBy(id="Next")
	public IOSElement TapOnNextButtonInTrackyourExerciseScreen;
	
	@iOSFindBy(id="Automatically track your exercise")
	public IOSElement VerifyTextInStartTrackingScreen;
	public TrackersPage VerifyingTextInStartTrackingScreen(String txt) {
		VerifyTextInStartTrackingScreen.getText();
		VerifyTextInStartTrackingScreen.isDisplayed();
		return this;
	}
	
	//Your mobile can automatically track your steps and exercise to help you get the most out of Aviva Wellbeing
	
	@iOSFindBy(id="Account")
	public IOSElement TapOnBackButtonToAccount;
	public TrackersPage TappingOnBackButtonToAccount() {
		TapOnBackButtonToAccount.click();
		return this;
	}
	
	@iOSFindBy(id="Close")
	public IOSElement TapOnCloseButtonFromAccount;
	public TrackersPage TappingOnCloseButtonFromAccount() {
		TapOnCloseButtonFromAccount.click();
		return this;
	}
	
	@iOSFindBy(id="Automatically track your steps")
	public IOSElement VerifyPhoneTrackerSection;
	public TrackersPage VerifyingPhoneTrackerSection(String txt) {
		VerifyPhoneTrackerSection.getText();
		VerifyPhoneTrackerSection.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeApplication[1]"
			+ "/XCUIElementTypeWindow[1]"
			+ "/XCUIElementTypeOther"
			+ "/XCUIElementTypeOther"
			+ "/XCUIElementTypeOther"
			+ "/XCUIElementTypeOther"
			+ "/XCUIElementTypeOther"
			+ "/XCUIElementTypeTable"
			+ "/XCUIElementTypeOther[1]/XCUIElementTypeSwitch")
	public IOSElement TapOnPhoneTrackerSwitch;
	public TrackersPage TappingOnPhoneTrackerSwitch() {
		TapOnPhoneTrackerSwitch.click();
		return this;
	}
	
	@iOSFindBy(id="CONNECTED TRACKERS")
	public IOSElement VerifyConnectedTrackersSection;
	public TrackersPage VerifyingConnectedTrackersSection(String txt) {
		VerifyConnectedTrackersSection.getText();
		VerifyConnectedTrackersSection.isDisplayed();
		return this;
	}
	
	@iOSFindBy(id="RECOMMENDED TRACKERS")
	public IOSElement VerifyRecommendedTrackersSection;
	public TrackersPage VerifyingRecommendedTrackersSection(String txt) {
		VerifyRecommendedTrackersSection.getText();
		VerifyRecommendedTrackersSection.isDisplayed();
		return this;
	}
	
	@iOSFindBy(id="MORE TRACKERS")
	public IOSElement VerifyMoreTrackersSection;
	public TrackersPage VerifyingMoreTrackersSection(String txt) {
		VerifyMoreTrackersSection.getText();
		VerifyMoreTrackersSection.isDisplayed();
		return this;
	}
	
	//Apple Health
	
	@iOSFindBy(xpath="//XCUIElementTypeCell/XCUIElementTypeButton[@name='Connect'][../XCUIElementTypeStaticText[@name='Apple Health']]")
	public IOSElement ConnectButtonAppleHealth;
	
	@iOSFindBy(id="Turn All Categories On")
	public IOSElement AppleHealthTurnAllCategoriesOnButton;
	
	@iOSFindBy(id="Allow")
	public IOSElement AppleHealthAllowButton;
	
	@iOSFindBy(id="Apple Health")
	public IOSElement VerifyAppleHealthTrackerTittle;
	public TrackersPage VerifyingAppleHealthTrackerTittle(String txt) {
		VerifyAppleHealthTrackerTittle.getText();
		VerifyAppleHealthTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Apple Health']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInAppleHealth;
	public TrackersPage TappingOnConnectButtonInAppleHealth() {
		TapOnConnectButtonInAppleHealth.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInAppleHealth;
	public TrackersPage TappingOnDisconnectButtonInAppleHealth() {
		TapOnDisconnectButtonInAppleHealth.click();
		return this;
	}
	
	//Dailymile
	@iOSFindBy(id="Dailymile")
	public IOSElement VerifyDailymileTrackerTittle;
	public TrackersPage VerifyingDailymileTrackerTittle(String txt) {
		VerifyDailymileTrackerTittle.getText();
		VerifyDailymileTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Dailymile']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInDailymile;
	public TrackersPage TappingOnConnectButtonInDailymile() {
		TapOnConnectButtonInDailymile.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInDailymile;
	public TrackersPage TappingOnDisconnectButtonInDailymile() {
		TapOnDisconnectButtonInDailymile.click();
		return this;
	}
	
	//FatSecret
	@iOSFindBy(id="FatSecret")
	public IOSElement VerifyFatSecretTrackerTittle;
	public TrackersPage VerifyingFatSecretTrackerTittle(String txt) {
		VerifyFatSecretTrackerTittle.getText();
		VerifyFatSecretTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='FatSecret']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInFatSecret;
	public TrackersPage TappingOnConnectButtonInFatSecret() {
		TapOnConnectButtonInFatSecret.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInFatSecret;
	public TrackersPage TappingOnDisconnectButtonInFatSecret() {
		TapOnDisconnectButtonInFatSecret.click();
		return this;
	}
	
	//Fitbit
	
	@iOSFindBy(id="Fitbit")
	public IOSElement VerifyFitbitTrackerTittle;
	public TrackersPage VerifyingFitbitTrackerTittle(String txt) {
		VerifyFitbitTrackerTittle.getText();
		VerifyFitbitTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeOther[.//XCUIElementTypeSecureTextField]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
	public IOSElement FitbitWebViewLoginTextField;
	
	@iOSFindBy(xpath="//XCUIElementTypeSecureTextField")
	public IOSElement FitbitWebViewPasswordTextField;
	
	@iOSFindBy(id="LOG IN")
	public WebElement FitbitWebViewLoginButton; 
	
	@iOSFindBy(xpath="//XCUIElementTypeCell/XCUIElementTypeButton[@name='Connect'][../XCUIElementTypeStaticText[@name='Fitbit']]")
	public IOSElement ConnectButtonFitbit;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Fitbit']/following-sibling::XCUIElementTypeButton[@name='Disconnect']")
	public IOSElement DisconnectButtonFitbit;
	
//	private AppiumDriver<WebElement> getAppiumWebDriver() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@iOSFindBy(id="Connect")
	public IOSElement VerifyConnectBtnInTrackerScreen;
	public TrackersPage VerifyingConnectBtnInTrackerScreen(String txt) {
		VerifyConnectBtnInTrackerScreen.getText();
		VerifyConnectBtnInTrackerScreen.isDisplayed();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInFitbit;
	public TrackersPage TappingOnDisconnectButtonInFitbit() {
		TapOnDisconnectButtonInFitbit.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement VerifyDisconnectBtnInTrackerScreen;
	public TrackersPage VerifyingDisconnectBtnInTrackerScreen(String txt) {
		VerifyDisconnectBtnInTrackerScreen.getText();
		VerifyDisconnectBtnInTrackerScreen.isDisplayed();
		return this;
	}
	
	//Garmin Connect
	@iOSFindBy(id="Garmin Connect")
	public IOSElement VerifyGarminConnectTrackerTittle;
	public TrackersPage VerifyingGarminConnectTrackerTittle(String txt) {
		VerifyGarminConnectTrackerTittle.getText();
		VerifyGarminConnectTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Garmin Connect']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInGarminConnect;
	public TrackersPage TappingOnConnectButtonInGarminConnect() {
		TapOnConnectButtonInGarminConnect.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInGarminConnect;
	public TrackersPage TappingOnDisconnectButtonInGarminConnect() {
		TapOnDisconnectButtonInGarminConnect.click();
		return this;
	}
	
	//Google Fit
	@iOSFindBy(id="Google Fit")
	public IOSElement VerifyGoogleFitTrackerTittle;
	public TrackersPage VerifyingGoogleFitTrackerTittle(String txt) {
		VerifyGoogleFitTrackerTittle.getText();
		VerifyGoogleFitTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Google Fit']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInGoogleFit;
	public TrackersPage TappingOnConnectButtonInGoogleFit() {
		TapOnConnectButtonInGoogleFit.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInGoogleFit;
	public TrackersPage TappingOnDisconnectButtonInGoogleFit() {
		TapOnDisconnectButtonInGoogleFit.click();
		return this;
	}
	
	//MisFit
	@iOSFindBy(id="Misfit")
	public IOSElement VerifyMisfitTrackerTittle;
	public TrackersPage VerifyingMisfitTrackerTittle(String txt) {
		VerifyMisfitTrackerTittle.getText();
		VerifyMisfitTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='MisFit']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInMisfit;
	public TrackersPage TappingOnConnectButtonInMisfit() {
		TapOnConnectButtonInMisfit.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInMisfit;
	public TrackersPage TappingOnDisconnectButtonInMisfit() {
		TapOnDisconnectButtonInMisfit.click();
		return this;
	}
	
	//Moves
	@iOSFindBy(id="Moves")
	public IOSElement VerifyMovesTrackerTittle;
	public TrackersPage VerifyingMovesTrackerTittle(String txt) {
		VerifyMovesTrackerTittle.getText();
		VerifyMovesTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Moves']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInMoves;
	public TrackersPage TappingOnConnectButtonInMoves() {
		TapOnConnectButtonInMoves.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInMoves;
	public TrackersPage TappingOnDisconnectButtonInMoves() {
		TapOnDisconnectButtonInMoves.click();
		return this;
	}
	
	//Nokia Health (Withings)
	@iOSFindBy(id="Nokia Health (Withings)")
	public IOSElement VerifyNokiaHealthTrackerTittle;
	public TrackersPage VerifyingNokiaHealthTrackerTittle(String txt) {
		VerifyNokiaHealthTrackerTittle.getText();
		VerifyNokiaHealthTrackerTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Nokia Health (Withings)']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInNokiaHealth;
	public TrackersPage TappingOnConnectButtonInNokiaHealth() {
		TapOnConnectButtonInNokiaHealth.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInNokiaHealth;
	public TrackersPage TappingOnDisconnectButtonInNokiaHealth() {
		TapOnDisconnectButtonInNokiaHealth.click();
		return this;
	}
	
	//Strava
	@iOSFindBy(id="Strava")
    public IOSElement VerifyStravaTrackerTittle;
    public TrackersPage VerifyingStravaTrackerTittle(String txt) {
        VerifyStravaTrackerTittle.getText();
        VerifyStravaTrackerTittle.isDisplayed();
        return this;
    }
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Strava']//preceding-sibling::XCUIElementTypeButton[@name='Connect']")
	public IOSElement TapOnConnectButtonInStrava;
	public TrackersPage TappingOnConnectButtonInStrava() {
		TapOnConnectButtonInStrava.click();
		return this;
	}
	
	@iOSFindBy(id="Disconnect")
	public IOSElement TapOnDisconnectButtonInStrava;
	public TrackersPage TappingOnDisconnectButtonInStrava() {
		TapOnDisconnectButtonInStrava.click();
		return this;
	}
	
	//Tracker info page
	@iOSFindBy(id="arrow-right")
	public IOSElement TapOnTracksWorkButton;


	
    @iOSFindBy(id="How trackers work in the app")
	public IOSElement VerifyTrackerInfoTitle;
   

	
	
	
    
	
//	@iOSFindBy(id="RemoteViewBridge")
//	public WebElement GetWebviewElements;
//	public TrackersPage GettingAWebviewElements() {
//		GetWebviewElements.click();
//		
//	
//		
//        // Switch to WebView
//       Set<String> GetWebviewElements =  driver.getContextHandles();
//        System.out.println(((WebElement) GetWebviewElements).getSize());
//        for (String contextName : GetWebviewElements) {
//            System.out.println(contextName);
//            if (contextName.contains("WEBVIEW")){
//                driver.context(contextName);
//            }
//        }
//        // check WELCOME text is present
//       Assert.assertEquals("Welcome To My Page", driver.findElement(By.id("welcome_text")).getText());
//        //Check UI elements text boxes and buttons are present on the page
//        Assert.assertTrue(driver.findElementById("email_edit").isDisplayed());
//        Assert.assertTrue(driver.findElementById("password_edit").isDisplayed());
//
//        Assert.assertTrue(driver.findElementById("submit_button").isDisplayed());
//
//        //enter email id and password
//        driver.findElementById("email_edit").sendKeys("ravi@tictrac.com");
//        driver.findElementById("password_edit").sendKeys("Lakshmi9298");
//
//        // /click on submit button
//        driver.findElementById("submit_button").click();
//
//        //Explicit wait for submission
//        //Thread.sleep(3000);
//        //Check for successful submission
//       // Assert.assertEquals("Successfully Registered",driver.findElementById("display_text"));
//        return this;
//	}
	
	
}
