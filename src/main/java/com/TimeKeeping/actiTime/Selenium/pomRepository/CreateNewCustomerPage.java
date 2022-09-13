package com.TimeKeeping.actiTime.Selenium.pomRepository;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage 
{
	WebDriver driver;
	 

	public CreateNewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement nameTextField;
	
	@FindBy(xpath="//textarea[contains(@placeholder,'Enter Customer Description')]")
	private WebElement enterDiscription;
	
	@FindBy(xpath="//div[text()='- Select Customer -']")
	private WebElement selectCustomerDropDown;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getEnterDiscription() {
		return enterDiscription;
	}

	public WebElement getSelectCustomerDropDown() {
		return selectCustomerDropDown;
	}
	
	@FindBy(xpath = "//div[@class='itemRow cpItemRow ']")
	private WebElement selectDropDown;
	
	public WebElement getSelectDropDown() {
		return selectDropDown;
	}
	@FindBy(xpath = "//div[text()='Create Customer']")
    private WebElement createCustomerButton;
	//GENERIC METHOD TO PERFORM CREATE NEW CUSTOMER
	public void createCustomerAction(String customerName,String customerDiscription)
	{
		nameTextField.sendKeys(customerName);
		enterDiscription.sendKeys(customerDiscription);
	    selectCustomerDropDown.click();
		
       Actions action=new Actions(driver);
       action.moveToElement(selectDropDown).perform();
		
       createCustomerButton.click();
	}
	
	
	

}
