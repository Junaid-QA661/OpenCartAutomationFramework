package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseObjectPage {

	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccountLink;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
	WebElement loginLink;
	
	
	//Action Methods
	
	public void clickOnMyAccount() {
		myAccountLink.click();
	}

	public void clickOnRegister() {
		registerLink.click();
	}
	
	public void clickOnLogin() {
		loginLink.click();
	}
	
}
