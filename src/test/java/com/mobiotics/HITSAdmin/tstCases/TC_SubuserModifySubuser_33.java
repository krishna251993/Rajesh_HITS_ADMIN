package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;
import com.mobiotics.SubuserModifySubuser.SubuserModifySubuser;

public class TC_SubuserModifySubuser_33 extends BaseTest{
	
	@Test
	public void testModifySubuserTest() throws InterruptedException
	{
		SubuserModifySubuser sm = new HomePage().navigateToModifySubuserPage();
		sm.testModifySubUser();
	}

}
