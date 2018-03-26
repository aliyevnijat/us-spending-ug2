package com.us_spending.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.us_spending.utilities.Driver;

public class AdministrativeConferencePage {

	private WebDriver driver;

	public AdministrativeConferencePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[@class='authority-amount']")
	public WebElement BudgetaryResources;
	
	
}
 