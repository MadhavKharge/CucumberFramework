package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchPageResult;
import pages.SearchPageResult;

public class Searchh {

	WebDriver driver;
	private HomePage homePage;
	private SearchPageResult searchPageResult ;

	@Given("User opens the application")
	public void user_opens_the_application() {

		driver = Driverfactory.getDriver();

	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {

		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);

//		driver.findElement(By.name("search")).sendKeys(validProductText);

	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {

		searchPageResult=homePage.clickOnSearchButton();

//		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default btn-lg')]")).click();

	}

	@Then("User should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {

//		SearchPageResult searchPageResult = new SearchPageResult(driver);  optimized line object created
		
		Assert.assertTrue(searchPageResult.displayStatusOfValidProduct());
 //      Assert.fail();
		
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproductText) {

		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidproductText);

//		driver.findElement(By.name("search")).sendKeys(invalidProduct);

	}

	@Then("User should get a massage about no product matching")
	public void user_should_get_a_massage_about_no_product_matching() {

		SearchPageResult searchPageResult = new SearchPageResult(driver);

		Assert.assertEquals("There is no product that matches the search criteria.", searchPageResult.getMessageText());

//		Assert.assertEquals("There is no product that matches the search criteria.",
//				driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());

	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

		homePage = new HomePage(driver);

		// kept blank

	}

}
