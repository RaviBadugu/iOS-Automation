/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.LoginPage;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class LoginSteps {
	
	public IOSDriver<IOSElement> driver;
	LoginPage login;
	CommonMethods common;
	public LoginSteps()
    {
		driver = Launcher.driver;
		login = new LoginPage(driver);
    	common = new CommonMethods(driver);
    }
	
	@When("^I attempt to login as (.*?) with password (.*?)$")
	public void I_enter_incorrect_login_details_and_tap_login_button(String username, String password) throws Throwable {
		System.out.println("Executing: When I attempt to login as '"+username+"' with password '"+password+"'");
		login.enterEmail(username).enterPassword(password);
		common.TapOn(login.loginbutton);
		Thread.sleep(3000);
	}
	
	}
