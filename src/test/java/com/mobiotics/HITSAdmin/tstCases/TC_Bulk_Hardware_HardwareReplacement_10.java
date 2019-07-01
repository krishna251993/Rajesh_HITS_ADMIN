package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkHardwareHardwareReplacement.BulkHardwareHardwareReplacementPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Hardware_HardwareReplacement_10 extends BaseTest{
	
	@Test
	public void testBulkHardwareRepacementMethod() throws InterruptedException
	{
		BulkHardwareHardwareReplacementPage bhp = new HomePage().navigateToBulkHardwareReplacementPage();
		bhp.testBulkHardwareReplacement();
	}
	

}
