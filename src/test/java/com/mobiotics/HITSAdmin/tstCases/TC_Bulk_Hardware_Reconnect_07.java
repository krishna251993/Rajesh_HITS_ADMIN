package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkHardwareReconnect.BulkHardwareReconnect;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Hardware_Reconnect_07 extends BaseTest{
	
	@Test
	public void testBulkHardwareRconnectMethod() throws InterruptedException
	{
		BulkHardwareReconnect br = new HomePage().navigateToBulkHardwareReconnectPage();
		br.testBulkHardwareReconnect();
	}

}
