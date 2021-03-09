package step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/Features/",
		glue = "step_definitions",
		plugin = {"pretty", "html:target/cucumber-html-report",
		"json:target/cucumber.json"}
		)
public class RunCukesTest{
	
}
