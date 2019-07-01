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

	private static String fromDateXp1 = "/html/body/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
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
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[3]")
	private WebElement initiatorTypeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement jobStatusDisplaying;
	
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
	
	public void searchByInitiatorType(String initiatorType)
	{
		selectElement(initiatorTyoeList, initiatorType);
	}
	
	public void searchByJobStatus(String jobStatus)
	{
		selectElement(jobStatusList, jobStatus);
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
	
	public void testReportCoreJobReport() throws InterruptedException
	{
			verifyPage();
			selectDates("01-06-2018");
			Thread.sleep(5000);
			if(verifyData())
			{
				logger.info("No Bulk Job is done available within the selected timeline.");
				return;
			}
			String initiatorId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 14, path);
			searchByInitiatorId(initiatorId);
			Thread.sleep(4000);
			if (verifyData()) 
			{
				logger.info("No Bulk Job is performed for this Initiator Id "+initiatorId);
				return;
			}
			verifySearch(initiatorIdDisplaying, initiatorId, "Initiator Id");
			
			String initiatorType = initiatorTypeDisplaying.getText();
			String jobStatus = jobStatusDisplaying.getText();
			
			searchByInitiatorType(initiatorType);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("No Bulk Job is performed for this Initiator Type "+initiatorType);
				return;
			}
			verifySearch(initiatorTypeDisplaying, initiatorType, "Initiator Id");
			
			searchByJobStatus(jobStatus);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("No Bulk Job is performed with this Job Status "+jobStatus);
				return;
			}
			verifySearch(jobStatusDisplaying, jobStatus, "Job Status");
			
			downloadReport(reportDownloadBtn);
				
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
