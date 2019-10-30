package src.joptions;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.eclipse.jetty.websocket.common.extensions.compress.CompressionMethod.Process;

//import shared.ObsoletePlus;

//import org.apache.commons.io.FileUtils;
//import org.apache.james.mime4j.field.structured.parser.ParseException;
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
////import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import com.google.common.io.Files;

public class AutomatedProcesses 
{
//	protected static String user_id = null;
////	External Applications
//	public static String strStartAlteryx="C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe";
//	public static String strStartQlikView="C:\\Program Files\\Alteryx\\bin\\QV.exe";
//	public static String strStartAccess="C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE";
//	public static String strStartProject="C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINPROJ.EXE";
//	public static String strStartWord="C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINWORD.EXE";
//	public static String strStartExcel="C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE /c start";
//	public static String strStartOutlook="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Microsoft Office 2016\\Outlook 2016.EXE";
//	public static String strStartHelpInfo="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\HelpInfo.EXE";
//	public static String strStartRegEdit="REGEDIT.EXE";
//	public static String strStartChrome="C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging";
//	public static String strStartIE="C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging ";
//
////	Paths
//	public static String strAlteryxRepository="C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\ALTERYX\\";

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

//	Paths
	public static String strAlteryxRepository="C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\ALTERYX\\";

	
	public static void main(String[] args) 
	{

			// convert xls data to CSV
			// pull BMC data
			// build knowledgebase of decisions made through process
			// pull Rally data
			// execute Alteryx
			// loop through new defects prompting for information
			// loop through cdsid as needed
			// loop through existing data for country data
			// append data as all data is found for each record
			// build alteryx wf to create xls for pivot table chart
			int StartEndCancel;
			StartEndCancel=StartEnd();
			if(StartEndCancel == 0)
			{
				RecordStartTime();
				OpenDailyCycleApps();
				OpenOraclePAR();
				OpenBMCconsole();
				CreateNewArchiveDirForRallyData();
//				OpenRallyToViewsInFEDEBOM();
				RenameRallyBaseFiles();
				RenameExports();
				RunAlteryxWorkFlow();
				RunAlteryxRally();
				RunCloseRallyGaps();
				ExecuteRemainingDefectActivities();
				ProcessFEDEdashboardProducts();
				CopyServerFiles();
				ProcessAnotherServerLogDate();
				DeDupServerLogData();
				RunD4S2Exe();
//				RunI6S2Exe();
				OpenAccuRev();
				PullAccuRevData();
				UpdateIncomingFilesThenRecodFileChanges();
				SaveLocalHelpInfo();
				NormalizeLocalHelpInfoData();
				OpenTimeTracking();
				CopySPLUNKFilesToDriveY();
//				OpenURLs();
				AllMultiThreadedTasksAreDone();
			}
			else if(StartEndCancel == 1)
			{
				EndOfDay();
			}
			else
			{
				System.out.println("Cancelled");
			}
		}
//		public static void OpenRallyAndExtract()
//		{
//			Integer intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//			String strMsg="";
//			strMsg=strMsg + "Clicking yes will open Rally and automatically extract data:";
//			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Open Rally?",intDialogButton);
//			if(intDialogButton == 0)
//			{
//				Properties prop = loadProperties();
//				WebDriver driver;
//				File jarPath=new File(AutomatedProcesses.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//			    String seleniumDriverPath=jarPath.getParentFile().getAbsolutePath()+"\\chromedriver.exe";
//			    String driverPath = seleniumDriverPath.replace("%20", " ");
//				System.setProperty("webdriver.chrome.driver",driverPath);
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--disable-extensions");
//				driver = new ChromeDriver(options);
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				driver.get("https://rally1.rallydev.com/#/51575742627ud/defects?tpsSI=0&tpsV=sq%3A293263692428");
//				System.out.println(driver.getTitle());
//				System.out.println(driver.getCurrentUrl());
//				System.out.println(driver.getPageSource());
//				System.out.println(driver.getWindowHandle());
//				driver.findElement(By.xpath("//span[contains(text(),'Active Directory')]")).click();
//				Thread thread = new Thread();
//				try 
//				{
//					thread.sleep(10000);
//				} 
//				catch (InterruptedException e1) 
//				{
//					e1.printStackTrace();
//				}
//			}
//		}
		public static void BuildBatToCopyRallyExportsToDriveY()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Build and execute the bat file to archive Rally Exports?",intDialogButton);
			if(intDialogButton == 0)
			{
				String strCMD=null;
				DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
				String strScannedToday=GetStringTodayYYYYMMDD1();
				File sourceDir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\");
				File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_RALLY_EXTRACTS\\" + strScannedToday);
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
				if(sourceDir.isDirectory())
				{
					BufferedWriter newTextBuffer = new BufferedWriter(batFile);
					PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
					File[] listFiles = sourceDir.listFiles();
					for(File file : listFiles)
					{
						strCMD="copy /Y \"";
						System.out.println(strCMD);
						strCMD = strCMD + sourceDir;
						System.out.println(strCMD);
						strCMD = strCMD + "\\";
						System.out.println(strCMD);
						strCMD = strCMD + file.getName();
						System.out.println(strCMD);
		//				strCMD = strCMD + "\"";
		//				System.out.println(strCMD);
						strCMD = strCMD + "\", \"";
						System.out.println(strCMD);
						strCMD = strCMD + targetDir;
						System.out.println(strCMD);
						strCMD = strCMD + "\\\"";
						System.out.println(strCMD);
						newTextPrinter.println(strCMD);
						strCMD="";
					}
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
		//			AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
				}
			}
		}

		public static void RunCloseRallyGaps()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Close Rally GAPS?",intDialogButton);
			if(intDialogButton == 0)
			{
		
				try 
				{
					String[] cmd01 = {strStartAccess,"C:\\PROJECTS\\DATA\\FEDEBOM\\MANUAL_PROGRAM_INPUTS\\CLOSE_RALLY_GAPS.accdb",""};
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec(cmd01);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static void CopyRallyFilesToDriveY()
		{
			java.lang.Process runProcess;
			String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "COPY_RALLY_EXTRACTS_TO_DRIVE_Y.yxmd"};
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.csv");
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			try 
			{
				runProcess = Runtime.getRuntime().exec(cmd03);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			WaitUntilThisFileIsWritable("C:\\PROJECTS\\EXECUTABLES\\Dynamic.csv");		
			RenameThisFile( "C:\\PROJECTS\\EXECUTABLES\\Dynamic.csv",  "C:\\PROJECTS\\EXECUTABLES\\Dynamic.BAT");
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.BAT");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
			
//			String strScannedToday=GetStringTodayYYYYMMDD1();
//			File sourceDir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\");
//			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_RALLY_EXTRACTS\\" + strScannedToday);
//			AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//			File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//			if(sourceDir.isDirectory())
//			{
//				File[] listFiles = sourceDir.listFiles();
//				for(File file : listFiles)
//				{
//					try 
//					{
//						FileWriter fw = new FileWriter(batFile,true);
//						BufferedWriter bw = new BufferedWriter(fw);
//						bw.write("\n copy /Y \"" + sourceDir + "\\" + file + "\", \"" + targetDir+"\"");
//						bw.close();
//						java.lang.Process runProcess;
//						runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//						AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//					} 
//					catch (IOException e) 
//					{
//						e.printStackTrace();
//					}
//				}
//			}
		}
		public static void RunAlteryxWorkFlow()
		{
			String strMsg="Clicking yes will run a bat file";
			strMsg=strMsg + "\n The bat file has the xml parameters to run the Analytical App";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Run the Alteryx Analytical App?",intDialogButton);
			if(intDialogButton == 0)
			{
				try 
				{
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunRallyDataProcessor.bat");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}		
		}
		public static void OpenOraclePAR() 
		{
			String strMsg="Begin the process for the User Metrics slide";
			strMsg=strMsg + "\n Clicking yes will open PAR";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Start the User Metrics Process?",intDialogButton);
			if(intDialogButton == 0)
			{
				try 
				{
					Runtime.getRuntime().exec(strStartChrome + " http://www.par.ford.com");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static void RunAlteryxRally()
		{
			String strMsg="Run Alteryx WF RALLY_EXPORT_PROCESSING";
			strMsg=strMsg + "\n The last step should have archived the properly named exports to the y drive";
			strMsg=strMsg + "\n Clicking yes will run the work flow";
			strMsg=strMsg + "\n  - Compare current day data to last snapshot";
			strMsg=strMsg + "\n  - Read through Rally Defects searching for Program Codes";
			strMsg=strMsg + "\n  - Create output files for metrics and daily activities";
			strMsg=strMsg + "\n Current Issue";
			strMsg=strMsg + "\n  - Java command is not launching the work flow";
			strMsg=strMsg + "\n  -- Changed to try to launch it like an application";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process Rally data?",intDialogButton);
			if(intDialogButton == 0)
			{
//				java.lang.Process
				RunAlteryxWorkFlow();
			}
		}
		public static String GetStringTodayYYYYMMDD1()
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date dateFile = new Date();
			return dateFormat.format(dateFile);
		}

		public static void RunD4S2Exe()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Run D4S2?",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					java.lang.Process runProcess;
					String[] cmd01 = {"C:\\PROJECTS\\EXECUTABLES\\D4_S2_FEDEBOM.exe",""};
					runProcess=Runtime.getRuntime().exec(cmd01);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void RunI6S2Exe()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Run I6S2?",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					java.lang.Process runProcess;
					String[] cmd01 = {"C:\\PROJECTS\\EXECUTABLES\\Integration_FEDEBOM.exe",""};
					runProcess = Runtime.getRuntime().exec(cmd01);
					String[] cmd02 = {"C:\\PROJECTS\\EXECUTABLES\\D4_S2_FEDEBOM.exe",""};
					runProcess = Runtime.getRuntime().exec(cmd02);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void ExecuteRemainingDefectActivities()
		{
			String strMsg="Remaining Defect Support Activities";
			strMsg=strMsg + "\n Find all new Rally changes where the Defect closed date is no longer blank";
			strMsg=strMsg + "\n Mark status as resolved for each closed defect";
			strMsg=strMsg + "\n Check for Rejected Defects and ensure new Incidents have been created";
			strMsg=strMsg + "\n Run Alteryx ETL_ACCESS_TO_QVX.yxmd";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process BMC and Rally data",intDialogButton);
			if(intDialogButton == 0)
			{
				java.lang.Process runProcess;
				String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "ETL_ACCESS_TO_QVX.yxmd"};
				try 
				{
					Runtime.getRuntime().exec(cmd03);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}		
		}
		public static void OpenBMCconsole()
		{
			String strMSG = "Clicking Yes open the IT Connect Mid-Tier";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMSG,"Open the Incident Console?",intDialogButton);
			if(intDialogButton == 0)
			{
				try 
				{
					Runtime.getRuntime().exec(strStartChrome + " https://www.itsmschange.ford.com/arsys/forms/prodaruser.ford.com/SHR:LandingConsole/Default+Administrator+View/?cacheid=1ee142e");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}		
		}
		public static void ProcessBmcAndRallyExportData()
		{
			String strMSG = "Before Clicking Yes";
			strMSG = strMSG + "\n  - Open the C:\\PROJECTS\\DATA\\FEDEBOM\\METRICS\\BMC_AND_RALLY_METRICS_additions.csv";
			strMSG = strMSG + "\n  - Open the C:\\PROJECTS\\DATA\\FEDEBOM\\METRICS\\METRICS\\BMC_AND_RALLY_METRICS.xlsx";
			strMSG = strMSG + "\n  - add the new additions";
			strMSG = strMSG + "\n Clicking Yes will Open CLOSE RALLY GAPS DB";
			strMSG = strMSG + "\n  - Run BAS_PROCESS_RALLY_GAP_CLOSING.ProcessNewData";
			strMSG = strMSG + "\n  - review the remainder of the new additions";
			strMSG = strMSG + "\n  - if any new addition metrics match currently open defect then notify user of change";
			strMSG = strMSG + "\n  - then search the unchecked new defects for programs in Rally attachments to add to Rally Description";
			strMSG = strMSG + "\n  - then search all defect attachments for key fields";
			strMSG = strMSG + "\n  - then add the customer cdsid";
			strMSG = strMSG + "\n  - if only the Incident exists, then add the customer cdsid to the local db";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMSG,"Process BMC and Rally data",intDialogButton);
			if(intDialogButton == 0)
			{
				RunRallyChangesDB();
			}		
		}
		public static void UpdateIncomingFilesThenRecodFileChanges()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","After updating files in AccuRev click yes",intDialogButton);
			if(intDialogButton == 0)
			{
				java.lang.Process runProcess;
				String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "BOMinFEDE_v1.0_Collab_DEV_FILE_LIST_FULLPATHS.yxmd"};
				try 
				{
					DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\JAVA_ANALYZER\\AccuRev\\AccuRevIncomingFiles\\AccuRevIncomingProcessingDone.csv");
					runProcess = Runtime.getRuntime().exec(cmd03);
//					WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\FEDEBOM\\AccuRev\\AccuRevIncomingFiles\\AccuRevIncomingProcessingDone.csv");
					String[] cmd01 = {strStartAlteryx, strAlteryxRepository + "ACCUREV_INCOMING_FILES.yxmd"};
					runProcess = Runtime.getRuntime().exec(cmd01);
					String[] cmd02 = {strStartAlteryx, strAlteryxRepository + "ACCUREV_DIR_AFTER_UPDATING.yxmd"};
					runProcess = Runtime.getRuntime().exec(cmd02);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		public static void PullAccuRevData()
		{
//			add prompt
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			String strMsg="After AccuRev opens";
			strMsg=strMsg + "\n AccuRev Interface shows files";
			strMsg=strMsg+"\n Click yes to run AccuRev bat file to gather data from AccuRev";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Gather AccuRev Data?",intDialogButton);
			if(intDialogButton == 0)
			{
				try 
				{
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\PullAccuRevData.bat");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}		
		}
		public static void OpenAccuRev()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Open AccuRev?",intDialogButton);
			if(intDialogButton == 0)
			{
				try 
				{
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunAccuRev.bat");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			}
		public static void DeDupServerLogData()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","De dup the Server Log data?",intDialogButton);
			if(intDialogButton == 0)
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
		public static void CopyServerFiles()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Copy the Server Files?",intDialogButton);
			if(intDialogButton == 0)
			{
				AutomatedProcesses.DeleteThisFile ("C:\\PROJECTS\\DATA\\FEDEBOM\\REFRESH_FEDEBOM_SERVER_LOGS_IS_DONE.TXT");
				try 
				{
					String[] cmd01 = {strStartAccess,"C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\LOG_ANALYZER\\LOGS\\REFRESH_FEDEBOM_SERVER_LOGS.accdb",""};
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec(cmd01);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static void RunRallyChangesDB()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process Rally Changes",intDialogButton);
			if(intDialogButton == 0)
			{
		
				try 
				{
					String[] cmd01 = {strStartAccess,"C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_CHANGES.accdb",""};
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec(cmd01);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static void CreateNewArchiveDirForRallyData()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "Clicking yes will","Create the new dir for the Rally data and refresh the local Rally Archive",intDialogButton);
			if(intDialogButton == 0)
			{
		
				String strScannedToday=GetStringTodayYYYYMMDD1();
				
				File fileDir = new File("Y:\\ARCHIVES\\FEDEBOM_RALLY_EXTRACTS\\" + strScannedToday);
				fileDir.mkdir();
				String[] cmd01 = {"C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RenameRallyBaseFiles.bat",""};
				java.lang.Process runProcess;
				try 
				{
					runProcess = Runtime.getRuntime().exec(cmd01);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static String GetStringTodayYYYYMMDD()
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date dateFile = new Date();
			return dateFormat.format(dateFile);
		}
		public static void OpenTimeTracking()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Open DORF and Epitec",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					Runtime.getRuntime().exec(strStartIE + " https://www.dorf.ford.com/");
					Runtime.getRuntime().exec(strStartChrome + "  https://epiauth.azurewebsites.net/Account/Login?ReturnUrl=https%3a%2f%2fportal.epitec.com%2f&ApplicationKey=baf3e385-9aed-4822-9b6e-20ffcfdd9186");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void SaveLocalHelpInfo()
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date dateFile = new Date();
			String strScanned=dateFormat.format(dateFile);

			String fileSource="C:\\Users\\rrose66\\Desktop\\HelpInfo-WGC1AA3CQJ3M2.txt";
			String fileDestination="K:\\TRENDING\\" +strScanned+ "_HelpInfo-WGC1AA3CQJ3M2.txt";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			String strMsg="Before Clicking Yes";
			strMsg=strMsg + "\n Save the Local HelpInfo file";
			strMsg=strMsg + "\n Export the registry";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Click Yes to Save the Local HelpInfo file to the SharePoint on Y drive",intDialogButton);
			if(intDialogButton == 0)
			{
				AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
				System.getProperties();
				System.out.println("Java Home: "+ System.getProperty("java.home"));
				System.out.println("Java library path: "+ System.getProperty("java.library.path"));
				System.out.println("Java class path: "+ System.getProperty("java.class.path"));
				System.out.println("Java ext dir: "+ System.getProperty("java.ext.dirs"));
				System.out.println("Java version: "+ System.getProperty("java.version"));
				System.out.println("Java runtime version: "+ System.getProperty("java.runtime.version"));
				System.out.println("Java file separator: "+ System.getProperty("file.separator"));
				System.out.println("Java Path Separator: "+ System.getProperty("path.separator"));
				System.out.println("Java Line Separator: "+ System.getProperty("line.separator"));
				System.out.println("Java User Name: "+ System.getProperty("user.name"));
				System.out.println("Java User Home: "+ System.getProperty("user.home"));
				System.out.println("Java User Dir: "+ System.getProperty("user.dir"));
				System.out.println("Java OS Name: "+ System.getProperty("os.name"));
				System.out.println("Java OS Version: "+ System.getProperty("os.version"));
				System.out.println("Java OS Arch: "+ System.getProperty("os.arch"));
				System.out.println(" Free Memory: " + Runtime.getRuntime().freeMemory());
				System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory());
				System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory());
				System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
				File fileRoot = new File("/");
				System.out.println("Free Space: " + fileRoot.getFreeSpace());
			}
		}
		public static void NormalizeLocalHelpInfoData()
		{

			String strMsg="";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "Clicking Yes will run";
			strMsg=strMsg + "\n   -Normalize each file individually that is identified as a trend file";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process all Help Info Trend Files",intDialogButton);
			if(intDialogButton == 0)
			{
				File fileHIP = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PARSED.TXT");
				File fileHIPI = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT");
				File fileHIHF = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HOT_FIXES.TXT");
				File fileHIPK = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PK");
				fileHIP.delete();
				fileHIPI.delete();
				fileHIHF.delete();
				fileHIPK.delete();

				FileWriter newFile = null;
				FileWriter filePrograms=null;
				FileWriter fileHotFixes=null;
				try 
				{
					newFile = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PARSED.TXT",true);
					filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
					fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
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
				
				File dir = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\SOURCE_FILES\\TRENDING\\");
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
		public static void LoopThroughNewDefects()
		{
			String strNow=null;
			String[] aryRecord=null;
			String[] aryCDSIDrecord=null;
			String strMsg="";
			String strEnvironment=null;
			String strSeverity=null;
			String strSubmittedBy= null;
			String strCustomer=null;
			String strCreationDate=null;
			String strCDSIDLookup=null;
			String strCDSID=null;
			String strProgramFound=null;
			String strSalesForceID=null;
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "This process will loop through each new defect prompting for the information needed to bridge the gaps";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"This is the next new Defect",intDialogButton);
			if(intDialogButton == 0)
			{

				try
				{
					File rstLog = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\METRICS\\BMC_AND_RALLY_METRICS_additions.csv");
					Scanner scLog = new Scanner(rstLog);
					while (scLog.hasNext())
					{
						strNow=scLog.next();
						aryRecord=strNow.split(",");
						System.out.println(strNow);
						if(aryRecord[3].equals("RALLY_DEFECT_NEW"))
						{
		//					System.out.print(aryRecord[3]);
		//					System.out.print(aryRecord[4]);
							System.out.print(aryRecord[5]);
							StringSelection selection = new StringSelection(aryRecord[5]);
							java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(selection, selection);
							strMsg= "The current Defect is: " + aryRecord[5] + " Please open Rally and copy the Environment here";
							strEnvironment = JOptionPane.showInputDialog(strMsg);
							if(strEnvironment == null)
							{
								System.out.println("Cancelled");
		//						strNow=scLog.forEachRemaining(action);
							}
							else
							{
								System.out.println("Defect: " + aryRecord[5] + " Environment: " + strEnvironment);
								strSeverity = JOptionPane.showInputDialog("Please paste the Severity here");
								strSubmittedBy=JOptionPane.showInputDialog("Please paste the CDSID of the Submitted by here");
								strCreationDate=JOptionPane.showInputDialog("Please paste the creation date here");
								strCustomer=JOptionPane.showInputDialog("Please paste the CDSID of the customer here");
								strSalesForceID=JOptionPane.showInputDialog("Please paste the SalesForceID here");
								strProgramFound=JOptionPane.showInputDialog("Were any programs found?");
								
								FileWriter newFile = null;
								BufferedWriter newTextBuffer = null;
								PrintWriter newTextPrinter = null;
								try
								{
									newFile = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\MANUAL_PROGRAM_INPUTS\\BMC_TO_RALLY_GAPS.txt",true);
									newTextBuffer = new BufferedWriter(newFile);
									newTextPrinter = new PrintWriter(newTextBuffer);
									newTextPrinter.println(aryRecord[5]+","+strEnvironment +","+strSeverity+","+strSubmittedBy+","+strCreationDate+","+strSalesForceID+","+strCustomer+","+strCreationDate);
									newTextPrinter.close();
								}
								catch (IOException allExceptions)
								{
									allExceptions.printStackTrace();
								}
								if(strProgramFound=="y")
								{
									FileWriter newProgramFile = null;
									BufferedWriter newProgramTextBuffer = null;
									PrintWriter newProgramTextPrinter = null;
									try
									{
										newProgramFile = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\MANUAL_PROGRAM_INPUTS\\MANUAL_PROGRAM_INPUTS\\PROGRAM_MAPPING.txt",true);
										newProgramTextBuffer = new BufferedWriter(newProgramFile);
										newProgramTextPrinter = new PrintWriter(newProgramTextBuffer);
										newProgramTextPrinter.println(strSalesForceID+",,,,,"+aryRecord[5]);
										newProgramTextPrinter.close();
									}
									catch (IOException allExceptions)
									{
										allExceptions.printStackTrace();
									}
								}
								else
								{
									FileWriter newNoProgramFile = null;
									BufferedWriter newNoProgramTextBuffer = null;
									PrintWriter newNoProgramTextPrinter = null;
									try
									{
										newNoProgramFile = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\MANUAL_PROGRAM_INPUTS\\NO_PROGRAMS_FOUND.txt",true);
										newNoProgramTextBuffer = new BufferedWriter(newNoProgramFile);
										newNoProgramTextPrinter = new PrintWriter(newNoProgramTextBuffer);
										newNoProgramTextPrinter.println(strSalesForceID+",,"+aryRecord[5]);
										newNoProgramTextPrinter.close();
									}
									catch (IOException allExceptions)
									{
										allExceptions.printStackTrace();
									}
									
								}
//								loop through cdsid as needed
//								try
//								{
//									File rstCDSIDs = new File("C:\\PROJECTS\\DATA\\ITIL\\MANUAL_PROGRAM_INPUTS\\CDSID_LOOKUP_DATA.txt");
//									Scanner scCDSIDs = new Scanner(rstCDSIDs);
//									while (scCDSIDs.hasNext())
//									{
//										strCDSIDLookup=scCDSIDs.next();
//										aryCDSIDrecord=strCDSIDLookup.split(",");
////										System.out.println(aryCDSIDrecord[3]);
//										if(aryCDSIDrecord.length < 4)
//										{
//											
//										}
//										else
//										{
//											
//											if(aryCDSIDrecord[4].matches(strSubmittedBy))
//											{
//												strCDSID=aryCDSIDrecord[0];
//											}
//											else
//											{
//												System.out.println("lookup CDSID and rerun");
//											}
//										}
//									}
//								}
//								catch (IOException allExceptions)
//								{
//									allExceptions.printStackTrace();
//								}
							}
						}
					}
				}
				catch (IOException allExceptions)
				{
					allExceptions.printStackTrace();
				}
			}
		}

		public static int StartEnd() 
		{
			String strMsg=null;
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg="";
			strMsg=strMsg + "Manual Action Items";
			strMsg=strMsg + "\n   -Is this the begin time?";
			strMsg=strMsg + "\n   -If this is the end time";
			strMsg=strMsg + "\nClicking yes will:";
			strMsg=strMsg + "\n   -Record the current time in the started log";
			strMsg=strMsg + "\n   -Continue with the remaining check lists";
			strMsg=strMsg + "\nClicking no will";
			strMsg=strMsg + "\n   -record the time leaving office ";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Record start or end time.",intDialogButton);
			return intDialogButton;
		}
		public static void ReviewSoftwareUpdates()
		{
			String strMsg=null;
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg="";
			strMsg=strMsg + "Manual Items:";
			strMsg=strMsg + "\n   -Open Software Center";
			strMsg=strMsg + "\n   -Review Updates";
			strMsg=strMsg + "\n   -If any exist";
			strMsg=strMsg + "\n      --Search for relevant pushes";
			strMsg=strMsg + "\n      --Run a baseline test";
			strMsg=strMsg + "\n      --Pull the hot fix";
			strMsg=strMsg + "\n      --Retest";
			strMsg=strMsg + "\n      --If all tests pass, stop here";
			strMsg=strMsg + "\n      --If any test fails, try to get another box tested";
			strMsg=strMsg + "\nButtons do nothing";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Execute the new Hot Fixes Process",intDialogButton);
			if(intDialogButton == 0)
			{
				try 
				{
					Runtime.getRuntime().exec(strStartIE + " https://www.eassets.ford.com/eassetsWeb/sms/admin/fordselfservicetool/listofAppsAction.do");
					Runtime.getRuntime().exec(strStartIE + " https://it2.spt.ford.com/sites/DWOneNote/Shared Documents/SoftwareCenter");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static void ValidateMonitoringForCMT()
		{
			String strMsg="";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "Results from the Automated Validations Include:";
			strMsg=strMsg + "\nManual Action Items";
			strMsg=strMsg + "\nClicking Yes will run";
			strMsg=strMsg + "\n   -Open the AVBOM2 document for the next task";
			strMsg=strMsg + "\n   -Open the AVBOM2 Dashboard";
			strMsg=strMsg + "\n   -Open the IBM Process Portal";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Going to open web sites",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					Runtime.getRuntime().exec(strStartIE + " https://it1.spt.ford.com/sites/ITMS19335/AVBOM2%20Support%20Documents/Forms/AllItems.aspx?RootFolder=%2Fsites%2FITMS19335%2FAVBOM2%20Support%20Documents%2FWERS%20Refresh%20KT%20documents&FolderCTID=0x0120005256534BDEA6AE4591693C0E5F142A47&View=%7B729DFB74%2D4973%2D4D6E%2D9BC4%2D48F3E4577D21%7D");
					Runtime.getRuntime().exec(strStartIE + " https://www.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
					Runtime.getRuntime().exec(strStartIE + " https://www.bpm.ford.com/ProcessPortal/jsp/index.jsp#list%20%20%20");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void NormalizeAllHelpInfoFiles()
		{
			String strMsg="";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "Clicking Yes will run";
			strMsg=strMsg + "\n   -Normalize each file individually";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process all Help Info Files",intDialogButton);
			if(intDialogButton == 0)
			{
				File fileHIP = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT");
				File fileHIPI = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PROGRAMS_INSTALLED.TXT");
				File fileHIHF = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_HOT_FIXES.TXT");
				File fileHIPK = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PK");
				fileHIP.delete();
				fileHIPI.delete();
				fileHIHF.delete();
				fileHIPK.delete();

				FileWriter newFile = null;
				FileWriter filePrograms=null;
				FileWriter fileHotFixes=null;
				try 
				{
					newFile = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT",true);
					filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PROGRAMS_INSTALLED.TXT",true);
					fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_HOT_FIXES.TXT",true);
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
				textPrinterHotFixes.println("WS_CDSID,APP,KB,HOT_FIX");
				
				newTextPrinter.close();
				TextPrinterPrograms.close();
				textPrinterHotFixes.close();
				
				File dir = new File("K:\\");
				if(dir.isDirectory())
				{
					File[] listFiles = dir.listFiles();
					for(File file : listFiles)
					{
						if(file.getName().contains(".txt"))
						{
							NormalizeOneHelpInfo(file,"Current");
						}
					}
				}
		    }
		}
		public static void ProcessHelpInfoFiles()
		{
			String strMsg="";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "Results from the Automated Validations Include:";
			strMsg=strMsg + "\nManual Action Items";
			strMsg=strMsg + "\n   -Save the HelpInfo file";
			strMsg=strMsg + "\n   -Open Registry and export";
			strMsg=strMsg + "\n   -Process Email";
			strMsg=strMsg + "\n   -Follow-up on Tickets";
			strMsg=strMsg + "\nClicking Yes will run";
			strMsg=strMsg + "\n   -Process the HelpInfo report saved locally if one was saved";
			strMsg=strMsg + "\n      -Automatically rename and move the HelpInfo file to the Tracking dir";
			strMsg=strMsg + "\n   -COMBINE_HELP_INFO_FILES.BAT";
			strMsg=strMsg + "\n      -Move the HelpInfo files from SharePoint User Feedback";
			strMsg=strMsg + "\n      -Delete all old supporting files";
			strMsg=strMsg + "\n      -Create Accum Text file of HelpInfo Information";
			strMsg=strMsg + "\n   -Parse Helpinfo data via Java";
			strMsg=strMsg + "\n   -Move files from User Feedback to HelpInfo";
			strMsg=strMsg + "\n   -wait until process is done";
			strMsg=strMsg + "\n   -HELP_INFO_PROCESSOR.yxmd";
			strMsg=strMsg + "\n   -Open the Help Info Analyzer in QlikView";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Gather Local Help Info and Process all feedback",intDialogButton);
			if(intDialogButton == 0)
			{
				DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\EMAIL_HELP_INFO_EXTRACTOR_DONE.TXT");
				File input = new File("C:\\Users\\rrose66\\Desktop\\HelpInfo - WGC1AA3CQJ3M2.txt");
				if(input.exists())
				{
					String strCMD;
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
					Calendar yyyymmddToday = Calendar.getInstance();
					yyyymmddToday.add(Calendar.DATE, 0);;
					String strPartOfFileNameForToday=dateFormat.format(yyyymmddToday.getTime());
					input.renameTo(new File("K:\\TRENDING\\" + strPartOfFileNameForToday + "_" + input.getName()));
				}
				java.lang.Process runProcess;
				try
				{
					String[] cmd01 = {strStartAccess,"C:\\PROJECTS\\DATA\\HELP_INFO\\EMAIL_HELP_INFO_EXTRACTOR.accdb",""};
					runProcess = Runtime.getRuntime().exec(cmd01);
					WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\EMAIL_HELP_INFO_EXTRACTOR_DONE.TXT");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\HOT_FIXES.TXT");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\PROGRAMS_INSTALLED.TXT");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO.TXT");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_DATABASE_IS_DONE.XLSX");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\MOVE_STAGED_HELP_INFO_IS_DONE.TXT");
					DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_COMBINING_DONE.TXT");
					String[] cmd02 = {"C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\COMBINE_HELP_INFO_FILES.BAT",""};
					runProcess = Runtime.getRuntime().exec(cmd02);
					WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_COMBINING_DONE.TXT");
					File fileHelpInfo = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO.TXT");
					if(fileHelpInfo.exists())
					{
						NormalizeHelpInfo();
						DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT");
						String[] cmd14 = {strStartAccess,"C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO.accdb"};
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT");
						runProcess = Runtime.getRuntime().exec(cmd14);
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_DATABASE_IS_DONE.XLSX");
						String[] cmd03 = {"C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\MOVE_STAGED_HELP_INFO_FILES.BAT",""};
						runProcess = Runtime.getRuntime().exec(cmd03);
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\MOVE_STAGED_HELP_INFO_IS_DONE.TXT");
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\HOT_FIXES.TXT");
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\PROGRAMS_INSTALLED.TXT");
						File dayBaseToDelete = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\DAY_BASE_DONE.csv");
						dayBaseToDelete.delete();
						String[] cmd13 = {strStartAlteryx, strAlteryxRepository + "DAY_BASE.yxmd"};
						runProcess = Runtime.getRuntime().exec(cmd13);
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\DAY_BASE_DONE.csv");
						String[] cmd04 = {strStartAlteryx, strAlteryxRepository + "HELP_INFO_PROCESSOR.yxmd"};
						runProcess = Runtime.getRuntime().exec(cmd04);
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO.qvx");
						WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_KB.xlsx");
					}
				}
				catch (IOException e) 
				{
				e.printStackTrace();
				}
			}
		}
		public static void RunIntegration()
		{
			String strMsg="";
			strMsg=strMsg + "\nManual Action Items";
			strMsg=strMsg + "\n   -AccuRev work:";
			strMsg=strMsg + "\n      --Open AccuRev and select the Incoming for Wizard source";
			strMsg=strMsg + "\nClicking Yes will";
			strMsg=strMsg + "\n    -Start I6 S2 FEDEBOM";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"This is the ITIL process for work time tracking.",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					java.lang.Process runProcess;
					String[] cmd02 = {strStartAlteryx, strAlteryxRepository + "METHOD_MAPPED_TO_ACCUREV.YXMD"};
					runProcess = Runtime.getRuntime().exec(cmd02);
					WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\TEST_CASES_IMPACTED_BY_CHANGES_SEEN_IN_ACCUREV.csv");
					String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "ACCUREV_WIP.yxmd"};
					runProcess = Runtime.getRuntime().exec(cmd03);
					String[] cmd05 = {"C:\\PROJECTS\\EXECUTABLES\\Integration_FEDEBOM.exe",""};
					runProcess = Runtime.getRuntime().exec(cmd05);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void RunI6S2()
		{
			String strMsg="";
			strMsg=strMsg + "\nClicking Yes will";
			strMsg=strMsg + "\n    -Start I6 S2 FEDEBOM";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"This is the ITIL process for work time tracking.",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					java.lang.Process runProcess;
					String[] cmd04 = {"C:\\PROJECTS\\EXECUTABLES\\I6_S2_FEDEBOM.exe",""};
					runProcess = Runtime.getRuntime().exec(cmd04);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void RunD4S2()
		{
			String strMsg="";
			strMsg=strMsg + "\nClicking Yes will";
			strMsg=strMsg + "\n    -Start I6 S2 FEDEBOM";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"This is the ITIL process for work time tracking.",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					java.lang.Process runProcess;
					String[] cmd06 = {"C:\\PROJECTS\\EXECUTABLES\\D4_S2_FEDEBOM.exe",""};
					runProcess = Runtime.getRuntime().exec(cmd06);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		public static void RallyWork()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			String strMsg="";
			strMsg=strMsg + "Results from the Automated Validations Include:";
			strMsg=strMsg + "\n   -WSAutomation environment has been created";
			strMsg=strMsg + "\n   -Server Down Messages have been processed";
			strMsg=strMsg + "\n   -the default scanned in all stagging tables is today";
			strMsg=strMsg + "\n   -AccuRev data has been gathered";
			strMsg=strMsg + "\n   -BMC tickets have been checked";
			strMsg=strMsg + "\nManual Action Items";
			strMsg=strMsg + "\n   -Outlook work:";
			strMsg=strMsg + "\n      --Delete WebMon messages by running the Daily Cleanup rule";
			strMsg=strMsg + "\n   -Rally work:";
			strMsg=strMsg + "\n      --Open the Rally Application and select the FEDEBOM view and download";
			strMsg=strMsg + "\nClicking Yes will run  STEP THROUGH ONLY";
			strMsg=strMsg + "\n   -RALLY_DATA_PROCESSOR.YXMD";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process Rally Data",intDialogButton);
			if(intDialogButton == 0)
			{
				DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_FEATURES_BASE.qvx");
				DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_STORIES_BASE.qvx");
				DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_TEST_CASES_BASE.qvx");
				DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_DEFECTS_BASE.qvx");
				RenameThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_FEATURES_ACCUM.qvx","C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_FEATURES_BASE.qvx");
				RenameThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_STORIES_ACCUM.qvx","C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_STORIES_BASE.qvx");
				RenameThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_TEST_CASES_ACCUM.qvx","C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_TEST_CASES_BASE.qvx");
				RenameThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_DEFECTS_ACCUM.qvx","C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\RALLY_DEFECTS_BASE.qvx");
				
				try
				{
					java.lang.Process runProcess;
					String[] cmd01 = {strStartAlteryx, strAlteryxRepository + "RALLY_DATA_PROCESSOR.YXMD"};
					runProcess = Runtime.getRuntime().exec(cmd01);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}	
		}
		public static void AllMultiThreadedTasksAreDone()
		{
			String strMsg=null;
			strMsg = "";
			strMsg=strMsg + "Done";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process is done.",intDialogButton);
		}
		public static void EndOfDay()
		{
			FileWriter newFile = null;
			try 
			{
//				java.lang.Process
				newFile = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\WORK_END_TIME.CSV",true);
				BufferedWriter newTextBuffer = null;
				PrintWriter newTextPrinter = null;
				SimpleDateFormat dateTimeToday = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
				Date dateToday = new Date();
				String strDateTimeNow = dateTimeToday.format(dateToday.getTime());
				newTextBuffer = new BufferedWriter(newFile);
				newTextPrinter = new PrintWriter(newTextBuffer);
				newTextPrinter.println(strDateTimeNow);
				newTextPrinter.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		public static void RecordStartTime()
		{
			SimpleDateFormat dateTimeToday = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
			Date dateToday = new Date();
			FileWriter newFile = null;
			BufferedWriter newTextBuffer = null;
			PrintWriter newTextPrinter = null;
			String strDateTimeNow = dateTimeToday.format(dateToday.getTime());
			String strLastDayEntry=null;
			try
			{
				newFile = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\WORK_BEGIN_TIME.CSV",true);
				newTextBuffer = new BufferedWriter(newFile);
				newTextPrinter = new PrintWriter(newTextBuffer);
				newTextPrinter.println(strDateTimeNow);
				newTextPrinter.close();
				strLastDayEntry = FindLastRow();
			}
			catch (IOException allExceptions)
			{
				allExceptions.printStackTrace();
			}
		}
		public static void ClassesAndMethods() 
			{
				String strPartOfFileNameForToday;
				DateFormat dateTimeToday = null;
				Date dateToday = new Date();
				Object strDateTimeNow = dateTimeToday.format(dateToday.getTime());
				DateFormat dateFormat = null;
				strPartOfFileNameForToday = dateFormat.format(dateToday.getTime());
				System.out.println(strDateTimeNow);
				String strTargetFile = "C:\\PROJECTS\\DATA\\FEDEBOM\\JAVA_DIR_LISTS\\javaDir.txt";
				File targetFile = new File(strTargetFile);
				String strClassesAndMethods="C:\\PROJECTS\\DATA\\FEDEBOM\\JAVA_ANALYZER\\classesAndMethods.txt";
				File classesAndMethods = new File(strClassesAndMethods);
				Integer intLengthOfLine;
				String strTargetSourceFile=null;
				String strSourceCodeLine=null;
				String strTCBOM=null;
				try
				{
					FileWriter fw = null;
					try 
					{
						fw = new FileWriter(strClassesAndMethods,true);
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw);
					Scanner inputStream = new Scanner(targetFile);
					while (inputStream.hasNext())
					{
						String data = inputStream.next();
						strTargetSourceFile=data;
						if (data.contains("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_v1.0_Collab_DEV"))
						{
							File sourceFile = new File(strTargetSourceFile);
							Scanner sourceInputStream = new Scanner(sourceFile);
							while (sourceInputStream.hasNext())
							{
								strSourceCodeLine=sourceInputStream.next();
								if(strSourceCodeLine.contains("class"))
								{
									out.println(data + "," + strSourceCodeLine);
									out.close();
								}
							}
							sourceInputStream.close();
						}
					}
					inputStream.close();
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
			new File("C:\\PROJECTS\\DATA\\FEDEBOM\\JAVA_DIR_LISTS\\javaDir.txt").renameTo(new File("C:\\PROJECTS\\DATA\\FEDEBOM\\JAVA_DIR_LISTS\\" + strPartOfFileNameForToday + "_javaDir.txt"));
			}
		public static String FindLastRow()
		{
			String strNow=null;
			try
			{
				File rstLog = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\FILES_INDICATING_END_OF_PROCESS\\DAY_BASE.TXT");
				Scanner scLog = new Scanner(rstLog);
				while (scLog.hasNext())
				{
					strNow=scLog.next();
				}
			}
			catch (IOException allExceptions)
			{
				allExceptions.printStackTrace();
			}

			return strNow;
			
		}
			
		public static void NormalizeHelpInfo()
		{
			String strWS=null;
			String[] aryWS=null;
			String strCDSID=null;
			String[] aryCDSID=null;
			String strDomain=null;
			String[] aryDomain=null;
			String strCountry=null;
			String[] aryCountry=null;
			String strUserGPO=null;
			String[] aryUserGPO=null;
			String[] aryHardDriveFreeSpace=null;
			String strHardDriveFreeSpace=null;
			String[] aryModel=null;
			String strModel=null;
			String[] aryRam=null;
			String strRam=null;
			String[] aryMachineGPO=null;
			String strMachineGPO=null;
			String[] aryIP=null;
			String strIP=null;
			String[] aryEthernetMAC=null;
			String strEthernetMAC=null;
			String[] aryOS=null;
			String strOS=null;
			String[] aryVersionOS=null;
			String[] aryWindowsVersion=null;
			String strWindowsVersion=null;
			String strEnterpriseVersion=null;
			String strVersionOS=null;
			String[] aryGlobalClientBuild=null;
			String strGlobalClientBuild=null;
			String[] aryGlobalClientVersion=null;
			String strGlobalClientVersion=null;
			String strInstalledProgramsFound="F";
			String strHotFixesFound="F";
			String strInternetExplorerVersion=null;
			
			File input = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\EOP\\New folder\\HELP_INFO.TXT");
			if(input.exists())
			{
				String inputData=null;
				String[] aryInput=null;
				FileWriter newFile = null;
				FileWriter filePrograms=null;
				FileWriter fileHotFixes=null;
				try 
				{
					newFile = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\EOP\\New folder\\HELP_INFO_PARSED.TXT",false);
					filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\EOP\\New folder\\PROGRAMS_INSTALLED.TXT",false);
					fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\EOP\\New folder\\HOT_FIXES.TXT",false);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				BufferedWriter newTextBuffer = new BufferedWriter(newFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
				newTextPrinter.println("WS,CDSID,COUNTRY,USER_GPO,HARD_DRIVE_FREE_SPACE,MODEL,RAM,MACHINE_GPO,IP,ETHERNET_MAC,OS,WINDOWS_VERSION,OS_VERSION,GLOBAL_CLIENT_BUILD");
				
				BufferedWriter textBufferPrograms = new BufferedWriter(filePrograms);
				PrintWriter TextPrinterPrograms = new PrintWriter(textBufferPrograms);
				TextPrinterPrograms.println("WS,CDSID,REFERENCE_PROGRAM,PROGRAM");
				
				BufferedWriter textBufferHotFixes = new BufferedWriter(fileHotFixes);
				PrintWriter textPrinterHotFixes = new PrintWriter(textBufferHotFixes);
				textPrinterHotFixes.println("WS,CDSID,REFERENCE_PROGRAM,KB,HOT_FIX");
				try
				{
					Scanner sc = new Scanner(input);
					sc.nextLine();
					while (sc.hasNextLine())
					{
						inputData=sc.nextLine();
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
							strCountry = aryDomain[1].substring(1, 4);
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
							strWindowsVersion=aryWindowsVersion[2];
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
						if(strInstalledProgramsFound == "T")
						{
							if(inputData.contains("Internet Explorer:"))
							{
								TextPrinterPrograms.println(strWS +"," + strCDSID + ",IE," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Excel"))
							{
								TextPrinterPrograms.println(strWS +"," + strCDSID + ",Excel," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Office"))
							{
								TextPrinterPrograms.println(strWS +"," + strCDSID + ",Office," + inputData.replace(",", "__"));
							}
							else
							{
								TextPrinterPrograms.println(strWS +"," + strCDSID + ",Other," + inputData.replace(",", "__"));						
							}
						}
						if(strHotFixesFound=="T")
						{
							if(inputData.contains("Internet Explorer:"))
							{
								textPrinterHotFixes.println(strWS +"," + strCDSID + ",IE,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Excel"))
							{
								textPrinterHotFixes.println(strWS +"," + strCDSID + ",Excel,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
							}
							else if(inputData.contains("Microsoft Office"))
							{
								textPrinterHotFixes.println(strWS +"," + strCDSID + ",Office,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
							}
							else
							{
								textPrinterHotFixes.println(strWS +"," + strCDSID + ",Other,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
							}
						}
						if(inputData.contains("Installed Programs"))
						{
							strInstalledProgramsFound="T";
						}
						if(inputData.contains("Installed HotFixes"))
						{
							strInstalledProgramsFound="F";
							strHotFixesFound="T";
						}
						newTextPrinter.println(strWS + "," + strCDSID + "," + strCountry + "," + strUserGPO + "," + strHardDriveFreeSpace + "," + strModel + "," + strRam + "," + strMachineGPO + "," + strIP + "," + strEthernetMAC + "," + strOS + "," + strWindowsVersion  + "," + strGlobalClientVersion.replace("\"", "") + "," + strGlobalClientBuild );
					}
					sc.close();
					newTextPrinter.close();
					TextPrinterPrograms.close();
					textPrinterHotFixes.close();
					try {
						newFile.close();
						filePrograms.close();
						fileHotFixes.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				catch(FileNotFoundException e)
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
		public static void ParseOneLargeTextFile() throws IOException
		{
			String strWS=null;
			String[] aryWS=null;
			String strCDSID=null;
			String[] aryCDSID=null;
			String strDomain=null;
			String[] aryDomain=null;
			String strCountry=null;
			String[] aryCountry=null;
			String strUserGPO=null;
			String[] aryUserGPO=null;
			String[] aryHardDriveFreeSpace=null;
			String strHardDriveFreeSpace=null;
			String[] aryModel=null;
			String strModel=null;
			String[] aryRam=null;
			String strRam=null;
			String[] aryMachineGPO=null;
			String strMachineGPO=null;
			String[] aryIP=null;
			String strIP=null;
			String[] aryEthernetMAC=null;
			String strEthernetMAC=null;
			String[] aryOS=null;
			String strOS=null;
			String[] aryVersionOS=null;
			String[] aryWindowsVersion=null;
			String strWindowsVersion=null;
			String strEnterpriseVersion=null;
			String strVersionOS=null;
			String[] aryGlobalClientBuild=null;
			String strGlobalClientBuild=null;
			String[] aryGlobalClientVersion=null;
			String strGlobalClientVersion=null;
			String strInstalledProgramsFound="F";
			String strHotFixesFound="F";
			String strInternetExplorerVersion=null;
			String inputData=null;
			String[] aryInput=null;
			FileWriter newFile = null;
			FileWriter filePrograms=null;
			FileWriter fileHotFixes=null;
			try 
			{
				newFile = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_PARSED.TXT",false);
				filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\PROGRAMS_INSTALLED.TXT",false);
				fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HOT_FIXES.TXT",false);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(newFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println("WS,CDSID,COUNTRY,USER_GPO,HARD_DRIVE_FREE_SPACE,MODEL,RAM,MACHINE_GPO,IP,ETHERNET_MAC,OS,WINDOWS_VERSION,OS_VERSION,GLOBAL_CLIENT_BUILD");
			
			BufferedWriter textBufferPrograms = new BufferedWriter(filePrograms);
			PrintWriter TextPrinterPrograms = new PrintWriter(textBufferPrograms);
			TextPrinterPrograms.println("WS,CDSID,REFERENCE_PROGRAM,PROGRAM");
			
			BufferedWriter textBufferHotFixes = new BufferedWriter(fileHotFixes);
			PrintWriter textPrinterHotFixes = new PrintWriter(textBufferHotFixes);
			textPrinterHotFixes.println("WS,CDSID,REFERENCE_PROGRAM,KB,HOT_FIX");
			String cur="";
		
			InputStreamReader isr;
			isr = new InputStreamReader(new FileInputStream("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO.TXT"),"UTF-8");
			BufferedReader input = new BufferedReader(isr);
			while((cur = input.readLine()) !=null)
			{
				inputData = input.readLine();
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
					strCountry = aryDomain[1].substring(1, 4);
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
					strWindowsVersion=aryWindowsVersion[2];
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
				if(strInstalledProgramsFound == "T")
				{
					if(inputData.contains("Internet Explorer:"))
					{
						TextPrinterPrograms.println(strWS +"," + strCDSID + ",IE," + inputData.replace(",", "__"));
					}
					else if(inputData.contains("Microsoft Excel"))
					{
						TextPrinterPrograms.println(strWS +"," + strCDSID + ",Excel," + inputData.replace(",", "__"));
					}
					else if(inputData.contains("Microsoft Office"))
					{
						TextPrinterPrograms.println(strWS +"," + strCDSID + ",Office," + inputData.replace(",", "__"));
					}
					else
					{
						TextPrinterPrograms.println(strWS +"," + strCDSID + ",Other," + inputData.replace(",", "__"));						
					}
				}
				if(inputData.contains("Installed HotFixes"))
				{
					strInstalledProgramsFound="F";
					strHotFixesFound="T";
				}
				if(strHotFixesFound=="T")
				{
					if(inputData.contains("Internet Explorer:"))
					{
						textPrinterHotFixes.println(strWS +"," + strCDSID + ",IE,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
					}
					else if(inputData.contains("Microsoft Excel"))
					{
						textPrinterHotFixes.println(strWS +"," + strCDSID + ",Excel,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
					}
					else if(inputData.contains("Microsoft Office"))
					{
						textPrinterHotFixes.println(strWS +"," + strCDSID + ",Office,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
					}
					else
					{
						textPrinterHotFixes.println(strWS +"," + strCDSID + ",Other,"   + GetKB(inputData) + "," + inputData.replace(",", "__"));
					}
				}
				if(inputData.contains("Ford Motor Company's Help Information Tool"))
				{
					newTextPrinter.println(strWS + "," + strCDSID + "," + strCountry + "," + strUserGPO + "," + strHardDriveFreeSpace + "," + strModel + "," + strRam + "," + strMachineGPO + "," + strIP + "," + strEthernetMAC + "," + strOS + "," + strWindowsVersion  + "," + strGlobalClientVersion.replace("\"", "") + "," + strGlobalClientBuild );
					strHotFixesFound="F";
					strWS=null;
					aryWS=null;
					strCDSID=null;
					aryCDSID=null;
					strDomain=null;
					aryDomain=null;
					strCountry=null;
					aryCountry=null;
					strUserGPO=null;
					aryUserGPO=null;
					aryHardDriveFreeSpace=null;
					strHardDriveFreeSpace=null;
					aryModel=null;
					strModel=null;
					aryRam=null;
					strRam=null;
					aryMachineGPO=null;
					strMachineGPO=null;
					aryIP=null;
					strIP=null;
					aryEthernetMAC=null;
					strEthernetMAC=null;
					aryOS=null;
					strOS=null;
					aryVersionOS=null;
					aryWindowsVersion=null;
					strWindowsVersion=null;
					strEnterpriseVersion=null;
					strVersionOS=null;
					aryGlobalClientBuild=null;
					strGlobalClientBuild=null;
					aryGlobalClientVersion=null;
					strGlobalClientVersion=null;
					strInstalledProgramsFound="F";
					strHotFixesFound="F";
				}
			}
				newTextBuffer.flush();
				newTextBuffer.close();
				newTextPrinter.flush();
				newTextPrinter.close();
				TextPrinterPrograms.flush();
				TextPrinterPrograms.close();
				textPrinterHotFixes.flush();
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
			}
//		public static List<Date> getDaysBetweenDates(String strStartDate) throws ParseException
//		{
//			File fileToDelete = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\BASE_DATES.txt");
//			fileToDelete.delete();
//			FileWriter newFile = null;
//			try 
//			{
//				newFile = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\BASE_DATES.txt",false);
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//			BufferedWriter newTextBuffer = null;
//			PrintWriter newTextPrinter = null;
//			newTextBuffer = new BufferedWriter(newFile);
//			newTextPrinter = new PrintWriter(newTextBuffer);
//			newTextPrinter.println("DT_BASE,STR_BASE");
	//	
//			List<Date> dates = new ArrayList<Date>();
//			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
//			SimpleDateFormat sdftxt = new SimpleDateFormat("yyyymmdd");
//		    Calendar calendar = new GregorianCalendar();
//		    Calendar calendarStart = Calendar.getInstance();
//		    try {
//				calendarStart.setTime(sdf.parse(strStartDate));
//			} catch (java.text.ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    String strResult=null;
//		    String result = null;
//		    Date dateEndDate=new Date();
//		    
//		    while (calendarStart.getTime().before(dateEndDate))
//		    {
//		    	calendarStart.add(Calendar.DATE, 1);
//		        result=sdf.format(calendarStart.getTime());
//		        strResult=sdftxt.format(calendarStart.getTime());
//				newTextPrinter.println(result + "," + strResult);
//		    }
//		    newTextPrinter.close();
//		    return dates;
//		}
		public static void DeleteThisFile(String strFullPath)
		{
			Boolean blnReadyToContinue=false;
			File fileToDelete = new File(strFullPath);
			if(fileToDelete.exists())
			{
				fileToDelete.delete();
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
						newFile = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PARSED.TXT",true);
						filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PROGRAMS_INSTALLED.TXT",true);
						fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_HOT_FIXES.TXT",true);
						filePK = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_PK",true);
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
						newFile = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PARSED.TXT",true);
						filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
						fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
						filePK = new FileWriter("C:\\PROJECTS\\DATA\\HELP_INFO\\HELP_INFO_TREND_PK",true);
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
		public static void MoveLocalHelpInfoFile()
		{
			String strMsg="";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "\nClicking Yes will run";
			strMsg=strMsg + "\n   -Process the HelpInfo report saved locally if one was saved";
			strMsg=strMsg + "\n      -Automatically rename and move the HelpInfo file to the Tracking dir";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Gather Local Help Info and Process all feedback",intDialogButton);
			if(intDialogButton == 0)
			{
				DeleteThisFile("C:\\PROJECTS\\DATA\\HELP_INFO\\EMAIL_HELP_INFO_EXTRACTOR_DONE.TXT");
				File input = new File("C:\\Users\\rrose66\\Desktop\\HelpInfo-WGC1AA3CQJ3M2.txt");
				if(input.exists())
				{
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
					Calendar yyyymmddToday = Calendar.getInstance();
					yyyymmddToday.add(Calendar.DATE, 0);;
					String strPartOfFileNameForToday=dateFormat.format(yyyymmddToday.getTime());
					input.renameTo(new File("K:\\TRENDING\\" + strPartOfFileNameForToday + "_" + input.getName()));
				}
			}
		}
		public static void OpenURLs()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "Click Yes to open all links","All URLs",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					Runtime.getRuntime().exec(strStartIE + "  https://it1.spt.ford.com/sites/ITMS19335/AVBOM2%20Support%20Documents/Forms/AllItems.aspx?RootFolder=%2Fsites%2FITMS19335%2FAVBOM2%20Support%20Documents%2FWERS%20Refresh%20KT%20documents&FolderCTID=0x0120005256534BDEA6AE4591693C0E5F142A47&View=%7B729DFB74%2D4973%2D4D6E%2D9BC4%2D48F3E4577D21%7D");
					Runtime.getRuntime().exec(strStartIE + "  https://www.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
					Runtime.getRuntime().exec(strStartIE + "  https://wwwqa.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
					Runtime.getRuntime().exec(strStartIE + "  https://www.bpm.ford.com/ProcessPortal/jsp/index.jsp#list%20%20%20");
					Runtime.getRuntime().exec(strStartIE + "  http://www.itsms.ford.com/arsys/forms/itsmsapp/SHR:LandingConsole/Default+Administrator+View/?cacheid=75bb0caa");
					Runtime.getRuntime().exec(strStartIE + "  http://www.request.ford.com/RequestCenter/myservices/orderrequisition.do?requisitionId=10316976&layout=");
					Runtime.getRuntime().exec(strStartIE + "  http://www.request.ford.com/RequestCenter/servicemanager/homepage.do?datatableID=ServiceMgrStaticViews");
					Runtime.getRuntime().exec(strStartIE + "  https://it1.spt.ford.com/sites/avbom2-wizard/_layouts/15/viewlsts.aspx?BaseType=0");
					Runtime.getRuntime().exec(strStartChrome + " https://rally1.rallydev.com/#/51575742627ud/workviews");
					Runtime.getRuntime().exec(strStartChrome + " https://github.ford.com/");
					Runtime.getRuntime().exec(strStartIE + "  https://it1.spt.ford.com/sites/PDAM/EarlyBOMMetricDashboard/AvailabilityCollection/DailyAvailability.aspx");
					Runtime.getRuntime().exec(strStartIE + "  https://citrix6p.ford.com/Citrix/XenApp/auth/login.aspx");
					Runtime.getRuntime().exec(strStartIE + "  https://www.dorf.ford.com/");
					Runtime.getRuntime().exec(strStartIE + " https://epiauth.azurewebsites.net/Account/Login?ReturnUrl=https%3a%2f%2fportal.epitec.com%2f&ApplicationKey=baf3e385-9aed-4822-9b6e-20ffcfdd9186");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
//		@SuppressWarnings("unused")
//		public static void OpenRallyToViewsInFEDEBOM()
//		{
//			Integer intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//			String strMsg="";
//			strMsg=strMsg + "Clicking yes will open Rally:";
////			strMsg=strMsg + "\n   -Pull the new HelpInfo files from email";
////			strMsg=strMsg + "\n   -Allow time to manually move the files";
////			strMsg=strMsg + "\nClicking No will skip";
//			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Open Rally",intDialogButton);
//			if(intDialogButton == 0)
//			{
////				Properties prop = loadProperties();
//				Properties prop = loadProperties();
//				WebDriver driver;
//				File jarPath=new File(AutomatedProcesses.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//			    String seleniumDriverPath=jarPath.getParentFile().getAbsolutePath()+"\\chromedriver.exe";
//			    String driverPath = seleniumDriverPath.replace("%20", " ");
//				System.setProperty("webdriver.chrome.driver",driverPath);
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--disable-extensions");
//				driver = new ChromeDriver(options);
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				driver.get("https://rally1.rallydev.com/#/51575742627ud/workviews");
//				System.out.println(driver.getTitle());
//				System.out.println(driver.getCurrentUrl());
//				System.out.println(driver.getPageSource());
//				System.out.println(driver.getWindowHandle());
//				driver.findElement(By.xpath("//span[contains(text(),'Active Directory')]")).click();
//				Thread thread = new Thread();
//				try 
//				{
//					thread.sleep(10000);
//				} 
//				catch (InterruptedException e1) 
//				{
//					e1.printStackTrace();
//				}
//			}
//		}
		public static void RenameThisFile(String strFileSource, String strFileDestination)
		{
			File fileSource = new File(strFileSource);
			File fileDestination = new File(strFileDestination);
			if(fileSource.exists())
			{
				fileSource.renameTo(fileDestination);
			}
		}
//		public static void OpenTheDailyReportExcelFiles()
//		{
//			File fileINC = new File("C:\\Users\\rrose66\\Downloads\\Global5fPDBOM5fIncident5fReport.xls");
//			File filePBI = new File("C:\\Users\\rrose66\\Downloads\\Global5fPDBOM5fProblem5fReport.xls");
//			File fileBreached = new File("C:\\Users\\rrose66\\Downloads\\PD AM Scheduled Copy of KPI Breached Report.xlsx");
//			File fileVBA = new File("C:\\PROJECTS\\GitHub\\DAILY_REPORT\\ADD_IN_CONVERTED.xlsm");
//			try 
//			{
//				Workbook wbINC = WorkbookFactory.create(fileINC);
//			} 
//			catch (EncryptedDocumentException e) 
//			{
//				e.printStackTrace();
//			} 
//			catch (InvalidFormatException e) 
//			{
//				e.printStackTrace();
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//			try 
//			{
//				Workbook wbPBI = WorkbookFactory.create(filePBI);
//			} 
//			catch (EncryptedDocumentException e) 
//			{
//				e.printStackTrace();
//			} 
//			catch (InvalidFormatException e) 
//			{
//				e.printStackTrace();
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//			try 
//			{
//				Workbook wbBRC = WorkbookFactory.create(fileBreached);
//			} 
//			catch (EncryptedDocumentException e) 
//			{
//				e.printStackTrace();
//			} 
//			catch (InvalidFormatException e) 
//			{
//				e.printStackTrace();
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//		}
		public static void NormalizeAllHelpInfoTrendFiles()
		{
			String strMsg="";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			strMsg=strMsg + "Clicking Yes will run";
			strMsg=strMsg + "\n   -Normalize each file individually that is identified as a trend file";
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process all Help Info Trend Files",intDialogButton);
			if(intDialogButton == 0)
			{
				File fileHIP = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PARSED.TXT");
				File fileHIPI = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT");
				File fileHIHF = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_HOT_FIXES.TXT");
				File fileHIPK = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PK");
				fileHIP.delete();
				fileHIPI.delete();
				fileHIHF.delete();
				fileHIPK.delete();
		
				FileWriter newFile = null;
				FileWriter filePrograms=null;
				FileWriter fileHotFixes=null;
				try 
				{
					newFile = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PARSED.TXT",true);
					filePrograms = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_PROGRAMS_INSTALLED.TXT",true);
					fileHotFixes = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_TREND_HOT_FIXES.TXT",true);
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
		
		
		public static void RenameExports()
		{
			ProcessIncidentDetailsServiceDashboard();
			ProcessRallyFeatures();
			ProcessRallyStories();
			ProcessRallyTestCases();
			ProcessRallyDefects();
			ProcessRallyFeatureStories();
			ProcessRallyTaskStory();
			ProcessRallyTestCaseFeatures();
			CopyRallyDefectMilestone();
			ProcessRallyDefectMilestone();
			BuildBatToCopyRallyExportsToDriveY();
			ProcessRallyDefectStory();
			ProcessRallyFeaturesExtract();
			ProcessRallyStoryExtract();
			ProcessRallyTaskExtract();
			ProcessRallyFeaturesFromPortfolio();
//			BackupAndRenameExportsFromSPLUNK();
		}
		public static void ProcessFEDEdashboardProducts()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "Clicking Yes opens the FEDEBOM Dashboard","Run the FEDEBOM Dashboard executable jar then extract the products then run the Alteryx WF",intDialogButton);
			if(intDialogButton == 0)
			{
				java.lang.Process runProcess;
				try 
				{
					runProcess=Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunFEDEDashboard.bat");
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
			}		
		}
		private static void ProcessRallyFeaturesFromPortfolio()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the Features",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "Features.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyTaskExtract()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 11_TASK_EXPORT",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "11_TASK_EXPORT.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyStoryExtract()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 10_STORY_EXTRACT",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "10_STORY_EXTRACT.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyFeaturesExtract()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 09_FEATURES_EXTRACT",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "09_FEATURES_EXTRACT.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyDefectStory()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 8_DefectsStory",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "8_DefectsStory.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyDefectMilestone()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
//			String fileDestination2="C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 08_DefectMilestones",intDialogButton);
			if(intDialogButton == 0)
			{
				File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "DEFECT_EXTRACT_FOR_WF.TXT";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//							File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
							try 
							{
								FileWriter fwc = new FileWriter(batFile);
								BufferedWriter bwc = new BufferedWriter(fwc);
								bwc.write("move /Y \"" + fileSource + "\", \"" + fileDestination + "\"");
								bwc.close();
								java.lang.Process runProcess;
								runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
							} 
							catch (IOException e) 
							{
								e.printStackTrace();
							}
//							fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\";
//							fileDestination = fileDestination + "DEFECT_EXTRACT_FOR_WF.TXT";
//							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//							try 
//							{
//								FileWriter fwm = new FileWriter(batFile);
//								BufferedWriter bwm = new BufferedWriter(fwm);
//								bwm.write("move /Y \"" + fileSource + "\", \"" + fileDestination + "\"");
//								bwm.close();
//								java.lang.Process runProcess;
//								runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//							} 
//							catch (IOException e) 
//							{
//								e.printStackTrace();
//							}
						}
					}
				}
			}
		}
		private static void CopyRallyDefectMilestone()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
//			String fileDestination2="C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Copy the 08_DefectMilestones",intDialogButton);
			if(intDialogButton == 0)
			{
				File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "08_DefectMilestones.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//							File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
							try 
							{
								FileWriter fwc = new FileWriter(batFile);
								BufferedWriter bwc = new BufferedWriter(fwc);
								bwc.write("copy /Y \"" + fileSource + "\", \"" + fileDestination + "\"");
								bwc.close();
								java.lang.Process runProcess;
								runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
							} 
							catch (IOException e) 
							{
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		private static void ProcessRallyTestCaseFeatures()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 7_TestCasesFeatures",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "7_TestCasesFeatures.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyTaskStory()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 6_TaskStory",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "6_TaskStory.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyFeatureStories()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 5_FeatureStories",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "5_FeatureStories.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyDefects()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 4_RALLY_DEFECTS",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "4_RALLY_DEFECTS.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessRallyTestCases()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the 3_RALLY_TEST_CASES",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "3_RALLY_TEST_CASES.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		
		private static void ProcessRallyStories()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the RALLY_STORIES",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "2_RALLY_STORIES.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		
		private static void ProcessRallyFeatures()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Process the RALLY_FEATURES",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "1_RALLY_FEATURES.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		private static void ProcessIncidentDetailsServiceDashboard()
		{
				
			Path FROM = Paths.get("C:\\Users\\rrose66\\Downloads\\");
			Path TO = Paths.get("C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\");
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			String strMsg="";
			strMsg=strMsg + "\nClicking Yes will";
			strMsg=strMsg + "\n    -Start the renaming processor";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the downloaded file",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("Incident Details"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "IncidentDetailsServiceDashboard.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
							File batFile = new File("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
							try 
							{
								FileWriter fw = new FileWriter(batFile);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write("cd C:\\Users\\rrose66\\Downloads");
								bw.append("\n");
								bw.write("rename *.*, IncidentDetailsServiceDashboard.csv");
								bw.append("\n");
								bw.write("del C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\IncidentDetailsServiceDashboard.csv");
								bw.append("\n");
								bw.write("copy IncidentDetailsServiceDashboard.csv, C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\");
								bw.append("\n");
								bw.write("del IncidentDetailsServiceDashboard.csv");
								
								bw.close();
								java.lang.Process runProcess;
								runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
		
							} 
							catch (IOException e) 
							{
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		public static void ProcessAnotherServerLogDate() 
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
//			String strMsg="";
//			strMsg=strMsg + "Manual Tasks:";
//			strMsg=strMsg + "\n    -Open the Server Log Trends QlikView and find the last scanned date";
//			strMsg=strMsg + "\nClicking Yes will";
//			strMsg=strMsg + "\n    -Prompt for a date to process";
//			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//			intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Update local folders and record changes",intDialogButton);
//			if(intDialogButton == 0)
//			{
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
//			}	
			ProcessServerLogLoop();
		}
		public static void NormalizeServerLogs(String strDateToProcess) throws IOException
		{
			String strFullPath;
//			File dir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\");
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
//			DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\FB4SchedulerFinal.txt");
//			DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\FB4Scheduler.txt");
			String[] aryFileTextName;
			String strFileTextName;
			String[] aryFileDelimitedName;
			String strFileDelimitedName;
//			System.out.println("String for the file path is: " + strFilePath);
			aryFileTextName=strFilePath.split("\\.");
			strFileTextName=aryFileTextName[0] + ".txt";
			File fileInput = new File(strFilePath);
			strFileName=fileInput.getName();
//			strFileDelimitedName=aryFileTextName[0] + "Final.txt";
			strFileDelimitedName="C:\\PROJECTS\\DATA\\FEDEBOM\\LOGS\\DT.CSV";
			
			DeleteThisFile(strFileTextName);
//			DeleteThisFile(strFileDelimitedName);
			
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
//					System.out.println(strInputData);
				}
//				if(strInputData.startsWith("2019"))
//				{
//					newTW.println(strInputData);
//				}
				strInputData = br.readLine();
			}
			newTW.close();
			br.close();
			String strLineType;
			String strMethodLine;

			FileWriter fwFB4SchedulerS2 = new FileWriter(strFileDelimitedName,true);
//			FileWriter fwFB4SchedulerS2 = new FileWriter(strFileDelimitedName,false);
			BufferedWriter newBW1 = new BufferedWriter(fwFB4SchedulerS2);
			PrintWriter newTW1 = new PrintWriter(newBW1);

			int intProcessedRows=0;
			BufferedReader brStep1 = new BufferedReader(new FileReader(strFileTextName));
			strInputData = brStep1.readLine();
			String[] aryScanned=null;
			while(strInputData!=null)
			{
				intProcessedRows++;
//				if(intProcessedRows > 1000)
//				{
//					break;
//				}
//				dtDateTime = GetDateFromLine(strInputData);
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
//					strMethodLine = GetLineMethodRow(strInputData);
					
					newTW1.println(strFileName + "," + strDateTime.substring(0,8) + "," + strDateTime + "," + strLineType + "," + strMethod);
				}
				strInputData = brStep1.readLine();
			}
			brStep1.close();
			newTW1.close();
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
		public static String GetDateTimeAsString(String strInputData)
		{
			String[] aryLine=null;
			aryLine=strInputData.split("");
//			String[] aryDateTime=null;
			String strDateTime="";
//			String strTime=null;
//			aryDateTime=aryLine[1].split("");
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
		public static void OpenDailyCycleApps()
		{
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "Click Yes to open all Daily Cycle links","All URLs",intDialogButton);
			if(intDialogButton == 0)
			{
				try
				{
					Runtime.getRuntime().exec(strStartChrome + " http://www.par.ford.com");
					Runtime.getRuntime().exec(strStartChrome + " https://rally1.rallydev.com/#/51575742627ud/workviews");
					Runtime.getRuntime().exec(strStartChrome + " https://splunk.shc.ford.com/en-US/app/fedebom/fede_application_monitoring_business");
					Runtime.getRuntime().exec(strStartIE + "  https://www.dorf.ford.com/");
					Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunFEDEDashboard.bat");
					Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunAccuRev.bat");
					Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\D4_S2_FEDEBOM.exe");
//					Runtime.getRuntime().exec(strStartIE + " https://www.dorf.ford.com/");
					Runtime.getRuntime().exec(strStartIE + " https://epiauth.azurewebsites.net/Account/Login?ReturnUrl=https%3a%2f%2fportal.epitec.com%2f&ApplicationKey=baf3e385-9aed-4822-9b6e-20ffcfdd9186");
				}
				catch (IOException e)
				{
					e.printStackTrace();
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
			}//		public static void DeleteThisFile(String strFullPath)
//		{
//			Boolean blnReadyToContinue=false;
//			File fileToDelete = new File(strFullPath);
//			if(fileToDelete.exists())
//			{
//				fileToDelete.delete();
//			}
//			while(blnReadyToContinue==false)
//			{
//				if(fileToDelete.exists())
//				{
//					try 
//					{
//						Thread.sleep(6000);
//					} 
//					catch (InterruptedException e) 
//					{
//						e.printStackTrace();
//					}
//				}
//				else
//				{
//					blnReadyToContinue=true;
//				}
//			}
//		}
	}
		private static void BackupAndRenameExportsFromSPLUNK()
		{
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\RALLY\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Backup and Rename SPLUNK files",intDialogButton);
			if(intDialogButton == 0)
			{
				File dir = new File(fileSource);
				File[] filesList = dir.listFiles();
				for (File file : filesList)
				{
					if (file.isFile())
					{
						if(file.getName().startsWith("export"))
						{
							fileSource = fileSource + file.getName();
							fileDestination = fileDestination +  "SPLUNK_PROGRAM_USAGE_MTD.csv";
							AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
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
						}
					}
				}
			}
		}
		public static void CopySPLUNKFilesToDriveY()
		{
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String fileSource="C:\\Users\\rrose66\\Downloads\\";
			String fileDestination="Y:\\ARCHIVES\\LEADERSHIP_DECK\\USER_METRICS\\";
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "","Backup and Rename SPLUNK files",intDialogButton);
			if(intDialogButton == 0)
			{
				fileSource="C:\\Users\\rrose66\\Downloads\\";
				FileWriter batFile=null;
//				AutomatedProcesses.DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
//				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
				try 
				{
					batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
					FileWriter fw = batFile;
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("move /Y \"" + fileSource + "SPLUNK_PROGRAM_USAGE_MTD.csv" + "\", \"" + fileDestination+  "SPLUNK_PROGRAM_USAGE_MTD" + "_" + GetStringTodayYYYYMMDD1() +".csv" + "\"");
					bw.newLine();
					bw.write("move /Y \"" + fileSource + "SPLUNK_PROGRAM_USAGE_PM.csv" + "\", \"" + fileDestination+ "SPLUNK_PROGRAM_USAGE_MTD" + "_" + GetStringTodayYYYYMMDD1() + ".csv"+ "\"");
					bw.newLine();
					bw.write("move /Y \"" + fileSource + "SPLUNK_SEARCHES.csv" + "\", \"" + fileDestination+"SPLUNK_SEARCHES" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
					bw.newLine();
					bw.write("move /Y \"" + fileSource + "SPLUNK_SUBMITS.csv" + "\", \"" + fileDestination+"SPLUNK_SUBMITS" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
					bw.newLine();
					bw.write("move /Y \"" + fileSource + "tcbomLOGS.zip" + "\", \"" + fileDestination+"tcbomLOGS" + "_" + GetStringTodayYYYYMMDD1() +".csv"+ "\"");
					bw.close();
					java.lang.Process runProcess;
					runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}

	public static void RenameRallyBaseFiles()
	{
		try 
		{
			Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RenameRallyBaseFiles.bat");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
	

