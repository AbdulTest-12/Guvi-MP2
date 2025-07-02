package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LoginPage;


public class LoginModule extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() {
		sheetname = "Login";
		testName = "Login Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Login Functionality with valid and Invalid credentials";

	}
	
	@Test(dataProvider = "readData")
	public  void LoginFunctionality(String username, String password, String testType, String expectedMessage) throws InterruptedException {
		HomePage login = new HomePage(driver);
		login.ClickLogin();
		
		LoginPage details = new LoginPage(driver);
		
		details.enterUserName(username);
		details.enterPassword(password);
		
		details.ClickLoginBtn();
		Thread.sleep(1000);
		details.validateLogin(testType, expectedMessage);

	}
}
