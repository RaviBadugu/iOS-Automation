package pageobjects;

/**
 * @author ravibadugu
 *
 */

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;

public class InAppNotificationSettingsPage {
	
	public  InAppNotificationSettingsPage(IOSDriver<IOSElement> driver) 
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@iOSFindBy(id="icon notification")
	public IOSElement notificationIcon;
	
}