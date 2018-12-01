package com.inetbanking.testCases;

//TC Login page - Takes the data from the Configuration Properties file via Read Configuration Class and Base Class 

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass { 

	@Test    
	public void loginTest() throws IOException   
	{
		LoginPage lp = new LoginPage(driver); 
		lp.setUserName(username);
		logger.info("User name provided"); //logger msg
		lp.setPassword(password);
		logger.info("Password provided"); //logger msg
		lp.clickSubmit();
		logger.info("clicked on submit"); 
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);          //Pass the TC
			logger.info("login test passed"); //Create a log
		}
		else
		{
			captureScreen(driver,"loginTest");  //Capture the screenshot
			Assert.assertTrue(false);           //Fail the TC
			logger.info("login test failed");   //Create a log
		}

	}

}
