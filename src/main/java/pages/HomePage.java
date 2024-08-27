package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommanUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginElement;

	@FindBy(linkText = "Register")
	private WebElement myRegisterOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-default btn-lg')]")
	private WebElement searchButton;
	
	

	public void clickOnMyAccount() {
		
		elementUtils.clickOnElements(myAccountDropMenu, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		
		
	//	myAccountDropMenu.click(); optimized from utils package elementUtils 
		
	}

	public LoginPage clickOnLogin() {
		
		elementUtils.clickOnElements(loginElement, CommanUtils.EXPLICIT_WAIT_BASICTIME);
	
//		loginElement.click();   optimized from utils package elementUtils 
		
		return new LoginPage(driver);
		
	}

	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElements(myRegisterOption, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		
//		myRegisterOption.click();  optimized from utils package elementUtils
		
		return new RegisterPage(driver);
		
	}

	public void enterProductIntoSearchBox(String productText) {

		elementUtils.typeTextIntoElement(searchBoxField, productText, CommanUtils.EXPLICIT_WAIT_BASICTIME);
		
//		searchBoxField.sendKeys(productText);   optimized from utils package elementUtils

	}
	
	public SearchPageResult clickOnSearchButton() {
		
		elementUtils.clickOnElements(searchButton, CommanUtils.EXPLICIT_WAIT_BASICTIME);

//		searchButton.click();   	 optimized from utils package elementUtils	

		return new SearchPageResult(driver);
		
	}

}
