package practice.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import practice.TestComponents.BaseTest;
import practice.pageobjects.CartPage;
import practice.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

//	@Test (groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException {
		
		String productName = "ZARA COAT 3";		
		landingPage.loginApplication("dipanshi1@gmail.com", "incorrectpassword");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("dipanshiasawa@gmail.com", "Test@123");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay("ZZZZ");
		Assert.assertFalse(match);

		
	}
	
	
}
