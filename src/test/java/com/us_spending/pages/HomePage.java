package com.us_spending.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
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
	
	
	@FindBy(xpath = "//button [@class='nav-dropdown__parent ' and @title='Profiles: Learn more about organizations and accounts']")
	public WebElement profiles;
	
	@FindBy(xpath = "//a[@class='nav-children__link 'and @href='#/agency']")
	public WebElement agencies;
	
	@FindBy(id = "logo")
	public WebElement goTohomePage;
	
}
