package com.us_spending.pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//footer[@class='footer-outer-wrap'  ]//div[@class='copyright']//a[@title]")
	public WebElement ClickHere;
	
	public boolean isTitle(String title) {
		return driver.getTitle().equals(title);
		
	}
	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
		
	}
	 
}
