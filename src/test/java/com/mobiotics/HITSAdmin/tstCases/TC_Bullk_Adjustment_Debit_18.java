package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkAdjustmentDebit.BulkAdjustmentDebitPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bullk_Adjustment_Debit_18 extends BaseTest{
	
	@Test
	public void bulkAdjustmentDebitMethod() throws InterruptedException
	{
		BulkAdjustmentDebitPage bdp = new HomePage().navigateToBulkAdjustmentDebitPage();
		bdp.testBulkAdjustmentDebit();
	}

}
