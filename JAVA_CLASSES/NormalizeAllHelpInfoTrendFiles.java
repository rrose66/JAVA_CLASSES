package etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class NormalizeAllHelpInfoTrendFiles 
{
	public static void main(String[] args) 
	{
		String strMsg="";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg=strMsg + "Clicking Yes will run";
		strMsg=strMsg + "\n   -Normalize each file individually that is identified as a trend file";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process all Help Info Trend Files",intDialogButton);
		if(intDialogButton == 0)
		{
			File fileHIP = new File("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PARSED.TXT");
			File fileHIPI = new File("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT");
			File fileHIHF = new File("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_HOT_FIXES.TXT");
			File fileHIPK = new File("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PK");
			fileHIP.delete();
			fileHIPI.delete();
			fileHIHF.delete();
			fileHIPK.delete();

			FileWriter newFile = null;
			FileWriter filePrograms=null;
			FileWriter fileHotFixes=null;
			try 
			{
				newFile = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PARSED.TXT",true);
				filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
				fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(newFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println("WS_CDSID,WS,CDSID,COUNTRY,USER_GPO,HARD_DRIVE_FREE_SPACE,MODEL,RAM,MACHINE_GPO,IP,ETHERNET_MAC,OS,WINDOWS_VERSION,OS_VERSION,GLOBAL_CLIENT_BUILD");
			
			BufferedWriter textBufferPrograms = new BufferedWriter(filePrograms);
			PrintWriter TextPrinterPrograms = new PrintWriter(textBufferPrograms);
			TextPrinterPrograms.println("WS_CDSID,REFERENCE_PROGRAM,PROGRAM");
			
			BufferedWriter textBufferHotFixes = new BufferedWriter(fileHotFixes);
			PrintWriter textPrinterHotFixes = new PrintWriter(textBufferHotFixes);
			textPrinterHotFixes.println("WS_CDSID,KB,HOT_FIX");
			
			newTextPrinter.close();
			TextPrinterPrograms.close();
			textPrinterHotFixes.close();
			
			File dir = new File("K:\\TRENDING\\");
			if(dir.isDirectory())
			{
				File[] listFiles = dir.listFiles();
				for(File file : listFiles)
				{
					if(file.getName().contains(".txt"))
					{
						NormalizeOneHelpInfo(file,"Trend");
					}
				}
			}
	    }

	}
	public static void NormalizeOneHelpInfo(File fileHelpInfo,String strTrend)
	{
		String strWS="";
		String[] aryWS=null;
		String strCDSID="";
		String[] aryCDSID=null;
		String strDomain="";
		String[] aryDomain=null;
		String strCountry="";
		String[] aryCountry=null;
		String strUserGPO="";
		String[] aryUserGPO=null;
		String[] aryHardDriveFreeSpace=null;
		String strHardDriveFreeSpace="";
		String[] aryModel=null;
		String strModel="";
		String[] aryRam=null;
		String strRam="";
		String[] aryMachineGPO=null;
		String strMachineGPO="";
		String[] aryIP=null;
		String strIP="";
		String[] aryEthernetMAC=null;
		String strEthernetMAC="";
		String[] aryOS=null;
		String strOS="";
		String[] aryVersionOS=null;
		String[] aryWindowsVersion=null;
		String strWindowsVersion="";
		String strEnterpriseVersion="";
		String strVersionOS="";
		String[] aryGlobalClientBuild=null;
		String strGlobalClientBuild="";
		String[] aryGlobalClientVersion=null;
		String strGlobalClientVersion="";
		String strInstalledProgramsFound="F";
		String strHotFixesFound="F";
		String strInternetExplorerVersion="";
		String strSkip=null;
		
		if(fileHelpInfo.exists())
		{
			String inputData=null;
			String[] aryInput=null;
			FileWriter newFile = null;
			FileWriter filePrograms=null;
			FileWriter fileHotFixes=null;
			FileWriter filePK= null;
			if (strTrend == "Current")
			{
				try 
				{
					newFile = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_PARSED.TXT",true);
					filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_PROGRAMS_INSTALLED.TXT",true);
					fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_HOT_FIXES.TXT",true);
					filePK = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_PK",true);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
				try 
				{
					newFile = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_TREND_PARSED.TXT",true);
					filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
					fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
					filePK = new FileWriter("C:\\PROJECTS\\DATA\\WIZ\\HELP_INFO\\EOP\\HELP_INFO_TREND_PK",true);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
			BufferedWriter newTextBuffer = new BufferedWriter(newFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			
			BufferedWriter textBufferPrograms = new BufferedWriter(filePrograms);
			PrintWriter TextPrinterPrograms = new PrintWriter(textBufferPrograms);
			
			BufferedWriter textBufferHotFixes = new BufferedWriter(fileHotFixes);
			PrintWriter textPrinterHotFixes = new PrintWriter(textBufferHotFixes);
			
			BufferedWriter textBufferPK = new BufferedWriter(filePK);
			PrintWriter textPrinterPK = new PrintWriter(textBufferPK);
	
			try
			{
				Scanner sc = new Scanner(fileHelpInfo);
				sc.nextLine();
				while (sc.hasNextLine())
				{
					inputData=sc.nextLine();
					strSkip="F";
					if(inputData.contains("Installed Programs"))
					{
						strSkip="T";
					}
					if(inputData.contains("Installed HotFixes"))
					{
						strSkip="T";
					}
					if(inputData.contains("Information for:"))
					{
						aryWS=inputData.split(":");
						strWS=aryWS[1];
						strWS =strWS.trim();
					}
					if(inputData.contains("CDSID:"))
					{
						aryCDSID=inputData.split(":");
						strCDSID=aryCDSID[1];
						strCDSID =strCDSID.trim();
					}
					if(inputData.contains("Domain (User):"))
					{
						aryDomain=inputData.split(":");
//						strCountry=aryDomain[1].substring(0, 3);
						aryCountry=aryDomain[1].split("\\.");
						strCountry = aryCountry[0];
					}
					if(inputData.contains("GPO Level (User):"))
					{
						aryUserGPO=inputData.split(":");
						strUserGPO=aryUserGPO[1];
						strUserGPO = strUserGPO.trim();
					}
					if(inputData.contains("HD Free Space:"))
					{
						aryHardDriveFreeSpace=inputData.split(":");
						strHardDriveFreeSpace=aryHardDriveFreeSpace[1];
						strHardDriveFreeSpace = strHardDriveFreeSpace.trim();
					}
					if(inputData.contains("PC Model:"))
					{
						aryModel=inputData.split(":");
						strModel=aryModel[1];
						strModel = strModel.trim();
					}
					if(inputData.contains("RAM:"))
					{
						aryRam=inputData.split(":");
						strRam=aryRam[1];
						strRam = strRam.trim();
					}
					if(inputData.contains("GPO Level (Machine):"))
					{
						aryMachineGPO=inputData.split(":");
						strMachineGPO=aryMachineGPO[1];
						strMachineGPO = strMachineGPO.trim();
					}
					if(inputData.contains("IP Address:"))
					{
						aryMachineGPO=inputData.split(":");
						strIP=aryMachineGPO[1];
						strIP = strIP.trim();
					}
					if(inputData.contains("MAC Address:"))
					{
						aryMachineGPO=inputData.split(":");
						strEthernetMAC=aryMachineGPO[1];
						strEthernetMAC = strEthernetMAC.trim();
					}
					if(inputData.contains("Version (OS):"))
					{
						aryVersionOS=inputData.split(":");
						strOS=aryVersionOS[1];
						strOS = strOS.trim();
						aryWindowsVersion=strOS.split(" ");
						System.out.println(aryWindowsVersion.length);
						if(aryWindowsVersion.length == 1)
						{
							strWindowsVersion="";
						}
						else
						{
							strWindowsVersion=aryWindowsVersion[2];
						}
						if(aryWindowsVersion.length == 7)
						{
							strEnterpriseVersion=aryWindowsVersion[4] + " " + aryWindowsVersion[5] + " " + aryWindowsVersion[6];
						}
						else if(aryWindowsVersion.length == 6)
						{
							strEnterpriseVersion=aryWindowsVersion[4] + " " + aryWindowsVersion[5] ;
						}
					}
					if(inputData.contains("Build Disk:"))
					{
						aryMachineGPO=inputData.split(":");
						strGlobalClientBuild=aryMachineGPO[1];
						strGlobalClientBuild = strGlobalClientBuild.trim();
					}
					if(inputData.contains("Version (GC):"))
					{
						aryMachineGPO=inputData.split(":");
						strGlobalClientVersion=aryMachineGPO[1];
						strGlobalClientVersion = strGlobalClientVersion.trim();
					}
					if(inputData.contains("Installed Programs"))
					{
						strInstalledProgramsFound="T";
					}
					if(strInstalledProgramsFound == "T" && strSkip=="F")
					{
						if(inputData.contains("Internet Explorer:"))
						{
							TextPrinterPrograms.println(strWS +"_" + strCDSID + ",IE," + inputData.replace(",", "__"));
						}
						else if(inputData.contains("Microsoft Excel"))
						{
							TextPrinterPrograms.println(strWS +"_" + strCDSID + ",Excel," + inputData.replace(",", "__"));
						}
						else if(inputData.contains("Microsoft Office"))
						{
							TextPrinterPrograms.println(strWS +"_" + strCDSID + ",Office," + inputData.replace(",", "__"));
						}
						else if(inputData.contains("Java"))
						{
							TextPrinterPrograms.println(strWS +"_" + strCDSID + ",Java," + inputData.replace(",", "__"));
						}
						else
						{
							TextPrinterPrograms.println(strWS +"_" + strCDSID + ",Other," + inputData.replace(",", "__"));						
						}
					}
					if(inputData.contains("Installed HotFixes"))
					{
						strInstalledProgramsFound="F";
						strHotFixesFound="T";
						strSkip="T";
					}
					if(strHotFixesFound=="T"  && strSkip=="F")
					{
						if(inputData.contains("Internet Explorer:"))
						{
								textPrinterHotFixes.println(strWS +"_" + strCDSID  + ",IE,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
						}
						else if(inputData.contains("Microsoft Excel"))
						{
							textPrinterHotFixes.println(strWS +"_" + strCDSID   +  ",Excel,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
						}
						else if(inputData.contains("Microsoft Office"))
						{
							textPrinterHotFixes.println(strWS +"_" + strCDSID +  ",Office,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
						}
						else
						{
							textPrinterHotFixes.println(strWS +"_" + strCDSID +  ",Other,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
						}
					}
				}
				sc.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			if(strSkip=="F")
			{
				newTextPrinter.println(strWS + "_" + strCDSID + "," + strWS + ", " + strCDSID + "," + strCountry + "," + strUserGPO + "," + strHardDriveFreeSpace + "," + strModel + "," + strRam + "," + strMachineGPO + "," + strIP + "," + strEthernetMAC + "," + strOS + "," + strWindowsVersion  + "," + strGlobalClientVersion.replace("\"", "") + "," + strGlobalClientBuild );
			}
			strSkip="F";
				newTextPrinter.close();
				TextPrinterPrograms.close();
				textPrinterHotFixes.close();
				try 
				{
					newFile.close();
					filePrograms.close();
					fileHotFixes.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			newTextPrinter.close();
		}
	}
	public static String GetKB(String strInputData)
	{
		String kb=null;
		String[] aryKB=null;
		String[] aryKBonly=null;
		int intStartOfKB=0;
		int intEndOfKB=0;
		String strToParse=null;
		String strCalc="";
		if(strInputData.contains("(KB"))
		{
			intStartOfKB = strInputData.lastIndexOf("(KB");
			strToParse=strInputData.substring(intStartOfKB+1);
			aryKBonly=strToParse.split("");
			for(int n=0;n<=8;n++)
			{
				if(aryKBonly[n]==")")
				{
					break;
				}
				strCalc = strCalc + aryKBonly[n];
			}
			kb=strCalc;
		}
		return kb;
	}

}
