package com.inetbanking.testCases;

//TC Login page multiple users - Using Data Provider method

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass { 
	
	@Test(dataProvider="LoginData") //Takes the data from the Data Provider method
	public void loginDDT(String user, String pwd) throws InterruptedException 
	{		
		LoginPage lp=new LoginPage(driver); 
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
			
		if(isAlertPresent()==true)  //Could not log into the page
		{
			driver.switchTo().alert().accept(); //Close the alert message
			driver.switchTo().defaultContent(); //Switch to the application page
			Assert.assertTrue(false);
			Thread.sleep(3000); 
			logger.warn("Login failed"); //Warning log
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent(); //Switch to the application page
			Thread.sleep(3000);
			logger.info("login passed");  //Info log
		}
		
	 }
	
		//Check if there is or not an alert window 
		public boolean isAlertPresent()
		{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	//Data Provider method reads the data from the excel file (Username and Password)
	@DataProvider(name="LoginData")  //Data Provider name
	public String [][] getData() throws IOException //Two dimensional array data type
	{
		//Test data file path
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		//Excel Utilities methods
		int rownum=XLUtils.getRowCount(path, "Sheet1");     //Count number of rows in the file
		int colcount=XLUtils.getCellCount(path,"Sheet1",1); //Count number of columns in the file
		
		String logindata[][]=new String[rownum][colcount]; //Create a two dimensional array
		
		for(int i=1;i<=rownum;i++) //Read all the rows (in this excel file 0 row is the header)
		{
			for(int j=0;j<colcount;j++) //Read all the columns for each row
			{
				//Get each cell data from the file into the array 
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j); 
			}
		}		
		return logindata;		
	}	
}
