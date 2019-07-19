package com.mobiotics.HITSAdmin.ReportCoreListSuspension;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;
import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreListSuspensionPage extends ReportUtilityClass{
	
	public ReportCoreListSuspensionPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListSuspensionPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Suspension')]")
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
	
	@FindBy(name = "lcoid")
	private WebElement lcoIdTxtFld;
	
	@FindBy(xpath = "//input[@name='lcoid']/following-sibling::button")
	private WebElement lcoIdGoBtn;
	
	@FindBy(id = "activitystatus")
	private WebElement activityStatusList;
	
	@FindBy(id = "devicestatus")
	private WebElement deviceStatusList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> customerIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement lcoIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[4]")
	private List<WebElement> lcoIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement activatyStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-2]")
	private List<WebElement> activatyStatusDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement deviceStatusDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-3]")
	private List<WebElement> deviceStatusDisplayingList;
	
	@FindBy(xpath = "//button[contains(text(), 'Suspension Download')]")
	private WebElement suspensionDownloadBtn;
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Admin Suspension List", "Page Title is not correct.");
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
	
	public void searchByCustomerId(String customerId)
	{
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}
	public void clearCustomerIdFilter()
	{
		clearTextFilter(customerIdTxtFld, customerIdGoBtn);
	}
	
	public void searchByLCOId(String lcoId) throws InterruptedException
	{
		searchByTextFilter(lcoIdTxtFld, customerIdGoBtn, lcoId);
		Thread.sleep(2000);
		if (verifyData()) 
		{
			logger.info("There is no Suspension for the LCO Id "+lcoId);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("LCO Id", lcoIdDisplayingList, lcoId, nextBtnLink, previousLink);
		clearLCOIdFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearLCOIdFilter()
	{
		clearTextFilter(lcoIdTxtFld, customerIdGoBtn);
	}
	
	public void searchByActivityStatus(String activityStatus) throws InterruptedException
	{
		selectElement(activityStatusList, activityStatus);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Suspension with the Activity Status "+activityStatus);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Activity Status", activatyStatusDisplayingList, activityStatus, nextBtnLink, previousLink);
		clearActivityStatus();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
	}
	public void clearActivityStatus()
	{
		selectElement(activityStatusList, "ALL");
	}
	
	public void searchBydeviceStatus(String deviceStatus) throws InterruptedException
	{
		selectElement(deviceStatusList, deviceStatus);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Suspension with the Device Status "+deviceStatus);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Device Dtatus", deviceStatusDisplayingList, deviceStatus, nextBtnLink, previousLink);
		clearDeviceStatus();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
		
	}
	public void clearDeviceStatus()
	{
		selectElement(deviceStatusList, "ALL");
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
	
	
	public void verifySearch(String filterName, List<WebElement> elementList, String dataExp, WebElement nextLink, WebElement previousLink) throws InterruptedException
	{
		Thread.sleep(2000);
		int noOfElements = countNoOfRecords(elementList, nextLink, previousLink);
		logger.info("Number of records present for this "+filterName+" are: "+noOfElements);
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
	
	public void testReportCoreListSuspensions() throws InterruptedException
	{
			verifyPage();
			selectDates("01-04-2018");
			Thread.sleep(5000);
			if(verifyData())
			{
				logger.info("No suspension is done within the selected timeline.");
				return;
			}
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 12, path);
			searchByCustomerId(customerId);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("No suspension is done for the customer id "+customerId+" within the selected timeline.");
				return;
			}			
			
			String lcoId = lcoIdDisplaying.getText();
			String activityStatus = activatyStatusDisplaying.getText();
			String deviceStatus = deviceStatusDisplaying.getText();
			
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Customer Id", customerIdDisplayingList, customerId, nextBtnLink, previousLink);
			clearCustomerIdFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			
			searchByLCOId(lcoId);
			
			searchByActivityStatus(activityStatus);
			
			searchBydeviceStatus(deviceStatus);
			
			downloadReport(suspensionDownloadBtn);
			Thread.sleep(5000);	
		}
		
		
	
}
