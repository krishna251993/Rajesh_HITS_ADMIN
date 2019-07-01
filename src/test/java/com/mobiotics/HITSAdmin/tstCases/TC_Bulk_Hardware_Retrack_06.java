package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkHardwareRetrack.BulkHardwareRetrackPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Hardware_Retrack_06 extends BaseTest{
	
	@Test
	public void testBulkHardwareRetrackMethod() throws InterruptedException
	{
		BulkHardwareRetrackPage bh = new HomePage().navigateToBulkHardwareRetrackPage();
		bh.testBulkHardwareRetrack();
	}

}
