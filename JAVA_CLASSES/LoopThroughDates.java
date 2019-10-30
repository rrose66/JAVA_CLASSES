package etl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class LoopThroughDates 
{
//	External Applications
	public static String strStartAlteryx="C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe";
	public static String strStartQlikView="C:\\Program Files\\Alteryx\\bin\\QV.exe";
	public static String strStartAccess="C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE";
	public static String strStartProject="C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINPROJ.EXE";
	public static String strStartWord="C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINWORD.EXE";
	public static String strStartExcel="C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE /c start";
	public static String strStartOutlook="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Microsoft Office 2016\\Outlook 2016.EXE";
	public static String strStartHelpInfo="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\HelpInfo.EXE";
	public static String strStartRegEdit="REGEDIT.EXE";
	public static String strStartChrome="C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging";
	public static String strStartIE="C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging ";

//	Paths
	public static String strAlteryxRepository="C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\ALTERYX\\";
	public static void main(String[] args) 
	{
		String strMsg="";
		strMsg=strMsg + "Process another Date?";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process another Date?",intDialogButton);
		if(intDialogButton == 0)
		{
			ProcessServerLogs();
		}	
	}
	public static void ProcessServerLogs()
	{
//		String strMsg="";
//		strMsg=strMsg + "Manual Tasks:";
//		strMsg=strMsg + "\n    -Open the Server Log Trends QlikView and find the last scanned date";
//		strMsg=strMsg + "\nClicking Yes will";
//		strMsg=strMsg + "\n    -Prompt for a date to process";
//		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Update local folders and record changes",intDialogButton);
//		if(intDialogButton == 0)
//		{
			String strDateToProcess="";
			strDateToProcess=JOptionPane.showInputDialog("After pulling the latest Server Logs, enter the Date to Process in the YYYY-MM-DD format");
			try 
			{
				NormalizeServerLogs(strDateToProcess);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
//		}	
		ProcessServerLogLoop();
	}
	public static void NormalizeServerLogs(String strDateToProcess) throws IOException
	{
		String strFullPath;
//		File dir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\");
		File dir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\STAGGING\\");
		if(dir.isDirectory())
		{
			File[] listFiles = dir.listFiles();
			for(File file : listFiles)
			{
				if(file.getName().contains(".log"))
				{
					System.out.println(file.getPath());
					strFullPath=file.getPath();
					ConvertToCommaDelimited(strFullPath,strDateToProcess);				
				}
			}
		}
	}
	public static void ConvertToCommaDelimited(String strFilePath, String strDateToProcess) throws IOException
	{
		String strInputData=null;
		String[] aryInputData=null;
		String[] aryDate;
		String[] aryTime;
		String strScanned="";
		String strMaxScanned="1995";
		int intScanned=0;
		int intMaxScanned=1995;
		String strFileName;
		String strKeepGoing="F";
		String strInfoError=null;
		String strDateTime=null;
		String strDate;
		String strProgram;
		String strMethod;
		String[] aryChunk01;
		String[] aryChunk02;
		String[] aryChunk03;
		String[] aryCDSID;
		String strLine;
		String strCDSID;
		Date dtDateTime;
		int intAryLength;
		int intYear;
		int intMonth;
		int intDay;
		int intStart;
		int intEnd;
		int intFoundCDSID;
		int intFound;
		long lngRow=0;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat dfTarget = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dateCurrent = null;
//		DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\FB4SchedulerFinal.txt");
//		DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\FB4Scheduler.txt");
		String[] aryFileTextName;
		String strFileTextName;
		String[] aryFileDelimitedName;
		String strFileDelimitedName;
//		System.out.println("String for the file path is: " + strFilePath);
		aryFileTextName=strFilePath.split("\\.");
		strFileTextName=aryFileTextName[0] + ".txt";
		File fileInput = new File(strFilePath);
		strFileName=fileInput.getName();
//		strFileDelimitedName=aryFileTextName[0] + "Final.txt";
		strFileDelimitedName="C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\DT.CSV";
		
		DeleteThisFile(strFileTextName);
//		DeleteThisFile(strFileDelimitedName);
		
		FileWriter fwFB4SchedulerS1 = new FileWriter(strFileTextName,true);
		BufferedWriter newBW = new BufferedWriter(fwFB4SchedulerS1);
		PrintWriter newTW = new PrintWriter(newBW);
		
		BufferedReader br = new BufferedReader(new FileReader(strFilePath));
		strInputData = br.readLine();
		while(strInputData!=null)
		{
			if(strInputData.startsWith(strDateToProcess))
			{
				newTW.println(strInputData);
			}
			else
			{
//				System.out.println(strInputData);
			}
//			if(strInputData.startsWith("2019"))
//			{
//				newTW.println(strInputData);
//			}
			strInputData = br.readLine();
		}
		newTW.close();
		br.close();
		String strLineType;
		String strMethodLine;

		FileWriter fwFB4SchedulerS2 = new FileWriter(strFileDelimitedName,true);
//		FileWriter fwFB4SchedulerS2 = new FileWriter(strFileDelimitedName,false);
		BufferedWriter newBW1 = new BufferedWriter(fwFB4SchedulerS2);
		PrintWriter newTW1 = new PrintWriter(newBW1);

		int intProcessedRows=0;
		BufferedReader brStep1 = new BufferedReader(new FileReader(strFileTextName));
		strInputData = brStep1.readLine();
		String[] aryScanned=null;
		while(strInputData!=null)
		{
			intProcessedRows++;
//			if(intProcessedRows > 1000)
//			{
//				break;
//			}
//			dtDateTime = GetDateFromLine(strInputData);
			strDateTime=GetDateTimeAsString(strInputData);
			if(strDateTime.equals("BAD"))
			{
				System.out.println("BAD entry so skip line");
			}
			else
			{
				strLineType = GetLineType(strInputData);
				aryScanned=strDateTime.split("");
				strScanned=aryScanned[0] + aryScanned[1] + aryScanned[2] + aryScanned[3] + aryScanned[5] + aryScanned[6] + aryScanned[8] + aryScanned[9];
				intScanned=Integer.parseInt(strScanned);
				intMaxScanned=Integer.parseInt(strMaxScanned);
				if(intScanned  > intMaxScanned)
				{
					strMaxScanned = strScanned;
				}
				strMethod = GetLineMethod(strInputData);
//				strMethodLine = GetLineMethodRow(strInputData);
				
				newTW1.println(strFileName + "," + strDateTime.substring(0,8) + "," + strDateTime + "," + strLineType + "," + strMethod);
			}
			strInputData = brStep1.readLine();
		}
		brStep1.close();
		newTW1.close();
	}
	public static String GetDateTimeAsString(String strInputData)
	{
		String[] aryLine=null;
		aryLine=strInputData.split("");
//		String[] aryDateTime=null;
		String strDateTime="";
//		String strTime=null;
//		aryDateTime=aryLine[1].split("");
		int intCountSemicolon=0;
		for(int intAryLocation=0;intAryLocation < 20;intAryLocation++)
		{
			if(aryLine[intAryLocation].equals(":") || aryLine[intAryLocation].equals("-") || aryLine[intAryLocation].equals(" "))
			{
				intCountSemicolon++;
			}
			else
			{
				strDateTime=strDateTime + aryLine[intAryLocation];
			}
		}
		if(intCountSemicolon < 2)
		{
			return "BAD";
		}
		else
		{
			return strDateTime;
		}
		
	}
	public static String GetLineType(String strInputData)
	{
		String[] aryLineType=null;
		aryLineType=strInputData.split(" ");
		return aryLineType[2];
	}
	public static String GetLineMethod(String strInputData)
	{
		String[] aryLine=null;
		String[] aryLineMethod=null;
		aryLine=strInputData.split(" ");
		aryLineMethod=aryLine[4].split(":");
		return aryLineMethod[0];
	}
	public static void ProcessServerLogLoop()
	{
		String strMsg="";
		strMsg=strMsg + "Process another Date?";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process another Date?",intDialogButton);
		if(intDialogButton == 0)
		{
			ProcessServerLogs();
		}
		else
		{
			try
			{
				java.lang.Process runProcess;
				String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "ELIMINATE_DUPLICATES.yxmd"};
				runProcess = Runtime.getRuntime().exec(cmd03);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
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
