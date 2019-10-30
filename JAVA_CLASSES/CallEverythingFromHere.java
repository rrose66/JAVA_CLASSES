package dev.misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author RROSE66
 * Intent is to run only this executable jar from the scheduler
 * @version
 * 		Version 00 - baseline converting multiple scheduled jobs into one
 * 
 */
public class CallEverythingFromHere 
{
	public static void main(String[] args) 
	{
		boolean success=false;
		Process runEachCommand;
		try 
		{
			File wizReportSource = new File ("Y:\\ARCHIVES\\DEV\\WIZARD\\WIZARD_MONITORING_DATA\\FOR_MONITOR_DASHBOARD.txt");
			File wizReportTarget = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\FOR_MONITOR_DASHBOARD.TXT");
			copyFile(wizReportSource,wizReportTarget);
			File allLogsDone = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_DONE.CSV");
			allLogsDone.delete();
			File allLogs = new File ("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.TXT");
			allLogs.delete();
			File dailyDynamic = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DailyDynamic.bat");
			dailyDynamic.delete();
			
			File fileIndicatingDone = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\DONE_GETTING_LOGS.TXT");
			while(success==false)
			{
//				try
//				{
//					java.nio.channels.FileLock lock = in.getChannel().lock();
//					try
//					{
////						Reader reader = new InputStreamReader(in,charset);
//					}
//					finally
//					{
//						lock.release();
//						success=true;
//					}
//				}
//				finally
//				{
//					
//				}
				if(fileIndicatingDone.exists())
				{
					success=true;
				}
			}

			success=false;
			String[] cmdOne ={ "C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe","C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\ALL_LOGS_TO_ONE_CSV.yxmd" };
			runEachCommand = Runtime.getRuntime().exec(cmdOne);
			File fileAllLogsDone = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_DONE.CSV");
			while(success==false)
			{
				if(fileAllLogsDone.exists() )
				{
					success=true;
				}
			}
			success=false;
//			FileInputStream in = null;
			RandomAccessFile in = null;
			FileLock lock = null;
//			while(success==false)
//			{
//				try
//				{
//					in = new RandomAccessFile(fileAllLogsDone,"rw");
////					if(in.getChannel().lock() == true)
////					{
////						
////					}
////					java.nio.channels.FileLock lock = in.getChannel().lock();
//					try
//					{
////						while (in.read() != -1)
////						{
////							System.out.println(in.readLine());
////						}
//					}
//					catch (OverlappingFileLockException e)
//					{
//						
//					}
//					if( lock !=null)
//					{
//						lock.release();
//					}
////					channel.close();
//					
////					finally
////					{
////						lock.release();
////						success=true;
////					}
//				}
//				catch (Exception e)
//				{
//					
//				}
//			finally
//			{
//				in.close();
//			}
//				if(fileAllLogsDone.exists() )
//				{
////					success=true;
//				}
//			}
			success=false;
//			Runtime.getRuntime().exec("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\CREATE_DYNAMIC_DAILY_BAT.JAR");

//			processAllInOneFile();
			
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
			copyFile(sourceFullPath,targetFullPath);
			
			
			newFile = new FileWriter("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DailyDynamic.bat",false);
			newTextBuffer = new BufferedWriter(newFile);
			newTextPrinter = new PrintWriter(newTextBuffer);

//			strCMD="";
//			strCMD = strCMD + "COPY C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.CSV";
//			strCMD = strCMD + "  C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_HISTORY\\ALL_LOGS_"  + strPartOfFileNameForYesterday + ".TXT";
//			newTextPrinter.println(strCMD);

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
	public static void processAllInOneFile()
	{
		File allInOne = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS.TXT");
//		File allInOne = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_FOR_REPORT.TXT");
//		File allInOne = new File("C:\\DEV\\FEDE_BOM\\ALL_LOGS_FOR_REPORT.TXT");
//		File allInOne = new File("C:\\Users\\Public\\FEDEBOM\\LOGS\\BOMClient\\BomUIApplication_201710181448.log");
		Integer intKeyWordsFound=0;
		String strCurrentLogEntry=null;
		String strFoundKeyWord=null;
		String[] arrayKeyWord=null;
		String strCDSID=null;
		String constantCDSID = "BOM Application launched by";
		Boolean blnAllWordsFound=false;
		Boolean blnSuccess=false;
		Scanner scAllInOne;
		Integer intCDSIDfoundAt=0;
		try 
		{
			scAllInOne = new Scanner(allInOne);
			while(scAllInOne.hasNextLine())
			{
//				System.out.println(strCurrentLogEntry);
				if(strCurrentLogEntry != null)
				{
					if(strCurrentLogEntry.contains(constantCDSID) )
					{
						strCDSID=strCurrentLogEntry.substring(75, 82);
					}
				}
				strCurrentLogEntry=scAllInOne.nextLine();
				File keyWordMatrix = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\KEY_WORD_MATRIX.TXT");
//				File keyWordMatrix = new File("C:\\DEV\\FEDE_BOM\\KEY_WORD_MATRIX.TXT");
				String strTargetKeyWordOne=null;
				Scanner scTargetData;
				scTargetData = new Scanner(keyWordMatrix);
				while(scTargetData.hasNextLine())
				{
					blnAllWordsFound=false;
					intKeyWordsFound=0;
					strTargetKeyWordOne=scTargetData.nextLine();
					arrayKeyWord = strTargetKeyWordOne.split(",");
					String strBaseKeyWord=null;
					if(strCurrentLogEntry.contains(arrayKeyWord[0]))
					{
						strBaseKeyWord=arrayKeyWord[0];
						Integer intArrayRow=0;
							if(strCurrentLogEntry.contains(arrayKeyWord[3]) && strBaseKeyWord != arrayKeyWord[0])
							{
								blnSuccess=true;
							}
							intArrayRow = intArrayRow + 1;
						intKeyWordsFound=intKeyWordsFound+1;
//						System.out.println("Keyword " + arrayKeyWord[0] + " has been found in " + strCurrentLogEntry  );
						if(strCurrentLogEntry.contains(arrayKeyWord[1]))
						{
							System.out.println("Keywords " + arrayKeyWord[0] + " and " + arrayKeyWord[1] + " has been found in " + strCurrentLogEntry  );
							if(strCurrentLogEntry.contains(arrayKeyWord[2]))
							{
								System.out.println("thirs key word matches " + arrayKeyWord[0] + ", " + arrayKeyWord[1] + ", " + arrayKeyWord[2]);
								System.out.println(strCurrentLogEntry);
								if(arrayKeyWord[3] == null)
								{
									System.out.println("null found");
								}
								blnAllWordsFound=true;
								break;
							}
						}
					}
				}
				scTargetData.close();
				if(blnAllWordsFound==false && intKeyWordsFound > 0)
				{
					System.out.println("Only keyword " + arrayKeyWord[0] + " was found.  Need to update the keyword matrix " + strCurrentLogEntry);
				}
			}
			scAllInOne.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}