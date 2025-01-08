package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features/SauceDemo.feature",
	    glue = "stepDefinations",
	    plugin = { 
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        "html:target/cucumber-reports/cucumber.html", 
	        "json:target/cucumber-reports/cucumber.json" 
	    },
	    monochrome = true,
	    dryRun = false
	)

public class SauceRunner extends AbstractTestNGCucumberTests {

}
