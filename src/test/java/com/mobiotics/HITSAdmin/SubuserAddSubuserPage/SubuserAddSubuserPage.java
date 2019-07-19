package com.mobiotics.HITSAdmin.SubuserAddSubuserPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

import generics.DateHelper;

public class SubuserAddSubuserPage extends BasePage{
	
	
	public SubuserAddSubuserPage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(SubuserAddSubuserPage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	private DateHelper dh = new DateHelper();

	@FindBy(name = "adminid")
	private WebElement adminIdTxtfld;
	
	@FindBy(name = "adminname")
	private WebElement amdinNameTxtFld;
	
	@FindBy(name = "password")
	private WebElement passwordTxtFld;
	
	@FindBy(name = "passphrase")
	private WebElement passphraseTxtFld;
	
	@FindBy(id = "type")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//div[@class='btn-group']/button")
	private WebElement permissinDropDownBtn;
	
	@FindBy(xpath = "//input[@value='lco']")
	private WebElement lcoPermissionChBox;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//p[@class='text-error error']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='text-success success']")
	private WebElement successMsg;
	
	@FindBy(xpath = "//div[@class='alert alert-success top-success text-center']")
	private WebElement finalSuccessMsg;
	
	@FindBy(id = "addsubuser")
	private WebElement addSubuserForm;
	
	public void testAddSubuser() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(), "Add Subuser", "This is not the correct page.");
		
		String adminid = DemoExcelLibrary3.getexcelData("hits admin data", 1, 19, path);
		
		adminIdTxtfld.sendKeys(adminid);
		amdinNameTxtFld.sendKeys("xyz");
		passwordTxtFld.sendKeys("test");
		passphraseTxtFld.sendKeys("indigital123");
		selectElement(typeDropDown, "Subuser");
		if(permissinDropDownBtn.isEnabled())
		{
			permissinDropDownBtn.click();
			Thread.sleep(2000);
			lcoPermissionChBox.click();
			Thread.sleep(500);
			addSubuserForm.click();
			
		}
		createBtn.click();
		Thread.sleep(1000);
		try {
			waitForElementPresence("//div[@class='alert alert-success top-success text-center']");
			logger.info(finalSuccessMsg.getText());
		} catch (Exception e) {
			
		}
		
		
		if(!((successMsg.getText()).equals("")))
		{
			logger.info(successMsg.getText());
		}
		
		if(!((errMsg.getText()).equals("")))
		{
			logger.info(errMsg.getText());
		}
		
		Thread.sleep(5000);
		
	}
	
	

}
