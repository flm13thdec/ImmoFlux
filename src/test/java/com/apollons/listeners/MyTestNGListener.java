package com.apollons.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import com.apollons.base.BaseTest;


public class MyTestNGListener extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testCaseName=result.getMethod().getMethodName();
		
		test.log(Status.PASS, testCaseName+" is passed");
		
		String filePath=BaseTest.screenshot();
		
		test.addScreenCaptureFromPath(filePath);
		
	}

	public void onTestFailure(ITestResult result) {
		
		String testCaseName=result.getMethod().getMethodName();
		
		test.log(Status.FAIL, testCaseName+" is failed");
		
		String filePath=BaseTest.screenshot();
		
		test.addScreenCaptureFromPath(filePath);
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}
