package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.Configuration;

public class Launcher {
	
//	public Launcher() {
//
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		
//	}
	
	
public static IOSDriver<IOSElement> driver;
public static WebDriverWait wait;

@Before

	public static void Launchapp() throws MalformedURLException, InterruptedException {
	// TODO Auto-generated method stub
		
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    

	    //Ravi Badugu Capabilities
	    
//	    File f = new File("/Users/ravibadugu/Downloads/Aviva.app");
//	    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
//	    //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
//	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");

	    //Rado Capabilities
//	    File f = new File("/Users/radorozkowinski/Downloads/Aviva.app");
//	    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
//	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
	    
	    //Aruna Capabilities
	    
//	    File f = new File("/Users/arunakumari/Downloads/Aviva.app");
//	    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.3");
//	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
	    
	    //BrowserStack Capabilities
	    
//	    String accessKey = "WWfFfvzqfKAgMEN365xW";
//		String userName = "liam55";
//	    File f = new File("/Users/ravibadugu/Downloads/Aviva 2018-06-14 17-18-48/Aviva.ipa");
//	    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
//	    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//	    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.3");
//	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
//	    caps.setCapability("bundleId", "com.tictrac.aviva.internal");
	    //caps.setCapability("bundleId", "com.tictrac.healthhub.internal");
//	    caps.setCapability(MobileCapabilityType.APP,"useNewWDA");
//	    caps.setCapability(MobileCapabilityType.APP,"clearSystemFiles");
//	    caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
//	    caps.setCapability("startIWDP", true);
//	    caps.setCapability("instrumentApp", true);
//	    caps.setCapability("webkitResponseTimeout", 70000);
//	    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
//	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	    //BrowserStack Capabilities
	    
 	    String accessKey = "WWfFfvzqfKAgMEN365xW";
 		String userName = "liam55";
	 
 	    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
 	    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
 	    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.3");
 	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
 	    caps.setCapability("bundleId", "com.tictrac.aviva.internal");
 	    //caps.setCapability("bundleId", "com.tictrac.healthhub.internal");
 	    caps.setCapability(MobileCapabilityType.APP,"useNewWDA");
 	    caps.setCapability(MobileCapabilityType.APP,"clearSystemFiles");
 	    caps.setCapability("browserstack.local", "false");
 	    caps.setCapability("webkitResponseTimeout", "60000");
 	    caps.setCapability("browserstack.localIdentifier", "Test123");
 	    
// 	    caps.setCapability("app", "bs://dd6d21973d9322133e1e9cdf36cb73a7e29d461a");
 	   String app = System.getenv("BROWSERSTACK_APP_ID"); // Get app id from environment variable.
 	   	caps.setCapability("app", "bs://dd6d21973d9322133e1e9cdf36cb73a7e29d461a"); // Add app id to driver capability.
 	    driver = new IOSDriver<IOSElement>(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
 	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 	    caps.setCapability("startIWDP", true);
 	    caps.setCapability("instrumentApp", true);
 	    caps.setCapability("webkitResponseTimeout", 70000);

 	    wait = new WebDriverWait(driver, 30);

	    
	    
	    // Shared capabilities - DO NOT COMMENT OUT
//	    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
//	    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//	    caps.setCapability("bundleId", "com.tictrac.aviva.internal");
//	    caps.setCapability(MobileCapabilityType.APP,"useNewWDA");
//	    caps.setCapability(MobileCapabilityType.APP,"clearSystemFiles");
//	    caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
//	    caps.setCapability("startIWDP", true);
//	    caps.setCapability("instrumentApp", true);
//	    caps.setCapability("webkitResponseTimeout", 70000);
//	    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
//	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//	    wait = new WebDriverWait(driver, 30);
	    
	    System.out.println("Exceting @Before");

	  }

@After

	public void tearDown() throws Exception {
	
	//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	System.out.println("Exceting @After");
	driver.quit();
	}  

	}