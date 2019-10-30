package dev.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseLog {

	public static void main(String[] args) {
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
			File keyWordMatrix = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\KEY_WORD_MATRIX.TXT");
//			File keyWordMatrix = new File("C:\\DEV\\FEDE_BOM\\KEY_WORD_MATRIX.TXT");
			String strTargetKeyWordOne=null;
			Scanner scTargetData;
			scTargetData = new Scanner(keyWordMatrix);
			String[] arrayOfKeyWordLine;
			String strCurrentGroup=null;
			String strLog=null;
			String strTargetGroup="";
			Integer intRow=0;
			Integer intUniqueGroups=0;
			strLog=scTargetData.nextLine();
			String[] arrayOfKeyWordGroups = null;
			//determine how many unique groups of key words there are
			while(scTargetData.hasNextLine())
			{
				strLog=scTargetData.nextLine();
				arrayOfKeyWordLine=strLog.split(",");
				strCurrentGroup=arrayOfKeyWordLine[1];
				if(strTargetGroup.equals(strCurrentGroup))
				{
				}
				else
				{
					strTargetGroup=strCurrentGroup;
//					arrayOfKeyWordGroups[intUniqueGroups]=strCurrentGroup;
					intUniqueGroups=intUniqueGroups+1;
				}
//				arrayOfKeyWordGroups[intRow]=strCurrentGroup;
				intRow = intRow + 1;
			}
			scTargetData.close();
			String[] strArrayOfGroups = new String[intUniqueGroups];
			intUniqueGroups=0;
			Scanner scKeyWordArrayData;
			scKeyWordArrayData = new Scanner(keyWordMatrix);
			strLog=scKeyWordArrayData.nextLine();
			//Build keyword array
			while(scKeyWordArrayData.hasNextLine())
			{
				strLog=scKeyWordArrayData.nextLine();
				arrayOfKeyWordLine=strLog.split(",");
				strCurrentGroup=arrayOfKeyWordLine[1];
				if(strTargetGroup.equals(strCurrentGroup))
				{
				}
				else
				{
					strTargetGroup=strCurrentGroup;
					strArrayOfGroups[intUniqueGroups]=strCurrentGroup;
					intUniqueGroups=intUniqueGroups+1;
				}
//				arrayOfKeyWordGroups[intRow]=strCurrentGroup;
				intRow = intRow + 1;
			}
			scKeyWordArrayData.close();
			scAllInOne = new Scanner(allInOne);
			while(scAllInOne.hasNextLine())
			{
				if(strCurrentLogEntry != null)
				{
					if(strCurrentLogEntry.contains(constantCDSID) )
					{
						strCDSID=strCurrentLogEntry.substring(75, 82);
					}
				}
				strCurrentLogEntry=scAllInOne.nextLine();
//				System.out.println(strCurrentLogEntry);
				
				Integer intTargetWord=0;
				Scanner scKeyWordGroupData;
				scKeyWordGroupData = new Scanner(keyWordMatrix);
				strTargetKeyWordOne=scKeyWordGroupData.nextLine();
				//Search for key words in log
				
				for(int i=0;i < strArrayOfGroups.length;i++)
				{
					
					String[] strArrayCurrentKeyWord=null;
					
					while(scKeyWordGroupData.hasNextLine())
					{/*
						strTargetKeyWordOne=scKeyWordGroupData.nextLine();
						System.out.println(strCurrentLogEntry);
//						System.out.println(strArrayOfGroups[3]);
//						System.out.println(strTargetKeyWordOne);
						System.out.println(strArrayOfGroups[i]);
						if(strTargetKeyWordOne.equals(strArrayOfGroups[i]))
						{
							System.out.println(strCurrentLogEntry);
							System.out.println(strArrayOfGroups[i]);
							String[] strArrayKeyWord = strTargetKeyWordOne.split(",");
							System.out.println(strArrayKeyWord[0]);
							System.out.println(strArrayKeyWord[1]);
							System.out.println(strArrayKeyWord[2]);
							System.out.println(strArrayKeyWord[3]);
							if(strCurrentLogEntry.contains(strArrayKeyWord[0]))
							{
								System.out.println("Found one key word in the array");
								if(strCurrentLogEntry.contains(strArrayKeyWord[1]))
								{
									System.out.println("Found second key word in the array");
									if(strCurrentLogEntry.contains(strArrayKeyWord[3]))
									{
										System.out.println("Found third key word in the array");
									}
								}
							}
//							strTargetKeyWordOne=scKeyWordGroupData.nextLine();
						}
						else
						{
//							strTargetKeyWordOne=scKeyWordGroupData.nextLine();
						}
					*/}
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
