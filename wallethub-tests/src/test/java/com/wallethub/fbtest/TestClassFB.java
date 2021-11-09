package com.wallethub.fbtest;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fb.pages.HomePageClass;
import com.fb.pages.LoginPageClass;
import com.wallethub.testbase.TestBaseClass;

public class TestClassFB extends TestBaseClass {
	
	@Parameters({"url","username","password","comment"})	
	@Test
	public void faceBookPost(String url, String username, String password, String comment) {
		driver.get(url);
		LoginPageClass login = new LoginPageClass(driver);
		login.enterUser(username);
		login.enterPassword(password);
		login.signIn();
		HomePageClass home = new HomePageClass(driver);
		home.homePagebutton();
	//	home.createPostWindow(comment);
		home.createPostFrame(comment);
	//	home.createPostAlert(comment);
	
	}

}
