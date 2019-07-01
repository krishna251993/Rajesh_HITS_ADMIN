package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;
import com.mobiotics.HITSAdmin.maintenance.MaintenancePage;

public class TC_Maintenance extends BaseTest{
	
	@Test
	public void maintenanceTestMethod() throws InterruptedException
	{
		HomePage hp = new HomePage();
		MaintenancePage mp1 = hp.navigateToMaintenancePage();
		mp1.createSlateMsg();
		Thread.sleep(10000);
		MaintenancePage mp2 = hp.navigateToMaintenancePage();
		mp2.disableSlateMsg();
		
	}

}
