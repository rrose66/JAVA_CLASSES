package Excel_IE_Config;
//Java program to change registry keys that declare Excel settings

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author NKILPAT1 
 *	executing commands on cmd prompt
 *	@author MALYASS
 *	getting reg values before/after commands execute
 *	output results/log to text file
 *	adding additional excel settings
 *	adding internet and security settings
 *	changed regkey class to handle strings and ints
 */
public class Cmd {
	
	//Registry Hive down to the Microsoft Office 16 location
	//Base for all sub hives that the Excel settings I've found are in
	static String office16 = "HKEY_CURRENT_USER\\Software\\Microsoft\\Office\\16.0";
	static String officeSecurity = "HKEY_CURRENT_USER\\Software\\Microsoft\\Office\\Common\\Security";
	static String security = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones";
	static String associations = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\Shell\\Associations\\UrlAssociations\\https\\UserChoice";
	static String shell = "HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\Shell\\Associations\\UrlAssociations";
	static String explorer = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\FileExts";

	
	//Save the Reg_DWORD value type for easy access
	static String dWord = "REG_DWORD";		
	
	//Collection for Registry Keys
	static ArrayList<RegKey> keys = new ArrayList<RegKey>();
	static ArrayList<RegKey> keys2 = new ArrayList<RegKey>();
	static ArrayList<RegKey> keys3 = new ArrayList<RegKey>();
	static ArrayList<RegKey> keys4 = new ArrayList<RegKey>();
	
	//Used to fill in text commands for debugging
	public static String command1="";

