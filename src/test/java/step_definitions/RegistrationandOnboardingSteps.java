package step_definitions;

import static org.junit.Assert.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.LoginPage;
import pageobjects.PreOnboarding;
//import pageobjects.AppiumLauncher;
import pageobjects.RegistrationandOnboardingPage;
import pageobjects.CommonMethods;
import pageobjects.JourneysObjects;


public class RegistrationandOnboardingSteps {
	
	public IOSDriver<IOSElement> driver;
	LoginPage login;
	PreOnboarding preon; 
	RegistrationandOnboardingPage register;
	CommonMethods common;
	JourneysObjects journeys;
	
	public RegistrationandOnboardingSteps()
    {
		driver = Launcher.driver;
		login = new LoginPage(driver);
    	preon = new PreOnboarding(driver);
    	register = new RegistrationandOnboardingPage(driver);
    	common = new CommonMethods(driver);
    	journeys = new JourneysObjects(driver);
    }
	
	@Given("^I register with the following settings:$")
	public void I_register_with_following_settings(DataTable registrationSettings) throws Throwable {
		System.out.println("Executing: I intend to register with the pre-selected settings");
		List<List<String>> dataRegistration = registrationSettings.raw();
		for (int i = 1; i < dataRegistration.size(); i++) {
			
			// **** This part should be enabled as soon as able to freely register ****				
//			
//			// Pass the credentials to register with datetime alias
//			String email = dataRegistration.get(i).get(0) +"+"+ common.getDateTime("DateTimeSettingsString");
//			String password = dataRegistration.get(i).get(1);
//			System.out.println("Registering with email: "+email+" and password: "+password);
//			login.enterEmail(email).enterPassword(password);
//			
//			common.TapOn(register.SignupButton);		
			
			// **** End of disabled part **** 
			
			// **** Temporary workaround for not able to freely register  ******
			// Switch to Login, if not already there
			int isTYEScreenAHA = driver.findElementsById("Already have an account? Log in").size();
			if (isTYEScreenAHA > 0) {
				System.out.println("Switching from Signup to Login page...");
				common.TapOn(login.alreadyHaveAccount);
				Thread.sleep(5000);
			}
			
			String email = "radoslaw+tempreg@tictrac.com";
			String password = "password123";
			login.enterEmail(email).enterPassword(password);
			common.TapOn(login.loginbutton);
			Thread.sleep(3000);	
			
			// **** End of temporary solution ****
			
			// Accept T&C
			int isTandCScreen = driver.findElementsById("Accept and continue").size();
			if (isTandCScreen > 0) {
				System.out.println("Accepting the TandC...");
				common.TapOn(register.AcceptAndContinueButton);
				Thread.sleep(2000);
			}
			
			// Give consent to data policy
			int isDataPolicyScreen = driver.findElementsById("I consent").size();
			if (isTandCScreen > 0) {
				System.out.println("Accepting the Data Policy...");
				common.TapOn(register.IConsentButton);
				Thread.sleep(2000);
			}
			
			// Check if Gender selection page displayed and tap the selected option
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Tell us about yourself\"]");
			String gender = dataRegistration.get(i).get(4);
			WebElement tapGender = null;
			System.out.println("Setting gender to: "+gender);
			switch (gender) {
			case "Male":
			case "Female":
				tapGender = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\""+gender+"\"]");
				break;
			case "I prefer not to say":
				tapGender = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"I prefer not to say\"]");
				break;
			}
			common.TapOn(tapGender);
			
			// Check if Journey selection page is displayed and tap the selected option
			// For the selected journey follow to the Medication page and continue
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your journey\"]");
			String journey = dataRegistration.get(i).get(2);
			WebElement tapJourney = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\""+journey+"\"]");
			System.out.println("Setting journey to: "+journey);
			common.TapOn(tapJourney);
			switch (journey) {
			case "Manage my diabetes":
				// Add tests for medication page
				common.AssertIsDisplayed(journeys.DoYouTakeMedicationLabel);
				common.AssertIsDisplayed(journeys.WhichTypeofMedicationLabel);
				common.AssertIsDisplayed(journeys.YourMostRecentHba1cLabel);
				break;
			case "Diabetes Prevention":
				common.AssertIsDisplayed(journeys.YourMostRecentHba1cLabel);
				break;
			default:
				break;
			}
			
			// Medication settings
			String medication = dataRegistration.get(i).get(3);
			System.out.println("Setting medication to: "+medication);
			switch (medication) {
			case "break":
				return;
			case "unchanged":
				common.TapOn(common.DoneButton);
				break;
			default:
				break;
			}
			
			// Check if Data Preferences page is displayed and use the selected options
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your data preferences\"]");
			String prefHeight = dataRegistration.get(i).get(7);
			String prefWeight = dataRegistration.get(i).get(8);
			String prefDistance = dataRegistration.get(i).get(9);
			System.out.println("Setting preferences to: "+prefHeight+","+prefWeight+","+prefDistance);
			WebElement tapPrefHeight = driver.findElementById(prefHeight);
			WebElement tapPrefWeight = driver.findElementById(prefWeight);
			WebElement tapPrefDistance = driver.findElementById(prefDistance);
			common.TapOn(tapPrefHeight);
			common.TapOn(tapPrefWeight);
			common.TapOn(tapPrefDistance);
			common.TapOn(common.NextButton);
			
			// Check if Height page displayed and continue
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your height\"]");
			System.out.println("Setting height...");
			common.TapOn(common.DoneButton);
			
			// Check if Weight page displayed and continue
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your weight\"]");
			System.out.println("Setting weight...");
			common.TapOn(common.DoneButton);
			
			// Check if DOB page displayed, pick the random and continue
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your date of birth\"]");
			System.out.println("Setting DOB...");
			common.scroll(driver, "vertically", 0.8, 0.7);
			Thread.sleep(2000);
			common.TapOn(common.DoneButton);
			
			// Check if Your location page displayed, and continue
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your location\"]");
			System.out.println("Skipping location...");
			int isLocationSet = driver.findElementsById("Find location").size();
			if (isLocationSet > 0) {
				System.out.println("Skipping find location...");
				common.TapOn(register.FindLocationButton);
				Thread.sleep(5000);
				common.TapOn(common.AllowButton);
			}
			else {
				common.TapOn(common.NextButton);	
			}
			
			
			
			// Check if Name page displayed, insert selected names and continue
			driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Your name\"]");
			String firstname = dataRegistration.get(i).get(5);
			String lastname = dataRegistration.get(i).get(6);
			System.out.println("Setting credentials: "+firstname+" "+lastname);
			register.firstNameInput.clear();
			register.firstNameInput.sendKeys(firstname);
			register.lastNameInput.clear();
			register.lastNameInput.sendKeys(lastname);
			common.TapOn(common.DoneButton);
			
			
			int isTYEScreenSkip = driver.findElementsById("Skip").size();
			if (isTYEScreenSkip > 0) {
				System.out.println("Skipping 'Track Your Exercise - skip' screen");
				common.TapOn(common.SkipButton);
				Thread.sleep(3000);
			}

			int isTYEScreenNext = driver.findElementsById("Next").size();
			if (isTYEScreenNext > 0) {
				System.out.println("Skipping 'Track Your Exercise - next' screen");
				common.TapOn(common.NextButton);
				Thread.sleep(3000);
			}

			// disabled so to not complete the registration
//			common.TapOn(login.NotRightNowButton);		
		}
	}
	
	@Given("^I enter login details as (.*?) / (.*?) and stop at (.*?) page$")
	public void I_enter_login_details_and_stop(String email, String password, String stopPage) throws Throwable {
		
		// Switch to Login, if not already there
		int isTYEScreenAHA = driver.findElementsById("Already have an account? Log in").size();
		if (isTYEScreenAHA > 0) {
			System.out.println("Switching from Signup to Login page...");
			common.TapOn(login.alreadyHaveAccount);
			Thread.sleep(5000);
		}
		
		login.enterEmail(email).enterPassword(password);
		common.TapOn(login.loginbutton);
		Thread.sleep(3000);
		
		switch (stopPage) {
		case "TandC":
			break;
		case "Data Privacy":
			// Accept TandC if displayed
			int isTandCScreen = driver.findElementsById("Accept and continue").size();
			if (isTandCScreen > 0) {
				System.out.println("Accepting the TandC...");
				common.TapOn(register.AcceptAndContinueButton);
				Thread.sleep(2000);
			}
			break;
		default:
			assertTrue("Error: unknown condition", 1 == 2);
			break;
		}
		
	}

}
