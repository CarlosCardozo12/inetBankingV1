package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//Page Object Class to Login Edit Customer

public class EditCustomerPage {
		
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver) {  
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	//Elements present in the Edit Customer page
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@FindBy(how = How.XPATH, using ="//input[@name='accountno']")
	@CacheLookup
	WebElement txtCustomerId;	
	
	@FindBy(how = How.XPATH, using ="//input[@value='Submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	//Actions Methods
	public void clickEditCustomer() {
		lnkEditCustomer.click();
			
	}

	public void custId(String cid) {
		txtCustomerId.sendKeys(cid);
		
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	
}
