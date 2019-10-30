package misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BuildQlikViewBaseDateData 
{

	public static void main(String[] args) 
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		DateFormat dateScanned = new SimpleDateFormat("yyyyMMddhhmmss");
		DateFormat dateTodayFormatted = new SimpleDateFormat("yyyyMMddhhmmss");
		Calendar c = Calendar.getInstance();
		Calendar calendarStart = Calendar.getInstance();
		Date dateTarget = new Date();
		Date dateToday = new Date();
		calendarStart.add(Calendar.DATE, -100);
		c.add(Calendar.DATE, 0);
		String convertedDate=dateFormat.format(c.getTime());
		String scannedDate = dateScanned.format(c.getTime());
		String strToday = dateTodayFormatted.format(c.getTime());
		try
		{
			FileWriter newFile = new FileWriter("C:\\PROJECTS\\DATA\\FOR_QLIKVIEW\\DATE_TIME_BASE_1.TXT",false);
			BufferedWriter newTextBuffer = new BufferedWriter(newFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println("Row,StandardDateTime,yyyyMMddhhmmss");
			for(Double intRow=1.0;intRow < 1000000000;intRow++)
			{
				calendarStart.add(Calendar.SECOND, 1);
				convertedDate=dateFormat.format(calendarStart.getTime());
				scannedDate = dateScanned.format(calendarStart.getTime());
				if(scannedDate.matches(strToday))
				{
					break;
				}
				newTextPrinter.println(intRow + "," + convertedDate + "," + scannedDate);
			}
			newTextPrinter.close();
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}

	}

}
