package com.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.Utilities.ExcelOperation;
import com.webpages.ActiveProjectsAndCustomerPage;
import com.webpages.AddNewCustomerPage;
import com.webpages.OpenTaskPage;



public class createCustomer extends BaseClass1
{
	@Test
public void testcreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException
{
		String customer = ExcelOperation.readData("sheet1", 1, 0);
	OpenTaskPage otp= new OpenTaskPage();
	otp.clickOnProjectsAndCustomersLink();
	ActiveProjectsAndCustomerPage apac= new ActiveProjectsAndCustomerPage();
	apac.clickOnAddNewCustomerButton();
	AddNewCustomerPage ancp= new AddNewCustomerPage();
	ancp.enterCustomerName(customer);
	ancp.clickOncreateCustomerButton();
	String s1= apac.retrieveSuccessMessage();
	System.out.println(s1);
	
}
}
