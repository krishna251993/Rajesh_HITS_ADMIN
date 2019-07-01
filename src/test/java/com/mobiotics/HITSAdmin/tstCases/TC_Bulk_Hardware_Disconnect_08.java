package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkHardwareDisconnect.BulkHardwareDisconnectPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Hardware_Disconnect_08 extends BaseTest{
	
	@Test
	public void testBulkHardwareDisconnectMethod() throws InterruptedException
	{
		BulkHardwareDisconnectPage bd = new HomePage().navigateToBulkHardwareDisconnectPage();
		bd.testBulkHardwareDisconnect();
	}

}
