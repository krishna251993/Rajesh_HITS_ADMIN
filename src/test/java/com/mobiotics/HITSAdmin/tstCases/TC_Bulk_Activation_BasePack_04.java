package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkActivationsBasePack.BulkActivationBasePackPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Activation_BasePack_04 extends BaseTest{
	
	@Test
	public void testBulkAddBasePack() throws InterruptedException
	{
		BulkActivationBasePackPage bp = new HomePage().navigateToBulkAddBasePackPage();
		bp.testBulkActivationBasePack();
	}

}
