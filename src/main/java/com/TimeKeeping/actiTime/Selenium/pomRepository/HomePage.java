package com.TimeKeeping.actiTime.Selenium.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
//constructor of homePage
	public HomePage(WebDriver driver) 
	{
	     PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	@FindBy(id="container_tasks")
	 private WebElement taskButton;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTaskButton() {
		return taskButton;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	//generic method to click on task module
	public void clickonTaskAction()
	{
		taskButton.click();
	}
	//generic method to click on logout button
	public void logoutAction()
	{
		logoutLink.click();
	}
	
	
	

}
