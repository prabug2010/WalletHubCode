package com.wallethub.testinsurancepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.PageBaseClass;

public class TestInsurancePage extends PageBaseClass{

	public TestInsurancePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "svg.rvs-star-svg:nth-child(7)")
	public WebElement stars;
	
	@FindBy(css = "#web-app > header > div > nav.burger-menu-right-menu.brgm-guest-user > span")
	public WebElement loginMenu;
	
	@FindBy(css = "#web-app > header > div > nav.burger-menu-right-menu > div.brgm-button.brgm-user.brgm-list-box > span")
	public WebElement profile;
		
	public WalletHubLoginPageClass loginAccount()
	{
		loginMenu.click();	
		return new WalletHubLoginPageClass(driver);
	}
	
	public ReviewSubmissionPage rating()
	{
		scrollingDown(stars);
		mouseHover(stars);
		click(stars);
		return new ReviewSubmissionPage(driver);
	}
	
	public ProfilePage validateReview()
	{
		mouseHover(loginMenu);
		hoverAndClick(profile);
		return new ProfilePage(driver);
	}
	
}
