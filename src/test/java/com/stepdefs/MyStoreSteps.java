package com.stepdefs;

import java.util.Map;

import com.pages.AddItemToCart;
import com.pages.RegisterLoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStoreSteps {
	
	RegisterLoginPage rlPage = new RegisterLoginPage();
	AddItemToCart cart = new AddItemToCart();
	
	@Given("^I launch the My Store application$")
	public void i_launch_the_My_Store_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   rlPage.launchApplication();
	}

	@When("^I click on sign in link$")
	public void i_click_on_sign_in_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rlPage.clickSignIn();
	}

	@When("^I enter email address \"([^\"]*)\" to register and click Create an account$")
	public void i_enter_email_address_to_register(String email) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rlPage.clickCreateAccount(email);
	}

	@When("^I enter below personal details$")
	public void i_enter_below_personal_details(DataTable userDetails) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		rlPage.enterPersonalDetails(userDetails);
	    
	}

	@When("^I click on Register button$")
	public void i_click_on_Register_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rlPage.clickRegisterButton();
	}

	@Then("^I verify account is created and full name is displayed$")
	public void i_should_see_welcome_message_on_My_Account_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rlPage.verifyAccountCreation();
	}

	@Then("^I logout from the application$")
	public void i_logout_from_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rlPage.logout();
	}

	@When("^I enter email address \"([^\"]*)\" and password \"([^\"]*)\" and click signIn$")
	public void i_enter_email_address_and_password(String email, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rlPage.login(email, password);
	}

	@When("^I click on T-Shirts link and Add to Cart$")
	public void i_click_on_T_Shirts_link_and_Add_to_Cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		cart.clickTShirt();
	    cart.addTShirtToCart();
	}

	@When("^I click on Proceed to checkout button$")
	public void i_click_on_Proceed_to_checkout_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.proceedToCheckout();
	}

	@Then("^I verify product details should be displayed$")
	public void product_details_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.verifyProductAndAddress();
	}
	
	@Then("^I verify Address details and proceed$")
	public void I_verify_adress_details_and_proceed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.verifyAddressAndProceed();
	}

	@When("^I agree to terms and conditions$")
	public void i_agree_to_terms_and_conditions() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.acceptTermsConditions();
	}

	@Then("^I should be navigated to Payments page$")
	public void i_should_be_navigated_to_Payments_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.verifyPaymentsPage();
	}

}
