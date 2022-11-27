package com.InetBankig.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver localDriver ;
	
	public HomePage (WebDriver rempetDriver)
	{
		localDriver=rempetDriver;
		PageFactory.initElements(rempetDriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement newCustomerElement;
	
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement customerNameElement;
	
	@FindBy(xpath="//input[@value='m']")
	@CacheLookup
	WebElement maleGenderElement;
	
	@FindBy(xpath="//input[@value='f']")
	@CacheLookup
	WebElement femaleGenderElement;
	
	@FindBy(xpath="//input[@id='dob']")
	@CacheLookup
	WebElement dobElement;
	
	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement addressElement;
	
	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement cityElement;
	
	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement stateElement;
	
	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement pinElement;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement mobileElement;
	
	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement emailElement;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@name='sub']")
	@CacheLookup
	WebElement submitElement;
	
	
	public  void newCustomer()
	{
		newCustomerElement.click();
	}
	
	public  void enterCustomerName(String customerName)
	{
		customerNameElement.sendKeys(customerName);
	}
	
	public  void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			maleGenderElement.click();
		}
		else
		{
			femaleGenderElement.click();
		}
	}
	
	public  void enterDOB(String day,String month,String year)
	{
		dobElement.sendKeys(day);
		dobElement.sendKeys(month);
		dobElement.sendKeys(year);
	}
	
	public  void enterAddress(String address)
	{
		addressElement.sendKeys(address);
	}
	
	public  void enterCity(String city)
	{
		cityElement.sendKeys(city);
	}
	
	public  void enterState(String state)
	{
		stateElement.sendKeys(state);
	}
	
	public  void enterPIN(String pin)
	{
		pinElement.sendKeys(pin);
	}
	
	public  void enterMobileNo(String mobile)
	{
		mobileElement.sendKeys(mobile);
	}
	
	public  void enterEmail(String email)
	{
		emailElement.sendKeys(email);
	}
	
	public  void enterPassword(String password)
	{
		passwordElement.sendKeys(password);
	}
	
	public  void clickSubmit( )
	{
		submitElement.click();
	}
	

}
