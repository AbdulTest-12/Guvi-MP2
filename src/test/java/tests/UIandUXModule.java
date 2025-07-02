package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class UIandUXModule extends ProjectSpecificationMethod {

	
	@BeforeTest
	public void setup() {
		testName = "UITest";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of UI Functionality of website";
	}
	
	
	@Test(priority = 1)
	public void ProductTileAlignment() {
        List<WebElement> productCards = driver.findElements(By.className("card"));
        Assert.assertTrue(productCards.size() > 0, "No product tiles found.");

        for (WebElement card : productCards) {
            Assert.assertTrue(card.isDisplayed(), "Product tile not displayed.");
        }
    }
	
	@Test(priority = 2)
	public void getPasswordFieldType() {
		HomePage login = new HomePage(driver);
		login.ClickLogin();
		
		@SuppressWarnings("deprecation")
		String fieldType = driver.findElement(By.id("loginpassword")).getAttribute("type");
		Assert.assertEquals(fieldType, "password", "Password field is not masked.");

	}
    @Test(priority = 3)
    public void ActionButtonsVisibility() {
        Assert.assertTrue(driver.findElement(By.id("login2")).isDisplayed(), "Login button not visible");
        Assert.assertTrue(driver.findElement(By.id("signin2")).isDisplayed(), "Sign up button not visible");
        Assert.assertTrue(driver.findElement(By.id("cartur")).isDisplayed(), "Cart button not visible");
    }
    
    @Test(priority = 4)
    public void FontConsistency() {
        WebElement header = driver.findElement(By.id("nava"));
        header.click();
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement freshHeader = wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.id("nava")));
     
        String fontFamily = freshHeader.getCssValue("fontFamily");
        
        Assert.assertTrue(fontFamily.contains("LatoWeb"));
    }
}
