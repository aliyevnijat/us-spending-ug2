package com.us_spending.tests;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.us_spending.pages.AgencyPage;
import com.us_spending.pages.HomePage;
import com.us_spending.utilities.TestBaseClass;

public class TestCase5_Bobur extends TestBaseClass {

	String title = "USAspending.gov";
	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	
	
	HomePage hp;
	AgencyPage ap;
	
	@Test(priority = 5, description = "USAHM005")
	public void TestCase5() {
		hp = new HomePage(driver);
		assertTrue(hp.isUrl(urlHomePage));
		assertTrue(hp.isTitle(title));
		hp.clickButton(hp.profiles, hp.agencies);
		
		ap=new AgencyPage(driver);
		assertTrue(ap.isUrl(urlAgencyPage));
		assertTrue(ap.isTitle(title));
		ap.clickButton(ap.agencyName);
		//agencyPage.clickButton(agencyPage.agencyName);
		ap.clickButton(ap.arrowDown);
		ap.clickButton(ap.arrowUp);
	}
}
