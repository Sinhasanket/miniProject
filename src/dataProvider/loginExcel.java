package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class loginExcel
{
	@DataProvider (name= "testdataForLogin")	
	public Object [] [] readExcel() throws IOException{
		FileInputStream file= new FileInputStream("D:\\Eclipse\\miniProjectDDT\\src\\main\\resources\\ExternalDataSourceExcel.xlsx");
		
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
