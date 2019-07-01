package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkProductAssign.BulkProductAssignPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Product_Assign_12 extends BaseTest{
	
	@Test
	public void testBulkProductAssignMethod() throws InterruptedException
	{
		BulkProductAssignPage bpa = new HomePage().navigateToBulkProductAssignPage();
		bpa.testBulkProductAssign();
	}

}
