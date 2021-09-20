package com.persistent.dataProvider_excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginExcel12 {
	@DataProvider (name= "testdataForLogin")	
	public Object [] [] readExcelLog() throws IOException{
		FileInputStream file= new FileInputStream("D:\\Eclipse\\miniProjectRenew\\miniProject22\\test\\com\\persistent\\resources\\ExternalDataSourceExcel.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum()+1;
		String inputData [] [] =new String [rows] [2];
		
		for(int i=0;i<rows;i++)
		{
			XSSFRow cur_row= sheet.getRow(i);
			inputData[i][0]=cur_row.getCell(0).toString();
			inputData[i][1]=cur_row.getCell(1).toString();
		}
		return inputData;
	}       


}
