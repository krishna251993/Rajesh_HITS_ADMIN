package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreListConnections.ReportCoreListConnectionsPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_ListConnections_21 extends BaseTest{
	
	@Test
	public void reportCoreListConnectionsTestMethod() throws InterruptedException
	{
		ReportCoreListConnectionsPage rcp = new HomePage().navigateToCoreListConnectionsPage();
		rcp.testReportCoreListConnections();
	}

}
