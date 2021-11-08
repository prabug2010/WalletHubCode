package com.wallethub.testinsurancepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.PageBaseClass;

public class TestInsurancePage extends PageBaseClass{

	public TestInsurancePage(WebDriver driver) {
		super(driver);
		waitFor(driver, 30, pageLocator);
	}

	@FindBy(css = "h1.profile-name")
	public WebElement pageLocator;

	@FindBy(css = "#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(7)")
	public WebElement stars;

	@FindBy(css = "#web-app > header > div > nav.burger-menu-right-menu.brgm-guest-user > span")
	public WebElement loginMenu;
	
	@FindBy(css = "#web-app > header > div > nav.burger-menu-right-menu > div.brgm-button.brgm-user.brgm-list-box > span")
	public WebElement profile;
		
	public WalletHubLoginPageClass clickLogin()
	{
		click(loginMenu);
		return new WalletHubLoginPageClass(driver);
	}
	
	public ReviewSubmissionPage rating()
	{
		scrollingDown(stars);
		System.out.println("scrolling process done !!!");
		//mouseHover(stars);
		click(stars);
		System.out.println("stars given !!!");
		return new ReviewSubmissionPage(driver);
	}
	
	public ProfilePage validateReview()
	{
		mouseHover(loginMenu);
		hoverAndClick(profile);
		return new ProfilePage(driver);
	}
	
}
