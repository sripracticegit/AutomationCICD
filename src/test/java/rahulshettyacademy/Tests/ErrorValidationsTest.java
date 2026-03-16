package rahulshettyacademy.Tests;

import java.io.IOException;
 
 
 
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
 
import rahulshettyacademy.pageobjects.ProductCatalogue;

// firstname : Selenium
//lastname : Automation
//phone: 9885123456
//gender : female
//occupation : Engineer
//email : selenium.automation@gmail.com
//pwd : Welcome@123

public class ErrorValidationsTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

	  		
		landingPage.loginApplication("vidya.paduri@gmail.com","Welcome@456");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
	 
		 }
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("sri.reddy@gmail.com","Welcome@456");
	 productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		 
	 

	}

}
