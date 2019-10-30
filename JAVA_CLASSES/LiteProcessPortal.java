package process;

import java.io.IOException;

public class LiteProcessPortal 
{
	public static void main(String[] args) 
	{
		try
		{
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/teamworks/executeServiceByName?processApp=AVBOM2&serviceName=pcProdBOMDashboardDisplay");
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.bpm.ford.com/ProcessPortal/jsp/index.jsp#list%20%20%20");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
