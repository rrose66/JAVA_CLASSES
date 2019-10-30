package dev.misc;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * 
 * @author RROSE66
 * @date 
 * The intent of this code is to capture the baseline of web services being triggered
 * '####################################################################################################
CONFIDENTIAL FORD MOTOR COMPANY

This is an unpublished work of authorship, which contains trade secrets, created in 2017.
Ford Motor Company owns all rights to this work and intends to maintain it in confidence to
preserve its trade secret status. Ford Motor Company reserves the right, under the copyright
laws of the United States or those of any other country that may have jurisdiction, to protect
this work as an unpublished work, in the event of an inadvertent or deliberate unauthorized
publication. Ford Motor Company also reserves its rights under all copyright laws to protect
this work as a published work, when appropriate. Those having access to this work may not copy
it, use it, modify it, or disclose the information contained in it without the written
authorization of Ford Motor Company.

Author: Robert Rose
Intent: Provide a utility the facilitates the testing process
 		Ensures a snapshot of the local log fits the user executed test case
 		Parses the log for key words indicating web services that have not yet been automated 
{@docRoot}
{@value}
@version 
	Version 09 10/24/2017 Documented, refined, moved reference file to SharePoint, and automatically saving outputs to SharePoint
	Version 08 10/20/2017 Cleaned up and revise references
	Version 07 10/19/2017 Coded to pickup system user id to add to file name
	Version 06 10/10/2017 Created end metrics report color coded
	Version 05 10/03/2017 Changed from JOptionPanel input to JOptionPanel dialogues
	Version 04 09/25/2017 Created report for user to review
	Version 03 09/18/2017 Changed from hard coded references to external reference file
	Version 02 09/14/2017 Changed from console to JOptionPanel
	Version 01 09/06/2017 Hard coded references
	Version 0 09/01/2017 Prototype proposal
 */
