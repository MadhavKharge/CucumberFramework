package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommanUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
	private WebElement warningMessage;

	public void enterEmailAddress(String emailtext) {

		elementUtils.typeTextIntoElement(emailField, emailtext, CommanUtils.EXPLICIT_WAIT_BASICTIME);

//		emailField.sendKeys(emailtext); Optimized fromUtils Package ElementUtils Class

	}

	public void enterPassword(String passwordText) {

		elementUtils.typeTextIntoElement(passwordField, passwordText, CommanUtils.EXPLICIT_WAIT_BASICTIME);

//		passwordField.sendKeys(passwordText);  Optimized fromUtils Package ElementUtils Class

	}

	public AccountPage clickOnloginButton() {

		elementUtils.clickOnElements(loginButton, CommanUtils.EXPLICIT_WAIT_BASICTIME);

//		loginButton.click();   Optimized fromUtils Package ElementUtils Class

		return new AccountPage(driver);
	}

	public String getWarningMesageText() {

		return elementUtils.getTextFromElement(warningMessage, CommanUtils.EXPLICIT_WAIT_BASICTIME);

//		return warningMessage.getText(); Optimized fromUtils Package ElementUtils Class

	}

}
