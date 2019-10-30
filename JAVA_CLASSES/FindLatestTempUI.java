package misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FindLatestTempUI 
{
	public static void main(String[] args) 
	{
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		
		String strCDSID=null;
		String strCMD=null;
		String strFileName=null;
		String strFEDEBOM=null;
		String strInput=null;
		String[] aryVersionPicker=null;
		Integer intLength=0;
		Integer intShortFileNameLength=0;
		String strLast4=null;
		String strNew=null;
		double doubleLast4=0;
		double doubleCurrent=0;
		Boolean blnFound=false;
		Boolean blnFirst=false;
	    String first = "C:\\temp\\FEDEBOM_UI\\";
		File buildLibs = new File(first);
		File[] listOfBuildLibs = buildLibs.listFiles();
		System.out.println(listOfBuildLibs.length);
		for (File file : listOfBuildLibs)
		{
		   System.out.println(file);
		   strFileName=file.getName();
		   strFEDEBOM=strFileName.substring(0,4);
		   System.out.println(strFEDEBOM);
		   System.out.println(strFileName);
		   System.out.println(strFEDEBOM.length());
		   intShortFileNameLength = strFileName.length();
		   if(intShortFileNameLength == 4)
		   {
			   
		   }
		   else
		   {
			   strFileName=strFileName.substring(7,strFileName.length());
			   if(!strFileName.isEmpty())
			   {
				   System.out.println(strFileName);
				   doubleLast4 = Double.parseDouble(strFileName);
				   if(blnFirst==false)
				   {
					   blnFirst=true;
					   doubleCurrent = doubleLast4;
				   }
				   else
				   {
					   if(doubleCurrent < doubleLast4)
					   {
						   doubleCurrent = doubleLast4;
					   }
				   }
				   System.out.println(doubleLast4);
			   }
		   }
		}
		try
		{
//		File fileToDelete = new File("C:\\temp\\FEDEBOM_UI\\FEDEBOM " + doubleLast4);
//		create a dynamic bat file then execute it
		FileWriter newFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\DEL_LATEST_TEMP_UI_DIR.bat",false);
		BufferedWriter newTextBuffer = new BufferedWriter(newFile);
		PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
		strCMD="";
		strCMD = strCMD + "RMDIR /Q/S " + '"' + "C:\\temp\\FEDEBOM_UI\\FEDEBOM " + doubleLast4 + '"';
		newTextPrinter.println(strCMD);
		newTextPrinter.close();
		
	}
	catch (IOException allExceptions)
	{
		allExceptions.printStackTrace();
	}

//		fileToDelete.delete();
	}
}
