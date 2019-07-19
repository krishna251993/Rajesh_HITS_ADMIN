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
	
	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "//div[@data-name='end']//table/tbody/tr[";
	private static String toDateXp2 = "]/td[";

	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//div[@data-name='start']//i[@class='glyphicon glyphicon-calendar']")
	private WebElement fromDateCal;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='start']//th[@class='year']//a[@class='previous']/i")
	private WebElement previousShftYearFromDate;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='start']//th[@class='year']//a[@class='next']/i")
	private WebElement nextShftYearFromDate;

	@FindBy(xpath = "//div[@data-name='start']//th[@class='year']/span")
	private WebElement fromDateYear;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='start']//th[@class='month']//a[@class='previous']/i")
	private WebElement previousShftMonthFromDate;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='start']//th[@class='month']//a[@class='next']/i")
	private WebElement nextShftMonthFromDate;

	@FindBy(xpath = "//div[@data-name='start']//th[@class='month']/span")
	private WebElement fromDateMonth;

	@FindBy(xpath = "//div[@data-name='end']//i[@class='glyphicon glyphicon-calendar']")
	private WebElement toDateCal;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='end']//th[@class='year']//a[@class='previous']/i")
	private WebElement previousShftYearToDate;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='end']//th[@class='year']//a[@class='next']/i")
	private WebElement nextShftYearToDate;

	@FindBy(xpath = "//div[@data-name='end']//th[@class='year']/span")
	private WebElement toDateYear;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='end']//th[@class='month']//a[@class='previous']/i")
	private WebElement previousShftMonthToDate;

	@FindBy(xpath = "//div[@class='form-inline']//div[@data-name='end']//th[@class='month']//a[@class='next']/i")
	private WebElement nextShftMonthToDate;

	@FindBy(xpath = "//div[@data-name='end']//th[@class='month']/span")
	private WebElement toDateMonth;

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
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr//td[2]")
	private List<WebElement> msoUserNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]//td[2]")
	private WebElement msoUserNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement msoFirstNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> msoFirstNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[8]")
	private WebElement msoBigCityDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[8]")
	private List<WebElement> msoBigCityDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement msoStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-3]")
	private List<WebElement> msoStatusDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtnLink;
	
	@FindBy(xpath = "//li[@class='prev']/button")
	private WebElement previousLink;

	
	String firstRowData;
	
	public void selectDates(String fromDate, String toDate) throws InterruptedException {
		waitTillElementIsClickable(fromDateCal);
		fromDateCal.click();
		String fromDateArr[] = fromDate.split("-");
		String toDateArr[] = toDate.split("-");
		waitTillElementIsClickable(previousShftYearFromDate);
		dh.selectYear(previousShftYearFromDate, nextShftYearFromDate, Integer.parseInt(fromDateYear.getText()),
				Integer.parseInt(fromDateArr[2]));
		Thread.sleep(1000);
		waitTillElementIsClickable(previousShftMonthFromDate);
		dh.selectMonth(previousShftMonthFromDate, nextShftMonthFromDate, fromDateMonth.getText(),
				Integer.parseInt(fromDateArr[1]));
		Thread.sleep(1000);
		dh.selectDate(fromDateXp1, fromDateXp2, Integer.parseInt(fromDateArr[0]));
		Thread.sleep(1000);

		waitTillElementIsClickable(toDateCal);
		toDateCal.click();
		waitTillElementIsClickable(nextShftYearToDate);
		dh.selectYear(previousShftYearToDate, nextShftYearToDate, Integer.parseInt(toDateYear.getText()),
				Integer.parseInt(toDateArr[2]));
		Thread.sleep(3000);
		waitTillElementIsClickable(nextShftMonthToDate);
		dh.selectMonth(previousShftMonthToDate, nextShftMonthToDate, toDateMonth.getText(),
				Integer.parseInt(toDateArr[1]));
		Thread.sleep(1000);
		dh.selectDate(toDateXp1, toDateXp2, Integer.parseInt(toDateArr[0]));
		Thread.sleep(1000);
		waitTillElementIsClickable(goDateBtn);
		goDateBtn.click();

	}

	
	
	public int verifyCount() throws InterruptedException
	{
		String countDisplayingNo = countValueNumber.getText();
		logger.info("Count displaying: "+countDisplayingNo);
		int noOfRecords = countNoOfRecords(listOfRecords, nextBtnLink, previousLink);
		logger.info("Number of records displaying are: "+noOfRecords);
		assertEquals(Integer.parseInt(countDisplayingNo), noOfRecords, "Count is displaying wrong number");
		return noOfRecords;
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
	
	public void clearUserNameTextFilter()
	{
		clearTextFilter(msoUserNameTxtFld, msoUserNameGoBtn);
	}
	
	public void searchByFirstName(String firstName) throws InterruptedException
	{
		logger.info("MSO FirstName entered is: "+firstName);
		msoFirstNameTxtFld.sendKeys(firstName);
		waitTillElementIsClickable(msoFirstNameGoBtn);
		msoFirstNameGoBtn.click();
		Thread.sleep(2000);
	}
	public void clearFirstrNameTextFilter()
	{
		clearTextFilter(msoFirstNameTxtFld, msoFirstNameGoBtn);
	}
	
	public void searchByBigCity(String bigCity) throws InterruptedException
	{
		logger.info("MSO BigCity entered is: "+bigCity);
		bigCityTxtFld.sendKeys(bigCity);
		waitTillElementIsClickable(bigCityGoBtn);
		bigCityGoBtn.click();
		Thread.sleep(2000);
	}
	public void clearBigCityTextFilter()
	{
		clearTextFilter(bigCityTxtFld, bigCityGoBtn);
	}
	
	public void searchByMSOStatus(String status) throws InterruptedException
	{
		logger.info("MSO status selected is: "+status);
		Select msoStatus = new Select(msoStatusDropDown);
		msoStatus.selectByVisibleText(status);
		Thread.sleep(2000);
		
	}
	public void clearMSOStatusFilter()
	{
		selectElement(msoStatusDropDown, "ALL");
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
	
	
	public void verifySearch(String filterName, List<WebElement> elementList, String dataExp, WebElement nextLink,
			WebElement previousLink) throws InterruptedException {
		Thread.sleep(2000);
		int noOfElements = countNoOfRecords(elementList, nextLink, previousLink);
		logger.info("Number of records present for this " + filterName + " are: " + noOfElements);
		int verifyRowNo = verifyDataDusplaying(elementList, dataExp, nextLink, previousLink);

		if (noOfElements != verifyRowNo) {
			logger.info("========================================================");
			logger.info("Functional Test Case for " + filterName + " filter is failed");
			logger.info(filterName + " is displaying wrong in Row Number " + verifyRowNo);
			logger.info("========================================================");
			Assert.assertTrue(false);
		} else {
			logger.info("========================================================");
			logger.info("Functional test case for " + filterName + " filter test case is passed.");
			logger.info("========================================================");
		}
	}
	
	
	public void testOperators_MSO() throws InterruptedException, IOException
	{
		Assert.assertEquals(driver.getTitle(), "MSO List", "This is not MSO List Page.");
		selectDates("01-01-2015", "01-01-2019");
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No MSO is created within the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifyCount();
		
		String msoUserName = DemoExcelLibrary3.getexcelData("hits admin data", 1, 1, path);
		
		searchByUserName(msoUserName);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No MSO is with the user name "+msoUserName+" in the selected timeline.");
			return;
		}
		
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		String msoFirstName = msoFirstNameDisplaying.getText();
		String msoBigCity = msoBigCityDisplaying.getText();
		String msoStatus = msoStatusDisplaying.getText();
		
		verifySearch("MSO User Name", msoUserNameDisplayingList, msoUserName, nextBtnLink, previousLink);
		clearUserNameTextFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		searchByFirstName(msoFirstName);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No MSO is with the first name "+msoFirstName+" in the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("First Name", msoFirstNameDisplayingList, msoFirstName, nextBtnLink, previousLink);
		clearFirstrNameTextFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		searchByBigCity(msoBigCity);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No LCO is with the Big City "+msoBigCity+" in the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Big City", msoBigCityDisplayingList, msoBigCity, nextBtnLink, previousLink);
		clearBigCityTextFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);

		
		searchByMSOStatus(msoStatus);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No MSO  with the Status "+msoStatus+" in the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("MSO Status", msoStatusDisplayingList, msoStatus, nextBtnLink, previousLink);
		clearMSOStatusFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		downloadReport(msoDownloadBtn);
		
		Thread.sleep(5000);
				
	}
	
	

}
