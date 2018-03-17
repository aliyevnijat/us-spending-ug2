package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.us_spending.pages.AgencyPage;
import com.us_spending.pages.HomePage;
import com.us_spending.utilities.BrowserUtils;
import com.us_spending.utilities.TestBaseClass;

public class SmokeTest extends TestBaseClass {
	
	String title = "USAspending.gov";
	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	
	
	HomePage homePage = new HomePage(driver);
	
	
	@Test(priority = 0)
	public void smokeTest1 (){
		homePage = new HomePage(driver);
		assertTrue(homePage.isTitle(title));
		assertTrue(homePage.isUrl(urlHomePage));
		homePage.clickButton(homePage.profiles, homePage.agencies);
		assertTrue(homePage.isUrl(urlAgencyPage));
		
	
		
	}
	@Test(priority = 1)
	public void smokeTest2() {
		BrowserUtils.waitFor(2);
		homePage.goTohomePage.click();
		
	}
	
}
