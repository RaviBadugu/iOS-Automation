package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;


	public class PreOnboarding {
		
		public PreOnboarding(IOSDriver<IOSElement> driver)
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}

	@iOSFindBy(id="Next")
	public IOSElement NextButton;
	
	@iOSFindBy(id="Skip")
	public IOSElement SkipButton;

}

