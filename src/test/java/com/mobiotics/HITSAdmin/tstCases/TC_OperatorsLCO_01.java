package com.mobiotics.HITSAdmin.tstCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;
import com.mobiotics.HITSAdmin.operatore_LCO.OperatorsLCOPage;

public class TC_OperatorsLCO_01 extends BaseTest{
	
	
	@Test
	public void testOperatorsLCOMethod() throws InterruptedException, IOException
	{
		OperatorsLCOPage olp = new HomePage().navigateToOperatorsLCO();
		olp.testOperators_LCO();
	}

}
