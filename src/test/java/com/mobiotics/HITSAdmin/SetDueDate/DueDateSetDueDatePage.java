package com.mobiotics.HITSAdmin.SetDueDate;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

import com.mobiotics.HITSAdmin.MessageListMessage.MessageListMessagesPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

import generics.DateHelper;

public class DueDateSetDueDatePage extends BasePage {

	public DueDateSetDueDatePage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(DueDateSetDueDatePage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(id = "date")
	private WebElement dateList;

	@FindBy(id = "comment")
	private WebElement commentTxtArea;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBtn;

	@FindBy(xpath = "//p[@class='text-success success']")
	private WebElement successMsg;

	@FindBy(xpath = "//p[@class='text-error error']")	
	private WebElement errMsg;

	public void testSEtDueDate() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(), "Set DueDate", "This is not the Set DueDate Page.");
		selectElement(dateList, "2");
		commentTxtArea.sendKeys("Test SetDueDate for Automation.");
		createBtn.click();
		Thread.sleep(4000);
		
		if (!((successMsg.getText()).equals("")))
		{
				logger.info(successMsg.getText());
		}
		if (!((errMsg.getText()).equals("")))
		{
				logger.info(errMsg.getText());
		}
	
		Thread.sleep(5000);
	}
}