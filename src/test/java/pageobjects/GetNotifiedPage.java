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
 */
public class GetNotifiedPage {
	
	
	public GetNotifiedPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	IOSDriver<?> driver;
	
	@iOSFindBy(id="Get notified!")
	public IOSElement VerifyGetNotifiedTittle;
	
	@iOSFindBy(id="Sounds good")
	public IOSElement TapOnSoundsgoodButton;
	
	@iOSFindBy(id="“Wellbeing” Would Like to Send You Notifications")
	public IOSElement VerifyTextInNotifiedPopUp;
	
	@iOSFindBy(id="Don’t Allow")
	public IOSElement TapOnDontAllowButtonInNotifiedPopUp;
	
	@iOSFindBy(id="Allow")
	public IOSElement TapOnAllowButtonInNotifiedPopUp;
	
	@iOSFindBy(id="Track your exercise")
	public IOSElement TapBackArrowFromGetNotifiedScreen;

}
