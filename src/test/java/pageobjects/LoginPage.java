package pageobjects;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.text.DateFormat;
//import java.sql.Date;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.ios.IOSDriver;

public class LoginPage  {
	
	
	public  LoginPage(IOSDriver<IOSElement> driver) 
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(id="Already have an account? Log in")
	public IOSElement alreadyHaveAccountButton;
	
	@iOSFindBy(id="Log in")
	public IOSElement loginbutton;

	@iOSFindBy(className="SecureTextField")
	public IOSElement Password;
	public LoginPage enterPassword(String txt) {
		Password.sendKeys(txt);
		return this;
	}	
	
	@iOSFindBy(className="TextField")
	public IOSElement Email;
	public LoginPage enterEmail(String txt) {
		Email.sendKeys(txt);
		return this;
	}	
	
	@iOSFindBy(id="Forgotten password?")
	public IOSElement forgottenPasswordButton;
	
	@iOSFindBy(id="Already have an account? Log in")
	public IOSElement alreadyHaveAccount;
	
	@iOSFindBy(id="Not right now")
	public IOSElement NotRightNowButton;
		
	@iOSFindBy(id="Sign up")
	public IOSElement SignUpButton;

	@iOSFindBy(id="Create an account")
	public IOSElement CreateAnAccountButton;   
	 
}



	
	
	
		
	
