package com.FlightBookingSystem.GenricLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WaitUtilities {
	public static WebDriver driver;
	
	public static void waitForPageToLoad()
	{
		BrowserUtilities.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
	}
	
	
	public static void expWait_elementclick(WebDriver driver,By by){
		
	        try {
				(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
				driver.findElement(by).click();
			} catch (StaleElementReferenceException  ser) {
				// TODO Auto-generated catch block
				driver.findElement(by).click();
			}
	        catch (TimeoutException   toe) {
				//  test.log(logStatus.Error, "Element identified by " + by.toString() + " was not clickable after 10 seconds");
				
			}
	}
	
	public static void expWait_elementlocated(WebDriver driver,By by){
		
        try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).click();
		} catch (StaleElementReferenceException  ser) {
			// TODO Auto-generated catch block
			driver.findElement(by).click();
		}
        catch (TimeoutException   toe) {
			
		}
}

	
	public static void fluWait(WebDriver driver,By by){
		
        
        	FluentWait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS ).ignoring(NoSuchElementException.class);   
        	
	
}
	
	  

}