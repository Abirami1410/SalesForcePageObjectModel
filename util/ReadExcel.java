package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String sheet) throws IOException {
		//set up the path for excel
		XSSFWorkbook wb=new XSSFWorkbook("./Data/CreateTaskPOM.xlsx");
		//Get into sheet
		XSSFSheet ws = wb.getSheet(sheet);//By name 
		//row count
		int rowCount = ws.getLastRowNum();
		//Column count
		short columnCount = ws.getRow(0).getLastCellNum();
		//To pass two dimentional array
	    String[][] data = new String[rowCount][columnCount];
	    //Get into row
	    for (int i = 1; i <=rowCount; i++) {
	    	
	    	XSSFRow row = ws.getRow(i);
	    	for (int j = 0; j <columnCount; j++) {
	    		XSSFCell cell = row.getCell(j);
	    		//Read the data from cell
	    	    data[i-1][j] = cell.getStringCellValue();
	    	    
	    		System.out.println(cell.getStringCellValue());
			}
			
		}
		//close the file
	    wb.close();
	    return data;

	}

}
