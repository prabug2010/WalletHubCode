package com.wallethub.testinsurancepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;

public class ReviewSubmissionPage extends PageBaseClass {

	public ReviewSubmissionPage(WebDriver driver) {
		super(driver);
		if(dropdown.isEnabled())
		{
			System.out.println("login success");
		}
	}
	
WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(css="div[class='dropdown second']:nth-child(1)")
	public WebElement dropdown;
	
	@FindBy(css="div[class='dropdown second']>ul li:nth-child(2)")
	public WebElement health;
	
	@FindBy(css="div.android > textarea[placeholder = 'Write your review...']")
	public WebElement writeReview;
	
	@FindBy(css="div.sbn-action.semi-bold-font.btn.fixed-w-c.tall")
	public WebElement submitButton;

	
	public ConfirmReviewPage writeReview(String reviewComment)
	{
		click(dropdown);
		hoverAndClick(health);
		sendText(writeReview, reviewComment);
		return new ConfirmReviewPage(driver);
	}
}
