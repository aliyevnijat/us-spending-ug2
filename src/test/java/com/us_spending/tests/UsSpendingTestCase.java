package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.us_spending.pages.AgencyPage;
import com.us_spending.pages.HomePage;
import com.us_spending.pages.PrivacyPage;
import com.us_spending.utilities.TestBaseClass;

public class UsSpendingTestCase extends TestBaseClass {
	
	HomePage hp;
	AgencyPage ap;
	PrivacyPage pp;
	
	String title = "USAspending.gov";
	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	
	
	@Test
	public void TestCase7() throws InterruptedException {
		hp=new HomePage(driver);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		Thread.sleep(4000);
		ap.ClickHere.click();
		String handle= driver.getWindowHandle();
		driver.switchTo().window(handle);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		
	}
//	@Test
	public void TestCase8() throws InterruptedException {
		hp=new HomePage(driver);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap=new AgencyPage(driver);
		ap.PrivacyPolicy.click();
		assertTrue(ap.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		assertTrue(pp.Privacytop.getText().equals("Legal"));
		assertTrue(pp.PrivacyPolicy.getText().equals("Privacy Policy"));	
	}
	
}
