package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod{

	@FindBy(id = "sign-username")
	WebElement SignUserName;

	@FindBy(id= "sign-password")
	WebElement SignPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement ClickSignUp;

	@SuppressWarnings("static-access")
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignUpPage enterSignUserName(String username) {
		SignUserName.clear();
		SignUserName.sendKeys(username);
		return this;
	}

	public SignUpPage enterPassword(String psw) {
		SignPassword.clear();
		SignPassword.sendKeys(psw);
		return this;
	}

	public HomePage ClickSignUpBtn() {
		ClickSignUp.click();
		return new HomePage(driver);
	}

	public void validateSignUp(String testType, String expectedMessage){

		if(testType.equals("Valid")){

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			Assert.assertTrue(alertText.contains(expectedMessage));


		}else if(testType.equals("No User")){
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			Assert.assertTrue(alertText.contains(expectedMessage));

		}else if(testType.equals("Duplicate")){
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			Assert.assertTrue(alertText.contains(expectedMessage));
		}

	}
}
