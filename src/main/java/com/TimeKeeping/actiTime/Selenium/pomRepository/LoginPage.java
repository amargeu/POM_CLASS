package com.TimeKeeping.actiTime.Selenium.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	WebDriver driver;
	//constructor of 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(id="username")
	private WebElement usernameTextfield;
	
	@FindBy(name="pwd")
	private WebElement passwordTextfield;
	
	@FindBy(xpath="//div[text()='Login ']")
	 private WebElement loginbutton;

	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	//bussiness logic/generic method for login
	public void loginAction(String username,String password)
	{
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginbutton.click();
		
	}


}
