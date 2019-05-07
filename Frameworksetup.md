####Automation Framework Setup

##Getting Started:

Follow the step by step process to get started

##Software Required:

	•	Eclipse IDE
	•	Java
	•	Maven
	•	Cucumber
	•	Appium Java-Client-4.1.2.jar
	•	Selenium-Java-3.0.1

##Prerequisites:

	1.	Install Java (https://java.com/en/)
	2.	Install Eclipse (https://www.eclipse.org/)
	3.	Install Maven (https://maven.apache.org/download.cgi)
	4.	Install Cucumber (http://cucumber.github.com/cucumber-eclipse/update-site)
		This is through eclipse -->Help -->Install new software -->Paste the above URL -->select all -->next.
	5.	Download appium java client (https://mvnrepository.com/artifact/io.appium/java-client/4.1.2)
	6.	Download selenium jars (http://www.seleniumhq.org/download/)

##Framework Setup:

	1.	Create a new maven project in eclipse
	2.	Add the respective jar files mentioned above to the project
	3.	Follow step four as mentioned above in prerequisites to add cucumber into your project 
	4.	Create .feature files to write cucumber feature in src/main/resources
	5.	Create three different packages to keep Page objects, Common methods and Step Definitions in src/test/java.

##Running Cucumber Features:

To run the cucumber features you need runner class see the code snippet below

	@RunWith(Cucumber.class)
	@CucumberOptions(dotcucumber = ".cucumber", 
	 	features = { "src/main/resources/FeatureFiles" },
	 	dryRun = false,
	 	strict = false,
	 	monochrome = true,
	 	format = {"pretty", "html:target/cucumber", "json:target/cucumber.json" },
			//glue = {"src/test/java/step_definitions"},
			tags = "@tagname")
	
	public class Runner {
	
	
	}
