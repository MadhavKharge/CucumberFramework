package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clickButton;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement YesNewslatterOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement FirstnameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement LastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement EmailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement PasswordWarning;

	public void enterFirstName(String firstNameText) {

		elementUtils.typeTextIntoElement(firstNameField, firstNameText, 30);

//		firstNameField.sendKeys(firstNameText); Optimized from ElementUtils Class

	}

	public void enterLastName(String LastNameText) {

		elementUtils.typeTextIntoElement(lastNameField, LastNameText, 30);

//		lastNameField.sendKeys(LastNameText); Optimized from ElementUtils Class

	}

	public void enteremailAddress(String emailText) {

		elementUtils.typeTextIntoElement(emailField, emailText, 30);

//		emailField.sendKeys(emailText); Optimized from ElementUtils Class
	}

	public void enterTelephone(String telephoneText) {

		elementUtils.typeTextIntoElement(telephoneField, telephoneText, 30);

//		telephoneField.sendKeys(telephoneText); Optimized from ElementUtils Class
	}

	public void enterpassword(String passwordText) {

		elementUtils.typeTextIntoElement(passwordField, passwordText, 30);

//		passwordField.sendKeys(passwordText); Optimized from ElementUtils Class

	}

	public void enterconfirmPassword(String passwordText) {

		elementUtils.typeTextIntoElement(passwordConfirmField, passwordText, 30);

//			passwordConfirmField.sendKeys(passwordText); Optimized from ElementUtils Class

	}

	public void SelectPrivacyPolicy() {

		elementUtils.clickOnElements(privacyPolicyOption, 30);

//		privacyPolicyOption.click(); Optimized from ElementUtils Class

	}

	public AccountSuccessPage clickonContinueButton() {

		elementUtils.clickOnElements(clickButton, 30);

//		clickButton.click();  Optimized from ElementUtils Class

		return new AccountSuccessPage(driver);
	}

	public void selectYesToNewslatterOption() {

		elementUtils.clickOnElements(YesNewslatterOption, 30);

//		YesNewslatterOption.click(); Optimized from ElementUtils Class

	}

	public String getWarnigMessageText() {

		return elementUtils.getTextFromElement(warningMessage, 30);

//		return warningMessage.getText(); Optimized from ElementUtils Class

	}

	public String getFirstnameWarning() {

		return elementUtils.getTextFromElement(FirstnameWarning, 30);

//		return FirstnameWarning.getText(); Optimized from ElementUtils Class
	}

	public String getlastNameWarning() {
		
		return elementUtils.getTextFromElement(LastNameWarning, 30);

//		return LastNameWarning.getText(); Optimized from ElementUtils Class
		
	}

	public String getEmailWarning() {
		
		return elementUtils.getTextFromElement(EmailWarning, 30);


//		return EmailWarning.getText(); Optimized from ElementUtils Class
		
	}

	public String getTelephoneWarning() {
		
		return elementUtils.getTextFromElement(TelephoneWarning, 30);

//		return TelephoneWarning.getText(); Optimized from ElementUtils Class
		
	}

	public String getpasswordWarning() {
		
		return elementUtils.getTextFromElement(PasswordWarning, 30);

//		return PasswordWarning.getText();  Optimized from ElementUtils Class
	}

}
