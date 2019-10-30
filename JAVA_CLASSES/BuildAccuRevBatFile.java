package misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BuildAccuRevBatFile 
{
	public static void main(String[] args) 
	{
		File input = new File("C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\FEDE_DIRS.csv");
		String inputData=null;
		FileWriter newFile = null;
		try 
		{
			newFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\GetFileListFromAccuRev.bat",false);
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
			while (sc.hasNextLine())
			{
				inputData=sc.nextLine();
				newTextPrinter.println("cd " + inputData.substring(0, inputData.length() -1));
				newTextPrinter.println("accuRev files >> C:\\PROJECTS\\DATA\\FILES_INDICATING_END_OF_PROCESS\\AccuRevFiles.txt");
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
