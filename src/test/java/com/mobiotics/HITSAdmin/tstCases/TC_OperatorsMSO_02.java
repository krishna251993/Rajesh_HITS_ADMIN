package com.mobiotics.HITSAdmin.tstCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;
import com.mobiotics.HITSAdmin.operators_MSO.OperatorsMSOPage;

public class TC_OperatorsMSO_02 extends BaseTest{
	
	@Test
	public void operatorsTestMethod() throws InterruptedException, IOException
	{
		OperatorsMSOPage omp = new HomePage().navigateToOperatorsMSOPage();
		omp.testOperators_MSO();
	}

}
