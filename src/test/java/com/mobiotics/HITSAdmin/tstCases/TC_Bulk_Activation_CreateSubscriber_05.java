package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BulkActivationCreateSubscriber.BulkActivationCreateSubscriber;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_Bulk_Activation_CreateSubscriber_05 extends BaseTest{
	
	@Test
	public void testBulkActivationCreateSubscriber() throws InterruptedException
	{
		BulkActivationCreateSubscriber bs = new HomePage().navigateToBulkActivationCreateSubscriber();
		bs.testBulkCreateSubscriber();
	}

}
