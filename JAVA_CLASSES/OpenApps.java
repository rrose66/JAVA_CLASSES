package open;

import java.io.IOException;

public class OpenApps 
{
	public static void main(String[] args) 
	{
		try 
		{
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe -noframemerging http://www.par.ford.com");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
