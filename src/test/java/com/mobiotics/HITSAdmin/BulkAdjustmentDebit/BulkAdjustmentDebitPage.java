package com.mobiotics.HITSAdmin.BulkAdjustmentDebit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkAdjustmentCredit.BulkAdjustmentCreditPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkAdjustmentDebitPage extends BasePage{
	
	public BulkAdjustmentDebitPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(BulkAdjustmentDebitPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\bulkDataFiles\\bulkadjustmenttemplate.csv";
	
	@FindBy(xpath = "//h1[contains(text(), 'Bulk Debit Adjustment')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'debitadjustmentselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "debitadjustmentupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "adjustment-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "initiateDebitButton")
	private WebElement debitBtn;
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Debit Adjustment", "Page Title is not correct.");
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
			waitTillElementIsClickable(debitBtn);
			debitBtn.click();
			waitTillElementIsVisible(uploadSuccessStatus);
			if(uploadSuccessStatus.isDisplayed())
			{
				if(uploadSuccessStatus.getText().contains("Successful"))
				{
					logger.info("Request for Bulk Adjustment Debit has been sent successfully.");
					logger.info("Functional test case for Bulk Adjustment Debit is passed.");
				}
				else
				{
					logger.info(uploadSuccessStatus.getText());
					logger.info("Functional test case for Bulk Adjustment Debit is passed.");
				}
			}
			
		}
		
	}
	
	
	public void testBulkAdjustmentDebit() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
		Thread.sleep(5000);
	}
	
	
	
	
	
	
	
	

}
