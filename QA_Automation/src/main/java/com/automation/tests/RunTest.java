package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",  // Path to feature files
    glue = "stepDefinitions",  // Path to step definition files
    plugin = {"pretty", "html:target/cucumber-reports.html"},  // Report generation
    monochrome = true, // Better console output readability
    dryRun = false,  // Set to 'true' to check if steps are defined
    strict = true  // Fail execution if undefined steps exist
)
public class RunTest { }
