package dev.misc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePingJar 
{
	public static void main(String[] args) 
	{
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		String strCMD;
		String strShortPath="Y:\\DATA\\PING\\TEMP\\";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		Date dateToday = new Date();
		String strNow;
		try
		{
			strNow = dateFormat.format(dateToday);
			newFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\PingAndRoute.bat",false);
			newTextBuffer = new BufferedWriter(newFile);
			newTextPrinter = new PrintWriter(newTextBuffer);
			
			newTextPrinter.println("DEL /q " + strShortPath + "*.*");

			strCMD = "";
			strCMD = strCMD + "PING 19.110.198.59 > ";
			strCMD = strCMD + strShortPath + "PING_AND_ROUTE_DATA_" ;
			strCMD = strCMD + strNow;
			strCMD = strCMD + ".txt";
			newTextPrinter.println(strCMD);
			
			strCMD = "";
			strCMD = strCMD + "ping 19.110.198.65 >> ";
			strCMD = strCMD + strShortPath + "PING_AND_ROUTE_DATA_" ;
			strCMD = strCMD + strNow;
			strCMD = strCMD + ".txt";
			newTextPrinter.println(strCMD);

			strCMD = "";
			strCMD = strCMD + "ping 19.151.77.3 >> ";
			strCMD = strCMD + strShortPath + "PING_AND_ROUTE_DATA_" ;
			strCMD = strCMD + strNow;
			strCMD = strCMD + ".txt";
			newTextPrinter.println(strCMD);

			strCMD = "";
			strCMD = strCMD + "ping 19.39.70.161 >> ";
			strCMD = strCMD + strShortPath + "PING_AND_ROUTE_DATA_" ;
			strCMD = strCMD + strNow;
			strCMD = strCMD + ".txt";
			newTextPrinter.println(strCMD);

			strCMD = "";
			strCMD = strCMD + "ping 19.39.12.82 >> ";
			strCMD = strCMD + strShortPath + "PING_AND_ROUTE_DATA_" ;
			strCMD = strCMD + strNow;
			strCMD = strCMD + ".txt";
			newTextPrinter.println(strCMD);

			strCMD = "";
			strCMD = strCMD + "ping 19.39.13.68 >> ";
			strCMD = strCMD + strShortPath + "PING_AND_ROUTE_DATA_" ;
			strCMD = strCMD + strNow;
			strCMD = strCMD + ".txt";
			newTextPrinter.println(strCMD);

			newTextPrinter.close();
			Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\PingAndRoute.bat");
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}
	}
}
