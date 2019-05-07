/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.JourneysObjects;
import pageobjects.CommonMethods;

/**
 * @author rado
 *
 */
public class JourneysSteps {

	public IOSDriver<IOSElement> driver;
	JourneysObjects journey;
	CommonMethods common;

	public JourneysSteps() {
		driver = Launcher.driver;
		common = new CommonMethods(driver);
		journey = new JourneysObjects(driver);
	}

	@When("^I set following values on journey onboarding (.*?) page:$")
	public void I_set_values_on_journey_onboarding(String onboardingPage, DataTable pageSettings) throws Throwable {
		System.out.println("Executing: When I set selected values on journey onboarding " + onboardingPage + " page");
		List<List<String>> dataSettings = pageSettings.raw();
		String timeoutString = driver.manage().timeouts().toString();
		System.out.println("Timeouts: "+timeoutString);
		switch (onboardingPage) {
		case "Your medication":
			String isMedicationString = dataSettings.get(1).get(0);
			System.out.println("Setting 'Do you take medication?' to: " + isMedicationString);
			String valueAttr;
			switch (isMedicationString) {
			case "Yes":
				common.TapOn(journey.isMedicationYesOption);
				valueAttr = journey.isMedicationYesOption.getAttribute("value");
				assertTrue("'Yes' option not selected", valueAttr != null);
				break;
			case "No":
				common.TapOn(journey.isMedicationNoOption);
				valueAttr = journey.isMedicationNoOption.getAttribute("value");
				assertTrue("'No' option not selected", valueAttr != null);
				break;
			default:
				break;
			}
			String medicationTypeString = dataSettings.get(1).get(1);
			System.out.println("Setting 'What type of medication do you take?' to: " + medicationTypeString);
			switch (medicationTypeString) {
			case "Insulin":
				common.TapOn(journey.medicationTypeInsulin);
				valueAttr = journey.medicationTypeInsulin.getAttribute("value");
				assertTrue("Insulin not selected", valueAttr != null);
				break;
			case "Oral medication":
				common.TapOn(journey.medicationTypeOral);
				valueAttr = journey.medicationTypeOral.getAttribute("value");
				assertTrue("Oral medication not selected", valueAttr != null);
				break;
			case "all":
				common.TapOn(journey.medicationTypeInsulin);
				valueAttr = journey.medicationTypeInsulin.getAttribute("value");
				assertTrue("Insulin not selected", valueAttr != null);
				common.TapOn(journey.medicationTypeOral);
				valueAttr = journey.medicationTypeOral.getAttribute("value");
				assertTrue("Oral medication not selected", valueAttr != null);
				break;
			case "disabled":
				assertFalse("Insulin not disabled", journey.medicationTypeInsulin.isEnabled());
				assertFalse("Oral medication not disabled", journey.medicationTypeOral.isEnabled());
			default:
				break;
			}
			break;

		default:
			break;
		}

	}
	
	@When("^I select areas to focus if applicable:$")
	public void selectAreaToFocusIfApplicable(List<String> areaToFocus) throws Throwable {
		System.out.println("Executing: When I select " + areaToFocus + " area to focus");
		if (driver.findElementsByXPath("//XCUIElementTypeStaticText[@name=\"Areas to focus\"]").size() >= 1) {
			for (String singleArea : areaToFocus ) {
				String[] AreaArray = singleArea.split("; ");
				for (String str : AreaArray) {
					String newstr = str.replace(";", "");
					System.out.println("Selecting area... "+newstr);
					WebElement AreaString = driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,'"+newstr+"')]");
					common.TapOn(AreaString);
					Thread.sleep(3000);
				}				
			}			
			common.TapOn(journey.NextAssessmentNavButton);
		}
	}
	
	@When("^I go through assessment with following answers:$")
	public void IgoThroughAssessmentWithAnswers(List<String> answers) throws Throwable {
		System.out.println("Executing: I go through assessment with specified answers");
		for (String singleAnswer : answers) {
			if (singleAnswer.equals("break")) {
				break;
			}
			String[] answersArray = singleAnswer.split("; ");
			for (String str : answersArray) {
				String newstr = str.replace(";", "");
				System.out.println("Setting the answer: "+newstr);
				WebElement selectedAnswer = driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,'"+newstr+"')]");
				common.TapOn(selectedAnswer);
				Thread.sleep(2000);
			}
			// Add if-else to handle last 'Finish' button
			int isNextButton = driver.findElementsById("NEXT").size();
			if (isNextButton >= 1) {
				common.TapOn(journey.NextAssessmentNavButton);
			}
			else {
				common.TapOn(journey.FinishAssessmentNavButton);
			}
			
		}
	}

}
