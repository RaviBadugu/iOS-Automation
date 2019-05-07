package step_definitions;

/**
 * @author ravibadugu
 * @param args
 * @throws MalformedURLException 
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidSample {


	AndroidDriver driver;
	@Before
	
	public void Setup() throws MalformedURLException {
		
		
		// TODO Auto-generated method stub

		DesiredCapabilities cap = new DesiredCapabilities();
		File f = new File("/Users/ravibadugu/Downloads/app-aviva-qa.apk");		
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "CVH7N15B10000897");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "05160560a2940e02");
		//cap.setCapability(MobileCapabilityType.APP_PACKAGE, "co.uk.aviva.wellbeing.nightly");
		//cap.setCapability("bundleId", "com.tictrac.projectdenver");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	
	public void click() {
		
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/next_button").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/next_button").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/next_button").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/next_button").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/get_started").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/change_page_text").click();
		//driver.findElementById("com.tictrac.android.healthHub.nightly:id/btn_main").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/account_identifier_edit").sendKeys("ravi+00@tictrac.com");
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/password_edit").sendKeys("lakshmi9298");
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/btn_main").click();
		driver.findElementById("co.uk.aviva.wellbeing.nightly:id/skip_text").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElementByAndroidUIAutomator("Plans").click();
      //driver.findElementById("com.tictrac.android.healthHub.nightly:id/negative_button").click();
//		driver.findElementByXPath("android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.view.View[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]").click();
//		driver.findElementByXPath("android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.view.View[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]").click();
//		driver.findElementByXPath("android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.view.View[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]").click();
//		driver.findElementByXPath("android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
//				+ "/android.view.View[1]/android.widget.FrameLayout[1]"
//				+ "/android.widget.LinearLayout[1]").click();
		
	}
	
	@After 
	
	public void close(){
		
		driver.closeApp();
	}

}
