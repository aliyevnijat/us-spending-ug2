package com.us_spending.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPage {
	private WebDriver driver;
	
	public PrivacyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[@id='main-focus']")
	public WebElement Privacytop;
	
	@FindBy(xpath="//h2[@class='about-section-title']")
	public WebElement PrivacyPolicy;
	
}
