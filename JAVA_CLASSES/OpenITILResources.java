package links;

import java.io.IOException;

import javax.swing.JOptionPane;

public class OpenITILResources 
{
	public static void main(String[] args) 
	{
		try
		{
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.itsmschange.ford.com/arsys/forms/prodaruser.ford.com/SHR%3ALandingConsole/Default+Administrator+View/?cacheid=7af845d1");
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/avbom2-wizard/_layouts/15/viewlsts.aspx?BaseType=0");
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://citrix6p.ford.com/Citrix/XenApp/auth/login.aspx");
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://github.ford.com/");
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://it1.spt.ford.com/sites/PDAM/EarlyBOMMetricDashboard/AvailabilityCollection/DailyAvailability.aspx");
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging 	https://www.itconnect.ford.com/ux/myitapp/#/catalog/home/");
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.smartit.ford.com/");
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.bpm.ford.com/ProcessPortal/jsp/index.jsp#list%20%20%20");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
