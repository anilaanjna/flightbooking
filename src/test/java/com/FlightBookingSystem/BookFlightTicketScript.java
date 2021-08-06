package com.FlightBookingSystem;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.FlightBookingSystem.GenricLib.BrowserUtilities;
import com.FlightBookingSystem.GenricLib.ExcelUtilities;
import com.FlightBookingSystem.GenricLib.Properties;
import com.FlightBookingSystem.GenricLib.WaitUtilities;
import com.FlightBookingSystem.ObjectRepository.FlightBookingObject;

public class BookFlightTicketScript extends BrowserUtilities {
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

		WaitUtilities.waitForPageToLoad();

		BrowserUtilities.driver.get(Properties.makemytrip);

	}

	@Test(priority = 1)
	public void selectFlight() {

		FlightBookingObject flightBookingObject = new FlightBookingObject(driver);
		flightBookingObject.removePopUp();
		flightBookingObject.selectFromCity();
		flightBookingObject.selectToCity();

		String actFromCity = flightBookingObject.getFromCity();
		String expFromCity = "Mumbai";
		String actToCity = flightBookingObject.getToCity();
		String expToCity = "Delhi";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actFromCity, expFromCity, "Verify that From City is correct.");
		sa.assertEquals(actToCity, expToCity, "Verify that To City is correct.");
		sa.assertAll();

	}

	@Test(priority = 2)
	public void selectDate() {
		FlightBookingObject flightBookingObject = new FlightBookingObject(driver);

		LocalDate currentdate = LocalDate.now();
		currentdate.getDayOfMonth();

		int todaysDate = currentdate.getDayOfMonth();
		int preDate = todaysDate - 1;
		// int nextDate = todaysDate+1;

		String actPreviousDateStatus = flightBookingObject.getPreviousDateStatus(preDate);
		String expPreviousDateStatus = "true";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actPreviousDateStatus, expPreviousDateStatus, "Previous date is disabled for start date");

		flightBookingObject.selectDate(todaysDate + 1);

		flightBookingObject.selectReturn();

		String actReturnDateStatus = flightBookingObject.getPreviousDateStatusForEndDate(preDate - 1);
		String expReturnDateStatus = "true";

		sa.assertEquals(actReturnDateStatus, expReturnDateStatus, "Previous date is disabled for end date");
		flightBookingObject.selectDate(todaysDate + 1);

		sa.assertAll();
	}

	@Test(priority = 3)
	public void selectTravellerAndClass() {

		FlightBookingObject flightBookingObject = new FlightBookingObject(driver);
		flightBookingObject.selectTravellersAndClass();

		String actTravellercount = flightBookingObject.getTravellerCount();
		String expTravellercount = "4 Travellers";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actTravellercount, expTravellercount, "Travellers Count showing correct");

		String actBusinessType = flightBookingObject.getTravellClass();
		String expBusinessType = "Business";
		sa.assertEquals(actBusinessType, expBusinessType, "Travell class is selected as Business type");

		sa.assertAll();

	}

	@Test(priority = 4)
	public void validatesearchResult() {

		FlightBookingObject flightBookingObject = new FlightBookingObject(driver);
		flightBookingObject.clickOnSearch();

		String actFromCity = flightBookingObject.getFromCityNameonSerachPage();
		String expTFromCity = "Mumbai, India";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actFromCity, expTFromCity, "From City is same as showing on search Page");

		String actToCity = flightBookingObject.getToCityNameOnSerachPage();
		String expTToCity = "Delhi, India";

		sa.assertEquals(actToCity, expTToCity, "To City is same as showing on search Page");
		sa.assertAll();
	}

	@Test(priority = 5)
	public void setPriceAndAirlineinExcel() throws Exception {
		ExcelUtilities.setExcelFile(Properties.pathTestData, Properties.fileTestData);

		FlightBookingObject flightBookingObject = new FlightBookingObject(driver);

		List<String> flightPriceList = flightBookingObject.getFlightPrice();

		List<String> airlineList = flightBookingObject.getAirlineList();

		int i = 1;

		for (String str : flightPriceList) {

			ExcelUtilities.setCellData(str, i, 0);
			i++;

		}

		int j = 1;
		for (String str : airlineList) {
			ExcelUtilities.setCellData(str, j, 1);
			j++;
		}

	}
	
	@Test(priority = 6)
	public void moveSlider() throws Exception {
	
		FlightBookingObject flightBookingObject = new FlightBookingObject(driver);
        flightBookingObject.handleSlider();
    
        ExcelUtilities.setExcelFile(Properties.pathTestData, Properties.fileTestData);


		List<String> flightPriceList = flightBookingObject.getFlightPrice();

		List<String> airlineList = flightBookingObject.getAirlineList();

		int i = 1;

		for (String str : flightPriceList) {

			ExcelUtilities.setCellData(str, i, 3);
			i++;

		}

		int j = 1;
		for (String str : airlineList) {
			ExcelUtilities.setCellData(str, j, 4);
			j++;
		}
        
		}
	

	@AfterClass
	public void closeBrowser() {
		BrowserUtilities.driver.close();

	}
	

}
