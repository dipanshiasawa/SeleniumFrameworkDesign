package practice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practice.pageobjects.CartPage;

public class AbstractComponent {
	
	
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement element) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForElementToDisappear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}
	
	public void waitForSeconds(int num) throws InterruptedException {
		Thread.sleep(num);

	}
	
	public CartPage goToCartPage() throws InterruptedException {
//		Thread.sleep(8000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.elementToBeClickable(cartHeader));
//		wait.until(ExpectedConditions.elementToBeClickable(cartHeader)).click();
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
}
