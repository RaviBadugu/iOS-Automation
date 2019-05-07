/**
 * 
 */
package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * @author ravibadugu
 *
 */
public class RegistrationandOnboardingPage {
	
	public  RegistrationandOnboardingPage(IOSDriver<IOSElement> driver) 
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Registration screen
	@iOSFindBy(id="Create an account")
	public IOSElement CreateAnAccountButton;
	
	@iOSFindBy(id="Sign up")
	public IOSElement SignupButton;
	
	// Terms and conditions
	@iOSFindBy(xpath="//XCUIElementTypeLink[@name=\"Terms and Conditions\"]")
	public IOSElement TandCLink;
	
	@iOSFindBy(id="Accept and continue")
	public IOSElement AcceptAndContinueButton;
	
	// Data Policy
	@iOSFindBy(id="I consent")
	public IOSElement IConsentButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeLink[@name=\"Privacy Policy\"]")
	public IOSElement PrivacyPolicyLink;
	
	//Your Location Page
	
	@iOSFindBy(id="Find location")
	public IOSElement FindLocationButton;
	
	//Your name locators
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"First name\"]/following-sibling::XCUIElementTypeTextField")
	public IOSElement firstNameInput;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Last name\"]/following-sibling::XCUIElementTypeTextField")
	public IOSElement lastNameInput;
	
	//Get Notified locators
	@iOSFindBy(id="Get notified!")
	public IOSElement GetNotifiedTitle;
	
	@iOSFindBy(id="Get personalized updates of your progress and achievements.")
	public IOSElement GetNotifiedPText;
	
	@iOSFindBy(id="Not right now")
	public IOSElement NotRightNowButton;
	
	@iOSFindBy(id="Discover more")
	public IOSElement DiscoverMoreButtonInGtngStrdBanner;

	
	

}
