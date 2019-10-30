package etl;

import java.io.File;
import java.io.IOException;

public class FindUpdatedFilesAndRecord 
{
	public static void main(String[] args) 
	{
		Process runProcess;
		String strStartAlteryx="C:\\Program Files\\Alteryx\\bin\\AlteryxEngineCmd.exe";
		String[] cmd03 = {strStartAlteryx, "C:\\PROJECTS\\GitHub\\FEDEBOM\\BOMinFEDE_v1.0_Collab_DEV_FILE_LIST_FULLPATHS.yxmd"};
		try 
		{
			DeleteThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\AccuRev\\AccuRevIncomingFiles\\AccuRevIncomingProcessingDone.csv");
			runProcess = Runtime.getRuntime().exec(cmd03);
			WaitUntilThisFileIsWritable("C:\\PROJECTS\\DATA\\FEDEBOM\\AccuRev\\AccuRevIncomingFiles\\AccuRevIncomingProcessingDone.csv");
//				WaitThisLong(5000);
			String[] cmd01 = {strStartAlteryx, "C:\\PROJECTS\\GitHub\\FEDEBOM\\ACCUREV_INCOMING_FILES.yxmd"};
			runProcess = Runtime.getRuntime().exec(cmd01);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}
	public static void WaitUntilThisFileIsWritable(String strFullPath)
	{
		Boolean blnReadyToContinue=false;
		while(blnReadyToContinue==false)
		{
			File f = new File(strFullPath);
			try 
			{
				Thread.sleep(6000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(f.canWrite())
			{
				blnReadyToContinue=true;
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
		while(blnReadyToContinue==false)
		{
			if(fileToDelete.exists())
			{
				try 
				{
					Thread.sleep(6000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				blnReadyToContinue=true;
			}
		}
	}
}
