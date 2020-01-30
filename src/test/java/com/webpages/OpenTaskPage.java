package com.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestScript.BaseClass1;

public class OpenTaskPage 
{
	public static Logger log;
	@FindBy(linkText="Projects & Customers")
private WebElement projectsAndCustomersLink;
	//@FindBy(className="menu_link_act")
	@FindBy(linkText="Settings")
	private WebElement settingsLink;
	
public OpenTaskPage()
{
	
	PageFactory.initElements(BaseClass1.driver, this);
	log=Logger.getLogger(OpenTaskPage.class);
	PropertyConfigurator.configure("Log4j.properties"); 
}
public void clickOnProjectsAndCustomersLink()
{
	projectsAndCustomersLink.click();
	log.info("-------------projects and customers link is clicked----------");
}
public void clickOnSettingLink()
{
	settingsLink.click();
	log.info("--------------setting link is clicked-----------");
}
}
