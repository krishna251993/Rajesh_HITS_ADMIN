package com.mobiotics.HITSAdmin.ReportPayBills;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportFinancePayBillsPage extends ReportUtilityClass{
	
	public ReportFinancePayBillsPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportFinancePayBillsPage.class);

	private static String fromDateXp1 = "/html/body/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "/html/body/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[";
	private static String toDateXp2 = "]/td[";
	
	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(xpath = "//h1[contains(text(), 'Pay Bills Report')]")
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

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[2]")
	private WebElement toDateCal;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[4]")
	private WebElement previousShftYearToDate;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[4]")
	private WebElement nextShftYearToDate;

	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[4]")
	private WebElement toDateYear;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[3]")
	private WebElement previousShftMonthToDate;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[3]")
	private WebElement nextShftMonthToDate;

	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[3]")
	private WebElement toDateMonth;

	@FindBy(id = "refresh")
	private WebElement goDateBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;

	@FindBy(name = "customerid")
	private WebElement customerIdTxtFld;

	@FindBy(xpath = "//input[@name='customerid']/following-sibling::button")
	private WebElement customerIdGoBtn;
	
	@FindBy(name = "initiatorid")
	private WebElement initiatorIdTxtFld;

	@FindBy(xpath = "//input[@id='initiatorid']/following-sibling::button")
	private WebElement initiatorIdGoBtn;
	
	@FindBy(id = "initiatortype")
	private WebElement entityTypeList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement initiatorIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement entityTypeDisplaying;
	
	@FindBy(xpath = "//button[contains(text(), 'Bill Download')]")
	private WebElement billReportDownloadBtn;
	
	public void verifyPage() {
		Assert.assertEquals(driver.getTitle(), "Pay Bill Report", "Page Title is not correct.");
		Assert.assertEquals(pageTitleTxt.isDisplayed(), true, "Not displaying Correct Page Heading");
		logger.info(pageTitleTxt.getText() + " page is displaying.");
	}

	public void selectDates(String fromDate, String toDate) throws InterruptedException {
		waitTillElementIsClickable(fromDateCal);
		fromDateCal.click();
		waitTillElementIsClickable(previousShftYearFromDate);
		String fromDateArr[] = fromDate.split("-");
		String toDateArr[] = toDate.split("-");
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
		Thread.sleep(1000);
		waitTillElementIsClickable(nextShftMonthToDate);
		dh.selectMonth(previousShftMonthToDate, nextShftMonthToDate, toDateMonth.getText(),
				Integer.parseInt(toDateArr[1]));
		Thread.sleep(1000);
		dh.selectDate(toDateXp1, toDateXp2, Integer.parseInt(toDateArr[0]));
		Thread.sleep(1000);
		waitTillElementIsClickable(goDateBtn);
		goDateBtn.click();

	}
	
	public void searchByCustomerId(String customerId) {
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}
	
	public void searchByInitiatorId(String initiatorId) {
		searchByTextFilter(initiatorIdTxtFld, initiatorIdGoBtn, initiatorId);
	}
	
	public void searchByEntityType(String entityType) {
		selectElement(entityTypeList, entityType);
	}
	
	public boolean verifyData() {
		waitTillElementIsVisible(firstRow);
		String firstRowData = firstRow.getText();
		if (firstRowData.contains("No Data Found")) {
			logger.info(firstRow.getText());
			return true;
		}
		return false;
	}
	
	public void verifySearch(WebElement elementDisplaying, String enteredData, String filterName) {
		logger.info(filterName + " entered is: " + enteredData);
		logger.info(filterName + " is displaying is " + elementDisplaying.getText());
		Assert.assertEquals(elementDisplaying.getText(), enteredData,
				filterName + " entered and " + filterName + " is displaying are not same.");
	}
	
	
	public void testReportFinancePayBills() throws InterruptedException {
		verifyPage();
		selectDates("01-01-2017", "01-06-2019");
		Thread.sleep(3000);
		
		if (verifyData()) {
			logger.info("No Bill  details available within the selected Timeline.");
			return;
		}
		
		String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 18, path);
		searchByCustomerId(customerId);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No Bill  details available for this Customer id " + customerId + " within the selected Timeline.");
			return;
		}
		verifySearch(customerIdDisplaying, customerId, "Customer Id");
		
		String initiatorId = initiatorIdDisplaying.getText();
		String entityType = entityTypeDisplaying.getText();
		
		if(!(entityType.equals("CUSTOMER") || initiatorId.contains("---")||initiatorId.equals("")))
		{
			searchByInitiatorId(initiatorId);
			Thread.sleep(4000);
			if (verifyData()) {
				logger.info("No Bill  details available for this Initiator id " + customerId + " within the selected Timeline.");
				return;
			}
			verifySearch(initiatorIdDisplaying, initiatorId, "Initiator Id");
		}
		
		
		searchByEntityType(entityType);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No Bill details available for this entity type " + entityType + " within the selected Timeline.");
			return;
		}
		verifySearch(entityTypeDisplaying, entityType, "Entity Type");

		downloadReport(billReportDownloadBtn);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
