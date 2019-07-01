package com.mobiotics.HITSAdmin.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.HITSAdmin.BanksListBanks.BanksListBanksPage;
import com.mobiotics.HITSAdmin.BulkActivationCreateSubscriber.BulkActivationCreateSubscriber;
import com.mobiotics.HITSAdmin.BulkActivationsBasePack.BulkActivationBasePackPage;
import com.mobiotics.HITSAdmin.BulkAdjustmentCredit.BulkAdjustmentCreditPage;
import com.mobiotics.HITSAdmin.BulkAdjustmentDebit.BulkAdjustmentDebitPage;
import com.mobiotics.HITSAdmin.BulkCustomerChangeTypeClass.BulkCustomerChangeTypeClassPage;
import com.mobiotics.HITSAdmin.BulkFinanceFinancialAccount.BulkFinanceFinancialAccountPage;
import com.mobiotics.HITSAdmin.BulkFinancePayBills.BulkFinancePayBillsPage;
import com.mobiotics.HITSAdmin.BulkHardwareCancelProduct.BulkHardwareCancelProductPage;
import com.mobiotics.HITSAdmin.BulkHardwareDisconnect.BulkHardwareDisconnectPage;
import com.mobiotics.HITSAdmin.BulkHardwareHardwareReplacement.BulkHardwareHardwareReplacementPage;
import com.mobiotics.HITSAdmin.BulkHardwareReconnect.BulkHardwareReconnect;
import com.mobiotics.HITSAdmin.BulkHardwareRetrack.BulkHardwareRetrackPage;
import com.mobiotics.HITSAdmin.BulkHardwareSendOSD.BulkHardwareSendOSDPage;
import com.mobiotics.HITSAdmin.BulkProductAssign.BulkProductAssignPage;
import com.mobiotics.HITSAdmin.BulkProductRemoval.BulkProductRemovalPage;
import com.mobiotics.HITSAdmin.DPO.OperatorsDPOPage;
import com.mobiotics.HITSAdmin.MessageAddScroll.MessageAddScrollPage;
import com.mobiotics.HITSAdmin.MessageListMessage.MessageListMessagesPage;
import com.mobiotics.HITSAdmin.ReportCoreJobReport.ReportCoreJobReportPage;
import com.mobiotics.HITSAdmin.ReportCoreListActivations.ReportCoreListActivationsPage;
import com.mobiotics.HITSAdmin.ReportCoreListConnections.ReportCoreListConnectionsPage;
import com.mobiotics.HITSAdmin.ReportCoreListCustomer.ReportCoreListCustomerPage;
import com.mobiotics.HITSAdmin.ReportCoreListDevice.ReportCoreListDevicesPage;
import com.mobiotics.HITSAdmin.ReportCoreListSuspension.ReportCoreListSuspensionPage;
import com.mobiotics.HITSAdmin.ReportCoreProductAssignments.ReportCoreProductAssignmentsPage;
import com.mobiotics.HITSAdmin.ReportFinanceGSTReport.ReportFinanceGSTReportPage;
import com.mobiotics.HITSAdmin.ReportFinanceListPayments.ReportFinanceListPaymentsPage;
import com.mobiotics.HITSAdmin.ReportFinancePayForBox.ReportFinancePayForBoxPage;
import com.mobiotics.HITSAdmin.ReportPayBills.ReportFinancePayBillsPage;
import com.mobiotics.HITSAdmin.ReportRefundReport.ReportFinanceRefundReportPage;
import com.mobiotics.HITSAdmin.SetDueDate.DueDateSetDueDatePage;
import com.mobiotics.HITSAdmin.SubuserAddSubuserPage.SubuserAddSubuserPage;
import com.mobiotics.HITSAdmin.maintenance.MaintenancePage;
import com.mobiotics.HITSAdmin.operatore_LCO.OperatorsLCOPage;
import com.mobiotics.HITSAdmin.operators_MSO.OperatorsMSOPage;
import com.mobiotics.SubuserModifySubuser.SubuserModifySubuser;

public class HomePage extends NavigationMenu {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Operators ']")
	public WebElement operatorMenu;

	@FindBy(xpath = "//a[text()='Bulk ']")
	public WebElement bulkMenu;

	@FindBy(xpath = "//a[text()='Report ']")
	public WebElement reportMenu;

	@FindBy(xpath = "//a[text()='Message ']")
	public WebElement messageMenu;

