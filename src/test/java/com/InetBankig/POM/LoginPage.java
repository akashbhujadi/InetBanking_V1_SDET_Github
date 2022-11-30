package com.InetBankig.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localDriver ;
	
	public LoginPage (WebDriver rempetDriver)
	{
		localDriver=rempetDriver;
		PageFactory.initElements(rempetDriver, this);
	}
	
	
	@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	WebElement userNameElement;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement PasswordElement;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	WebElement loginButtonElement;
	
	@FindBy(xpath="//input[@name='btnReset']")
	@CacheLookup
	WebElement resetButtonElement;
		
	
	public  void enterUserName(String luserName)
	{
		userNameElement.sendKeys(luserName);
	}
	
	public  void enterPassword(String password)
	{
		PasswordElement.sendKeys(password);
	}
	
	public  void logIn( )
	{
		loginButtonElement.click();
	}
	
	public void reset( )
	{
		resetButtonElement.click();
	}
}


