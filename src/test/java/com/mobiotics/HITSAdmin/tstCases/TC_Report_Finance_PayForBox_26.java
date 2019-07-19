package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportFinancePayForBox.ReportFinancePayForBoxPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Finance_PayForBox_26 extends BaseTest{
	
	@Test
	public void reportFinancePayForBoxTestMethod() throws InterruptedException
	{
		ReportFinancePayForBoxPage rfp = new HomePage().navigateToFinancePayForBoxPage();
		rfp.testReportFinanceListPayments();
		Thread.sleep(4000);
	}

}
