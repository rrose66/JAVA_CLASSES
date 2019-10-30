package ws.health;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class HealthChecker 
{
	public static void main(String[] args) 
	{
		System.getProperties();
		System.out.println("Java Home: "+ System.getProperty("java.home"));
		System.out.println("Java library path: "+ System.getProperty("java.library.path"));
		System.out.println("Java class path: "+ System.getProperty("java.class.path"));
		System.out.println("Java ext dir: "+ System.getProperty("java.ext.dirs"));
		System.out.println("Java version: "+ System.getProperty("java.version"));
		System.out.println("Java runtime version: "+ System.getProperty("java.runtime.version"));
		System.out.println("Java file separator: "+ System.getProperty("file.separator"));
		System.out.println("Java Path Separator: "+ System.getProperty("path.separator"));
		System.out.println("Java Line Separator: "+ System.getProperty("line.separator"));
		System.out.println("Java User Name: "+ System.getProperty("user.name"));
		System.out.println("Java User Home: "+ System.getProperty("user.home"));
		System.out.println("Java User Dir: "+ System.getProperty("user.dir"));
		System.out.println("Java OS Name: "+ System.getProperty("os.name"));
		System.out.println("Java OS Version: "+ System.getProperty("os.version"));
		System.out.println("Java OS Arch: "+ System.getProperty("os.arch"));
		System.out.println(" Free Memory: " + Runtime.getRuntime().freeMemory());
		System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory());
		System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory());
		System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
		File fileRoot = new File("/");
		System.out.println("Free Space: " + fileRoot.getFreeSpace());
//		System.out.println(": " + FileSystemUtils.freeSpacekb("/"));
//		FileStore store = null;
//		try 
//		{
//			store = Files.getFileStore((java.nio.file.Path) FileSystems.getDefault().getRootDirectories());
//			System.out.println("Available Disk Space: " + store.getUsableSpace());
//			System.out.println("Total Disk Space: " + store.getTotalSpace());
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
	}
}
