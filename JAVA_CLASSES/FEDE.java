package src.obsolete;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

//import dependencies.RunTests;
import src.utilities.InputParams;
//import utilities.TestResultsExcelWrite;
import com.sun.istack.internal.logging.Logger;

public class FEDE 
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

//	Paths
	public static String strAlteryxRepository="C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\ALTERYX\\";

//	public static String strStartAccess="C:\\Program Files (x86)\\Microsoft Office\\Office16\\MSACCESS.EXE";
//	public static String strStartProject="C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINPROJ.EXE";
//	public static String strStartWord="C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINWORD.EXE";
//	public static String strStartExcel="C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE /c start";
//	C:\Program Files (x86)\Microsoft Office\root\Office16

	
//	public static void MonitorFEDEBOM()
//	{
//		String strMsg="";
//		strMsg=strMsg + "\nClicking Yes will";
//		strMsg=strMsg + "\n    -Start I6 S2 FEDEBOM";
//		strMsg=strMsg + "\n    -Monitor Rally";
//		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Enter the FEDEBOM monitoring branch?",intDialogButton);
//		if(intDialogButton == 0)
//		{
////			GetRallyExports();
//			ServerDown();
//			RunD4S2();
//			RunI6S2();
//			RunIntegration();
//			RallyWork();
//		}
//	}

//	public class RunTests 
//	{
//		private static Logger logger = Logger.getLogger(RunTests.class);
//		protected static String user_id = null;
//
//		@SuppressWarnings("static-access")
//		public static void main(String[] args) 
//		{
//			boolean isValidUser = false;		
//			TestResultsExcelWrite resultsWriter = new TestResultsExcelWrite();
//			InputParams inputParams=new InputParams();
//		}

//	}

	public static void RunAlteryxRallyToBMC()
	{
		String strMsg="Run Alteryx WF BMC_TO_RALLY_EXPORT_PROCESSING";
		strMsg=strMsg + "\n The last step should have archived the properly named exports to the y drive";
		strMsg=strMsg + "\n Clicking yes will run the work flow";
		strMsg=strMsg + "\n  - Compare current day data to last snapshot";
		strMsg=strMsg + "\n  - Read through Rally Defects searching for Program Codes";
		strMsg=strMsg + "\n  - Create output files for metrics and daily activities";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process BMC and Rally data?",intDialogButton);
		if(intDialogButton == 0)
		{
			Process runProcess;
			String[] cmd03 = {strStartAlteryx, "C:\\PROJECTS\\GitHub\\FEDEBOM\\DEFECTS\\BMC_AND_RALLY_DATA_PROCESSOR_v03.yxwz"};
			
			try 
			{
				runProcess = Runtime.getRuntime().exec(cmd03);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

}
