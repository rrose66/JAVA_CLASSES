package cmdb;

import java.io.IOException;

import javax.swing.JOptionPane;

public class AccuRevAndAlteryx 
{
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
				String[] cmd03 = {strStartAlteryx, strAlteryxRepository + "ACCUREV_DIR_BEFORE_UPDATING.yxmd"};
				runProcess = Runtime.getRuntime().exec(cmd03);

			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}		

	}

}
