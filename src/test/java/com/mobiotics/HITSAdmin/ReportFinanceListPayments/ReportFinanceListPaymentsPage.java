package com.mobiotics.HITSAdmin.ReportFinanceListPayments;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.ReportCoreJobReport.ReportCoreJobReportPage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportFinanceListPaymentsPage extends ReportUtilityClass {

	public ReportFinanceListPaymentsPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportFinanceListPaymentsPage.class);

	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div[1]/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "/html/body/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[";
	private static String toDateXp2 = "]/td[";

	private String fromDateArchiveXp1 = "//*[@id=\"startt\"]/div[2]/table/tbody/tr[";
	private String fromDateArchiveXp2 = "]/td[";

	private String toDateArchiveXp1 = "//*[@id=\"endd\"]/div[2]/table/tbody/tr[";
	private String toDateArchiveXp2 = "]/td[";

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(xpath = "//h1[contains(text(), 'Payment Report')]")
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

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement transactionIdDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-4]")
	private WebElement chequeNoDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement paymentStatusDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement initiatorDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[6]")
	private WebElement paymentModeDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement typeDisplaying;

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

	public void verifyPage() {
		Assert.assertEquals(driver.getTitle(), "Payment Report", "Page Title is not correct.");
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

	public void searchByTransactionId(String transactionId) {
		searchByTextFilter(transactionIdTxtFld, transactionIdGoBtn, transactionId);
	}

	public void searchByChequeNo(String chequeNo) {
		searchByTextFilter(chequeNoTxtFld, chequeNoGoBtn, chequeNo);
	}

	public void searchByPaymentStatus(String paymentStatus) {
		selectElement(paymentStatusList, paymentStatus);
	}

	public void searchByInitiator(String initiator) {
		selectElement(initiatorTypeList, initiator);
	}

	public void searchByPaymentMode(String paymentMode) {
		selectElement(paymentModeList, paymentMode);
	}

	public void searchByType(String type) {
		selectElement(typeList, type);
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
		Thread.sleep(3000);
		if(verifyData()) 
		{
			logger.info("No payment is done selected timeline.");
			return;
		}
		String entityId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 15, path);
		searchByEntityId(entityId);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No payment details for the entity id " + entityId + " within the selected Timeline.");
			return;
		}
		verifySearch(entityIdDisplaying, entityId, "Entity Id");

		String transactionId = transactionIdDisplaying.getText();
		String chequeNo = chequeNoDisplaying.getText();
		String paymentStatus = paymentStatusDisplaying.getText();
		String initiator = initiatorDisplaying.getText();
		String paymentMode = paymentModeDisplaying.getText();
		String type = typeDisplaying.getText();

		searchByTransactionId(transactionId);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info(
					"No payment details for the Transaction Id " + transactionId + " within the selected Timeline.");
			return;
		}
		verifySearch(transactionIdDisplaying, transactionId, "Transaction Id");

		if (paymentMode.equalsIgnoreCase("Cheque")) {
			searchByChequeNo(chequeNo);
			Thread.sleep(4000);
			if (verifyData()) {
				logger.info("No payment details for the Cheque Number " + chequeNo + " within the selected Timeline.");
				return;
			}
			verifySearch(chequeNoDisplaying, chequeNo, "Cheque Id");
		}

		searchByPaymentStatus(paymentStatus);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info(
					"No payment details for the Payment Status " + paymentStatus + " within the selected Timeline.");
			return;
		}
		verifySearch(paymentStatusDisplaying, paymentStatus, "Payment Status");

		searchByInitiator(initiator);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info(
					"No payment details for the selected Initiator " + initiator + " within the selected Timeline.");
			return;
		}
		verifySearch(initiatorDisplaying, initiator, "Initiator");

		searchByPaymentMode(paymentMode);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No payment details for the selected payment mode: " + initiator
					+ " within the selected Timeline.");
			return;
		}
		verifySearch(paymentModeDisplaying, paymentMode, "Payment Mode");

		if (paymentMode.equalsIgnoreCase("OP")) {
			searchByType(type);
			Thread.sleep(4000);
			if (verifyData()) {
				logger.info("No payment details for the selected type: " + type + " within the selected Timeline.");
				return;
			}
			verifySearch(typeDisplaying, type, "Type");
		}

		downloadReport(paymentReportDownloadBtn);

		archiveDownloadReport();

	}

}
