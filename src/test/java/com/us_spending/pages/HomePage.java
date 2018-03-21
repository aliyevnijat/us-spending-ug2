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
	
 
	 
	
	@FindBy(linkText = "Fedaral Accounts")      //Shavkat
	public WebElement FedaralAgencies;
	
	@FindBy(linkText = "Agencies")      //Shavkat
	public WebElement agencies2;
	
	@FindBy(xpath="//div[.='Profiles']") 
	public WebElement profiles;
	
	@FindBy(linkText = "Agencies") 
	public WebElement agencies;
	
	@FindBy(linkText = "Federal Accounts") 
	public WebElement federalAcc;	
	
	@FindBy(id = "logo")	
	public WebElement goTohomePage;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/button")
	public WebElement btnDwnldCntr;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[1]/a")
	public WebElement btnAwardDataArchive;
	 
	@FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[2]/a") 
	public WebElement btnCustomAwardData;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[4]/a")
	public WebElement btnAgencySubmissionFiles;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[5]/button")
	public WebElement btnDataBaseSnapshots;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/"
			+ "header/nav/div/div[4]/ul/li[4]/div/div/ul/li[6]/a")
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
}
