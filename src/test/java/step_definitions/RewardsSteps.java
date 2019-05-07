/**
 * 
 */
package step_definitions;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.RewardsPage;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class RewardsSteps {
	
	public IOSDriver<IOSElement> driver;
	RewardsPage Rewards;
	CommonMethods common;
	
	public RewardsSteps()
    {
		driver = Launcher.driver;
    	Rewards = new RewardsPage(driver);
    	common = new CommonMethods(driver);
    }
	
	@When("^I open \'(.*?)\' reward$")
	public void I_open_reward(String rewardName) throws Throwable {
		System.out.println("Executing When");
		String rewardXpath = "//XCUIElementTypeOther[XCUIElementTypeStaticText[@name='"+rewardName+"']]";
		int isVisible = driver.findElementsByXPath(rewardXpath).size();
		while (isVisible < 1) {
			common.scroll(driver, "vertically", 0.8, 0.2);
			Thread.sleep(1500);
			isVisible = driver.findElementsByXPath(rewardXpath).size();
		}
		common.TapOn(driver.findElementByXPath(rewardXpath));
	}
	
}
