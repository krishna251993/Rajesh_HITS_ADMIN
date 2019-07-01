package com.mobiotics.HITSAdmin.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu extends BasePage{
	
	public NavigationMenu() {
		PageFactory.initElements(driver, this);
	}
	
	//------This is for Operators------------
	@FindBy(xpath = "//a[text()='LCO']")
	public WebElement operatorsLCO;
	
	@FindBy(xpath = "//a[text()='MSO']")
	public WebElement operatorsMSO;
	
	@FindBy(xpath = "//a[text()='DPO']")
	public WebElement operatorsDPO;
	
	//-----------This is for Bulk---------------------
	
	@FindBy(xpath = "//a[text()='Activation']")
	public WebElement bulkActivation;
	//These are Activation submenus------------------
	@FindBy(xpath = "//a[text()='Basepack']")
	public WebElement bulkActivationBasepack;
	
	@FindBy(xpath = "//a[text()='Create Subscriber']")
	public WebElement bulkActivationCreateSubscriber;
	//------------------------------------------------
	
	
	@FindBy(xpath = "//a[text()='Hardware']")
	public WebElement bulkHardware;
	//This for hardware--------------------------------
	@FindBy(xpath = "//a[text()='Retrack']")
	public WebElement bulkHardwareRetrack;
	
	@FindBy(xpath = "//a[text()='Reconnect']")
	public WebElement bulkHardwareReconnect;
	
	@FindBy(xpath = "//a[text()='Disconnect']")
	public WebElement bulkHardwareDisconnect;
	
	@FindBy(xpath = "//a[text()='Cancel Product']")
	public WebElement bulkHardwareCancelProduct;
	
	@FindBy(xpath = "//a[text()='Hardware Replacement']")
	public WebElement bulkHardwareReplacement;
	
	@FindBy(xpath = "//a[text()='Send OSD']")
	public WebElement bulkHardwareSendOSD;
	//----------------------------------------------------
	
	//This for Bulk Product-------------------------------
	@FindBy(xpath = "//a[text()='Product']")
	public WebElement bulkProduct;
	
	@FindBy(xpath = "//a[text()='Assign']")
	public WebElement bulkProductAssign;
	
	@FindBy(xpath = "//a[text()='Remove']")
	public WebElement bulkProductRemove;
	//---------------------------------------------------
	
	//This is for Bulk > Customer------------------------
	@FindBy(xpath = "//a[text()='Customer']")
	public WebElement bulkCustomer;
	
	@FindBy(xpath = "//a[text()='Change Type & Class']")
	public WebElement bulkCustomerChangeTypeAndClass;
	//---------------------------------------------------
	
	//This is for Bulk > Finance-------------------------
	@FindBy(xpath = "(//a[text()='Finance'])[1]")
	public WebElement bulkFinance;
	
	@FindBy(xpath = "//a[text()='Pay Bills']")
	public WebElement bulkFinancePayBills;
	
	@FindBy(xpath = "//a[text()='Financial Account']")
	public WebElement bulkFinanceFinacialAccount;
	//---------------------------------------------------
	
	//This is for Bulk > Adjustment----------------------
	@FindBy(xpath = "//a[text()='Adjustment']")
	public WebElement bulkAdjustment;
	
	@FindBy(xpath = "//a[text()='Credit']")
	public WebElement bulkAdjustmentCredit;
	
	@FindBy(xpath = "//a[text()='Debit']")
	public WebElement bulkAdjustmentDebit;
	//---------------------------------------------------
	
	
	//----------------This is for Report-----------------
	@FindBy(xpath = "//a[text()='Core']")
	public WebElement reportCore;
	
	@FindBy(xpath = "//a[text()='List Customer']")
	public WebElement reportCoreListCustomer;
	
	@FindBy(xpath = "//a[text()='List Devices']")
	public WebElement reportCoreListDevices;
	
	@FindBy(xpath = "//a[text()='List Connections']")
	public WebElement reportCoreListConnections;
	
	@FindBy(xpath = "//a[text()='List Activations']")
	public WebElement reportCoreListActivations;
	
	@FindBy(xpath = "//a[text()='List Suspension']")
	public WebElement reportCoreListSuspension;
	
	@FindBy(xpath = "//a[text()='Product Assignments']")
	public WebElement reportCoreProductAssignments;
	
	@FindBy(xpath = "//a[text()='Job Report']")
	public WebElement reportCoreJobReport;
	//------------------------------------------------------
	
	@FindBy(xpath = "//a[text()='Core']/../..//a[text()='Finance']")
	public WebElement reportFinance;
	
	@FindBy(xpath = "//a[text()='List Payments']")
	public WebElement reportFinanceListPayments;
	
	@FindBy(xpath = "//a[text()='Pay For Box']")
	public WebElement reportFinancePayForBox;

	@FindBy(xpath = "//a[text()='GST Report ']")
	public WebElement reportFinanceGSTReport;
	
	@FindBy(xpath = "//a[text()='Pay Bills ']")
	public WebElement reportFinancePayBills;
	
	@FindBy(xpath = "//a[text()='Refund Report']")
	public WebElement reportFinanceRefundReport;
	//---------------------------------------------------------
	
	//----------------This is for Messages---------------------
	@FindBy(xpath = "//a[text()='List Message']")
	public WebElement messageListMessage;
	
	@FindBy(xpath = "//a[text()='Add Scroll']")
	public WebElement messageAddScroll;
	//---------------------------------------------------------
	
	//-----------------This is for Due Date--------------------
	@FindBy(xpath = "//a[text()='Set DueDate']")
	public WebElement dueDateSubDueDate;
	//---------------------------------------------------------
	
	//----------------This is for Subuser----------------------
	@FindBy(xpath = "//a[text()='Add Subuser']")
	public WebElement subuserAddSubuser;
	
	@FindBy(xpath = "//a[text()='Modify Subuser']")
	public WebElement subuserModifySubuser;
	//--------------------------------------------------------
	
	//--------------This is for Banks-------------------------
	@FindBy(xpath = "//a[text()='List Banks']")
	public WebElement bnksListBanks;
	//--------------------------------------------------------
	
}
