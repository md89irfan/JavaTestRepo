package com.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue={"com.stepdefs"}
		,tags={}
		,monochrome=true
		,plugin = { "pretty", "pretty:target/cucumber-reports/pretty.txt",
					"html:target/cucumber-reports",
					"json:target/cucumber-reports/cucumber.json",
					"junit:target/cucumber-reports/cucumber-junitreport.xml",
					"ru.yandex.qatools.allure.cucumberjvm.AllureReporter"
					}
		
		)

public class TestRunner {

}
