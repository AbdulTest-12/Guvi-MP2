package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.NavigationPage;

public class NavigationModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "Navigation Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Navigation Functionality of application";

	}

	@Test(priority = 1)
	public void testNavigateToHome() {
		NavigationPage navPage = new NavigationPage(driver);
		navPage.ClickHome();
		Assert.assertTrue(driver.getCurrentUrl().contains("demoblaze.com"));
	}

	@Test(priority = 2)
	public void testNavbarLinks() throws InterruptedException {
		NavigationPage navPage = new NavigationPage(driver);
		navPage.ClickCart();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
		navPage.ClickHome();
		Thread.sleep(1000);
		navPage.ClickContact();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("exampleModal")).isDisplayed());
	}

	@Test(priority = 3)
	public  void Navigation() throws InterruptedException {
		NavigationPage navPage = new NavigationPage(driver);
		navPage.selectCategory("Laptops");
		Thread.sleep(1000);
		Assert.assertTrue(driver.getPageSource().contains("Sony vaio i5"));
	}

	@Test(priority = 4)
	public void testViewProductDetails() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Nokia lumia 1520']")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getPageSource().contains("Product description"));
	}

}


