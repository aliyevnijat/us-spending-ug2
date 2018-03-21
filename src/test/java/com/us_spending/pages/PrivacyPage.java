package com.us_spending.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.us_spending.utilities.Driver;
 
public class PrivacyPage {
	private WebDriver driver;
	
	public PrivacyPage() {
		this.driver=Driver.getDriver() ;
		PageFactory.initElements(driver, this);
		
	}
	
	String url="https://www.usaspending.gov/";
	
	@FindBy(xpath="//h1[@id='main-focus']")
	public WebElement Privacytop;
	
	@FindBy(xpath="//h2[@class='about-section-title']")
	public WebElement PrivacyPolicy;
	
}
