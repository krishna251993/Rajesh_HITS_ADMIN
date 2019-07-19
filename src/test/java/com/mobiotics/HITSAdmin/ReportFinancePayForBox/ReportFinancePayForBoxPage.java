package com.mobiotics.HITSAdmin.ReportFinancePayForBox;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportFinancePayForBoxPage extends ReportUtilityClass {

	public ReportFinancePayForBoxPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportFinancePayForBoxPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "//div[@data-name='end']//table/tbody/tr[";
	private static String toDateXp2 = "]/td[";

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(xpath = "//h1[contains(text(), 'Payforbox Report')]")
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

	@FindBy(name = "lcoid")
	private WebElement lcoIdTxtFld;

	@FindBy(xpath = "//input[@name='lcoid']/following-sibling::button")
	private WebElement lcoIdGoBtn;

	@FindBy(id = "boxtype")
	private WebElement boxTypeList;

	@FindBy(id = "status")
	private WebElement statusList;

	@FindBy(id = "gateway")
	private WebElement gatewayList;

	@FindBy(name = "model")
	private WebElement modelTxtFld;

	@FindBy(xpath = "//input[@name='model']/following-sibling::button")
	private WebElement modelGoBtn;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement lcoIdDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement modelDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement boxTypeDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement statusDisplaying;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement gatewayDisplaying;

	@FindBy(xpath = "//button[contains(text(), 'Download Payforbox Report')]")
	private WebElement payForBoxReportDownloadBtn;

	public void verifyPage() {
		Assert.assertEquals(driver.getTitle(), "Pay For Box", "Page Title is not correct.");
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

	public void searchByLCOId(String lcoId) {
		searchByTextFilter(lcoIdTxtFld, lcoIdGoBtn, lcoId);
	}

	public void searchByModel(String model) {
		searchByTextFilter(modelTxtFld, modelGoBtn, model);
	}

	public void searchByBoxType(String boxType) {
		selectElement(boxTypeList, boxType);
	}

	public void searchByStatus(String status) {
		selectElement(statusList, status);
	}

	public void searchByGateWay(String gateWay) {
		selectElement(gatewayList, gateWay);
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

	public void testReportFinanceListPayments() throws InterruptedException {
		verifyPage();
		selectDates("01-01-2019", "01-06-2019");
		Thread.sleep(3000);
		if(verifyData()) 
		{
			logger.info("No Pay For Box details available within the selected timeline");
			return;
		}
		String lcoId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 16, path);
		searchByLCOId(lcoId);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No Pay For Box details for the LCO id " + lcoId + " within the selected Timeline.");
			return;
		}
		verifySearch(lcoIdDisplaying, lcoId, "LCO Id");

		String model = modelDisplaying.getText();
		String boxType = boxTypeDisplaying.getText();
		String status = statusDisplaying.getText();
		String gateway = gatewayDisplaying.getText();

		searchByModel(model);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No Pay For Box details for the model " + model + " within the selected Timeline.");
			return;
		}
		verifySearch(modelDisplaying, model, "Model");

		searchByBoxType(boxType);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No Pay For Box details for the Box Type " + boxType + " within the selected Timeline.");
			return;
		}
		verifySearch(boxTypeDisplaying, boxType, "Box Type");

		searchByStatus("PENDING");
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No Pay For Box details for the Status " + status + " within the selected Timeline.");
			return;
		}
		//verifySearch(statusDisplaying, status, "Status");

		searchByGateWay("PAYTM");
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info(
					"No Pay For Box details for the selected gateway " + gateway + " within the selected Timeline.");
			return;
		}
		//verifySearch(gatewayDisplaying, gateway, "Gateway");

		
		downloadReport(payForBoxReportDownloadBtn);
		Thread.sleep(5000);
	}

}
