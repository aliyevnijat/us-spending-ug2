package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;


import org.testng.annotations.Test;

import com.us_spending.pages.AgencyPage;
import com.us_spending.pages.HomePage;
import com.us_spending.pages.PrivacyPage;
import com.us_spending.utilities.BrowserUtils;
import com.us_spending.utilities.TestBaseClass;

public class UsSpendingTestCase extends TestBaseClass {
	
	HomePage hp;
	AgencyPage ap;
	PrivacyPage pp;
	
	String title = "USAspending.gov";
	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	String urlDBpage = "https://www.usaspending.gov/#/db_info";
	
	@Test(priority = 0, description = "USAHM001")
	public void testCase1() {
		 hp=new HomePage(driver);
		 assertTrue(hp.isTitle(title));
		 assertTrue(hp.isUrl(urlHomePage));
		 hp.clickButton(hp.profiles, hp.agencies);
		 assertTrue(hp.isUrl(urlAgencyPage));
		 ap = new AgencyPage(driver);
		 ap.search.clear();
		 ap.search.sendKeys("Department of Homeland Security");
		 assertTrue(ap.numResult.isDisplayed());
		 assertTrue(ap.searchBox.getAttribute("value").equals("Department of Homeland Security"));
		 assertTrue(ap.searchedAgencyName.isDisplayed(), ap.searchedAgencyName.getText());
	}
	@Test(priority = 1, description = "USAHM007")
	public void testCase7()  {
		hp=new HomePage(driver);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap = new AgencyPage(driver);
		ap.search.sendKeys("");
		BrowserUtils.scroll(ap.ClickHere);
		ap.ClickHere.click();
		BrowserUtils.waitFor(3);
		BrowserUtils.switchToWindowUrl(urlDBpage);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlDBpage), driver.getCurrentUrl());	
	}
	//@Test
	public void testCase8() throws InterruptedException {
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
