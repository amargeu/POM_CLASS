package com.TimeKeeping.actiTime.Selenium.basicTestCase;

import org.testng.annotations.Test;

public class ToPerformGroupExecution 
{
	@Test(groups = "smoketest")
	public void login()
	{
		System.out.println("login to the flipkart");
	}
	@Test(groups = "regressiontest")
	public void select()
	{
		System.out.println("product selected");
	}
	@Test(groups = "regressiontest")
	public void addToKart()
	{
		System.out.println("added to kart");
	}
	@Test(groups = "regressiontest")
	public void payment()
	{
		System.out.println("do payment for product");
	}
	@Test(groups = "smoketest")
	public void logout()
	{
		System.out.println("logout suceess");
	}
	
	
}
