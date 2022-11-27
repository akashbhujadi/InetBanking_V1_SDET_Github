package com.InetBankig.Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.InetBankig.TestCases.BaseClass;
import com.InetBankig.TestCases.TC_LogIn_001;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class IExtentReport extends BaseClass  implements ITestListener{
	
	public static ExtentSparkReporter extenetSparkReporter_All;
	public static ExtentReports extentReport;
	public static ExtentTest etest;
	public static String ssFolder ;
	public static String img ;
	

	@Override
	public void onStart(ITestContext context) {
			
		extenetSparkReporter_All =new ExtentSparkReporter("All_Test_Report.html");
		try {
			extenetSparkReporter_All.loadXMLConfig(new File("./Configuration/Extent-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReport = new ExtentReports();
		extentReport.attachReporter(extenetSparkReporter_All);
		
		
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
		


		
		
	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();
		try {
			Desktop.getDesktop().browse(new File ("All_Test_Report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestStart(ITestResult result ) {
		
		etest=extentReport.createTest(result.getTestClass().getName());
		etest.assignAuthor("Akash");
		etest.assignDevice("Windows");
		etest.assignCategory("smoke");
		etest.assignCategory("sanity");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		etest.pass("This test is passed sucessfully ");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		

		 LocalDateTime myDateObj = LocalDateTime.now();
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		 String ssFolder=myDateObj.format(myFormatObj);
		 String imgName=result.getTestClass().getName();
		 //File file=new File("C:\\Users\\sai\\eclipse-workspace\\Inetbanking_V1_SDET\\Screenshots\\"+imgName+"="+ssFolder);
			//file.mkdir();
			
		String path="C:\\Users\\sai\\eclipse-workspace\\Inetbanking_V1_SDET\\Screenshots\\"+imgName+"\\"+imgName+"="+ssFolder+".png"; 
		
		
		File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);			//taking the screenshot
		File trg=new File(path);
		try {
			FileUtils.copyFile(file,trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		etest.addScreenCaptureFromPath(path);
		
		etest.fail(result.getThrowable());
		

		
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		etest.skip("This test is skiped");
	}
	
	
	

}
