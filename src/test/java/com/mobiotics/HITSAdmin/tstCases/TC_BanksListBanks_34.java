package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.BanksListBanks.BanksListBanksPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_BanksListBanks_34 extends BaseTest{
	
	@Test
	public void testListBanksMethod() throws InterruptedException
	{
		BanksListBanksPage bl = new HomePage().navigateToListBanksPage();
		bl.testListBanks();
	}

}
