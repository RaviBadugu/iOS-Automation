package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HelpAndSupportPage {

	public HelpAndSupportPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(id = "Help and support")
	public IOSElement HelpAndSupportButton;

	@iOSFindBy(id = "FAQs")
	public IOSElement FAQsButton;

	@iOSFindBy(id = "Send feedback")
	public IOSElement SendFeedbackButton;

	@iOSFindBy(id = "Terms of Use and Privacy Policy")
	public IOSElement TermsOfUseAndPrivacyPolicyButton;
	
	
}
