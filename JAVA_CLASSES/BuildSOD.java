package report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class BuildSOD 
{
	public static String strStartAlteryx="C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe";
	public static String strStartQlikView="C:\\Program Files\\Alteryx\\bin\\QV.exe";
	public static String strStartAccess="C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\MSACCESS.EXE";
	public static String strStartProject="C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINPROJ.EXE";
	public static String strStartWord="C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.EXE";
	public static String strStartExcel="C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE /c start";
	public static String strStartOutlook="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Microsoft Office 2016\\Outlook 2016.EXE";
	public static String strStartHelpInfo="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\HelpInfo.EXE";
	public static String strStartRegEdit="REGEDIT.EXE";
	public static String strStartChrome="C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging";
	public static String strStartIE="C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging ";
	public static String strStartPW="C:\\WINDOWS\\system32\\WindowsPowerShell\\v1.0\\powershell_ise.exe";

//	Paths
	public static String strAlteryxRepository="C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\ALTERYX\\";
	public static String strDownloads="C:\\Users\\rrose66\\Downloads\\";
	public static String strDestination="Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\";
	public static String strSODmdb="C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\";
	
	public static void main(String[] args) 
	{
		Integer intDialogButton=0;
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		String strMsg = "Click to do the following:";
		strMsg=strMsg + "\n Refresh the Oracle Dump file with the file extracted today";
		strMsg=strMsg + "\n Run SOD_CONFLICTS_DEVELOPERS_WITH_PRODUCTION_EDIT_ACCESS.yxmd";
		strMsg=strMsg + "\n Run SOD Access db that auto populates the SOD";
		strMsg=strMsg + "\n Should see the SOD Excel file";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Populate the SOD?",intDialogButton);
		if(intDialogButton == 0)
		{
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			File sourceDir = new File("Y:\\ARCHIVES\\LEADERSHIP_DECK\\USER_METRICS\\ORACLE_DUMP_"  + GetStringTodayYYYYMMDD() + ".csv");
			File targetDir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\ORACLE_DUMP.csv");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println("copy /Y \"" + sourceDir + "\", \"" + targetDir + "\"");
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
//			java.lang.Process runProcess;
			String[] cmd01 = {strStartAlteryx, strAlteryxRepository + "SOD_CONFLICTS_DEVELOPERS_WITH_PRODUCTION_EDIT_ACCESS.yxmd"};
			WaitThisLong(5000);
//			WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\CONFLICTS\\DEVELOPERS_WITH_PRODUCTION_EDIT_ACCESS.csv");
			WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\DEVELOPERS_BY_ROLE_ENV.csv");
			try 
			{
				runProcess = Runtime.getRuntime().exec(cmd01);
			} 
			catch (IOException e2) 
			{
				e2.printStackTrace();
			}
			String[] cmd02 = {strStartAccess, strSODmdb + "SOD.accdb"};
			WaitThisLong(5000);
			try 
			{
				runProcess = Runtime.getRuntime().exec(cmd02);
			} 
			catch (IOException e2) 
			{
				e2.printStackTrace();
			}
			String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "SOD_CONFLICTS_ACCUREV.yxmd"};
			try 
			{
				runProcess = Runtime.getRuntime().exec(cmd03);
			} 
			catch (IOException e2) 
			{
				e2.printStackTrace();
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
	public static String GetStringTodayYYYYMMDD()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}
	public static void WaitThisLong(long lngMilliSeconds)
	{
		try 
		{
			Thread.sleep(lngMilliSeconds);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
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
	}}
