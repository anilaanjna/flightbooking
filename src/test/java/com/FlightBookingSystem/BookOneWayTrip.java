package com.FlightBookingSystem;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FlightBookingSystem.GenricLib.BrowserUtilities;
import com.FlightBookingSystem.GenricLib.Properties;
import com.FlightBookingSystem.GenricLib.WaitUtilities;
import com.FlightBookingSystem.ObjectRepository.FlightBookingObject;
import com.FlightBookingSystem.GenricLib.ExcelUtilities;
import com.FlightBookingSystem.GenricLib.Properties;

public class BookOneWayTrip extends BrowserUtilities {
	// Declare An Excel Work Book
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;

	// Launch the Browser and open project url.
	@BeforeClass // to launch browser only once
	public void launchBrowserTest() throws InterruptedException, IOException {

		workbook = new HSSFWorkbook();
		// create a new work sheet
		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		TestNGResults.put("1", new Object[] { "Test Step Id", "Action", "Expected Output", "Actual Output" });

		BrowserUtilities.getBrowser();
		/*
		 * BrowserUtilities.driver.manage().deleteAllCookies();
		 * BrowserUtilities.driver.manage().window().maximize();
		 */
		WaitUtilities.waitForPageToLoad();

		BrowserUtilities.driver.get(Properties.Flightbookingurl);

	}

	@Test()

	public void Tc_001() throws Exception {
		FlightBookingObject obj = PageFactory.initElements(BrowserUtilities.driver, FlightBookingObject.class);
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, 30);
		BrowserUtilities.driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

		ExcelUtilities.setExcelFile(Properties.pathTestData, Properties.fileTestData);

		obj.select_flight.click();

		obj.flight_tpye.click();

		// Thread.sleep(1000);

		obj.type_business.click();

		Thread.sleep(1000);

		obj.from_city.click();

		Thread.sleep(1000);
		obj.from_city_name.sendKeys(ExcelUtilities.getCellData(1, 1));

		obj.select_city.click();

		obj.to_city.click();

		obj.to_city_name.sendKeys(ExcelUtilities.getCellData(2, 1));

		Thread.sleep(1000);
		obj.select_city_to.click();

		Thread.sleep(1000);
		obj.calender.click();

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[9]/div/div/div[2]/div[24]")));

		System.out.println("Jun 22  " + element.isDisplayed());

		element.click();

		Thread.sleep(1000);
		obj.adult_add.click();

		obj.child_add.click();

		obj.child_add.click();

		Thread.sleep(1000);
		obj.search.click();

	}

	@AfterClass // to close browser in the end
	public void closeBrowser() {
		BrowserUtilities.driver.close();
	}
	

}
