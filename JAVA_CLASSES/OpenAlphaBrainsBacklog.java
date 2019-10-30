package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenAlphaBrainsBacklog 
{
	public static void main(String[] args) 
	{
//		String strMsg="";
//		strMsg=strMsg + "\nClicking Yes will";
//		strMsg=strMsg + "\n    -Open Rally and go to the Views";
//		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Open Rally?",intDialogButton);
//		if(intDialogButton == 0)
//		{
			Properties prop =loadProperties();
			WebDriver driver;
			File jarPath=new File(OpenAlphaBrainsBacklog.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        String seleniumDriverPath=jarPath.getParentFile().getAbsolutePath()+"\\chromedriver.exe";
	        String driverPath = seleniumDriverPath.replace("%20", " ");
			System.setProperty("webdriver.chrome.driver",driverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.get("https://rally1.rallydev.com/#/51575742627ud/workviews");
//			driver.get("https://rally1.rallydev.com/#/279864618004ud/backlog");
			driver.get("https://rally1.rallydev.com/#/279864618004ud/portfolioitemstreegrid");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getPageSource());
			System.out.println(driver.getWindowHandle());
			driver.findElement(By.xpath("//span[contains(text(),'Active Directory')]")).click();
			Thread thread = new Thread();
			try 
			{
				thread.sleep(10000);
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
//		}
	}
	private static Properties loadProperties() 
	{
		final Properties properties = new Properties();
		InputStream input = null;
		try 
		{
			File jarPath=new File(OpenAlphaBrainsBacklog.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
	        System.out.println(" propertiesPath-"+propertiesPath);
	        properties.load(new FileInputStream("application.properties"));
			System.out.println("application.properties loaded");
		} 
		catch (final Exception e) 
		{
			System.out.println("Loading proprties file failed");
			
		} 
		finally 
		{
			if (input != null)
				try 
				{
					input.close();
				} 
				catch (final IOException e) 
				{
						
				}
		}
		return properties;
	}
}
