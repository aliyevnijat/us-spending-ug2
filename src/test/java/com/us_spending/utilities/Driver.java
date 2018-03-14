package com.us_spending.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		if (browser == null) {
			browser = Configuration.getProperties("browser");
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			default:
				break;
			}
		}
		return driver;
	}

	public static void driverQuit() {
		driver.quit();
	}
}
