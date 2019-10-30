package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuildListOfModifiedFilesInAccuRev 
{

	public static void main(String[] args) 
	{
		File input = new File("C:\\PROJECTS\\DATA\\FEDE_DIRS.CSV");
		String inputData=null;
		try
		{
			Scanner sc = new Scanner(input);
			while (sc.hasNextLine())
			{
				inputData=sc.nextLine();
				System.out.println(inputData);
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
