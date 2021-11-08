package com.fb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.PageBaseClass;

public class LoginPageClass extends PageBaseClass {

	public LoginPageClass(WebDriver driver) {
		super(driver);
		waitFor(driver, 30, userId);
	}

	@FindBy(id = "email")
	public WebElement userId;

	@FindBy(id = "pass")
	public WebElement password;

	@FindBy(name = "login")
	public WebElement loginbutton;

	public void enterUser(String userName) {
		sendText(userId, userName);
	}

	public void enterPassword(String pass) {
		sendText(password, pass);
	}

	public HomePageClass signIn() {
		click(loginbutton);
		return new HomePageClass(driver);
	}

}