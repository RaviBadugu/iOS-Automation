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
 * @author rado
 *
 */
public class SettingsMainPage {
	
	public IOSDriver<IOSElement> driver;
	
	public SettingsMainPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
	public IOSElement AccountMainUserAvatar;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[contains(@label,'My motivation')]/preceding-sibling::XCUIElementTypeStaticText")
	public IOSElement AccountMainUsername;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[contains(@label,'My motivation')]")
	public IOSElement AccountMainUserMotivation;
	
	@iOSFindBy(id="Connected trackers")
	public IOSElement AccountMainConnectedTrackersNavButton;
	
	@iOSFindBy(id="Friends")
	public IOSElement AccountMainFriendsNavButton;
	
	@iOSFindBy(id="Help and support")
	public IOSElement AccountMainHelpNavButton;
	
	@iOSFindBy(xpath="//*[@name='Account']/parent::XCUIElementTypeCell")
	public IOSElement AccountEditButton;
	
	@iOSFindBy(id="Security and privacy")
	public IOSElement SecurityAndPrivacyButton;
	
	@iOSFindBy(id="Notifications")
	public IOSElement NotificationsButton;
	
	@iOSFindBy(xpath="(//XCUIElementTypeButton[../XCUIElementTypeButton[contains(@label,'edit profile')]])[1]")
	public IOSElement ProfileEditButton;
}
