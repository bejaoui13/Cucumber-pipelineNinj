package com.myRunner;

import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Login.feature",
		glue="com.stepDefinition",
		plugin= {"pretty","html:target/CucumberReport.html"},
		monochrome= true
		
		)
public class RunnerLogin {

}
