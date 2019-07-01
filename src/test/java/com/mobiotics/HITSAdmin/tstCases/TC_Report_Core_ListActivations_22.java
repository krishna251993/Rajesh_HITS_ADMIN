package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreListActivations.ReportCoreListActivationsPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_ListActivations_22 extends BaseTest{
	
	@Test
	public void reportCoreActivationsTestMethod() throws InterruptedException
	{
		ReportCoreListActivationsPage rcp = new HomePage().navigateToCoreListActivationsPage();
		rcp.testReportCoreListActivations();
	}

}
