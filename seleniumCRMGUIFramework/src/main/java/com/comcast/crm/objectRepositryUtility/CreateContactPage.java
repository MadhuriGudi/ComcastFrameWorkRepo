package com.comcast.crm.objectRepositryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactPage extends Organizations{
	WebDriverUtility wlib= new WebDriverUtility();

	JavaUtility jlib= new JavaUtility();
			WebDriver  driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement crtNewCont;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectorg;
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDate;
	@FindBy(xpath="//input[@name='support_start_date']")
	private WebElement startDate;
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(name="lastname")
	private WebElement lstnmtbx;
	public WebElement getLstnmtbx() {
		return lstnmtbx;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCrtNewCont() {
		return crtNewCont;
	}
	public WebElement getSelectorg() {
		return selectorg;
	}
	public WebElement getEndDate() {
		return endDate;
	}
	public WebElement getStartDate() {
		return startDate;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void CreateNewContact(String lastname) {
		lstnmtbx.sendKeys(lastname);
		savebtn.click();
		
		}
	public void  createContWithOrg(String lastname ,String orgname) {
		lstnmtbx.sendKeys(lastname);
		String parentWindow=driver.getWindowHandle();
		selectorg.click();
		wlib.swichNewBrowserTab(driver, "module=Accounts");
		super.getSrchTxtBx().sendKeys(orgname);
		super.getSrcBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
		
		driver.switchTo().window(parentWindow);
		savebtn.click();
		
		
	    
		
		
		
	}
	
	public void contactDate (String lastname) throws InterruptedException {
		lstnmtbx.sendKeys(lastname);
		String START_DATE=jlib.getSystemDate();
		System.out.println(START_DATE);
		startDate.clear();
		System.out.println("Text field clear");
		Thread.sleep(5000);
		startDate.sendKeys(START_DATE);
		System.out.println(START_DATE);
		
		
		String END_DATE=jlib.getRequriedDateYYYYDDMM(30);
		System.out.println(END_DATE);
		endDate.clear();
		Thread.sleep(5000);
		endDate.sendKeys(END_DATE);
		savebtn.click();
		
		
	}
	public void selectOrg() {
		selectorg.click();
		
	}
	
}
