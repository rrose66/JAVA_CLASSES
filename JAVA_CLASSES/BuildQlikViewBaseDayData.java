package misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class BuildQlikViewBaseDayData 
{

	public static void main(String[] args) 
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat dateScanned = new SimpleDateFormat("yyyyMMdd");
		DateFormat dateTodayFormatted = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		Calendar calendarStart = Calendar.getInstance();
		Date dateTarget = new Date();
		Date dateToday = new Date();
	//		calendarStart.add(Calendar.DATE, -100);
		c.add(Calendar.DATE, 1);
		String convertedDate=dateFormat.format(c.getTime());
		String scannedDate = dateScanned.format(c.getTime());
		String strToday = dateTodayFormatted.format(c.getTime());
		try
		{
			String strLastDayEntry = null;
			Date dateInput = null;
			try {
				dateInput = dateScanned.parse(strLastDayEntry);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.setTime(dateInput);
			c.add(Calendar.DATE, 1);
			FileWriter newFile = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\DAY_BASE.TXT",true);
			BufferedWriter newTextBuffer = new BufferedWriter(newFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			System.out.println("the new date is: " + dateScanned.format(c.getTime()));
			newTextPrinter.println("\n" + dateScanned.format(c.getTime()));
			newTextPrinter.close();
	
		}
		catch (IOException | ParseException allExceptions)
		{
			allExceptions.printStackTrace();
		}
		try
		{
			String strStartAlteryx = null;
			String[] cmd08 = {strStartAlteryx, "C:\\PROJECTS\\GitHub\\Wizard\\Monitor\\Alteryx\\DAY_BASE.yxmd"};
			Process runProcess = Runtime.getRuntime().exec(cmd08);
		}
		catch (IOException  allExceptions)
		{
			allExceptions.printStackTrace();
		}
	}

}
