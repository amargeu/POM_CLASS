package com.TimeKeeping.actiTime.Selenium.TaskTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TimeKeeping.actiTime.Selenium.genericUtility.BaseUtility;
import com.TimeKeeping.actiTime.Selenium.genericUtility.ExcelUtility;
import com.TimeKeeping.actiTime.Selenium.genericUtility.JavaUtility;
import com.TimeKeeping.actiTime.Selenium.pomRepository.CreateNewCustomerPage;
import com.TimeKeeping.actiTime.Selenium.pomRepository.HomePage;
import com.TimeKeeping.actiTime.Selenium.pomRepository.LoginPage;
import com.TimeKeeping.actiTime.Selenium.pomRepository.TaskPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToAddNewCustomerTest2 extends BaseUtility
{
	@Test
	public void addCustomerInTaskTest() throws IOException 
	{
		/*
		 * Random random = new Random(); 
		 * int randomValue = random.nextInt(2000);
		 */
		//JavaUtility jUtils = new JavaUtility();
		int randomValue = jUtils.genereateRandomNo(1000);
         
		//read data from properties file
		 // String url = jUtils.fetchDataFromPropertyFile("url"); 
		//  String username = jUtils.fetchDataFromPropertyFile("username"); 
		 // String password = jUtils.fetchDataFromPropertyFile("password");
		 
         
		/*
		 * FileInputStream fis=new
		 * FileInputStream("./src/test/resources/PropertyData.properties"); Properties
		 * property=new Properties(); property.load(fis);
		 *  String url=property.getProperty("url"); 
		 * String username=property.getProperty("username");
		 * String password=property.getProperty("password");
		 */
        //read data from excel sheet
          //ExcelUtility excelUtils = new ExcelUtility();
		  String expectedCustomerName = excelUtils.fetchDataFromExcelSheet("Sheet4",1,0)+randomValue; 
		  String description = excelUtils.fetchDataFromExcelSheet("Sheet4",1,1);
		 
          
		/*
		 * FileInputStream fs=new
		 * FileInputStream("./src/test/resources/ExcelData.xlsx"); Workbook workbook =
		 * WorkbookFactory.create(fs); String expectedCustomerName =
		 * workbook.getSheet("sheet4").getRow(1).getCell(0).toString()+randomValue;
		 * String description =
		 * workbook.getSheet("sheet4").getRow(1).getCell(1).toString();
		 */
		//launching a chrome driver and navigate to the url
		
		 // WebDriverManager.chromedriver().setup(); WebDriver driver=new ChromeDriver();
		 // driver.manage().window().maximize();
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 // driver.get(url);
		 
		//login to the  application
		
		// LoginPage login=new LoginPage(driver); 
		// login.loginAction(username,password);
		 
		//clicking on task module
		HomePage home=new HomePage(driver);
		home.clickonTaskAction();
		//clicking on add customer button and then click on add new customer
		TaskPage task=new TaskPage(driver);
		task.clickOnNewCustomer();
		//create new customer with description and handle dropdown then clicking on create customer button
		CreateNewCustomerPage createCustomer=new CreateNewCustomerPage(driver);
		createCustomer.createCustomerAction(expectedCustomerName,description);
		

		String actualcustomerName=task.verifyCustomerName(expectedCustomerName);
		Assert.assertEquals(actualcustomerName,expectedCustomerName);
		System.out.println("the customer name has been verified");
		//home.logoutAction();
		//driver.quit();
		
	}

}
