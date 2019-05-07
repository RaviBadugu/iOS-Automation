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
public class LibraryPage {
	
	public LibraryPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(id="Library")
	public IOSElement NavLibrary;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"Recommended\"]")
	public IOSElement RecommendedSwitchButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"Topics\"]")
	public IOSElement TopicsSwitchButton;
	
	@iOSFindBy(xpath="(//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[@name=\"article\"]//XCUIElementTypeStaticText)[1]")
	public IOSElement ArticleTitle;
	
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar/XCUIElementTypeOther")
	public IOSElement TopicPageNavTitle;
	
}
