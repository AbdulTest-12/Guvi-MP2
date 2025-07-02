package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AddCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;

public class PlaceOrderModule extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() {
		
		testName = "PlaceOrderTest";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of PlaceOrder Functionality with valid and Invalid credentials";
	}

	@Test(priority = 1)
	public void testPlaceOrderWithValidDetails() throws InterruptedException {
		Thread.sleep(1000);
		HomePage device = new HomePage(driver);
		device.addSamSungS6();

		AddCartPage addcart = new AddCartPage(driver);
		addcart.AddToCartBtn();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();


		addcart.CartInATC();

		CartPage order = new CartPage(driver);
		order.PlaceOrderBtn();


		PlaceOrderPage cardInfo = new PlaceOrderPage(driver);
		cardInfo.fillOrderDetails("Happy Customer", "India", "Coimbatore", "5555520002", "12", "2028");
		WebDriverWait purchaseBtn = new WebDriverWait(driver, Duration.ofSeconds(10));
		purchaseBtn.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Purchase']"))));
		
		cardInfo.ClickPurchaseBtn();

		Thread.sleep(3000);

		Assert.assertTrue(cardInfo.isConfirmationDisplayed());
	}

	@Test(priority = 2)
	public void testPlaceOrderWithEmptyForm() throws InterruptedException {

		HomePage device = new HomePage(driver);
		device.addSamSungS6();

		AddCartPage addcart = new AddCartPage(driver);
		addcart.AddToCartBtn();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();

		addcart.CartInATC();

		CartPage order = new CartPage(driver);
		order.PlaceOrderBtn();
		
		WebDriverWait purchaseBtn = new WebDriverWait(driver, Duration.ofSeconds(10));
		purchaseBtn.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Purchase']"))));
		

		PlaceOrderPage cardInfo = new PlaceOrderPage(driver);
		cardInfo.ClickPurchaseBtn();

		Thread.sleep(1000);

		Assert.assertTrue(cardInfo.PleaseFillDetailsAlert().contains("Please fill out Name and Creditcard."));
	}
}



