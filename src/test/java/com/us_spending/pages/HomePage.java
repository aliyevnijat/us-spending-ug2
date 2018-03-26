package com.us_spending.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.us_spending.utilities.Driver;

public class HomePage {
	private WebDriver driver;  

	public HomePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	public boolean isTitle(String title) {
		return driver.getTitle().equals(title);
		
	} 
	
	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
		  
	}
	  
	public void goToHomePage() {
		driver.get("https://www.usaspending.gov/#/");
	}
	
	public void clickButton(WebElement element1,WebElement element2 ) {
		 Actions action = new Actions(driver);
		 action.moveToElement(element1).perform();
		 element2.click();
	}
	
	@FindBy(id = "header-glossary-button")
	public WebElement glossary;
	
	@FindBy(xpath = "//input")
	public WebElement glossarySearch;
	
	@FindBy(xpath="//span[.='Spending Explorer']")
	public WebElement spendEx;	 
	
	@FindBy(linkText = "Federal Accounts")
	public WebElement FederalAgencies;

	@FindBy(xpath="//div[.='Profiles']") 
	public WebElement profiles;
	
	@FindBy(linkText = "Agencies") 
	public WebElement agencies;	 	
	
	@FindBy(id = "logo")	
	public WebElement goTohomePage;
	
	@FindBy (xpath = "//div[@class='nav-dropdown__parent-label'][contains(text(),'Download Center')]")
	public WebElement btnDwnldCntr;
	
	@FindBy (xpath = "//a[@href='#/download_center/award_data_archive']")
	public WebElement btnAwardDataArchive;
	 
	@FindBy (xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'Custom Award Data')]") 
	public WebElement btnCustomAwardData;
	
	@FindBy (xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'Agency Submission Files')]")
	public WebElement btnAgencySubmissionFiles;
	
	@FindBy (xpath = "//button[@class='nav-children__link']")
	public WebElement btnDataBaseSnapshots;
	
	@FindBy (xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'API')]")
	public WebElement btnAPI;
	
	@FindBy(xpath="//div[.='Award Search']")  
	 public WebElement awardSearch;
 
	@FindBy(id="header-glossary-button")
	public WebElement Glossary;
	
	@FindBy(xpath="//input")
	public WebElement GlossarySearchPlace;
 
	@FindBy (xpath = "//a[@class='nav-children__link ' and @href='#/search']")
	public WebElement advancedSearch;
	
	@FindBy (xpath = "//a[@class='nav-children__link ' and @href='#/keyword_search']")
	public WebElement keywordSearch;
	
	@FindBy(xpath="//a[@class='nav-children__link ' and @href='#/search']")
	public WebElement AdvanceSearch;
 
	@FindBy(xpath="//a[@class='nav-children__link ' and @href='#/keyword_search']")
	public WebElement KeywordSearch;
	
	@FindBy(xpath="//table//td[.='Department of Housing and Urban Development (HUD)']")
	public WebElement departmentName;
	
	@FindBy(xpath="//table//td[.='Department of Housing and Urban Development (HUD)']/..//td[2]")
	public WebElement departmentBudget;
	
	@FindBy(tagName="h3")
	public WebElement departmentName2;
	
	@FindBy(xpath="//div[@class='budget-authority']//div[@class='authority-amount']")
	public WebElement departmentBudget2;
	
	
}
