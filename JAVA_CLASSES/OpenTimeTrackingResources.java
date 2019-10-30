package open;

import java.io.IOException;

public class OpenTimeTrackingResources 
{
	public static void main(String[] args) 
	{
		try
		{
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://www.dorf.ford.com/");
			Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe -noframemerging https://epiauth.azurewebsites.net/Account/Login?ReturnUrl=https%3a%2f%2fportal.epitec.com%2f&ApplicationKey=baf3e385-9aed-4822-9b6e-20ffcfdd9186");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
