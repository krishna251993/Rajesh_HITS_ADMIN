package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreProductAssignments.ReportCoreProductAssignmentsPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_Product_Assignment_24 extends BaseTest{
	
	@Test
	public void reportCoreProductAssignmentTestMethod() throws InterruptedException
	{
		ReportCoreProductAssignmentsPage rpa = new HomePage().navigateToCoreProductAssignmentsPage();
		rpa.testReportCoreListSuspensions();
	}

}
