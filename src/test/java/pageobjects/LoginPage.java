package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="Email")
	WebElement emailTextBox;
	
	@FindBy(id="Password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement logInButton;
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
		
	}
	
	public void enterPassword(String pwd) {
		passwordTextBox.sendKeys(pwd);
		
	}
	
	public void clickLoginButton() {
		logInButton.click();
		
	}
	

}
