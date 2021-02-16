package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
		glue = { "stepDefinitions" }, 
		plugin = { "pretty",
		"json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, 
		monochrome = true,
		tags = "@ValuesFeature")

public class TestRunner {
	
}
