package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommanUtils;

public class Loginn {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;

	@Given("User has navigates to login Page")
	public void User_has_navigates_to_login_Page() {

		driver = Driverfactory.getDriver();
		HomePage hPage = new HomePage(driver);
		hPage.clickOnMyAccount();
		loginPage = hPage.clickOnLogin();

	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {

//		loginPage = new LoginPage(driver);  optimized line already created object

		loginPage.enterEmailAddress(emailText);

//   driver.findElement(By.id("input-email")).sendKeys(emailText);
		
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String password) {

		loginPage = new LoginPage(driver);
		loginPage.enterPassword(password);

		// driver.findElement(By.id("input-password")).sendKeys(password);

	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnloginButton();

		// driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());

//		Assert.assertTrue(
//				driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {

//		loginPage = new LoginPage(driver); optimized line

		loginPage.enterEmailAddress(CommanUtils.getEmailWithTimeStamp());

//		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());

	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {

		loginPage.enterPassword(invalidPasswordText);

//		driver.findElement(By.id("input-password")).sendKeys(getEmailWithTimeStamp());

	}

	@Then("User should get a warning massage about credentials mismatch")
	public void user_should_get_a_warning_massage_about_credentials_mismatch() {

		Assert.assertTrue(
				loginPage.getWarningMesageText().contains("Warning: No match for E-Mail Address and/or Password"));

//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]")).getText()
//				.contains("Warning: No match for E-Mail Address and/or Password"));

	}

	@When("User  dont enters any email address into email field")
	public void user_dont_enters_any_email_address_into_email_field() {

//		loginPage = new LoginPage(driver); optimized line  already created object

		loginPage.enterEmailAddress("");

		// driver.findElement(By.id("input-email")).sendKeys("");

	}

	@And("User dont enters any password into password field")
	public void user_dont_enters_any_password_into_password_field() {

//		loginPage = new LoginPage(driver); optimized line  already created object
	
		loginPage.enterPassword("");

		// driver.findElement(By.id("input-password")).sendKeys("");

	}

}
