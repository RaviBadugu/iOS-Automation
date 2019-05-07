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
public class TimelinePage {
	
	public TimelinePage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(id="Home")
	public WebElement NavHome;
	
//	@iOSFindBy(xpath="")
//	public WebElement ShareWithFollowersButton;
//	
//	@iOSFindBy(xpath="")
//	public WebElement iconMoreRecommended;
//	
//	@iOSFindBy(xpath="")
//	public WebElement shareWithFollowersOption;
	
	@iOSFindBy(id="heart outline")
	public IOSElement heartLikeIcon;
	
}
