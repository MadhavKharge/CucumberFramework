package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommanUtils;

public class Registerr {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;

	@Given("User has navigates to Register Account Page")
	public void user_has_navigates_to_register_account_page() {

		driver = Driverfactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

//		driver = Driverfactory.getDriver();
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Register")).click();

	}

	@When("User enters below details into fields")
	public void user_enters_below_details_into_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

//		registerPage = new RegisterPage(driver); optimized line object created 

		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enteremailAddress(CommanUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterpassword(dataMap.get("password"));
		registerPage.enterconfirmPassword(dataMap.get("password"));

//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
//		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));

	}

	@When("User enters below details into fields with duplicate email")
	public void user_enters_below_details_into_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

//		registerPage = new RegisterPage(driver);  optimized line object created 

		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enteremailAddress(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterpassword(dataMap.get("password"));
		registerPage.enterconfirmPassword(dataMap.get("password"));

//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
//		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));

	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {

		registerPage.SelectPrivacyPolicy();

//		driver.findElement(By.xpath("//input[@name='agree']")).isSelected();

	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {

		accountSuccessPage = registerPage.clickonContinueButton();

//		driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

	@Then("User account should get created")
	public void user_account_should_get_created() {

//		AccountSuccessPage accoutSuccessPage = new AccountSuccessPage(driver);   optimized code

		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());

//		Assert.assertEquals("Your Account Has Been Created!",
//				driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-9 > h1:nth-child(1)")).getText());
//   xpath= div[@id='content']/h1	

	}

	@When("User select Yes for Newsletter")
	public void user_select_yes_for_newsletter() {

		registerPage.selectYesToNewslatterOption();

//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {

		Assert.assertTrue(
				registerPage.getWarnigMessageText().contains("Warning: E-Mail Address is already registered!"));

//		Assert.assertTrue(
//				driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Register Account"));

	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {

//		registerPage = new RegisterPage(driver); optimized line 

		// intentionally kept blank below step no needed 
		
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enteremailAddress("");
		registerPage.enterTelephone("");
		registerPage.enterpassword("");
		registerPage.enterconfirmPassword("");

	}

	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {

		Assert.assertTrue(
				registerPage.getWarnigMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstnameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getlastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getpasswordWarning());

//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
//				.contains("Warning: You must agree to the Privacy Policy!"));
//		Assert.assertEquals("First Name must be between 1 and 32 characters!",
//				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
//		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
//				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
//		Assert.assertEquals("E-Mail Address does not appear to be valid!",
//				driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
//		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
//				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
//		Assert.assertEquals("Password must be between 4 and 20 characters!",
//				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());

	}

}
