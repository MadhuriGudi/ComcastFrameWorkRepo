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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateorgwithIndustriesTest {

	public static void main(String[] args) throws IOException {
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
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgname = row.getCell(2).toString() + randomInt;
		String industries = row.getCell(3).toString();
		String type = row.getCell(4).toString();
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement industry = driver.findElement(By.name("industry"));
		Select sel1=new Select(industry);
		sel1.selectByVisibleText(industries);
		WebElement type1 = driver.findElement(By.name("accounttype"));
		Select sel2=new Select(type1);
		sel2.selectByVisibleText(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actlindusty = driver.findElement(By.id("dtlview_Industry")).getText();
		String actltype = driver.findElement(By.id("dtlview_Type")).getText();
		
		if(industries.equals(actlindusty)) {
			System.out.println(industries+ "   entered and varified==pass");
		}
		else {
			System.out.println(industries+ "    not entered==fail");
		}
		if(type.equals(actltype)) {
			System.out.println(type+ "entered and varified==pass");
		}
		
		else {
			System.out.println(type+ "not entered ==fail");
		}
        driver.quit();
	}

}
