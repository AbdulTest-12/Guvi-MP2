package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpModule extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup() {
		sheetname = "Sign";
		testName = "SignupTest";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of SignUp Functionality with valid and Invalid credentials";
	}

	@Test(dataProvider = "readData")
	public void SignUp(String username, String password,String testType, String expectedMessage){
		HomePage SignUp = new HomePage(driver);
		SignUp.ClickSignUp();

		SignUpPage userInfo = new SignUpPage(driver);
		
		userInfo.enterSignUserName(username);
		userInfo.enterPassword(password);
		userInfo.ClickSignUpBtn();
		userInfo.validateSignUp(testType, expectedMessage);
	}
}
