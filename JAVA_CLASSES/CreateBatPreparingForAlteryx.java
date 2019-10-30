package dev.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateBatPreparingForAlteryx {

	public static void main(String[] args) {
		String strCMD;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);;
//		System.out.println(dateFormat.format(yesterday.getTime()));
		Date dateToday = new Date();
		final Calendar twoDaysAgo = Calendar.getInstance();
		twoDaysAgo.add(Calendar.DATE, -2);
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		DateFormat df8 = new SimpleDateFormat("yyyymmdd");
		String strPartOfFileNameForYesterday=dateFormat.format(yesterday.getTime());
//		System.out.println(strPartOfFileNameForYesterday);
		String strPartOfFileNameForTwoDaysAgo;
		try
		{
//			strPartOfFileNameForYesterday = df8.format(yesterday.DATE);
			strPartOfFileNameForTwoDaysAgo = df8.format(twoDaysAgo.DATE);
			
			newFile = new FileWriter("C:\\PROJECTS\\ACCUREV\\BOMinFEDE_CART_WS_Tools_COLLAB_D00\\DAILY_CYCLE\\S5_DailyDynamic.bat",false);
			newTextBuffer = new BufferedWriter(newFile);
			newTextPrinter = new PrintWriter(newTextBuffer);

//			newTextPrinter.println("DEL C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\TWO_DAYS_AGO\\ALL_LOGS.CSV");
//			newTextPrinter.println("DEL C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_LOG_HISTORY\\FULL_LOG_ENTRIES.TXT");
//			newTextPrinter.println("DEL C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_ERROR_HISTORY\\ERRORS.TXT");

			
//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.CSV";
//			strCMD = strCMD + "  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\TWO_DAYS_AGO\\ALL_LOGS.TXT";
//			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.CSV";
			strCMD = strCMD + "  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS_"  + strPartOfFileNameForYesterday + ".TXT";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS*.TXT";
			strCMD = strCMD + "  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_FOR_REPORT.TXT";
			newTextPrinter.println(strCMD);

			
//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\Stagging\\TARGET\\*.TXT ";
//			strCMD = strCMD + "  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS_" + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_LOG_HISTORY\\FULL_LOG_ENTRIES.TXT ";
//			strCMD = strCMD + " C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_LOG_HISTORY\\FULL_LOG_ENTRIES_" + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_LOG_HISTORY\\FULL_LOG_ENTRIES.TXT ";
//			strCMD = strCMD + " C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_LOG_HISTORY\\FULL_LOG_ENTRIES_TODAY.TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_ERROR_HISTORY\\ERRORS.TXT ";
//			strCMD = strCMD + " C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_ERROR_HISTORY\\ERRORS_" + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_ERROR_HISTORY\\ERRORS.TXT ";
//			strCMD = strCMD + " C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_ERROR_HISTORY\\ERRORS_TODAY.TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.CSV ";
//			strCMD = strCMD + "C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS_" + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\LOGS_FILE_NAME_BY_DAY\\ERRORS_YESTERDAY.CSV ";
//			strCMD = strCMD + "C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\LOGS_FILE_NAME_BY_DAY\\ERRORS_YESTERDAY_" + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\LOGS_FILE_NAME_BY_DAY\\FLAGGED_BY_DATE.CSV ";
//			strCMD = strCMD + "C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\LOGS_FILE_NAME_BY_DAY\\FLAGGED_" + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

//			newTextPrinter.println("DEL C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\FULL_LOG_ENTRIES.TXT");
//			newTextPrinter.println("DEL C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ERRORS.TXT");
//			newTextPrinter.println("COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DAILY_ERROR_HISTORY\\*.*  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ERRORS.TXT");
			
			newTextPrinter.close();
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}
	}

}
