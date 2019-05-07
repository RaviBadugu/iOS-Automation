/**
 * 
 */
package pageobjects;

/**
 * @author ravibadugu
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;


public class ProfileSettingsPage {
	
	public ProfileSettingsPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath="//XCUIElementTypeTextField[../XCUIElementTypeStaticText[@label='Email']]")
	public IOSElement EmailInputField;
	
	@iOSFindBy(xpath="//XCUIElementTypeTextField[../XCUIElementTypeStaticText[@label='First name']]")
	public IOSElement FirstNameInputField;
	
	@iOSFindBy(xpath="//XCUIElementTypeTextField[../XCUIElementTypeStaticText[@label='Last name']]")
	public IOSElement LastNameInputField;
	
	@iOSFindBy(xpath="//XCUIElementTypeTextField[../XCUIElementTypeStaticText[@label='Display name']]")
	public IOSElement DisplayNameInputField;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"Change photo\"]")
	public IOSElement ChangePhotoButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[../XCUIElementTypeStaticText[@label='Birthday']]")
	public IOSElement BirthdayProfileSettings;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[../XCUIElementTypeStaticText[@label='Gender']]")
	public IOSElement GenderProfileSettings;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[../XCUIElementTypeStaticText[@label='Location']]")
	public IOSElement LocationProfileSettings;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[../XCUIElementTypeStaticText[@label='Height']]")
	public IOSElement HeightProfileSettings;
	
	@iOSFindBy(id="Update location")
	public IOSElement UpdateLocationButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Motivation\"]")
	public IOSElement UpdateMotivationLabel;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Motivation\"]/following-sibling::XCUIElementTypeStaticText")
	public IOSElement UpdateMotivationValue;
	
	@iOSFindBy(xpath="//XCUIElementTypeCell[XCUIElementTypeStaticText[@label='Your medication']]")
	public IOSElement UpdateMotivationMedication;
	
	@iOSFindBy(xpath="//XCUIElementTypeCell[XCUIElementTypeStaticText[@label='Your HbA1c']]")
	public IOSElement UpdateMotivationHba1c;
	
	@iOSFindBy(id="Yes, sure")
	public IOSElement YesSureButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeSheet[@name=\"Important\"]")
	public IOSElement ChangeJourneyWarningOnSave;

}
