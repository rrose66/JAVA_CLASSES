package misc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileExistsSoContinue 
{
	public static void main(String[] args) 
	{
		File fileApplicationLog = new File("C:\\PROJECTS\\DATA\\LAN_COPY\\FEDEWSAutomation\\logs\\application.log");
		boolean blnKeepGoing = true;
		long baseDate;
		long currentLastModifiedDate;
		currentLastModifiedDate = fileApplicationLog.lastModified();
		baseDate=currentLastModifiedDate;
		while (blnKeepGoing)
		{
			baseDate=currentLastModifiedDate;
			try 
			{
				TimeUnit.MINUTES.sleep(10);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			currentLastModifiedDate = fileApplicationLog.lastModified();
			if(currentLastModifiedDate == baseDate)
			{
				blnKeepGoing=false;
			}
		}
	}
}
