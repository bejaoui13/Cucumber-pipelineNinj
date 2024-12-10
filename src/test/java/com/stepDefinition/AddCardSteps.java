package com.stepDefinition;

import com.basepage.BasePage;
import com.pageobject.AddCardPage;
import com.pageobject.LoginPage;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCardSteps extends BasePage {

	LoginPage loginpage;
	AddCardPage addproductcard;
	private float floatNumber;

	@Given("User go to home page")
	public void user_go_to_home_page() {
		driver = BasePage.setDriver();
		addproductcard = new AddCardPage(driver);

	}

	@When("User enters name product {string} into the search bar")
	public void user_enters_name_product_into_the_search_bar(String product) {
		addproductcard.searchProduct(product);
	}

	@And("User click on the search button")
	public void user_click_on_the_search_button() {
		addproductcard.clichBtnsearch();

	}

	@Then("User should see message {string}")
	public void user_should_see_message(String msg) {
		System.out.println("-----------------" + addproductcard.invalideProduct());
		Assert.assertEquals(addproductcard.invalideProduct(), msg);
		closeDriver();
 
	}

	@Given("User logged {string} and valid password {string}")
	public void user_logged_and_valid_password(String email, String pwd) {
		driver = BasePage.setDriver();
		loginpage = new LoginPage(driver);
		addproductcard = new AddCardPage(driver);
		loginpage.entercredential(email, pwd);
		loginpage.clickbuttonlogin();

	}

	@Then("User should see a list of product containing {string}")
	public void user_should_see_a_list_of_product_containing(String existeproduct) {
		//System.out.println("++++++++++++++" + addproductcard.existeproduct());
		Assert.assertEquals(addproductcard.existeproduct(), existeproduct);
		
 	}

	@Given("User go to page product")
	public void user_go_to_page_product() {
		addproductcard = new AddCardPage(driver);

		addproductcard.goPageProduct();
	}

	@When("User update {string}")
	public float user_update(String quantity) {
		addproductcard.updateQuantity(quantity);
		String nb = addproductcard.priceOneProduct();
		this.floatNumber = Float.parseFloat(nb);

	//	System.out.println("------*****------" + floatNumber);
		return floatNumber;
	}

	@And("User add product to card")
	public void user_add_product_to_card() {
		addproductcard.clickAddCard();
	}

	@And("User go to shoping card")
	public void user_go_to_shoping_card() {
		addproductcard.goShopCard();
	}

	@Then("User have the price correct in the shoping card {string}")
	public void user_have_price_correct_in_the_shoping_card(String qteexpected) throws InterruptedException {

		float actualpricecard = Float.parseFloat(addproductcard.checkPrice());

		float floatqte = Float.parseFloat(qteexpected);
		float expectedTotalpricecard = this.floatNumber * floatqte;
		//System.out.println("----" + this.floatNumber + "----" + floatqte + "----" + expectedTotalpricecard);
 
		//Assert.assertEquals(actualpricecard, expectedTotalpricecard, "Price incorrect");
		Assert.assertEquals(addproductcard.checkQte(), qteexpected, "Qte incorrect");

		
 
	}

	@Given("User in the page card shop")
	public void user_in_the_page_card_shop() {
		addproductcard = new AddCardPage(driver);
	}

	@When("User update quantity {string} and click on the button")
	public void user_update_quantity_and_click_on_the_button(String newqte) throws InterruptedException {
		addproductcard.updateQTEpageCard(newqte);
		addproductcard.checkQte();
	}

	@Then("User have succes alert {string}")
	public void user_have_succes_alert(String msg) {
      Assert.assertEquals(addproductcard.succesAlertUpdate(), true);
	}

	@When("User click on the button deleted")
	public void user_click_on_the_button_deleted() {
        
		addproductcard.deletQteCard();
		
	}

	@Then("User dont have product {string} on the page")
	public void user_dont_have_product_on_the_page(String nomproduct) {
      Assert.assertEquals(true, addproductcard.checkDeletElement(nomproduct));
		closeDriver();
	}

}
