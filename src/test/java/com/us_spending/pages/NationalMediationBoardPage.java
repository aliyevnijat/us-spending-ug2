package com.us_spending.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.us_spending.utilities.Driver;

public class NationalMediationBoardPage {
	private WebDriver driver;

	public NationalMediationBoardPage() {
		this.driver = Driver.getDriver();
		driver.manage().window().fullscreen();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='usa-da-treemap-section']")
	public WebElement objectClassesTable;

	@FindBy(xpath = "//*[contains(text(), 'Personnel')]")
	public WebElement personCompTable;

	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement personCompAmount;
	
	@FindBy(xpath = "//*[contains(text(), 'Full-time')]")
	public WebElement FullTimeBox;
	
	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement FullTimeAmount;
	
	@FindBy(xpath = "//*[contains(text(), 'Civilian')]")
	public WebElement CivilianBox;
	
	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement CivilianAmount;
	
	@FindBy(xpath = "//*[contains(text(), 'Special')]")
	public WebElement SpecialBox;
	
	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement SpecialAmount;
	
	@FindBy(xpath = "(//*[@class='treemap-svg overlay']/..//*[@class='tile'])[4]")
	public WebElement otherBox;
	
	@FindBy(xpath = "(//div[@class='tooltip-value'])[1]")
	public WebElement otherAmount;
	
	public boolean isTitle(String title) {
		return driver.getTitle().equals(title);
	}

	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
	}

}
