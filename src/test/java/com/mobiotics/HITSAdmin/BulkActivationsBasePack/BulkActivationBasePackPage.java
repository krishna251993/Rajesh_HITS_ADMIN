package com.mobiotics.HITSAdmin.BulkActivationsBasePack;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.commonpages.BasePage;




public class BulkActivationBasePackPage extends BasePage{
	
	public BulkActivationBasePackPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger=Logger.getLogger(BulkActivationBasePackPage.class);
	
	private String path = System.getProperty("user.dir")+"\\excelFiles\\bulkDataFiles\\bulkaddbasepacktemplate.csv";
	
	@FindBy(xpath = "//h1[contains(text(), 'Admin Bulk Add Basepack')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'productsubscriptionselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "productsubscriptionupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "productsubscription-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "initiateSubscriptionButton")
	private WebElement initiateRenewBtn;
	
	@FindBy(id = "productsubscription-upload-status")
	private WebElement finalSuccessMsg;
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Admin Bulk Add Basepack", "Page Title is not correct.");
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
			waitTillElementIsClickable(initiateRenewBtn);
			initiateRenewBtn.click();
			waitTillElementIsVisible(finalSuccessMsg);
			if(finalSuccessMsg.isDisplayed())
			{
				logger.info("Request for Bulk Add Base Pack hasbeen sent successfully.");
				logger.info("Functional test case for Bulk Add Base Pack is passed.");
			}
		}
		
		
		
		
	}
	
	
	public void testBulkActivationBasePack() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
		Thread.sleep(5000);
	}
	


}
