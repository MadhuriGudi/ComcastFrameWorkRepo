package com.comcast.crm.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	WebDriver  driver;
	public Organizations() {}
	public Organizations (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(id="search_txt")
	private WebElement srchTxtBx;
	@FindBy(name ="search")
	private WebElement srcBtn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSrchTxtBx() {
		return srchTxtBx;
	}
	public WebElement getSrcBtn() {
		return srcBtn;
	}
	
}
