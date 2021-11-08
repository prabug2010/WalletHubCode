package com.wallethub.testinsurancepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;

public class WalletHubLoginPageClass extends PageBaseClass {

	public WalletHubLoginPageClass(WebDriver driver) {
		super(driver);
		waitFor(driver, 30, loginBtn);
	}
	
	@FindBy(css = "#join-login > form > div.btns > button.btn.blue.center.reg-tabs-bt.touch-element-cl > span")
	public WebElement loginBtn;
	
	@FindBy(id = "email")
	public WebElement mail;
	
	@FindBy(id = "password")
	public WebElement pwd;
	
	@FindBy(css = "#join-login > form > div.full.left.remember > label")
	public WebElement rememberBtn;
	
	public TestInsurancePage login()
	{
		click(loginBtn);
		return new TestInsurancePage(driver);
	}
	
	public void enterUserName(String username)
	{
		sendText(mail, username);
		System.out.println("Entered the username");
	}
	
	public void enterPassword(String password)
	{
		sendText(pwd, password);
		System.out.println("Entered the password");
	}
	
	
	

}
