@tag
Feature: Purchase the order from Ecommerce Website

	Background:
	Given I landed on Ecommerce Page
	
	@Regression
	Scenario Outline: Positive Test of Submitting the order
	  Given Logged in with username <username> and <password>
	  When I add product <productName> to Cart
	  And Checkout <productName> and submit the order
	  Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	  
	  Examples:
		|          username            |  password   |   productName   |
		|selenium.automation@gmail.com | Welcome@123 |   ZARA COAT 3   |

