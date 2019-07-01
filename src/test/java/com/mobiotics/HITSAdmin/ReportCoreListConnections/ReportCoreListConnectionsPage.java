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

	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Connection List')]")
	private WebElement pageTitleTxt;
	
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
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtnLink;
	
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
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement productNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement connectionTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement connectionStatusDisplaying;
	
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
	
	public void verifyCount()
	{
		String countDisplayingNo = countValueNumber.getText();
		logger.info("Count displaying: "+countDisplayingNo);
		int noOfRecords = countNoOfRecords(listOfRecords, nextBtnLink);
		logger.info("Number of records displaying are: "+noOfRecords);
		assertEquals(Integer.parseInt(countDisplayingNo), noOfRecords, "Count is displaying wrong number");
	}
	
	public void searchByCustomerId(String customerId)
	{
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}
	
	public void searchByProductName(String productName)
	{
		searchByTextFilter(productNameTxtFld, productNameGoBtn, productName);
	}
	
	public void searchByConnectionType(String connectionType)
	{
		selectElement(connectionTypeList, connectionType);
	}
	
	public void searchByconnectionStatus(String connectionStatus)
	{
		selectElement(connectionStatusList, connectionStatus);
	}
	
	public void verifySearch(WebElement elementDisplaying, String enteredData, String filterName)
	{
		logger.info(filterName+" entered is: "+enteredData);
		logger.info(filterName+" is displaying is "+elementDisplaying.getText());
		Assert.assertEquals(elementDisplaying.getText(), enteredData, filterName+" entered and "+filterName+" is displaying are not same.");
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
			selectDates("01-04-2019");
			Thread.sleep(7000);
			if(verifyData()) 
			{
				logger.info("Thre is no Connection details available in the selected table within the selected timeline");
				return;
			}
			//verifyCount();//bug-------
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 11, path);
			searchByCustomerId(customerId);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				return;
			}
			verifySearch(customerIdDisplaying, customerId, "Customer Id");
			
			String productName = productNameDisplaying.getText();
			String connectionType = connectionTypeDisplaying.getText();
			String connectionStatus = connectionStatusDisplaying.getText();
			
			
			searchByProductName(productName);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Connection with the Product Name "+productName);
				return;
			}
			verifySearch(productNameDisplaying, productName, "Product Name");
			
			searchByConnectionType(connectionType);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Connection of type "+connectionType);
				return;
			}
			verifySearch(connectionTypeDisplaying, connectionType, "Connection Type");
			
			searchByconnectionStatus(connectionStatus);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Connection with the status "+connectionStatus);
				return;
			}
			verifySearch(connectionStatusDisplaying, connectionStatus, "Connection Status");
			
			//verifyCount();//bug--------
			
			downloadReport(connectionDownloadBtn);
			
			
			
			
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
	

}
