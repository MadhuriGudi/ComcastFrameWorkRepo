package practice_contact_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/commondata.Properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		FileInputStream fis1=new FileInputStream("./testdata/Book1.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String lastname = row.getCell(2).toString() + randomInt;
		
		WebDriver driver=null;
		if (BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else 
			driver=new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
        String actllastname = driver.findElement(By.id("dtlview_Last Name")).getText();
        if(actllastname.equals(lastname)) {
        	System.out.println("last name enterd and vaified==pass");
        }
        else {
        	System.out.println("lastname is incorrect==fail");
        }
        driver.close();
	}

}
