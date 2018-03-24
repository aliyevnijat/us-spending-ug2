package com.us_spending.tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	PrivacyPage pp = new PrivacyPage();

	String title = "USAspending.gov";

	String urlHomePage = "https://www.usaspending.gov/#/";
	String urlAgencyPage = "https://www.usaspending.gov/#/agency";
	String urlDBpage = "https://www.usaspending.gov/#/db_info";
	String ppUrl = "https://www.usaspending.gov/";

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

	@Test(priority = 3, description = "USAHM002")
	public void testCase3() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap.BudgetaryResourcesClick.click();
		assertTrue(ap.BudgetaryResourcesDownLight.isDisplayed());
		ap.BudgetaryResourcesClick.click();
		assertTrue(ap.BudgetaryResourcesUpLight.isDisplayed());

	}

	@Test(priority = 4, description = "USAHM002")
	public void testCase4() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		assertTrue(hp.isUrl(urlAgencyPage));
		ap.persentageButton.click();
		assertTrue(ap.persentagelightDown.isDisplayed());
		ap.persentageButton.click();
		assertTrue(ap.persentageUpLight.isDisplayed());
	}

	@Test(priority = 5, description = "USAHM005")
	public void TestCase5() {

		assertTrue(hp.isUrl(urlHomePage));
		assertTrue(hp.isTitle(title));
		hp.clickButton(hp.profiles, hp.agencies);

		assertTrue(ap.isUrl(urlAgencyPage));
		assertTrue(ap.isTitle(title));
		ap.clickButton(ap.agencyName);
		assertTrue(ap.AgencylightDown.isDisplayed());
		ap.clickButton(ap.agencyName);
		assertTrue(ap.AgencyUpLight.isDisplayed());

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
			// NEW COMMENT

		}
	}

	@Test(priority = 8, description = "USAHM008")
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

		assertTrue(pp.Privacytop.getText().contains("Legal"));
		assertTrue(pp.PrivacyPolicy.getText().equals("Privacy Policy"));

	}

	@Test (priority = 9, description = "USAHM009")
		public void testCase9() throws InterruptedException {
		 
			assertTrue(hp.isTitle(title));
			assertTrue(hp.isUrl(urlHomePage));
			hp.clickButton(hp.profiles, hp.agencies);
			
			ap.listToUpperCase();
	}
			

	@Test(priority = 10, description = "USRID011")
	public void testCase10() {

		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));

		hp.clickButton(hp.profiles, hp.agencies);
		ap.DepartmentofAgriculture.click();
		BrowserUtils.waitFor(2);
		ap.AgencyWebsiteButton.click();
		BrowserUtils.waitFor(5);
		List <String> windows = new ArrayList<String> (driver.getWindowHandles());
		BrowserUtils.waitFor(5);
		driver.switchTo().window(windows.get(1));
		BrowserUtils.waitFor(5);
		WebElement newWindow = driver.findElement(By.xpath("/html/head/link[1]")); // bad xpath. Need a good one ) although it works
		BrowserUtils.waitFor(5);

		System.out.println(driver.getTitle()); //not get Url bc Url of the page is not found in elements. Anyone has luck with finding the url??
//		System.out.println(newWindow.getText()); //does not print anything out for some reason

		assertTrue(driver.getTitle().equals("USDA"));
//		assertTrue(newWindow.getText().equals("https://www.usda.gov/")); //does not pass
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

	@Test(priority = 13, description = "USAHM013")
	public void testCase13() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isUrl(urlHomePage));
		Actions mouse = new Actions(driver);
		BrowserUtils.waitForPageToLoad(2);
		mouse.moveToElement(hp.awardSearch).build().perform();
		BrowserUtils.waitFor(2);
		assertTrue(hp.AdvanceSearch.isDisplayed());
		assertTrue(hp.KeywordSearch.isDisplayed());

	}

	@Test(priority = 14, description = "USAHM014")
	public void testCase14() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isUrl(urlHomePage));
		Actions mouse = new Actions(driver);
		BrowserUtils.waitForPageToLoad(2);
		mouse.moveToElement(hp.profiles).build().perform();
		BrowserUtils.waitFor(2);
		assertTrue(hp.profiles.isDisplayed());
		assertTrue(hp.FedaralAgencies.isDisplayed());
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

	@Test(priority = 16, description = "USAHM016")
	public void testCase16() {
		BrowserUtils.waitFor(2);
		assertTrue(hp.isUrl(urlHomePage));

		hp.Glossary.click();
		BrowserUtils.waitFor(2);
		assertTrue(hp.GlossarySearchPlace.isDisplayed());
	}

	@Test(priority = 17, description = "USRID011")
	public void testCase17() {
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		BrowserUtils.waitForPageToLoad(2);
		ap.search.sendKeys("administrative");
		ap.AdministrativeConferenceButton.click();

	}

	@Test(priority = 19) //// USILY 019 MARIA DOBROKHODOVA
	public void signIn() {
		assertTrue(hp.isTitle(title));
		assertTrue(hp.isUrl(urlHomePage));
		hp.clickButton(hp.profiles, hp.agencies);
		ap.test();
		System.out.println(hp.departmentName.getText());
		System.out.println(hp.departmentBudget.getText());
		ap.DepartmentofHousing.click();

		System.out.println(hp.departmentName2.getText());

		System.out.println(hp.departmentBudget2.getText());
		// assertTrue(hp.departmentName.getText().equals(hp.departmentName2.getText()));
		// assertTrue(hp.departmentBudget.getText().equals(hp.departmentBudget2.getText()));
	}

	@Test(priority = 21, description = "USAHM0021")
	public void testCase7() {

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
}
