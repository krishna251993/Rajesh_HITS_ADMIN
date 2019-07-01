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

	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
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
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement jobIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement entityTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement purposeDisplaying;
	
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
	
	public void searchByJobId(String jobId)
	{
		searchByTextFilter(jobIdTxtFld, jobIdGoBtn, jobId);
	}
	
	public void searchByEntityType(String entityType)
	{
		selectElement(entityTypeList, entityType);
	}
	
	public void searchByPurpose(String purpose)
	{
		selectElement(purposeList, purpose);
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
	
	public void verifySearch(WebElement elementDisplaying, String enteredData, String filterName)
	{
		logger.info(filterName+" entered is: "+enteredData);
		logger.info(filterName+" is displaying is "+elementDisplaying.getText());
		Assert.assertEquals(elementDisplaying.getText(), enteredData, filterName+" entered and "+filterName+" is displaying are not same.");
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
			if (verifyData()) 
			{
				logger.info("There is no Product assignment and removal for the Entity Id "+entityId);
				return;
			}
			verifySearch(entityIdDisplaying, entityId, "Entity Id");
			
			String jobId = jobIdDisplaying.getText();
			String entityType = entityTypeDisplaying.getText();
			String purpose = purposeDisplaying.getText();
			
			searchByJobId(jobId);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Product assignment and removal for the Job Id "+jobId);
				return;
			}
			verifySearch(jobIdDisplaying, jobId, "Job Id");
			
			searchByEntityType(entityType);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Product assignment and removal for the Entity Type "+entityType);
				return;
			}
			verifySearch(entityTypeDisplaying, entityType, "Entity Type");
			
			searchByPurpose(purpose);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Product assignment and removal for the Purpose "+purpose);
				return;
			}
			verifySearch(purposeDisplaying, purpose, "Purpose");
			
			downloadReport(reportDownloadBtn);
				
		}
}
