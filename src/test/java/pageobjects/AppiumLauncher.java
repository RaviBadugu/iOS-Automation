package pageobjects;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

//public class AppiumLauncher  {
//	public AppiumLauncher() {
//
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//
//	}
//
//
//	public IOSDriver driver;
//
//	@Before
//	public void Setup() throws MalformedURLException {
//
//
//		File f = new File("/Users/garfieldblake/Downloads/HealthLab.app");
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
//		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
//		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//	//driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
//
//	}
//
//
//	//driver.findElementByName("Sign up with Facebook").click();
//
//		/*public static void main(String[] args) throws MalformedURLException {
//
//		  DesiredCapabilities cap = new DesiredCapabilities();
//		  File f = new File("/Users/garfieldblake/Downloads/app-myHealthHub-qa.apk");
//		  cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
//		  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
//		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "e3866134");
//		  cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//		  cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
//		  AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
//
//	  }
//		*/
//
//	public int delay (int time) {
//   	 long endTime = System.currentTimeMillis() + time;
//   	 while (System.currentTimeMillis() < endTime);
//   	 return time;
//	 }
//
////	public WebElement waitForPageUntilElementVisible(By webElement) {
////		return(new WebDriverWait(driver, 10))
////				.pollingEvery(1000, TimeUnit.MILLISECONDS)
////				.until(ExpectedConditions.visibilityOfElementLocated(webElement));
////	}
//
//
//
//
//}
