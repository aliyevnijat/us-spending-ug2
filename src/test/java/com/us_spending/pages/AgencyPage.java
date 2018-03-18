package com.us_spending.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AgencyPage {

	private WebDriver driver;
	public AgencyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//input")
	public WebElement search;
	
	@FindBy(xpath="//*[contains(text(), 'Privacy Policy')]")
	public WebElement PrivacyPolicy;
	
	@FindBy(xpath="//a[. = 'click here']")
	public WebElement ClickHere;
	
	@FindBy(css = ".results-count")
	public WebElement numResult;
	
	@FindBy(css = ".search-section__input")
	public WebElement searchBox;
	
	@FindBy(css = ".matched")
	public WebElement searchedAgencyName;
	
	@FindBy(css = ".results-table-message")
	public WebElement noResultFound;
	
	
	public boolean isTitle(String title) {
		return driver.getTitle().equals(title);
		
	}
	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
		
	}
	 
}
