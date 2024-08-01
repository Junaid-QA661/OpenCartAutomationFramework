package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BaseObjectPage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement registerAccountText;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//div[@class='pull-right']/input[1]")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement confirmationMsg;
	
	@FindBy(xpath="//div[@class='pull-right']/a")
	WebElement btnSuccessfulContinue;
	
//	@FindBy(xpath="//ul[@class='breadcrumb']/li[2]/a")
//	WebElement txtMyAccountTab;
	
	public String getRegisterAccountText() {
		try {
			return (registerAccountText.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephoneNo) {
		txtTelephone.sendKeys(telephoneNo);
	}
	
	public void setPassord(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassord(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickOnPolicyCheckBox() {
		chkPolicy.click();;
	}
	
	public void clickOnContinue() {
		btnContinue.click();;
	}
	
	public String getConfirmationMsg() {
		try {
			return (confirmationMsg.getText());
		}catch(Exception e){
			return (e.getMessage());
		}
	}
		
	public void clickOnbtnSuccessfulContinue() {
		btnSuccessfulContinue.click();
	}
	
//	public String getTabName() {
//		try {
//			return (txtMyAccountTab.getText());
//		}
//		catch(Exception e) {
//			return (e.getMessage());
//		}
//	}

}

















