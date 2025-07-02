package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class AddCartPage extends ProjectSpecificationMethod {
	
	@FindBy(xpath = "//a[normalize-space()='Add to cart']")
	WebElement AddToCartBtn;
	
	@FindBy(xpath = "//a[@id='cartur']")
	WebElement   Cart;
	
	@SuppressWarnings("static-access")
	public AddCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddToCartBtn() {
		AddToCartBtn.click();
	}
	
	public String Productaddedalert() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept(); 
		return alertText;
	}
	
	public CartPage CartInATC() {
		Cart.click();
		return new CartPage(driver);
	}
	
	public static  boolean isProductInCart(String Products) {
        return driver.getPageSource().contains(Products);
    }

}
