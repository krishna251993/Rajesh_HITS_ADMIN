package com.mobiotics.HITSAdmin.ReportFinanceListPayments;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportFinanceListPaymentsPage extends ReportUtilityClass {

	public ReportFinanceListPaymentsPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportFinanceListPaymentsPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "//div[@data-name='end']//table/tbody/tr[";
	private static String toDateXp2 = "]/td[";

	private String fromDateArchiveXp1 = "//*[@id=\"startt\"]/div[2]/table/tbody/tr[";
	private String fromDateArchiveXp2 = "]/td[";

	private String toDateArchiveXp1 = "//*[@id=\"endd\"]/div[2]/table/tbody/tr[";
	private String toDateArchiveXp2 = "]/td[";

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(xpath = "//h1[contains(text(), 'Payment Report')]")
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

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;

	@FindBy(name = "entityid")
	private WebElement entityIdTxtFld;

	@FindBy(xpath = "//input[@name='entityid']/following-sibling::button")
	private WebElement entityIdGoBtn;

	@FindBy(name = "transactionid")
	private WebElement transactionIdTxtFld;

	@FindBy(xpath = "//input[@name='transactionid']/following-sibling::button")
	private WebElement transactionIdGoBtn;

	@FindBy(name = "chequeno")
	private WebElement chequeNoTxtFld;

	@FindBy(xpath = "//input[@name='chequeno']/following-sibling::button")
	private WebElement chequeNoGoBtn;

	@FindBy(id = "paymentstatus")
	private WebElement paymentStatusList;

	@FindBy(id = "initiatortype")
	private WebElement initiatorTypeList;

	@FindBy(id = "paymentmode")
	private WebElement paymentModeList;

	@FindBy(id = "type")
	private WebElement typeList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement entityIdDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> entityIdDisplayingList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement transactionIdDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[4]")
	private List<WebElement> transactionIdDisplayingList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-4]")
	private WebElement chequeNoDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-4]")
	private List<WebElement> chequeNoDisplayingList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement paymentStatusDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-2]")
	private List<WebElement> paymentStatusDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement paymentTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private List<WebElement> paymentTypeDisplayingList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement initiatorDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[5]")
	private List<WebElement> initiatorDisplayingList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[6]")
	private WebElement paymentModeDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[6]")
	private List<WebElement> paymentModeDisplayingList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement typeDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private List<WebElement> typeDisplayingList;

	@FindBy(xpath = "//button[contains(text(), 'Payment Report Download')]")
	private WebElement paymentReportDownloadBtn;

	@FindBy(id = "arcdownload")
	private WebElement archiveDownloadBtn;

	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement archivePpup;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCalArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement previousMnthShftFromDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nextMnthShftFrmDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//a[@class='previous']/following-sibling::span)[1]")
	private WebElement frmDateMonthArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-left'])[2]")
	private WebElement previousYearShftFromDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-right'])[2]")
	private WebElement nextYearShftFromDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//a[@class='previous']/following-sibling::span)[2]")
	private WebElement frmDateYearArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-calendar'])[2]")
	private WebElement toDateCalArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-left'])[3]")
	private WebElement previousMnthShftToDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-right'])[3]")
	private WebElement nextMnthShftToDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//a[@class='previous']/following-sibling::span)[3]")
	private WebElement toDateMonthArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-left'])[4]")
	private WebElement previousYearShftToDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//i[@class='glyphicon glyphicon-chevron-right'])[4]")
	private WebElement nextYearShftToDateArchive;

	@FindBy(xpath = "(//div[@class='modal-content']//a[@class='previous']/following-sibling::span)[4]")
	private WebElement toDateYearArchive;

	@FindBy(xpath = "//form[@id='downloadarc']/button[contains(text(), 'Download')]")
	private WebElement downloadBtnArchivePopup;

	@FindBy(xpath = "//div[@class='modal-header']/button")
	private WebElement closeArchivePopUpBtn;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextLink;

	@FindBy(xpath = "//button[text()='Prev']")
	private WebElement previousLink;

	public void verifyPage() {
		Assert.assertEquals(driver.getTitle(), "Payment Report", "Page Title is not correct.");
		Assert.assertEquals(pageTitleTxt.isDisplayed(), true, "Not displaying Correct Page Heading");
		logger.info(pageTitleTxt.getText() + " page is displaying.");
	}

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

	public void selectDatesArchives(String fromDate, String toDate) throws InterruptedException {

		waitTillElementIsClickable(fromDateCalArchive);
		fromDateCalArchive.click();
		waitTillElementIsClickable(previousYearShftFromDateArchive);
		String fromDateArr[] = fromDate.split("-");
		String toDateArr[] = toDate.split("-");
		dh.selectYear(previousYearShftFromDateArchive, nextYearShftFromDateArchive,
				Integer.parseInt(frmDateYearArchive.getText()), Integer.parseInt(fromDateArr[2]));
		waitTillElementIsClickable(previousMnthShftFromDateArchive);
		dh.selectMonth(previousMnthShftFromDateArchive, nextMnthShftFrmDateArchive, frmDateMonthArchive.getText(),
				Integer.parseInt(fromDateArr[1]));
		Thread.sleep(1000);
		dh.selectDate(fromDateArchiveXp1, fromDateArchiveXp2, Integer.parseInt(fromDateArr[0]));
		Thread.sleep(1000);

		waitTillElementIsClickable(toDateCalArchive);
		toDateCalArchive.click();
		waitTillElementIsClickable(previousYearShftToDateArchive);
		dh.selectYear(previousYearShftToDateArchive, nextYearShftToDateArchive,
				Integer.parseInt(toDateYearArchive.getText()), Integer.parseInt(toDateArr[2]));
		waitTillElementIsClickable(previousMnthShftToDateArchive);
		dh.selectMonth(previousMnthShftToDateArchive, nextMnthShftToDateArchive, toDateMonthArchive.getText(),
				Integer.parseInt(toDateArr[1]));
		Thread.sleep(1000);
		dh.selectDate(toDateArchiveXp1, toDateArchiveXp2, Integer.parseInt(toDateArr[0]));
		Thread.sleep(1000);
		waitTillElementIsClickable(downloadBtnArchivePopup);
		downloadBtnArchivePopup.click();

	}

	public void searchByEntityId(String entityId) {
		searchByTextFilter(entityIdTxtFld, entityIdGoBtn, entityId);
	}

	public void clearEntityIdFilter() {
		clearTextFilter(entityIdTxtFld, entityIdGoBtn);
	}

	public void searchByTransactionId(String transactionId) throws InterruptedException {
		searchByTextFilter(transactionIdTxtFld, transactionIdGoBtn, transactionId);
		Thread.sleep(4000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) {
			logger.info(
					"No payment details for the Transaction Id " + transactionId + " within the selected Timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(transactionIdDisplayingList);
		verifySearch("Transaction Id", transactionIdDisplayingList, transactionId, nextLink, previousLink);
		clearTransactionIdFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
	}

	public void clearTransactionIdFilter() {
		clearTextFilter(transactionIdTxtFld, transactionIdGoBtn);
	}

	public void searchByChequeNo(String chequeNo) {
		searchByTextFilter(chequeNoTxtFld, chequeNoGoBtn, chequeNo);

	}

	public void clearChequeNoFilter() {
		clearTextFilter(chequeNoTxtFld, chequeNoGoBtn);
	}

	public void searchByPaymentStatus(String paymentStatus) {
		selectElement(paymentStatusList, paymentStatus);
	}

	public void clearPaymentStatusFilter() {
		selectElement(paymentStatusList, "ALL");
	}

	public void searchByInitiator(String initiator) {
		selectElement(initiatorTypeList, initiator);
	}

	public void clearInitiatorListFilter() {
		selectElement(initiatorTypeList, "ALL");
	}

	public void searchByPaymentMode(String paymentMode) {
		selectElement(paymentModeList, paymentMode);
	}

	public void clearPaymentModeFilter() {
		selectElement(paymentModeList, "ALL");
	}

	public void searchByType(String type) {
		selectElement(typeList, type);
	}

	public void clearType() {
		selectElement(typeList, "ALL");
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

	public void archiveDownloadReport() throws InterruptedException {

		archiveDownloadBtn.click();
		Thread.sleep(5000);
		waitTillElementIsVisible(archivePpup);
		selectDatesArchives("1-01-2016", "1-01-2017");
		downloadBtnArchivePopup.click();
		try {
			Runtime run = Runtime.getRuntime();
			run.exec(System.getProperty("user.dir") + "\\exeFiles\\saveReport.exe");
		} catch (Exception e) {

		}
		closeArchivePopUpBtn.click();

	}

	public void testReportFinanceListPayments() throws InterruptedException {
		verifyPage();
		String fromDate = DemoExcelLibrary3.getexcelData("hits admin data", 2, 15, path);
		String toDate = DemoExcelLibrary3.getexcelData("hits admin data", 3, 15, path);
		selectDates(fromDate, toDate);
		Thread.sleep(5000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) {
			logger.info("No payment is done selected timeline.");
			return;
		}
		String entityId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 15, path);
		searchByEntityId(entityId);
		Thread.sleep(4000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) {
			logger.info("No payment details for the entity id " + entityId + " within the selected Timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);

		//String transactionId = transactionIdDisplaying.getText();
		String chequeNo = chequeNoDisplaying.getText();
		String paymentStatus = paymentStatusDisplaying.getText();
		String initiator = initiatorDisplaying.getText();
		String paymentMode = paymentModeDisplaying.getText();
		String paymentType = paymentTypeDisplaying.getText();

		verifySearch("Entity Id", entityIdDisplayingList, entityId, nextLink, previousLink);
		clearEntityIdFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);

//		searchByTransactionId(transactionId);
//		Thread.sleep(4000);
//		waitTillElementIsVisible(firstRow);
//		if (verifyData()) {
//			logger.info("No Transaction details for the  Transaction Id " + transactionId
//					+ " within the selected Timeline.");
//			return;
//		}
//
//		waitForVisibiltyOfListOfElements(listOfRecords);
//		verifySearch("Transaction Id", transactionIdDisplayingList, transactionId, nextLink, previousLink);
		
		clearTransactionIdFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);

		if (!(chequeNo.equals("---"))) {
			searchByChequeNo(chequeNo);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) {
				logger.info("No payment details for the Cheque Number " + chequeNo + " within the selected Timeline.");
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Cheque Number", chequeNoDisplayingList, chequeNo, nextLink, previousLink);
			clearChequeNoFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
		}

		if (!(paymentStatus.equals("---")))
		{
			searchByPaymentStatus(paymentStatus);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) {
				logger.info(
						"No payment details for the Payment Status " + paymentStatus + " within the selected Timeline.");
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Payment Status", paymentStatusDisplayingList, paymentStatus, nextLink, previousLink);
			clearPaymentStatusFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
		}
		

		
		if(!(initiator.equalsIgnoreCase("MSO")))
		{
			searchByInitiator(initiator);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) {
				logger.info(
						"No payment details for the selected Initiator " + initiator + " within the selected Timeline.");
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Initiator", initiatorDisplayingList, initiator, nextLink, previousLink);
			clearInitiatorListFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
		}
			

		searchByPaymentMode(paymentMode);
		Thread.sleep(4000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) {
			logger.info("No payment details for the selected payment mode: " + paymentMode
					+ " within the selected Timeline.");
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Payment Mode", paymentModeDisplayingList, paymentMode, nextLink, previousLink);
		clearPaymentModeFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
		
		if(!(paymentType.equals("---")))
		{
			searchByType(paymentType);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) {
				logger.info("No payment details for the selected payment Type: " + paymentType
						+ " within the selected Timeline.");
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Payment Type", paymentTypeDisplayingList, paymentType, nextLink, previousLink);
			clearPaymentModeFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
		}

		downloadReport(paymentReportDownloadBtn);

		archiveDownloadReport();
		Thread.sleep(5000);

	}
	
	

}
