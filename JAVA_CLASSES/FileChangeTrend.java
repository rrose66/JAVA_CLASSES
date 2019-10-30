package dev.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileChangeTrend {

	public static void main(String[] args) {
		File fileAllFiles = new File("Y:\\DATA_MONITORING\\CHANGED_FILES.CSV");
		Scanner scFileList = null;
		String strCurrentEntry=null;
		String[] strArrayFileName;
		try 
		{
			scFileList = new Scanner(fileAllFiles);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strFullPath=null;
		strCurrentEntry=scFileList.nextLine();
		while(scFileList.hasNext())
		{
			strCurrentEntry=scFileList.nextLine();
			strArrayFileName=strCurrentEntry.split(",");
			strFullPath=strArrayFileName[1] + strArrayFileName[0];
			strFullPath.replace("\\", "\\\\");
			File fileCurrentFile = new File(strFullPath);
			Scanner scCurrentFile = null;
			try {
				scCurrentFile=new Scanner(fileCurrentFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(scCurrentFile.hasNextLine())
			{
				System.out.println(scCurrentFile.nextLine());
			}
			System.out.println(strCurrentEntry);
			scCurrentFile.close();
		}
		scFileList.close();

	}

}
