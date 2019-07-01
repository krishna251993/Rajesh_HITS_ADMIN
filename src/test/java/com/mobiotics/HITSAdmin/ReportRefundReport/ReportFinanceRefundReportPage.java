package com.mobiotics.HITSAdmin.ReportRefundReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportFinanceRefundReportPage extends ReportUtilityClass {

	public ReportFinanceRefundReportPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportFinanceRefundReportPage.class);

	private static String fromDateXp1 = "(//table[@class='calendar table table-bordered'])[1]/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "(//table[@class='calendar table table-bordered'])[2]/tbody/tr[";
	private static String toDateXp2 = "]/td[";

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();
	private int index;
	private static String refundActionBtnXp1 = "//table[@class='table table-striped']/tbody/tr[";
	private static String refundActionBtnXp2 = "]/td[last()]/button";
	private static List<WebElement> individualRefundAction;

	@FindBy(xpath = "//h1[contains(text(), 'Refund Report')]")
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

	@FindBy(name = "frcode")
	private WebElement lcoIdTxtFld;

	@FindBy(xpath = "//input[@name='frcode']/following-sibling::button")
	private WebElement lcoIdGoBtn;

	@FindBy(id = "status")
	private WebElement refundActionList;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> customerIdDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> lcoIdDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]/button")
	private List<WebElement> refundActionDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()]/button")
	private List<WebElement> refundActionDisplaying2;

	@FindBy(xpath = "//button[contains(text(), 'Refund Report Download')]")
	private WebElement refundReportDownloadBtn;

	@FindBy(xpath = "//div[@id='approvemodal']//div[@class='modal-content']")
	private WebElement approvalDialogueBox;

	@FindBy(xpath = "//div[@id='myModal']//div[@class='modal-content']")
	private WebElement rejectDialogueBox;

	@FindBy(xpath = "//div[@id='approvemodal']//div[@class='modal-content']//p")
	private WebElement approvalConfirmationMsg;

	@FindBy(id = "reasonmessage")
	private WebElement reasonMsgForRejectAction;

	@FindBy(id = "reason")
	private WebElement rejectSubmitBtn;

	@FindBy(id = "approverequest")
	private WebElement approveYesBtn;

	public boolean findPendingStatus() {
		for (int i = 1; i <= refundActionDisplaying2.size(); i++) {
			individualRefundAction = driver.findElements(By.xpath(refundActionBtnXp1 + i + refundActionBtnXp2));
			if (individualRefundAction.size() > 1) {
				index = i;
				return true;
			}
		}
		return false;
	}

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[index]/td[last()]/button")
	private List<WebElement> refundActionPending;

	public void verifyPage() {
		Assert.assertEquals(driver.getTitle(), "Refund Report", "Page Title is not correct.");
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

	public void searchByCustomerId(String customerId) throws InterruptedException {
		customerIdTxtFld.clear();
		Thread.sleep(1000);
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}

	public void searchByLCOId(String lcoId) throws InterruptedException {
		lcoIdTxtFld.clear();
		Thread.sleep(1000);
		searchByTextFilter(lcoIdTxtFld, lcoIdGoBtn, lcoId);
	}

	public void searchByRefundAction(String refundAction) {
		selectElement(refundActionList, refundAction);
	}

	public boolean verifyData() {
		waitTillElementIsVisible(firstRow);
		String firstRowData = firstRow.getText();
		if (firstRowData.contains("No Refund Data Available")) {
			logger.info(firstRowData);
			return true;
		}
		return false;
	}

	public void verifySearch(WebElement elementDisplaying, String enteredData, String filterName) {
		logger.info(filterName + " entered is: " + enteredData);
		logger.info(filterName + " is displaying is " + elementDisplaying.getText());
		Assert.assertEquals(elementDisplaying.getText().toUpperCase(), enteredData.toUpperCase(),
				filterName + " entered and " + filterName + " is displaying are not same.");
	}

	public boolean verifyPageIsRefreshed() {
		if ((lcoIdTxtFld.getText().equals("")) && (customerIdTxtFld.getText().equals(""))) {
			Select selectedAction = new Select(refundActionList);
			if (selectedAction.getFirstSelectedOption().getText().equals("ALL")) {
				return true;
			}
		}
		return false;
	}

	public void functionalTestForLCOId() throws InterruptedException {
		String lcoId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 20, path);
		searchByLCOId(lcoId);
		Thread.sleep(6000);
		if (verifyData()) {
			logger.info("No refund details available for the LCO ID " + lcoId);
			return;
		}
		waitForVisibiltyOfListOfElements(lcoIdDisplaying);
		if (verifyDataDusplaying(lcoIdDisplaying, lcoId)) {
			logger.info("Functional test for LCO Id filter is passed");
		}
	}

	public void functionalTestForCustomerId() throws InterruptedException {
		String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 21, path);
		searchByCustomerId(customerId);
		Thread.sleep(6000);
		if (verifyData()) {
			logger.info("No refund details available for the Customer ID " + customerId);
			return;
		}
		waitForVisibiltyOfListOfElements(customerIdDisplaying);

		if (verifyDataDusplaying(customerIdDisplaying, customerId)) {
			logger.info("Functional test for Customer Id filter is passed");
		}
	}

	public void functionalTestForRefundActionList() throws InterruptedException {
		String[] refundActions = { "APPROVED", "REJECTED" };
		for (int i = 0; i < refundActions.length; i++) {
			searchByRefundAction(refundActions[i]);
			Thread.sleep(6000);
			if (verifyData()) {
				logger.info("No refund details available within the selected timeline for the for the Selected Action "
						+ refundActions[i]);
				return;
			}
			waitForVisibiltyOfListOfElements(refundActionDisplaying2);
			if (verifyDataDusplaying(refundActionDisplaying2, refundActions[i])) {
				logger.info("Functional test for Refund Actions filter with the status" +refundActions[i]+ " is passed");
			}
		}

		searchByRefundAction("PENDING");
		Thread.sleep(6000);
		
		if (verifyData()) {
			logger.info("No refund details available within the selected timeline for the for the Pending Action ");
			return;
		}
		waitForVisibiltyOfListOfElements(refundActionDisplaying2);
		
		if (verifyDataDisplaying(refundActionDisplaying2, refundActionBtnXp1, refundActionBtnXp2))
		{
			logger.info("Functional test for Refund Actions filter with PENDING status is passed");
		}
		

	}

	public void testReportRefundReport() throws InterruptedException {
		verifyPage();

		String fromDate = "01-01-2019";
		String toDate = "29-06-2019";
		selectDates(fromDate, toDate);
		if (verifyData()) {
			logger.info("No refund details available within the selected Timeline.");
			return;
		}
		functionalTestForCustomerId();
		functionalTestForLCOId();
		functionalTestForRefundActionList();
		
		driver.navigate().refresh();

		for (int i = 0; i < 2; i++) {
			selectDates(fromDate, toDate);
			Thread.sleep(3000);
			if (verifyData()) {
				logger.info("No refund details available within the selected Timeline.");
				return;
			}

			String lcoId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 20, path);
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", i + 1, 21, path);

			searchByLCOId(lcoId);
			Thread.sleep(4000);
			if (verifyData()) {
				logger.info("No refund details available for this LCO id " + lcoId + " within the selected Timeline.");
				return;
			}
			verifySearch(lcoIdDisplaying.get(0), lcoId, "LCO Id");

			searchByCustomerId(customerId);
			Thread.sleep(4000);
			if (verifyData()) {
				logger.info("No refund details available for this Customer id " + customerId
						+ " under this LCO within the selected Timeline.");
				return;
			}
			verifySearch(customerIdDisplaying.get(0), customerId, "Customer Id");

			if (findPendingStatus()) {
				Thread.sleep(2000);
				waitTillElementIsVisible(firstRow);
				logger.info("Either you can  " + individualRefundAction.get(0).getText());
				logger.info("Either you can  " + individualRefundAction.get(1).getText());

				String refundActionToBePerformed = individualRefundAction.get(i).getText();
				logger.info("For Customer Id " + customerId + "We are going to " + refundActionToBePerformed);
				individualRefundAction.get(i).click();
				Thread.sleep(5000);
				try {
					if (approvalDialogueBox.isDisplayed()) {
						logger.info("Displaying Approval Confirmation dialogue box.");
						logger.info("Displaying--- " + approvalConfirmationMsg.getText() + " ---Message");
						approveYesBtn.click();
						logger.info("Approval is confirmed");
						refundActionToBePerformed = "APPROVED";

					}
				} catch (Exception e) {

				}

				try {
					if (rejectDialogueBox.isDisplayed()) {
						logger.info("Displaying Reject Confirmation dialogue box.");
						logger.info("Enter Reason for Rejection...");
						reasonMsgForRejectAction.sendKeys("For Automation Testing...");
						Thread.sleep(3000);
						rejectSubmitBtn.click();
						logger.info("Refund Request is Rejected.");
						refundActionToBePerformed = "REJECTED";

					}
				} catch (Exception e) {

				}

				Thread.sleep(5000);

				if (verifyPageIsRefreshed()) {
					logger.info("Page is refreshed....");
					logger.info("Verify status for the customer Id: " + customerId);
					logger.info("Select Timeline again...");
					selectDates(fromDate, toDate);
					searchByLCOId(lcoId);
					Thread.sleep(4000);
					verifySearch(lcoIdDisplaying.get(0), lcoId, "LCO ID");

					searchByCustomerId(customerId);
					Thread.sleep(4000);
					verifySearch(customerIdDisplaying.get(0), customerId, "Customer ID");

					Thread.sleep(7000);
					logger.info("The request we " + refundActionToBePerformed + " is "
							+ individualRefundAction.get(0).getText());

				}

			} else {
				logger.info("For the Customer with customer ID: " + customerId + " there is no Pending request. ");
				logger.info(
						"Refund status of first row for this customer is: " + refundActionDisplaying.get(0).getText());
			}

		}

		downloadReport(refundReportDownloadBtn);

	}

}