	@FindBy(xpath = "//a[text()='DueDate']")
	public WebElement dueDateMenu;

	@FindBy(xpath = "//a[text()='Subuser ']")
	public WebElement subuserMenu;

	@FindBy(xpath = "//a[text()='Banks ']")
	public WebElement banksMenu;

	@FindBy(xpath = "//a[text()='Maintenance']")
	public WebElement maintenanceMenu;

	// ---------------Navigate to the Operators > LCO page--------
	public OperatorsLCOPage navigateToOperatorsLCO() {
		waitTillElementIsClickable(operatorMenu);
		operatorMenu.click();
		waitTillElementIsClickable(operatorsLCO);
		operatorsLCO.click();
		return new OperatorsLCOPage();
	}

//------------------Navigate to Operators > MSO page--------------	
	public OperatorsMSOPage navigateToOperatorsMSOPage() {
		waitTillElementIsClickable(operatorMenu);
		operatorMenu.click();
		waitTillElementIsClickable(operatorsMSO);
		operatorsMSO.click();
		return new OperatorsMSOPage();
	}

//-------------------Navigate to Operators > DPO Page------------	
	public OperatorsDPOPage navigateToOperatorsDPOPage() {
		waitTillElementIsClickable(operatorMenu);
		operatorMenu.click();
		waitTillElementIsClickable(operatorsDPO);
		operatorsDPO.click();
		return new OperatorsDPOPage();
	}

//--------------------Navigate to Message > List Message Page-----------
	public MessageListMessagesPage navigateToListMessagePage() {
		waitTillElementIsClickable(messageMenu);
		messageMenu.click();
		waitTillElementIsClickable(messageListMessage);
		messageListMessage.click();
		return new MessageListMessagesPage();
	}

//---------------------Navigate to the Message > Add Scroll Page---------
	public MessageAddScrollPage navigateToAddScroll() {
		waitTillElementIsClickable(messageMenu);
		messageMenu.click();
		waitTillElementIsVisible(messageAddScroll);
		messageAddScroll.click();
		return new MessageAddScrollPage();
	}

//---------------------Navigate to the Due Date > Set Due Date Page-----
	public DueDateSetDueDatePage navigateToSetDueDatePage() {
		waitTillElementIsClickable(dueDateMenu);
		dueDateMenu.click();
		waitTillElementIsVisible(dueDateSubDueDate);
		dueDateSubDueDate.click();
		return new DueDateSetDueDatePage();
	}

//--------------------Navigate to the Subuser > Add Subuser page------
	public SubuserAddSubuserPage navigateToAddSubuserPage() {
		waitTillElementIsClickable(subuserMenu);
		subuserMenu.click();
		waitTillElementIsVisible(subuserAddSubuser);
		subuserAddSubuser.click();
		return new SubuserAddSubuserPage();
	}

//--------------------Navigate to Subuser > Modify Subuser Page-------
	public SubuserModifySubuser navigateToModifySubuserPage() {
		waitTillElementIsClickable(subuserMenu);
		subuserMenu.click();
		waitTillElementIsVisible(subuserModifySubuser);
		subuserModifySubuser.click();
		return new SubuserModifySubuser();
	}

//---------------------Navigate to Banks > List Banks Page-------------
	public BanksListBanksPage navigateToListBanksPage() {
		waitTillElementIsClickable(banksMenu);
		banksMenu.click();
		waitTillElementIsVisible(bnksListBanks);
		bnksListBanks.click();
		return new BanksListBanksPage();
	}

//-----------------Navigate to Bulk > Activation > Base Pack-------------
	public BulkActivationBasePackPage navigateToBulkAddBasePackPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkActivation);
		moveToElement(bulkActivation);
		waitTillElementIsVisible(bulkActivationBasepack);
		bulkActivationBasepack.click();
		return new BulkActivationBasePackPage();
	}

//-----------------Navigate to Bulk > Activation > Create Subscriber-------------
	public BulkActivationCreateSubscriber navigateToBulkActivationCreateSubscriber() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkActivation);
		moveToElement(bulkActivation);
		waitTillElementIsVisible(bulkActivationCreateSubscriber);
		bulkActivationCreateSubscriber.click();
		return new BulkActivationCreateSubscriber();
	}

