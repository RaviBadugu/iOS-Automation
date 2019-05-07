package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class JourneysObjects {

	public JourneysObjects(IOSDriver<IOSElement> driver)

	{

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Plan

	@iOSFindBy(id = "Plan")
	public IOSElement navPlanButton;
	
	@iOSFindBy(id = "Get started")
	public IOSElement getStartedButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Set up your plan\"]")
	public IOSElement setupYourPlanTitle;
	
	@iOSFindBy(id = "NEXT")
	public IOSElement NextAssessmentNavButton;
	
	@iOSFindBy(id = "FINISH")
	public IOSElement FinishAssessmentNavButton;

	// Your medication screen

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Do you take medication?\"]")
	public IOSElement DoYouTakeMedicationLabel;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Which type of medication do you take?\"]")
	public IOSElement WhichTypeofMedicationLabel;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter your most recent HbA1c:\"]")
	public IOSElement YourMostRecentHba1cLabel;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Yes']/preceding-sibling::XCUIElementTypeButton[@name='icon unchecked circle']")
	public IOSElement isMedicationYesOption;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Yes']/following-sibling::XCUIElementTypeButton[@name='icon unchecked circle']")
	public IOSElement isMedicationNoOption;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Oral medication']/preceding-sibling::XCUIElementTypeButton[@name='habits off']")
	public IOSElement medicationTypeOral;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Oral medication']/following-sibling::XCUIElementTypeButton[@name='habits off']")
	public IOSElement medicationTypeInsulin;

}
