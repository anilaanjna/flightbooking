package com.FlightBookingSystem.GenricLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtilities {

	public static WebDriver driver;

	public static WebDriver getBrowser() throws IOException {
		
		 
		if (Properties.browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			WaitUtilities.waitForPageToLoad();
		}

		else if (Properties.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\SPOS_Automation\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			

		} else if (Properties.browser.equals("ie")) {

			
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			WaitUtilities.waitForPageToLoad();
		}

		return driver;

	}

}
