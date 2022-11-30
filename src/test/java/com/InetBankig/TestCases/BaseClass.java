package com.InetBankig.TestCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.InetBankig.Utilities.IExtentReport;
import com.InetBankig.Utilities.ReadConfig;
import com.aventstack.extentreports.model.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	
	
	public static WebDriver driver;
	String URL=readConfig.getURl();
	String suserName=readConfig.getuserName();
	String spassword=readConfig.getpassword();
	String title=readConfig.gettitle();
	public static Logger log;
	
	
	
	@Parameters("browser")
	 @BeforeClass
	  public void launchBrowser(@Optional("chrome")String browser) throws InterruptedException
	 {
		 switch(browser.toLowerCase())
		 {
		 case "chrome" :
			 	WebDriverManager.chromedriver().setup();
			 	driver=new ChromeDriver();
			 	break;
			 			
		 case "firefox" :
	 			WebDriverManager.firefoxdriver().setup();
	 			driver=new FirefoxDriver();
	 			break;
	 			
		 case "edge" :
	 			WebDriverManager.edgedriver().setup();
	 			driver=new EdgeDriver();
	 			break;	
	 	default:
	 		System.out.println("Enter z Browser name from chrome , edge , firefox only");	 		
		 }	
		 
		driver.get(URL);
	 	driver.manage().window().maximize();
		Thread.sleep(1000);
		
		 log=Logger.getLogger("Banking");
		//PropertyConfigurator.configure("log4j.properties");
		DOMConfigurator.configure("log4j.xml");
	 }
	
	
	@AfterClass
	  public void tearDown() 
	  {
		  driver.close();
		 
	  }
		
	
	
	
}
