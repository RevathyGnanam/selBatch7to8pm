package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.AccountRegistrationPage;
import pageobjects.BasePage;
import pageobjects.HomePage;
import testbase.BaseClass;

public class TC001_RegistrationTest extends BaseClass{


	@Test(groups= {"Regression","Master"})
	public void account_Registration() {
		//logger.info("-----------------Reached the home page-----------");
		HomePage homepage = new HomePage(driver);
		homepage.clickRegister();
		//logger.info("-----------------Reached the register page-----------");
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		//logger.info("-----------------provide customer details-----------");
		
		regPage.clickGenderBulletButton();
		regPage.enterFirstName(randomAlphabetic());
		regPage.enterLastName(randomAlphabetic());
		regPage.enterEmail(randomAlphaNumeric()+"@gmail.com");
		String password = randomAlphaNumeric();
		regPage.enterPassword(password);
		regPage.enterConfirmPassword(password);
		regPage.clickRegisterButton();
		String getConfirmationMgs = regPage.getConfirmationMgs();
		Assert.assertEquals(getConfirmationMgs, "Your registration completed");
		regPage.clickContinueButton();


	}






}
