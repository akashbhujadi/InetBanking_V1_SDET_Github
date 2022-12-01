package com.InetBankig.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBankig.POM.HomePage;
import com.InetBankig.POM.LoginPage;
import com.InetBankig.Utilities.IExtentReport;

public class TC_LogIn_003 extends BaseClass {

	@Test(groups = { "regression" })
	public void TC_003() throws InterruptedException, FindFailed {
		LoginPage lp = new LoginPage(driver);

		log.info("Browser and  URL is launched Sucessfully");
		IExtentReport.etest.info("Browser and  URL is launched Sucessfully");
		Thread.sleep(1000);

		lp.enterUserName(suserName);
		log.info("UserName entered  Sucessfully");
		IExtentReport.etest.info("UserName entered  Sucessfully");

		lp.enterPassword(spassword);
		log.info("Password entered  Sucessfully");
		IExtentReport.etest.info("Password entered  Sucessfully");

		lp.logIn();
		log.info("login button clicked Sucessfully");
		IExtentReport.etest.info("login button clicked Sucessfully");
		Thread.sleep(1000);

		Assert.assertEquals(title, driver.getTitle());
		log.info("************ Login Successful *************");
		IExtentReport.etest.pass("Login Successful With HardAssertion ");

		HomePage hp = new HomePage(driver);

		hp.newCustomer();
		log.info("New Customer link clicked");
		IExtentReport.etest.info("New Customer link clicked");

		
		adblocker();
		

		hp.enterCustomerName("Akash Bhujadi");
		log.info("Customer name entered successfully");
		IExtentReport.etest.info("Customer name entered successfully");

		hp.selectGender("male");
		log.info("Gender selected successfully");
		IExtentReport.etest.info("Gender selected successfully");

		hp.enterDOB("30", "03", "1995");
		log.info("DOB entered successfully");
		IExtentReport.etest.info("DOB entered successfully");

		hp.enterAddress("GAw Mahirt Ngu JLN");
		log.info("Address entered successfully");
		IExtentReport.etest.info("Address entered successfully");

		hp.enterCity("city");
		log.info("city entered successfully");
		IExtentReport.etest.info("City entered successfully");

		hp.enterState("State");
		log.info("State entered successfully");
		IExtentReport.etest.info("State entered successfully");

		hp.enterPIN("457812");
		log.info("pin entered successfully");
		IExtentReport.etest.info("pin entered successfully");

		hp.enterMobileNo(GenerateMobileno());
		log.info("MobileNo entered successfully");
		IExtentReport.etest.info("MobileNo entered successfully");

		hp.enterEmail(generateEmail());
		log.info("Email entered successfully");
		IExtentReport.etest.info("Email entered successfully");

		hp.enterPassword(GeneratePassword());
		log.info("Password entered successfully");
		IExtentReport.etest.info("Password entered successfully");
		Thread.sleep(2000);

		hp.clickSubmit();
		log.info("Submitted successfully");
		IExtentReport.etest.info("Submitted  successfully");

		Assert.assertTrue(driver.getPageSource().contains("Customer Registered Successfully!!!"));
		log.info("Test is  successfully executed");
		IExtentReport.etest.info("Test is  successfully executed with assertion");

		Thread.sleep(500);

	}

	public static String GenerateMobileno() {
		String Mobileno = RandomStringUtils.randomNumeric(10);
		return Mobileno;

	}

	public static String generateEmail() {
		RandomStringUtils rm = new RandomStringUtils();
		String email = rm.randomAlphabetic(5) + "@gmail.com";
		return email;
	}

	public static String GeneratePassword() {
		String password = RandomStringUtils.randomAlphanumeric(8);
		return password;
	}

}
