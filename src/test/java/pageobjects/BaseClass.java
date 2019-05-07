package pageobjects;



import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;



	
		public abstract class BaseClass {
			public static IOSDriver<IOSElement> driver;
			public static boolean bResult;
			public  BaseClass(IOSDriver<IOSElement> driver){
				BaseClass.driver = driver;
				BaseClass.bResult = true;
		}

		}


