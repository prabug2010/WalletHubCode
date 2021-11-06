package com.wallethub.fbtest;


import org.testng.annotations.Test;
import com.fb.pages.HomePageClass;
import com.fb.pages.LoginPageClass;
import com.wallethub.testbase.TestBaseClass;

public class TestClassFB extends TestBaseClass {

	@Test
	public void faceBookPost() {
		driver.get(testConfig.get("url"));
		LoginPageClass login = new LoginPageClass(driver);
		login.enterUser(testConfig.get("username"));
		login.enterPassword(testConfig.get("password"));
		login.signIn();
		HomePageClass home = new HomePageClass(driver);
		home.homePagebutton();
	//	home.createPostWindow(testConfig.get("comment"));
		home.createPostFrame(testConfig.get("comment"));
	//	home.createPostAlert(testConfig.get("comment"));
	}
	

}
