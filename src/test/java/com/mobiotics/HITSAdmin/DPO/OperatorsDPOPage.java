package com.mobiotics.HITSAdmin.DPO;

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

public class OperatorsDPOPage extends BasePage{
	
	
	
	public OperatorsDPOPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger=Logger.getLogger(OperatorsDPOPage.class);
	
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
	private WebElement dpoUserNameTxtFld;
	
	@FindBy(xpath = "//input[@name='username']/following-sibling::button")
	private WebElement dpoUserNameGoBtn;
	
	@FindBy(name = "firstname")
	private WebElement dpoFirstNameTxtFld;
	
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::button")
	private WebElement dpoFirstNameGoBtn;
	
	@FindBy(name = "bigcity")
	private WebElement bigCityTxtFld;
	
	@FindBy(xpath = "//input[@name='bigcity']/following-sibling::button")
	private WebElement bigCityGoBtn;
	
	@FindBy(id = "lcostatus")
	private WebElement dpoStatusDropDown;
	
	@FindBy(id = "registered")
	private WebElement registerationStatusDropDown;
	
	@FindBy(xpath = "//div[text()='Count : ']/span")
	private WebElement countValueNumber;
	
	@FindBy(xpath = "//button[text()='DPO Download']")
	private WebElement dpoDownloadBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]//td[2]")
	private WebElement dpoUserNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr//td[2]")
	private List<WebElement> dpoUserNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement dpoFirstNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> dpoFirstNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[8]")
	private WebElement dpoBigCityDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[8]")
	private List<WebElement> dpoBigCityDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement dpoStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private List<WebElement> dpoStatusDisplayingList;
	
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
		logger.info("DPO username entered is: "+userName);
		dpoUserNameTxtFld.sendKeys(userName);
		waitTillElementIsClickable(dpoUserNameGoBtn);
		dpoUserNameGoBtn.click();
		Thread.sleep(5000);
		waitTillElementIsVisible(listOfRecords.get(0));
	}
	public void clearUserNameTextFilter()
	{
		clearTextFilter(dpoUserNameTxtFld, dpoUserNameGoBtn);
	}
	
	public void searchByFirstName(String firstName) throws InterruptedException
	{
		logger.info("DPO FirstName entered is: "+firstName);
		dpoFirstNameTxtFld.sendKeys(firstName);
		waitTillElementIsClickable(dpoFirstNameGoBtn);
		dpoFirstNameGoBtn.click();
		Thread.sleep(2000);
	}
	public void clearFirstrNameTextFilter()
	{
		clearTextFilter(dpoFirstNameTxtFld, dpoFirstNameGoBtn);
	}
	
	public void searchByBigCity(String bigCity) throws InterruptedException
	{
		logger.info("DPO BigCity entered is: "+bigCity);
		bigCityTxtFld.sendKeys(bigCity);
		waitTillElementIsClickable(bigCityGoBtn);
		bigCityGoBtn.click();
		Thread.sleep(2000);
	}
	public void clearBigCityTextFilter()
	{
		clearTextFilter(bigCityTxtFld, bigCityGoBtn);
	}
	
	public void searchByDPOStatus(String status) throws InterruptedException
	{
		logger.info("DPO status selected is: "+status);
		Select dpoStatus = new Select(dpoStatusDropDown);
		dpoStatus.selectByVisibleText(status);
		Thread.sleep(2000);
		
	}
	public void clearLCOStatusFilter()
	{
		selectElement(dpoStatusDropDown, "ALL");
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
	
	
	public void testOperators_DPO() throws InterruptedException, IOException
	{
		Assert.assertEquals(driver.getTitle(), "DPO List", "This is not DPO List Page.");
		
		selectDates("01-01-2015", "01-01-2019");
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No DPO is created within the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifyCount();
		
		String dpoUserName = DemoExcelLibrary3.getexcelData("hits admin data", 1, 2, path);
		
		searchByUserName(dpoUserName);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No DPO is with the user name "+dpoUserName+" in the selected timeline.");
			return;
		}
		
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		String dpoFirstName = dpoFirstNameDisplaying.getText().trim();
		String dpoBigCity = dpoBigCityDisplaying.getText().trim();
		String dpoStatus = dpoStatusDisplaying.getText();
		
		verifySearch("DPO User Name", dpoUserNameDisplayingList, dpoUserName, nextBtnLink, previousLink);
		clearUserNameTextFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		searchByFirstName(dpoFirstName);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No DPO is with the first name "+dpoFirstName+" in the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("First Name", dpoFirstNameDisplayingList, dpoFirstName, nextBtnLink, previousLink);
		clearFirstrNameTextFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		
		searchByBigCity(dpoBigCity);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No DPO is with the Big City "+dpoBigCity+" in the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Big City", dpoBigCityDisplayingList, dpoBigCity, nextBtnLink, previousLink);
		clearBigCityTextFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		searchByDPOStatus(dpoStatus);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if(verifyDataIsPresent())
		{
			logger.info("No DPO  with the Status "+dpoStatus+" in the selected timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("DPO Status", dpoStatusDisplayingList, dpoStatus, nextBtnLink, previousLink);
		clearLCOStatusFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		downloadReport(dpoDownloadBtn);
		
		Thread.sleep(5000);
				
	}
	
	
	
	
	
	
	

}
