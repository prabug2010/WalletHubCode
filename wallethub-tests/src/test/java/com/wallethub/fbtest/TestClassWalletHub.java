package com.wallethub.fbtest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.wallethub.testbase.TestBaseClass;
import com.wallethub.testinsurancepages.ConfirmReviewPage;
import com.wallethub.testinsurancepages.ProfilePage;
import com.wallethub.testinsurancepages.ReviewSubmissionPage;
import com.wallethub.testinsurancepages.TestInsurancePage;
import com.wallethub.testinsurancepages.WalletHubLoginPageClass;

public class TestClassWalletHub extends TestBaseClass{
	
	@Parameters({"url","username","password","comment"})	
	@Test
	public void postReview(String url, String username, String password, String comment) 
	{
		driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
		TestInsurancePage tip = new TestInsurancePage(driver);
		tip.loginAccount();
		WalletHubLoginPageClass wlc = new WalletHubLoginPageClass(driver);
		wlc.enterUserName(username);
		wlc.enterPassword(password);
		tip = wlc.login();
		tip.rating();
		ReviewSubmissionPage review = new ReviewSubmissionPage(driver);
		review.writeReview(comment);
		ConfirmReviewPage conf = new ConfirmReviewPage(driver);
		conf.submitReview();
		ProfilePage prof = new ProfilePage(driver);
		prof.verifyReview();
	}

}
