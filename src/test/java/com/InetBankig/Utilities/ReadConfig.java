package com.InetBankig.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
	public String getURl()
	{
		String URL=pro.getProperty("URL");
		return URL;
	}
	
	public String getuserName()
	{
		String userName=pro.getProperty("suserName");
		return userName;
	}
	
	public String getpassword()
	{
		String password=pro.getProperty("spassword");
		return password;
	}
	
	public String gettitle()
	{
		String title=pro.getProperty("title");
		return title;
	}
}
