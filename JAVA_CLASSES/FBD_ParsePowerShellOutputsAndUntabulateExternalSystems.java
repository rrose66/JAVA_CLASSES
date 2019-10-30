package etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FBD_ParsePowerShellOutputsAndUntabulateExternalSystems 
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

	public static String strLocalFolderForWIP="C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\CREDENTIAL_PASSWORD_MANAGEMENT\\";

	public static void main(String[] args) 
	{
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, "Clicking Yes will run parse PowerShell Outputs then Untabulate External Systems","PowerShell has been manually run so now manually process that data?",intDialogButton);
		if(intDialogButton == 0)
		{
			RemoveEmptyFiles();
			FileWriter fwExtSystems = null;
			try 
			{
				fwExtSystems = new FileWriter(strLocalFolderForWIP + "READY_FOR_SHARE_POINT\\EXTERNAL_SYSTEMS.TXT",true);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(fwExtSystems);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println("ENVIRONMENT,CONFIG,SYSTEM,SERVER,DB,USER");
			File fileExtSystems = new File(strLocalFolderForWIP + "EXTRACTS\\EXTERNAL_SYSTEMS.csv");
			Boolean blnSkipLine;
			blnSkipLine=false;
			String strEnvironment=null;
			String strConfig=null;
			String strInputData=null;
			String[] aryInputData=null;
			Scanner scExtSystemsIn = null;
			try 
			{
				scExtSystemsIn = new Scanner(fileExtSystems);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			scExtSystemsIn.nextLine();
			while (scExtSystemsIn.hasNextLine())
			{
				strInputData=scExtSystemsIn.nextLine();
				aryInputData=strInputData.split(",");
				if (strInputData.contains("SqlLiteDB"))
				{
					System.out.println("SqlLiteDB record has blank user");
				}
				if (strInputData.contains("SERVERNAME"))
				{
					System.out.println("SERVERNAME has blank user");
				}
				if (strInputData.contains("transLogSchema.db"))
				{
					System.out.println("transLogSchema.db has blank user");
				}
				if (strInputData.contains("TERAQA.app.ford.com"))
				{
					System.out.println("TERAQA.app.ford.com has blank user");
				}
				if (strInputData.contains("USERNAME"))
				{
					blnSkipLine=true;
				}
				else if (strInputData.length()==6)
				{
					blnSkipLine=true;
				}
				else if (aryInputData.length ==5)
				{
					if (aryInputData[4].length()==2)
					{
						blnSkipLine=true;
					}
					if (blnSkipLine==false)
					{
						if (aryInputData[2].length()==2)
						{
							blnSkipLine=true;
						}
					}
					if (blnSkipLine==false)
					{
						if (aryInputData[3].length() ==2)
						{
							blnSkipLine=true;
						}
					}
				}
				if (blnSkipLine==false)
				{
					if(aryInputData.length==2)
					{
						if (aryInputData[0].length()==2)
						{
							strConfig=aryInputData[1];
						}
						else
						{
							strEnvironment=aryInputData[0];
							strConfig=aryInputData[1];
						}
					}
					else
					{
						if (!strEnvironment.isEmpty()) 
						{
							if (!strConfig.isEmpty())
							{
								if (!aryInputData[1].isEmpty())
								{
									if (!aryInputData[2].isEmpty())
									{
										if (!aryInputData[3].isEmpty())
										{
											if (!aryInputData[4].isEmpty())
											{
												newTextPrinter.println(GetEnv(strEnvironment) + "," + strConfig + "," + aryInputData[1] + "," + aryInputData[2] + "," + aryInputData[3] + "," + aryInputData[4]);
											}
										}
									}
								}
							}
						}
					}
					blnSkipLine=false;
				}
				else
				{
					blnSkipLine=false;
				}
			}	
			newTextPrinter.close();
			scExtSystemsIn.close();
			
		}
		java.lang.Process runProcess;
		String[] cmd01 = {strStartAlteryx, strAlteryxRepository + "CMT_UPDATE_SHARE_POINT_WITH_AD_SEARCH_RESULTS.yxmd"};
		try 
		{
			runProcess = Runtime.getRuntime().exec(cmd01);
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}

	}
	public static String GetEnv(String strEnvironment)
	{
		String strReturnedEnvironemt=null;
		switch (strEnvironment)
		{
		case "Prod":
			strReturnedEnvironemt="Prod";
			break;
		case "Integration_(I6S2)":
			strReturnedEnvironemt="I6S2";
			break;
		case "Pre_Prod_(I6S1)":
			strReturnedEnvironemt="I6S1";
			break;
		case "CAD_BOM_(I2S3)":
			strReturnedEnvironemt="I2S3";
			break;
		case "Developement_(D4S2)":
			strReturnedEnvironemt="D4S2";
			break;
		case "Developement_(D4S1)":
			strReturnedEnvironemt="D4S1";
			break;
		}
		return strReturnedEnvironemt;
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
	public static void DeleteThisFile(String strFullPath)
	{
		Boolean blnReadyToContinue=false;
		File fileToDelete = new File(strFullPath);
		if(fileToDelete.exists())
		{
			fileToDelete.delete();
		}
	}
	public static void RemoveEmptyFiles()
	{

		File dir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\CREDENTIAL_PASSWORD_MANAGEMENT\\READY_FOR_SHARE_POINT\\");
		File[] filesList = dir.listFiles();
		for (File file : filesList)
		{
			if (file.isFile())
			{
				if(file.length()==0)
				{
					file.delete();
				}
			}
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
	}
}
