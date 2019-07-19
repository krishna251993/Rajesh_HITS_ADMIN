package com.mobiotics.HITSAdmin.BulkActivationCreateSubscriber;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkActivationsBasePack.BulkActivationBasePackPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkActivationCreateSubscriber extends BasePage{
	
	public BulkActivationCreateSubscriber()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger=Logger.getLogger(BulkActivationCreateSubscriber.class);
	
	private String path = System.getProperty("user.dir")+"\\excelFiles\\bulkDataFiles\\bulkcreatecustomertemplate.csv";
	
	
	@FindBy(xpath = "//h1[contains(text(), 'Subscriber')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'createcustselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "createcustupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "create-cust-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "createcustbutton")
	private WebElement createSubscriberBtn;
	
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Subscriber", "Page Title is not correct.");
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
			waitTillElementIsClickable(createSubscriberBtn);
			createSubscriberBtn.click();
			waitTillElementIsVisible(uploadSuccessStatus);
			if(uploadSuccessStatus.getText().equals("Successful"))
			{
				logger.info("Request for Bulk Create Subscriber has been sent successfully.");
				logger.info("Functional test case for Bulk Create Subscriber is passed.");
			}
		}
		
	}
	
	public void testBulkCreateSubscriber() throws InterruptedException
	{
		verifyPage();
		uploadBulkFile();
		Thread.sleep(5000);
	}

}
