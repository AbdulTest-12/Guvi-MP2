package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;

import pages.AddCartPage;
import pages.CartPage;
import pages.HomePage;

public class AddToCartModule extends ProjectSpecificationMethod{


	@BeforeTest
	public void setup() {
		testName = "Cart Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Cart Functionality with valid and Invalid credentials";

	}

	@Test(priority = 1)
	public void testAddProductToCart() throws InterruptedException {


		HomePage device = new HomePage(driver);
		device.addSamSungS6();

		AddCartPage product = new AddCartPage(driver);
		product.AddToCartBtn();

		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		product.CartInATC();
		Thread.sleep(2000);

		Assert.assertTrue(AddCartPage.isProductInCart("Samsung galaxy s6"));

	}

	@Test(priority = 2)
	public void RemoveAddedProductFromCart() throws InterruptedException {

		HomePage device = new HomePage(driver);
		device.addSamSungS6();

		AddCartPage product = new AddCartPage(driver);
		product.AddToCartBtn();

		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		product.CartInATC();

		CartPage remove = new CartPage(driver);
		remove.deleteItemFromCart();

		Thread.sleep(2000);
		Assert.assertFalse(AddCartPage.isProductInCart("Samsung galaxy s6"));
	}

	@Test(priority = 3)
	public void AddMutilpleProductToCart() throws InterruptedException {
		String[] products = {"Samsung galaxy s6", "Nokia lumia 1520"};

		for (String product : products) {
			addProductToCart(product);
		}

		AddCartPage cart = new AddCartPage(driver);
		cart.CartInATC();
		Thread.sleep(2000);

		for (String product : products) {
			Assert.assertTrue(AddCartPage.isProductInCart(product), product + " not found in cart");
		}
	}


	public void addProductToCart(String product) throws InterruptedException {
		driver.findElement(By.linkText(product)).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(1500);

		driver.switchTo().alert().accept();

		driver.findElement(By.id("nava")).click(); 
		Thread.sleep(1000);
	}

}