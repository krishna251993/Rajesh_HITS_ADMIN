package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportFinanceGSTReport.ReportFinanceGSTReportPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Finance_GSTReport_27 extends BaseTest{
	
	@Test
	public void reportFinanceGSTReportTestMethod() throws InterruptedException
	{
		ReportFinanceGSTReportPage rgp = new HomePage().navigateToFinanceGSTReportPage();
		rgp.testReportFinanceListPayments();
	}

}
