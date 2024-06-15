package practice.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brand, String product) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		String x= "(//span[text()='"+product+"'])[2]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objarr=new Object[3][2];
	    objarr[0][0]= "iphone";
		objarr[0][1]= "Apple iPhone 15 (128 GB) - Black";
		objarr[1][0]= "iphone";		
		objarr[1][1]= "Apple iPhone 13 (128GB) - Pink";
		objarr[2][0]= "iphone";
		objarr[2][1]= "Apple iPhone 13 (128GB) - Starlight";
	
		return objarr;
	}
	

}
