package com.inetbanking.testCases;

// Base Class with the common resources required for all the TCs

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass { 

	ReadConfig readconfig = new ReadConfig(); // Create the object for ReadConfig class

	public String baseURL = readconfig.getApplicationURL(); // Read the value from ReadConfig class
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();  
	public static WebDriver driver;

	public static Logger logger; // Added logger

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties"); 

		//Launch browser
		if (br.equals("chrome")) {
			// Chrome Browser
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			// Firefox Browser
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			// Internet Explorer Browser
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		driver.manage().window().maximize(); 

		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Capture a screenshot on TC failures 
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	//Generates a random string
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(8);
		return (generatedString1);
	}

	//Generates a random number 
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
