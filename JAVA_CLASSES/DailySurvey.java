package survey;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DailySurvey 
{
	public static void main(String[] args) 
	{
		String user_id = null;
		areWizDirListsValid();
		String strCustomMessage=null;
		Process runAccess;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateTimeToday = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		Date dateToday = new Date();
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		String strDateTimeNow = dateTimeToday.format(dateToday.getTime());
		String strPartOfFileNameForToday;
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		dateToday = new Date();
		strDateTimeNow = dateTimeToday.format(dateToday.getTime());
		System.out.println(strDateTimeNow);
		strCustomMessage="";
		strCustomMessage=strCustomMessage + "Is this the begin time?";
		intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
		try
		{
			System.out.println(dateTimeToday.format(dateToday.getTime()));
			strPartOfFileNameForToday = dateFormat.format(dateToday.getTime());
			if(intDialogButton == 0)
			{
				newFile = new FileWriter("C:\\PROJECTS\\DATA\\ITIL\\WORK_BEGIN_TIME.CSV",true);
				newTextBuffer = new BufferedWriter(newFile);
				newTextPrinter = new PrintWriter(newTextBuffer);
				newTextPrinter.println(strDateTimeNow);
				newTextPrinter.close();
				System.out.println(dateTimeToday.format(dateToday.getTime()));
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "\nAction Items";
				strCustomMessage=strCustomMessage + "\n   Open Outlook";
				strCustomMessage=strCustomMessage + "\nClicking Yes will run";
				strCustomMessage=strCustomMessage + "\n   I6 S2";
				strCustomMessage=strCustomMessage + "\n   Server Down Messages";
				strCustomMessage=strCustomMessage + "\n      Populate data from Inbox";
				strCustomMessage=strCustomMessage + "\n      Change the default scanned in all stagging tables";
				strCustomMessage=strCustomMessage + "\n   Wizard Report to refresh Data";
				strCustomMessage=strCustomMessage + "\n   Remedy";
				strCustomMessage=strCustomMessage + "\n   Wizard Availability Dashboard and open the web page";
				strCustomMessage=strCustomMessage + "\n   LAN based WS Automation";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{
					System.out.println(dateTimeToday.format(dateToday.getTime()));
					String[] cmd1 = {"C:\\PROJECTS\\EXECUTABLES\\I6_S2_FEDEBOM.exe",""};
					String[] cmd = {"C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\VBA\\PROCESS_SERVER_DOWN_MESSAGES.accdb"};
					String[] cmd20 = {"C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\VBA\\WIZ_REPORTING.accdb"};
					try
					{
						dateToday = new Date();
						strDateTimeNow = dateTimeToday.format(dateToday.getTime());
						System.out.println(strDateTimeNow);
						runAccess = Runtime.getRuntime().exec(cmd1);
						Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/PDAM/EarlyBOMMetricDashboard/AvailabilityCollection/DailyAvailability.aspx");
						Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.itsms.ford.com/arsys/shared/login.jsp?/arsys/forms/itsmsapp.ford.com/CTM:People/");
						Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://rally1.rallydev.com/#/34494668566ud/backlog");
						runAccess = Runtime.getRuntime().exec(cmd);
						runAccess = Runtime.getRuntime().exec(cmd20);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				System.out.println(dateTimeToday.format(dateToday.getTime()));
				dateToday = new Date();
				strDateTimeNow = dateTimeToday.format(dateToday.getTime());
				System.out.println(strDateTimeNow);
				boolean blnScheduledTasks = areWizDirListsValid();
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "Action Items";
				strCustomMessage=strCustomMessage + "\n   Validate that all Scheduled tasks completed without error" + blnScheduledTasks;
				strCustomMessage=strCustomMessage + "\n   When TC BOM opens, search for something to get journal to initialize";
				strCustomMessage=strCustomMessage + "\n   If no errors are seen in WS Automation command window, review the spreadsheets";
				strCustomMessage=strCustomMessage + "\n   Open Remedy and self assign";
				strCustomMessage=strCustomMessage + "\n   Open the Rally Application";
				strCustomMessage=strCustomMessage + "\n   Ensure files in C:\\PROJECTS\\DATA\\WIZ_DIR_LISTS have the current date on them";
				strCustomMessage=strCustomMessage + "\n   Move the WebMon email now";
				strCustomMessage=strCustomMessage + "\nClicking Yes will:";
				strCustomMessage=strCustomMessage + "\n   update the BOMClient.properties";
				strCustomMessage=strCustomMessage + "\n   run the Java Target Database moving data to baseline";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String outPutLine;
					Writer output = null;
					String[] cmd2 = {"C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\VBA\\MOVE_TARGET_DATA_TO_BASELINE.accdb"};
					try
					{
						newFile = new FileWriter("C:\\Users\\rrose66\\bom\\BomInputs\\BOMClient.properties",true);
						newTextBuffer = new BufferedWriter(newFile);
						newTextPrinter = new PrintWriter(newTextBuffer);
						newTextBuffer.newLine();
						newTextBuffer.write("GET_BOM_SERVER_PERFORMANCE_DISABLED=TRUE");
						newTextBuffer.newLine();
						newTextBuffer.write("CLIENT_DEBUG=TRUE");
						newTextBuffer.newLine();
						newTextBuffer.write("DEBUG_LEVEL=1");
						newTextBuffer.close();
						runAccess = Runtime.getRuntime().exec(cmd2);
					}
					catch (IOException allExceptions)
					{
						allExceptions.printStackTrace();
					}
				}
				System.out.println(dateTimeToday.format(dateToday.getTime()));
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "Action Items";
				strCustomMessage=strCustomMessage + "\n   Open AccuRev";
				strCustomMessage=strCustomMessage + "\n      TC BOM Workspace";
				strCustomMessage=strCustomMessage + "\n         Update the Incoming TC BOM files";
				strCustomMessage=strCustomMessage + "\n         Populate TC BOM files Recursive and Over Write";
				strCustomMessage=strCustomMessage + "\n      Automation Workspace";
				strCustomMessage=strCustomMessage + "\n         Update the Incoming Automation files";
				strCustomMessage=strCustomMessage + "\n         Populate Automation files  Recursive and Over Write";
				strCustomMessage=strCustomMessage + "\n   Open Rally";
				strCustomMessage=strCustomMessage + "\n      Continue download work";
				strCustomMessage=strCustomMessage + "\nOnce the AccuRev app is closed, click Yes to";
				strCustomMessage=strCustomMessage + "\n   paste resource folder into Eclipse";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{
					try
					{
						dateToday = new Date();
						strDateTimeNow = dateTimeToday.format(dateToday.getTime());
						System.out.println(strDateTimeNow);
						runAccess = Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\BAT\\CopyResourceFile.bat");
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "\nAction Items";
				strCustomMessage=strCustomMessage + "\n   Run TC BOM from Eclipse";
				strCustomMessage=strCustomMessage + "\n      Delete Existing Project";
				strCustomMessage=strCustomMessage + "\n      Import Gradle Project";
				strCustomMessage=strCustomMessage + "\n   While waiting to run TC BOM from Eclipse";
				strCustomMessage=strCustomMessage + "\n   Open RALLY MAPPING database to add the stagging data from rally";
				strCustomMessage=strCustomMessage + "\n   Run gradle task to create build folder";
				strCustomMessage=strCustomMessage + "\n   While waiting to run gradle task to create build folder";
				strCustomMessage=strCustomMessage + "\n   Extract and load the Work View data";
				strCustomMessage=strCustomMessage + "\n   While waiting for AccuRev to re-populate automation testing files";
				strCustomMessage=strCustomMessage + "\n   Extract and load Rally Tasks and Stories with Related data";
				strCustomMessage=strCustomMessage + "\nThis task is dependent on a successful Gradle build.";
				strCustomMessage=strCustomMessage + "\nClick Yes to run:";
				strCustomMessage=strCustomMessage + "\n   JavaCodeDirectoryScanner.yxmd";
				strCustomMessage=strCustomMessage + "\n   WIZ_FEDE_NET";
				strCustomMessage=strCustomMessage + "\n   JAVA_SOURCE_COLLECTOR.yxmd";
				strCustomMessage=strCustomMessage + "\n   WIZ_ERROR_DASHBOARD.yxmd";
				strCustomMessage=strCustomMessage + "\n   the UnZipBomClient.bat to make libraries accessible";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String[] cmd10 = {"C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\BAT\\UnzipBomClient.bat", ""};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd10);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					String[] cmd3 = {"C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\ALTERYX\\JavaCodeDirectoryScanner.yxmd"};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd3);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					String[] cmd5 = {"C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\ALTERYX\\JAVA_SOURCE_COLLECTOR.yxmd"};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd5);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					String[] cmd15 = {"C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\ALTERYX\\WIZ_ERROR_DASHBOARD.yxmd"};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd15);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}				
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "Action Items";
				strCustomMessage=strCustomMessage + "\n   When TC BOM opens, search for something to get journal to initialize";
				strCustomMessage=strCustomMessage + "\n   Review Wizard Availability Dashboard";
				strCustomMessage=strCustomMessage + "\n   Open Tableau Wizard Dashboard";
				strCustomMessage=strCustomMessage + "\n   Open Alteryx Wizard Dashboard";
				strCustomMessage=strCustomMessage + "\n   Open the Rally Metrics";
				strCustomMessage=strCustomMessage + "Click Yes only if the Gradle task above was successful, the following will run:";
				strCustomMessage=strCustomMessage + "\n   JavaFilesThatChangedSinceLastLoad.yxmd";
				strCustomMessage=strCustomMessage + "\n   JAVA_SOURCE_ANALYZER";
				strCustomMessage=strCustomMessage + "\n   Build the .classPath files for each of the automation tests";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{	
					BuildClassPath();
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String[] cmd7 = {"C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\ALTERYX\\JavaFilesThatChangedSinceLastLoad.yxmd"};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd7);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					String[] cmd6 = {"C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\ALTERYX\\JAVA_SOURCE_ANALYZER.yxmd"};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd6);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "Action Items";
				strCustomMessage=strCustomMessage + "\n    Prepare to run AddPart, AutomationTesting, and EditPart by executing the following steps";
				strCustomMessage=strCustomMessage + "\n       Delete Project";
				strCustomMessage=strCustomMessage + "\n       Import Project";
				strCustomMessage=strCustomMessage + "\n       clear the Eclipse log contents";
				strCustomMessage=strCustomMessage + "\n       rebuild the path";
				strCustomMessage=strCustomMessage + "\n       run AddPart?";
				strCustomMessage=strCustomMessage + "\nContinue with Rally Downloads";
				strCustomMessage=strCustomMessage + "\nClick yes, only if Gradle task above was successful, to run:";
				strCustomMessage=strCustomMessage + "\n   (still developing) to rebuild the paths in Eclipse for all the automation code";
				strCustomMessage=strCustomMessage + "\n   RALLY_IMPORT_DATA to append new records";
				strCustomMessage=strCustomMessage + "\n   Build BackUpTestCaseOutputs.bat";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{	
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String[] cmd2 = {"C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE", "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\VBA\\RALLY_IMPORT_DATA.accdb"};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd2);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
//							BuildClassPath();

					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String strCMD;
					Calendar yesterday = Calendar.getInstance();
					yesterday.add(Calendar.DATE, -1);;
					final Calendar twoDaysAgo = Calendar.getInstance();
					twoDaysAgo.add(Calendar.DATE, -2);
					try
					{
						strPartOfFileNameForToday = dateFormat.format(dateToday.getTime());
						newFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\BackUpTestCaseOutputs.bat",false);
						newTextBuffer = new BufferedWriter(newFile);
						newTextPrinter = new PrintWriter(newTextBuffer);
	
						//Add Part ----------------------------------------------------------
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\application.log";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\ADD_PART_ANALYSIS\\applicationLog_"  + strPartOfFileNameForToday + ".TXT";
						newTextPrinter.println(strCMD);
	
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\application.log";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\applicationLog_addPart_"  + strPartOfFileNameForToday + ".TXT";
						newTextPrinter.println(strCMD);
	
						
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\FEDETestCaseResults.xlsx";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\ADD_PART_ANALYSIS\\FEDETestCaseResults_"  + strPartOfFileNameForToday + ".xlsx";
						newTextPrinter.println(strCMD);
	
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\FEDETestCaseResults.xlsx";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\FEDETestCaseResults_addPart_"  + strPartOfFileNameForToday + ".xlsx";
						newTextPrinter.println(strCMD);
	
						
						//Edit Part ----------------------------------------------------------
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\application.log";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\EDIT_PART_TEST_CASE_RESULTS_ANALYSIS\\applicationLog_"  + strPartOfFileNameForToday + ".TXT";
						newTextPrinter.println(strCMD);
	
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\application.log";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\applicationLog_editPart_"  + strPartOfFileNameForToday + ".TXT";
						newTextPrinter.println(strCMD);
	
						
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\FEDETestCaseResults.xlsx";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\EDIT_PART_TEST_CASE_RESULTS_ANALYSIS\\FEDETestCaseResults_"  + strPartOfFileNameForToday + ".xlsx";
						newTextPrinter.println(strCMD);
	
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\FEDETestCaseResults.xlsx";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\FEDETestCaseResults__editPart_"  + strPartOfFileNameForToday + ".xlsx";
						newTextPrinter.println(strCMD);
	
						
						//WS AT_WEB_SERVICE_TESTING Part ----------------------------------------------------------
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\application.log";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\AT_WEB_SERVICE_TESTING\\applicationLog_"  + strPartOfFileNameForToday + ".TXT";
						newTextPrinter.println(strCMD);
	
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\application.log";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\applicationLog_WS_"  + strPartOfFileNameForToday + ".TXT";
						newTextPrinter.println(strCMD);
	
						
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\FEDETestCaseResults.xlsx";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\AT_WEB_SERVICE_TESTING\\FEDETestCaseResults_"  + strPartOfFileNameForToday + ".xlsx";
						newTextPrinter.println(strCMD);
	
						strCMD="";
						strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\FEDETestCaseResults.xlsx";
						strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\FEDETestCaseResults_WS_"  + strPartOfFileNameForToday + ".xlsx";
						newTextPrinter.println(strCMD);
						newTextPrinter.close();
					}
					catch (IOException allExceptions)
					{
						allExceptions.printStackTrace();
					}
				}
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "Action Items";
				strCustomMessage=strCustomMessage + "\n   Ensure all automated testing is completed";
				strCustomMessage=strCustomMessage + "\nClick yes to Run";
				strCustomMessage=strCustomMessage + "\n   BackUpTestCaseOutputs.bat";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{	
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String[] cmd8 = {"C:\\PROJECTS\\EXECUTABLES\\BackUpTestCaseOutputs.bat", ""};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd8);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}

				}
				strCustomMessage="";
				strCustomMessage=strCustomMessage + "Action Items";
				strCustomMessage=strCustomMessage + "\n   Open QlikView and view the WIZ reports";
				strCustomMessage=strCustomMessage + "\n   Open Tableau and view the WIZ reports";
