package com.TimeKeeping.actiTime.Selenium.TaskTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.TimeKeeping.actiTime.Selenium.genericUtility.BaseClass2;

public class ToAddNewCustomerTest extends BaseClass2
{
	@Test
	public void addCustomerInTaskTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		System.out.println("====add customer====");
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		
		System.out.println("===adding new customer====");
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
		
      FileInputStream fis=new FileInputStream("./src/test/resources/ExcelData.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet3");
      	Row row = sheet.getRow(1);
      	Cell cell=row.getCell(0);
		String Name = cell.getStringCellValue();
		String Discription = row.getCell(1).getStringCellValue();
		
		System.out.println(Name);
		driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys(Name);
		Thread.sleep(2000);
		System.out.println(Discription);
		driver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter Customer Description')]")).sendKeys(Discription);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='- Select Customer -']")).click();
		 Actions action=new Actions(driver);
		 Thread.sleep(2000);
		 action.moveToElement(driver.findElement(By.xpath("//div[@class='itemRow cpItemRow ']"))).click().perform();
		 
		 driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		 Thread.sleep(2000);
		 System.out.println("======new customer added=======");
		
	
	
		
		
      	
		
	}

}
