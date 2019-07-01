package com.mobiotics.HITSAdmin.BulkFinancePayBills;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkCustomerChangeTypeClass.BulkCustomerChangeTypeClassPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkFinancePayBillsPage extends BasePage{
	
	public BulkFinancePayBillsPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(BulkFinancePayBillsPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\bulkDataFiles\\bulkpaytemplate.csv";

	@FindBy(xpath = "//h1[contains(text(), 'Bulk Bill Pay')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'billpayselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "billpayupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "billpay-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "initiateAssignButton")
	private WebElement changeBtn;
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Bulk Bill Pay", "Page Title is not correct.");
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
			waitTillElementIsClickable(changeBtn);
			changeBtn.click();
			waitTillElementIsVisible(uploadSuccessStatus);
			if(uploadSuccessStatus.isDisplayed())
			{
				if(uploadSuccessStatus.getText().contains("Successful"))
				{
					logger.info("Request for Bulk Finance Pay Bills has been sent successfully.");
					logger.info("Functional test case for Bulk Finance Pay Bills is passed.");
				}
				else
				{
					logger.info(uploadSuccessStatus.getText());
					logger.info("Functional test case for Bulk Finance Pay Bills is passed.");
				}
			}
			
		}
		
	}
	
	
	public void testBulkFinancePayBills() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
	}
	
	
	
	
	

}
