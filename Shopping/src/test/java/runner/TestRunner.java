package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinition", "listeners"},
    plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {}