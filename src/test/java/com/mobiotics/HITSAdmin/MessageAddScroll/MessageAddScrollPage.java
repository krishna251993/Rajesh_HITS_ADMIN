package com.mobiotics.HITSAdmin.MessageAddScroll;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.HITSAdmin.MessageListMessage.MessageListMessagesPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;

import generics.DateHelper;

public class MessageAddScrollPage extends BasePage{
	
	public MessageAddScrollPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(MessageListMessagesPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();
	
	@FindBy(id = "description")
	private WebElement descriptionTxtArea;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-info']") 
	private WebElement createBtn;
	
	@FindBy(xpath = "//p[@class='text-error error']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='text-success success']")
	private WebElement successMsg;
	
	
	public void testAddScrollMsg() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(), "Add Scroll", "This is not the Add Scroll Page");
		descriptionTxtArea.sendKeys("Add scroll message for Automation Testing.");
		Thread.sleep(2000);
		createBtn.click();
		Thread.sleep(4000);
		if(!(errMsg.getText()).equals(""))
		{
			logger.info(errMsg.getText());
		}
		if(!(successMsg.getText()).equals(""))
		{
			logger.info(successMsg.getText());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	


}
