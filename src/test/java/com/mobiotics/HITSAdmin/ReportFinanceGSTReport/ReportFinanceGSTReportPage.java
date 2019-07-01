package com.mobiotics.HITSAdmin.ReportFinanceGSTReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.ReportFinancePayForBox.ReportFinancePayForBoxPage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportFinanceGSTReportPage extends ReportUtilityClass{
	
	public ReportFinanceGSTReportPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportFinanceGSTReportPage.class);

	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";

	private static String toDateXp1 = "/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/table/tbody/tr[";
	private static String toDateXp2 = "]/td[";
	
	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(xpath = "//h2[contains(text(), 'GST Report')]")
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

	@FindBy(xpath = "//input[@placeholder='Search By lcoid']")
	private WebElement lcoIdTxtFld;

	@FindBy(xpath = "//input[@placeholder='Search By lcoid']/following-sibling::button")
	private WebElement lcoIdGoBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement lcoIdDisplaying;
	
	@FindBy(xpath = "//button[contains(text(), 'GST Report Download')]")
	private WebElement payForBoxReportDownloadBtn;
	
	
	public void verifyPage() {
		Assert.assertEquals(driver.getTitle(), "GST Report", "Page Title is not correct.");
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
			logger.info("No GST details available within the selected timeline");
			return;
		}
		String lcoId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 17, path);
		searchByLCOId(lcoId);
		Thread.sleep(4000);
		if (verifyData()) {
			logger.info("No GST details for the LCO id " + lcoId + " within the selected Timeline.");
			return;
		}
		verifySearch(lcoIdDisplaying, lcoId, "LCO Id");

		downloadReport(payForBoxReportDownloadBtn);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
