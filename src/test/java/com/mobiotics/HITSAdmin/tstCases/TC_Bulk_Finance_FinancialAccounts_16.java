package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkFinanceFinancialAccount.BulkFinanceFinancialAccountPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Finance_FinancialAccounts_16 extends BaseTest{
	
	@Test
	public void bulkFinanceFinancialAccountsTestMethod() throws InterruptedException
	{
		BulkFinanceFinancialAccountPage bfp = new HomePage().navigateToBulkFinancialAccountPage();
		bfp.testBulkFinanceFinancialAccounts();
	}

}