public class Baselining 
{
	public static void main(String[] args) 
	{
		String strJarFileVersion="9";
		boolean success=false;
		boolean blnTargetFound=false;
		boolean blnNoneAutomatedWebServiceFound=false;
		String strTargetPathForDataFiles="C:\\Users\\Public\\FEDEBOM\\LOGS\\BOMClient\\";
		String outPutLine=null;
		JScrollPane scrollpane = new JScrollPane();
		JPanel panel = new JPanel();
		panel.add(scrollpane);
		int intWebServicesFound=0;
		int intWebServicesStillNeedingAutomation=0;
		Properties fordUserProperties = new Properties(System.getProperties());
		String strCDSID = fordUserProperties.getProperty("user.name");
		String strYYYYMMDDHHMM=null;
		Date dateForFileNames = new Date();
		DateFormat dateFormatForFileName = new SimpleDateFormat("yyyyMMddHHmm");
		dateFormatForFileName.format(dateForFileNames);
		strYYYYMMDDHHMM = dateFormatForFileName.format(dateForFileNames);
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		
		FileWriter rstRemainingWebServicesFound = null;
		BufferedWriter bufRemainingWebServicesFound = null;
		PrintWriter pntRemainingWebServicesFound = null;

		String strNow;
		final String strMesOneLineOne="Select Yes to start the test.";
		outPutLine = "";
		outPutLine = outPutLine + strMesOneLineOne;
		outPutLine = outPutLine + "\nThe Jar file utility you are using is at Version: ";
		outPutLine = outPutLine + strJarFileVersion;
		outPutLine = outPutLine + "\nThis will rename your log.";
		outPutLine = outPutLine + "\nPlease close FEDE BOM FIRST";
		int intDialogButton=JOptionPane.YES_NO_OPTION;
		intDialogButton=JOptionPane.showConfirmDialog(null, outPutLine,"Warning",intDialogButton);
		outPutLine="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		Date dateToday = new Date();
		dateFormat.format(dateToday);
		if(intDialogButton == 0 )
		{
			strNow = dateFormat.format(dateToday);
			File fileBackedUpLog = new File("C:\\Users\\Public\\FEDEBOM\\LOGS\\BOMClient\\BomUIApplication_" + strYYYYMMDDHHMM + ".txt");
			File fileCurrentLog = new File("C:\\Users\\Public\\FEDEBOM\\LOGS\\BOMClient\\BomUIApplication.log");
			success=false;
			success = fileCurrentLog.renameTo(fileBackedUpLog);
			outPutLine="";
			outPutLine = outPutLine + "Select Yes to mark the end of the test.";
			outPutLine = outPutLine + "\nEnsure all testing for the select test case is completed. ";
			outPutLine = outPutLine + "\nEnsure FEDE BOM is closed first.  ";
			outPutLine = outPutLine + "\nThis will search the log file for web services ";
			outPutLine = outPutLine + "\nthen create a report of the findings";
			intDialogButton=JOptionPane.showConfirmDialog(null, outPutLine,"Warning",intDialogButton);
			outPutLine="";
			if(intDialogButton == 0)
			{
				try
				{
					strNow = dateFormat.format(dateToday);
					File rstLog = new File("C:\\Users\\Public\\FEDEBOM\\LOGS\\BOMClient\\BomUIApplication.log");
					Scanner scLog = new Scanner(rstLog);
					String strCurrentLogEntry=null;
					String strFoundKeyWord=null;
					String[] arrayKeyWord=null;
					while(scLog.hasNextLine())
					{
						strCurrentLogEntry=scLog.nextLine();
						if(strCurrentLogEntry.isEmpty())
						{
						}
						else
						{
							File rstLocalKeyWords = new File("C:\\Users\\Public\\FEDEBOM\\LOGS\\BOMClient\\KEY_WORDS.TXT");
							File rstSPKeyWords = new File("L:\\FEDE_BOM_WS_LIST\\KEY_WORDS.TXT");
							try
							{
								copyFile(rstSPKeyWords,rstLocalKeyWords);
							}
							catch (IOException e) 
							{
								e.printStackTrace();
							}
							Scanner scKeyWords = new Scanner(rstLocalKeyWords);
							while(scKeyWords.hasNextLine())
							{
								strFoundKeyWord=scKeyWords.nextLine();
								arrayKeyWord=strFoundKeyWord.split(",");
								String strWebServiceLine="YES";
								if(strCurrentLogEntry.contains(arrayKeyWord[0]) && arrayKeyWord[2].equals(strWebServiceLine))
								{
									rstRemainingWebServicesFound = new FileWriter(strTargetPathForDataFiles + "ReportFor.txt",true);
									bufRemainingWebServicesFound = new BufferedWriter(rstRemainingWebServicesFound);
									pntRemainingWebServicesFound = new PrintWriter(bufRemainingWebServicesFound);
									if(strCurrentLogEntry.length()>=254)
									{
										strCurrentLogEntry=strCurrentLogEntry.substring(0,254);
									}
									outPutLine="";
									outPutLine=outPutLine  + "\"" + arrayKeyWord[0] + "\"";
									outPutLine=outPutLine + ", " + "\"" + arrayKeyWord[1] + "\"";
									outPutLine=outPutLine + ", " + "\"" + strCurrentLogEntry + "\"" ;
									pntRemainingWebServicesFound.println(outPutLine);
									pntRemainingWebServicesFound.close();
									blnTargetFound=true;
									String strNTBA="NEEDS TO BE AUTOMATED";
									if(arrayKeyWord[1].equals(strNTBA))
									{
										blnNoneAutomatedWebServiceFound=true;
										intWebServicesStillNeedingAutomation=intWebServicesStillNeedingAutomation+1;
									}
									else
									{
										intWebServicesFound=intWebServicesFound+1;
									}
								}
								else if(strCurrentLogEntry.contains(arrayKeyWord[0]) && !arrayKeyWord[2].equals(strWebServiceLine))
								{
									FileWriter fwIssueFound = null;
									BufferedWriter buIssueFound = null;
									PrintWriter pwIssueFound = null;
									fwIssueFound = new FileWriter(strTargetPathForDataFiles + "IssuesFor.txt",true);
									buIssueFound = new BufferedWriter(fwIssueFound);
									pwIssueFound = new PrintWriter(buIssueFound);
									if(strCurrentLogEntry.length()>=254)
									{
										strCurrentLogEntry=strCurrentLogEntry.substring(0,254);
									}
									outPutLine="";
									outPutLine=outPutLine  + "\"" + arrayKeyWord[0] + "\"";
									outPutLine=outPutLine + ", " + "\"" + arrayKeyWord[1] + "\"";
									outPutLine=outPutLine + ", " + "\"" + strCurrentLogEntry + "\"" ;
									pwIssueFound.println(outPutLine);
									pwIssueFound.close();
									blnTargetFound=true;
								}
							}
						scKeyWords.close();
						}
					}
					scLog.close();
				}
				catch (IOException allExceptions)
				{
					allExceptions.printStackTrace();
				}
				String strFinalMessage=null;
				String strFinalMessageIsNull=null;
				if (blnTargetFound==true)
				{
					if(blnNoneAutomatedWebServiceFound==true)
					{
						outPutLine="";
						outPutLine=outPutLine + "Please enter the Rally Test Case i.e. TC0000 ";
						outPutLine=outPutLine + "\nIf there is no Rally Test Case, please enter the date and time yyyymmddhhmm. ";
						outPutLine=outPutLine + "\nThis test executed one or more web services that has not yet been automated.  ";
						outPutLine=outPutLine + "\nPlease contact the Team that is automating the webService testing.  ";
						outPutLine=outPutLine + "\nThe report named <input> _Report.txt has the details.  ";
						outPutLine=outPutLine + "\nThe log named  <input>_BomUIApplication.log will be prepared for you.  ";
						outPutLine=outPutLine + "\nPlease copy both files into SharePoint";
						strFinalMessage=JOptionPane.showInputDialog(outPutLine);
						outPutLine="";
					}
					else
					{
						outPutLine="";
						outPutLine=outPutLine + "Please enter the Rally Test Case i.e. TC0000 ";
						outPutLine=outPutLine + "\nIf there is no Rally Test Case, please enter the date and time yyyymmddhhmm. ";
						outPutLine=outPutLine + "\nThis test executed one or more web services.  ";
						outPutLine=outPutLine + "\nThe report named <input> _Report.txt has the details. ";
						outPutLine=outPutLine + "\nThe log named  <input>_BomUIApplication.log will be prepared for you.  ";
						outPutLine=outPutLine + "\nPlease copy both files into SharePoint";
						strFinalMessage=JOptionPane.showInputDialog(outPutLine);
						outPutLine="";
					}
				}
				else
				{
					outPutLine="";
					outPutLine=outPutLine + "Please enter the Rally Test Case i.e. TC0000 ";
					outPutLine=outPutLine + "\nIf there is no Rally Test Case, please enter the date and time yyyymmddhhmm. ";
					outPutLine=outPutLine + "\nNone of the web services were found.  ";
					outPutLine=outPutLine + "\nPlease close FEDE BOM and restart this program";
					strFinalMessage=JOptionPane.showInputDialog(outPutLine);
					outPutLine="";
				}
				if(strFinalMessage == null)
				{
					System.exit(0);
				}
				else
				{
					File strNewReportFileName = new File("L:\\FEDE_BOM_TC_WS_MAPPING\\" + strFinalMessage + "_" + strCDSID + "_" + strYYYYMMDDHHMM + "_Report"  + ".txt");
					File strOldPath= new File(strTargetPathForDataFiles + "ReportFor.txt");
					File fileNewLocalName = new File(strTargetPathForDataFiles  + strFinalMessage + "_" + strCDSID + "_" + strYYYYMMDDHHMM + "_Report"  + ".txt");
					try 
					{
						if(strNewReportFileName.exists())
						{
							throw new java.io.IOException("file exists");
						}
						copyFile(strOldPath,strNewReportFileName);
					} catch (IOException e) {
						e.printStackTrace();
					}

					File fileIssuesTarget = new File("L:\\FEDE_BOM_TC_FLAGS_MAPPING\\" + strFinalMessage + "_" + strCDSID + "_" + strYYYYMMDDHHMM + "_Report"  + ".txt");
					File fileIssuesCurrent = new File(strTargetPathForDataFiles + "IssuesFor.txt");
					File fileIssuesTargetLocal = new File(strTargetPathForDataFiles  + strFinalMessage + "_" + strCDSID + "_" + strYYYYMMDDHHMM + "_Issues"  + ".txt");
					try 
					{
						if(fileIssuesTarget.exists())
						{
							throw new java.io.IOException("file exists");
						}
						copyFile(fileIssuesCurrent,fileIssuesTarget);
						success=false;
						success = fileIssuesCurrent.renameTo(fileIssuesTargetLocal);
					} catch (IOException e) {
						e.printStackTrace();
					}

					File fileNewBOMUIApplication = new File(strTargetPathForDataFiles + strFinalMessage + "_" + strCDSID + "_" + strYYYYMMDDHHMM + "_BomUIApplication.txt");
					File fileOldPath= new File(strTargetPathForDataFiles + "BomUIApplication.log");
					success=false;
					success = strOldPath.renameTo(fileNewLocalName);
					try 
					{
						if(fileNewBOMUIApplication.exists())
						{
							throw new java.io.IOException("file exists");
						}
						success=false;
						success = fileOldPath.renameTo(fileNewBOMUIApplication);
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					
					panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
					JFrame frame = new JFrame("Web Service Discovery");
					frame.setLocationRelativeTo(null);
					JLabel labelWSfound = new JLabel("Web Services needing automation");
					JButton labelNotify = new JButton("Notify the Web Service Automation Team of your findings");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(new GridLayout(3,3));
					frame.add((new JLabel("Web Services found")));
					frame.add((new JLabel(Integer.toString(intWebServicesFound))));
					frame.add(labelWSfound);
					frame.add(new JLabel(Integer.toString(intWebServicesStillNeedingAutomation)));
					frame.add(new JLabel("Copy the reference files to sharepoint"));
					if(intWebServicesStillNeedingAutomation>=1)
					{
						labelNotify.setBackground(Color.RED);
						frame.add(labelNotify);
					}
					frame.pack();
					frame.setVisible(true);
				}
			}
			else
			{
				System.exit(0);
			}
		}
	}
	public static void copyFile(File sourceFile,File destFile) throws IOException
	{
		if(!destFile.exists())
		{
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try
		{
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		}
		finally
		{
			if(source !=null)
			{
				source.close();
			}
			if(destination != null)
			{
				destination.close();
			}
		}
	}
}
