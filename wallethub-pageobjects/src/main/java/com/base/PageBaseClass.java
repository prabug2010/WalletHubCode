package com.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBaseClass {
	
	public WebDriver driver;
	
		public PageBaseClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriverWait wait;
	public Alert alert;
	
	public void closeDriver() {
		driver.close();
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void sendText(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	public void mouseHover(WebElement element)
	{
		Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	}
	
	public void hoverAndClick(WebElement element)
	{
		Actions action = new Actions(driver);
	action.moveToElement(element).click().build().perform();	
	}

	public void switchFrame(WebElement ele)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		driver.switchTo().frame(ele);
	}
	
	
	public void alert(String comment)
	{
		alert = driver.switchTo().alert();
		alert.sendKeys(comment);
		alert.accept();
	}
	
	public void scrollingDown(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
