package com.mobiotics.HITSAdmin.ReportCoreListDevice;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreListDevicesPage extends ReportUtilityClass{
	
	public ReportCoreListDevicesPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListDevicesPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Device List')]")
	private WebElement pageTitleTxt;
	
	
	@FindBy(xpath = "//div[contains(text(), 'Please select table')]")
	private WebElement selectTableMsg;
	
	@FindBy(id = "postfix")
	private WebElement tableForData;
	
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
	
	@FindBy(name = "productid")
	private WebElement productIdTxtFld;
	
	@FindBy(xpath = "//input[@name='productid']/following-sibling::button")
	private WebElement productIdGoBtn;
	
	@FindBy(name = "productname")
	private WebElement productNameTxtFld;
	
	@FindBy(xpath = "//input[@name='productname']/following-sibling::button")
	private WebElement productNameGoBtn;
	
	@FindBy(name = "serialno")
	private WebElement serialNoTxtFld;
	
	@FindBy(xpath = "//input[@name='serialno']/following-sibling::button")
	private WebElement serialNoGoBtn;
	
	@FindBy(name = "lcoid")
	private WebElement initiatorIdTxtFld;
	
	@FindBy(xpath = "//input[@name='lcoid']/following-sibling::button")
	private WebElement initiatorIdGoBtn;
	
	@FindBy(id = "devicestatus")
	private WebElement deviceStatusList;
	
	@FindBy(xpath = "//button[contains(text(), 'Device Download')]")
	private WebElement deviceDownloadBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement initiatorIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> initiatorIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement serialNoDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> serialNoDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> customerIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement productIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-3]")
	private List<WebElement> productIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement productNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-2]")
	private List<WebElement> productNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement deviceStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private List<WebElement> deviceStatusDisplayingList;
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Device List", "Page Title is not correct.");
		Assert.assertEquals(pageTitleTxt.isDisplayed(), true, "Not displaying Correct Page Heading");
		logger.info(pageTitleTxt.getText()+" page is displaying.");
	}
	
	
	public boolean verifyOnPageLoad()
	{
		try {
			waitForElementPresence("//div[contains(text(), 'Please select table')]");
			logger.info("Displaying \"Please Select Table Message\"");
		}
		catch (Exception e) {
			logger.info("Not displaying \"Please Select Table Message\"");
			if(firstRow.getText().contains("Failed to get table count."))
			{
				logger.info(firstRow.getText());
				return false;
			}
		}
		return true;
	}
	
	public void selectTable(String tableNo)
	{
		selectElement(tableForData, tableNo);
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
	
	public void clearCustomerIdTxtFld()
	{
		clearTextFilter(customerIdTxtFld, customerIdGoBtn);
	}
	
	public void searchByProductId(String productId)
	{
		searchByTextFilter(productIdTxtFld, productIdGoBtn, productId);
	}
	
	public void clearProductIdTxtFld()
	{
		clearTextFilter(productIdTxtFld, productIdGoBtn);
	}
	
	public void searchByProductName(String productName)
	{
		searchByTextFilter(productNameTxtFld, productNameGoBtn, productName);
	}
	
	public void clearProductNameTxtFld()
	{
		clearTextFilter(productNameTxtFld, productNameGoBtn);
	}
	
	public void searchBySerialNo(String serialNo) throws InterruptedException
	{
		serialNoTxtFld.sendKeys(serialNo);
		Thread.sleep(2000);
		waitTillElementIsClickable(serialNoGoBtn);
		serialNoGoBtn.click();
		
	}
	
	public void clearSerialNoTxtFld()
	{
		clearTextFilter(serialNoTxtFld, serialNoGoBtn);
	}
	
	public void searchByInitiatorId(String initiatorId)
	{
		searchByTextFilter(initiatorIdTxtFld, initiatorIdGoBtn, initiatorId);
	}
	
	public void clearInitiatorIdTxtFld()
	{
		clearTextFilter(initiatorIdTxtFld, initiatorIdGoBtn);
	}
	
	public void searchBydeviceStatus(String deviceStatus)
	{
		selectElement(deviceStatusList, deviceStatus);
	}
	public void clearDeviceStatusFilter()
	{
		selectElement(deviceStatusList, "ALL");
	}
	
	public boolean verifyData()
	{
		waitTillElementIsVisible(firstRow);
		String firstRowData = firstRow.getText();
		if(firstRowData.contains("No Device available.") || firstRowData.contains("Failed to get table count."))
		{
			logger.info(firstRow.getText());
			return true;
		}
		return false;
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
	
	
	
	public void testReportCoreListDevice() throws InterruptedException
	{
		verifyPage();
		if (verifyOnPageLoad()) {
			selectTable("1");
			Thread.sleep(5000);
			selectDates("01-04-2019");
			Thread.sleep(5000);
			if(verifyData()) 
			{
				logger.info("Thre is no device information available in the selected table within the selected timeline");
				return;
			}
			verifyCount();
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 9, path);
			searchByCustomerId(customerId);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("Thre is no device information available for the Customer Id "+customerId+" in the selected table within the selected timeline for t");
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			
			String productId = productIdDisplaying.getText();
			String productName = productNameDisplaying.getText();
			String initiatorId = initiatorIdDisplaying.getText();
			String serialNo = serialNoDisplaying.getText();
			String deviceStatus = deviceStatusDisplaying.getText();
			
			verifySearch("Customer Id", customerIdDisplayingList, customerId, nextBtnLink, previousLink);
			clearCustomerIdTxtFld();
			Thread.sleep(2000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchByProductId(productId);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Device with the Product Id "+productId);
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Product Id", productIdDisplayingList, productId, nextBtnLink, previousLink);
			clearProductIdTxtFld();
			Thread.sleep(3000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchByProductName(productName);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Device with the Product Name "+productName);
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Product Name", productNameDisplayingList, productName, nextBtnLink, previousLink);
			clearProductNameTxtFld();
			Thread.sleep(3000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchBySerialNo(serialNo);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Device with the serial Number "+serialNo);
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Serail Number", serialNoDisplayingList, serialNo, nextBtnLink, previousLink);
			clearSerialNoTxtFld();
			Thread.sleep(3000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchByInitiatorId(initiatorId);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Device with the Initiator Id "+initiatorId);
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Initiator Id", initiatorIdDisplayingList, initiatorId, nextBtnLink, previousLink);
			clearInitiatorIdTxtFld();
			Thread.sleep(5000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchBydeviceStatus(deviceStatus);
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Device with the Entity Type "+deviceStatus);
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Device Status", deviceStatusDisplayingList, deviceStatus, nextBtnLink, previousLink);
			clearDeviceStatusFilter();
			Thread.sleep(5000);
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			
			verifyCount();
			
			downloadReport(deviceDownloadBtn);
			
		}
		Thread.sleep(5000);
	}
	
}
