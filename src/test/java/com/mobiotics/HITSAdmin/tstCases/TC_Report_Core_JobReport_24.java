package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreJobReport.ReportCoreJobReportPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_JobReport_24 extends BaseTest{
	
	@Test
	public void reportCoreJobReportTestMethod() throws InterruptedException
	{
		ReportCoreJobReportPage rcp = new HomePage().navigateToCoreJobReportPage();
		rcp.testReportCoreJobReport();
	}

}
