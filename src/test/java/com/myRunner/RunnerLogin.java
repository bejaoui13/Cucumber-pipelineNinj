package com.myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Login.feature",
		glue="com.stepDefinition",
		plugin= {"pretty","html:target/CucumberReport.html"},
		monochrome= true
		
		)
public class RunnerLogin {

}
