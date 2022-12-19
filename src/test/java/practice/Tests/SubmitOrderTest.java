package practice.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.TestComponents.BaseTest;
import practice.pageobjects.CartPage;
import practice.pageobjects.CheckoutPage;
import practice.pageobjects.ConfirmationPage;
import practice.pageobjects.LandingPage;
import practice.pageobjects.OrderPage;
import practice.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	
	@Test (dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() throws InterruptedException {
		ProductCatalogue productCatalogue = landingPage.loginApplication("dipanshi@gmail.com", "Test@123");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Boolean match = orderPage.VerifyOrderDisplay(productName);
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
	
		
		/*
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "dipanshi@gmail.com");
		map.put("password", "Test@123");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "dipanshiasawa@gmail.com");
		map1.put("password", "Test@123");
		map1.put("product", "ADIDAS ORIGINAL");
		*/
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\practice\\data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}
