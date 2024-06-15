package com.comcast.crm.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public void loginToApp( String url,String username , String password) {
		 waitForPageload(driver);
		 driver.get(url);
		 
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginbtn.click();
	}
	

}
