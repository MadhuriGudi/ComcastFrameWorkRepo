package com.comcast.crm.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	//check
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	@FindBy(linkText="More")
	private WebElement morelink;
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindBy(linkText ="Sign Out")
	private WebElement signOut;
	
	
	
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	
	public WebElement getMorelink() {
		return morelink;
	}
	
	
	public WebElement getCampaignlink() {
		return campaignlink;
	}
	
	public void navigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(morelink).build().perform();;
		campaignlink.click();
	}
	public void logout() throws InterruptedException {
		Actions act1=new Actions(driver);
		Thread.sleep(5000);
	   act1.moveToElement(adminImg).build().perform();
		
		signOut.click();
	}

}
