package com.mobiotics.HITSAdmin.BulkHardwareHardwareReplacement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.BulkHardwareRetrack.BulkHardwareRetrackPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class BulkHardwareHardwareReplacementPage extends BasePage {
	
	
public BulkHardwareHardwareReplacementPage()
{
	PageFactory.initElements(driver, this);
}

	static final Logger logger = Logger.getLogger(BulkHardwareHardwareReplacementPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\bulkDataFiles\\bulkhardwarereplacement.csv";
	
	
	@FindBy(xpath = "//h1[contains(text(), 'Hardware Replacement')]")
	private WebElement pageTitleTxt;
	
	@FindBy(xpath = "//label[@for='inputEmail3']")
	private WebElement uploadFileLabel;
	
	@FindBy(xpath = "//input[@type = 'file'][@id = 'hardwareselect']")
	private WebElement uploadFileField;
	
	@FindBy(id = "hardwareupload")
	private WebElement uploadBtn;
	
	@FindBy(id = "hardware-upload-status")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id = "replacementbutton")
	private WebElement replacementBtn;
	
	
	
	
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "Hardware Replacement", "Page Title is not correct.");
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
			waitTillElementIsClickable(replacementBtn);
			replacementBtn.click();
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
	}
	


}