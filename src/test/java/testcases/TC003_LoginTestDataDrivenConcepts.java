package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.DemoHomePageAfterLogin;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDataDrivenConcepts extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass =DataProviders.class,groups="dataDriven")
	public void verify_LoginTest(String email,String password) {
		//logger.info("-------------------TC002_LoginTest---------------");
		HomePage homePage = new HomePage(driver);
		implicitwaits(10);
		homePage.clickLogin();
		implicitwaits(10);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		
		DemoHomePageAfterLogin demoHomePageAfterLogin = new DemoHomePageAfterLogin(driver);
		Assert.assertTrue(demoHomePageAfterLogin.verifyLogoutButton());
		demoHomePageAfterLogin.clickLogOutButton();
		//logger.info("-------------------Finished Logout scenario---------------");
		
	}

}
