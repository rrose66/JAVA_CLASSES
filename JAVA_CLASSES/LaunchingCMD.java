package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LaunchingCMD 
{
	public static void main(String[] args) 
	{
		ProcessBuilder builder = new ProcessBuilder
				("cmd.exe", "/c", "cd \"C:\\temp\" && dir");
	        builder.redirectErrorStream(true);
	        Process p = null;
			try 
			{
				p = builder.start();
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line = null;
	        while (true) {
	            try 
	            {
					line = r.readLine();
				} 
	            catch (IOException e) 
	            {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            if (line == null) { break; }
	            System.out.println(line);
	        }

		
		
		
		
		
		Runtime rt = Runtime.getRuntime();
		String[] strCMD = {"cmd.exe","/c","start"};
		try
		{
			rt.exec(strCMD);
			String[] strCMD1 = {"cmd.exe","/c","cd /"};
			rt.exec(strCMD1);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