	public static void main(String[] args) {	
		//add all keys corresponding to needed settings
		addRegKeys();
		
		//add all registry values prior to changes to the keys
		for (RegKey key : keys) {
			String value = WinRegistry.readRegistry(key.getLocation(), key.getValueName());
			key.setRegBefore(value.replace("\n", "").replace("\r", ""));
		}
		for (RegKey key : keys2) {
			String value = WinRegistry.readRegistry(key.getLocation(), key.getValueName());
			key.setRegBefore(value.replace("\n", "").replace("\r", ""));
		}
		for (RegKey key : keys3) {
			String value = WinRegistry.readRegistry(key.getLocation(), key.getValueName());
			key.setRegBefore(value.replace("\n", "").replace("\r", ""));
		}
		for (RegKey key : keys4) {
			String value = WinRegistry.readRegistry(key.getLocation(), key.getValueName());
			key.setRegBefore(value.replace("\n", "").replace("\r", ""));
		}
		
		//converts all keys into a String of commands to give to the Command Line
		String commands = keysToCMD(keys);
		String commands2 = keysToCMD(keys2);
		String commands3 = keysToCMD(keys3);
		String commands4 = keysToCMD(keys4);
		
		//abstracted out to more easily turn exit on and off for testing
		String exit = " && exit";
		//exit = "";
		
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd /c start cmd.exe /K " + "\""  + commands + " timeout 0" + exit + "\"");
			
		} catch (Exception e) {
			System.out.println("Exception Error: ");
			e.printStackTrace();
		}
		
		try {
			runtime.exec("cmd /c start cmd.exe /K " + "\""  + commands2 + " timeout 0" + exit + "\"");
			
		} catch (Exception e) {
			System.out.println("Exception Error: ");
			e.printStackTrace();
		}
		
		try {
			runtime.exec("cmd /c start cmd.exe /K " + "\""  + commands3 + " timeout 0" + exit + "\"");
			
		} catch (Exception e) {
			System.out.println("Exception Error: ");
			e.printStackTrace();
		}
		try {
			runtime.exec("cmd /c start cmd.exe /K " + "\""  + commands4 + " timeout 0" + exit + "\"");
			
		} catch (Exception e) {
			System.out.println("Exception Error: ");
			e.printStackTrace();
		}
		
		
		
		
		//wait for changes to save
		try{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}
		
		//get all reg key values after the change
		for (RegKey key : keys) {
			String value = WinRegistry.readRegistry(key.getLocation(), key.getValueName());
			key.setRegAfter(value.replace("\n", "").replace("\r", ""));
		}
		for (RegKey key : keys2) {
			String value = WinRegistry.readRegistry(key.getLocation(), key.getValueName());
			key.setRegAfter(value.replace("\n", "").replace("\r", ""));
		}
		
		//call func to write results
		writeResults(keys, keys2, keys3, keys4);
		
		String username = System.getProperty("user.name");
        String strCMD="C:\\Users\\" + username + "\\Desktop\\DR BOM WIZARD RROSE66";
        File dir = new File(strCMD);
        if (!dir.isDirectory()) 
        {
          System.err.println("There is no directory @ given path");
        } 
        else 
        {
            File newDir = new File("C:\\Users\\" + username + "\\Desktop\\DR BOM WIZARD "  + username +  "_old");
            dir.renameTo(newDir);
        }
        strCMD="";
        strCMD = "C:\\Users\\"  + username + "\\AppData\\Local\\Temp\\tml15_2oi_1y3_tmp\\DF03ED8DB220CA2D0586.tmp";
        
        File tmpFileToDelete = new File (strCMD);
        tmpFileToDelete.delete();

		
	}
	
	/**
	 * Write necessary information to text file
	 * @param keys List of all registry keys
	 */
	private static void writeResults(ArrayList<RegKey> keys, ArrayList<RegKey> keys2, ArrayList<RegKey> keys3, ArrayList<RegKey> keys4) {
		
		//format and write the output of file
		try {
			FileWriter writer = new FileWriter("output.txt", false);
			
			String formatStr = "%-40s %-1s %-10s %-1s %-10s %-1s %-10s %-1s%n";
			String repeated = new String(new char[80]).replace("\0", "-");
			repeated = repeated + "\r\n";
			
			writer.write(repeated);
			writer.write(String.format(formatStr, "Setting Name","|","Before","|","After","|","Required","|"));
			writer.write(repeated);
			for (RegKey key : keys) {
				writer.write(String.format(formatStr, key.getValueName(),"|",key.getRegBefore(),"|",key.getRegAfter(),"|",key.getValueString(),"|"));
			}
			for (RegKey key : keys2) {
				writer.write(String.format(formatStr, key.getValueName(),"|",key.getRegBefore(),"|",key.getRegAfter(),"|",key.getValueString(),"|"));
			}
			for (RegKey key : keys3) {
				writer.write(String.format(formatStr, key.getValueName(),"|",key.getRegBefore(),"|",key.getRegAfter(),"|",key.getValueString(),"|"));
			}
			for (RegKey key : keys4) {
				writer.write(String.format(formatStr, key.getValueName(),"|",key.getRegBefore(),"|",key.getRegAfter(),"|",key.getValueString(),"|"));
			}
			writer.write(repeated);
			writer.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//open file
		ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "output.txt");
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Converts collection of keys into a String of commands to write to registry
	 * @param keys List of all registry keys to be changed
	 * @return String of commands to execute
	 */
	private static String keysToCMD(ArrayList<RegKey> keys){
		String commands="";
		
		for (RegKey key : keys){			
			commands+= key.convertToCMD()+"&&";			
		}
		//commands+="echo - - - - - - - - - - - - - - - - - - - &&"; 
		//commands+="echo All Operations Completed Successfully &&";
		return commands;
	}
	
	/**
	 * Build ArrayList of keys that need to be changed in registry
	 */
	private static void addRegKeys(){
		//Allow Network Locations
		
		
		
		//  Excel Settings
		RegKey allowNetworkLocations = new RegKey(office16+"\\Excel\\Security\\Trusted Locations",
				"AllowNetworkLocations", dWord, "00000001","0x1");
		keys.add(allowNetworkLocations);
		
		//find way to clear
		//Disable Trusted Documents
		RegKey disableTrustedDocuments = new RegKey(office16+"\\Excel\\Security\\Trusted Documents", "DisableTrustedDocuments", dWord, "00000001","0x1");
		keys.add(disableTrustedDocuments);
		
		//UFI controls, which changes the ActiveX Excel settings
		RegKey UFIControls = new RegKey("HKEY_CURRENT_USER\\Software\\Microsoft\\Office\\Common\\Security", "UFIControls", dWord, "5","0x5");
		keys.add(UFIControls);
		
		//Developer Macro Settings: Trust access to the VBA project object model
		RegKey accessVBObjectModel = new RegKey(office16 + "\\Excel\\Security", "AccessVBOM", dWord, "1","0x1");
		keys.add(accessVBObjectModel);
		
		//Disable Internet Files in Protected View
		RegKey disableInternetFilesInPV = new RegKey(office16+"\\Excel\\Security\\ProtectedView", "DisableInternetFilesInPV", dWord, "1","0x1");
		keys.add(disableInternetFilesInPV);
		
		//Disable Attachments in Protected View
		RegKey disableAttachmentsInPV = new RegKey(office16+"\\Excel\\Security\\ProtectedView", "DisableAttachmentsInPV", dWord, "1","0x1");
		keys.add(disableAttachmentsInPV);
		
		//Disable Unsafe Locations in Protected View
		RegKey disableUnsafeLocationsInPV = new RegKey(office16+"\\Excel\\Security\\ProtectedView", "DisableUnsafeLocationsInPV", dWord, "1","0x1");
		keys.add(disableUnsafeLocationsInPV);
		
		//Show Message bar
		RegKey trustBar = new RegKey(office16+"\\Common\\TrustCenter", "TrustBar", dWord, "0","0x0");
		keys.add(trustBar);
		
		//Disable XL4 Workbooks
		RegKey XL4Workbooks = new RegKey(office16+"\\Excel\\Security\\FileBlock", "XL4Workbooks", dWord, "00000000","0x0");
		keys.add(XL4Workbooks);	
		
		//Disable XL2-4 Worksheets
		RegKey XL4Worksheets = new RegKey(office16+"\\Excel\\Security\\FileBlock", "XL4Worksheets", dWord, "00000000","0x0");
		keys.add(XL4Worksheets);				
		RegKey XL3Worksheets = new RegKey(office16+"\\Excel\\Security\\FileBlock", "XL3Worksheets", dWord, "00000000","0x0");
		keys.add(XL3Worksheets);				
		RegKey XL2Worksheets = new RegKey(office16+"\\Excel\\Security\\FileBlock", "XL2Worksheets", dWord, "00000000","0x0");
		keys.add(XL2Worksheets);
		
		//FileBlock->Open Behavior->Do not open
		RegKey openInProtectedView = new RegKey(office16+"\\Excel\\Security\\FileBlock", "OpenInProtectedView", dWord, "00000000","0x0");
		keys.add(openInProtectedView);
		
		//Disable Background Checking Setting
		RegKey backgroundChecking = new RegKey (office16+"\\Excel\\Error Checking", "BackgroundChecking", dWord, "0","0x0");
		keys.add(backgroundChecking);
						
		//Disable Hardware Acceleration Setting
		RegKey disableHardwareAcceleration = new RegKey (office16+"\\Common\\Graphics", "DisableHardwareAcceleration", dWord, "0", "0x0");
		keys.add(disableHardwareAcceleration);		
		
		//Enable all activeX
		RegKey enableActiveX = new RegKey (officeSecurity, "DisableAllActiveX", dWord, "0", "0x0");
		keys.add(enableActiveX);	
		
		//Data Connection Warnings
		RegKey dataConnectionWarning = new RegKey (office16+"\\Excel\\Security", "DataConnectionWarnings", dWord, "0", "0x0");
		keys.add(dataConnectionWarning);	
		
		//Security Settings for Workbook Links
		RegKey workbookLinkWarning = new RegKey (office16+"\\Excel\\Security", "WorkbookLinkWarnings", dWord, "2", "0x2");
		keys.add(workbookLinkWarning);	
		
		//analysis
		/*
		HKU\S-1-5-21-1078229911-1189946983-1225219381-1150206\SOFTWARE\Microsoft\Office\16.0\Excel\options\OPEN: "/R "C:\Program Files (x86)\Microsoft Office\Office16\Library\Analysis\ANALYS32.XLL""
		HKU\S-1-5-21-1078229911-1189946983-1225219381-1150206\SOFTWARE\Microsoft\Office\16.0\Excel\options\OPEN1: "/R "C:\Program Files (x86)\Microsoft Office\Office16\Library\Analysis\ATPVBAEN.XLAM""
		*/
		
		
		
		//Internet security settings
		RegKey internet1001 = new RegKey (security+"\\3", "1001", dWord, "1", "0x1");
		keys.add(internet1001);	
		RegKey internet1004 = new RegKey (security+"\\3", "1004", dWord, "3", "0x3");
		keys.add(internet1004);
		RegKey internet1200 = new RegKey (security+"\\3", "1200", dWord, "0", "0x0");
		keys.add(internet1200);	
		RegKey internet1201 = new RegKey (security+"\\3", "1201", dWord, "3", "0x3");
		keys.add(internet1201);	
		RegKey internet1206 = new RegKey (security+"\\3", "1206", dWord, "3", "0x3");
		keys.add(internet1206);	
		RegKey security1207 = new RegKey (security+"\\3", "1207", dWord, "3", "0x3");
		keys.add(security1207);	
		RegKey security1208 = new RegKey (security+"\\3", "1208", dWord, "3", "0x3");
		keys.add(security1208);	
		RegKey internet1209 = new RegKey (security+"\\3", "1209", dWord, "3", "0x3");
		keys.add(internet1209);	
		RegKey internet1400 = new RegKey (security+"\\3", "1400", dWord, "0", "0x0");
		keys.add(internet1400);	
		RegKey internet1402 = new RegKey (security+"\\3", "1402", dWord, "0", "0x0");
		keys.add(internet1402);	
		RegKey internet1405 = new RegKey (security+"\\3", "1405", dWord, "0", "0x0");
		keys.add(internet1405);	
		RegKey internet1406 = new RegKey (security+"\\3", "1406", dWord, "3", "0x3");
		keys.add(internet1406);	
		RegKey internet1407 = new RegKey (security+"\\3", "1407", dWord, "1", "0x1");
		keys.add(internet1407);	
		RegKey internet1408 = new RegKey (security+"\\3", "1408", dWord, "3", "0x3");
		keys.add(internet1408);	
		RegKey internet1409 = new RegKey (security+"\\3", "1409", dWord, "0", "0x0");
		keys.add(internet1409);	
		RegKey internet1601 = new RegKey (security+"\\3", "1601", dWord, "0", "0x0");
		keys.add(internet1601);	
		RegKey internet1604 = new RegKey (security+"\\3", "1604", dWord, "0", "0x0");
		keys.add(internet1604);	
		RegKey internet1605 = new RegKey (security+"\\3", "1605", dWord, "0", "0x0");
		keys.add(internet1605);	
		RegKey internet1606 = new RegKey (security+"\\3", "1606", dWord, "0", "0x0");
		keys.add(internet1606);	
		RegKey internet1607 = new RegKey (security+"\\3", "1607", dWord, "3", "0x3");
		keys.add(internet1607);	
		RegKey internet1608 = new RegKey (security+"\\3", "1608", dWord, "0", "0x0");
		keys.add(internet1608);	
		RegKey internet1609 = new RegKey (security+"\\3", "1609", dWord, "1", "0x1");
		keys.add(internet1609);	
		RegKey internet1800 = new RegKey (security+"\\3", "1800", dWord, "1", "0x1");
		keys.add(internet1800);	
		RegKey internet1802 = new RegKey (security+"\\3", "1802", dWord, "0", "0x0");
		keys.add(internet1802);	
		RegKey internet1803 = new RegKey (security+"\\3", "1803", dWord, "0", "0x0");
		keys.add(internet1803);	
		RegKey internet1804 = new RegKey (security+"\\3", "1804", dWord, "1", "0x1");
		keys.add(internet1804);	
		RegKey internet1805 = new RegKey (security+"\\3", "1805", dWord, "1", "0x1");
		keys.add(internet1805);	
		RegKey internet1806 = new RegKey (security+"\\3", "1806", dWord, "1", "0x1");
		keys.add(internet1806);	
		RegKey internet1807 = new RegKey (security+"\\3", "1807", dWord, "1", "0x1");
		keys.add(internet1807);	
		RegKey internet1808 = new RegKey (security+"\\3", "1808", dWord, "0", "0x0");
		keys.add(internet1808);	
		RegKey internet1809 = new RegKey (security+"\\3", "1809", dWord, "0", "0x0");
		keys.add(internet1809);	
		
		RegKey internet2000 = new RegKey (security+"\\3", "2000", dWord, "0", "0x0");
		keys2.add(internet2000);	
		RegKey internet2001 = new RegKey (security+"\\3", "2001", dWord, "0", "0x0");
		keys2.add(internet2001);	
		RegKey internet2004 = new RegKey (security+"\\3", "2004", dWord, "0", "0x0");
		keys2.add(internet2004);	
		RegKey internet2005 = new RegKey (security+"\\3", "2005", dWord, "3", "0x3");
		keys2.add(internet2005);	
		RegKey internet2007 = new RegKey (security+"\\3", "2007", dWord, "65536", "0x10000");
		keys2.add(internet2007);	
		RegKey internet2100 = new RegKey (security+"\\3", "2100", dWord, "0", "0x0");
		keys2.add(internet2100);	
		RegKey internet2101 = new RegKey (security+"\\3", "2101", dWord, "0", "0x0");
		keys2.add(internet2101);	
		RegKey internet2102 = new RegKey (security+"\\3", "2102", dWord, "3", "0x3");
		keys2.add(internet2102);	
		RegKey internet2103 = new RegKey (security+"\\3", "2103", dWord, "3", "0x3");
		keys2.add(internet2103);
		RegKey internet2104 = new RegKey (security+"\\3", "2104", dWord, "3", "0x3");
		keys2.add(internet2104);
		RegKey internet2105 = new RegKey (security+"\\3", "2105", dWord, "3", "0x3");
		keys2.add(internet2105);
		RegKey internet2107 = new RegKey (security+"\\3", "2107", dWord, "3", "0x3");
		keys2.add(internet2107);
		RegKey internet2200 = new RegKey (security+"\\3", "2200", dWord, "3", "0x3");
		keys2.add(internet2200);
		RegKey internet2201 = new RegKey (security+"\\3", "2201", dWord, "3", "0x3");
		keys2.add(internet2201);
		RegKey internet2300 = new RegKey (security+"\\3", "2300", dWord, "1", "0x1");
		keys2.add(internet2300);
		RegKey internet2301 = new RegKey (security+"\\3", "2301", dWord, "0", "0x0");
		keys2.add(internet2301);
		RegKey internet2400 = new RegKey (security+"\\3", "2400", dWord, "3", "0x3");
		keys2.add(internet2400);
		RegKey internet2401 = new RegKey (security+"\\3", "2401", dWord, "0", "0x0");
		keys2.add(internet2401);
		RegKey internet2402 = new RegKey (security+"\\3", "2402", dWord, "3", "0x3");
		keys2.add(internet2402);
		RegKey internet2500 = new RegKey (security+"\\3", "2500", dWord, "0", "0x0");
		keys2.add(internet2500);
		RegKey internet2600 = new RegKey (security+"\\3", "2600", dWord, "0", "0x0");
		keys2.add(internet2600);
		RegKey internet2700 = new RegKey (security+"\\3", "2700", dWord, "0", "0x0");
		keys2.add(internet2700);
		RegKey internet2702 = new RegKey (security+"\\3", "2702", dWord, "0", "0x0");
		keys2.add(internet2702);
		RegKey internet2703 = new RegKey (security+"\\3", "2703", dWord, "3", "0x3");
		keys2.add(internet2703);
		RegKey internet2708 = new RegKey (security+"\\3", "2708", dWord, "3", "0x3");
		keys2.add(internet2708);
		RegKey internet2709 = new RegKey (security+"\\3", "2700", dWord, "3", "0x3");
		keys2.add(internet2709);
		RegKey internet120A = new RegKey (security+"\\3", "120A", dWord, "3", "0x3");
		keys2.add(internet120A);
		RegKey internet120B = new RegKey (security+"\\3", "120B", dWord, "3", "0x3");
		keys2.add(internet120B);
		RegKey internet120C = new RegKey (security+"\\3", "120C", dWord, "3", "0x3");
		keys2.add(internet120C);
		RegKey internet160A = new RegKey (security+"\\3", "160A", dWord, "3", "0x3");
		keys2.add(internet160A);
		RegKey internet180A = new RegKey (security+"\\3", "180A", dWord, "3", "0x3");
		keys2.add(internet180A);
		RegKey internet180D = new RegKey (security+"\\3", "180D", dWord, "1", "0x1");
		keys2.add(internet180D);
		RegKey internet1A00 = new RegKey (security+"\\3", "1A00", dWord, "131072", "0x20000");
		keys2.add(internet1A00);
		RegKey internet1A02 = new RegKey (security+"\\3", "1A02", dWord, "0", "0x0");
		keys2.add(internet1A02);
		RegKey internet1A03 = new RegKey (security+"\\3", "1A03", dWord, "0", "0x0");
		keys2.add(internet1A03);
		RegKey internet1A04 = new RegKey (security+"\\3", "1A04", dWord, "3", "0x3");
		keys2.add(internet1A04);
		RegKey internet1A05 = new RegKey (security+"\\3", "1A05", dWord, "1", "0x1");
		keys2.add(internet1A05);
		RegKey internet1A06 = new RegKey (security+"\\3", "1A06", dWord, "0", "0x0");
		keys2.add(internet1A06);
		RegKey internet1A10 = new RegKey (security+"\\3", "1A10", dWord, "1", "0x1");
		keys2.add(internet1A10);
		RegKey internet1C00 = new RegKey (security+"\\3", "1C00", dWord, "65536", "0x10000");
		keys2.add(internet1C00);
		RegKey internet270B = new RegKey (security+"\\3", "270B", dWord, "3", "0x3");
		keys2.add(internet270B);
		RegKey internet270C = new RegKey (security+"\\3", "270C", dWord, "0", "0x0");
		keys2.add(internet270C);
		RegKey internet270D = new RegKey (security+"\\3", "270D", dWord, "3", "0x3");
		keys2.add(internet270D);
		RegKey internetCurrentLevel = new RegKey (security+"\\3", "CurrentLevel", dWord, "70912", "0x11500");
		keys2.add(internetCurrentLevel);	
	
		
		//local Intranet security settings
		RegKey intranet1001 = new RegKey (security+"\\1", "1001", dWord, "1", "0x1");
		keys3.add(intranet1001);	
		RegKey intranet1004 = new RegKey (security+"\\1", "1004", dWord, "3", "0x3");
		keys3.add(intranet1004);
		RegKey intranet1200 = new RegKey (security+"\\1", "1200", dWord, "0", "0x0");
		keys3.add(intranet1200);	
		RegKey intranet1201 = new RegKey (security+"\\1", "1201", dWord, "3", "0x3");
		keys3.add(intranet1201);	
		RegKey intranet1206 = new RegKey (security+"\\1", "1206", dWord, "3", "0x3");
		keys3.add(intranet1206);	
		RegKey intranet1207 = new RegKey (security+"\\1", "1207", dWord, "0", "0x0");
		keys3.add(intranet1207);	
		RegKey intranet1208 = new RegKey (security+"\\1", "1208", dWord, "0", "0x0");
		keys3.add(intranet1208);	
		RegKey intranet1209 = new RegKey (security+"\\1", "1209", dWord, "3", "0x3");
		keys3.add(intranet1209);	
		RegKey intranet1400 = new RegKey (security+"\\1", "1400", dWord, "0", "0x0");
		keys3.add(intranet1400);	
		RegKey intranet1402 = new RegKey (security+"\\1", "1402", dWord, "0", "0x0");
		keys3.add(intranet1402);	
		RegKey intranet1405 = new RegKey (security+"\\1", "1405", dWord, "0", "0x0");
		keys3.add(intranet1405);	
		RegKey intranet1406 = new RegKey (security+"\\1", "1406", dWord, "3", "0x3");
		keys3.add(intranet1406);	
		RegKey intranet1407 = new RegKey (security+"\\1", "1407", dWord, "1", "0x1");
		keys3.add(intranet1407);	
		RegKey intranet1408 = new RegKey (security+"\\1", "1408", dWord, "0", "0x0");
		keys3.add(intranet1408);	
		RegKey intranet1409 = new RegKey (security+"\\1", "1409", dWord, "0", "0x0");
		keys3.add(intranet1409);	
		RegKey intranet1601 = new RegKey (security+"\\1", "1601", dWord, "0", "0x0");
		keys3.add(intranet1601);	
		RegKey intranet1604 = new RegKey (security+"\\1", "1604", dWord, "0", "0x0");
		keys3.add(intranet1604);	
		RegKey intranet1605 = new RegKey (security+"\\1", "1605", dWord, "0", "0x0");
		keys3.add(intranet1605);	
		RegKey intranet1606 = new RegKey (security+"\\1", "1606", dWord, "0", "0x0");
		keys3.add(intranet1606);	
		RegKey intranet1607 = new RegKey (security+"\\1", "1607", dWord, "3", "0x3");
		keys3.add(intranet1607);	
		RegKey intranet1608 = new RegKey (security+"\\1", "1608", dWord, "0", "0x0");
		keys3.add(intranet1608);	
		RegKey intranet1609 = new RegKey (security+"\\1", "1609", dWord, "1", "0x1");
		keys3.add(intranet1609);	
		RegKey intranet1800 = new RegKey (security+"\\1", "1800", dWord, "1", "0x1");
		keys3.add(intranet1800);	
		RegKey intranet1802 = new RegKey (security+"\\1", "1802", dWord, "0", "0x0");
		keys3.add(intranet1802);	
		RegKey intranet1803 = new RegKey (security+"\\1", "1803", dWord, "0", "0x0");
		keys3.add(intranet1803);	
		RegKey intranet1804 = new RegKey (security+"\\1", "1804", dWord, "1", "0x1");
		keys3.add(intranet1804);	
		RegKey intranet1805 = new RegKey (security+"\\1", "1805", dWord, "1", "0x1");
		keys3.add(intranet1805);	
		RegKey intranet1806 = new RegKey (security+"\\1", "1806", dWord, "1", "0x1");
		keys3.add(intranet1806);	
		RegKey intranet1807 = new RegKey (security+"\\1", "1807", dWord, "1", "0x1");
		keys3.add(intranet1807);	
		RegKey intranet1808 = new RegKey (security+"\\1", "1808", dWord, "0", "0x0");
		keys3.add(intranet1808);	
		RegKey intranet1809 = new RegKey (security+"\\1", "1809", dWord, "0", "0x0");
		keys3.add(intranet1809);	
		
		RegKey intranet2000 = new RegKey (security+"\\1", "2000", dWord, "0", "0x0");
		keys4.add(intranet2000);	
		RegKey intranet2001 = new RegKey (security+"\\1", "2001", dWord, "0", "0x0");
		keys4.add(intranet2001);	
		RegKey intranet2004 = new RegKey (security+"\\1", "2004", dWord, "0", "0x0");
		keys4.add(intranet2004);	
		RegKey intranet2005 = new RegKey (security+"\\1", "2005", dWord, "0", "0x0");
		keys4.add(intranet2005);	
		RegKey intranet2007 = new RegKey (security+"\\1", "2007", dWord, "65536", "0x10000");
		keys4.add(intranet2007);	
		RegKey intranet2100 = new RegKey (security+"\\1", "2100", dWord, "0", "0x0");
		keys4.add(intranet2100);	
		RegKey intranet2101 = new RegKey (security+"\\1", "2101", dWord, "0", "0x0");
		keys4.add(intranet2101);	
		RegKey intranet2102 = new RegKey (security+"\\1", "2102", dWord, "3", "0x3");
		keys4.add(intranet2102);	
		RegKey intranet2103 = new RegKey (security+"\\1", "2103", dWord, "0", "0x0");
		keys4.add(intranet2103);
		RegKey intranet2104 = new RegKey (security+"\\1", "2104", dWord, "0", "0x0");
		keys4.add(intranet2104);
		RegKey intranet2105 = new RegKey (security+"\\1", "2105", dWord, "0", "0x0");
		keys4.add(intranet2105);
		RegKey intranet2107 = new RegKey (security+"\\1", "2107", dWord, "0", "0x0");
		keys4.add(intranet2107);
		RegKey intranet2200 = new RegKey (security+"\\1", "2200", dWord, "3", "0x3");
		keys4.add(intranet2200);
		RegKey intranet2201 = new RegKey (security+"\\1", "2201", dWord, "3", "0x3");
		keys4.add(intranet2201);
		RegKey intranet2300 = new RegKey (security+"\\1", "2300", dWord, "1", "0x1");
		keys4.add(intranet2300);
		RegKey intranet2301 = new RegKey (security+"\\1", "2301", dWord, "0", "0x0");
		keys4.add(intranet2301);
		RegKey intranet2400 = new RegKey (security+"\\1", "2400", dWord, "0", "0x0");
		keys4.add(intranet2400);
		RegKey intranet2401 = new RegKey (security+"\\1", "2401", dWord, "0", "0x0");
		keys4.add(intranet2401);
		RegKey intranet2402 = new RegKey (security+"\\1", "2402", dWord, "0", "0x0");
		keys4.add(intranet2402);
		RegKey intranet2500 = new RegKey (security+"\\1", "2500", dWord, "0", "0x0");
		keys4.add(intranet2500);
		RegKey intranet2600 = new RegKey (security+"\\1", "2600", dWord, "0", "0x0");
		keys4.add(intranet2600);
		RegKey intranet2700 = new RegKey (security+"\\1", "2700", dWord, "3", "0x3");
		keys4.add(intranet2700);
		RegKey intranet2702 = new RegKey (security+"\\1", "2702", dWord, "0", "0x0");
		keys4.add(intranet2702);
		RegKey intranet2703 = new RegKey (security+"\\1", "2703", dWord, "0", "0x0");
		keys4.add(intranet2703);
		RegKey intranet2708 = new RegKey (security+"\\1", "2708", dWord, "3", "0x3");
		keys4.add(intranet2708);
		RegKey intranet2709 = new RegKey (security+"\\1", "2709", dWord, "3", "0x3");
		keys4.add(intranet2709);
		RegKey intranet120A = new RegKey (security+"\\1", "120A", dWord, "3", "0x3");
		keys4.add(intranet120A);
		RegKey intranet120B = new RegKey (security+"\\1", "120B", dWord, "0", "0x0");
		keys4.add(intranet120B);
		RegKey intranet120C = new RegKey (security+"\\1", "120C", dWord, "0", "0x0");
		keys4.add(intranet120C);
		RegKey intranet160A = new RegKey (security+"\\1", "160A", dWord, "0", "0x0");
		keys4.add(intranet160A);
		RegKey intranet180A = new RegKey (security+"\\1", "180A", dWord, "3", "0x3");
		keys4.add(intranet180A);
		RegKey intranet180D = new RegKey (security+"\\1", "180D", dWord, "1", "0x1");
		keys4.add(intranet180D);
		RegKey intranet1A00 = new RegKey (security+"\\1", "1A00", dWord, "131072", "0x20000");
		keys4.add(intranet1A00);
		RegKey intranet1A02 = new RegKey (security+"\\1", "1A02", dWord, "0", "0x0");
		keys4.add(intranet1A02);
		RegKey intranet1A03 = new RegKey (security+"\\1", "1A03", dWord, "0", "0x0");
		keys4.add(intranet1A03);
		RegKey intranet1A04 = new RegKey (security+"\\1", "1A04", dWord, "3", "0x3");
		keys4.add(intranet1A04);
		RegKey intranet1A05 = new RegKey (security+"\\1", "1A05", dWord, "1", "0x1");
		keys4.add(intranet1A05);
		RegKey intranet1A06 = new RegKey (security+"\\1", "1A06", dWord, "0", "0x0");
		keys4.add(intranet1A06);
		RegKey intranet1A10 = new RegKey (security+"\\1", "1A10", dWord, "1", "0x1");
		keys4.add(intranet1A10);
		RegKey intranet1C00 = new RegKey (security+"\\1", "1C00", dWord, "65536", "0x10000");
		keys4.add(intranet1C00);
		RegKey intranet270B = new RegKey (security+"\\1", "270B", dWord, "0", "0x0");
		keys4.add(intranet270B);
		RegKey intranet270C = new RegKey (security+"\\1", "270C", dWord, "0", "0x3");
		keys4.add(intranet270C);
		RegKey intranet270D = new RegKey (security+"\\1", "270D", dWord, "0", "0x3");
		keys4.add(intranet270D);
		RegKey intranetCurrentLevel = new RegKey (security+"\\1", "CurrentLevel", dWord, "69632", "0x11000");
		keys4.add(intranetCurrentLevel);
		
		
		/*
		//Internet security settings
		RegKey internetCurrentLevel = new RegKey (security+"\\3", "CurrentLevel", dWord, "70912", "0x11500");
		keys.add(internetCurrentLevel);	
		
		//RegKey security1207 = new RegKey (security+"\\3", "1207", dWord, "3", "0x3");
		//keys.add(security1207);	
		
		//RegKey security1208 = new RegKey (security+"\\3", "1208", dWord, "3", "0x3");
		//keys.add(security1208);	
		
		RegKey security1408 = new RegKey (security+"\\3", "1408", dWord, "3", "0x3");
		keys.add(security1408);	
		
		RegKey security160A = new RegKey (security+"\\3", "160A", dWord, "3", "0x3");
		keys.add(security160A);	
		
		RegKey security2005 = new RegKey (security+"\\3", "2005", dWord, "3", "0x3");
		keys.add(security2005);	
		
		RegKey security2103 = new RegKey (security+"\\3", "2103", dWord, "3", "0x3");
		keys.add(security2103);	
		
		RegKey security2104 = new RegKey (security+"\\3", "2104", dWord, "3", "0x3");
		keys.add(security2104);	
		
		RegKey security2105 = new RegKey (security+"\\3", "2105", dWord, "3", "0x3");
		keys.add(security2105);	
		
		RegKey security2400 = new RegKey (security+"\\3", "2400", dWord, "3", "0x3");
		keys.add(security2400);	
		
		RegKey security2402 = new RegKey (security+"\\3", "2402", dWord, "3", "0x3");
		keys.add(security2402);	
		
		RegKey security2700 = new RegKey (security+"\\3", "2700", dWord, "0", "0x0");
		keys.add(security2700);	
		
		RegKey security2107 = new RegKey (security+"\\3", "2107", dWord, "3", "0x3");
		keys.add(security2107);	
		
		RegKey security1812 = new RegKey (security+"\\3", "1812", dWord, "1", "0x1");
		keys.add(security1812);	
		
		RegKey security270B = new RegKey (security+"\\3", "270B", dWord, "3", "0x3");
		keys.add(security270B);	
		
		RegKey security270C = new RegKey (security+"\\3", "270C", dWord, "0", "0x0");
		keys.add(security270C);	
		
		RegKey security270D = new RegKey (security+"\\3", "270D", dWord, "3", "0x3");
		keys.add(security270D);	
		
		RegKey security2703 = new RegKey (security+"\\3", "2703", dWord, "3", "0x3");
		keys.add(security2703);	
		
		RegKey security120C = new RegKey (security+"\\3", "120C", dWord, "3", "0x3");
		keys.add(security120C);	
		
		RegKey security120B = new RegKey (security+"\\3", "120B", dWord, "3", "0x3");
		keys.add(security120B);	
		
		RegKey protectedMode = new RegKey (security+"\\3", "2500", dWord, "0", "0x0");
		keys.add(protectedMode);	
	
		
	
		 //Intranet security options 
		RegKey intranetCurrentLevel = new RegKey (security+"\\1", "CurrentLevel", dWord, "69632", "0x11000");
		keys.add(intranetCurrentLevel);	
		
		RegKey security1407 = new RegKey (security+"\\1", "1407", dWord, "1", "0x1");
		keys.add(security1407);	
		
		RegKey security1206 = new RegKey (security+"\\1", "1206", dWord, "3", "0x3");
		keys.add(security1206);	
		
		RegKey security1209 = new RegKey (security+"\\1", "1209", dWord, "3", "0x3");
		keys.add(security1209);	
		
		RegKey security1406 = new RegKey (security+"\\1", "1406", dWord, "3", "0x3");
		keys.add(security1406);	
		
		RegKey security1409 = new RegKey (security+"\\1", "1409", dWord, "0", "0x0");
		keys.add(security1409);	
		
		RegKey security1607 = new RegKey (security+"\\1", "1607", dWord, "3", "0x3");
		keys.add(security1607);	
		
		RegKey security1809 = new RegKey (security+"\\1", "1809", dWord, "0", "0x0");
		keys.add(security1809);	
		
		RegKey security1A04 = new RegKey (security+"\\1", "1A04", dWord, "3", "0x3");
		keys.add(security1A04);	
		
		RegKey security1A05 = new RegKey (security+"\\1", "1A05", dWord, "1", "0x1");
		keys.add(security1A05);	
		
		RegKey security1C00 = new RegKey (security+"\\1", "1C00", dWord, "65536", "0x10000");
		keys.add(security1C00);	
		
		RegKey security2102 = new RegKey (security+"\\1", "2102", dWord, "3", "0x3");
		keys.add(security2102);	
		
		RegKey security2200 = new RegKey (security+"\\1", "2200", dWord, "3", "0x3");
		keys.add(security2200);	
		
		RegKey security2201 = new RegKey (security+"\\1", "2201", dWord, "3", "0x3");
		keys.add(security2201);	
		
		RegKey security2301 = new RegKey (security+"\\1", "2301", dWord, "0", "0x0");
		keys.add(security2301);	
		
		RegKey security2702 = new RegKey (security+"\\1", "2702", dWord, "0", "0x0");
		keys.add(security2702);	
		
		RegKey protectedMode2 = new RegKey (security+"\\1", "2500", dWord, "0", "0x0");
		keys.add(protectedMode2);
*/

		//Default browser 
		/*
		RegKey shellftp = new RegKey (shell+"\\ftp\\UserChoice", "ProgId", "REG_SZ", "IE.FTP", "IE.FTP");
		keys.add(shellftp);	
		
		RegKey shellhttp = new RegKey (shell+"\\http\\UserChoice", "ProgId", "REG_SZ", "IE.HTTP", "IE.HTTP");
		keys.add(shellhttp);	
		
		RegKey shellhttps = new RegKey (shell+"\\https\\UserChoice", "ProgId", "REG_SZ", "IE.HTTPS", "IE.HTTPS");
		keys.add(shellhttps);	
		
	
		RegKey shellhttps = new RegKey (explorer+"\\.HTM\\UserChoice", "ProgId", "REG_SZ", "IE.AssocFile.HTM", "IE.AssocFile.HTM");
		keys.add(shellhttps);	
		 
		 */
	}
}
