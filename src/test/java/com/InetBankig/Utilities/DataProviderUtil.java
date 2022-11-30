package com.InetBankig.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderUtil {
	
	public static Object[][] getExcelData(String workbookName , String sheetName) throws Exception
	{
		File excelFile =new File("C:\\Users\\sai\\eclipse-workspace\\Inetbanking_V1_SDET\\src\\test\\java\\com\\InetBankig\\TestData\\"+workbookName+".xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int noofRows=sheet.getPhysicalNumberOfRows();
		int noofCols=sheet.getRow(0).getLastCellNum();
		
		Object [][] data =new Object[noofRows-1][noofCols]; 
		for (int i = 0; i < noofRows-1; i++) {
			for (int j = 0; j < noofCols; j++) {
				
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));							
			}
		}
		workbook.close();
		fis.close();
		
		return data;
	}

}
