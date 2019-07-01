package com.mobiotics.HITSAdmin.tstCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.DPO.OperatorsDPOPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_OperatorsDPO_03 extends BaseTest{
	
	
	@Test
	public void testOperatorsDPOMethod() throws InterruptedException, IOException
	{
		OperatorsDPOPage odp = new HomePage().navigateToOperatorsDPOPage();
		odp.testOperators_DPO();
	}
	

}
