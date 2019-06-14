package com.mobiotics.HITSAdmin.listenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenerClass implements ITestListener{

	public void onTestStart(ITestResult result) {

		System.out.println("Test case starts: "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed successfully: "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test cases failed but within the success percentage are: "+result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("Test case on start: "+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test cas on finish: "+context.getName());
		
	}
	
	
	
	

}
