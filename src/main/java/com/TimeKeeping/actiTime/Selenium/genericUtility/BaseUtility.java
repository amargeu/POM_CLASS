package com.TimeKeeping.actiTime.Selenium.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.TimeKeeping.actiTime.Selenium.pomRepository.HomePage;
import com.TimeKeeping.actiTime.Selenium.pomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility 
{
   public WebDriver driver;
   public JavaUtility jUtils = new JavaUtility();
   public ExcelUtility excelUtils = new ExcelUtility();
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("=====database connection is established=======");
	}
	@BeforeClass
	public void bcConfig() throws IOException
	{
		 String url = jUtils.fetchDataFromPropertyFile("url"); 
		 WebDriverManager.chromedriver().setup(); 
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get(url);
		 System.out.println("=====browser is launching=======");
		 System.out.println("====navigate to the url======");
	}
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String username = jUtils.fetchDataFromPropertyFile("username"); 
		String password = jUtils.fetchDataFromPropertyFile("password");
		LoginPage login=new LoginPage(driver); 
		login.loginAction(username, password);
		System.out.println("=====login to the application=====");
	}
	@AfterMethod
	public void amConfig()
	{
		HomePage home=new HomePage(driver);
		home.logoutAction();
		System.out.println("====logout from the application====");
	}
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("====close the browser=====");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("=====close the database=====");
	}


}
