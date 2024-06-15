package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Phone_Number_createorg {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/commondata.Properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		Random random=new Random();
		System.out.println(URL);
		int randomInt=random.nextInt(1000);
		FileInputStream fis1=new FileInputStream(".\\testdata\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(7);
		String orgname = row.getCell(2).toString() + randomInt;
		
		String phno=row.getCell(3).toString();
		WebDriver driver=null;
		if (BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
				}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
        driver.findElement(By.id("phone")).sendKeys(phno);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       String actlphno = driver.findElement(By.id("dtlview_Phone")).getText();
       if(actlphno.equals(phno)) {
    	   System.out.println(actlphno+ "  phone number is enterd and varified==pass");
       }
       else {
    	   System.out.println(actlphno+ "  phonenumber not correct==fail");
       }
       driver.close();
	}

}
