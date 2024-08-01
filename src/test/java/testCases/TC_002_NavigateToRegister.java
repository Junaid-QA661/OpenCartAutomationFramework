package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_NavigateToRegister extends BaseClass {

	@Test(priority = 1, groups= {"Sanity", "Master"})
	public void testNavigateToRegisterViaRegister() {

		logger.info("*** testNavigateToRegisterViaRegister STARTED ***");
		
		try {

			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnRegister();

			logger.info("Clicked on Register...");

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			String registerAccountText = arp.getRegisterAccountText();

			if (registerAccountText.equals("Register Account")) {
				logger.info("Test Case Register Via Register is PASSED...");
				Assert.assertTrue(true);
			} else {
				logger.error("Test Case Register Via Register is FAILED...");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(registerAccountText, "Register Account");

		} catch (Exception e) {
			System.out.println("Test case -testNavigateToRegisterViaRegister- is failed..." + e.getMessage());
			Assert.assertTrue(false);
		}

		logger.info("*** testNavigateToRegisterViaRegister FINISHED");

	}

	@Test(priority = 2, groups={"Sanity", "Master"})
	public void testNavigateToRegisterViaLogin_NewCustomer() throws InterruptedException {

		try {

			logger.info("*** testNavigateToRegisterViaLogin_NewCustomer STARTED ***");

			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnLogin();

			logger.info("Clicked on Login...");

			Thread.sleep(3000);

			LoginPage ncp = new LoginPage(driver);
			ncp.clickOnbtnNewCustomer();
			
			logger.info("Clicked on New Customer Button...");
			
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			String registerAccountText = arp.getRegisterAccountText();

			if (registerAccountText.equals("Register Account")) {
				logger.info("Test Case Register Via Login_NewCustomer is PASSED...");
				Assert.assertTrue(true);
				
			} else {
				logger.error("Test Case Register Via Login_NewCustomer is FAILED...");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}

			// Assert.assertEquals(registerAccountText, "Register Account");

		} catch (Exception e) {
			System.out.println("Test case -testNavigateToRegisterViaLogin_NewCustomer- is failed..." + e.getMessage());
			Assert.assertTrue(false);
		}
		
		logger.info("*** testNavigateToRegisterViaLogin_NewCustomer FINISHED ***");

	}

	@Test(priority = 3, groups={"Sanity", "Master"})
	public void testNavigateToRegisterViaLogin_Register() throws InterruptedException {

		try {

			logger.info("*** testNavigateToRegisterViaLogin_Register STARTED ***");

			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnLogin();
			
			logger.info("Clicked on Login...");

			Thread.sleep(3000);

			LoginPage ncp = new LoginPage(driver);
			ncp.clickOnlinkRegister();
			
			logger.info("Clicked on Register link...");

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			String registerAccountText = arp.getRegisterAccountText();
			
			if (registerAccountText.equals("Register Account")) {
				logger.info("Test Case Register Via Login_Register is PASSED...");
				Assert.assertTrue(true);
			} else {
				logger.error("Test Case Register Via Login_Register is FAILED...");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println("Test case -testNavigateToRegisterViaLogin_Register- is failed..." + e.getMessage());
			Assert.assertTrue(false);
		}
		
		logger.info("*** testNavigateToRegisterViaLogin_Register FINISHED ***");
	}
}
