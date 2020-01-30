package com.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TestScript.BaseClass1;

public class AddNewProjectPage 
{
	public static Logger log;
	@FindBy(name="customerId")
	private WebElement customerDropdown;
	@FindBy(name="name")
	private WebElement enterProjectNameTextField;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectButton;
	public AddNewProjectPage()
	{
		PageFactory.initElements(BaseClass1.driver, this);
		log=Logger.getLogger(OpenTaskPage.class);
		PropertyConfigurator.configure("Log4j.properties"); 
	}
	public void selectCustomerFromDropdown(String customerName)
	{
		Select s1 = new Select(customerDropdown);
		s1.selectByVisibleText(customerName);
		log.info("---------------dropdown is selected------------");
	}
	public void enterProjectName(String projectName)
	{
		enterProjectNameTextField.sendKeys(projectName);
		log.info("---------------project name is entered---------");
	}
	public void clickOnCreateProjectButton()
	{
		createProjectButton.click();
		log.info("----------------createproject button is clicked-----------");
	}

}
