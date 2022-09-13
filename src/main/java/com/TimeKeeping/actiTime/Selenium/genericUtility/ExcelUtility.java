package com.TimeKeeping.actiTime.Selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
public String fetchDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fisExcel=new FileInputStream("./src/test/resources/ExcelData.xlsx");	
	Workbook workbook = WorkbookFactory.create(fisExcel);
    Sheet sheet = workbook.getSheet(sheetName);
    return sheet.getRow(rowNo).getCell(cellNo).toString();
    
}
	

}
