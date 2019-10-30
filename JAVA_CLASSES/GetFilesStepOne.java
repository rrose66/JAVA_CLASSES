package dev.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class GetFilesStepOne {

	public static void main(String[] args) 
	{
		boolean success=false;
		@SuppressWarnings("unused")
		Process runEachCommand;
		try 
		{
			File wizReportSource = new File ("Y:\\ARCHIVES\\DEV\\WIZARD\\WIZARD_MONITORING_DATA\\FOR_MONITOR_DASHBOARD.txt");
			File wizReportTarget = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\FOR_MONITOR_DASHBOARD.TXT");
			copyFile(wizReportSource,wizReportTarget);
			File allLogsDone = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_DONE.CSV");
			allLogsDone.delete();
			File allLogs = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.TXT");
			allLogs.delete();
			File dailyDynamic = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DailyDynamic.bat");
			dailyDynamic.delete();
			File fileAllLogsForReport = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_FOR_REPORT.TXT");
			fileAllLogsForReport.delete();

			File fileIndicatingDone = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DONE_GETTING_LOGS.TXT");
			while(success==false)
			{
				if(fileIndicatingDone.exists())
				{
					success=true;
				}
			}

			success=false;
			String[] cmdOne ={ "C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe","C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\ALL_LOGS_TO_ONE_CSV.yxmd" };
			runEachCommand = Runtime.getRuntime().exec(cmdOne);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void copyFile(File sourceFile,File destFile) throws IOException
	{
		if(!destFile.exists())
		{
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try
		{
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
			source.close();
			destination.close();
			
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
//		finally
//		{
//			if(source !=null)
//			{
//				source.close();
//			}
//			if(destination != null)
//			{
//				destination.close();
//			}
//		}
	}
}
