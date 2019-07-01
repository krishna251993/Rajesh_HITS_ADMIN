package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportPayBills.ReportFinancePayBillsPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Finance_PayBills_28 extends BaseTest{
	
	@Test
	public void reportFinancePayBillsTestMethod() throws InterruptedException
	{
		ReportFinancePayBillsPage rpb = new HomePage().navigateToFinancePayBillsPage();
		rpb.testReportFinancePayBills();
	}

}
