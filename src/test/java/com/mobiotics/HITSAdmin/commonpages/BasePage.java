package com.mobiotics.HITSAdmin.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.mobiotics.HITSAdmin.constants.AutomationConstants;
import com.mobiotics.HITSAdmin.constants.BaseTest;

import generics.Property;

public class BasePage {
	
	public Logger log=Logger.getLogger(this.getClass());
	public WebDriver driver;
	public String configFile;
	public long timeout;
	
	public BasePage() {
		this.driver=BaseTest.driver;
		configFile=AutomationConstants.CONFIG_PATH+AutomationConstants.CONFIG_FILE;
		timeout=Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));
		
	}
	
	public  void waitTillElementIsVisible(WebElement element)
	{
		
		 new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
	}
	
	 public void waitTillElementIsClickable(WebElement element)
		{
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		}
	 
	 public void verifyURLis(String expectedUrl)
		{
			new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(expectedUrl));
			
		}
		 public boolean verifyURLhas(String expectedURL) {
			 return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(expectedURL));
			 
		 }
	 
	 public void moveToElement(WebElement element) {
		 Actions actions=new Actions(driver);
		 actions.moveToElement(element).perform();
	 }

}
