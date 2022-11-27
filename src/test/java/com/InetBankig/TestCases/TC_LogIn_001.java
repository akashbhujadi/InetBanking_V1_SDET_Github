package com.InetBankig.TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBankig.POM.LoginPage;
import com.InetBankig.Utilities.IExtentReport;
import com.InetBankig.Utilities.ReadConfig;



public class TC_LogIn_001 extends BaseClass {
	
	
	
	@Test (groups = {"smoke"})
	public void TC_001() throws InterruptedException
	{
		
		
		log.info("Browser and  URL is launched Sucessfully");
		IExtentReport.etest.info("Browser and  URL is launched Sucessfully");
		LoginPage login=new LoginPage(driver);
		log.info("POM constructor launched Sucessfully");
		IExtentReport.etest.info("POM constructor launched Sucessfully");
		Thread.sleep(1000);
		login.enterUserName(suserName);
		log.info("UserName entered  Sucessfully");
		IExtentReport.etest.info("UserName entered  Sucessfully");
		login.enterPassword(spassword);
		log.info("Password entered  Sucessfully");
		IExtentReport.etest.info("Password entered  Sucessfully");
		login.logIn();
		log.info("login button clicked Sucessfully");
		IExtentReport.etest.info("login button clicked Sucessfully");
		Assert.assertEquals(title, driver.getTitle());
		log.info("************ This test is  Sucessfully Passed *************");
		IExtentReport.etest.pass("This test is passed sucessfully with the assertion ");

		Thread.sleep(500);
		
	}

}
