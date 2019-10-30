package open;

import java.io.IOException;

public class ConsoleForIncidents 
{
	public static String strStartChrome="C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging";

	public static void main(String[] args) 
	{
		try 
		{
			Runtime.getRuntime().exec(strStartChrome + " https://www.smartit.ford.com/ux/smart-it/#/");
			Runtime.getRuntime().exec(strStartChrome + " https://www.itsmschange.ford.com/arsys/forms/prodaruser.ford.com/SHR:LandingConsole/Default+Administrator+View/?cacheid=1ee142e");
//			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.itsmschange.ford.com/arsys/forms/prodaruser/SHR%3ALandingConsole/Default+Administrator+View/?cacheid=1ee142e");
//			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.itsmschange.ford.com/arsys/forms/prodaruser.ford.com/SHR%3ALandingConsole/Default+Administrator+View/?cacheid=7af845d1");
//			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.bpm.ford.com/ProcessPortal/jsp/index.jsp#list%20%20%20");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
