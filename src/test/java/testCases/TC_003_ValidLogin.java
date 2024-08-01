package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_ValidLogin extends BaseClass {

	@Test(groups= {"Smoke", "Sanity", "Master", "Regression"})
	public void testValidLogin() throws IOException {

		logger.info("***** TC_003_ValidLogin Started ***** ");

		try {

			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnLogin();

			logger.info("Clicked on Login link...");

			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(property.getProperty("EmailAddress"));
			lp.setPassword(property.getProperty("Password"));
			lp.clickOnLogin();

			logger.info("Clicked on Login button...");

			//MyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			String headerText = map.getHeaderText();

			if (headerText.equals("My Account")) {
				logger.info("Successfully logged in...");
				Assert.assertTrue(true);
			} else {
				logger.info("Unable to login...");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println("TC_003_ValidLogin FAILED due to ========> " + e.getMessage());
			Assert.fail();
		}
		
		
		logger.info("***** TC_003_ValidLogin Finished ***** ");

	}

}
