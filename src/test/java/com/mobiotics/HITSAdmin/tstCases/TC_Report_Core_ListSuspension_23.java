package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreListSuspension.ReportCoreListSuspensionPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_ListSuspension_23 extends BaseTest{
	
	@Test
	public void reportCoreListSuspensionTestMethod() throws InterruptedException
	{
		ReportCoreListSuspensionPage rsp = new HomePage().navigateToCoreListSuspensionPage();
		rsp.testReportCoreListSuspensions();
		Thread.sleep(4000);
	}

}
