//****************************************************************

//* Copyright (c) 2016 Ford Motor Company. All Rights Reserved.

//****************************************************************
package com.ford.auto.headlessbrowser;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ford.auto.reusablecomponents.Browser;
import com.ford.auto.reusablecomponents.GlobalVariables;
import com.ford.auto.utilities.BaseTest; 

public class HeadlessBrowser extends BaseTest {
	static String strBrowserChoice;

	@BeforeClass 
	public void setUpClass() throws Exception {
		System.out.println("OurCompany Before class");
		setupClass(this.getClass().getPackage(), this.getClass().toString());
	}

	@Test //Headless
	public void WSLloginPage() throws Exception
	{
		String methodName = "WSLloginPage";

		WebDriver d = Browser.getInstance().getDriver();

		System.out.println("I am inside test : "+methodName+"");
		System.out.println("driver instance for test "+methodName+" is :"+d+"");
		setupTest(this.getClass().getPackage(), this.getClass().toString(), methodName);
		
		reportUtils.addInfo("Executing Started for headless browser: " + methodName, methodName);		
		try
		{
			d.findElement(By.xpath("//span[contains(text(),'CDS Lookup')]/parent::a")).click();
			Thread.sleep(5000);
			String CurrentwindowHandle = d.getWindowHandle();
			Set<String> allWindows = d.getWindowHandles();

			for(String CW : allWindows)
			{
				if(! (CW.equals(CurrentwindowHandle)))
				{
					d.switchTo().window(CW);
					d.findElement(By.id("ADloginUserIdInput")).sendKeys(GlobalVariables.configData.get("User"));					
					d.findElement(By.id("ADloginPasswordInput")).sendKeys(GlobalVariables.configData.get("Password"));
					
					TakesScreenshot ts = (TakesScreenshot) d;
					File source =  ts.getScreenshotAs(OutputType.FILE);
					File DestFile = new File(GlobalVariables.configData.get("ReportPath")+"\\HeadlessLoginPageScreenshot"+System.currentTimeMillis()+ ".png");					
					FileUtils.copyFile(source, DestFile);
					
					reportUtils.addResult("Headless browser_1", false, "Test automation enablement team");					
					
					d.findElement(By.id("ADloginWSLSubmitButton")).click();
					Thread.sleep(5000);
				}
			}			
			d.switchTo().window(CurrentwindowHandle);
			reportUtils.addResult("Headless browser_2", false, "Test automation enablement team");

			Thread.sleep(1000);	
			System.out.println("Completed");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void HtmlunitDriver() throws Exception
	{
		String methodName = "HtmlunitDriver";
		System.out.println("I am inside test : "+methodName+"");
		
		HtmlUnitDriver d = null;
		DesiredCapabilities capabilities = DesiredCapabilities.htmlUnit();
		capabilities.setJavascriptEnabled(true);
		d= new HtmlUnitDriver(capabilities);
		
		reportUtils.addInfo("Executing Started for headless browser: " + methodName, methodName);
		System.out.println("HtmlunitDriver driver instance for test "+methodName+" is :"+d+"");
		
		d.get("https://www.at.ford.com/");
		System.out.println("started");
		
		try
		{
			Thread.sleep(3000);
			d.get("https://www.google.com/");
			System.out.println("HtmlunitDriver - Completed");
			/*			d.close();
			d.quit();*/

		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			/*			d.close();
			d.quit();*/
		}
	}

}