//-----------------Navigate to Bulk > Hardware > Retrack-------------
	public BulkHardwareRetrackPage navigateToBulkHardwareRetrackPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkHardware);
		moveToElement(bulkHardware);
		waitTillElementIsVisible(bulkHardwareRetrack);
		bulkHardwareRetrack.click();
		return new BulkHardwareRetrackPage();
	}

	// -----------------Navigate to Bulk > Hardware > Reconnect-------------
	public BulkHardwareReconnect navigateToBulkHardwareReconnectPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkHardware);
		moveToElement(bulkHardware);
		waitTillElementIsVisible(bulkHardwareReconnect);
		bulkHardwareReconnect.click();
		return new BulkHardwareReconnect();
	}

	// -----------------Navigate to Bulk > Hardware > Disconnect-------------
	public BulkHardwareDisconnectPage navigateToBulkHardwareDisconnectPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkHardware);
		moveToElement(bulkHardware);
		waitTillElementIsVisible(bulkHardwareDisconnect);
		bulkHardwareDisconnect.click();
		return new BulkHardwareDisconnectPage();
	}

	// -----------------Navigate to Bulk > Hardware > Disconnect-------------
	public BulkHardwareCancelProductPage navigateToBulkHardwareCancelProductPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkHardware);
		moveToElement(bulkHardware);
		waitTillElementIsVisible(bulkHardwareCancelProduct);
		bulkHardwareCancelProduct.click();
		return new BulkHardwareCancelProductPage();
	}

	// -----------------Navigate to Bulk > Hardware > Hardware
	// Replacement-------------
	public BulkHardwareHardwareReplacementPage navigateToBulkHardwareReplacementPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkHardware);
		moveToElement(bulkHardware);
		waitTillElementIsVisible(bulkHardwareReplacement);
		bulkHardwareReplacement.click();
		return new BulkHardwareHardwareReplacementPage();
	}

	// -----------------Navigate to Bulk > Hardware > Send OSD-------------
	public BulkHardwareSendOSDPage navigateToBulkHardwareSendOSDPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkHardware);
		moveToElement(bulkHardware);
		waitTillElementIsVisible(bulkHardwareSendOSD);
		bulkHardwareSendOSD.click();
		return new BulkHardwareSendOSDPage();
	}

	// -----------------Navigate to Bulk > Product > Assign-------------
	public BulkProductAssignPage navigateToBulkProductAssignPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkProduct);
		moveToElement(bulkProduct);
		waitTillElementIsVisible(bulkProductAssign);
		bulkProductAssign.click();
		return new BulkProductAssignPage();
	}

	// -----------------Navigate to Bulk > Product > Remove-------------
	public BulkProductRemovalPage navigateToBulkProductRemovalPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkProduct);
		moveToElement(bulkProduct);
		waitTillElementIsVisible(bulkProductRemove);
		bulkProductRemove.click();
		return new BulkProductRemovalPage();
	}

	// -----------------Navigate to Bulk > Product > Remove-------------
	public BulkCustomerChangeTypeClassPage navigateToBulkCustomerChangeTypeClassPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkCustomer);
		moveToElement(bulkCustomer);
		waitTillElementIsVisible(bulkCustomerChangeTypeAndClass);
		bulkCustomerChangeTypeAndClass.click();
		return new BulkCustomerChangeTypeClassPage();
	}

	// -----------------Navigate to Bulk > Finance > Pay Bills-------------
	public BulkFinancePayBillsPage navigateToBulkFinancePayBillsPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkFinance);
		moveToElement(bulkFinance);
		waitTillElementIsVisible(bulkFinancePayBills);
		bulkFinancePayBills.click();
		return new BulkFinancePayBillsPage();
	}

	// -----------------Navigate to Bulk > Finance > Financial Accounts-------------
	public BulkFinanceFinancialAccountPage navigateToBulkFinancialAccountPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkFinance);
		moveToElement(bulkFinance);
		waitTillElementIsVisible(bulkFinanceFinacialAccount);
		bulkFinanceFinacialAccount.click();
		return new BulkFinanceFinancialAccountPage();
	}

	// -----------------Navigate to Bulk > Adjustment > Credit-------------
	public BulkAdjustmentCreditPage navigateToBulkAdjustmentCreditPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkAdjustment);
		moveToElement(bulkAdjustment);
		waitTillElementIsVisible(bulkAdjustmentCredit);
		bulkAdjustmentCredit.click();
		return new BulkAdjustmentCreditPage();
	}

	// -----------------Navigate to Bulk > Adjustment > Debit-------------
	public BulkAdjustmentDebitPage navigateToBulkAdjustmentDebitPage() {
		waitTillElementIsClickable(bulkMenu);
		bulkMenu.click();
		waitTillElementIsVisible(bulkAdjustment);
		moveToElement(bulkAdjustment);
		waitTillElementIsVisible(bulkAdjustmentDebit);
		bulkAdjustmentDebit.click();
		return new BulkAdjustmentDebitPage();
	}

	// -----------------Navigate to Report > Core > List Customer-------------
	public ReportCoreListCustomerPage navigateToCoreListCustomerPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreListCustomer);
		reportCoreListCustomer.click();
		return new ReportCoreListCustomerPage();
	}

	// -----------------Navigate to Report > Core > List Devices-------------
	public ReportCoreListDevicesPage navigateToCoreListDEvicesPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreListDevices);
		reportCoreListDevices.click();
		return new ReportCoreListDevicesPage();
	}

	// -----------------Navigate to Report > Core > List Connections-------------
	public ReportCoreListConnectionsPage navigateToCoreListConnectionsPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreListConnections);
		reportCoreListConnections.click();
		return new ReportCoreListConnectionsPage();
	}

	// -----------------Navigate to Report > Core > List Activations-------------
	public ReportCoreListActivationsPage navigateToCoreListActivationsPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreListActivations);
		reportCoreListActivations.click();
		return new ReportCoreListActivationsPage();
	}

	// -----------------Navigate to Report > Core > List Suspension-------------
	public ReportCoreListSuspensionPage navigateToCoreListSuspensionPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreListSuspension);
		reportCoreListSuspension.click();
		return new ReportCoreListSuspensionPage();
	}

	// -----------------Navigate to Report > Core > Product Assignments-------------
	public ReportCoreProductAssignmentsPage navigateToCoreProductAssignmentsPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreProductAssignments);
		reportCoreProductAssignments.click();
		return new ReportCoreProductAssignmentsPage();
	}

	// -----------------Navigate to Report > Core > Job Report-------------
	public ReportCoreJobReportPage navigateToCoreJobReportPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportCore);
		moveToElement(reportCore);
		waitTillElementIsVisible(reportCoreJobReport);
		reportCoreJobReport.click();
		return new ReportCoreJobReportPage();
	}

	// -----------------Navigate to Report > Finance > List Payments-------------
	public ReportFinanceListPaymentsPage navigateToFinanceListPaymentsPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportFinance);
		moveToElement(reportFinance);
		waitTillElementIsVisible(reportFinanceListPayments);
		reportFinanceListPayments.click();
		return new ReportFinanceListPaymentsPage();
	}

	// -----------------Navigate to Report > Finance > Pay For Box-------------
	public ReportFinancePayForBoxPage navigateToFinancePayForBoxPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportFinance);
		moveToElement(reportFinance);
		waitTillElementIsVisible(reportFinancePayForBox);
		reportFinancePayForBox.click();
		return new ReportFinancePayForBoxPage();
	}

	// -----------------Navigate to Report > Finance > GST Report-------------
	public ReportFinanceGSTReportPage navigateToFinanceGSTReportPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportFinance);
		moveToElement(reportFinance);
		waitTillElementIsVisible(reportFinanceGSTReport);
		reportFinanceGSTReport.click();
		return new ReportFinanceGSTReportPage();
	}

	// -----------------Navigate to Report > Finance > Pay Bills-------------
	public ReportFinancePayBillsPage navigateToFinancePayBillsPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportFinance);
		moveToElement(reportFinance);
		waitTillElementIsVisible(reportFinancePayBills);
		reportFinancePayBills.click();
		return new ReportFinancePayBillsPage();
	}

	// -----------------Navigate to Report > Finance > Pay Bills-------------
	public ReportFinanceRefundReportPage navigateToFinanceRefundReportPage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(reportFinance);
		moveToElement(reportFinance);
		waitTillElementIsVisible(reportFinanceRefundReport);
		reportFinanceRefundReport.click();
		return new ReportFinanceRefundReportPage();
	}

	// -----------------Navigate to Maintenance-------------
	public MaintenancePage navigateToMaintenancePage() {
		waitTillElementIsClickable(reportMenu);
		reportMenu.click();
		waitTillElementIsVisible(maintenanceMenu);
		maintenanceMenu.click();
		return new MaintenancePage();
	}

}
