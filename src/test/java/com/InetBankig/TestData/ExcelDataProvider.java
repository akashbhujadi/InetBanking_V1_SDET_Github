package com.InetBankig.TestData;

import org.testng.annotations.DataProvider;

import com.InetBankig.Utilities.DataProviderUtil;

public class ExcelDataProvider {
	
	@DataProvider
	public Object[][] TC_LogIn_002 () throws Exception
	{
		Object [][] data=DataProviderUtil.getExcelData("LoginData", "Sheet1");
		return data;			
	}


}
