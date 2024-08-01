package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseObjectPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnNewCustomer;
	
//	@FindBy(xpath="//div[@id='content']/h1")
//	WebElement registerAccountText;
	
	@FindBy(xpath="//aside[@id='column-right']/div/a[2]")
	WebElement linkRegister;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void clickOnbtnNewCustomer() {
		btnNewCustomer.click();
	}
	
	public void clickOnlinkRegister() {
		linkRegister.click();
	}
	
	public void setEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		btnLogin.click();
	}
	
//	public String getregisterAccountText() {
//		try {
//			return (registerAccountText.getText());
//		}catch(Exception e) {
//			return (e.getMessage());
//		}
//	}

}
