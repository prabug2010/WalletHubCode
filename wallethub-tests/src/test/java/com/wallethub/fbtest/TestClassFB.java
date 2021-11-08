package com.wallethub.fbtest;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.fb.pages.HomePageClass;
import com.fb.pages.LoginPageClass;
import com.wallethub.testbase.TestBaseClass;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TestClassFB extends TestBaseClass {

	@Test
	public void faceBookPost() {
		driver.get(testConfig.get("url"));
		LoginPageClass login = new LoginPageClass(driver);
		login.enterUser(testConfig.get("username"));
		login.enterPassword(testConfig.get("password"));
		HomePageClass home = login.signIn();
		System.out.println("Successfully logged in!!!");
		try {
			Thread.sleep(10000);
			System.out.println("Wait over!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Robot robot = null;
		try {
			robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);// C
		} catch (Exception e) {
			e.printStackTrace();
		}

		home.clickHomePagebutton();
	//	home.createPostWindow(testConfig.get("comment"));
		home.createPostFrame(testConfig.get("comment"));
	//	home.createPostAlert(testConfig.get("comment"));
	}
	

}
