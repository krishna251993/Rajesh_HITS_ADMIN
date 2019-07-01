package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkAdjustmentCredit.BulkAdjustmentCreditPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Adjustment_Credit_17 extends BaseTest{
	
	@Test
	public void bulkAdjustmentCreditMethod() throws InterruptedException
	{
		BulkAdjustmentCreditPage bcp = new HomePage().navigateToBulkAdjustmentCreditPage();
		bcp.testBulkAdjustmentCredit();
	}

}
