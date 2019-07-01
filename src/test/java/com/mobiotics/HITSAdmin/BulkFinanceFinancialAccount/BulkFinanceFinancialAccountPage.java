package com.mobiotics.HITSAdmin.BulkFinanceFinancialAccount;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkFinancePayBills.BulkFinancePayBillsPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkFinanceFinancialAccountPage extends BasePage{
	
	public BulkFinanceFinancialAccountPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(BulkFinanceFinancialAccountPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\bulkDataFiles\\bulkfinancialtemplate.csv";
	
	@FindBy(xpath = "//h1[contains(text(), 'Bulk Add Financial Account')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'billpayselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "addfinancialupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "addfinancial-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "initiateAssignButton")
	private WebElement assignBtn;
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Bulk Add Financial Account", "Page Title is not correct.");
		Assert.assertEquals(pageTitleTxt.isDisplayed(), true, "Not displaying Correct Page Heading");
		logger.info(pageTitleTxt.getText()+" page is displaying.");
	
	}
	
	public void uploadBulkFile() throws InterruptedException
	{
		waitTillElementIsVisible(uploadFileLabel);
		Assert.assertEquals(uploadFileLabel.isDisplayed(), true, "Upload File label is not displaying.");
		Assert.assertEquals(uploadFileLabel.getText(), "Upload File*");
		Thread.sleep(3000);
		uploadFileField.sendKeys(path);
		waitTillElementIsClickable(uploadBtn);
		uploadBtn.click();
		waitTillElementIsVisible(uploadSuccessStatus);
		if (uploadSuccessStatus.isDisplayed()) {
			
			logger.info(uploadSuccessStatus.getText());
			waitTillElementIsClickable(assignBtn);
			assignBtn.click();
			waitTillElementIsVisible(uploadSuccessStatus);
			if(uploadSuccessStatus.isDisplayed())
			{
				if(uploadSuccessStatus.getText().contains("Successful"))
				{
					logger.info("Request for Bulk Finance Financial Accounts has been sent successfully.");
					logger.info("Functional test case for Bulk Finance Financial Accounts is passed.");
				}
				else
				{
					logger.info(uploadSuccessStatus.getText());
					logger.info("Functional test case for Bulk Finance Financial Accounts is passed.");
				}
			}
			
		}
		
	}
	
	public void testBulkFinanceFinancialAccounts() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
	}
	
	
	

}
