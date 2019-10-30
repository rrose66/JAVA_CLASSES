package misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BuildDateFileForQlikView 
{
	public static void main(String[] args) 
	{
//		Integer intRow=0;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		DateFormat dateScanned = new SimpleDateFormat("yyyyMMddhhmmss");
		DateFormat dateTodayFormatted = new SimpleDateFormat("yyyyMMddhhmmss");
		Calendar c = Calendar.getInstance();
		Calendar calendarStart = Calendar.getInstance();
		Date dateTarget = new Date();
		Date dateToday = new Date();
		calendarStart.add(Calendar.DATE, -100);
//		c.add(Calendar.DATE, -100);
		c.add(Calendar.DATE, 0);
//		System.out.println(c.getTime());
		String convertedDate=dateFormat.format(c.getTime());
		String scannedDate = dateScanned.format(c.getTime());

		String strToday = dateTodayFormatted.format(c.getTime());
//		System.out.println(strToday);
//		System.out.println(scannedDate);
//		System.out.println(convertedDate);
		try
		{
			FileWriter newFile = new FileWriter("C:\\PROJECTS\\DATA\\FOR_QLIKVIEW\\DATE_TIME_BASE.TXT",false);
			BufferedWriter newTextBuffer = new BufferedWriter(newFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println("StandardDateTime,yyyyMMddhhmmss");
			for(Double intRow=1.0;intRow < 1000000000;intRow++)
			{
				calendarStart.add(Calendar.SECOND, 1);
				convertedDate=dateFormat.format(calendarStart.getTime());
				scannedDate = dateScanned.format(calendarStart.getTime());
//				System.out.println(convertedDate);
//				System.out.println(scannedDate);
//				System.out.println(strToday);
				if(scannedDate.matches(strToday))
				{
//					System.out.println(scannedDate);
//					System.out.println(strToday);
					break;
				}
				newTextPrinter.println( convertedDate + "," + scannedDate);
			}
			newTextPrinter.close();
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}
	}

}
