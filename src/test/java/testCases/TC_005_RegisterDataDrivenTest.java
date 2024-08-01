package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_RegisterDataDrivenTest extends BaseClass {

	@Test(dataProvider = "registerData", dataProviderClass = DataProviders.class)
	public void validateRegistrationWithDiffCredentials(String fName, String lName, String email, String telephoneNo, String pwd, String confPwd, String expe) {
		
		logger.info("***** TC_005_RegisterDataDrivenTest Started ***** ");
		
		try {

			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnRegister();

			logger.info("Clicked on Register link...");

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			arp.setFirstName(fName);
			arp.setLastName(lName);
			arp.setEmail(email);
			arp.setTelephone(telephoneNo);
			arp.setPassord(pwd);
			arp.setConfirmPassord(confPwd);

			arp.clickOnPolicyCheckBox();
			arp.clickOnContinue();
			
			logger.info("Clicked on Continue after providing the details...");

			MyAccountPage map = new MyAccountPage(driver); // To access logout btn

			String confRegisterMsg = arp.getConfirmationMsg();

			/*
			 * Data is valid - Register success - test pass - logout 
			  				 - Register failed - test fail
			 * Data is invalid - Register success - test fail - logout 
			 				   - Register failed - test pass
			 */

			if (expe.equalsIgnoreCase("Valid")) {
				if (confRegisterMsg.equals("Your Account Has Been Created!")) {
					map.clickOnMyAccountDrpDwn();
					map.clickOnlogOutBtn();

					logger.info("Clicked on Logout Button...");

					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (expe.equalsIgnoreCase("Invalid")) {
				if (confRegisterMsg.equals("Your Account Has Been Created!")) {
					map.clickOnMyAccountDrpDwn();
					map.clickOnlogOutBtn();

					logger.info("Clicked on Logout Button...");

					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			System.out.println("TC_005_RegisterDataDrivenTest due to: " + e.getMessage());
		}
		
		logger.info("***** TC_005_RegisterDataDrivenTest Finished ***** ");
	}
}
