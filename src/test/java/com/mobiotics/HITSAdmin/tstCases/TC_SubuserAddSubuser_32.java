package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.SubuserAddSubuserPage.SubuserAddSubuserPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_SubuserAddSubuser_32 extends BaseTest{
	
	@Test
	public void testAddSubuserMethod() throws InterruptedException
	{
		SubuserAddSubuserPage sp = new HomePage().navigateToAddSubuserPage();
		sp.testAddSubuser();
	}

}
