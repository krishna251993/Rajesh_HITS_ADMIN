package com.mobiotics.HITSAdmin.tstCases;

import org.testng.annotations.Test;

import com.mobiotics.HITSAdmin.MessageListMessage.MessageListMessagesPage;
import com.mobiotics.HITSAdmin.commonpages.HomePage;
import com.mobiotics.HITSAdmin.constants.BaseTest;

public class TC_MessageListMessage_30 extends BaseTest{
	
	
		@Test
		public void testListMessageMethod() throws InterruptedException
		{
			MessageListMessagesPage mlp = new HomePage().navigateToListMessagePage();
			mlp.testListMessage();
		}
	
	

}
