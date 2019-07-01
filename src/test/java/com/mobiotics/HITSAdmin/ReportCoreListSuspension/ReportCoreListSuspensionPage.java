package com.mobiotics.HITSAdmin.ReportCoreListSuspension;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.ReportCoreListActivations.ReportCoreListActivationsPage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;
import generics.ReportUtilityClass;

public class ReportCoreListSuspensionPage extends ReportUtilityClass{
	
	public ReportCoreListSuspensionPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ReportCoreListSuspensionPage.class);

	private static String fromDateXp1 = "/html/body/div[3]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	private static String fromDateXp2 = "]/td[";
	private String path = System.getProperty("user.dir")+"\\excelFiles\\tsetData.xls";
	
	private DateHelper dh = new DateHelper();
	
	@FindBy(xpath = "//h1[contains(text(), 'Suspension')]")
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
	
	@FindBy(xpath = "//div[text()='Count : ']/span")
	private WebElement countValueNumber;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> listOfRecords;
	
	@FindBy(name = "customerid")
	private WebElement customerIdTxtFld;
	
	@FindBy(xpath = "//input[@name='customerid']/following-sibling::button")
	private WebElement customerIdGoBtn;
	
	@FindBy(name = "lcoid")
	private WebElement lcoIdTxtFld;
	
	@FindBy(xpath = "//input[@name='lcoid']/following-sibling::button")
	private WebElement lcoIdGoBtn;
	
	@FindBy(id = "activitystatus")
	private WebElement activityStatusList;
	
	@FindBy(id = "devicestatus")
	private WebElement deviceStatusList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[4]")
	private WebElement lcoIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-2]")
	private WebElement activatyStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-3]")
	private WebElement deviceStatusDisplaying;
	
	@FindBy(xpath = "//button[contains(text(), 'Suspension Download')]")
	private WebElement suspensionDownloadBtn;
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Admin Suspension List", "Page Title is not correct.");
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
	
	public void searchByCustomerId(String customerId)
	{
		searchByTextFilter(customerIdTxtFld, customerIdGoBtn, customerId);
	}
	
	public void searchByLCOId(String lcoId)
	{
		searchByTextFilter(lcoIdTxtFld, customerIdGoBtn, lcoId);
	}
	
	public void searchByActivityStatus(String activityStatus)
	{
		selectElement(activityStatusList, activityStatus);
	}
	
	public void searchBydeviceStatus(String deviceStatus)
	{
		selectElement(deviceStatusList, deviceStatus);
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
			if(verifyData())
			{
				logger.info("No suspension is done within the selected timeline.");
				return;
			}
			String customerId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 12, path);
			searchByCustomerId(customerId);
			Thread.sleep(4000);
			if (verifyData()) 
			{
				return;
			}
			verifySearch(customerIdDisplaying, customerId, "Customer Id");
			
			String lcoId = lcoIdDisplaying.getText();
			String activityStatus = activatyStatusDisplaying.getText();
			String deviceStatus = deviceStatusDisplaying.getText();
			
			searchByLCOId(lcoId);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Suspension for the LCO Id "+lcoId);
				return;
			}
			verifySearch(lcoIdDisplaying, lcoId, "LCO Id");
			
			searchByActivityStatus(activityStatus);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Suspension with the Activity Status "+activityStatus);
				return;
			}
			verifySearch(activatyStatusDisplaying, activityStatus, "Activity Status");
			
			searchBydeviceStatus(deviceStatus);
			Thread.sleep(2000);
			if (verifyData()) 
			{
				logger.info("There is no Suspension with the Device Status "+deviceStatus);
				return;
			}
			verifySearch(deviceStatusDisplaying, deviceStatus, "Device Status");
			
			downloadReport(suspensionDownloadBtn);
				
		}
		
		
	
}
