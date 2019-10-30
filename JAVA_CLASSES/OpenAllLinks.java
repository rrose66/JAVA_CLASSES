package urls;

import java.io.IOException;

import javax.swing.JOptionPane;

public class OpenAllLinks 
{
	public static void main(String[] args) 
	{
//			Prod Links
			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
			intDialogButton=JOptionPane.showConfirmDialog(null, "This will open 15 links","Test the Prod Links?",intDialogButton);
			if(intDialogButton == 0)
			{	
				try
				{

					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/PDAM/AVBOM2%20Version%20Controlled%20Library/Forms/AllItems.aspx?RootFolder=%2Fsites%2FPDAM%2FAVBOM2%20Version%20Controlled%20Library%2FWeekly%20John%20Meeting%2F2018%2F09%2D13%2D2018&FolderCTID=0x012000D15F616401E1D342AA6C3");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/portal/jsp/getSavedSearch.do");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/ProcessPortal/jsp/index.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://pd3.spt.ford.com/sites/avbomuser");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/ProcessAdmin/ProcessAdmin/com.lombardisoftware.processadmin.ProcessAdmin/ProcessAdmin.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1760.md3.ford.com:9080/ProcessAdmin/ProcessAdmin/com.lombardisoftware.processadmin.ProcessAdmin/ProcessAdmin.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1761.md3.ford.com:9080/ProcessAdmin/ProcessAdmin/com.lombardisoftware.processadmin.ProcessAdmin/ProcessAdmin.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://eccvas1760.md2.ford.com:9080/ProcessAdmin/ProcessAdmin/com.lombardisoftware.processadmin.ProcessAdmin/ProcessAdmin.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://eccvas1761.md2.ford.com:9080/ProcessAdmin/ProcessAdmin/com.lombardisoftware.processadmin.ProcessAdmin/ProcessAdmin.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.avbom2.ford.com/WERSRefreshUiWeb/views/maintenance.faces?windowId=c33");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.avbom2.ford.com/WERSRefreshUiWeb/views/programSummary.faces?windowId=a8b");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.pdoservices.ford.com/PdoServicesWeb/ProductVarietyVehicleLineServiceV1");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.pdoservices.ford.com/PdoServicesWeb/ProductVarietyBuildabilityServiceV1");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.padb.ford.com/PadbServicesWeb/ProductClassificationCrossReferenceService");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				} 
			}

			//Log Files
			intDialogButton=JOptionPane.showConfirmDialog(null, "This will open 5 links","Test the Links to the Log Files?",intDialogButton);
			if(intDialogButton == 0)
			{	
				try
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1760.md3.ford.com:9080/LogViewer/html/logview/listlogs.jsp?logfolder=BPM8_PSPROD.AppTarget.Node01.0&profile=Node01");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://eccvas1760.md2.ford.com:9080/LogViewer/html/logview/htmlservlet?filename=SystemOut.log&profile=Node02&folder=BPM8_PSPROD.AppTarget.Node02.0&browser=1");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1761.md3.ford.com:9080/LogViewer/html/logview/htmlservlet?filename=SystemOut.log&profile=Node03&folder=BPM8_PSPROD.AppTarget.Node03.0&browser=1");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://eccvas1761.md2.ford.com:9080/LogViewer/html/logview/htmlservlet?filename=SystemOut.log&profile=Node04&folder=BPM8_PSPROD.AppTarget.Node04.0&browser=1");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1760.md3.ford.com:9080/LogViewer/html/logview/htmlservlet?filename=SystemOut.log&profile=Node01&folder=BPM8_PSPROD.AppTarget.Node01.0&browser=1");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				} 
			}
//Thread Dump
			intDialogButton=JOptionPane.showConfirmDialog(null, "This will open 4 links","Test the Links to the Thread Dump?",intDialogButton);
			if(intDialogButton == 0)
			{	
				try
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1761.md3.ford.com:9080/FordCustom/html/custom/system/threadDump.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://fcvas1760.md3.ford.com:9080/FordCustom/html/custom/system/threadDump.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://eccvas1761.md2.ford.com:9080/FordCustom/html/custom/system/threadDump.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://eccvas1760.md2.ford.com:9080/FordCustom/html/custom/system/threadDump.jsp");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				} 
			}
