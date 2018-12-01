package com.inetbanking.utilities;

//Utilities - Read Configuration Class - Read the values from the Configuration Properties file 

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro; //Java class 
	
	public ReadConfig() //Constructor 
	{
		File src = new File("./Configuration/config.properties"); //Point to configuration properties file

		try {
			FileInputStream fis = new FileInputStream(src); //Open the file in the read mode
			pro = new Properties();
			pro.load(fis); 			 //Load the configuration file
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());  
		}
	}
	
	//Read the values from the configuration properties file 
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL"); //Capture the value from the variable in the file
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
}
