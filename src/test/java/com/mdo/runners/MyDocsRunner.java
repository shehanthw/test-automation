package com.mdo.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src//test//resources//features//mydocs.feature",
        glue= "com/mdo/stepdefinitions",
        monochrome = true,
        plugin = {"pretty","json:target/reports/mydocs.json", "html:target/cucumber-html-report"}
)

public class MyDocsRunner {
}
