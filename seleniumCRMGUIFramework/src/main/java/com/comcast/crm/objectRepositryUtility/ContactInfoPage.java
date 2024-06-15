package com.comcast.crm.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contheader;
	@FindBy(id="mouseArea_Support Start Date")
	public WebElement strtdatetbx;
	@FindBy(id="mouseArea_Support End Date")
	public WebElement enddatetbx;
	
	
	public WebElement getStrtdatetbx() {
		return strtdatetbx;
	}

	public WebElement getEnddatetbx() {
		return enddatetbx;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getContheader() {
		return contheader;
	}
	
	
		
		
		
	}
	
	


