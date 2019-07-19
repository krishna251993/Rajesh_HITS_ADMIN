package com.mobiotics.HITSAdmin.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.mobiotics.HITSAdmin.constants.AutomationConstants;
import com.mobiotics.HITSAdmin.constants.BaseTest;

import generics.Property;

public class BasePage {

	public Logger log = Logger.getLogger(this.getClass());
	public WebDriver driver;
	public String configFile;
	public long timeout;

	public BasePage() {
		this.driver = BaseTest.driver;
		configFile = AutomationConstants.CONFIG_PATH + AutomationConstants.CONFIG_FILE;
		timeout = Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));

	}

	public void waitTillElementIsVisible(WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));

	}

	public void waitTillElementIsClickable(WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void verifyURLis(String expectedUrl) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(expectedUrl));
	}

	public boolean verifyURLhas(String expectedURL) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(expectedURL));

	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void selectElement(WebElement element, String text) {
		Select elementList = new Select(element);
		elementList.selectByVisibleText(text);
	}

	public int countNoOfMessages(List<WebElement> elementList) {
		return elementList.size();
	}

	public void waitForElementPresence(String xpathExpression) {
		new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
	}

	public void waitForVisibiltyOfListOfElements(List<WebElement> elementList) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(elementList));
	}

	public void waitTillElementContainsText(WebElement element, String text) {

		new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementValue(element, text));

	}

	public int countNoOfRecords(List<WebElement> elementList, WebElement nextLink, WebElement previousLink) throws InterruptedException {
		int count = elementList.size();
		try {
			while (nextLink.isEnabled()) {
				nextLink.click();
				Thread.sleep(4000);
				waitForVisibiltyOfListOfElements(elementList);
				count = count + elementList.size();

			}
		} catch (Exception e) {
			return count;
		}
		
		while(previousLink.isEnabled())
		{
			previousLink.click();
			Thread.sleep(5000);
			waitForVisibiltyOfListOfElements(elementList);
		}
		
		return count;
	}

	public boolean verifyDataDusplaying(List<WebElement> elementList, String elementValue) {
		for (int i = 0; i < elementList.size(); i++) {
			if (!(elementList.get(i).getText().equalsIgnoreCase(elementValue))) {
				return false;
			}

		}
		return true;
	}

	public int verifyDataDusplaying(List<WebElement> elementList, String dataExp, WebElement nextBtn, WebElement previousLink) throws InterruptedException {
		int count = 0;
		for (int i = 0; i < elementList.size(); i++) {
			Thread.sleep(500);
			count++;
			String dataAct = elementList.get(i).getText();
			if (!(dataAct.equalsIgnoreCase(dataExp))) {
				System.out.println(dataExp+" is expected but found "+dataAct+" in row number "+count+1);
				return count;

			}
		
			try {
				if ((i == (elementList.size() - 1) ) && (nextBtn.isEnabled())) {

					nextBtn.click();
					Thread.sleep(5000);
					i = -1;
				}
			} catch (Exception e) {
				return count;
			}

		}
		
		while(previousLink.isEnabled())
		{
			previousLink.click();
			Thread.sleep(5000);
		}
		
		return count;
	}


	public void searchByTextFilter(WebElement txtFldElement, WebElement goBtn, String value)
	{
		txtFldElement.sendKeys(value);
		waitTillElementIsClickable(goBtn);
		goBtn.click();
	}
	
	public void clearTextFilter(WebElement txtFldElement, WebElement goBtn)
	{
		txtFldElement.clear();
		waitTillElementIsClickable(goBtn);
		goBtn.click();
	}
	
	public void downloadReport(WebElement downloadBtn)
	{
		waitTillElementIsClickable(downloadBtn);
		downloadBtn.click();
		try
		{
			Runtime run = Runtime.getRuntime();
			run.exec(System.getProperty("user.dir")+"\\exeFiles\\saveReport.exe");
		}
		catch (Exception e) {
			
		}
	}
	
}
