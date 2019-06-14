package com.mobiotics.HITSAdmin.operators_MSO;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;

public class OperatorsMSOPage extends BasePage{
	
	public OperatorsMSOPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger=Logger.getLogger(OperatorsMSOPage.class);
	
	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div[1]/div/div[1]/div[2]/table/tbody/tr[";
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
	private WebElement msoUserNameTxtFld;
	
	@FindBy(xpath = "//input[@name='username']/following-sibling::button")
	private WebElement msoUserNameGoBtn;
	
	@FindBy(name = "firstname")
	private WebElement msoFirstNameTxtFld;
	
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::button")
	private WebElement msoFirstNameGoBtn;
	
	@FindBy(name = "bigcity")
	private WebElement bigCityTxtFld;
	
	@FindBy(xpath = "//input[@name='bigcity']/following-sibling::button")
	private WebElement bigCityGoBtn;
	
	@FindBy(id = "msostatus")
	private WebElement msoStatusDropDown;
	
	@FindBy(id = "registered")
	private WebElement registerationStatusDropDown;
	
	@FindBy(xpath = "//div[text()='Count : ']/span")
	private WebElement countValueNumber;
	
	@FindBy(xpath = "//button[text()='MSO Download']")
	private WebElement msoDownloadBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]//td[2]")
	private WebElement msoUserNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement msoFirstNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[8]")
	private WebElement msoBigCityDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement msoStatusDisplaying;
	
	String firstRowData;
	
	public void selectDates(String fromDate) throws InterruptedException
	{
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
		logger.info("MSO username entered is: "+userName);
		msoUserNameTxtFld.sendKeys(userName);
		waitTillElementIsClickable(msoUserNameGoBtn);
		msoUserNameGoBtn.click();
		Thread.sleep(5000);
		waitTillElementIsVisible(listOfRecords.get(0));
	}
	
	public void searchByFirstName(String firstName) throws InterruptedException
	{
		logger.info("MSO FirstName entered is: "+firstName);
		msoFirstNameTxtFld.sendKeys(firstName);
		waitTillElementIsClickable(msoFirstNameGoBtn);
		msoFirstNameGoBtn.click();
		Thread.sleep(2000);
	}
	
	public void searchByBigCity(String bigCity) throws InterruptedException
	{
		logger.info("MSO BigCity entered is: "+bigCity);
		bigCityTxtFld.sendKeys(bigCity);
		waitTillElementIsClickable(bigCityGoBtn);
		bigCityGoBtn.click();
		Thread.sleep(2000);
	}
	
	public void searchByMSOStatus(String status) throws InterruptedException
	{
		logger.info("MSO status selected is: "+status);
		Select msoStatus = new Select(msoStatusDropDown);
		msoStatus.selectByVisibleText(status);
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
	
	
	public void testOperators_MSO() throws InterruptedException, IOException
	{
		selectDates("01-01-2016");
		Thread.sleep(5000);
		
		if(verifyDataIsPresent())
		{
			return;
		}
		verifyCount();
		
		String msoUserName = DemoExcelLibrary3.getexcelData("hits admin data", 1, 1, path);
		searchByUserName(msoUserName);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(msoUserNameDisplaying.getText(), msoUserName, "MSO username entered and MSO username displaying are not same");
		String msoFirstName = msoFirstNameDisplaying.getText();
		String msoBigCity = msoBigCityDisplaying.getText();
		String msoStatus = msoStatusDisplaying.getText();
		
		
		searchByFirstName(msoFirstName);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(msoFirstName, msoFirstNameDisplaying.getText(), "MSO firstname entered and MSO firstname displaying are not same");
		
		
		searchByBigCity(msoBigCity);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(msoBigCity, msoBigCityDisplaying.getText(), "MSO Big City entered and MSO Big City displaying are not same");
		
		
		searchByMSOStatus(msoStatus);
		waitTillElementIsVisible(listOfRecords.get(0));
		if(verifyDataIsPresent())
		{
			return;
		}
		Assert.assertEquals(msoStatus, msoStatusDisplaying.getText(), "MSO Big City entered and MSO Big City displaying are not same");
		
		verifyCount();
		logger.info(listOfRecords.get(0).getText());
		msoDownloadBtn.click();
		try
		{
			Runtime run = Runtime.getRuntime();
			run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		}
		catch (Exception e) {
			
		}
		
		
				
	}
	
	

}
