/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.TimelinePage;
import pageobjects.CommonMethods;

/**
 * @author rado
 *
 */
public class TimelineSteps {
	
	public IOSDriver<IOSElement> driver; 
	TimelinePage timeline;
	CommonMethods common;
	
	String articleTileTitle = "";
	String topicTileTitle = "";
	
	public TimelineSteps()
    {
		driver = Launcher.driver;
    	timeline = new TimelinePage(driver);
    	common = new CommonMethods(driver);
    }
	
//	@Then("^I see the Timeline card with all the GUI elements$")
//	public void timeline_card_GUI() throws Throwable {
//		System.out.println("Executing: I see the Timeline card with all the GUI elements");
//		Thread.sleep(4000);
//		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Recommended\"])[1]");
//		int isShared = driver.findElementsByXPath("(//XCUIElementTypeStaticText[@name=\"Recommended\"])[1]/preceding-sibling::XCUIElementTypeButton[@name=\"Share with followers\"]").size();
//		if (isShared < 1) {
//			driver.findElementByXPath("");
//		}
//
//		// To add more elements when valid locators introduced
//	}
	
//	@Then("^I can share Timeline card with followers$")
//	public void I_can_share_timeline_card_with_followers() throws Throwable {
//		System.out.println("Executing: I can share Timeline card with followers");
//		int isShared = driver.findElementsByXPath("(//XCUIElementTypeStaticText[@name=\"Recommended\"])[1]/preceding-sibling::XCUIElementTypeButton[@name=\"Share with followers\"]").size();
//		if (isShared >= 1) {
//			common.TapOn(timeline.iconMoreRecommended);
//			common.TapOn(timeline.shareWithFollowersOption);
//		}
//		common.TapOn(timeline.ShareWithFollowersButton);
//		common.AssertIsDisplayed(timeline.heartLikeIcon);
//	}

}
