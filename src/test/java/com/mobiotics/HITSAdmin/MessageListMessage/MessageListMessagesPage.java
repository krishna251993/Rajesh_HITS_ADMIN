package com.mobiotics.HITSAdmin.MessageListMessage;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;



public class MessageListMessagesPage extends BasePage {

	public MessageListMessagesPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(MessageListMessagesPage.class);

	
	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstMessageRow;

	@FindBy(id = "createMessage_btn")
	private WebElement createAlertMsgBtn;

	@FindBy(id = "myModalLabel")
	private WebElement addAlertMsgLbl;

	@FindBy(id = "priority")
	private WebElement priorityList;

	@FindBy(id = "alerttype")
	private WebElement alertTypeList;

	@FindBy(id = "entitytype")
	private WebElement entityTypeList;

	@FindBy(id = "description")
	private WebElement descriptionTxtArea;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBtn;

	@FindBy(id = "lcousername")
	private WebElement lcoUserNameTxtFld;

	@FindBy(id = "msousername")
	private WebElement msoUserName;
	
	@FindBy(xpath = "//p[@class='text-error error']")
	private WebElement errMsg;

	@FindBy(xpath = "(//button[text()='Close'])[2]")
	private WebElement closePopUpBtn;

	@FindBy(id = "deleteMessageButton")
	private WebElement deleteMsgBtn;

	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()]")
	private List<WebElement> deleteBtnList;
	
	@FindBy(xpath = "//button[@class='btn btn-danger deleteConfirm']")
	private WebElement deleteBtnPopUp;
	
	@FindBy(id = "close")
	private WebElement closeBtnDelPopUp;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> alertMesagesRows;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> alertMsgTxtList;
	
	

	public int createAlertMsg() throws InterruptedException {
		int count = 0;
		for (int i = 1; i < 4; i++) {
			String alertType = DemoExcelLibrary3.getexcelData("hits admin data", i, 3, path);
			if (alertType.equals("CUSTOMER")) {
				for (int j = 1; j < 4; j++) {
					Thread.sleep(2000);
					waitTillElementIsVisible(createAlertMsgBtn);
					createAlertMsgBtn.click();
					selectElement(priorityList, "1");
					Thread.sleep(2000);
					waitTillElementIsVisible(alertTypeList);
					selectElement(alertTypeList, alertType);
					String entityType = DemoExcelLibrary3.getexcelData("hits admin data", j, 4, path);
					if (entityType.equalsIgnoreCase("LCO")) {
						selectElement(entityTypeList, entityType);
						waitTillElementIsVisible(lcoUserNameTxtFld);
						lcoUserNameTxtFld.sendKeys("LCO200000955.01");

					}
					if (entityType.equalsIgnoreCase("MSO")) {
						selectElement(entityTypeList, entityType);
						waitTillElementIsVisible(msoUserName);
						msoUserName.sendKeys("WLMSO00000199.98");
					} else
						selectElement(entityTypeList, entityType);

					descriptionTxtArea.sendKeys("This is Alert message for Automation script " + alertType +" "+entityType);
					Thread.sleep(4000);
					createBtn.click();
					Thread.sleep(6000);
					
					if(!(errMsg.getText().equals("")))
					{
						logger.info(errMsg.getText());
						descriptionTxtArea.clear();
						Thread.sleep(1000);
						closePopUpBtn.click();
						Thread.sleep(2000);
					}
					else {
						count++;
					}

				}
			}

			else {
				createAlertMsgBtn.click();
				selectElement(priorityList, "1");
				selectElement(alertTypeList, alertType);
				descriptionTxtArea.sendKeys("This is Alert message for Automation script "  + alertType);
				Thread.sleep(7000);
				createBtn.click();
				Thread.sleep(7000);
				
				if(!(errMsg.getText().equals("")))
				{
					logger.info(errMsg.getText());
					descriptionTxtArea.clear();
					Thread.sleep(1000);
					closePopUpBtn.click();
					Thread.sleep(2000);
				}
				else {
					count++;
				}
			}
		}
		return count;
	}
	
	
	public int deleteMessages(List<WebElement> eleList, List<WebElement> delBtnList) throws InterruptedException
	{
		int i=0, count = 0;
		while(i<eleList.size())
		{
			String alertMsgTxt = eleList.get(i).getText();
			if(alertMsgTxt.contains("This is Alert message for Automation script"))
			{
				delBtnList.get(i).click();
				Thread.sleep(4000);
				waitTillElementIsVisible(deleteBtnPopUp);
				deleteBtnPopUp.click();
				waitTillElementIsClickable(closeBtnDelPopUp);
				closeBtnDelPopUp.click();
				Thread.sleep(4000);
				count++;
			}
			else
			{
				i++;
			}
		}
		
		
		return count;
		
	}
	
	
	
	
	public void testListMessage() throws InterruptedException
	{
		int noOfMessagesPresent = countNoOfMessages(alertMesagesRows);
		logger.info("Number of messages present are: "+noOfMessagesPresent);
		int noOfmessagesCreated = createAlertMsg();
		logger.info("Number of new alert messages created are: "+noOfmessagesCreated);
		int noOfMessagesDeleted = deleteMessages(alertMsgTxtList, deleteBtnList);
		logger.info("Number of messages deleted are: "+noOfMessagesDeleted);
		
		
	}
	

}
