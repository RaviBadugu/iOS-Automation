package step_definitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.InAppNotificationSettingsPage;
import pageobjects.LoginPage;
import pageobjects.PreOnboarding;
import pageobjects.CommonMethods;

public class InAppNotificationSettingsSteps {
	
	public IOSDriver<IOSElement> driver;
	LoginPage login;
	PreOnboarding preon; 
	InAppNotificationSettingsPage notification;
	CommonMethods common;
	
	public InAppNotificationSettingsSteps()
    {
		driver = Launcher.driver;
    	notification = new InAppNotificationSettingsPage(driver);
    	common = new CommonMethods(driver);
    }
	
	@Then("^all the notifications flags may be switched$")
	public void all_notifications_may_be_switched() throws Throwable {
		System.out.println("Executing: Then all the notifications flags may be switched");
		for (int i = 1; i < 6; i++) {
			WebElement switcher = driver.findElementByXPath("(//XCUIElementTypeSwitch)["+i+"]");
			String switcherValue = switcher.getAttribute("value");
			common.TapOn(switcher);
			String newSwitcherValue = switcher.getAttribute("value");
			switch (switcherValue) {
			case "1": assertTrue("Disabling emelent "+i+" unsuccessful", newSwitcherValue != switcherValue); break;
			case "0": assertTrue("Enabling emelent "+i+" unsuccessful", newSwitcherValue != switcherValue); break;
			}
		}
	}

}
