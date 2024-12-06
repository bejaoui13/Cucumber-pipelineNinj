package com.stepDefinition;

import com.baseTest.BaseTest;
import com.pageobject.LoginPage;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

	LoginPage loginpage;

	@Given("User open browser")
	public void user_open_browser() {

		driver = BaseTest.setDriver();
		loginpage = new LoginPage(driver);

	}

	@When("User enters invalid email {string} and valid password {string}")
	public void user_enters_invalid_email_and_valid_password(String email, String pwd) {
		loginpage.entercredential(email, pwd);
	}

	@And("User click button login")
	public void user_click_button_login() {
		loginpage.clickbuttonlogin();
		

	}

	@Then("login should be failed with an error {string}")
	public void login_should_be_failed_with_an_error(String error) throws InterruptedException {
		 
		System.out.println("***************" + loginpage.validatelogin());
	    Assert.assertEquals(loginpage.validatelogin(),error);
        closeDriver();


	}

	@When("Enter valid login {string} and valid password {string}")
	public void enter_valid_login_and_valid_password(String emailinp, String pwdinp) {
		loginpage.entercredential(emailinp, pwdinp);
		
	}

	@Then("User should connect to home page")
	public void user_should_connect_to_home_page() {
		System.out.println("*********************" + loginpage.validatepagehome());
	    Assert.assertEquals(loginpage.validatepagehome(),"My Account");
           closeDriver();
	}

}
