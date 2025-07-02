package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {
	
	@FindBy(xpath =  "//a[text()='Home ']")
	WebElement Home;
	
	@FindBy(xpath = "//a[text()='Contact']" )
	WebElement Contact;
	
	@FindBy(xpath = "//a[text()='About us']")
	WebElement AboutUs;
	
	@FindBy(id = "cartur")
	WebElement Cart;
	
	@FindBy(id = "login2")
	WebElement Login;
	
	@FindBy(id = "signin2")
	WebElement SignUp;
	
	@FindBy(id = "logout2")
	WebElement Logout;
	
	@FindBy(id = "nameofuser")
    WebElement NameOfUser;
	
	@FindBy(xpath = "//a[text()='Phones']")
	WebElement Phones;
	
	@FindBy(xpath = "//a[text()='Laptops']")
	WebElement Laptops;
	
	@FindBy(xpath = "//a[text()='Monitors']")
	WebElement Monitors;
	
	
	@FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
	WebElement SamSungGalaxyS6;
	
	@FindBy(xpath = "//a[text()='Nokia lumia 1520']")
	WebElement NokiaLimia1520;
	
	@FindBy(xpath = "//a[text()='Nexus 6']")
	WebElement Nexus6;
	
	@FindBy(xpath = "//a[text()='Samsung galaxy s7']")
	WebElement SamSungGalaxyS7;
	
	@FindBy(xpath = "//a[text()='Iphone 6 32gb']")
	WebElement iPhone632gb;
	
	@FindBy(xpath = "//a[text()='Sony xperia z5']")
	WebElement SonyXperiaz5;
	
	@FindBy(xpath = "//a[text()='HTC One M9']")
	WebElement HTCOneM9;
	
	@SuppressWarnings("static-access")
	public HomePage(WebDriver driver) {
	     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage ClickHome() {
		
		Home.click();
		return this;		
	}
	
   public ContactPage ClickContact() {
	Contact.click();
	return new ContactPage(driver);
   }
   
   public CartPage ClickCart() {
	   Cart.click();
	   return new CartPage(driver);
	   
   }
   
   public SignUpPage ClickSignUp() {
	   SignUp.click();
	   return new SignUpPage(driver);
   }
   
   public LoginPage ClickLogin() {
	   Login.click();
	   return new LoginPage(driver);
   }
   

	public CartPage addSamSungS6() {
		SamSungGalaxyS6.click();
		return new CartPage(driver);
	}
	
	public CartPage addNokiaL() {
	NokiaLimia1520
		.click();
		return new CartPage(driver);
	}
	public void clickLogout() {
		Logout.click();
	}

	public boolean isLoggedOut() {
		return Login.isDisplayed();
	}

}
