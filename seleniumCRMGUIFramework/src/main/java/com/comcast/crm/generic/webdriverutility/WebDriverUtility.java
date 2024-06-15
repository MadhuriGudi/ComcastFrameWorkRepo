package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void swichNewBrowserTab(WebDriver driver, String partialurl ) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialurl)) {
				break;
			}
		}
			
		}
		public void swichNewTabOnTitle(WebDriver driver, String partialTitle ) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String windowid = it.next();
				driver.switchTo().window(windowid);
				String actTitle = driver.getTitle();
				if (actTitle.contains(partialTitle)) {
					break;
				}
				
			}
	}
		public void switchtoFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		public void switchtoFrame(WebDriver driver, String nameID) {
			driver.switchTo().frame(nameID);
		}
		public void switchtoFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}
		public void alertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		public void alertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		public void select (WebElement element, String text) {
			Select sel= new Select(element);
			sel.deselectByVisibleText(text);
		}
		public void select(WebElement element, int index) {
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		public void mouseMoveOnElement(WebDriver driver, WebElement element) {
			Actions act= new Actions(driver);
			act.moveToElement(element).build().perform();
		}
		public void doubleClick(WebDriver driver, WebElement element) {
			Actions act= new Actions(driver);
			act.contextClick(element).build().perform();
		}
		
		

}
