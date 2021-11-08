package com.wallethub.testinsurancepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;

public class ReviewSubmissionPage extends PageBaseClass {

	public ReviewSubmissionPage(WebDriver driver) {
		super(driver);
		waitFor(driver, 30, dropdown);
	}
	
WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(css="div[class='dropdown second']:nth-child(1)")
	public WebElement dropdown;
	
	@FindBy(css="div[class='dropdown second opened'] ul li:nth-child(2)")
	public WebElement health;
	
	@FindBy(css="textarea[placeholder = 'Write your review...']")
	public WebElement writeReview;
	
	@FindBy(css="div.sbn-action.semi-bold-font.btn.fixed-w-c.tall")
	public WebElement submitButton;

	@FindBy(css = "#reviews-section modal-dialog review-star svg:nth-child(7) path[fill='none']")
	public WebElement validate4Star;

	
	public void writeReview(String reviewComment)
	{
		click(dropdown);
		System.out.println("Dropdown selected !!!");
		//hoverAndClick(health);
		click(health);
		System.out.println("Health Insurance selected !!!");
		sendText(writeReview, reviewComment);
		System.out.println("Review given !!!");
		click(submitButton);
	}

	public void validateStar()
	{
		waitFor(driver, 30, validate4Star);
	}
}
