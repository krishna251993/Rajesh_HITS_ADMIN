package com.mobiotics.SubuserModifySubuser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.HITSAdmin.SubuserAddSubuserPage.SubuserAddSubuserPage;
import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;

public class SubuserModifySubuser extends BasePage {
	
	public SubuserModifySubuser() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(SubuserModifySubuser.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();
	
	@FindBy(id = "subuser")
	private WebElement subUserDropDown;
	
	@FindBy(id = "adminname")
	private WebElement amdinNameTxtFld;
	
	@FindBy(id = "password")
	private WebElement passwordTxtFld;
	
	@FindBy(id = "passphrase")
	private WebElement passphraseTxtFld;
	
	@FindBy(id = "type")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//div[@class='btn-group']/button")
	private WebElement permissinDropDownBtn;
	
	@FindBy(xpath = "//input[@value='mso']")
	private WebElement msoPermissionChBox;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//p[@class='text-error error']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='text-success success']")
	private WebElement successMsg;
	
	@FindBy(xpath = "//div[@class='alert alert-success top-success text-center']")
	private WebElement finalSuccessMsg;
	
	@FindBy(xpath = "//div[@class='alert alert-danger top-error text-center']")
	private WebElement finalErrMsg;
	
	@FindBy(id = "updatesubuser")
	private WebElement updateSubuserForm;
	
	
	public void testModifySubUser() throws InterruptedException
	{
		String adminid = DemoExcelLibrary3.getexcelData("hits admin data", 1, 19, path);
		selectElement(subUserDropDown, adminid);
		amdinNameTxtFld.clear();
		Thread.sleep(1000);
		amdinNameTxtFld.sendKeys("xyz");
		passwordTxtFld.sendKeys("test");
		passphraseTxtFld.clear();
		passphraseTxtFld.sendKeys("indigital123");
		selectElement(typeDropDown, "Subuser");
		
		if(permissinDropDownBtn.isEnabled())
		{
			permissinDropDownBtn.click();
			Thread.sleep(1000);
			msoPermissionChBox.click();
			Thread.sleep(500);
			updateSubuserForm.click();
			
		}
		createBtn.click();
		Thread.sleep(1000);
		try
		{
			waitForElementPresence("//div[@class='alert alert-danger top-error text-center']");
			logger.info(finalErrMsg.getText());
		}
		catch (Exception e) {
			
		}	
		
		if(!(amdinNameTxtFld.isEnabled()))
		{
			logger.info("User modified successfully.");
		}
		
		else if(!((successMsg.getText()).equals("")))
		{
			logger.info(successMsg.getText());
		}
		
		else if(!((errMsg.getText()).equals("")))
		{
			logger.info(errMsg.getText());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
