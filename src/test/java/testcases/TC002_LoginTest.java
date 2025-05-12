package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.DemoHomePageAfterLogin;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verify_LoginTest() {
		//logger.info("-------------------TC002_LoginTest---------------");
		HomePage homePage = new HomePage(driver);
		implicitwaits(10);
		homePage.clickLogin();
		implicitwaits(10);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmail(p.getProperty("userName"));
		loginpage.enterPassword(p.getProperty("password"));
		loginpage.clickLoginButton();
		
		DemoHomePageAfterLogin demoHomePageAfterLogin = new DemoHomePageAfterLogin(driver);
		Assert.assertTrue(demoHomePageAfterLogin.verifyLogoutButton());
		//logger.info("-------------------Finished Login scenario---------------");
		
	}

}
