package src.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import joptions.Checklist;

public class ObsoletePlus 
{
	public static void WaitUntilThisFileIsWritable(String strFullPath)
	{
		Boolean blnReadyToContinue=false;
		while(blnReadyToContinue==false)
		{
			File f = new File(strFullPath);
			try 
			{
				Thread.sleep(6000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(f.canWrite())
			{
				blnReadyToContinue=true;
			}
		}
	}
//	public static Properties loadProperties() 
//	{
//		final Properties properties = new Properties();
//		InputStream input = null;
//		try 
//		{
//			File jarPath=new File(AutomatedProcesses.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//	        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
//	        System.out.println(" propertiesPath-"+propertiesPath);
//	        properties.load(new FileInputStream("application.properties"));
//			System.out.println("application.properties loaded");
//		} 
//		catch (final Exception e) 
//		{
//			System.out.println("Loading proprties file failed");
//			
//		} 
//		finally 
//		{
//			if (input != null)
//				try 
//				{
//					input.close();
//				} 
//				catch (final IOException e) 
//				{
//						
//				}
//		}
//		return properties;
//	}

}
