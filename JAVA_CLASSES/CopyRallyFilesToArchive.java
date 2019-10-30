package src.file.management;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyRallyFilesToArchive 
{
	public static void main(String[] args) 
	{
		String strFileExtensionSource=null;
		String strFileExtensionTarget="csv";
		String strSourceFullPath="C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\";
		String strFolderName=GetStringTodayYYYYMMDD();
		String strTargetFullPath="Y:\\ARCHIVES\\FEDEBOM_RALLY_EXTRACTS\\" + strFolderName + "\\";
		File dir = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\");
		File[] listFiles = dir.listFiles();
		String[] aryFullPath=null;
		for(File file : listFiles)
		{
			System.out.println(file.getName());
			aryFullPath=file.getName().split("\\.");
			strFileExtensionSource=aryFullPath[1];
			File srcFile = new File(strSourceFullPath+file.getName());
			File destFile = new File(strTargetFullPath+file.getName());
			if (strFileExtensionSource.equals(strFileExtensionTarget))
			{
//				srcFile=file.getAbsoluteFile();
//				destFile=strTargetFullPath+file.getName();
				try 
				{
					copyFile(srcFile,destFile);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
//				CopyOption[] options = new CopyOption[] {StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES};
//				java.nio.file.Files.copy(strSourceFullPath, strTargetFullPath);
				
//				RenameThisFile("C:\\PROJECTS\\DATA\\FEDEBOM\\RALLY\\" + file.getName(),"Y:\\ARCHIVES\\FEDEBOM_RALLY_EXTRACTS\\" + strFolderName + "\\" + file.getName());
			}
		}		
	}
	private static  void copyFile(File srcFile, File destFile) throws IOException 
    {
            InputStream oInStream = new FileInputStream(srcFile);
            OutputStream oOutStream = new FileOutputStream(destFile);

            // Transfer bytes from in to out
            byte[] oBytes = new byte[1024];
            int nLength;
            BufferedInputStream oBuffInputStream = 
                            new BufferedInputStream( oInStream );
            while ((nLength = oBuffInputStream.read(oBytes)) > 0) 
            {
                oOutStream.write(oBytes, 0, nLength);
            }
            oInStream.close();
            oOutStream.close();
    }
	public static String GetStringTodayYYYYMMDD()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}
	public static void RenameThisFile(String strFileSource, String strFileDestination)
	{
		File fileSource = new File(strFileSource);
		File fileDestination = new File(strFileDestination);
		if(fileSource.exists())
		{
			fileSource.renameTo(fileDestination);
		}
	}

}
