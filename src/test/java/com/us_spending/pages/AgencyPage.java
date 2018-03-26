package com.us_spending.pages;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.us_spending.utilities.Driver;

public class AgencyPage {

	private WebDriver driver;

	public AgencyPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input")
	public WebElement search;

	@FindBy(xpath = "//*[contains(text(), 'Privacy Policy')]")
	public WebElement PrivacyPolicy;

	@FindBy(xpath = "//a[. = 'click here']")
	public WebElement ClickHere;

	@FindBy(css = ".results-count")
	public WebElement numResult;

	@FindBy(css = ".search-section__input")
	public WebElement searchBox;

	@FindBy(css = ".matched")
	public WebElement searchedAgencyName;

	@FindBy(css = ".results-table-message")
	public WebElement noResultFound;

	@FindBy(xpath = "//button [@class='nav-dropdown__parent ' and @title='Profiles: Learn more about organizations and accounts']")
	public WebElement profiles;

	@FindBy(xpath = "//a[@class='nav-children__link 'and @href='#/agency']")
	public WebElement agencies;

	@FindBy(xpath = "//table //thead //td[1]") // Bobur
	public WebElement agencyName;

	@FindBy(xpath = "//button[@class='sort-icon' and @title='Sort table by descending Agency Name']")
	public WebElement arrowDown;// Bobur

	@FindBy(xpath = "//button[@class='sort-icon active' and @title='Sort table by ascending Agency Name']")
	public WebElement arrowUp;// Bobur

	@FindBy(xpath = "(//table//tbody//tr//td[2]//div//div)[1]")
	public WebElement budgetaryRecuorcesFormat;// Bobur

	@FindBy(xpath = "(//table//tbody//tr//td[2]//div//div)")
	public List<WebElement> budgetaryRecuorcesFormatLlist;// Bobur

	@FindBy(xpath = "//table//thead//td[2]")
	public WebElement BudgetaryResourcesClick;

	@FindBy(xpath = "//button[@class='sort-icon active']")
	public WebElement BudgetaryResourcesDownLight;

	@FindBy(xpath = "//button[@class='sort-icon active']")
	public WebElement BudgetaryResourcesUpLight;

	@FindBy(xpath = "//table//thead//td[3]")
	public WebElement persentageButton;
	
	@FindBy(xpath = "//div[@id='agency-landing-results']//tbody/tr/td[3]//div[@class='cell-content']")
	public List<WebElement> agencyProfilesTable3rdColumn;

	@FindBy(xpath = "//button [@class='sort-icon active']")
	public WebElement persentagelightDown;

	@FindBy(xpath = "//button [@class='sort-icon active']")
	public WebElement persentageUpLight;

	@FindBy(xpath = "//button [@class='sort-icon active']")
	public WebElement AgencylightDown;

	@FindBy(xpath = "//button [@class='sort-icon active']")
	public WebElement AgencyUpLight;

	@FindBy(xpath = "//table//tbody//td[1]")
	public WebElement AdministrativeConferenceButton;

	@FindBy(xpath = "//p[@class='against-auth-text']")
	public WebElement ObligatedAmount;

	@FindBy(xpath = "//table//tbody//td[1]")
	public List<WebElement> AgencyNames;

	@FindBy(xpath = "//table//tbody//td[2]")
	public List<WebElement> AgencyAmount;

	@FindBy(xpath = " //a[. = 'Department of Housing and Urban Development (HUD)']")
	public WebElement DepartmentofHousing;

	@FindBy(xpath = " //div[@class='authority-amount']")
	public WebElement DepartmentofHousingAmount;

	@FindBy(xpath = "//a[. = 'Department of Agriculture (USDA)']")
	public WebElement DepartmentofAgriculture;

	@FindBy(xpath = "//a [@class='agency-website']")
	public WebElement AgencyWebsiteButton;

	@FindBy(xpath = "//table//tbody//td[1]")
	public List<WebElement> agencyNameList;
	
	@FindBy(xpath = " //a[. = 'National Mediation Board (NMB)']")
	public WebElement NationalMeditationBoard;

	public void test() {

		int row = 0;
		for (int i = 0; i < AgencyNames.size(); i++) {
			if (AgencyNames.get(i).getText().contains("Department of Housing and Urban Development (HUD)")) {
				row = i;
			}
		}
		System.out.println("row= " + row);

		System.out.println(AgencyAmount.get(row).getText());
	}

	public void clickButton(WebElement element1) {// Bobur
		element1.click();
	}

	public boolean isTitle(String title) {
		return driver.getTitle().equals(title);

	}

	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);

	}

	public static void showPriceInUSD(long price) {
		long priceInUSD = price;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.printf("Price in USD : %s %n", currencyFormat.format(priceInUSD));
	}

	public void listToUpperCase() {
		 List<WebElement> list = agencyNameList;
		  for (WebElement name : list) {
		  name.getText().toUpperCase();
	 }
	}
	public void secondList() {
		
		List<String> listTwo = new ArrayList<>();
		String str = "";
		StringBuilder s = new StringBuilder("something");
		StringBuilder sTemp = new StringBuilder("something");
		
		for(int i=0; i<agencyNameList.size(); i++) {
			str = agencyNameList.get(i).toString();
			searchBox.sendKeys(str);
			
			for(int k=0; k<listTwo.size(); k++) {
//				listTwo = listTwo(k).add(agencyNameList.get(i).toString().toUpperCase());
//			s = replace(0,s.length()-1,agencyNameList.get(i).toString());
//			searchBox.sendKeys(agencyNameList.get(i)); //we need to type the agency names from the list into the Search Box
			}
		
		
		
//		for(int i=0; i<agencyNameList.size(); i++) {
//			searchBox.sendKeys(agencyNameList.get(i)); //we need to type the agency names from the list into the Search Box
//		}
		
		
		
		List<WebElement> list = agencyNameList;
		for (WebElement name : list) {
			name.getText().toUpperCase();
		}

	}
	}
	
}
