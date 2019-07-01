package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportFinanceListPayments.ReportFinanceListPaymentsPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Finance_ListPayments_25 extends BaseTest{
	
	@Test
	public void reportFinanceListPaymentsTestMethod() throws InterruptedException
	{
		ReportFinanceListPaymentsPage rfp = new HomePage().navigateToFinanceListPaymentsPage();
		rfp.testReportFinanceListPayments();
	}

}
