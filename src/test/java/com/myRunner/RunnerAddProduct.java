package com.myRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 @CucumberOptions(
		   features = "src/test/resources/features", 
          glue = "com.stepDefinition", 
 
          plugin = {"pretty",
        		  "html:target/cucumber-reports/report.html",
        		  "json:target/cucumber.json",
        		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
          monochrome = true)

 //allure serve allure-results
 
 
 public class RunnerAddProduct extends AbstractTestNGCucumberTests {

}
