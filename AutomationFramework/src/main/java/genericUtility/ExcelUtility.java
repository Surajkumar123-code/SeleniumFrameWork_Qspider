package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getStringDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/skillaryTestDAta.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
	}
	   
	public boolean getBooleanDatafromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/skillaryTestDAta.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
		
	}
	public double getNumericDatafromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/skillaryTestDAta.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return (int) workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}
	 
	public LocalDateTime localDatafromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/skillaryTestDAta.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return (LocalDateTime) workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
		
		
	}
}


