package com.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation 
{
	public static FileInputStream fis;
	public static Workbook w1;
	public static int rowCount(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{	
		fis= new FileInputStream("E:/eclipse new version/ActiTime/testdata/userdatamaven.xlsx");
		w1= WorkbookFactory.create(fis);
		return w1.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	public static int cellCount(String sheetName, int rowNumber) throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		fis= new FileInputStream("E:/eclipse new version/ActiTime/testdata/userdatamaven.xlsx");
		w1= WorkbookFactory.create(fis);
		return w1.getSheet(sheetName).getRow(rowNumber).getPhysicalNumberOfCells();
	}
	public static String readData(String sheetName, int rowNumber,int cellNumber) throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		fis= new FileInputStream("E:/eclipse new version/ActiTime/testdata/userdatamaven.xlsx");
		w1= WorkbookFactory.create(fis);
		Cell c= w1.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber);
		DataFormatter rv = new DataFormatter();
		return rv.formatCellValue(c);
	}
	public static void writeData(String sheetName, int rowNumber,int cellNumber,String data) throws IOException, EncryptedDocumentException, InvalidFormatException
	{	
		fis= new FileInputStream("E:/eclipse new version/ActiTime/testdata/userdatamaven.xlsx");
		w1= WorkbookFactory.create(fis);
		w1.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(data);
		FileOutputStream fos= new FileOutputStream(System.getProperty("user.dir")+"//testdata//userdata.xlsx");
		w1.write(fos);
		
	}
	
}
