package com.wallethub.testinsurancepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;

public class ProfilePage extends PageBaseClass{

	public ProfilePage(WebDriver driver) {
		super(driver);
		}
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(linkText="Test Insurance Company")
	public WebElement reviewPublish;
	

	public void verifyReview()
	{
		if(reviewPublish.isEnabled())
		{
			System.out.println("Review published successfully");
		}
	}
}
