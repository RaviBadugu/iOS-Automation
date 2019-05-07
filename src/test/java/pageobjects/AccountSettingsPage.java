package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AccountSettingsPage {
	
	
	public AccountSettingsPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

		@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Height']")
		public IOSElement AccountSettingsHeightLabel;
		
		@iOSFindBy(xpath="//XCUIElementTypeSegmentedControl/child::XCUIElementTypeButton[@name='cm']/following-sibling::XCUIElementTypeButton[@name='ft']")
		public IOSElement AccountSettingsHeightUnitsSwitcher;
		
		@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Weight']")
		public IOSElement AccountSettingsWeightLabel;
		
		@iOSFindBy(xpath="//XCUIElementTypeSegmentedControl/child::XCUIElementTypeButton[@name='kg']/following-sibling::XCUIElementTypeButton[@name='lb']/following-sibling::XCUIElementTypeButton[@name='st']")
		public IOSElement AccountSettingsWeightUnitsSwitcher;
		
		@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Distance']")
		public IOSElement AccountSettingsDistanceLabel;
		
		@iOSFindBy(xpath="//XCUIElementTypeSegmentedControl/child::XCUIElementTypeButton[@name='km']/following-sibling::XCUIElementTypeButton[@name='mi']")
		public IOSElement AccountSettingsDistanceUnitsSwitcher;
		
		@iOSFindBy(id="account")
		public IOSElement AccountIcon;
		
		@iOSFindBy(id="Export data")
		public IOSElement ExportDataButton;
		
		@iOSFindBy(id="Close account")
		public IOSElement CloseAccountButton;
		
		@iOSFindBy(id="Log out")
		public IOSElement LogOutButton;
		
}
