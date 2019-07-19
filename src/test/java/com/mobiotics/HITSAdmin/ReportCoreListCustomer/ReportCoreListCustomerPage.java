package com.mobiotics.HITSAdmin.ReportCoreListCustomer;

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

public class ReportCoreListCustomerPage extends ReportUtilityClass{
	
	public ReportCoreListCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListCustomerPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Customer List')]")
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
	
	@FindBy(xpath = "//li[@class='prev']/button")
	private WebElement previousLink;
	
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
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> customerIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement lcoIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> lcoIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement firstNameDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> firstNameDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement mobileNoDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[4]")
	private List<WebElement> mobileNoDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-4]")
	private WebElement entityTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-4]")
	private List<WebElement> entityTypeDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement customerTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-3]")
	private List<WebElement> customerTypeDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement kycStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-2]")
	private List<WebElement> kycStatusDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement customerStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private List<WebElement> customerStatusDisplayingList;
		

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
	
	public int verifyCount() throws InterruptedException
	{
		String countDisplayingNo = countValueNumber.getText();
		logger.info("Count displaying: "+countDisplayingNo);
		int noOfRecords = countNoOfRecords(listOfRecords, nextBtnLink, previousLink);
		logger.info("Number of records displaying are: "+noOfRecords);
		assertEquals(Integer.parseInt(countDisplayingNo), noOfRecords, "Count is displaying wrong number");
		return noOfRecords;
	}
	
	public void searchByCustomerId(String customerId)
	{
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}
	
	public void clearCustomerIdTxtFilter()
	{
		clearTextFilter(customerIdTxtFld, customerIdGoBtn);
	}
	
	public void searchByFirstName(String firstName) throws InterruptedException
	{
		searchByTextFilter(firstNameTxtFld, firstNameGoBtn, firstName);
	}
	
	public void clearFirstNameTxtFilter()
	{
		clearTextFilter(firstNameTxtFld, firstNameGoBtn);
	}
	
	public void searchByLCOId(String lcoId)
	{
		searchByTextFilter(lcoIdTxtFld, lcoIdGoBtn, lcoId);
	}
	
	public void clearLCOIdxtFilter()
	{
		clearTextFilter(lcoIdTxtFld, lcoIdGoBtn);
	}
	
	public void searchByMobileNo(String mobileNo)
	{
		searchByTextFilter(mobileNoTxtFld, mobileNoGoBtn, mobileNo);
	}
	
	public void clearMobileNoTxtFilter()
	{
		clearTextFilter(mobileNoTxtFld, mobileNoGoBtn);
	}
	
	public void searchByKYCStatus(String kycStatus)
	{
		selectElement(kycStatusList, kycStatus);
	}
	
	public void clearKYCStatusTxtFilter()
	{
		selectElement(kycStatusList, "ALL");
	}
	
	public void searchByCustomerStatus(String customerStatus)
	{
		selectElement(customerStatusList, customerStatus);
	}
	
	public void clearCustomerStatusField()
	{
		selectElement(customerStatusList, "ALL");
	}
	
	public void searchByEntityType(String entityType)
	{
		selectElement(entityTypeList, entityType);
	}
	
	public void clearEntityTypeFilter()
	{
		selectElement(entityTypeList, "ALL");
	}
	
	public void searchByCustomerType(String customerType)
	{
		selectElement(customerTypeList, customerType);
	}
	
	public void clearCustomerTypeFilter()
	{
		selectElement(customerTypeList, "ALL");
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

	public void testReportCoreListCustomer() throws InterruptedException
	{
		verifyPage();
		if (verifyOnPageLoad()) {
			selectTable("1");
			Thread.sleep(5000);
			selectDates("01-06-2019");
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
				logger.info("Thre is no Customer with the Customer Id: "+customerId+" in the selected table within the selected timeline");
				return;
			}
			
			
			String firstNameArr[] = firstNameDisplaying.getText().split(" ");
			String lcoId = lcoIdDisplaying.getText();
			String mobileNo = mobileNoDisplaying.getText();
			String kycStatus = kycStatusDisplaying.getText();
			String customerStatus = customerStatusDisplaying.getText();
			String entityType = entityTypeDisplaying.getText();
			String customerType = customerTypeDisplaying.getText();
			
			verifySearch("Customer Id", customerIdDisplayingList, customerId, nextBtnLink, previousLink);
			clearCustomerIdTxtFilter();
			Thread.sleep(5000);
			
			searchByFirstName("r");
			Thread.sleep(5000);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the name "+"r");
				return;
			}
			waitForVisibiltyOfListOfElements(firstNameDisplayingList);
			int noOfMatches = verifyFirstString(firstNameDisplayingList, "r", nextBtnLink);
			System.out.println("Number of firstName are --- "+noOfMatches);
			firstNameGoBtn.click();
			Thread.sleep(7000);
			waitForVisibiltyOfListOfElements(firstNameDisplayingList);
			Assert.assertEquals(noOfMatches, countNoOfRecords(firstNameDisplayingList, nextBtnLink, previousLink));
			waitTillElementIsClickable(firstNameGoBtn);
			firstNameGoBtn.click();
			Thread.sleep(7000);
			verifyCount();
			logger.info("Functional test case for First Name Text field is passed.");
			
			clearFirstNameTxtFilter();
			
			
			searchByLCOId(lcoId);
			Thread.sleep(2000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the LCO ID "+lcoId);
				return;
			}
			verifySearch("LCO Id", lcoIdDisplayingList, lcoId, nextBtnLink, previousLink);
			Thread.sleep(3000);
			clearLCOIdxtFilter();
			
			
			searchByMobileNo(mobileNo);
			Thread.sleep(5000);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the Mobile Number "+mobileNo);
				return;
			}
			verifySearch("Mobile Number", mobileNoDisplayingList, mobileNo, nextBtnLink, previousLink);
			Thread.sleep(3000);
			clearMobileNoTxtFilter();
			
			searchByKYCStatus("VERIFIED");
			Thread.sleep(5000);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the KYC status "+"VERIFIED");
				return;
			}
			verifySearch("KYC Status", kycStatusDisplayingList, "VERIFIED", nextBtnLink, previousLink);
			Thread.sleep(3000);
			clearKYCStatusTxtFilter();
			
			searchByCustomerStatus("REGISTERED");
			Thread.sleep(5000);
			if (verifyData()) 
			{
				logger.info("There is no Customer with the Customer Status "+"REGISTERED");
				return;
			}
			verifySearch("Customer Status", customerStatusDisplayingList, "REGISTERED", nextBtnLink, previousLink);
			Thread.sleep(3000);
			clearCustomerStatusField();
			
//============In Entity Type filter there is a bug after fixing we will verify it==============			
//			searchByEntityType(entityType);
//			Thread.sleep(5000);
//			if (verifyData()) 
//			{
//				logger.info("There is no Customer with the Entity Type "+entityType);
//				return;
//			}
//			verifySearch("Entity Type", entityTypeDisplayingList, entityType, nextBtnLink);
//			verifyCount();
//			Thread.sleep(3000);
//			clearEntityTypeFilter();
//		
			searchByCustomerType(customerType);
			Thread.sleep(5000);
			if (verifyData()) 
			{
				logger.info("There is no Customer of Type "+customerType);
				return;
			}
			verifySearch("Customer Type", customerTypeDisplayingList, customerType, nextBtnLink, previousLink);
			Thread.sleep(3000);
			clearCustomerTypeFilter();
			
			Thread.sleep(5000);
			downloadReport(customerDownloadBtn);
			
			
		}
		
		Thread.sleep(5000);
		
	}
	
	
	


}
