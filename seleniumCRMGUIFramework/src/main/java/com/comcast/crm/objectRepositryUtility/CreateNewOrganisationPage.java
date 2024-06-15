package com.comcast.crm.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganisationPage {
	WebDriver driver;
	public CreateNewOrganisationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="accountname")
	private WebElement orgnameEdit;
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(name="industry")
	private WebElement indDD;
	@FindBy(id="phone")
	private WebElement phntxt;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getIndDD() {
		return indDD;
	}
	public WebElement getPhntxt() {
		return phntxt;
	}
	public WebElement getOrgnameEdit() {
		return orgnameEdit;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public void createorg(String orgname) {
		orgnameEdit.sendKeys(orgname);
		savebtn.click();
		}
	public void createorg(String orgname , String industries) {
		orgnameEdit.sendKeys(orgname);
		Select sel= new Select(indDD);
		sel.selectByVisibleText(industries);
    	savebtn.click();
		
	}
	public void createphoneNum(String Phonenumber) {
		phntxt.sendKeys(Phonenumber);
	}
	
		
	
	
	

}
