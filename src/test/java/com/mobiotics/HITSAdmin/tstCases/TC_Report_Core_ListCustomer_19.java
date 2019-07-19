package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreListCustomer.ReportCoreListCustomerPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_ListCustomer_19 extends BaseTest{
	
	@Test
	public void reportCoreListCustomerTestMethod() throws InterruptedException
	{
		ReportCoreListCustomerPage rp = new HomePage().navigateToCoreListCustomerPage();
		rp.testReportCoreListCustomer();
	}

}

