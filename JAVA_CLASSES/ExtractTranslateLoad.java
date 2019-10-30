package dev.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtractTranslateLoad {
	public static void main(String[] args) {
		File allInOne = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\ALL_LOGS_FOR_REPORT.TXT");
		String strCurrentLogEntry=null;
		String strFoundKeyWord=null;
		String[] arrayKeyWord=null;
		Scanner scAllInOne;
		try 
		{
			scAllInOne = new Scanner(allInOne);
			while(scAllInOne.hasNextLine())
			{
				System.out.println(strCurrentLogEntry);
				strCurrentLogEntry=scAllInOne.nextLine();
				File keyWordMatrix = new File("C:\\DEV\\FEDE_BOM\\SERVER_MONITORING\\DATA\\KEY_WORD_MATRIX.TXT");
				String strTargetKeyWordOne=null;
				Scanner scTargetData;
				scTargetData = new Scanner(keyWordMatrix);
				while(scTargetData.hasNextLine())
				{
					strTargetKeyWordOne=scTargetData.nextLine();
					arrayKeyWord = strTargetKeyWordOne.split(",");
					if(strCurrentLogEntry.contains(arrayKeyWord[0]))
					{
						System.out.println("Keyword " + arrayKeyWord[0] + " has been found in " + strCurrentLogEntry  );
						if(strCurrentLogEntry.contains(arrayKeyWord[1]))
						{
							System.out.println("Keywords " + arrayKeyWord[0] + " and " + arrayKeyWord[1] + " has been found in " + strCurrentLogEntry  );
							
						}
						else
						{
							System.out.println("Only keyword 0 was found.  Need to update the keyword matrix");
						}
					}
				}
				scTargetData.close();
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
