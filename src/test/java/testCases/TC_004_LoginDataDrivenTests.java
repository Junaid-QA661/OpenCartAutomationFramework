package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_LoginDataDrivenTests extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void validateLoginWithDiffCredentials(String email, String pwd, String expResult){
		logger.info("***** TC_004_LoginDataDrivenTests Started ***** ");
		
		try {
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnLogin();

			logger.info("Clicked on Login link...");

			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(email);
			lp.setPassword(pwd);
			lp.clickOnLogin();

			logger.info("Clicked on Login button...");

			//MyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			String myAccConfText = map.getHeaderText();
			
			/*
		 	Data is valid  	- login success - test pass  - logout
							- login failed - test fail

			Data is invalid - login success - test fail  - logout
							- login failed - test pass
			*/			
			
			//Valid Data
			if(expResult.equalsIgnoreCase("Valid")) {
				if(myAccConfText.equals("My Account")) {
					map.clickOnMyAccountDrpDwn();
					map.clickOnlogOutBtn();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			//Invalid Data
			if(expResult.equalsIgnoreCase("Invalid")) {
				if(myAccConfText.equals("My Account")) {
					map.clickOnMyAccountDrpDwn();
					map.clickOnlogOutBtn();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e) {
			logger.info("TC_003_ValidLogin is failed due to: "+e.getMessage());
			Assert.fail();
		}
		
		
		logger.info("***** TC_003_ValidLogin Finished ***** ");
	}
}


























