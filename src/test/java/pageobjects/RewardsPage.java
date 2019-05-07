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
public class RewardsPage {
	
	public RewardsPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"REWARD POINTS\"]")
	public IOSElement RewardPointsLabel;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'How do I earn more')]")
	public IOSElement HowToRewardExpander;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell)[1]")
	public IOSElement RewardTile;
	
	@iOSFindBy(id="Get this reward")
	public IOSElement GetRewardButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"You don’t have enough points yet\"]")
	public IOSElement notEnoughPointsButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeOther/XCUIElementTypeOther[XCUIElementTypeImage[@name=\"reward-icon\"]]")
	public IOSElement RewardEntryHeader;
}
