package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.us_spending.pages.AgencyPage;
import com.us_spending.pages.HomePage;
import com.us_spending.pages.PrivacyPage;
import com.us_spending.utilities.BrowserUtils;
import com.us_spending.utilities.TestBaseClass;

public class UsSpendingTestCase extends TestBaseClass {

	HomePage hp = new HomePage();
	AgencyPage ap = new AgencyPage();
	PrivacyPage pp = new PrivacyPage() ;

	String title = "USAspending.gov";
	
	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	String urlDBpage = "https://www.usaspending.gov/#/db_info";
	String ppUrl="https://www.usaspending.gov/";
	
	@Test(priority = 1, description = "USAHM001")
	public void testCase1() {
  
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap.search.clear();
		ap.search.sendKeys("Department of Homeland Security");
		assertTrue(ap.numResult.isDisplayed());
		assertTrue(ap.searchBox.getAttribute("value").equals("Department of Homeland Security"));
		assertTrue(ap.searchedAgencyName.isDisplayed(), ap.searchedAgencyName.getText());
	}

	@Test(priority = 2, description = "USAHM002")
	public void testCase2() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap.search.clear();
		ap.search.sendKeys("babakuly");
		assertTrue(ap.numResult.isDisplayed());
		assertTrue(ap.searchBox.getAttribute("value").equals("babakuly"));
		assertTrue(ap.noResultFound.isDisplayed(), ap.noResultFound.getText());
	}

	@Test(priority = 5, description = "USAHM005")
	public void TestCase5() {
		
		assertTrue(hp.isUrl(urlHomePage));
		assertTrue(hp.isTitle(title));
		hp.clickButton(hp.profiles, hp.agencies);
		
		assertTrue(ap.isUrl(urlAgencyPage));
		assertTrue(ap.isTitle(title));
		ap.clickButton(ap.agencyName);
		//agencyPage.clickButton(agencyPage.agencyName);
		ap.clickButton(ap.arrowDown);
		ap.clickButton(ap.arrowUp);
	}
	@Test(priority = 6, description = "USAHM006")
	public void TestCase6() {
		assertTrue(hp.isUrl(urlHomePage));
		assertTrue(hp.isTitle(title));
		hp.clickButton(hp.profiles, hp.agencies);
		
		assertTrue(ap.isUrl(urlAgencyPage));
		assertTrue(ap.isTitle(title));
		
		List<WebElement> list = ap.budgetaryRecuorcesFormatLlist;
		for (WebElement row : list) {
			System.out.println(row.getText());
		//NEW COMMENT
		
	}
	}

//	@Test(priority = 7, description = "USAHM007")
	public void testCase7() {
		//BrowserUtils.waitFor(2);
		BrowserUtils.waitForPageToLoad(2);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap.search.sendKeys("");
		BrowserUtils.scroll(ap.ClickHere);
		ap.ClickHere.click();
		BrowserUtils.waitFor(3);
		BrowserUtils.switchToWindowUrl(urlDBpage);
		assertTrue(hp.isTitle(title));
		BrowserUtils.waitForPageToLoad(2);
		assertTrue(hp.isUrl(urlDBpage), driver.getCurrentUrl());
	}

	 @Test (priority = 8, description = "USAHM008")
	public void testCase8() throws InterruptedException {
	 
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap.PrivacyPolicy.click();	
		BrowserUtils.waitFor(3);
		assertTrue(ap.isTitle(title));
		BrowserUtils.waitForPageToLoad(2);
		assertTrue(driver.getCurrentUrl().contains(ppUrl));
		
		assertTrue(pp.Privacytop.getText().equals("Legal"));
		assertTrue(pp.PrivacyPolicy.getText().equals("Privacy Policy"));

	}
	
	@Test(priority = 11, description = "USRID011")
	public void testCase11() {	

		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		 
		hp.clickButton(hp.profiles, hp.agencies);
	}

	@Test(priority = 12, description = "USRID012") 
	public void testCase12() {
		driver.manage().window().maximize();
		assertTrue(hp.isTitle(title));		
		hp.spendEx.click();
		assertTrue(hp.spendEx.isDisplayed());
		

	}

	@Test(priority = 15, description = "USAHM015")
	public void testCase15() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isUrl(urlHomePage));
		Actions mouse = new Actions(driver);
		BrowserUtils.waitForPageToLoad(2);
		mouse.moveToElement(hp.btnDwnldCntr).build().perform();
		assertTrue(hp.btnAwardDataArchive.isDisplayed());
		assertTrue(hp.btnCustomAwardData.isDisplayed());
		assertTrue(hp.btnAgencySubmissionFiles.isDisplayed());
		assertTrue(hp.btnDataBaseSnapshots.isDisplayed());
		assertTrue(hp.btnAPI.isDisplayed());
	}


	@Test(priority = 19) //// USILY 019 MARIA DOBROKHODOVA
	public void signIn() {

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/header/nav/div/div[4]/ul/li[1]/a")).click();
		driver.navigate().to("https://www.usaspending.gov/#/explorer/agency");

	}
	
	@Test(priority = 13, description = "USRID013")
	 public void testCase13() {  
	  driver.manage().window().maximize();
	  assertTrue(hp.isTitle(title));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(hp.profiles).perform();

	 }
	 
	 @Test(priority = 14, description = "USRID014")
	 public void testCase14() {  
	  driver.manage().window().maximize();
	  assertTrue(hp.isTitle(title));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(hp.awardSearch).perform();

	 }
	

}
