package etl;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class ParseData 
{
	public static void main(String[] args) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		String strScanned=dateFormat.format(dateFile);

		String fileSource="C:\\Users\\rrose66\\Desktop\\HelpInfo-WGC1AA3CQJ3M2.txt";
		String fileDestination="Y:\\ARCHIVES\\HELPINFO\\" +strScanned+ "_HelpInfo-WGC1AA3CQJ3M2.txt";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		String strMsg="Before Clicking Yes";
		strMsg=strMsg + "\n Save the Local HelpInfo file";
		strMsg=strMsg + "\n Export the registry";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Click Yes to Save the Local HelpInfo file to the SharePoint on Y drive and normalized",intDialogButton);
		if(intDialogButton == 0)
		{
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			try 
			{
				FileWriter fw = new FileWriter(batFile);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("move /Y \"" + fileSource + "\", \"" + fileDestination+"\"");
				bw.close();
				java.lang.Process runProcess;
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			File fileRoot = new File("/");
			System.out.println("Free Space: " + fileRoot.getFreeSpace());
			NormalizeLocalHelpInfoData(fileDestination);
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
		public static void NormalizeLocalHelpInfoData(String fileDestination)
		{

			String strMsg="";
			File fileHIP = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PARSED.TXT");
			File fileHIPI = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT");
			File fileHIHF = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HOT_FIXES.TXT");
			File fileHIPK = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PK.TXT");
			fileHIP.delete();
			fileHIPI.delete();
			fileHIHF.delete();
			fileHIPK.delete();

			FileWriter fwParsed = null;
			FileWriter fwPrograms=null;
			FileWriter fwHotFixes=null;
			FileWriter fwPK=null;
			try 
			{
				fwParsed = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PARSED.TXT",true);
				fwPrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
				fwHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
				fwPK = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PK.TXT",true);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(fwParsed);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			String strCMD="";
			strCMD=strCMD + "CREATED,";
			strCMD=strCMD + "WS_CDSID,";
			strCMD=strCMD + "WS,";
			strCMD=strCMD + "CDSID,";
			strCMD=strCMD + "COUNTRY,";
			strCMD=strCMD + "USER_GPO,";
			strCMD=strCMD + "HARD_DRIVE_FREE_SPACE,";
			strCMD=strCMD + "MODEL,";
			strCMD=strCMD + "RAM,";
			strCMD=strCMD + "MACHINE_GPO,";
			strCMD=strCMD + "IP,";
			strCMD=strCMD + "ETHERNET_MAC,";
			strCMD=strCMD + "OS,";
			strCMD=strCMD + "WINDOWS_VERSION,";
			strCMD=strCMD + "OS_VERSION,";
			strCMD=strCMD + "GLOBAL_CLIENT_BUILD,";
			strCMD = strCMD + "JAVA_HOME,";
			strCMD = strCMD + "JAVA_LIBRARY_PATH,";
			strCMD = strCMD + "JAVA_CLASS_PATH,";
			strCMD = strCMD + "JAVA_EXT_DIRS,";
			strCMD = strCMD + "JAVA_VERSION,";
			strCMD = strCMD + "JAVA_RUNTIME_VERSION,";
			strCMD = strCMD + "USER_NAME,";
			strCMD = strCMD + "USER_HOME,";
			strCMD = strCMD + "USER_DIR,";
			strCMD = strCMD + "OS_NAME,";
			strCMD = strCMD + "OS_VERSION,";
			strCMD = strCMD + "OS_ARCH,";
			strCMD = strCMD + "FREE_MEMORY,";
			strCMD = strCMD + "TOTAL_MEMORY,";
			strCMD = strCMD + "MAX_MEMORY,";
			strCMD = strCMD + "AVAILABLE_PROCESSORS";
			newTextPrinter.println(strCMD);
			
			BufferedWriter textBufferPrograms = new BufferedWriter(fwPrograms);
			PrintWriter TextPrinterPrograms = new PrintWriter(textBufferPrograms);
			TextPrinterPrograms.println("CREATED,WS_CDSID,REFERENCE_PROGRAM,PROGRAM");
			
			BufferedWriter textBufferHotFixes = new BufferedWriter(fwHotFixes);
			PrintWriter textPrinterHotFixes = new PrintWriter(textBufferHotFixes);
			textPrinterHotFixes.println("CREATED,WS_CDSID,KB,HOT_FIX");
			
			newTextPrinter.close();
			TextPrinterPrograms.close();
			textPrinterHotFixes.close();
			
			File dir = new File("Y:\\ARCHIVES\\HELPINFO\\");
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
		public static void NormalizeOneHelpInfo(File fileHelpInfo,String strTrend)
		{
			String strCMD="";
			String strWS="";
			String[] aryDateCreated=null;
			String strDateCreated=null;
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
			System.getProperties();
			String strJavaHome=System.getProperty("java.home");
			String strJavaLibraryPath=System.getProperty("java.library.path");

			String strJavaClassPath= System.getProperty("java.class.path");
			String strJavaExtDir= System.getProperty("java.ext.dirs");
			String strJavaVersion= System.getProperty("java.version");
			String strJavaRuntimeVersion= System.getProperty("java.runtime.version");
			String strJavaFileSeparator= System.getProperty("file.separator");
			String strJavaPathSeparator= System.getProperty("path.separator");
			String strJavaLineSeparator= System.getProperty("line.separator");
			String strJavaUserName= System.getProperty("user.name");
			String strJavaUserHome= System.getProperty("user.home");
			String strJavaUserDir= System.getProperty("user.dir");
			String strJavaOSName= System.getProperty("os.name");
			String strJavaOSVersion= System.getProperty("os.version");
			String strJavaOSArch= System.getProperty("os.arch");
			Long lngFreeMemory = Runtime.getRuntime().freeMemory();
			Long lngTotalMemory = Runtime.getRuntime().totalMemory();
			Long lngMaxMemory = Runtime.getRuntime().maxMemory();
			Integer intAvailableProcessors = Runtime.getRuntime().availableProcessors();

			String strHIT=null;
			FileWriter fwHeader=null;
			try 
			{
				fwHeader = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HEADER.txt",true);
			} 
			catch (IOException e2) 
			{
				e2.printStackTrace();
			}
			BufferedWriter bwHeader = new BufferedWriter(fwHeader);
			PrintWriter pwHeader = new PrintWriter(bwHeader);
			
//			System.out.println("Java Home: "+ System.getProperty("java.home"));
//			System.out.println("Java library path: "+ System.getProperty("java.library.path"));
//			System.out.println("Java class path: "+ System.getProperty("java.class.path"));
//			System.out.println("Java ext dir: "+ System.getProperty("java.ext.dirs"));
//			System.out.println("Java version: "+ System.getProperty("java.version"));
//			System.out.println("Java runtime version: "+ System.getProperty("java.runtime.version"));
//			System.out.println("Java file separator: "+ System.getProperty("file.separator"));
//			System.out.println("Java Path Separator: "+ System.getProperty("path.separator"));
//			System.out.println("Java Line Separator: "+ System.getProperty("line.separator"));
//			System.out.println("Java User Name: "+ System.getProperty("user.name"));
//			System.out.println("Java User Home: "+ System.getProperty("user.home"));
//			System.out.println("Java User Dir: "+ System.getProperty("user.dir"));
//			System.out.println("Java OS Name: "+ System.getProperty("os.name"));
//			System.out.println("Java OS Version: "+ System.getProperty("os.version"));
//			System.out.println("Java OS Arch: "+ System.getProperty("os.arch"));
//			System.out.println(" Free Memory: " + Runtime.getRuntime().freeMemory());
//			System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory());
//			System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory());
//			System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
			
			if(fileHelpInfo.exists())
			{
				String inputData=null;
				String[] aryInput=null;
				FileWriter fwParsed = null;
				FileWriter fwPrograms=null;
				FileWriter fwHotFixes=null;
				FileWriter filePK= null;
				if (strTrend == "Current")
				{
					try 
					{
						fwParsed = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT",true);
						fwPrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PROGRAMS_INSTALLED.TXT",true);
						fwHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_HOT_FIXES.TXT",true);
						filePK = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PK.TXT",true);
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
						fwParsed = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PARSED.TXT",true);
						fwPrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
						fwHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
						filePK = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PK.TXT",true);
					} 
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
				}
				BufferedWriter newTextBuffer = new BufferedWriter(fwParsed);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
				
				BufferedWriter textBufferPrograms = new BufferedWriter(fwPrograms);
				PrintWriter TextPrinterPrograms = new PrintWriter(textBufferPrograms);
				
				BufferedWriter textBufferHotFixes = new BufferedWriter(fwHotFixes);
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
						if(inputData.contains("Help Information Tool"))
						{
							String[] aryHIT=inputData.split(" ");
							strHIT = aryHIT[6];
						}

						if(inputData.contains("Information for:"))
						{
							String[] aryIFWS=inputData.split(":");
							String[] aryWSo=aryIFWS[1].split("\\");
							String strIFWS = aryWSo[1];
							String strWSheader=SplitByForwardSlash(SplitBySemicolon(inputData));
						}
						if(inputData.contains("Created by:"))
						{
							String[] aryIFCB=inputData.split(":");
							String[] aryIFCBCDSID=aryIFCB[1].split("\\");
							String strIFCBCDSID=aryIFCBCDSID[1];
						}
						if(inputData.contains("Date Created:"))
						{
							aryDateCreated=inputData.split(":");
							strDateCreated=aryDateCreated[1];
							strDateCreated=strDateCreated.trim();
							pwHeader.println(strDateCreated + "_" + strWS + "," + strHIT );
						}
						if(inputData.contains("CDSID:"))
						{
							aryCDSID=inputData.split(":");
							strCDSID=aryCDSID[1];
							strCDSID =strCDSID.trim();
						}
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
						if(inputData.contains("Domain (User):"))
						{
							aryDomain=inputData.split(":");
		//					strCountry=aryDomain[1].substring(0, 3);
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
								TextPrinterPrograms.println(strDateCreated + "," + strWS +"_" + strCDSID + ",IE," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Excel"))
							{
								TextPrinterPrograms.println(strDateCreated + "," + strWS +"_" + strCDSID + ",Excel," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Office"))
							{
								TextPrinterPrograms.println(strDateCreated + "," + strWS +"_" + strCDSID + ",Office," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Java"))
							{
								TextPrinterPrograms.println(strDateCreated + "," + strWS +"_" + strCDSID + ",Java," + inputData.replace(",", "__"));
							}
							else
							{
								TextPrinterPrograms.println(strDateCreated + "," + strWS +"_" + strCDSID + ",Other," + inputData.replace(",", "__"));						
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
								strCMD="";
								strCMD = strCMD + "strDateCreated + \",\"";
								strCMD = strCMD + "strWS +\"_\" + strCDSID,";
								strCMD = strCMD + "IE,";
								strCMD = strCMD + "GetKB(inputData) + \",\"";
								strCMD = strCMD + "inputData.replace(\",\", \"__\"))";
									textPrinterHotFixes.println(strCMD);
							}
							else if(inputData.contains("Microsoft Excel"))
							{
								textPrinterHotFixes.println(strDateCreated + "," + strWS +"_" + strCDSID   +  ",Excel,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Office"))
							{
								textPrinterHotFixes.println(strDateCreated + "," + strWS +"_" + strCDSID +  ",Office,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
							}
							else
							{
								textPrinterHotFixes.println(strDateCreated + "," + strWS +"_" + strCDSID +  ",Other,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
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
					strCMD="";
					strCMD=strCMD + strDateCreated + ",";
					strCMD=strCMD + strWS + "_" + strCDSID + ",";
					strCMD=strCMD + strWS + ",";
					strCMD=strCMD + strCDSID + ",";
					strCMD=strCMD + strCountry + ",";
					strCMD=strCMD + strUserGPO + ",";
					strCMD=strCMD + strHardDriveFreeSpace + ",";
					strCMD=strCMD + strModel + ",";
					strCMD=strCMD + strRam + ",";
					strCMD=strCMD + strMachineGPO + ",";
					strCMD=strCMD + strIP + ",";
					strCMD=strCMD + strEthernetMAC + ",";
					strCMD=strCMD + strOS + ",";
					strCMD=strCMD + strWindowsVersion  + ",";
					strCMD=strCMD + strGlobalClientVersion.replace(",", "__") + ",";
					strCMD=strCMD + strGlobalClientBuild + ",";
					strCMD=strCMD + System.getProperty("java.home") + ",";
					strCMD=strCMD + System.getProperty("java.library.path") + ",";
					strCMD=strCMD + System.getProperty("java.class.path") + ",";
					strCMD=strCMD + System.getProperty("java.ext.dirs") + ",";
					strCMD=strCMD + System.getProperty("java.version") + ",";
					strCMD=strCMD + System.getProperty("java.runtime.version") + ",";
//					strCMD=strCMD + System.getProperty("file.separator") + ",";
//					strCMD=strCMD + System.getProperty("path.separator") + ",";
//					strCMD=strCMD + System.getProperty("line.separator") + ",";
					strCMD=strCMD + System.getProperty("user.name") + ",";
					strCMD=strCMD + System.getProperty("user.home") + ",";
					strCMD=strCMD + System.getProperty("user.dir") + ",";
					strCMD=strCMD + System.getProperty("os.name") + ",";
					strCMD=strCMD + System.getProperty("os.version") + ",";
					strCMD=strCMD + System.getProperty("os.arch") + ",";
//					strCMD=strCMD + System.getProperty("user.name") + ",";
					strCMD=strCMD + Runtime.getRuntime().freeMemory() + ",";
					strCMD=strCMD + Runtime.getRuntime().totalMemory() + ",";
					strCMD=strCMD + Runtime.getRuntime().maxMemory() + ",";
					strCMD=strCMD + Runtime.getRuntime().availableProcessors();
					newTextPrinter.println(strCMD);
				}
				strSkip="F";
					newTextPrinter.close();
					TextPrinterPrograms.close();
					textPrinterHotFixes.close();
					try 
					{
						fwParsed.close();
						fwPrograms.close();
						fwHotFixes.close();
//						fwPK.close();
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
//		public static  void copyFile(File srcFile, File destFile) throws IOException 
//	    {
//	            InputStream oInStream = new FileInputStream(srcFile);
//	            OutputStream oOutStream = new FileOutputStream(destFile);
//
//	            // Transfer bytes from in to out
//	            byte[] oBytes = new byte[1024];
//	            int nLength;
//	            BufferedInputStream oBuffInputStream = 
//	                            new BufferedInputStream( oInStream );
//	            while ((nLength = oBuffInputStream.read(oBytes)) > 0) 
//	            {
//	                oOutStream.write(oBytes, 0, nLength);
//	            }
//	            oInStream.close();
//	            oOutStream.close();
//	    }
	}
		public static String SplitBySemicolon(String strInput)
		{
			String[] aryInput=strInput.split(":");
			String strOutput=aryInput[1];
			return strOutput;
		}
		public static String SplitByForwardSlash(String strInput)
		{
			String[] aryInput=strInput.split("\\");
			String strOutput=aryInput[1];
			return strOutput;
		}
}
