package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class RegisterExcel {
	@DataProvider (name= "testdataForRegister")	
	public Object [] [] readExcelReg() throws IOException{
		FileInputStream file= new FileInputStream("D:\\Eclipse\\socialSiteTestingUsingDDT\\src\\main\\resources\\ExternalDataSourceExcel.xlsx");

		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet2");
		
		int rows=sheet.getLastRowNum()+1;
		int columns=sheet.getRow(0).getLastCellNum();
		
		System.out.println(rows+"   "+columns);
		
		String inputData [] [] =new String [rows] [5];
		for(int i=0;i<rows;i++)
		{
			XSSFRow cur_row= sheet.getRow(i);
			
			for(int j=0;j<columns;j++) {
			inputData[i][j]=cur_row.getCell(j).toString();
			}
		}
		return inputData;		
	}


}
