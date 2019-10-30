//****************************************************************

//* Copyright (c) 2016 Ford Motor Company. All Rights Reserved.

//****************************************************************
package com.ford.auto.maindriver;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

import com.ford.auto.reusablecomponents.GlobalVariables;
import com.ford.auto.utilities.XmlTestSuiteGenerator;

public class MainDriverScript extends GlobalVariables {
	public static boolean bLoginStatus = false;
	public static String strCDSID = System.getProperty("user.name");
	public static String rootFolderPath = System.getProperty("user.dir");
	public static String downloadPath = "c:/users/"+strCDSID+"/Downloads/";	

	public static void main(String args[]) throws Exception {

		XmlTestSuiteGenerator xmlTestSuiteGenerator = new XmlTestSuiteGenerator();
		xmlTestSuiteGenerator.generateTestNgXmlSuite();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(workingDir + "\\testng.xml");
		testng.setTestSuites(suites);
		testng.run();

	}
}