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
 *
 */
public class SecurityAndPrivacy {
	
	public SecurityAndPrivacy(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
		@iOSFindBy(xpath="//XCUIElementTypeSwitch")
		public IOSElement PrivacySwitcher;
		
		@iOSFindBy(xpath="//XCUIElementTypeSecureTextField[../XCUIElementTypeStaticText[@label='Current password']]")
		public IOSElement CurrentPasswordInputField;
		
		@iOSFindBy(xpath="//XCUIElementTypeSecureTextField[../XCUIElementTypeStaticText[@label='New password']]")
		public IOSElement NewPasswordInputField;
		
		@iOSFindBy(xpath="//XCUIElementTypeSecureTextField[../XCUIElementTypeStaticText[@label='Confirm password']]")
		public IOSElement ConfirmPasswordInputField;

}
