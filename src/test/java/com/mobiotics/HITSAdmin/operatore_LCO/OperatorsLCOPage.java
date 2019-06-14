package com.mobiotics.HITSAdmin.operatore_LCO;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;
import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;

public class OperatorsLCOPage extends BasePage{
	
	public OperatorsLCOPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger=Logger.getLogger(OperatorsLCOPage.class);
	
	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[2]")
	private WebElement previousShftYearFromDate;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[2]")
	private WebElement nextShftYearFromDate;
	
	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[2]")
	private WebElement fromDateYear;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement previousShftMonthFromDate;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nextShftMonthFromDate;
	
	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[1]")
	private WebElement fromDateMonth;
	
	@FindBy(id = "refresh")
	private WebElement goDateBtn;
	
	@FindBy(name = "username")
	private WebElement lcoUserNameTxtFld;
	
	@FindBy(xpath = "//input[@name='username']/following-sibling::button")
	private WebElement lcoUserNameGoBtn;
	
	@FindBy(name = "firstname")
	private WebElement lcoFirstNameTxtFld;
	
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::button")
	private WebElement lcoFirstNameGoBtn;
	
	@FindBy(name = "bigcity")
	private WebElement bigCityTxtFld;
	
	@FindBy(xpath = "//input[@name='bigcity']/following-sibling::button")
	private WebElement bigCityGoBtn;
	
	@FindBy(id = "lcostatus")
	private WebElement lcoStatusDropDown;
	
	@FindBy(id = "registered")
	private WebElement registerationStatusDropDown;
	
	@FindBy(xpath = "//div[text()='Count : ']/span")
	private WebElement countValueNumber;
	
	@FindBy(xpath = "//button[text()='LCO Download']")
	private WebElement lcoDownloadBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]//td[2]")
	private WebElement lcoUserNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement lcoFirstNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[8]")
	private WebElement lcoBigCityDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement lcoLCOStatusDisplaying;

	String firstRowData;
	
	public void selectDates(String fromDate) throws InterruptedException
	{
		//driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		fromDateCal.click();
		waitTillElementIsClickable(previousShftYearFromDate);
		String fromDateArr[] = fromDate.split("-");
		dh.selectYear(previousShftYearFromDate, nextShftYearFromDate, Integer.parseInt(fromDateYear.getText()), Integer.parseInt(fromDateArr[2]));
		waitTillElementIsClickable(previousShftMonthFromDate);
		dh.selectMonth(previousShftMonthFromDate, nextShftMonthFromDate, fromDateMonth.getText(), Integer.parseInt(fromDateArr[1]));
		Thread.sleep(1000);
		dh.selectDate(fromDateXp1, fromDateXp2, Integer.parseInt(fromDateArr[0]));
		goDateBtn.click();
		
	}
	
	
	public void verifyCount()
	{
		logger.info("Count displaying: "+countValueNumber.getText());
		logger.info("Number of records displaying are: "+listOfRecords.size());
		assertEquals(Integer.parseInt(countValueNumber.getText()), listOfRecords.size(), "Count is displaying wrong number");
	}

	public void searchByUserName(String userName) throws InterruptedException
	{
		logger.info("LCO username entered is: "+userName);
		lcoUserNameTxtFld.sendKeys(userName);
		waitTillElementIsClickable(lcoUserNameGoBtn);
		lcoUserNameGoBtn.click();
		Thread.sleep(5000);
		waitTillElementIsVisible(listOfRecords.get(0));
	}
	
	public void searchByFirstName(String firstName) throws InterruptedException
	{
		logger.info("LCO FirstName entered is: "+firstName);
		lcoFirstNameTxtFld.sendKeys(firstName);
		waitTillElementIsClickable(lcoFirstNameGoBtn);
		lcoFirstNameGoBtn.click();
		Thread.sleep(2000);
	}
	
	public void searchByBigCity(String bigCity) throws InterruptedException
	{
		logger.info("LCO BigCity entered is: "+bigCity);
		bigCityTxtFld.sendKeys(bigCity);
		waitTillElementIsClickable(bigCityGoBtn);
		bigCityGoBtn.click();
		Thread.sleep(2000);
	}
	
	public void searchByLCOStatus(String status) throws InterruptedException
	{
		logger.info("LCO status selected is: "+status);
		Select lcoStatus = new Select(lcoStatusDropDown);
		lcoStatus.selectByVisibleText(status);
		Thread.sleep(2000);
		
	}
	
	public boolean verifyDataIsPresent()
	{
		String firstRowData = listOfRecords.get(0).getText();
		if(firstRowData.equalsIgnoreCase("No Data Found"))
		{
			logger.info(firstRowData);
			return true;
		}
		return false;
		
	}
	
	public void testOperators_LCO() throws InterruptedException, IOException
	{
		selectDates("01-01-2017");
		Thread.sleep(5000);
		
		if(verifyDataIsPresent())
		{
			return;
		}
		verifyCount();
		
		String lcoUserName = DemoExcelLibrary3.getexcelData("hits admin data", 1, 0, path);
		searchByUserName(lcoUserName);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(lcoUserNameDisplaying.getText(), lcoUserName, "LCO username entered and LCO username displaying are not same");
		String lcoFirstName = lcoFirstNameDisplaying.getText();
		String lcoBigCity = lcoBigCityDisplaying.getText();
		String lcoStatus = lcoLCOStatusDisplaying.getText();
		
		
		searchByFirstName(lcoFirstName);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(lcoFirstName, lcoFirstNameDisplaying.getText(), "LCO firstname entered and LCO firstname displaying are not same");
		
		
		searchByBigCity(lcoBigCity);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(lcoBigCity, lcoBigCityDisplaying.getText(), "LCO Big City entered and LCO Big City displaying are not same");
		
		
		searchByLCOStatus(lcoStatus);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(lcoStatus, lcoLCOStatusDisplaying.getText(), "LCO Big City entered and LCO Big City displaying are not same");
		
		verifyCount();
		logger.info(listOfRecords.get(0).getText());
		lcoDownloadBtn.click();
		try
		{
			Runtime run = Runtime.getRuntime();
			run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		}
		catch (Exception e) {
			
		}
		
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
