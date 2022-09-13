package com.TimeKeeping.actiTime.Selenium.basicTestCase;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ClassA 
{
	@Test
   public void demo1()
   {
		System.out.println("demo1");
		Reporter.log("message from demo1 to see", false);
   }
	@Test
	   public void demo2()
	   {
			System.out.println("demo2");
	   }
	@Test
	   public void demo3()
	   {
			System.out.println("demo3");
	   }
	@Test
	   public void demo4()
	   {
			System.out.println("demo4");
	   }
	
}
