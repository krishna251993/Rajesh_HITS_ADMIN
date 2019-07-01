package com.mobiotics.HITSAdmin.tstCases;


import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkHardwareCancelProduct.BulkHardwareCancelProductPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Hardware_CancelProduct_09 extends BaseTest{
	
	@Test
	public void testBulkHardwareCancelProductMethod() throws InterruptedException
	{
		BulkHardwareCancelProductPage bcp = new HomePage().navigateToBulkHardwareCancelProductPage();
		bcp.testBulkHardwareCancelProduct();
	}

}
