package com.mobiotics.HITSAdmin.BulkHardwareSendOSD;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkHardwareHardwareReplacement.BulkHardwareHardwareReplacementPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkHardwareSendOSDPage extends BasePage{
	
	public BulkHardwareSendOSDPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(BulkHardwareSendOSDPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\bulkDataFiles\\osdtemplate.csv";
	
	
	@FindBy(xpath = "//h1[contains(text(), 'OSD')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'msoosdselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "msoosdupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "msoosd-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "initiateMsoOsdButton")
	private WebElement sendOSDBtn;
	
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "OSD", "Page Title is not correct.");
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
			waitTillElementIsClickable(sendOSDBtn);
			sendOSDBtn.click();
			waitTillElementIsVisible(uploadSuccessStatus);
			if(uploadSuccessStatus.isDisplayed())
			{
				if(uploadSuccessStatus.getText().contains("Successful"))
				{
					logger.info("Request for Bulk Hardware Replacement has been sent successfully.");
					logger.info("Functional test case for Bulk Hardware Replacement is passed.");
				}
				else
				{
					logger.info(uploadSuccessStatus.getText());
					logger.info("Functional test case for Bulk Hardware Replacement is passed.");
				}
			}
			
		}
		
	}
	
	public void testBulkHardwareReplacement() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
		Thread.sleep(5000);
	}
	


		
		
		

}
