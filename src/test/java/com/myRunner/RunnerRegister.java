package com.myRunner;

import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Registration.feature",
		glue="com.stepDefinition",
		plugin= {"pretty","html:target/CucumberReport.html"},
		monochrome= true
		
		)


public class RunnerRegister {

	
	
}
