package com.fb.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageBaseClass;


public class HomePageClass extends PageBaseClass {

	public HomePageClass(WebDriver driver) {
		super(driver);
		waitFor(driver, 30, home);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	@FindBy(css="div[aria-label='Facebook'] li>span div")
	public WebElement home;
	
	@FindBy(css = "#mount_0_0_G0 > div > div:nth-child(1) > div > div.rq0escxv.l9j0dhe7.du4w35lb > div > div > div.j83agx80.cbu4d94t.d6urw2fd.dp1hu0rb.l9j0dhe7.du4w35lb > div.rq0escxv.l9j0dhe7.du4w35lb.j83agx80.pfnyh3mw.taijpn5t.gs1a9yip.owycx6da.btwxx1t3.dp1hu0rb.p01isnhg > div > div.rq0escxv.l9j0dhe7.du4w35lb.j83agx80.g5gj957u.pmt1y7k9.buofh1pr.hpfvmrgz.taijpn5t.gs1a9yip.owycx6da.btwxx1t3.f7vcsfb0.fjf4s8hc.b6rwyo50.oyrvap6t > div > div > div > div.j83agx80.btwxx1t3.taijpn5t > div > div:nth-child(3) > div > div > div > div.k4urcfbm.g5gj957u.buofh1pr.j83agx80.ll8tlv6m > div")
	public WebElement writePost;
	
	@FindBy(css = "div._1p1v")
	public WebElement createPost;
	
	@FindBy(css = "#mount_0_0_VT > div > div:nth-child(1) > div > div:nth-child(7) > div > div > div.rq0escxv.l9j0dhe7.du4w35lb > div > div.iqfcb0g7.tojvnm2t.a6sixzi8.k5wvi7nf.q3lfd5jv.pk4s997a.bipmatt0.cebpdrjk.qowsmv63.owwhemhu.dp1hu0rb.dhp61c6y.l9j0dhe7.iyyx5f41.a8s20v7p > div > div > div > form > div > div.rq0escxv.pmk7jnqg.du4w35lb.pedkr2u6.oqq733wu.ms05siws.pnx7fd3z.b7h9ocf4.j9ispegn.kr520xx4 > div > div > div > div.ihqw7lf3.discj3wi.l9j0dhe7 > div.k4urcfbm.discj3wi.dati1w0a.hv4rvrfc.i1fnvgqd.j83agx80.rq0escxv.bp9cbjyn > div > div > div.n00je7tq.arfg74bv.qs9ysxi8.k77z8yql.i09qtzwb.n7fi1qx3.b5wmifdl.hzruof5a.pmk7jnqg.j9ispegn.kr520xx4.c5ndavph.art1omkt.ot9fgl3s.rnr61an3")
	public WebElement post;

	String parent  = driver.getWindowHandle();
		
	public void clickHomePagebutton() {
		click(home);
	}
	
	public void createPostWindow(String comment)
	{
		click(writePost);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		while(itr.hasNext())
		{
			String child = itr.next();
			if(parent!=child)
			{
				driver.switchTo().window(child);
				wait.until(ExpectedConditions.elementToBeClickable(createPost));
				sendText(createPost, comment);
				click(post);
				break;
			}
		}
		
	}
	
	public void createPostFrame(String comment)
	{
		click(writePost);
		wait.until(ExpectedConditions.elementToBeClickable(createPost));
		switchFrame(createPost);
		sendText(createPost, comment);
		click(post);
	}
	
	public void createPostAlert(String comment)
	{
		alert(comment);
	}

}
