package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LoginPage;

public class LogOutModule extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() throws IOException {
           readAndWritePropFile();
   		testName = "Navigation Test";
   		testAuthor = "Abdul Nazeer";
   		testCategory = "Regression";
   		testCategory = "Validation of Navigation Functionality";
	}
	@Test
	public void LogoutFunctionality() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.ClickLogin();

		LoginPage userInfo = new LoginPage(driver);
		userInfo.enterUserName(prop.getProperty("username"))
		.enterPassword(prop.getProperty("password"))
		.ClickLoginBtn();

		Thread.sleep(3000);


		HomePage logout = new HomePage(driver);
		logout.clickLogout();
		Thread.sleep(2000);

		Assert.assertTrue(logout.isLoggedOut());
	}


}
