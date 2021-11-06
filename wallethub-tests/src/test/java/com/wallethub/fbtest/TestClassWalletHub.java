package com.wallethub.fbtest;

import org.testng.annotations.Test;

import com.fb.pages.LoginPageClass;
import com.wallethub.testbase.TestBaseClass;
import com.wallethub.testinsurancepages.ConfirmReviewPage;
import com.wallethub.testinsurancepages.ProfilePage;
import com.wallethub.testinsurancepages.ReviewSubmissionPage;
import com.wallethub.testinsurancepages.TestInsurancePage;
import com.wallethub.testinsurancepages.WalletHubLoginPageClass;

public class TestClassWalletHub extends TestBaseClass{
	
	@Test
	public void postReview()
	{
		String s = "Your health insurance policy provides you with financial assistance at the time of a medical emergency. Health risks and uncertainties are part of life. \r\n"
				+ "Hence, it is important you opt for a health insurance plan.";
		driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
		TestInsurancePage tip = new TestInsurancePage(driver);
		tip.loginAccount();
		WalletHubLoginPageClass wlc = new WalletHubLoginPageClass(driver);
		wlc.enterUserName("gprabumail@yahoo.com");
		wlc.enterPassword("Kalkin@2018");
		tip = wlc.login();
		tip.rating();
		ReviewSubmissionPage review = new ReviewSubmissionPage(driver);
		review.writeReview(s);
		ConfirmReviewPage conf = new ConfirmReviewPage(driver);
		conf.submitReview();
		ProfilePage prof = new ProfilePage(driver);
		prof.verifyReview();
	}

}
