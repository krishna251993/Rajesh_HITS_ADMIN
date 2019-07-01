package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.ReportCoreListDevice.ReportCoreListDevicesPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Report_Core_ListDevices_20 extends BaseTest{
	
	@Test
	public void reportCoreListDevicesTestMethod() throws InterruptedException
	{
		ReportCoreListDevicesPage rdp = new HomePage().navigateToCoreListDEvicesPage();
		rdp.testReportCoreListDevice();
	}

}
