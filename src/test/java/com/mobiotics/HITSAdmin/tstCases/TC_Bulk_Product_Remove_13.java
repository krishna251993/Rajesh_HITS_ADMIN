package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkProductRemoval.BulkProductRemovalPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Product_Remove_13 extends BaseTest{
	
	@Test
	public void bulkProductRemovetestMethod() throws InterruptedException
	{
		BulkProductRemovalPage bpr = new HomePage().navigateToBulkProductRemovalPage();
		bpr.testBulkProductRemoval();
	}

}
