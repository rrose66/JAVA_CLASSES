package misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;


public class ListWizErrFiles {

	public static void main(String[] args) 
	{
  		
		FileWriter fw = null;
  		BufferedWriter bw = null;
  		PrintWriter out = null;
		
		String strCDSID=null;
		String strFileName=null;
		String strInput=null;
		Boolean blnFound=false;
      String first = "I:\\WizDevErrLogs\\";
      File buildLibs = new File(first);
      File[] listOfBuildLibs = buildLibs.listFiles();
      for (File file : listOfBuildLibs)
      {
    	  System.out.println(file);
    	  strFileName=file.getName();
    	  String[] aryFileName = strFileName.split("-");
    	  System.out.println(aryFileName[0]);
    	  System.out.println(aryFileName[1]);
    	  System.out.println(aryFileName[2]);
    	  strCDSID=aryFileName[2];
    	  System.out.println(aryFileName[3]);
      		File fileRequests = new File("C:\\PROJECTS\\DATA\\WIZ_ERRORS\\requests.txt");
    		Scanner sc = null;
    		try 
    		{
    			sc = new Scanner(fileRequests);
    		} 
    		catch (FileNotFoundException e) 
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		while(sc.hasNextLine())
    		{
    			strInput=sc.nextLine();
    			System.out.println(strInput);
    			if(strCDSID.equals(strInput))
				{
    				System.out.println("Request has already been created for " + strInput);
    				blnFound=true;
				}
    			else
    			{
    				System.out.println("Create request");
    			}
    		}
    		sc.close();
    	  if(blnFound=true)
    	  {
    		  blnFound=false;
    	  }
    	  else
    	  {
    			int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
    			intDialogButton=JOptionPane.showConfirmDialog(null, "If the file can be opened and a request created select yes to update.",null, intDialogButton);

    	  		try
    	  		{
    	  			fw = new FileWriter("C:\\PROJECTS\\DATA\\WIZ_ERRORS\\requests.txt",true);
    	  			bw = new BufferedWriter(fw);
    	  			out = new PrintWriter(bw);
    	  			out.println(strCDSID);
    	  			out.close();
    	  		}
    	  		catch (IOException e)
    	  		{
    	  			System.out.println(e);
    	  		}
    		  
    	  }
      }
	}
//	@Override
//	public void apply(Project target)
//	{
//		target.task("javaTask");
//	}
}
