package com.inetbanking.testCases;

// TC Add New Customer

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
		
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided"); 
		lp.setPassword(password); 
		logger.info("password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver); //Create the page object class object Add Customer
		addcust.clickAddNewCustomer(); // click on add new customer link
		logger.info("providing customer details....");
		addcust.custName("Joe Ham");
		addcust.custgender("male");
		addcust.custaddress("Rue Del Mar");
		addcust.custdob("15","10","1996");
		Thread.sleep(3000);
		addcust.custaddress("Canada");
		addcust.custcity("Toronto");
		addcust.custstate("ON");
		addcust.custpinno("505678");
		addcust.custtelephoneno("774319965"); 
		
		String email = randomestring() + "@gmail.com"; //Generates a new email address 
		addcust.custemailid(email);
		addcust.custpassword("abcdifj");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{ 
			Assert.assertTrue(true);
			logger.info("test case passed....");
			captureScreen(driver,"addNewCustomer"); //Capture the new customer ID
		}
		else
		{
			logger.warn("test case failed....");
			captureScreen(driver,"addNewCustomer"); //Pass the driver and TC name
			Assert.assertTrue(false);
		}			
	}		
}
