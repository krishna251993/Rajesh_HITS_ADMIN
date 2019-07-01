package com.mobiotics.HITSAdmin.ReportCoreListCustomer;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkAdjustmentDebit.BulkAdjustmentDebitPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreListCustomerPage extends ReportUtilityClass{
	
	public ReportCoreListCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListCustomerPage.class);

	private static String fromDateXp1 = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Customer List')]")
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
	
	@FindBy(name = "firstname")
	private WebElement firstNameTxtFld;
	
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::button")
	private WebElement firstNameGoBtn;
	
	@FindBy(name = "lcoid")
	private WebElement lcoIdTxtFld;
	
	@FindBy(xpath = "//input[@name='lcoid']/following-sibling::button")
	private WebElement lcoIdGoBtn;
	
	@FindBy(name = "mobileno")
	private WebElement mobileNoTxtFld;
	
	@FindBy(xpath = "//input[@name='mobileno']/following-sibling::button")
	private WebElement mobileNoGoBtn;
	
	@FindBy(id = "kycstatus")
	private WebElement kycStatusList;
	
	@FindBy(id = "customerstatus")
	private WebElement customerStatusList;
	
	@FindBy(id = "entitytype")
	private WebElement entityTypeList;
	
	@FindBy(id = "customertype")
	private WebElement customerTypeList;
	
	@FindBy(xpath = "//button[text()='Customer Download']")
	private WebElement customerDownloadBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement lcoIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement firstNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement mobileNoDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-4]")
	private WebElement entityTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement customerTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement kycStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement customerStatusDisplaying;
	
	

	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Customer List", "Page Title is not correct.");
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
		customerIdTxtFld.sendKeys(customerId);
		waitTillElementIsClickable(customerIdTxtFld);
		customerIdGoBtn.click();
	}
	
	public void searchByFirstName(String firstName)
	{
		String firstNameArr[] = firstName.split(" ");
		firstNameTxtFld.sendKeys(firstNameArr[0]);
		waitTillElementIsVisible(firstNameGoBtn);
		firstNameGoBtn.click();
	}
	
	public void searchByLCOId(String lcoId)
	{
		lcoIdTxtFld.sendKeys(lcoId);
		waitTillElementIsVisible(firstNameGoBtn);
		lcoIdGoBtn.click();
	}
	
	public void searchByMobileNo(String mobileNo)
	{
		mobileNoTxtFld.sendKeys(mobileNo);
		waitTillElementIsVisible(firstNameGoBtn);
		mobileNoGoBtn.click();
	}
	
	public void searchByKYCStatus(String kycStatus)
	{
		selectElement(kycStatusList, kycStatus);
	}
	
	public void searchByCustomerStatus(String customerStatus)
	{
		selectElement(customerStatusList, customerStatus);
	}
	
	public void searchByEntityType(String entityType)
	{
		selectElement(entityTypeList, entityType);
	}
	
	public void searchByCustomerType(String customerType)
	{
		selectElement(customerTypeList, customerType);
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
	
	
	
	public void testReportCoreListCustomer() throws InterruptedException
	{
		verifyPage();
		if (verifyOnPageLoad()) {
			selectTable("1");
			Thread.sleep(5000);
			selectDates("01-04-2019");
			Thread.sleep(5000);
			if(verifyData()) 
			{
				logger.info("Thre is no Customer details in the selected table within the selected timeline");
				return;
			}
			verifyCount();
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 8, path);
			searchByCustomerId(customerId);
			if (verifyData()) 
			{
				return;
			}
			verifySearch(customerIdDisplaying, customerId, "Customer Id");
			String firstNameArr[] = firstNameDisplaying.getText().split(" ");
			String lcoId = lcoIdDisplaying.getText();
			String mobileNo = mobileNoDisplaying.getText();
			String kycStatus = kycStatusDisplaying.getText();
			String customerStatus = customerStatusDisplaying.getText();
			String entityType = entityTypeDisplaying.getText();
			String customerType = customerTypeDisplaying.getText();
			
			searchByFirstName(firstNameArr[0]);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the name "+firstNameArr[0]);
				return;
			}
			else if(firstNameDisplaying.getText().contains(firstNameArr[0]))
			{
				logger.info("First Name entered is: "+firstNameArr[0]);
				logger.info("First Name displaying is: "+firstNameDisplaying.getText());
			}
			else
			{
				logger.info("First Name entered is: "+firstNameArr[0]);
				logger.info("First Name displaying is: "+firstNameDisplaying.getText());
			}
			
			
			searchByLCOId(lcoId);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the LCO ID "+lcoId);
				return;
			}
			verifySearch(lcoIdDisplaying, lcoId, "LCO Id");
			
			searchByMobileNo(mobileNo);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the Mobile Number "+mobileNo);
				return;
			}
			verifySearch(mobileNoDisplaying, mobileNo, "Mobile Number");
			
			searchByKYCStatus(kycStatus);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the KYC status "+kycStatus);
				return;
			}
			verifySearch(kycStatusDisplaying, kycStatus, "KYC Status");
			
			searchByCustomerStatus(customerStatus);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the Customer Status "+customerStatus);
				return;
			}
			verifySearch(customerStatusDisplaying, customerStatus, "Customer Status");
			
			searchByEntityType(entityType);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the Entity Type "+entityType);
				return;
			}
			verifySearch(entityTypeDisplaying, entityType, "Entity Type");
			
			
			searchByCustomerType(customerType);
			if (verifyData()) 
			{
				logger.info("There is no Customer of Type "+customerType);
				return;
			}
			verifySearch(customerTypeDisplaying, customerType, "Customer Type");
			
			//verifyCount();
			downloadReport(customerDownloadBtn);
			
			
		}
		
		
		
	}
	
	


}
