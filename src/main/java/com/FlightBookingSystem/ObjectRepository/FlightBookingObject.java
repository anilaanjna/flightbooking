package com.FlightBookingSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.FlightBookingSystem.GenricLib.BrowserUtilities;

public class FlightBookingObject {

	WebDriver driver;

	@Test
	public void FlightBookingObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(BrowserUtilities.driver, this);

	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a")

	public WebElement select_flight;

	@FindBy(how = How.XPATH, using = "//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]")

	public WebElement flight_tpye;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Business')]")

	public WebElement type_business;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/span[1]")

	public WebElement from_city;

	// sent city name in textbox
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div/input")

	public WebElement from_city_name;

	// Click on first city after serach
	@FindBy(how = How.XPATH, using = "//body/div[@id='select2-drop']/ul[1]/li[1]/div[1]")

	public WebElement select_city;

	// Click on city textbox
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_location_to\"]")

	public WebElement to_city;

	// sent city name in to textbox
	@FindBy(how = How.XPATH, using = "/html/body/div[8]/div/input")

	public WebElement to_city_name;
	
	//click on first result
	@FindBy(how = How.XPATH, using = "//body/div[@id='select2-drop']/ul[1]/li[1]/div[1]")

	public WebElement select_city_to;
	
	//Click on Calender 
	@FindBy(how = How.XPATH, using = "//input[@id='FlightsDateStart']")

	public WebElement calender;
	
	
    //select Date 22 une
	@FindBy(how = How.XPATH, using = "//body/div[@id='datepickers-container']/div[10]/div[1]/div[1]/div[2]/div[24]")

	public WebElement date_of_travel;
	
	//add adult
	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")

	public WebElement adult_add;
	
	//add 2 child
	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/button[1]")

	public WebElement child_add;
	
	//click on Search
	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[4]/button[1]")
	                                  
	public WebElement search;
}
