package com.TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass1

 {
	
	public static ChromeDriver driver;
	public static FileInputStream fis;
	
	
	@BeforeTest
	public void OpenBrowser() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		fis= new FileInputStream("E:/eclipse new version/ActiTime/Actitime.properties");
		Properties p1= new Properties();
		p1.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\drivers/chromedriver.exe");
		driver= new ChromeDriver();	
		driver.get(p1.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login() throws IOException
	
	{
		fis= new FileInputStream("E:/eclipse new version/ActiTime/Actitime.properties");
		Properties p1= new Properties();
		p1.load(fis);
		
		driver.findElement(By.name("username")).sendKeys(p1.getProperty("username"));
		
		driver.findElement(By.name("pwd")).sendKeys(p1.getProperty("password"));
		
		driver.findElement(By.xpath("//input[@valign='absmiddle']")).click();
	}
	@AfterMethod
	public void logOut()
	{
		
		
		driver.findElement(By.className("logoutImg")).click();
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		
	}
		
 }
	

