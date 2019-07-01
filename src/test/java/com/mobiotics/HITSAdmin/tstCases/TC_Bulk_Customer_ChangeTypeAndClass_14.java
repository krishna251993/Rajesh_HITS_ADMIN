package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkCustomerChangeTypeClass.BulkCustomerChangeTypeClassPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Customer_ChangeTypeAndClass_14 extends BaseTest{
	
	@Test
	public void bulkCustomerChangeTypeAndClassMethod() throws InterruptedException
	{
		BulkCustomerChangeTypeClassPage bcc = new HomePage().navigateToBulkCustomerChangeTypeClassPage();
		bcc.testBulkCustomerChangeTypeClass();
	}

}
