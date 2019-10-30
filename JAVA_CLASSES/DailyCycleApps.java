package exec;

import java.io.IOException;

public class DailyCycleApps 
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

	public static void main(String[] args) 
	{
		try
		{
			java.lang.Process runProcess;
			Runtime.getRuntime().exec(strStartChrome + " https://www.itsmschange.ford.com/arsys/forms/prodaruser.ford.com/SHR:LandingConsole/Default+Administrator+View/?cacheid=1ee142e");
			Runtime.getRuntime().exec(strStartChrome + " http://www.par.ford.com");
			Thread.sleep(6000);
			Runtime.getRuntime().exec(strStartChrome + " https://rally1.rallydev.com/#/51575742627ud/workviews");
			Thread.sleep(6000);
			Runtime.getRuntime().exec(strStartChrome + " https://splunk.shc.ford.com/en-US/app/fedebom/fede_application_monitoring_business");
			Thread.sleep(6000);
			Runtime.getRuntime().exec(strStartIE + "  https://www.dorf.ford.com/");
			Thread.sleep(6000);
			Runtime.getRuntime().exec(strStartIE + " https://epiauth.azurewebsites.net/Account/Login?ReturnUrl=https%3a%2f%2fportal.epitec.com%2f&ApplicationKey=baf3e385-9aed-4822-9b6e-20ffcfdd9186");
			Thread.sleep(6000);
			Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunFEDEDashboard.bat");
			Thread.sleep(6000);
			Runtime.getRuntime().exec("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB\\BAT\\RunAccuRev.bat");
			Thread.sleep(6000);
			String[] cmd01 = {strStartAccess,"C:\\PROJECTS\\DATA\\FEDEBOM\\CHANGE_MANAGEMENT\\LOG_ANALYZER\\LOGS\\REFRESH_FEDEBOM_SERVER_LOGS.accdb",""};
			runProcess = Runtime.getRuntime().exec(cmd01);
			Thread.sleep(6000);
			String[] cmd02 = {strStartAccess,"C:\\PROJECTS\\DATA\\FEDEBOM\\LEADERSHIP_DECK\\MANUAL_UPDATES.accdb",""};
			runProcess = Runtime.getRuntime().exec(cmd02);
			Thread.sleep(6000);
			Runtime.getRuntime().equals("C:\\PROJECTS\\EXECUTABLES\\BMC.jar");
			Thread.sleep(6000);
			Runtime.getRuntime().exec("C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe");
			Thread.sleep(6000);
			Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\D4_S2_FEDEBOM.exe");
		}
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}


	}

}
