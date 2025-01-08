package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/SauceDemo.feature", // Path to features
		glue = "stepDefinations", // Path to step definitions
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json" },

		monochrome = true, // Optional: Cleaner console output
		dryRun = false // Optional: Set to true to check step definitions without executing tests
)
public class SauceRunner extends AbstractTestNGCucumberTests {
}
