package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Multiple_data_withconditio {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String expcondition="tc_02";
		String data;
		String data1="";
		String data2="";
		String data3="";
		Sheet sh = wb.getSheet("org");
		int rowcount=sh.getLastRowNum();
		for(int i=0; i<=rowcount; i++) {
			data="";
			
			try {
				data=sh.getRow(i).getCell(0).toString();
				if(data.equals(expcondition)) {

					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
					data3=sh.getRow(i).getCell(3).toString();
				}

			}catch (Exception e) {}
		}
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
	}
}






