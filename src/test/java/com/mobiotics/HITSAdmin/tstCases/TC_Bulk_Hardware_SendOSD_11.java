package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkHardwareSendOSD.BulkHardwareSendOSDPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Hardware_SendOSD_11 extends BaseTest{
	
	@Test
	public void testBulkHardwareSendOSDMethod() throws InterruptedException
	{
		BulkHardwareSendOSDPage bso = new HomePage().navigateToBulkHardwareSendOSDPage();
		bso.testBulkHardwareReplacement();
	}

}
