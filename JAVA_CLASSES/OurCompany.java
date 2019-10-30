//****************************************************************

//* Copyright (c) 2016 Ford Motor Company. All Rights Reserved.

//****************************************************************
package com.ford.auto.insideford;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ford.auto.business_reusablecomponents.ReusableComponents;
import com.ford.auto.reusablecomponents.MouseHandler;
import com.ford.auto.utilities.BaseTest;

public class OurCompany extends BaseTest {
	String methodName;

	@BeforeClass 
	public void setUpClass() throws Exception {
		System.out.println("Before class");
		mouseHandler = new MouseHandler();
		setupClass(this.getClass().getPackage(), this.getClass().toString());
	}

	@BeforeMethod
	public void setUpTest(Method method) throws Exception {
		System.out.println("Before Methods"+ method.getName());
		setupTest(this.getClass().getPackage(), this.getClass().toString(), method.getName());
		methodName = method.getName();
	}

	@Test
	public void validateOurCompanyPageIsDisplayed() throws Exception {
		reportUtils.addInfo("Executing Started for Test" + methodName, methodName);
		reportUtils.addInfo("Executing Started Step 1" , methodName );
		
		ReusableComponents.getMachineDetails();
		String actualTest = textBox.getText("insideford.insidefordtitle_xpath");
		boolean result = textBox.verrifyText("insideford.insidefordtitle_xpath", "INSIDE FORD");

		testVerificationObj.verifyEquals("INSIDE FORD", actualTest);		
		testVerificationObj.verifyTrue("VerifyTrue", actualTest.equalsIgnoreCase("INSIDE FORD"));
		testVerificationObj.verifyFalse("VerifyFalse", actualTest.equalsIgnoreCase("FALSE EXPECTED INSIDE FORD"));
		testVerificationObj.clearVerificationErrors();

		reportUtils.addInfoOnValidations(methodName, result, "Success", "Invalid value");
		reportUtils.addStepDetails("Page title Validated");
	}
	
	@AfterMethod(alwaysRun= true)
	public void afterTestSetup(ITestResult itestResult) throws InterruptedException {
		System.out.println(" After Methods"+ itestResult.getMethod().getMethodName());

		if (itestResult.getStatus() == ITestResult.FAILURE) {
			reportUtils.takeScreenShotOnFailure(methodName, itestResult.getThrowable().toString());
		}
		methodName = null;
	}

	@AfterSuite(alwaysRun= true)
	public void tearDownTest() throws InterruptedException {
		System.out.println(" After class");
		reportUtils.endReport();
	}
}