package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Smoke", "Regression", "Master"})
	public void registrationTest() throws InterruptedException {

		logger.info("***** Starting TC_001_AccountRegistrationTest *****");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnRegister();

			logger.info("Clicked on Register...");

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);

			logger.info("Providing User Details...");
			arp.setFirstName(randomString().toUpperCase());
			arp.setLastName(randomString().toUpperCase());
			arp.setEmail(randomString() + "@gmail.com");
			arp.setTelephone(randomNumber());

			String password = randomAlphaNumeric();
			arp.setPassord(password);
			arp.setConfirmPassord(password);

			Thread.sleep(3000);

			arp.clickOnPolicyCheckBox();
			arp.clickOnContinue();

			logger.info("Clicked on Continue...");

			if (arp.getConfirmationMsg().equals("Your Account Has Been Created!")) {
				arp.clickOnbtnSuccessfulContinue();
			}
			
			MyAccountPage map = new MyAccountPage(driver);
			String headerText = map.getHeaderText();

			if (headerText.equals("My Account")) {
				logger.info("New Account Created...");
				Assert.assertTrue(true);
			} else {
				logger.error("Test case failed");
				logger.debug("Debug logs....");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println("TC_001_AccountRegistrationTest FAILED due to: "+e.getMessage());
			Assert.fail();
		}

		logger.info("***** Finished TC_001_AccountRegistrationTest *****");

	}
}
