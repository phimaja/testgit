package com.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.Utilities.ExcelOperation;
import com.webpages.ActiveProjectsAndCustomerPage;
import com.webpages.AddNewProjectPage;
import com.webpages.OpenTaskPage;


public class createProject extends BaseClass1
{
@Test
public void testCreateProject() throws EncryptedDocumentException, InvalidFormatException, IOException
{ 	String customer=ExcelOperation.readData("sheet1", 1, 0);
	String projectname= ExcelOperation.readData("sheet1", 1, 1);
	OpenTaskPage otp= new OpenTaskPage();
	otp.clickOnProjectsAndCustomersLink();
	ActiveProjectsAndCustomerPage apcp= new ActiveProjectsAndCustomerPage();
	apcp.clickOnAddnewProjectButton();
	AddNewProjectPage anpp= new  AddNewProjectPage();
	anpp.selectCustomerFromDropdown(customer);
	anpp.enterProjectName(projectname);
	anpp.clickOnCreateProjectButton();
	String s2=apcp.retrieveSuccessMessage();
	System.out.println(s2);
	
}
}