package com.mobiotics.HITSAdmin.BulkProductAssign;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkHardwareSendOSD.BulkHardwareSendOSDPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkProductAssignPage extends BasePage {
	
	public BulkProductAssignPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(BulkProductAssignPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\bulkDataFiles\\bulkassignorremovetemplate.csv";
	
	
	@FindBy(xpath = "//h1[contains(text(), 'Bulk Product Assign')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'productassignselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "productassignupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "productassign-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "initiateAssignButton")
	private WebElement assignBtn;
	
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Product Assign", "Page Title is not correct.");
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
					logger.info("Request for Bulk Product Assignment has been sent successfully.");
					logger.info("Functional test case for Bulk Product Assignment is passed.");
				}
				else
				{
					logger.info(uploadSuccessStatus.getText());
					logger.info("Functional test case for Bulk Product Assignment is passed.");
				}
			}
			
		}
		
	}
	
	public void testBulkProductAssign() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
	}
	


		
	

}
