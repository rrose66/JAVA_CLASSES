package dev.misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ParseMPNR 
{
	public static void main(String[] args) 
	{
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		String strInput=null;
		File file = new File("C:\\Users\\rrose66\\bom\\BomInputs\\ClientJsonCache\\MPNRJson.json");
		try 
		{
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine())
			{
				strInput=sc.nextLine();
				System.out.println(strInput);
				if (strInput.contains("suffix"))
				{
					System.out.println(strInput);
					
				}
			}
			sc.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newTextBuffer = new BufferedWriter(newFile);
		newTextPrinter = new PrintWriter(newTextBuffer);

//		C:\Users\rrose66\bom\BomInputs\ClientJsonCache

	}

}
