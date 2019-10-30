package misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ETL_HelpInfo 
{
	public static void main(String[] args) 
	{
		File input = new File("C:\\PROJECTS\\DATA\\HELP_INFO\\STAGGING\\HelpInfo - WGC1105CYLNN2.TXT");
		String inputData=null;
		String strInputLineTwo=null;
		String[] aryFullPath=null;
		String strObjectNameOnly=null;
		String strDir=null;
		String strUserWorkSteam=null;
		Integer intArrayPosi=null;
		Boolean blnHeader=false;
		Boolean blnKeepGoing=false;
		Boolean blnDateFound=false;
		String strWS=null;
		String strCDSID=null;
		String strSCANNED=null;
		String strDomain=null;
		String strClientType=null;
		String strHD_FREE_SPACE=null;
		String strRam=null;
		String strOS=null;
		String strInstalledHotFix=null;
		String strCMD=null;
		String[] aryKB=null;
		FileWriter newFile = null;
		try 
		{
			newFile = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\HELP_INFO_ACCUM.TXT",true);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		BufferedWriter newTextBuffer = new BufferedWriter(newFile);
		PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
		try
		{
			newTextPrinter.println("");
			Scanner sc = new Scanner(input);
			sc.nextLine();
//			newTextPrinter.println("WS,SCANNED,CDSID,DOMAIN,CLIENT_TYPE,HD_FREE_SPACE,RAM,OS,INSTALLED_HOT_FIXES,KB,FOCUS");
			while (sc.hasNextLine())
			{
				inputData=sc.nextLine();
				if (inputData.isEmpty())
				{
					
				}
				else
				{
					
				System.out.println(inputData);
				if(inputData.contains("Information for:"))
				{
					strWS=inputData.substring(17, inputData.length());
				}
				if(inputData.contains("Date:") && blnDateFound==false)
				{
					strSCANNED=inputData.substring(6, 17);
					blnDateFound=true;
				}
				if(inputData.contains("CDSID:"))
				{
//					strCDSID=inputData.substring(7, 14);
					strCDSID=inputData.substring(7, inputData.length());
				}
				if(inputData.contains("Domain (User):"))
				{
					strDomain=inputData.substring(15, inputData.length());
				}
				if(inputData.contains("Client Type:"))
				{
					strClientType=inputData.substring(13, inputData.length());
				}
				if(inputData.contains("HD Free Space:"))
				{
					strHD_FREE_SPACE=inputData.substring(15, inputData.length());
				}
				if(inputData.contains("RAM:"))
				{
					strRam=inputData.substring(5, inputData.length());
				}
				if(inputData.contains("Version (OS):"))
				{
					strOS=inputData.substring(14, inputData.length());
				}
				if(inputData.contains("Installed HotFixes"))
				{
					blnKeepGoing=true;
					inputData=sc.nextLine();
				}
				if(blnKeepGoing)
				{
					strInstalledHotFix=inputData;
					strCMD=strWS + ",";
					strCMD = strCMD + strSCANNED + ",";
					strCMD = strCMD + strCDSID + ",";
					strCMD = strCMD + strDomain + ",";
					strCMD = strCMD + strClientType + ",";
					strCMD = strCMD + strHD_FREE_SPACE + ",";
					strCMD = strCMD + strRam + ",";
					strCMD = strCMD + strOS + ",";
					strCMD = strCMD + strInstalledHotFix + ",";
					strCMD = strCMD + strInstalledHotFix.substring(strInstalledHotFix.indexOf("KB"),strInstalledHotFix.indexOf("KB")+9) + ",";
					if(strInstalledHotFix.contains("Security Update for Microsoft Excel 2016"))
					{
						strCMD = strCMD + "Excel 2016";
					}
					else if(strInstalledHotFix.contains("Internet Explorer 11"))
					{
						strCMD = strCMD + "Internet Explorer 11";
					}
					else if(strInstalledHotFix.contains("Excel 2010"))
					{
						strCMD = strCMD + "Excel 2010";
					}
					else if(strInstalledHotFix.contains("Office 2010"))
					{
						strCMD = strCMD + "Office 2010";
					}
					else if(strInstalledHotFix.contains("Office 2016"))
					{
						strCMD = strCMD + "Office 2016";
					}
					else
					{
						strCMD = strCMD + "";
					}
					
//					System.out.println(strCMD);
					newTextPrinter.println(strCMD);
				}
				}
				inputData="";
				strInputLineTwo="";
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		newTextPrinter.close();
	

	}

}
