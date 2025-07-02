package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class NavigationPage extends ProjectSpecificationMethod{

	@FindBy(xpath = "//li[@class='nav-item active']//a[@class='nav-link']")
	WebElement Home;

	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement Contact;

	@FindBy(xpath = "//a[@id='cartur']")
	WebElement Cart;

	@FindBy(xpath = "//a[@id='login2']")
	WebElement Login;

	@FindBy(xpath = "//a[@id='signin2']")
	WebElement SignUp;
	
	@FindBy(xpath = "//div[@id='contcont']//a[2]")
	WebElement Phones;
	
	@FindBy(xpath = "//div[@id='contcont']//a[3]")
	WebElement Laptops;
	
	@FindBy(xpath = "//div[@id='contcont']//a[4]")
	WebElement Monitors;

	@SuppressWarnings("static-access")
	public NavigationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage ClickHome() {
		Home.click();
		return new HomePage(driver);
	}

	public ContactPage ClickContact() {
		Contact.click();
		return new ContactPage(driver);
	}

	public AddCartPage ClickCart() {
		Cart.click();
		return new AddCartPage(driver);
	}

	public LoginPage ClickLogin() {
		Login.click();
		return new LoginPage(driver);
	}

	public SignUpPage ClickSignUp() {
		SignUp.click();
		return new SignUpPage(driver);
	}
	
	public void selectCategory(String category) {
        switch (category.toLowerCase()) {
            case "phones":
                Phones.click();
                break;
            case "laptops":
                Laptops.click();
                break;
            case "monitors":
                Monitors.click();
                break;
        }
    }


}
