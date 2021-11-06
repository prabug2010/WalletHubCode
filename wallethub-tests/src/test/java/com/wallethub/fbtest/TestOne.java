package com.wallethub.fbtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.annotations.Test;

import com.wallethub.testbase.TestBaseClass;

public class TestOne extends TestBaseClass{
	
	@Test
	public void verifyPublish() {
		driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
		WebElement rating = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(7)"));
		String colour = rating.getCssValue("color");
		Actions act = new Actions(driver);
		act.moveToElement(rating).click().build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement highStar = driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg:nth-child(7) > g > path:nth-child(1)"));
		String hcolour = highStar.getCssValue("color");
		System.out.println(colour);
		System.out.println(hcolour);
		
		}

}
