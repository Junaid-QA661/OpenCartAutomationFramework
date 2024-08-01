package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseObjectPage {
	
	WebDriver driver;
	
	public BaseObjectPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
