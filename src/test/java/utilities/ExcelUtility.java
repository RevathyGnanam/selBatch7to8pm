package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public XSSFWorkbook workBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fout;
	public XSSFCellStyle style;
	String path;


	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String SheetName) throws Exception {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet =  workBook.getSheet(SheetName);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		fis.close();
		return rowCount;	
	}

	public int getCellCount(String SheetName,int rowCount) throws Exception {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet =  workBook.getSheet(SheetName);
		row = sheet.getRow(rowCount);
		int cellCount = row.getLastCellNum();
		workBook.close();
		fis.close();
		return cellCount;	
	}

	public String getCellData(String SheetName,int rowCount,int colNum) throws Exception {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet =  workBook.getSheet(SheetName);
		row = sheet.getRow(rowCount);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workBook.close();
		fis.close();
		return data;	
	}

	public void setData(String SheetName,int rowCount,int column,String data) throws Exception {
		File xlFile = new File(path);
		if(!xlFile.exists()) {
			workBook = new XSSFWorkbook();
			fout = new FileOutputStream(path);
			workBook.write(fout);

		}
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);

		if(workBook.getSheetIndex(SheetName)==-1)	
			workBook.createSheet(SheetName);
		sheet = workBook.getSheet(SheetName);

		if(sheet.getRow(rowCount)==null)
			sheet.createRow(rowCount);
		row = sheet.getRow(rowCount);

		cell = row.createCell(column);
		cell.setCellValue(data);
		fout = new FileOutputStream(path);
		workBook.write(fout);
		workBook.close();
		fis.close();
		fout.close();
	}

	public void fillGreenColor(String SheetName,int rowCount,int column) throws Exception {

		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet =  workBook.getSheet(SheetName);
		row = sheet.getRow(rowCount);
		cell = row.getCell(column);
		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workBook.write(fout);
		workBook.close();
		fis.close();
		fout.close();

	}
	
	public void fillredColor(String SheetName,int rowCount,int column) throws Exception {

		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet =  workBook.getSheet(SheetName);
		row = sheet.getRow(rowCount);
		cell = row.getCell(column);
		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workBook.write(fout);
		workBook.close();
		fis.close();
		fout.close();

	}


























}
