package com.epam.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        plugin = {
                "json:target/cucumber-report.json",
                "html:target/cucumber-report"        },
        tags = "@DemoTest",
        features="src/test/resources/features",  // if runner does not see the features
        glue = {"com.epam.taf.steps"}
)
public class CucumberTestNGTest extends AbstractTestNGCucumberTests {
}
