package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resourcess/features",
                  glue = {"stepdefinitions", "hooks"},
                  publish=true,
		         plugin={"pretty","html:target/CucumberReports/cucumberReport.html"}
		         )
public class TestRunner {
	
	

}
