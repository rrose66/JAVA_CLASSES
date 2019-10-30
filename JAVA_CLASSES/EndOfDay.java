package insert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EndOfDay 
{
	public static void main(String[] args) 
	{
		FileWriter newFile = null;
		try 
		{
			Process runProcess;
			newFile = new FileWriter("C:\\PROJECTS\\DATA\\ITIL\\WORK_END_TIME.CSV",true);
			BufferedWriter newTextBuffer = null;
			PrintWriter newTextPrinter = null;
			SimpleDateFormat dateTimeToday = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
			Date dateToday = new Date();
			String strDateTimeNow = dateTimeToday.format(dateToday.getTime());
			newTextBuffer = new BufferedWriter(newFile);
			newTextPrinter = new PrintWriter(newTextBuffer);
			newTextPrinter.println(strDateTimeNow);
			newTextPrinter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
