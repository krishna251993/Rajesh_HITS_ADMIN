package com.mobiotics.HITSAdmin.BulkHardwareRetrack;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkActivationCreateSubscriber.BulkActivationCreateSubscriber;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkHardwareRetrackPage extends BasePage{
	
	
	public BulkHardwareRetrackPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger=Logger.getLogger(BulkHardwareRetrackPage.class);
	
	private String path = System.getProperty("user.dir")+"\\excelFiles\\bulkDataFiles\\bulkretracktemplate.csv";
	
	@FindBy(xpath = "//h1[contains(text(), 'Bulk Retrack')]")
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
	private WebElement retrackBtn;
	
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Admin Retrack", "Page Title is not correct.");
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
			waitTillElementIsClickable(retrackBtn);
			retrackBtn.click();
			waitTillElementIsVisible(uploadSuccessStatus);
			if(uploadSuccessStatus.getText().equals("Successful"))
			{
				logger.info("Request for Bulk Hardware Retrack has been sent successfully.");
				logger.info("Functional test case for Bulk Hardware Retrack is passed.");
			}
		}
		
	}
	
	public void testBulkHardwareRetrack() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
		Thread.sleep(5000);
	}
	

}
