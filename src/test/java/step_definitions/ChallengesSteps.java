
/**
 * @author ravibadugu
 *
 */
package step_definitions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ChallengePage;
import pageobjects.CommonMethods;

public class ChallengesSteps {

	public IOSDriver<IOSElement> driver;
	ChallengePage challenge;
	CommonMethods common;

	public ChallengesSteps() {
		driver = Launcher.driver;
		challenge = new ChallengePage(driver);
		common = new CommonMethods(driver);
	}

	@Then("^all Challenge tiles have their GUI elements displayed$")
	public void all_challenge_tiles_are_correct() throws Throwable {
		System.out.println("Executing: Then all Challenge tiles have their GUI elements displayed");
		int numberOfTiles = driver.findElementsByXPath("//XCUIElementTypeCell").size();
		for (int i = 1; i <= numberOfTiles; i++) {
			System.out.println("ckecking tile number... "+i);
			// verify Start/End label
			driver.findElementByXPath("//XCUIElementTypeCell[" + i
					+ "]//XCUIElementTypeStaticText[contains(@label,'Ends in') or contains(@label,'Starts in')]");
			// verify image displayed
			driver.findElementByXPath("//XCUIElementTypeCell[" + i + "]//XCUIElementTypeImage[@enabled='true']");
		}
	}

	@Then("^I( do not)? see the (.*?) in My Challenges$")
	public void I_see_challenge_in_my_challenges(String doNot, String challengeName) throws Throwable {
		System.out.println("Executing: Then I"+doNot+" see the "+challengeName+" in My Challenges");
		int challengeJoined = driver.findElementsByXPath("//XCUIElementTypeStaticText[@name='" + challengeName
				+ "']/preceding-sibling::XCUIElementTypeOther[XCUIElementTypeImage[@name='challenge-trophy-list']]")
				.size();
		if (doNot == null) {
			assertTrue("FAIL! The challenge " + challengeName + " is NOT joined", challengeJoined > 0);
		} else {
			if (challengeJoined == 0) {
				common.scrollPage(driver, "top");
			}
			assertTrue("FAIL! The challenge " + challengeName + " is STILL joined", challengeJoined == 0);
		}
	}

	@When("^I join (.*?) challenge$")
	public void I_join_challenge(String challengeName) throws Throwable {
		System.out.println("Executing: When I join "+challengeName+" challenge");
		String challengeXpath = "//XCUIElementTypeCell[XCUIElementTypeOther/XCUIElementTypeStaticText[@name='" + challengeName + "']]";
		int selectedChallengeVisible = driver.findElementsByXPath(challengeXpath).size();
		if (selectedChallengeVisible < 1) {
			common.scrollPage(driver, "bottom");
		}
		Thread.sleep(5000);
		WebElement selectedChallenge = driver.findElementByXPath(challengeXpath);
		common.TapOn(selectedChallenge);
		int needsJoin = driver.findElementsById("Join Challenge").size();
		if (needsJoin >= 1) {
			common.TapOn(challenge.joinChallengeButton);
		}
	}

	@When("^I opt to (.*?)$")
	public void leave_chalenge(String option) throws Throwable {
		System.out.println("Executing: When I opt to "+option);
		common.scrollPage(driver, "top");
		Thread.sleep(4000);
		common.TapOn(common.OverflowMenu);
		switch (option) {
		case "leave challenge":
			common.TapOn(challenge.challengeMenuLeave);
			common.TapOn(challenge.challengeAlertLeave);
			break;
		case "connect tracker":
			common.TapOn(challenge.challengeMenuTrackers);
			break;
		}
		
	}

}
