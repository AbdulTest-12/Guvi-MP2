package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod{

	@FindBy(id = "loginusername")
	WebElement LoginUserName;

	@FindBy(id = "loginpassword")
	WebElement LoginPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[contains(text(), 'Welcome')]")
	WebElement Welcome;

	@SuppressWarnings("static-access")
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUserName(String username) {
		LoginUserName.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String psw) {
		LoginPassword.sendKeys(psw);
		return this;

	}

	public HomePage ClickLoginBtn() {
		LoginBtn.click();

		return new HomePage(driver);
	}

	public static String AcceptAlertText() {

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept(); 
		return alertText;
	}

	@SuppressWarnings("deprecation")
	public String getPasswordFieldType() {

		WebElement password = driver.findElement(By.id("LoginPassword"));
		return password.getAttribute("type");
	}

	public void validateLogin(String testType, String expectedMessage){
        
		if(testType.equals("valid")) {

			String actualText = Welcome.getText();
			Assert.assertEquals(actualText, expectedMessage);

		}else if(testType.equals("No User")){

			String alertText = LoginPage.AcceptAlertText();
			Assert.assertEquals(alertText, expectedMessage);

		}else if(testType.equals("Wrong Password")){

			String alertText = LoginPage.AcceptAlertText();
			Assert.assertEquals(alertText, expectedMessage);

		}else if(testType.equals("Not Registered")){

			String alertText = LoginPage.AcceptAlertText();
			Assert.assertEquals(alertText, expectedMessage);
		}
	}

}
