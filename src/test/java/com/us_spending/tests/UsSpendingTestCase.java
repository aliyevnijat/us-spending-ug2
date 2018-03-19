package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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
	@Test(priority = 1, description = "USAHM002")
	public void testCase2() {
		 BrowserUtils.waitFor(2);
		 hp=new HomePage(driver);
		 assertTrue(hp.isTitle(title));
		 assertTrue(hp.isUrl(urlHomePage));
		 hp.clickButton(hp.profiles, hp.agencies);
		 assertTrue(hp.isUrl(urlAgencyPage));
		 ap = new AgencyPage(driver);
		 ap.search.clear();
		 ap.search.sendKeys("babakuly");
		 assertTrue(ap.numResult.isDisplayed());
		 assertTrue(ap.searchBox.getAttribute("value").equals("babakuly"));
		 assertTrue(ap.noResultFound.isDisplayed(), ap.noResultFound.getText());
	}
	@Test(priority = 2, description = "USAHM007")
	public void testCase7()  {
		BrowserUtils.waitFor(2);
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
	//@Test (priority = 2, description = "USAHM008")
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
	
	@Test(priority = 627, description="USRID012")//Shavkat's
	public void testCase12() {
		 hp=new HomePage(driver);
		 driver.manage().window().maximize();
		 assertTrue(hp.isTitle(title));
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 hp.spendEx.click();
		 
	}
	
	@Test(priority = 3, description = "USAHM015")
	public void testCase15()  {
		hp = new HomePage(driver);
		assertTrue(hp.isUrl(urlHomePage));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(hp.btnDwnldCntr).build().perform();
	
		assertTrue(hp.btnAwardDataArchive.isDisplayed());
		assertTrue(hp.btnCustomAwardData.isDisplayed());
		assertTrue(hp.btnAgencySubmissionFiles.isDisplayed());
		assertTrue(hp.btnDataBaseSnapshots.isDisplayed());
		assertTrue(hp.btnAPI.isDisplayed());
	}
	
	@Test (priority=19)////USILY 019 MARIA  DOBROKHODOVA
	public void signIn() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/header/nav/div/div[4]/ul/li[1]/a")).click();
		driver.navigate().to("https://www.usaspending.gov/#/explorer/agency");
	
}}