//References
			intDialogButton=JOptionPane.showConfirmDialog(null, "This will open 7 links","Test the Links to the References and Lower Env?",intDialogButton);
			if(intDialogButton == 0)
			{	
				try
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://tools.netops.ford.com/");

//Lower Env Links
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://wwwdev.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://wwwqa.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://wwwdev.avbom2.ford.com/WERSRefreshUiWeb/views/maintenance.faces?windowId=c33");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://wwwqa.avbom2.ford.com/WERSRefreshUiWeb/views/maintenance.faces?windowId=c33");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://wwwqa.bpm.ford.com/portal/jsp/getSavedSearch.do");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://wwwdev.bpm.ford.com/portal/jsp/getSavedSearch.do");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				} 
			}
//Quick Access
			intDialogButton=JOptionPane.showConfirmDialog(null, "This will open 11 links","Test the Links to the Quick Access?",intDialogButton);
			if(intDialogButton == 0)
			{	
				try
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/PDAM/EarlyBOMMetricDashboard/AvailabilityCollection/HourlyAvailability.aspx");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMChangeView");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.processcenter.ford.com/teamworks/executeServiceByName?processApp=FMGOVNA&serviceName=BPM%20-%20Process%20Designer%20Access%20Dashboard&snapshot=2018-08-06");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.processcenter.ford.com/teamworks/executeServiceByName?processApp=FMGOVNA&serviceName=BPM%20-%20Process%20Designer%20Access%20Dashboard&snapshot=2018-08-06");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://pd1.spt.ford.com/sites/avbomts/tools/System%20Metrics/Forms/AllItems.aspx?RootFolder=%2Fsites%2Favbomts%2Ftools%2FSystem%20Metrics%2FCTQ&FolderCTID=0x012000B2E5F68810BFD74ABCE8989CDA3EC44B&View=%7B39A678C0%2D8FE6%2D4D1B%2D90C6%2D2908BDCA19F9%7D");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.hteam.ford.com/hostingtools/home.do?action=home");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/bpmrest-ui/BPMRestAPITester/index.jsp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.gicc.ford.com/tab_index.cgi?work_area=GICC&tab_name=Requests");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.gicc.ford.com/cgi-bin/network/view_req.cgi?cc_no=2448834");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.wsl.ford.com/pcookie/listcookies.cgi");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/GCE/Shared%20Documents/Forms/AllItems.aspx?RootFolder=%2fsites%2fGCE%2fShared%20Documents%2fCredential%20Change%20Procedure%20Template&FolderCTID=0x0120005802EB72568F1A429067F303C05BB0C8");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				} 
			}
//Other Links
			intDialogButton=JOptionPane.showConfirmDialog(null, "This will open 15 links","Test the Links to all Others?",intDialogButton);
			if(intDialogButton == 0)
			{	
				try
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.acrol.ford.com/asp/ACROLModify.asp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it2.spt.ford.com/sites/ITSecurity/compliance");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.acrol.ford.com/asp/Search_Record.asp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.eatool.ford.com/EaToolUiWeb/home.faces?dswid=-7874");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/ITMS19335/AVBOM2%20Support%20Documents/Forms/AllItems.aspx");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.rc.ford.com/reporting/RCServerProjectRpt.asp");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/ITAdvisorySite/SitePages/Home.aspx");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/PDAM/AVBOM2%20Version%20Controlled%20Library/Forms/AllItems.aspx?RootFolder=%2Fsites%2FPDAM%2FAVBOM2%20Version%20Controlled%20Library%2FWeekly%20John%20Meeting%2F2018&FolderCTID=0x012000D15F616401E1D342AA6C3668C01855A6&View=");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://rally1.rallydev.com/");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.itsms.ford.com/arsys/forms/itsmsapp/SHR:LandingConsole/Default+Administrator+View/?cacheid=52d55f9a");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.tc.ford.com/ts/BPM/platform/Platform%20Controls/default.aspx?RootFolder=%2Fts%2FBPM%2Fplatform%2FPlatform%20Controls%2FPlatform%20Support%20Document%2FMetrics&FolderCTID=0x0120004D784F4116C9E341AAA0338E96A3E455&View=%7b1DD163EB-D35E-4A76-9941-");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.audit.ford.com/CAWWeb/homePre.do");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging http://www.etracker.ford.com/Apps/AddIssues/EditIssue.asp?ShowAsPopup=Y&ProjectID=2016TEST&IssueId=15201184");
					Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/ITMS19335/AVBOM2%20KB/Lists/Knolodge%20Base/AllItems.aspx");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				} 
			}
		}
}
