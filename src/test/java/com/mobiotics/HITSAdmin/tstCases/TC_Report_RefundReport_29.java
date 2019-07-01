package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportRefundReport.ReportFinanceRefundReportPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_RefundReport_29 extends BaseTest{
	
	@Test
	public void reportRefundReportTestMethod() throws InterruptedException
	{
		ReportFinanceRefundReportPage rrp = new HomePage().navigateToFinanceRefundReportPage();
		rrp.testReportRefundReport();
	}

}
