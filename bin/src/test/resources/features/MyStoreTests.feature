Feature: Register to My Store web site and add a product to Shopping Cart


@Register
Scenario: Register to My Store web site
	
	Given I launch the My Store application
	When  I click on sign in link
	And   I enter email address "sel552@java.com" to register and click Create an account
	When  I enter below personal details
	|Title |First Name | Last Name | Password  | Company  | Address     | City    | State  | Zip Code | Mobile Phone | Address Alias |
	| Mr.  | Selenium  | Java      | Pass123   | CTS Test | 12 James St | Newyork | Alaska | 40560    | 6530126789   | sel123        |
	And   I click on Register button
	Then  I verify account is created and full name is displayed
	Then  I logout from the application

@AddItemsToCart	
Scenario: Login to My Store and add products to the cart

	Given I launch the My Store application
	When  I click on sign in link
	And   I enter email address "sel552@java.com" and password "Pass123" and click signIn
	When  I click on T-Shirts link and Add to Cart 
	Then  I verify product details should be displayed
	When  I click on Proceed to checkout button
	And   I verify Address details and proceed
	And   I agree to terms and conditions
	Then  I should be navigated to Payments page
	
	 