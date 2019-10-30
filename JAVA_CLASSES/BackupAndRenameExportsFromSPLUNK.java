package etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class BackupAndRenameExportsFromSPLUNK 
{

	public static void main(String[] args) 
	{
		String fileSource="C:\\Users\\rrose66\\Downloads\\";
		String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, "","Backup and Rename SPLUNK files",intDialogButton);
		if(intDialogButton == 0)
		{
			CopySPLUNKFilesToDriveY();
//			File dir = new File(fileSource);
//			File[] filesList = dir.listFiles();
//			for (File file : filesList)
//			{
//				if (file.isFile())
//				{
//					if(file.getName().startsWith("export"))
//					{
//						fileSource = fileSource + file.getName();
//						fileDestination = fileDestination +  "SPLUNK_PROGRAM_USAGE_MTD.csv";
//						BackupAndRenameExportsFromSPLUNK.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//						File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//						try 
//						{
//							FileWriter fw = new FileWriter(batFile);
//							BufferedWriter bw = new BufferedWriter(fw);
//							bw.write("move /Y \"" + fileSource + "\", \"" + fileDestination+"\"");
//							bw.close();
//							java.lang.Process runProcess;
//							runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//	
//						} 
//						catch (IOException e) 
//						{
//							e.printStackTrace();
//						}
//					}
//				}
//			}
		}

	}
	public static void CopySPLUNKFilesToDriveY()
	{
		DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
		String fileSource="C:\\Users\\rrose66\\Downloads\\";
		String fileDestination="Y:\\ARCHIVES\\LEADERSHIP_DECK\\USER_METRICS\\";
//		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//		intDialogButton=JOptionPane.showConfirmDialog(null, "","Backup and Rename SPLUNK files",intDialogButton);
//		if(intDialogButton == 0)
//		{
			fileSource="C:\\Users\\rrose66\\Downloads\\";
			FileWriter batFile=null;
//			AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
//			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				FileWriter fw = batFile;
				BufferedWriter bw = new BufferedWriter(fw);
//				bw.write("move /Y \"" + fileSource + "SPLUNK_PROGRAM_USAGE_MTD.csv" + "\", \"" + fileDestination+  "SPLUNK_PROGRAM_USAGE_MTD" + "_" + GetStringTodayYYYYMMDD1() +".csv" + "\"");
//				bw.newLine();
				bw.write("move /Y \"" + fileSource + "SPLUNK_PROGRAM_USAGE_PM.csv" + "\", \"" + fileDestination+ "SPLUNK_PROGRAM_USAGE_MTD" + "_" + GetStringTodayYYYYMMDD1() + ".csv"+ "\"");
				bw.newLine();
				bw.write("move /Y \"" + fileSource + "SPLUNK_SEARCHES.csv" + "\", \"" + fileDestination+"SPLUNK_SEARCHES" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
				bw.newLine();
				bw.write("move /Y \"" + fileSource + "SPLUNK_SUBMITS.csv" + "\", \"" + fileDestination+"SPLUNK_SUBMITS" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
				bw.newLine();
//				bw.write("move /Y \"" + fileSource + "tcbomLOGS.zip" + "\", \"" + fileDestination+"tcbomLOGS" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
//				bw.newLine();
//				bw.write("move /Y \"" + fileSource + "tcbomLOGS (1).zip" + "\", \"" + fileDestination+"tcbomLOGS1" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
//				bw.newLine();
//				bw.write("move /Y \"" + fileSource + "tcbomLOGS (2).zip" + "\", \"" + fileDestination+"tcbomLOGS2" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
//				bw.newLine();
//				bw.write("move /Y \"" + fileSource + "tcbomLOGS (3).zip" + "\", \"" + fileDestination+"tcbomLOGS3" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
//				bw.newLine();
//				bw.write("move /Y \"" + fileSource + "tcbomLOGS (4).zip" + "\", \"" + fileDestination+"tcbomLOGS4" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
				bw.close();
				java.lang.Process runProcess;
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
//		}
	}
	public static String GetStringTodayYYYYMMDD1()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}
	public static void DeleteThisFile(String strFullPath)
	{
		Boolean blnReadyToContinue=false;
		File fileToDelete = new File(strFullPath);
		if(fileToDelete.exists())
		{
			fileToDelete.delete();
		}
	}
}
