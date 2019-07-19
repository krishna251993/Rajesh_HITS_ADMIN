package com.mobiotics.HITSAdmin.ReportCoreJobReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreJobReportPage extends ReportUtilityClass{
	

	public ReportCoreJobReportPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreJobReportPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Job Report')]")
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
	
	@FindBy(id = "refresh")
	private WebElement goDateBtn;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtnLink;
	
	@FindBy(xpath = "//button[text()='Prev']")
	private WebElement previousLink;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;
	
	@FindBy(name = "initiatorid")
	private WebElement initiatorIdTxtFld;
	
	@FindBy(xpath = "//input[@name='initiatorid']/following-sibling::button")
	private WebElement initiatorIdGoBtn;
	
	@FindBy(id = "initiatortype")
	private WebElement initiatorTyoeList;
	
	@FindBy(id = "jobstatus")
	private WebElement jobStatusList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement initiatorIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> initiatorIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement initiatorTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> initiatorTypeDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement jobStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[5]")
	private List<WebElement> jobStatusDisplayingList;
	
	@FindBy(xpath = "//button[contains(text(), 'Report Download')]")
	private WebElement reportDownloadBtn;
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Job Report", "Page Title is not correct.");
		Assert.assertEquals(pageTitleTxt.isDisplayed(), true, "Not displaying Correct Page Heading");
		logger.info(pageTitleTxt.getText()+" page is displaying.");
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
	
	public void searchByInitiatorId(String initiatorId)
	{
		searchByTextFilter(initiatorIdTxtFld, initiatorIdGoBtn, initiatorId);
	}
	public void clearInitiatorIdFilter()
	{
		clearTextFilter(initiatorIdTxtFld, initiatorIdGoBtn);
	}
	
	public void searchByInitiatorType(String initiatorType) throws InterruptedException
	{
		selectElement(initiatorTyoeList, initiatorType);
		Thread.sleep(4000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("No Bulk Job is performed for this Initiator Type "+initiatorType);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Initiator Type", initiatorTypeDisplayingList, initiatorType, nextBtnLink, previousLink);
		clearInitiatorTypeFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(initiatorTypeDisplayingList);
	}
	public void clearInitiatorTypeFilter()
	{
		selectElement(initiatorTyoeList, "ALL");
	}
	
	public void searchByJobStatus(String jobStatus) throws InterruptedException
	{
		selectElement(jobStatusList, jobStatus);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("No Bulk Job is performed with this Job Status "+jobStatus);
			return;
		}
		waitForVisibiltyOfListOfElements(jobStatusDisplayingList);
		verifySearch("Job Status", jobStatusDisplayingList, jobStatus, nextBtnLink, previousLink);
		clearJobStatusFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
		
	}
	public void clearJobStatusFilter()
	{
		selectElement(jobStatusList, "ALL");
	}
	
	public boolean verifyData()
	{
		waitTillElementIsVisible(firstRow);
		String firstRowData = firstRow.getText();
		if(firstRowData.contains("No Data Found"))
		{
			logger.info(firstRow.getText());
			return true;
		}
		return false;
	}
	
//	public void verifySearch(WebElement elementDisplaying, String enteredData, String filterName)
//	{
//		logger.info(filterName+" entered is: "+enteredData);
//		logger.info(filterName+" is displaying is "+elementDisplaying.getText());
//		Assert.assertEquals(elementDisplaying.getText(), enteredData, filterName+" entered and "+filterName+" is displaying are not same.");
//	}
	
	public void verifySearch(String filterName, List<WebElement> elementList, String dataExp, WebElement nextLink, WebElement previousLink) throws InterruptedException
	{
		Thread.sleep(2000);
		int noOfElements = countNoOfRecords(elementList, nextLink, previousLink);
		logger.info("Number of records present for this "+filterName+" are: "+noOfElements);
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
	
	public void testReportCoreJobReport() throws InterruptedException
	{
			verifyPage();
			selectDates("03-07-2019");
			Thread.sleep(5000);
			waitTillElementIsVisible(firstRow);
			if(verifyData())
			{
				logger.info("No Bulk Job is done available within the selected timeline.");
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			String initiatorId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 14, path);
			searchByInitiatorId(initiatorId);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("No Bulk Job is performed for this Initiator Id "+initiatorId);
				return;
			}
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			String initiatorType = initiatorTypeDisplaying.getText();
			String jobStatus = jobStatusDisplaying.getText();
			
			verifySearch("Inbitiator Id", initiatorIdDisplayingList, initiatorId, nextBtnLink, previousLink);
			clearInitiatorIdFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
			
			searchByInitiatorType(initiatorType);
			
			searchByJobStatus(jobStatus);
			
			downloadReport(reportDownloadBtn);
			Thread.sleep(5000);
				
		}
	
	
}
