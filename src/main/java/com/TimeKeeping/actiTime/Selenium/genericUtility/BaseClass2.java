package com.TimeKeeping.actiTime.Selenium.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 
{
public static WebDriver driver;
@BeforeSuite
public void bsConfig()
{
	System.out.println("=====database connection is established=======");
}
@BeforeClass
public void bcConfig() throws IOException
{
	System.out.println("=====browser is launching=======");
	WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver ();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	System.out.println("====navigate to the url======");
	FileInputStream fis=new FileInputStream("./src/test/resources/PropertyData.properties");
	Properties property=new Properties();
	property.load(fis);
	String url=property.getProperty("url");
	driver.get(url);	
}
@BeforeMethod
public void login() throws IOException, InterruptedException
{
	System.out.println("=====login to the application=====");
	
	FileInputStream fis=new FileInputStream("./src/test/resources/PropertyData.properties");
	Properties property=new Properties();
	property.load(fis);
	
	String uname=property.getProperty("username");
	Thread.sleep(2000);
	System.out.println(uname);
	Thread.sleep(5000);
	driver.findElement(By.id("username")).sendKeys(uname);
	String password=property.getProperty("password");
	System.out.println(password);
	Thread.sleep(3000);
	driver.findElement(By.name("pwd")).sendKeys(password);
    driver.findElement(By.xpath("//div[text()='Login ']")).click();
	
}

  @AfterMethod 
  public void amConfig() 
  {
  System.out.println("====logout from the application====");
  driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }
  
  @AfterClass 
  public void acConfig() 
  {
  System.out.println("====close the browser=====");
  driver.close();
  }
  
  @AfterSuite
  public void asConfig()
  {
  System.out.println("=====close the database=====");
  driver.quit();
  }
  
 

}
