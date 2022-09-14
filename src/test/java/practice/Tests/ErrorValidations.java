package practice.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.TestComponents.BaseTest;
import practice.pageobjects.CartPage;
import practice.pageobjects.CheckoutPage;
import practice.pageobjects.ConfirmationPage;
import practice.pageobjects.LandingPage;
import practice.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		
		String productName = "ZARA COAT 3";		
		ProductCatalogue productCatalogue = landingPage.loginApplication("dipanshi@gmail.comjj", "Test@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		
	}
	
	
	
}
