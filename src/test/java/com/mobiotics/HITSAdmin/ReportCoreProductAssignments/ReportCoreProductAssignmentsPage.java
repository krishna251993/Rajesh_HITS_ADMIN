package com.mobiotics.HITSAdmin.ReportCoreProductAssignments;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreProductAssignmentsPage extends ReportUtilityClass{
	
	public ReportCoreProductAssignmentsPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreProductAssignmentsPage.class);

	private static String fromDateXp1 = "//div[@data-name='start']//table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h2[contains(text(), 'Assignment & Removal Report')]")
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
	
	@FindBy(name = "entityid")
	private WebElement entityIdTxtFld;
	
	@FindBy(xpath = "//input[@name='entityid']/following-sibling::button")
	private WebElement entityIdGoBtn;
	
	@FindBy(name = "jobid")
	private WebElement jobIdTxtFld;
	
	@FindBy(xpath = "//input[@name='jobid']/following-sibling::button")
	private WebElement jobIdGoBtn;
	
	@FindBy(id = "entitytype")
	private WebElement entityTypeList;
	
	@FindBy(id = "purpose")
	private WebElement purposeList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement entityIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> entityIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement jobIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private List<WebElement> jobIdDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement entityTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private List<WebElement> entityTypeDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement purposeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-2]")
	private List<WebElement> purposeDisplayingList;
	
	@FindBy(xpath = "//button[contains(text(), 'Report Download')]")
	private WebElement reportDownloadBtn;
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Product Assignment or Removal Report", "Page Title is not correct.");
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
	
	public void searchByEntityId(String entityId)
	{
		searchByTextFilter(entityIdTxtFld, entityIdGoBtn, entityId);
	}
	public void clearEntityIdFilter()
	{
		clearTextFilter(entityIdTxtFld, entityIdGoBtn);
	}
	
	
	public void searchByJobId(String jobId) throws InterruptedException
	{
		searchByTextFilter(jobIdTxtFld, jobIdGoBtn, jobId);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Product assignment and removal for the Job Id "+jobId);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Job Id", jobIdDisplayingList, jobId, nextBtnLink, previousLink);
		clearJobIdFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearJobIdFilter()
	{
		clearTextFilter(jobIdTxtFld, jobIdGoBtn);
	}
	
	
	public void searchByEntityType(String entityType) throws InterruptedException
	{
		selectElement(entityTypeList, entityType);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Product assignment and removal for the Entity Type "+entityType);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Entity Type", entityTypeDisplayingList, entityType, nextBtnLink, previousLink);
		clearByEntityTypeFilter();
		Thread.sleep(2000);
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearByEntityTypeFilter()
	{
		selectElement(entityTypeList, "ALL");
	}
	
	
	public void searchByPurpose(String purpose) throws InterruptedException
	{
		selectElement(purposeList, purpose);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		if (verifyData()) 
		{
			logger.info("There is no Product assignment and removal for the Purpose "+purpose);
			return;
		}
		waitForVisibiltyOfListOfElements(listOfRecords);
		verifySearch("Purpose", purposeDisplayingList, purpose, nextBtnLink, previousLink);
		clearPurposeFilter();
		waitForVisibiltyOfListOfElements(listOfRecords);
	}
	public void clearPurposeFilter()
	{
		selectElement(purposeList, "ALL");
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
	
	
	public void testReportCoreListSuspensions() throws InterruptedException
	{
			verifyPage();
			selectDates("01-06-2018");
			Thread.sleep(5000);
			
			if (verifyData()) 
			{
				logger.info("There is no Product assignment and removal details available within the selected timeline.");
				return;
			}
			
			String entityId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 13, path);
			searchByEntityId(entityId);
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			if (verifyData()) 
			{
				logger.info("There is no Product assignment and removal for the Entity Id "+entityId);
				return;
			}
			
			String jobId = jobIdDisplaying.getText();
			String entityType = entityTypeDisplaying.getText();
			String purpose = purposeDisplaying.getText();
			
			waitForVisibiltyOfListOfElements(listOfRecords);
			verifySearch("Entity Id", entityIdDisplayingList, entityId, nextBtnLink, previousLink);
			clearEntityIdFilter();
			waitForVisibiltyOfListOfElements(listOfRecords);
			
	
			searchByJobId(jobId);
			
			searchByEntityType(entityType);
			
			searchByPurpose(purpose);
			
			downloadReport(reportDownloadBtn);
			Thread.sleep(5000);	
		}
}
