package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rownum,int celnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).getStringCellValue();
		
		wb.close();
		return data;
		
	}
	public int getRowcount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata.Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getFirstRowNum();
		wb.close();
		return rowcount;
		
	}
	public void setDataintoExcel(String sheetname,int rownum,int celnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata.Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(celnum);
		FileOutputStream fos=new FileOutputStream("./testdata.Book1.xlsx");
		wb.write(fos);
		wb.close();
	}

}
