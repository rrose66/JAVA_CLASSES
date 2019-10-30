package misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ETL_AccuRev_WIP {

	public static void main(String[] args) {
		File input = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\ACCUREV_WIP.TXT");
		String inputData=null;
		String strInputLineTwo=null;
		String[] aryFullPath=null;
		String strObjectNameOnly=null;
		String strDir=null;
		String strUserWorkSteam=null;
		Integer intArrayPosi=null;
		Boolean blnHeader=false;
		FileWriter newFile = null;
		try 
		{
			newFile = new FileWriter("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\ACCU_REV_WIP.TXT",false);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		BufferedWriter newTextBuffer = new BufferedWriter(newFile);
		PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
		try
		{
			Scanner sc = new Scanner(input);
			sc.nextLine();
			newTextPrinter.println("RelativePath,WorkStreamName,ObjectName");
			while (sc.hasNextLine())
			{
				inputData=sc.nextLine();
				System.out.println(inputData);
//				strInputLineTwo=sc.nextLine();
				if(inputData.contains("\\"))
				{
					strDir=inputData;
					intArrayPosi = inputData.lastIndexOf("\\");
					strObjectNameOnly = inputData.substring(intArrayPosi + 1);
					blnHeader=true;
				}
				else
				{
					if(blnHeader)
					{
						newTextPrinter.println(strDir + "," + inputData + "," + strObjectNameOnly);
//						blnHeader=false;
					}
				}
//				intArrayPosi = strInputLineTwo.lastIndexOf("\\");
//				strObjectNameOnly = strInputLineTwo.substring(intArrayPosi + 1);
//				aryFullPath = strInputLineTwo.split("\\");
//				strObjectNameOnly=aryFullPath[aryFullPath.length];
//				for(Integer i=1;i < strInputLineTwo.length();i++)
//				{
////					strObjectNameOnly=strInputLineTwo.lastIndexOf(strInputLineTwo);
//				}
//				newTextPrinter.println(inputData + "," + strInputLineTwo + "," + strObjectNameOnly);
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
