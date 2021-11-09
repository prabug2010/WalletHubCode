package com.fb.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;


public class HomePageClass extends PageBaseClass {

	public HomePageClass(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.elementToBeClickable(home));
		if(home.isEnabled())
		{
			System.out.println("login success");
		}

	}
	
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	@FindBy(css="div[aria-label='Facebook'] li>span div")
	public WebElement home;
	
	@FindBy(css = "div.a5q79mjw:nth-child(1) > span")
	public WebElement writePost;
	
	@FindBy(css = "div._1p1v")
	public WebElement createPost;
	
	@FindBy(css = "div.a5q79mjw:nth-child(1) > span")
	public WebElement post;

	String parent  = driver.getWindowHandle();
		
	public void homePagebutton() {
		click(home);
		}
	
	public void createPostWindow(String comment)
	{
		click(writePost);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		while(itr.hasNext())
		{
			String child = itr.next();
			if(parent!=child)
			{
				driver.switchTo().window(child);
				wait.until(ExpectedConditions.elementToBeClickable(createPost));
				sendText(createPost, comment);
				click(post);
				break;
			}
		}
		
	}
	
	public void createPostFrame(String comment)
	{
		click(writePost);
		wait.until(ExpectedConditions.elementToBeClickable(createPost));
		switchFrame(createPost);
		sendText(createPost, comment);
		click(post);
	}
	
	public void createPostAlert(String comment)
	{
		alert(comment);
	}

}
