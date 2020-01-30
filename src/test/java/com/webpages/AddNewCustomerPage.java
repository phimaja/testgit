package com.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestScript.BaseClass1;

public class AddNewCustomerPage 
{
	@FindBy(name="name")
private WebElement enterCustomerNameTextField;
	@FindBy(name="createCustomerSubmit")
private WebElement createCustomerButton;
	public AddNewCustomerPage()
	{
		PageFactory.initElements(BaseClass1.driver, this);
	}
public void enterCustomerName(String customerName)
{
	enterCustomerNameTextField.sendKeys(customerName);
}
public void clickOncreateCustomerButton()
{
	createCustomerButton.click();
}
}
