package com.mobiotics.HITSAdmin.ReportCoreListActivations;

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

public class ReportCoreListActivationsPage extends ReportUtilityClass{
	
	public ReportCoreListActivationsPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListActivationsPage.class);

	private static String fromDateXp1 = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Activation List')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//div[contains(text(), 'Please select table')]")
	private WebElement selectTableMsg;
	
	@FindBy(id = "postfix")
	private WebElement tableForData;
	
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
	
	@FindBy(name = "productid")
	private WebElement productIdTxtFld;
	
	@FindBy(xpath = "//input[@name='customerid']/following-sibling::button")
	private WebElement productIdGoBtn;
	
	@FindBy(name = "productname")
	private WebElement productNameTxtFld;
	
	@FindBy(xpath = "//input[@name='productname']/following-sibling::button")
	private WebElement productNameGoBtn;
	
	@FindBy(id = "activationstatus")
	private WebElement activationStatusList;
	
	@FindBy(id = "activationtype")
	private WebElement activationTypeList;
	
	@FindBy(id = "initiatortype")
	private WebElement initiatorTypeList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement productIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement productNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement activationStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement activationTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement initiatorDisplaying;
	
	@FindBy(xpath = "//button[contains(text(), 'Activation Download')]")
	private WebElement activationDownloadBtn;
	
	@FindBy(xpath = "//button[contains(text(), 'Archive Download')]")
	private WebElement archiveDownloadBtn;
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement archiveDownloadPopUp;
	
	@FindBy(id = "archivee")
	private WebElement archiveePopDownloadBtn;
	
	@FindBy(xpath = "//button[@class='close']/span[1]")
	private WebElement archiveClosePopUpBtn;
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Activation List", "Page Title is not correct.");
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
	
	public void searchByProductId(String productId)
	{
		searchByTextFilter(productIdTxtFld, productIdGoBtn, productId);
	}
	
	public void searchByProductName(String productName)
	{
		searchByTextFilter(productNameTxtFld, productNameGoBtn, productName);
	}
	
	public void searchByActivationStatus(String activationStatus)
	{
		selectElement(activationStatusList, activationStatus);
	}
	
	public void searchByActivationType(String activationType)
	{
		selectElement(activationTypeList, activationType);
	}
	
	public void searchByInitiator(String initiator)
	{
		selectElement(initiatorTypeList, initiator);
	}
	
	public boolean verifyData()
	{
		waitTillElementIsVisible(firstRow);
		String firstRowData = firstRow.getText();
		if(firstRowData.contains("No Data Found") || firstRowData.contains("Failed to get table count."))
		{
			logger.info(firstRow.getText());
			return true;
		}
		return false;
	}
	
	public void verifySearch(WebElement elementDisplaying, String enteredData, String filterName)
	{
		logger.info(filterName+" entered is: "+enteredData);
		logger.info(filterName+" is displaying is "+elementDisplaying.getText());
		Assert.assertEquals(elementDisplaying.getText(), enteredData, filterName+" entered and "+filterName+" is displaying are not same.");
	}
	
	public void archiveDownloadReport()
	{
		archiveDownloadBtn.click();
		waitTillElementIsVisible(archiveDownloadPopUp);
		archiveePopDownloadBtn.click();
		try
		{
			Runtime run = Runtime.getRuntime();
			run.exec(System.getProperty("user.dir")+"\\exeFiles\\saveReport.exe");
		}
		catch (Exception e) {
			
		}
		archiveClosePopUpBtn.click();
		
	}
	
	public void testReportCoreListActivations() throws InterruptedException
	{
		verifyPage();
		if (verifyOnPageLoad()) {
			selectTable("1");
			Thread.sleep(5000);
			selectDates("01-06-2019");
			Thread.sleep(5000);
			if(verifyData()) 
			{
				logger.info("Thre is no activations in the selected table within the selected timeline");
				return;
			}
			verifyCount();
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 11, path);
			searchByCustomerId(customerId);
			Thread.sleep(4000);
			if (verifyData()) 
			{
				return;
			}
			verifySearch(customerIdDisplaying, customerId, "Customer Id");
			
			String productId = productIdDisplaying.getText();
			String productName = productNameDisplaying.getText();
			String activationStatus = activationStatusDisplaying.getText();
			String activationType = activationTypeDisplaying.getText();
			String initiator = initiatorDisplaying.getText();
			
			searchByProductId(productId);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Activation for the Product Id "+productId);
				return;
			}
			verifySearch(productIdDisplaying, productId, "Product Id");
			
			searchByProductName(productName);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Activation for the Product Name "+productName);
				return;
			}
			verifySearch(productNameDisplaying, productName, "Product Name");
			
			searchByActivationStatus(activationStatus);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Activation with the Activation Status: "+activationStatus);
				return;
			}
			verifySearch(activationStatusDisplaying, activationStatus, "Activation Status");
			
			searchByActivationType(activationType);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Activation for the Activation Type: "+activationType);
				return;
			}
			verifySearch(activationTypeDisplaying, activationType, "Activation Type");
			
			searchByInitiator(initiator);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Activation for the Initiator: "+initiator);
				return;
			}
			verifySearch(initiatorDisplaying, initiator, "Initiator");
			
			
			verifyCount();
			
			downloadReport(activationDownloadBtn);
			archiveDownloadReport();
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
