package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginScenarios {

	WebDriver driver;
	@Before
	@Given("Open the browser")
	public void openTheBrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

	}
	@When("Launch the Url")
	public void launchTheUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("URL has been launched successfully");

	}
	@Then("Enter the valid credentials")
	public void enterTheValidCredentials() {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

	}
	@Then("Click on login button")
	public void clickOnLoginButton() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("User should navigate to the home page")
	public void userShouldNavigateToTheHomePage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

	}
	@Then("Verify title of the page")
	public void verifyTitleOfThePage() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");

	}
	@After
	@Then("Close the browser")
	public void closeTheBrowser() {
		driver.quit();
	}


	@Then("^Enter the invalid credentials(.*)and(.*)$")
	public void enter_the_invalid_credentials_username_and_password(String username,String password) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

	}

	@Then("Verify error message of the page")
	public void verify_error_message_of_the_page() {
		String  errorText = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
		Assert.assertEquals(errorText, "Invalid credentials");
	}

	@Then("^Enter valid credentials")
	public void enter_valid_credentials(DataTable dataTable) throws Exception {
		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		String userName =null;
		String passWord =null;

		for (Map<String, String> map : userList) {
			userName = map.get("username");
			passWord = map.get("username");


			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(5000);
		}




	}




}
