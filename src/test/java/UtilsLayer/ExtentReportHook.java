package UtilsLayer;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class ExtentReportHook {

    private static ExtentReports extent;
    private static ExtentTest featureTest;
    private static ExtentTest scenarioTest;

    @Before
    public void beforeScenario(Scenario scenario) {
        if (extent == null) {
            setupExtentReports();
        }

        // Create test entry for the current scenario
        scenarioTest = featureTest.createNode(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            scenarioTest.fail("Test failed: " + scenario.getName());
        } else {
            scenarioTest.pass("Test passed: " + scenario.getName());
        }
    }

    private static void setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-report.html");
        sparkReporter.config().setDocumentTitle("Cucumber BDD Test Report");
        sparkReporter.config().setReportName("BDD Automation Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system information
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Pravin Kadam");

        featureTest = extent.createTest("BDD Features");
    }

    public static void flushExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}

