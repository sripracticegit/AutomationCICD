@tag
Feature: Error validation 
 	
	@ErrorValidation
	Scenario Outline: Negative Test of Login Page
	  Given I landed on Ecommerce Page
	  When Logged in with username <username> and <password>
	  Then "Incorrect email or password." message is displayed 
	  
	  Examples:
		|          username            |  password   |   
		|selenium.automation@gmail.com | Welcome123 |   
