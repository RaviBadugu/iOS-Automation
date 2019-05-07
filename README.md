##Appium Setup


##Getting Started 

Follow the steps below to Get Started

#Software Required:

	•	Appium
	•	Android SDK Tools (Android)
	•	Xcode (iOS)
	•	Macaca Inspector
	•	Carthage
	•	Eclipse
	•	Java

#Installation Process:

#Setup Appium Server

The below dependencies have to be installed on your machine before attempting to run

	1.Install Appium 
	    a)	node
		b)	npm
		c)	Carthage

	2.Install this through terminal run: npm install
	
	3.Install Carthage (https://github.com/Carthage/Carthage/releases)
	  Download Carthage.pkg
	  
	4.Install Android SDK tools (http://mac.freewareupdate.com/download-android-developer-tools/10001/)

	5.Install Java (https://java.com/en/)

	6.Install Macaca-Inspector (https://macacajs.github.io/app-inspector/)
	  Installation through terminal Follow the steps in the link.

	7.Install Eclipse (https://www.eclipse.org/)

	8.Install Maven (https://maven.apache.org/download.cgi)

	9.Install Cucumber (http://cucumber.github.com/cucumber-eclipse/update-site) or use this 
					   (http://mrpotes.github.com/cukes-jvm-eclipse-plugin/update-site)
	  This is through eclipse -->Help -->Install new software -->Paste the above URL -->select all -->next  

	10.Download appium java client (https://mvnrepository.com/artifact/io.appium/java-client/4.1.2)

	11.Download selenium jars (http://www.seleniumhq.org/download/)

#Running:

To Start the Appium server follow steps below

	Start Appium in a console window
	npm start

## Building the iOS app for running in Simulator

The below code snippet was used to build a version of the iOS app that worked with Appium and the iOS simulator

```
xcodebuild -sdk iphonesimulator ONLY_ACTIVE_ARCH=NO -workspace My_workspace_here -scheme 'my_sceheme_name_here' CONFIGURATION_BUILD_DIR=/Users/my_name/Desktop/ clean build
```

#Setting up Environment Variables in Mac:

 Run these commands in Terminal Window 
	
	1.	vi ~/.bash_profile (Add all the Paths)
	
	2.	export ANDROID_HOME=/YOUR_PATH_TO/android-sdk
		export PATH=$ANDROID_HOME/platform-tools:$PATH
		export PATH=$ANDROID_HOME/tools:$PATH
		export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home
		export M2_HOME=/Users/username/Documents/apache-maven-3.3.9
		export PATH=$PATH:$M2_HOME/bin
	
	3.	source ~/.bash_profile
	
	
#Available Devices in BrowserStack Link below:

https://www.browserstack.com/app-automate/capabilities#mobile-capabilities

#Installation of iOS Webkit Debug Proxy:

Open the command terminal on your mac. Once that is open, verify you have Homebrew installed

```
brew -v
```

When you're certain the Homebrew is installed, do the following:

```
$ cd  ~
$ git clone https://github.com/google/ios-webkit-debug-proxy.git
$ brew install autoconf automake libusb libplist usbmuxd libimobiledevice
$ brew install --HEAD IDEVICEINSTALLER
$ cd ios-webkit-debug-proxy
$ ./autogen.sh
$ brew install ios-webkit-debug-proxy
```

To verify installation:

```
$ ios_webkit_debug_proxy
```



