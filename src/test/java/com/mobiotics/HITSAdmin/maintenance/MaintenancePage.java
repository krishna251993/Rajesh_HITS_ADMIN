package com.mobiotics.HITSAdmin.maintenance;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mobiotics.HITSAdmin.commonpages.BasePage;
import com.mobiotics.HITSAdmin.utilities.DemoExcelLibrary3;

public class MaintenancePage extends BasePage {

	public MaintenancePage() {
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(MaintenancePage.class);

	private String path = System.getProperty("user.dir") + "\\excelFiles\\tsetData.xls";

	@FindBy(xpath = "//h4[contains(text(), 'Maintenance Mode')]")
	private WebElement pageHeader;

	@FindBy(id = "password")
	private WebElement passwordTxtFld;

	@FindBy(xpath = "//input[@value='LCO']")
	private WebElement lcoRadioBtn;

	@FindBy(xpath = "//input[@value='slate']")
	private WebElement slateMsgRadioBtn;

	@FindBy(xpath = "//input[@name='slatemode'][@value='YES']")
	private WebElement slateMsgOn;

	@FindBy(xpath = "//input[@name='slatemode'][@value='NO']")
	private WebElement slateMsgOff;

	@FindBy(id = "message")
	private WebElement msgTxtFld;

	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedBtn;

	private String password = DemoExcelLibrary3.getexcelData("hits admin data", 1, 22, path);

	public void createSlateMsg() throws InterruptedException {

		passwordTxtFld.sendKeys(password);
		if (!(lcoRadioBtn.isSelected())) {
			lcoRadioBtn.click();
			logger.info("Selected LCO portal");
		}

		if (!(slateMsgRadioBtn.isSelected())) {
			slateMsgRadioBtn.click();
			logger.info("Selected Slate Message");
		}

		if (!(slateMsgOn.isSelected())) {
			slateMsgOn.click();
			logger.info("Slate Message is ON");
			Thread.sleep(3000);
		}
		msgTxtFld.sendKeys("Automation Testing....");
		Thread.sleep(2000);
		proceedBtn.click();
		Thread.sleep(4000);
		if (driver.getTitle().equalsIgnoreCase("Dashboard")) {
			logger.info("Slate Message Created Successfully.");
		}

	}

	public void disableSlateMsg() throws InterruptedException {
		passwordTxtFld.sendKeys(password);
		if (!(lcoRadioBtn.isSelected())) {
			lcoRadioBtn.click();
			logger.info("Selected LCO portal");
		}

		if (!(slateMsgRadioBtn.isSelected())) {
			slateMsgRadioBtn.click();
			logger.info("Selected Slate Message");
		}

		if (!(slateMsgOff.isSelected())) {
			slateMsgOff.click();
			Thread.sleep(2000);
		}
		proceedBtn.click();
		Thread.sleep(4000);
		if (driver.getTitle().equalsIgnoreCase("Dashboard")) {
			logger.info("Slate Message disabled.");
		}
		
		Thread.sleep(5000);
	}
	

}
