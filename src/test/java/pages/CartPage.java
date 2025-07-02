package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class CartPage extends ProjectSpecificationMethod{
	
   @FindBy(xpath = "//a[normalize-space()='Delete']") 
    WebElement DeleteBtn;
   
   @FindBy(xpath = "//button[normalize-space()='Place Order']")
   WebElement PlaceOrder;


    @SuppressWarnings("static-access")
	public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage deleteItemFromCart() {
        DeleteBtn.click();
        return this;
    }
    
    public PlaceOrderPage PlaceOrderBtn() {
    	PlaceOrder.click();
    	return new PlaceOrderPage(driver);
    }

}

