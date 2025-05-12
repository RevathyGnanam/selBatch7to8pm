package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePageAfterLogin extends BasePage{

	public DemoHomePageAfterLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logOutButton;
	
	public boolean verifyLogoutButton() {
		try {
			return logOutButton.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}	
		
	}
	
	public void clickLogOutButton() {
		logOutButton.click();
	}

}
