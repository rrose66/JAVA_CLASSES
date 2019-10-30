package ford.com.gather.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class GatherDataFromFiles {

	public static void main(String[] args) {
		String strCMD;
		int intRow=0;
		int intPingStart;
		int intLastLineOfPing;
		String strPassFail=null;
		boolean blnPingHasStarted = false;
		boolean blnInPingBlock=false;
		boolean blnInTraceBlock=false;
		String strURL = null;
		String strContent = null;
		String strLastContent = null;
		boolean blnHoldLastValue=false;
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		String strIPaddress=null;
		String strDateTimeFromFileName=null;
		int intStartOfDateStringInFileName=0;
		String strFileName=null;
		String outPutLine;
		int intSpeed=0;
//		String[] FILES = getTargetFiles(File "C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\PING_AND_TRACE_ROUTE_DATA");
		String strTargetDirectory="C:\\PROJECTS\\DATA\\PING_AND_TRACE_ROUTE_DATA";
		File dir = new File(strTargetDirectory);
//		System.out.println(dir);
		String[] strFileToOpen=dir.list();
		String strTargetFileFullPath=strTargetDirectory + "\\" + strFileToOpen[0];
//		System.out.println(strTargetFileFullPath);
		File file = new File(strTargetFileFullPath);
//		File file = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\PING_AND_TRACE_ROUTE_DATA\\PING_AND_ROUTE_DATA_201710090635.txt");
		strFileName=file.getName();
//		System.out.println(strTargetFileFullPath);
		intStartOfDateStringInFileName=getDateTimeFromFileName(strFileName);
		int intLengthOfFileName=strFileName.length();
		strDateTimeFromFileName=strFileName.substring(intStartOfDateStringInFileName,intLengthOfFileName-4);
//		System.out.println(strDateTimeFromFileName);
		try 
		{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				intRow = intRow + 1;
				blnHoldLastValue=true;
				strContent = sc.nextLine();
				System.out.println(strContent);
				if(strContent.contains("Pinging"))
				{
					intPingStart = intRow;
					blnPingHasStarted=true;
					strURL = strContent.substring(8, 22);
				}
				else
				{
					if(blnPingHasStarted)
					{	
						if(strContent.contains("Reply"))
						{
							strLastContent=strContent;
							System.out.println(strContent); 
							System.out.println(strLastContent); 
							intLastLineOfPing =intRow;
						}
						else if(strContent.contains("timed out"))
						{
							System.out.println(strContent);
							System.out.println(strLastContent);
							strIPaddress=getIPaddressAfterTimeout(strLastContent);
							blnPingHasStarted=false;
							try
							{
								newFile = new FileWriter("Y:\\DATA\\PING\\PingResponseHistory.txt",true);
								newTextBuffer = new BufferedWriter(newFile);
								newTextPrinter = new PrintWriter(newTextBuffer);
								strPassFail="TIMED_OUT";
								outPutLine = "\"" + strDateTimeFromFileName + "\",\"" + strIPaddress + "\",\"" + 10000 + "\",\"" + strPassFail + "\"";
								newTextPrinter.println(outPutLine);
								newTextPrinter.close();
							}
							catch (IOException allExceptions)
							{
								allExceptions.printStackTrace();
							}
						}
						else
						{
							System.out.println(strContent);
							System.out.println(strLastContent);
							blnPingHasStarted=false;
							blnHoldLastValue=false;
/*
							FileWriter newFile = null;
							BufferedWriter newTextBuffer = null;
							PrintWriter newTextPrinter = null;
							String outPutLine;
*/
							int intPingResponse=0;
							intPingResponse = getPingResponse(strLastContent);
//							String strIPaddress;
							strIPaddress=getIPaddress(strLastContent);
							strPassFail="PASSED_IN_LIMITS";
							try
							{
								newFile = new FileWriter("Y:\\DATA\\PING\\PingResponseHistory.txt",true);
								newTextBuffer = new BufferedWriter(newFile);
								newTextPrinter = new PrintWriter(newTextBuffer);
								outPutLine = "\"" + strDateTimeFromFileName + "\",\"" + strIPaddress + "\",\"" + intPingResponse + "\",\"" + strPassFail  + "\"";
								newTextPrinter.println(outPutLine);
								newTextPrinter.close();
							}
							catch (IOException allExceptions)
							{
								allExceptions.printStackTrace();
							}
						}
					}
				}
				if(strContent.contains("Tracing"))
				{
					blnInTraceBlock=true;
					strContent=sc.nextLine();
					strContent=sc.nextLine();
					System.out.println(strContent);
					strLastContent=strContent;
				}
				else
				{
					if(blnInTraceBlock==true)
					{
						System.out.println(strContent);
						String[] strTraceArray;
						strTraceArray=strContent.split(" ");
						String strIP_Address;
						strIP_Address=strTraceArray[23];
						strIP_Address=strIP_Address.replace("[", "");
						strIP_Address=strIP_Address.replace("]", "");
						strIP_Address=strIP_Address.trim();
						strPassFail="PASS_WITHIN_LIMITS";
						if(strTraceArray[2].trim().isEmpty())
						{
							
						}
						else
						{
						try
						{
						newFile = new FileWriter("Y:\\DATA\\PING\\TraceHistory.txt",true);
						newTextBuffer = new BufferedWriter(newFile);
						newTextPrinter = new PrintWriter(newTextBuffer);
						outPutLine = "\"" +strDateTimeFromFileName + "\",\"" + strTraceArray[2] + "\",\"" + strTraceArray[19] + "\",\"" + strIP_Address + "\",\""+ strPassFail + "\"";
						newTextPrinter.println(outPutLine);
						newTextPrinter.close();
						}
						catch (IOException allExceptions)
						{
							allExceptions.printStackTrace();
						}
						}
					}
				}
			}
			sc.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int getPingResponse(String strLastContent)
	{
//		System.out.println(strLastContent);
		int intStartOfResponse=0;
		String[] strArray;
		String[] strTimeArray;
		strArray=strLastContent.split(" ");
		String strTimeEntry=strArray[4];
		strTimeArray=strTimeEntry.split("=");
		String strTime;
		int intLengthOfstrTime=strTimeArray[1].length()-2;
		strTime=strTimeArray[1].substring(0, intLengthOfstrTime);
		int intPingMilliseconds=Integer.parseInt(strTime);
		return intPingMilliseconds;
	}
	public static String getIPaddress(String strLastContent)
	{
		System.out.println(strLastContent);
		String strIPaddress=null;
		String[] strArray;
		String[] strTimeArray;
		strArray=strLastContent.split(" ");
		String strTimeEntry=strArray[2];
		strIPaddress=strTimeEntry.replace(":", "");
		return strIPaddress.trim();
	}
	public static String getIPaddressAfterTimeout(String strLastContent)
	{
		System.out.println(strLastContent);
		String strIPaddress=null;
		String[] strArray;
		String[] strTimeArray;
		strArray=strLastContent.split(" ");
		String strTimeEntry=strArray[2];
		strIPaddress=strTimeEntry.replace(":", "");
		return strIPaddress.trim();
	}
	public static int getDateTimeFromFileName(String strFileName)
	{
		System.out.println(strFileName);
		int intCharWhereDateTimeStarts = 0;
		char firstChar;
		for(int intChar=1 ; (intChar<=strFileName.length()) ; intChar++)
		{
			firstChar=strFileName.charAt(intChar);
			if(Character.isDigit(firstChar))
			{
				intCharWhereDateTimeStarts= intChar;
				break;
			}
		}
		return intCharWhereDateTimeStarts;
	}
}
