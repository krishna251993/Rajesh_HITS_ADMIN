package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.MessageAddScroll.MessageAddScrollPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_MessageAddScroll_31 extends BaseTest{
	
	@Test
	public void testAddScrollMethod() throws InterruptedException
	{
		MessageAddScrollPage msap =  new HomePage().navigateToAddScroll();
		msap.testAddScrollMsg();
	}

}
