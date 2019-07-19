package com.mobiotics.HITSAdmin.BanksListBanks;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;

public class BanksListBanksPage extends BasePage{
	
	public BanksListBanksPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(BanksListBanksPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(xpath = "//h1[contains(text(), 'Bank List')]")
	private WebElement pageName;
	
	@FindBy(id = "status")
	private WebElement statusDropDown;
	
	@FindBy(xpath = "//input[@placeholder='Search By Bank Name']")
	private WebElement searchBankNameTxtFld;
	
	@FindBy(xpath = "//input[@placeholder='Search By Bank Name']/following-sibling::button")
	private WebElement searchBankNameGoBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()]")
	private List<WebElement> stausDisplayingList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private List<WebElement> bankNameDisplayingList;
	
	@FindBy(xpath = "//button[contains(text(), 'Add Bank')]")
	private WebElement addBankBtn;
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement addBankPopUp;
	
	@FindBy(id = "bankid")
	private WebElement bankIdTxtFld;
	
	@FindBy(id = "bankname")
	private WebElement bankNameTxtFld;
	
	@FindBy(id = "bankstatus")
	private WebElement bankStatusDropDownPopUp;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement createBtn;
	
	@FindBy(id = "close")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> bankIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> tableRecords;
	
	@FindBy(xpath = "//p[@class='error text-danger']")
	private WebElement addBankErrMsg;
	
	@FindBy(xpath = "//p[@class='success text-success']")
	private WebElement addBankSuccessMsg;
	
	public void verifyPage()
	{
		logger.info("Verify Page----------");
		Assert.assertEquals(driver.getTitle(), "Admin Bank List", "Page title is not correct.");
		if(pageName.getText().contains("Bank List"))
		{
			logger.info("Page Name is: "+pageName.getText());
		}
		else
		{
			Assert.assertFalse(false);
		}
	}
	
	public void searchBankByStatus(String status)
	{
		logger.info("Search Banks by status--------"+status);
		selectElement(statusDropDown, status);
		for(int i=0; i<stausDisplayingList.size(); i++)
		{
			if(!(stausDisplayingList.get(i).getText().equalsIgnoreCase(status)))
			{
				Assert.assertFalse(false, "Status is not displaying properly.");
			}
		}
		logger.info("All the banks are displaying with the selected status: "+status);
		
	}
	
	public void searchBankByBankName(String bankName) throws InterruptedException
	{
		logger.info("Search Bank By Name--------");
		searchBankNameTxtFld.sendKeys(bankName);
		waitTillElementIsClickable(searchBankNameGoBtn);
		searchBankNameGoBtn.click();
		Thread.sleep(2000);
		for(int i=0; i<bankNameDisplayingList.size(); i++)
		{
			if(!(bankNameDisplayingList.get(i).getText().contains("[?"+bankName+"]")))
			{
				Assert.assertFalse(false, "Bank Name is not displaying properly.");
				logger.info(tableRecords.get(i).getText());
				return;
			}
		}
		
		
		
	}
	
	public void addBank(String bankId, String bankName, String status) throws InterruptedException
	{
		logger.info("Add Bank---------------");
		waitTillElementIsClickable(addBankBtn);
		addBankBtn.click();
		waitTillElementIsVisible(addBankPopUp);
		waitTillElementIsClickable(bankNameTxtFld);
		bankIdTxtFld.sendKeys(bankId);
		bankNameTxtFld.sendKeys(bankName);
		Thread.sleep(2000);
		selectElement(bankStatusDropDownPopUp, status);
		waitTillElementIsClickable(createBtn);
		createBtn.click();
		Thread.sleep(2000);
		if(!(addBankSuccessMsg.getText().equals("")))
		{
			logger.info(addBankSuccessMsg.getText());
		}
		
		else if(!(addBankErrMsg.getText().equals("")))
		{
			logger.info("Bank is not added successfully because: "+addBankErrMsg.getText());
		}
		waitTillElementIsClickable(closeBtn);
		closeBtn.click();
		
		
	}
	
	public void verifyAddedBank(String bankId)
	{
		logger.info("Verify Bank details------------------");
		boolean br = false;
		for(int i=0; i<bankIdDisplaying.size(); i++)
		{
			
			if((bankIdDisplaying.get(i).getText().equals(bankId)))
			{
				logger.info("The bank details for ID: "+bankId+ " is: ");
				logger.info(tableRecords.get(i).getText());
				br=true;
				return;
			}
		}
		if(br == false)
		{
			logger.info("Bank with Id: "+bankId+" is not present.");
		}
		
	}
	
	public void changeStatus(String bankId) throws InterruptedException
	{
		logger.info("Change status--------------");
		for(int i=0; i<bankIdDisplaying.size(); i++)
		{
			if((bankIdDisplaying.get(i).getText().equals(bankId)))
			{
				logger.info("Bank details for the given bank ID: "+bankId);
				logger.info(tableRecords.get(i).getText());
				logger.info("Current status is: "+stausDisplayingList.get(i).getText());
				stausDisplayingList.get(i).click();
				Thread.sleep(2000);
				logger.info("Current status after changing is: "+stausDisplayingList.get(i).getText());
				logger.info(tableRecords.get(i).getText());
				return;
			}
		}
	}
	
	
	public void testListBanks() throws InterruptedException
	{
		verifyPage();
		String status = DemoExcelLibrary3.getexcelData("hits admin data", 1, 5, path);
		String bankName = DemoExcelLibrary3.getexcelData("hits admin data", 1, 6, path);
		String bankId = DemoExcelLibrary3.getexcelData("hits admin data", 1, 7, path);
		addBank(bankId, bankName, status);
		Thread.sleep(4000);
		verifyAddedBank(bankId);
		Thread.sleep(4000);
		changeStatus(bankId);
		Thread.sleep(4000);
		searchBankByBankName(bankName);
		Thread.sleep(4000);
		searchBankByStatus(status);
		Thread.sleep(5000);
		
	}
	
	
	
	
	
	
}
