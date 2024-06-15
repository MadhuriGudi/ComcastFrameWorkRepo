package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Multiple_data_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("phone");
		int rowcount = sh.getLastRowNum();
		for(int i=1; i<=rowcount; i++) {
			Row row = sh.getRow(i);
			 String coloumndata = row.getCell(0).toString();
			 String coloumndata1 = row.getCell(1).toString();
			 System.out.println(coloumndata+"   \t   "+coloumndata1);
		}
			wb.close();

	}

}
