package open;

import java.io.IOException;

public class OpenITconnect 
{

	public static void main(String[] args) 
	{
		try
		{
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging 	https://www.itconnect.ford.com/ux/myitapp/#/catalog/home/");
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging https://www.smartit.ford.com/");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