//						strCustomMessage=strCustomMessage + "\n   Open all output excel files";
//						strCustomMessage=strCustomMessage + "\n   copy and paste latest updates into SharePoint excel file";
				strCustomMessage=strCustomMessage + "\n   Open RALLY_MAPPING access db";
				strCustomMessage=strCustomMessage + "\n   Run the code to sync the FedeTestResults to All Test Cases";
				strCustomMessage=strCustomMessage + "\n   email failures and questionable results to developer";
				strCustomMessage=strCustomMessage + "\nClick Yes to run";
				strCustomMessage=strCustomMessage + "\n   java file scanner?";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String[] cmd10 = {"C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\BAT\\JAVA_SCANNER.BAT",""};
					try
					{
						runAccess = Runtime.getRuntime().exec(cmd10);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				intDialogButton=JOptionPane.showConfirmDialog(null, "Click Yes to scan the java files?","This is the ITIL process for work time tracking.",intDialogButton);
				if(intDialogButton == 0)
				{	
					dateToday = new Date();
					strDateTimeNow = dateTimeToday.format(dateToday.getTime());
					System.out.println(strDateTimeNow);
					String strTargetFile = "C:\\PROJECTS\\DATA\\JAVA_DIR_LISTS\\javaDir.txt";
					File targetFile = new File(strTargetFile);
					Integer intLengthOfLine;
					try
					{
						Scanner inputStream = new Scanner(targetFile);
						while (inputStream.hasNext())
						{
							String data = inputStream.next();
							for (intLengthOfLine = 1;intLengthOfLine < data.length();intLengthOfLine++)
							{
								System.out.println(data.substring(0,intLengthOfLine));
							}
							System.out.println(data);
						}
						inputStream.close();
					}
					catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					new File("C:\\PROJECTS\\DATA\\JAVA_DIR_LISTS\\javaDir.txt").renameTo(new File("C:\\PROJECTS\\DATA\\JAVA_DIR_LISTS\\" + strPartOfFileNameForToday + "_javaDir.txt"));
				}
				strCustomMessage="";
				strCustomMessage=strCustomMessage+"If time, send wiz error users email notice when dashboard and error analysis aligns";
				strCustomMessage=strCustomMessage+"\nIf time create report of AccuRev metrics";
				strCustomMessage=strCustomMessage+"\nIf time create report of Java source changes";
				strCustomMessage=strCustomMessage+"\nIf time review checklist in schedule to analyze existing automated test cases";
				strCustomMessage=strCustomMessage+"\nIf time research WIZ error files";
				strCustomMessage=strCustomMessage+"\nIf time automate the governance of all automated test cases";
				strCustomMessage=strCustomMessage+"\nShutdown then start computer";
				intDialogButton=JOptionPane.showConfirmDialog(null, strCustomMessage,"This is the ITIL process for work time tracking.",intDialogButton);
			}
			else if(intDialogButton == 1)
			{
				newFile = new FileWriter("C:\\PROJECTS\\DATA\\ITIL\\WORK_END_TIME.CSV",true);
				newTextBuffer = new BufferedWriter(newFile);
				newTextPrinter = new PrintWriter(newTextBuffer);
				newTextPrinter.println(strDateTimeNow);
				newTextPrinter.close();
			}
			else
			{
				System.out.println("Cancelled");
			}
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}
	}
	public static void BuildClassPath()
	{
//				//update the path location in strings folder 1-4 for each of the folder location. Use double backslashes 
//				String folder1 = "C:\\Projects\\AccuRev\\BOMinFEDE_v1.0_Collab_DEV\\build\\distributions\\BOMClient\\libs\\";
//				String folder2 = "C:\\Projects\\AccuRev\\BOMinFEDE_v1.0_Collab_DEV\\build\\distributions\\BOMClient\\core\\";
//				String folder3 = "C:\\temp\\FEDEBOM_UI\\FEDEBOM 2.55\\bomclient\\core\\";
//				String folder4 = "C:\\temp\\FEDEBOM_UI\\FEDEBOM 2.55\\bomclient\\libs\\";
//				//xml formatting for the file string
//				String start = "\t<classpathentry kind=\"lib\" path=\"";
//				String end = "\"/>";
//				//File location
//				String newClassPath = "c:\\temp\\FileAutomationxml.txt";
//				//set up writer for writing to text file
//				PrintWriter out;
//				try {
//					out = new PrintWriter(new BufferedWriter(new FileWriter(newClassPath)));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		
		//open xml code
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println("<classpath>");
		System.out.println("\t<classpathentry kind=\"src\" path=\"src\"/>");
		System.out.println("\t<classpathentry kind=\"src\" path=\"resources/inputjson\"/>");
		System.out.println("\t<classpathentry excluding=\"inputjson/\" kind=\"src\" path=\"resources\"/>");
		
		//write file location with xml formating
//				File buildLibs = new File(folder1);
//				File[] listOfBuildLibs = buildLibs.listFiles();
//				for (File newClassPath1 : listOfBuildLibs){
//					System.out.println(start + newClassPath1 + end);
//				}
//				File buildCore = new File(folder2);
//				File[] listOfBuildCore = buildCore.listFiles();
//				for (File newClassPath1 : listOfBuildCore){
//					System.out.println(start + newClassPath1 + end);
//				}
//				File tempCore = new File(folder3);
//				File[] listOfTempCore = tempCore.listFiles();
//				for (File newClassPath1 : listOfTempCore){
//					System.out.println(start + newClassPath1 + end);
//				}
//				File tempLibs = new File(folder4);
//				File[] listOfTempLibs = tempLibs.listFiles();
//				for (File newClassPath1 : listOfTempLibs){
//					System.out.println(start + newClassPath1 + end);
//				}
		
		//end xml code
		System.out.println("\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
		System.out.println("\t<classpathentry kind=\"output\" path=\"bin\"/>");
		System.out.println("</classpath>");
		
		//close the write statement
		System.out.close();
	}
	public static boolean areWizDirListsValid()
	{
		String dateFormat = "dd/MM/yyyy";
		Boolean blnReturnVaule=false;
		Date lastModified;
		Date toDay=new Date();
		File wizDirs = new File("C:\\PROJECTS\\DATA\\WIZ_DIR_LISTS");
		File[] listOfFiles = wizDirs.listFiles();
		for (File file : listOfFiles)
		{
			lastModified=new Date(file.lastModified());
			System.out.println(file.getName());
			System.out.println(file.length());
			System.out.println(lastModified);
			System.out.println(toDay);
			System.out.println(toDay.getYear());
			System.out.println(toDay.getMonth());
			System.out.println(toDay.getDay());
			System.out.println(lastModified.getYear());
			System.out.println(lastModified.getMonth());
			System.out.println(lastModified.getDay());
			if(toDay.getYear()==lastModified.getYear())
			{
				System.out.println("year matches");
				if(toDay.getMonth() == lastModified.getMonth())
				{
					System.out.println("month matches");
					if(toDay.getDay() == lastModified.getDay())
					{
						System.out.println("day matches");
						blnReturnVaule= true;
					}
				}
			}
		}
		return blnReturnVaule;
	}

}
