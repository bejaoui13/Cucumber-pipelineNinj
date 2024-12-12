package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		   features = "src/test/resources/features/01_Registration.feature", 
          glue = "com.stepDefinition", 
 
          plugin = {"pretty",
        		  "html:target/cucumber-reports/report.html",
        		  "json:target/cucumber.json",
        		//  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        		  },
          monochrome = true)

 //allure serve allure-results
 
//public class RunnerAddProduct extends AbstractTestNGCucumberTests {

 public class TestRunnerAddProduct  {

}
