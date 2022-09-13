package com.TimeKeeping.actiTime.Selenium.genericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
@BeforeSuite
public void bsConfig()
{
	System.out.println("=====database connection is established=======");
}
@BeforeClass
public void bcConfig()
{
	System.out.println("=====browser is launching=======");
	System.out.println("====navigate to the url======");
}
@BeforeMethod
public void bmConfig()
{
	System.out.println("=====login to the application=====");
}
@AfterMethod
public void amConfig()
{
	System.out.println("====logout from the application====");
}
@AfterClass
public void acConfig()
{
	System.out.println("====close the browser=====");
}
@AfterSuite
public void asConfig()
{
	System.out.println("=====close the database=====");
}



}
