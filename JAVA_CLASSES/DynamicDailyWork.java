package dev.misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DynamicDailyWork {

	public static void main(String[] args) {
		boolean success=false;
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
		strPartOfFileNameForTwoDaysAgo = df8.format(twoDaysAgo.DATE);


		File sourceFullPath = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.TXT");
		File targetFullPath = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS_"   + strPartOfFileNameForYesterday + ".TXT");
		try {
			copyFile(sourceFullPath,targetFullPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			newFile = new FileWriter("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DailyDynamic.bat",false);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		newTextBuffer = new BufferedWriter(newFile);
		newTextPrinter = new PrintWriter(newTextBuffer);

		strCMD="";
		strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS*.TXT";
		strCMD = strCMD + "  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_FOR_REPORT.TXT";
		newTextPrinter.println(strCMD);

		newTextPrinter.close();
		
		File fileDailyDynamic = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DailyDynamic.bat");
		success=false;
		while(success==false)
		{
			if(fileDailyDynamic.exists())
			{
				success=true;
			}
		}
		try
		{
		Runtime.getRuntime().exec("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DailyDynamic.bat");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void copyFile(File sourceFile,File destFile) throws IOException
	{
		if(!destFile.exists())
		{
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try
		{
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		}
		finally
		{
			if(source !=null)
			{
				source.close();
			}
			if(destination != null)
			{
				destination.close();
			}
		}
	}

}
