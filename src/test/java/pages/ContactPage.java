package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethod;

public class ContactPage extends ProjectSpecificationMethod{
	
	@FindBy(id= "recipient-email")
	WebElement ConatctEmail;
	
	@FindBy(id= "recipient-name")
	WebElement ContactName;
	
	@FindBy(id = "message-text")
	WebElement Message;
	
	@FindBy(xpath =  "//button[text()='Send message']")
	WebElement ClickSendMessage;
	
	@SuppressWarnings("static-access")
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public ContactPage enterContactEmail (String email) {
		ConatctEmail.sendKeys(email);
		return this;
		
	}
	
	public ContactPage enterContactName(String name) {
		ContactName.sendKeys(name);
		return this;
	}
	 public ContactPage enterMessage(String msg) {
		 Message.sendKeys(msg);
		 return this;
		
	 }
	 public HomePage enterSendMessage() {
		 ClickSendMessage.click();
		 driver.switchTo().alert().accept();
		 return new HomePage(driver);
	 }
	 

}
