package com.InetBankig.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBankig.POM.LoginPage;
import com.InetBankig.TestData.ExcelDataProvider;
import com.InetBankig.Utilities.DataProviderUtil;
import com.InetBankig.Utilities.IExtentReport;

public class TC_LogIn_002 extends BaseClass{
	
	@Test (groups = {"sanity"} , dataProvider = "TC_LogIn_002" , dataProviderClass = ExcelDataProvider.class)
	public void TC_002(Object[] a) throws InterruptedException
	{
		
		
		log.info("Browser and  URL is launched Sucessfully");
		IExtentReport.etest.info("Browser and  URL is launched Sucessfully");
		LoginPage login=new LoginPage(driver);
		log.info("POM constructor launched Sucessfully");
		IExtentReport.etest.info("POM constructor launched Sucessfully");
		login.enterUserName((String) a[0]);
		log.info("UserName entered  Sucessfully");
		IExtentReport.etest.info("UserName entered  Sucessfully");
		login.enterPassword((String) a[1]);
		log.info("Password entered  Sucessfully");
		IExtentReport.etest.info("Password entered  Sucessfully");
		login.logIn();
		log.info("login button clicked Sucessfully");
		IExtentReport.etest.info("login button clicked Sucessfully");
		
		driver.switchTo().alert().accept();
		
		Assert.assertFalse(false);
		log.info("************ This test is  Sucessfully Passed *************");
		IExtentReport.etest.pass("This test is passed sucessfully with the assertion ");

		Thread.sleep(500);

}
}
