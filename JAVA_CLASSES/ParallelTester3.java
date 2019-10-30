//****************************************************************

//* Copyright (c) 2016 Ford Motor Company. All Rights Reserved.

//****************************************************************
package com.ford.auto.paralleltester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ford.auto.reusablecomponents.Browser;
import com.ford.auto.reusablecomponents.Common;
import com.ford.auto.utilities.BaseTest;

public class ParallelTester3 extends BaseTest {
	Common c = new Common();
	
	@BeforeClass 
	public void setUpClass() throws Exception {
		System.out.println("parallelTester Before class");
		setupClass(this.getClass().getPackage(), this.getClass().toString());
	}	

	@Test
	public void parallelTesterPageIsDisplayed() throws Exception {
		String methodName = "parallelTesterPageIsDisplayed";
		try{
			System.out.println("I am inside test : "+methodName+"");
			WebDriver driver = Browser.getInstance().getDriver();
			System.out.println(methodName + " - driver instance => "+driver+"");
			
			if(isGridMode){
				methodLevelChildTest = gridParentTest.get().createNode(methodName);
				System.out.println("*****!!!!!****** " + methodName);			
				gridChildTest.set(methodLevelChildTest);
			}			
			
			setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);

			reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
			reportUtils.addInfo("Executing Started Step 1: " , methodName );		

			String actualTest = textBox.getText("insideford.insidefordtitle_xpath");
			boolean result = textBox.verrifyText("insideford.insidefordtitle_xpath", "INSIDE FORD");

			testVerificationObj.verifyEquals("INSIDE FORD", actualTest);		
			testVerificationObj.verifyTrue("VerifyTrue", actualTest.equalsIgnoreCase("INSIDE FORD"));
			testVerificationObj.verifyFalse("VerifyFalse", actualTest.equalsIgnoreCase("FALSE EXPECTED INSIDE FORD"));
			testVerificationObj.clearVerificationErrors();

			Assert.assertEquals(driver.getTitle(), "parallelTesterPageIsDisplayed", "@FordOnline");			
//			Assert.assertTrue(true, "parallelTesterPageIsDisplayed");
			Assert.assertTrue(false, "Success - parallelTesterPageIsDisplayed");
			
			reportUtils.addInfoOnValidations(methodName, result, "Success", "Invalid value");
			reportUtils.addStepDetails("Page title Validated");		
		}
		catch(NullPointerException npException){
			npException.printStackTrace();
		}
	}
	
	@Test
	public void ClickSearchLink10() throws Exception
	{
		String methodName = "ClickSearchLink10";		
		WebDriver driver = Browser.getInstance().getDriver();
		System.out.println("I am inside test : "+methodName+"");
		System.out.println(methodName + " - driver instance => "+driver+"");

		if(isGridMode){
			methodLevelChildTest = gridParentTest.get().createNode(methodName);
			System.out.println("*****!!!!!****** " + methodName);			
			gridChildTest.set(methodLevelChildTest);
		}
		
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);
		reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
		try
		{//			driver.findElement(By.id("desktop-search")).click();			
			waitObj.waitUntilElementIsVisible("searchButton_id");
			waitObj.waitUntilElementIsClickable("searchButton_id");
			common.click("searchButton_id");
			Assert.assertEquals(driver.getTitle(), methodName, "@FordOnline");
//			Assert.assertTrue(true, "ClickSearchLink");
			Assert.assertTrue(false, "Success - ClickSearchLink");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test
	public void ClickSearchLink11() throws Exception
	{
		String methodName = "ClickSearchLink11";		
		WebDriver driver = Browser.getInstance().getDriver();
		System.out.println("I am inside test : "+methodName+"");
		System.out.println(methodName + " - driver instance => "+driver+"");

		if(isGridMode){
			methodLevelChildTest = gridParentTest.get().createNode(methodName);
			System.out.println("*****!!!!!****** " + methodName);			
			gridChildTest.set(methodLevelChildTest);
		}		
		
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);
		reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
		try
		{//			driver.findElement(By.id("desktop-search")).click();
			
			waitObj.waitUntilElementIsVisible("searchButton_id");
			waitObj.waitUntilElementIsClickable("searchButton_id");
			common.click("searchButton_id");
			Assert.assertEquals(driver.getTitle(), methodName, "@FordOnline");
			Assert.assertTrue(true, "ClickSearchLink");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test
	public void ClickSearchLink12() throws Exception
	{
		String methodName = "ClickSearchLink12";		
		WebDriver driver = Browser.getInstance().getDriver();
		
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Google", "Google");
		System.out.println("I am inside test : "+methodName+"");
		System.out.println(methodName + " - driver instance => "+driver+"");
		
		if(isGridMode){
			methodLevelChildTest = gridParentTest.get().createNode(methodName);
			System.out.println("*****!!!!!****** " + methodName);			
			gridChildTest.set(methodLevelChildTest);
		}		
		
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);
		reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
		try
		{//			driver.findElement(By.id("desktop-search")).click();
			
			waitObj.waitUntilElementIsVisible("searchButton_id");
			waitObj.waitUntilElementIsClickable("searchButton_id");
			common.click("searchButton_id");
//			Assert.assertEquals(driver.getTitle(), "FordOnline", "@FordOnline");
//			Assert.assertTrue(true, "ClickSearchLink");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test
	public void ClickSearchLink13() throws Exception
	{
		String methodName = "ClickSearchLink13";		
		WebDriver driver = Browser.getInstance().getDriver();
		System.out.println("I am inside test : "+methodName+"");
		System.out.println(methodName + " - driver instance => "+driver+"");
		
		if(isGridMode){
			methodLevelChildTest = gridParentTest.get().createNode(methodName);
			System.out.println("*****!!!!!****** " + methodName);			
			gridChildTest.set(methodLevelChildTest);
		}		
		
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);
		reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
		try
		{//			driver.findElement(By.id("desktop-search")).click();
			
			waitObj.waitUntilElementIsVisible("searchButton_id");
			waitObj.waitUntilElementIsClickable("searchButton_id");
			common.click("searchButton_id");
			Assert.assertEquals(driver.getTitle(), methodName, "@FordOnline");
			Assert.assertTrue(true, "ClickSearchLink");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test
	public void ClickSearchLink14() throws Exception
	{
		String methodName = "ClickSearchLink14";		
		WebDriver driver = Browser.getInstance().getDriver();
		System.out.println("I am inside test : "+methodName+"");
		System.out.println(methodName + " - driver instance => "+driver+"");

		if(isGridMode){
			methodLevelChildTest = gridParentTest.get().createNode(methodName);
			System.out.println("*****!!!!!****** " + methodName);			
			gridChildTest.set(methodLevelChildTest);
		}		
		
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);
		reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
		try
		{//			driver.findElement(By.id("desktop-search")).click();
			
			waitObj.waitUntilElementIsVisible("searchButton_id");
			waitObj.waitUntilElementIsClickable("searchButton_id");
			common.click("searchButton_id");
			Assert.assertEquals(driver.getTitle(), methodName, "@FordOnline");
			Assert.assertTrue(true, "ClickSearchLink");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test
	public void VerifyMouseHandlers3() throws Exception
	{
		String methodName = "VerifyMouseHandlers3";

		System.out.println("I am inside test : "+methodName+"");
		WebDriver driver = Browser.getInstance().getDriver();
		System.out.println("driver instance for test "+methodName+" is :"+driver+"");
		
		if(isGridMode){
			methodLevelChildTest = gridParentTest.get().createNode(methodName);
			System.out.println("*****!!!!!****** " + methodName);			
			gridChildTest.set(methodLevelChildTest);
		}
		
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);	

		reportUtils.addInfo("Executing Started for Test: " + methodName, methodName);
		reportUtils.addInfo("Executing Started Step 1: " , methodName );

		try
		{
			driver.navigate().to("https://letskodeit.teachable.com/p/practice");
			Thread.sleep(10000);
			mouseHandler.click("insideford.BMW_xpath", "insideford.BMWRadio_xpath");
			mouseHandler.click("insideford.BMWSCheck_xpath", "isnideford.BMWCheckBox_xpath");
			mouseHandler.doubleClick("insideford.BMWSCheck_xpath", "isnideford.BMWCheckBox_xpath");
			driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

			System.out.println("*** OurCompany - SwitchToFrame - Driver Instance: " + driver);
			common.SwtichToFrame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(2000);
			popupHandler.alertAccept();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			common.SwtichToFrame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(2000);
			popupHandler.alertDismiss();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
			common.SwtichToFrame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(3000);
			popupHandler.SetPopoupText("Hello");
			Thread.sleep(2000);
			popupHandler.alertDismiss();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert2");
			common.SwtichToFrame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(3000);
			String  text =  popupHandler.alertGettext();
			System.out.println(text);
			Thread.sleep(2000);
			popupHandler.alertAccept();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(1000);	

			Assert.assertEquals(driver.getTitle(), methodName, "@FordOnline");
			Assert.assertTrue(true, methodName);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}	
}