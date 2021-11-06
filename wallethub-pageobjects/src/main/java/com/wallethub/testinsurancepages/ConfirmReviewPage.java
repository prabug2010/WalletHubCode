package com.wallethub.testinsurancepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;

public class ConfirmReviewPage extends PageBaseClass {
	
	public ConfirmReviewPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
	}

		@FindBy(css="div.rvc-body-bottom > div.btn.rvc-continue-btn")
		public WebElement continueBtn;
		
		public TestInsurancePage submitReview()
		{
			click(continueBtn);
			return new TestInsurancePage(driver);
		}

}