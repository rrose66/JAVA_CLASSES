package etl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CleanOracleExtract 
{

	public static void main(String[] args) 
	{
		Integer intRoleCounter=0;
		String[] aryOracleExtract=null;
		String[] aryMultipleRoles=null;
		String strOracleExtractAllRoles=null;
		String strOracleExtractFileName ="";
		String strOracleExtractData = "";
		String strCDSID = "";
		String strRole = "";
		File fileOracleExtact = new File("Y:\\ARCHIVES\\LEADERSHIP_DECK\\USER_METRICS\\ORACLE_DUMP_" + GetStringTodayYYYYMMDD() + ".csv");
		File fileKnownConflictsOracleMultipleRoles = new File ("P:\\Audit Regulatory\\Security & Controls\\Separation of Duties\\WIP\\KNOWN_CONFLICTS_ORACLE_MULTIPLE_ROLES.txt");
		PrintWriter pwOracleExtractUniqueCDSID = null;
		try 
		{
//			fwOracleExtractUniqueCDSID = new FileWriter("P:\\Audit Regulatory\\Security & Controls\\Separation of Duties\\WIP\\ORACLE_EXTRACT_UNIQUE_CDSID.TXT",true);
			pwOracleExtractUniqueCDSID = new PrintWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\ORACLE_EXTRACT_UNIQUE_CDSID.TXT");
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		Scanner scOracleMultipleRoleConflicts = null;
		Scanner scOracleExtract = null;
		try 
		{
			scOracleExtract = new Scanner(fileOracleExtact);
			scOracleMultipleRoleConflicts = new Scanner(fileKnownConflictsOracleMultipleRoles);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		intRoleCounter=1;
		scOracleExtract.nextLine();
		while (scOracleExtract.hasNextLine())
		{
			strOracleExtractData=scOracleExtract.nextLine();
//			System.out.println(strOracleExtractData);
			aryOracleExtract=strOracleExtractData.split(",");
			if (strCDSID.isEmpty())
			{
				strCDSID = aryOracleExtract[1].toUpperCase();
				strOracleExtractAllRoles = aryOracleExtract[2];
			}
			else
			{
				if(aryOracleExtract[1].toUpperCase().matches(strCDSID))
				{
					strOracleExtractAllRoles = strOracleExtractAllRoles + "_" + aryOracleExtract[2];
					intRoleCounter=intRoleCounter+1;
				}
				else
				{
	//				add a record
					pwOracleExtractUniqueCDSID.println(strCDSID + "," + strOracleExtractAllRoles + "," + intRoleCounter);
					intRoleCounter=1;
					strCDSID = aryOracleExtract[1].toUpperCase();
					strOracleExtractAllRoles = aryOracleExtract[2];
//					pwOracleExtractUniqueCDSID.close();
				}
			}
		}
		pwOracleExtractUniqueCDSID.close();
		FindBusinessDirectedConflicts();
	}
	public static void FindBusinessDirectedConflicts()
	{
		Integer intRoleBase;
		Integer intRoleTarget;
		Integer intRoleCount;
		String strOracleUniqueCDSID;
		String strCDSID;
		String strConflict;
		String strRoles;
		String strKnownConflicts;
		String strBaseRole;
		String strRoleTarget;
		Scanner scOracleExtractUniqueCDSID = null;
		Scanner scKnownConflicts = null;
		File fileOracleExtractUniqueCDSID = null;
		File fileKnownMultipleRoleConflict = null;
		PrintWriter pwConflictsFound = null;
		String[] aryRoles;
		String[] aryRolesParsed;
		String[] aryKnownConflicts;
		try 
		{
			fileOracleExtractUniqueCDSID = new File("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\ORACLE_EXTRACT_UNIQUE_CDSID.TXT");
			scOracleExtractUniqueCDSID = new Scanner(fileOracleExtractUniqueCDSID);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		while (scOracleExtractUniqueCDSID.hasNextLine())
		{
			strOracleUniqueCDSID = scOracleExtractUniqueCDSID.nextLine();
			System.out.println(strOracleUniqueCDSID);
			aryRoles = strOracleUniqueCDSID.split(",");
			strRoles = aryRoles[1].replace("\"", "");
			aryRolesParsed = strRoles.split("_");
			intRoleCount = aryRolesParsed.length;
			strCDSID = aryRoles[0];
			fileKnownMultipleRoleConflict = new File("P:\\Audit Regulatory\\Security & Controls\\Separation of Duties\\WIP\\KNOWN_CONFLICTS_ORACLE_MULTIPLE_ROLES.txt");
			try 
			{
				scKnownConflicts = new Scanner(fileKnownMultipleRoleConflict);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			if(aryRolesParsed.length > 1)
			{
				for ( intRoleBase = 0; intRoleBase <= intRoleCount-2 ;intRoleBase++)
				{
					strBaseRole = aryRolesParsed[intRoleBase];
					for ( intRoleTarget = 0; intRoleTarget <= intRoleCount-2 ;intRoleTarget++)
					{
						strRoleTarget = aryRolesParsed[intRoleTarget];
						while (scKnownConflicts.hasNextLine())
						{
							strKnownConflicts = scKnownConflicts.nextLine();
							aryKnownConflicts = strKnownConflicts.split(",");
							if (strBaseRole.matches(aryKnownConflicts[0]))
							{
								if (strRoleTarget.matches(aryKnownConflicts[1]))
								{
									strConflict = aryKnownConflicts[2];
									try 
									{
										pwConflictsFound = new PrintWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\CONFLICTS_FOUND.TXT");
										pwConflictsFound.println(strCDSID + "," + strConflict);
										pwConflictsFound.close();
									} 
									catch (FileNotFoundException e) 
									{
										e.printStackTrace();
									}
									
								}
							}
						}
					}
				}
					
			}
			
//			System.out.println(aryRolesParsed[0]);
//			System.out.println(aryRolesParsed[1]);
		}
	}
	public static String GetStringTodayYYYYMMDD()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}
}
