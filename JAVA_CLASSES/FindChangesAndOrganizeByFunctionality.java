package analyze;

import java.io.IOException;

import javax.swing.JOptionPane;

public class FindChangesAndOrganizeByFunctionality 
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
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, "","After updating files in AccuRev click yes",intDialogButton);
		if(intDialogButton == 0)
		{
			java.lang.Process runProcess;
			try 
			{
//				DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\JAVA_ANALYZER\\AccuRev\\AccuRevIncomingFiles\\AccuRevIncomingProcessingDone.csv");
				String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "BOMinFEDE_v1.0_Collab_DEV_FILE_LIST_FULLPATHS.yxmd"};
				runProcess = Runtime.getRuntime().exec(cmd03);
//				WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\FEDEBOM\\AccuRev\\AccuRevIncomingFiles\\AccuRevIncomingProcessingDone.csv");
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

}
