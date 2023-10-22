package com.api.cucumber.stepDef;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		plugin = {"pretty\",\"json:target/cucumber.json"},
		features = {"./src/main/resources/Feature/CURD.feature",},
		glue = {"com.api.cucumber.stepDef"},
		tags = {"@Regression"},
		monochrome = true,
		dryRun = false,
		strict = true
		
		
		)


public class runnerFile extends AbstractTestNGCucumberTests {

}
