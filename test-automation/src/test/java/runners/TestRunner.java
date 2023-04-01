package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src//test//resources//features//login.feature",
        glue="stepDefinitions",
        tags = "@valid or @ulp",
        monochrome = true,
        plugin = {"pretty","json:target/cucumber.json", "html:target/cucumber-html-report"}
)

public class TestRunner {

}
