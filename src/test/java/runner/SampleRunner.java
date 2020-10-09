package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Created by sheerin on 10/1/2020.
 */
@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,
                    strict = true,
                    features = ".",
                    monochrome = true,
                    glue = "steps",
plugin = {
        "pretty",
        "json:build/cucumber-report/cucumber.json",
        "html:build/cucumber-report/cucumber.html",
        "junit:build/cucumber-report/cucumber.xml",
        "com.epam.reportportal.cucumber.StepReporter"}
                )
public class SampleRunner {

}
