package del.rename.move;

import java.io.File;

public class DeleteThisFile 
{
	public static void main(String strFullPath) 
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
