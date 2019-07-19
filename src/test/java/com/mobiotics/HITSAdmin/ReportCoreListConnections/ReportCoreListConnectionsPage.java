package com.mobiotics.HITSAdmin.ReportCoreListConnections;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.ReportCoreListCustomer.ReportCoreListCustomerPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreListConnectionsPage extends ReportUtilityClass{
	
	public ReportCoreListConnectionsPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListConnectionsPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Connection List')]")
	private WebElement pageTitleTxt;
	
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
	
	@FindBy(id = "refresh")
	private WebElement goDateBtn;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtnLink;
	
	@FindBy(xpath = "//button[text()='Prev']")
	private WebElement previousLink;
	
	@FindBy(xpath = "//div[text()='Count : ']/span")
	private WebElement countValueNumber;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;
	
	@FindBy(name = "customerid")
	private WebElement customerIdTxtFld;
	
	@FindBy(xpath = "//input[@name='customerid']/following-sibling::button")
	private WebElement customerIdGoBtn;
	
	@FindBy(name = "productname")
	private WebElement productNameTxtFld;
	
	@FindBy(xpath = "//input[@name='productname']/following-sibling::button")
	private WebElement productNameGoBtn;
	
	@FindBy(id = "connectiontype")
	private WebElement connectionTypeList;
	
	@FindBy(id = "connectionstatus")
	private WebElement connectionStatusList;
	
	@FindBy(id = "producttype")
	private WebElement productTypeList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[4]")
	private List<WebElement> customerIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement productNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> productNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement connectionTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-2]")
	private List<WebElement> connectionTypeDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement connectionStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private List<WebElement> connectionStatusDisplayingList;
	
	@FindBy(xpath = "//button[contains(text(), 'Connection Download')]")
	private WebElement connectionDownloadBtn;
	

	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Connection List", "Page Title is not correct.");
		Assert.assertEquals(pageTitleTxt.isDisplayed(), true, "Not displaying Correct Page Heading");
		logger.info(pageTitleTxt.getText()+" page is displaying.");
	}
	
	public void selectDates(String fromDate) throws InterruptedException
	{
		waitTillElementIsClickable(fromDateCal);
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
	
	public int verifyCount() throws InterruptedException
	{
		String countDisplayingNo = countValueNumber.getText();
		logger.info("Count displaying: "+countDisplayingNo);
		int noOfRecords = countNoOfRecords(listOfRecords, nextBtnLink, previousLink);
		logger.info("Number of records displaying are:  "+noOfRecords);
		assertEquals(Integer.parseInt(countDisplayingNo), noOfRecords, "Count is displaying wrong number");
		return noOfRecords;
	}
	
	public void searchByCustomerId(String customerId)
	{
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}
	public void clearCustomerIdFilter()
	{
		clearTextFilter(customerIdTxtFld, customerIdGoBtn);
	}
	
	public void searchByProductName(String productName) throws InterruptedException
	{
		searchByTextFilter(productNameTxtFld, productNameGoBtn, productName);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Connection with the Product Name "+productName);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Product Name", productNameDisplayingList, productName, nextBtnLink, previousLink);
		clearProductNameFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearProductNameFilter()
	{
		clearTextFilter(productNameTxtFld, productNameGoBtn);
	}
	
	public void searchByConnectionType(String connectionType) throws InterruptedException
	{
		selectElement(connectionTypeList, connectionType);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Connection of type "+connectionType);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Connection Type", connectionTypeDisplayingList, connectionType, nextBtnLink, previousLink);
		clearConnectionTypeFilter();
		Thread.sleep(5000);
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearConnectionTypeFilter()
	{
		selectElement(connectionTypeList, "ALL");
	}
	
	public void searchByconnectionStatus(String connectionStatus) throws InterruptedException
	{
		selectElement(connectionStatusList, connectionStatus);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Connection with the status "+connectionStatus);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Connection Status", connectionStatusDisplayingList, connectionStatus, nextBtnLink, previousLink);
		clearconnectionStatus();
		Thread.sleep(5000);
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearconnectionStatus()
	{
		selectElement(connectionStatusList, "ALL");
	}
	
	public void verifySearch(String filterName, List<WebElement> elementList, String dataExp, WebElement nextLink, WebElement previousLink) throws InterruptedException
	{
		Thread.sleep(2000);
		int noOfElements = verifyCount();
		int verifyRowNo = verifyDataDusplaying(elementList, dataExp, nextLink, previousLink);
		
		if(noOfElements != verifyRowNo)
		{
			logger.info("========================================================");
			logger.info("Functional Test Case for "+  filterName +" filter is failed");
			logger.info(filterName + " is displaying wrong in Row Number "+verifyRowNo);
			logger.info("========================================================");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("========================================================");
			logger.info("Functional test case for "+filterName+ " filter test case is passed.");
			logger.info("========================================================");
		}
	}
	
	public boolean verifyData()
	{
		waitTillElementIsVisible(firstRow);
		String firstRowData = firstRow.getText();
		if(firstRowData.contains("No Data Found"))
		{
			logger.info(firstRow.getText());
			return true;
		}
		return false;
	}
	
	public void testReportCoreListConnections() throws InterruptedException
	{
			verifyPage();
			selectDates("15-06-2019");
			Thread.sleep(7000);
			if(verifyData()) 
			{
				logger.info("There is no Connection details available in the selected table within the selected timeline");
				return;
			}
			//verifyCount();//bug-------
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 10, path);
			searchByCustomerId(customerId);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				return;
			}
			
			String productName = productNameDisplaying.getText();
			String connectionType = connectionTypeDisplaying.getText();
			String connectionStatus = connectionStatusDisplaying.getText();
			
			waitForVisibiltyOfListOfElements(customerIdDisplayingList);
			verifySearch("Customer Id", customerIdDisplayingList, customerId, nextBtnLink, previousLink);
			clearCustomerIdFilter();
			Thread.sleep(5000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchByProductName(productName);
			
			searchByConnectionType(connectionType);
			
			searchByconnectionStatus(connectionStatus);
			
			
			//verifyCount();//bug--------
			
			downloadReport(connectionDownloadBtn);
			Thread.sleep(5000);	
		}
		
}
