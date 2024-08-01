package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseObjectPage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h2[text()='My Account']")
	WebElement myAccountHeaderText;	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccountDrpDwn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a")
	WebElement logOutBtn;
	
	public String getHeaderText() {
		try {
			return (myAccountHeaderText.getText());
		}catch(Exception e) {
			return ("Encountered following exception while Logging into the application: "+e.getMessage());
		}
	}
	
	public void clickOnMyAccountDrpDwn() {
		myAccountDrpDwn.click();
	}
	
	public void clickOnlogOutBtn() {
		logOutBtn.click();
	}
	
}
