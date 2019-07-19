package com.mobiotics.HITSAdmin.MessageListMessage;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	@FindBy(xpath = "//p[@class='success text-success']")
	private WebElement successMsgOfDeleteMsg;
	
	@FindBy(xpath = "//p[@class= 'error text-danger']")
	private WebElement errMsgOfDeleteMsg;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> alertMesagesRows;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private List<WebElement> alertMsgTxtList;
	
	

	public int createAlertMsg() throws InterruptedException {
		int count = 0;
		for (int i = 1; i < 4; i++) {
			Thread.sleep(3000);
			String alertType = DemoExcelLibrary3.getexcelData("hits admin data", i, 3, path);
			if (alertType.equals("CUSTOMER")) {
				for (int j = 1; j < 4; j++) {
					Thread.sleep(4000);
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
					Thread.sleep(5000);
					createBtn.click();
					Thread.sleep(6000);
					
					if(!(errMsg.getText().equals("")))
					{
						logger.info(errMsg.getText());
						descriptionTxtArea.clear();
						Thread.sleep(3000);
						closePopUpBtn.click();
						Thread.sleep(3000);
					}
					else {
						count++;
					}

				}
			}

			else {
				Thread.sleep(4000);
				waitTillElementIsClickable(createAlertMsgBtn);
				createAlertMsgBtn.click();
				Thread.sleep(4000);
				waitTillElementIsClickable(priorityList);
				selectElement(priorityList, "1");
				Thread.sleep(3000);
				waitTillElementIsClickable(alertTypeList);
				selectElement(alertTypeList, alertType);
				descriptionTxtArea.sendKeys("This is Alert message for Automation script "  + alertType);
				Thread.sleep(7000);
				createBtn.click();
				Thread.sleep(7000);
				
				if(!(errMsg.getText().equals("")))
				{
					logger.info(errMsg.getText());
					descriptionTxtArea.clear();
					Thread.sleep(2000);
					closePopUpBtn.click();
					Thread.sleep(3000);
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
			Thread.sleep(3000);
//			Pattern pattern1 =Pattern.compile("This is Alert message for Automation script");
//			Matcher matcher = pattern1.matcher(eleList.get(i).getText());
//			if(matcher.lookingAt())
//			{
//				
//			}
			
			String alertMsgTxt = eleList.get(i).getText();
			if(alertMsgTxt.contains("This is Alert message for Automation script"))
			{
				Thread.sleep(5000);
				waitTillElementIsClickable(delBtnList.get(i));
				delBtnList.get(i).click();
				Thread.sleep(7000);
				waitTillElementIsClickable(deleteBtnPopUp);
				deleteBtnPopUp.click();
				Thread.sleep(6000);
				
				if(!(successMsgOfDeleteMsg.getText().equals("")))
				{
					waitTillElementIsClickable(closeBtnDelPopUp);
					closeBtnDelPopUp.click();
					Thread.sleep(4000);
					count++;
				}
					
				else
				{
					logger.info(alertMsgTxt+" is not deleted ");
					logger.info(errMsgOfDeleteMsg.getText());
					waitTillElementIsClickable(closeBtnDelPopUp);
					closeBtnDelPopUp.click();
					Thread.sleep(4000);
				}
				
				
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
		Thread.sleep(5000);
		
	}
	
	
	

}
