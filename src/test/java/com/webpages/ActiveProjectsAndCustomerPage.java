package com.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestScript.BaseClass1;

public class ActiveProjectsAndCustomerPage 
{
	public static Logger log;
	@FindBy(xpath="//input[@value='Add New Customer']")
private WebElement addNewCustomerButton;
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement addNewProjectButton;
	@FindBy(className="successmsg")
private WebElement successMessage;
public ActiveProjectsAndCustomerPage()
{
	PageFactory.initElements(BaseClass1.driver, this);
	log=Logger.getLogger(OpenTaskPage.class);
	PropertyConfigurator.configure("Log4j.properties"); 
}
public void clickOnAddNewCustomerButton()
{
	addNewCustomerButton.click();
	log.info("------------- add new customer button is clicked----------");
}
public void clickOnAddnewProjectButton()
{
	addNewProjectButton.click();
	log.info("--------------- click on add new project button is clicked---------");
}
public String retrieveSuccessMessage()
{
	String s=successMessage.getText();
	log.info("---------------- success message is retrieved--------------");
	return s;
	
}
}
