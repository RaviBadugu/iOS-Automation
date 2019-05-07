package step_definitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
 	features = { "src/main/resources/HealthLabiOS/FeatureFiles" },
 	dryRun = false,
 	strict = false,
 	monochrome = true,
 	plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json" },
		//glue = {"iOSAutomation/src/test/java/step_definitions"},


	tags = "@C16847"
 	)


public class runTest {

}
