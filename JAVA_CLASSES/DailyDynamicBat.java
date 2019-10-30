package dev.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DailyDynamicBat 
{

	public static void main(String[] args) 
	{
		String strCMD;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);;
		Date dateToday = new Date();
		final Calendar twoDaysAgo = Calendar.getInstance();
		twoDaysAgo.add(Calendar.DATE, -2);
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		DateFormat df8 = new SimpleDateFormat("yyyymmdd");
		String strPartOfFileNameForYesterday=dateFormat.format(yesterday.getTime());
		String strPartOfFileNameForTwoDaysAgo;
		try
		{
			strPartOfFileNameForTwoDaysAgo = df8.format(twoDaysAgo.DATE);
			newFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\DailyDynamic.bat",false);
			newTextBuffer = new BufferedWriter(newFile);
			newTextPrinter = new PrintWriter(newTextBuffer);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\DATA\\SERVER_LOGS\\ALL_LOGS.CSV";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\SERVER_LOGS\\ALL_LOGS_HISTORY\\ALL_LOGS_"  + strPartOfFileNameForYesterday + ".TXT";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\DATA\\SERVER_LOGS\\ALL_LOGS_HISTORY\\ALL_LOGS*.TXT";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\SERVER_LOGS\\ALL_LOGS_FOR_REPORT.TXT";
			newTextPrinter.println(strCMD);
			
			newTextPrinter.close();
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}
	}
}
