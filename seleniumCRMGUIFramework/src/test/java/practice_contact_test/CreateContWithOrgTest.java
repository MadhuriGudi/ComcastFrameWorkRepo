package practice_contact_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContWithOrgTest {

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
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgname = row.getCell(2).toString() + randomInt;
		String lastname = row.getCell(3).toString()+ randomInt;
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgname)) {
			System.out.println(orgname+ "is created== pass");
		}
		else {
			System.out.println(orgname+ "is not created==fail");
		}
		String actualOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(actualOrgName.equals(orgname)) {
			System.out.println(orgname+ "is created== pass");
		}
			else {
				System.out.println(orgname+ "is not created==fail");

			
		}
		driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
        
       String parentwin = driver.getWindowHandle();
       
        Set<String> windows = driver.getWindowHandles();
//       Iterator<String> it = window.iterator();
//       while(it.hasNext()) {
//    	   String WindowID = it.next();
//    	   driver.switchTo().window(WindowID);
//    	   String actCWurl = driver.getCurrentUrl();
//    	   if(actCWurl.contains("module=Accounts")) {
//    		   break;
//    		   
//    	   }
//    	   
//       }
        for( String window:windows) {
        	
        	driver.switchTo().window(window);
        	String actCWurl = driver.getCurrentUrl();
        	 if(actCWurl.contains("module=Accounts")) {
       		   break;
       	   }
        	
        }
        driver.findElement(By.id("search_txt")).sendKeys(orgname);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
        
//        Set<String> window1 = driver.getWindowHandles();
//        Iterator<String> it1 = window1.iterator();
//        while(it1.hasNext()) {
//     	   String WindowID1 = it1.next();
//     	   driver.switchTo().window(WindowID1);
//     	   String actpWurl = driver.getCurrentUrl();
//     	   if(actpWurl.contains("module=Contacts&action")) {
//     		   break;
//     	   }
        
        driver.switchTo().window(parentwin);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        driver.close();
        }
	}

        

	


	

