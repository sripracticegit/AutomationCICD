package rahulshettyacademy.Tests;

 
import java.io.IOException; 
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
 
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

// firstname : Selenium
//lastname : Automation
//phone: 9885123456
//gender : female
//occupation : Engineer
//email : selenium.automation@gmail.com
//pwd : Welcome@123


public class SubmitOrderTest extends BaseTest {
	
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"},retryAnalyzer=Retry.class)
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		//Submitting orders
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		//productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	 
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		//To verify ZARA COAT 3 is displaying in orders page
		ProductCatalogue productCatalogue = landingPage.loginApplication("selenium.automation@gmail.com","Welcome@123");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
	}
	
	//FAQ : How you are driving the data from external files by utilizing TestNG data provider as an integration to implement parameterization data driven testing in your framework?
	//Ans: The framework uses the @DataProvider annotation in TestNG as an integration point 
	      //to read test data from external files (like Excel, CSV, or JSON) and supply it to test methods for data-driven testing.
	
	
	
	/*HashMap<String,String> map = new HashMap<String,String>();
	map.put("email", "selenium.automation@gmail.com");
	map.put("password", "Welcome@123");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String,String> map1 = new HashMap<String,String>();
	map1.put("email", "sri.reddy@gmail.com");
	map1.put("password", "Welcome@456");
	map1.put("product", "ADIDAS ORIGINAL");
	*/
	
	//@DataProvider
    //	public Object[][] getData()
	//{		
	//	return new Object[][] {{"selenium.automation@gmail.com","Welcome@123","ZARA COAT 3"},{"sri.reddy@gmail.com","Welcome@456","ADIDAS ORIGINAL"}};
	//}
	
	
	
	
	
	
	

}
