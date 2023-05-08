package Selenium_Projects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {

	public static void writeExcelSheet() throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet 1");
		
		int rowNum = 0;
		for(int i=0;i<=10;i++) {
			
			Row row = sheet.createRow(rowNum++);
			
			int cellNum = 0;
			for(int j=0;j<=10;j++) {
				
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue("Row "+i+"Column "+j);
			}
		}
		
		String path = System.getProperty("user.dir")+"/src/test/resources/Excel/Demo.xlsx";
		File  ExcelFile = new File(path);
		FileOutputStream Fos = null;
		try {
			 Fos = new FileOutputStream(ExcelFile);
			 workbook.write(Fos);
			 workbook.close();
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		finally {
			
			Fos.close();
		}
	}
	public static void readExcelSheet() throws IOException {
		
		String path = System.getProperty("user.dir")+"/src/test/resources/Excel/Demo.xlsx";
		File Excelfile = new File(path);
		
			FileInputStream Fis = new FileInputStream(Excelfile);
			XSSFWorkbook workbook = new XSSFWorkbook(Fis);
			XSSFSheet sheet = workbook.getSheet("Sheet 1");
			
			Iterator<Row>  row = sheet.rowIterator();
			while(row.hasNext()) {
				
				Row currRow = row.next();
				
				Iterator<Cell> cell = currRow.cellIterator();
				while(cell.hasNext()) {
					
					Cell currCell = cell.next();
					System.out.println(currCell.getStringCellValue());
				}
				System.out.println();
			}
			
			Row newrow = sheet.createRow(12);
			Cell newcell = newrow.createCell(12);
			newcell.setCellValue("Lakshmi");
			FileOutputStream Fos = new FileOutputStream(Excelfile);
			workbook.write(Fos);
			workbook.close();
		
	}
	public static void main(String[] args) throws IOException {
		
		//writeExcelSheet();
		readExcelSheet();
		
	}
}
