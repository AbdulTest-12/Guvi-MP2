package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class PlaceOrderPage extends ProjectSpecificationMethod{

	@FindBy(xpath = "//input[@id='name']")
	WebElement Name;

	@FindBy(xpath = "//input[@id='country']")
	WebElement Country;


	@FindBy(xpath = "//input[@id='city']")
	WebElement City;

	@FindBy(xpath = "//input[@id='card']")
	WebElement CreditCard;

	@FindBy(xpath = "//input[@id='month']")
	WebElement Month;

	@FindBy(xpath = "//input[@id='year']" )
	WebElement Year;

	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement PurchaseBtn;


	@FindBy(xpath = "//div[contains(@class,'showSweetAlert visible')]")
	WebElement ConfirmationPopUp;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement ConfirmationOK;

	@SuppressWarnings("static-access")
	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
		Name.sendKeys(name);
		Country.sendKeys(country);
		City.sendKeys(city);
		CreditCard.sendKeys(card);
		Month.sendKeys(month);
		Year.sendKeys(year);
	}


	public void ClickPurchaseBtn() {
		PurchaseBtn.click();

	}

	public boolean isConfirmationDisplayed() {
		return ConfirmationPopUp.isDisplayed();

	}

	public String PleaseFillDetailsAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		return alertText;
	}
	public HomePage acceptConfirmationAlert() {

		String ConfirmationMsg = ConfirmationPopUp.getText();
		System.out.println(ConfirmationMsg);
		ConfirmationOK.click();
		return new HomePage(driver);
	}

}
