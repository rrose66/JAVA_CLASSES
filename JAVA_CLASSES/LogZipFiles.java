package renameAndMove;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class LogZipFiles 
{
	public static void main(String[] args) 
	{
		String strMsg="";
		String strPageLink="";
		String strPageLink1="";
		int intDialogButton=0;
		final String strMove="move /Y \"";

//		strPageLink="Default";
//		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
//		strMsg="There should be no tcbom.zip file in the download folder";
//		strMsg=strMsg + "Before Clicking Yes";
//		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
//		strMsg=strMsg + "\n Then select all check boxes for logs only";
//		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
//		if(intDialogButton == 0)
//		{
//			String strCMD=null;
//			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//			String strScannedToday=GetStringTodayYYYYMMDD();
//			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
//			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip");
//			FileWriter batFile=null;
//			try 
//			{
//				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
//				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
//				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			} 
//			catch (IOException e1) 
//			{
//				e1.printStackTrace();
//			}
//			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
//			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD="move /Y \"";
//			strCMD = strCMD + sourceDir;
//			strCMD = strCMD + "\", \"";
//			strCMD = strCMD + targetDir;
//			newTextPrinter.println(strCMD);
//			strCMD="";
//			newTextPrinter.close();
//			java.lang.Process runProcess;
//			try 
//			{
//				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//		}


		
		strPageLink="Default";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		strPageLink="Adapter Tool";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		
		
		strPageLink="ExtAppsIntg_FEDESync";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the ExtAppsIntg link";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		

		strPageLink="ExtAppsIntg_Incremental";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the ExtAppsIntg link";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}


		strPageLink="ExtAppsIntg_Service";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the ExtAppsIntg link";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		
		strPageLink="Scheduler";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		strPageLink="TCAsync";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		strPageLink="TCAsync_Backup_Latest";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		strPageLink="TCAsync_FBLDomain";
		intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		strMsg="There should be no tcbom.zip file in the download folder";
		strMsg=strMsg + "Before Clicking Yes";
		strMsg=strMsg + "\n Navigate to the " + strPageLink + " link";
		strMsg=strMsg + "\n Then select all check boxes for logs only";
		intDialogButton=JOptionPane.showConfirmDialog(null, strMsg,"Process the tcbomLOGS.zip from " + strPageLink + " page?",intDialogButton);
		if(intDialogButton == 0)
		{
			String strCMD=null;
			DeleteThisFile("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			String strScannedToday=GetStringTodayYYYYMMDD();
			File sourceDir = new File("C:\\Users\\rrose66\\Downloads\\tcbomLOGS.zip");
			File targetDir = new File("Y:\\ARCHIVES\\FEDEBOM_DASHBOARD\\tcbomLOGS_" + strPageLink + "_ "+ strScannedToday + ".zip\"");
			FileWriter batFile=null;
			try 
			{
				batFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat",false);
				BufferedWriter newTextBuffer = new BufferedWriter(batFile);
				PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			BufferedWriter newTextBuffer = new BufferedWriter(batFile);
			PrintWriter newTextPrinter = new PrintWriter(newTextBuffer);
//			strCMD=strMove;
			strCMD = strMove + sourceDir;
			strCMD = strCMD + "\", \"";
			strCMD = strCMD + targetDir;
			newTextPrinter.println(strCMD);
			strCMD="";
			newTextPrinter.close();
			java.lang.Process runProcess;
			try 
			{
				runProcess = Runtime.getRuntime().exec("C:\\PROJECTS\\EXECUTABLES\\Dynamic.bat");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public static void DeleteThisFile(String strFullPath)
	{
		Boolean blnReadyToContinue=false;
		File fileToDelete = new File(strFullPath);
		if(fileToDelete.exists())
		{
			fileToDelete.delete();
		}
	}
	public static String GetStringTodayYYYYMMDD()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}

}
