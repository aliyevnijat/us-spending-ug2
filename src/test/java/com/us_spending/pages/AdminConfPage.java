package com.us_spending.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.us_spending.utilities.Driver;

public class AdminConfPage {
	private WebDriver driver;

	public AdminConfPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='number number-bolder']")
	public WebElement obligatedAmount;

	@FindBy(xpath = "//div[@class='usa-da-treemap-section']")
	public WebElement objectClassesTable;

	@FindBy(xpath = "//*[contains(text(), 'Personnel')]")
	public WebElement personCompTable;

	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement personCompAmount;

	@FindBy(xpath = "//*[contains(text(), 'Contractual')]")
	public WebElement contractServTable;

	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement contractServAmount;

	
	public boolean isTitle(String title) {
		return driver.getTitle().equals(title);
	}

	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
	}
}
