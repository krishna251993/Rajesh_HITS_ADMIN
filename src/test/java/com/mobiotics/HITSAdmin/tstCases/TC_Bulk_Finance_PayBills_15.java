package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkFinancePayBills.BulkFinancePayBillsPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Finance_PayBills_15 extends BaseTest{
	
	@Test
	public void bulkFinancePayBillsTestMethod() throws InterruptedException
	{
		BulkFinancePayBillsPage bpb = new HomePage().navigateToBulkFinancePayBillsPage();
		bpb.testBulkFinancePayBills();
	}

}
