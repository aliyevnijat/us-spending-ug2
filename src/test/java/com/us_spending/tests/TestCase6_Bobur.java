package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.us_spending.pages.AgencyPage;
import com.us_spending.pages.HomePage;
import com.us_spending.utilities.TestBaseClass;



public class TestCase6_Bobur extends TestBaseClass {

	String title = "USAspending.gov";
	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	
	
	HomePage hp;
	AgencyPage ap;
	
	@Test(priority = 6, description = "USAHM006")
	public void TestCase6() {
		hp = new HomePage(driver);
		assertTrue(hp.isUrl(urlHomePage));
		assertTrue(hp.isTitle(title));
		hp.clickButton(hp.profiles, hp.agencies);
		
		ap=new AgencyPage(driver);
		assertTrue(ap.isUrl(urlAgencyPage));
		assertTrue(ap.isTitle(title));
		
		List<WebElement> list = ap.budgetaryRecuorcesFormatLlist;
		for (WebElement row : list) {
			System.out.println(row.getText());
		
		
	}
	}
}
