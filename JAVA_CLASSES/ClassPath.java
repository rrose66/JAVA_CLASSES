/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classpath;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author GROMER16
 */
public class ClassPath {
    //update the path location in strings folder 1-4 for each of the folder location. Use double backslashes 
    public static String BOMinFEDELibs = "C:\\Projects\\AccuRev\\BOMinFEDE_v1.0_Collab_DEV\\build\\distributions\\BOMClient\\libs\\";
    public static String BOMinFEDECore = "C:\\Projects\\AccuRev\\BOMinFEDE_v1.0_Collab_DEV\\build\\distributions\\BOMClient\\core\\";
    public static String FEDEUICore = "C:\\temp\\FEDEBOM_UI\\FEDEBOM 2.55\\bomclient\\core\\";
    public static String FEDEUILibs = "C:\\temp\\FEDEBOM_UI\\FEDEBOM 2.55\\bomclient\\libs\\";
    public static String BOMinFEDEDir = "C:/Projects/AccuRev/";
    public static String FEDEDUIDir = "C:/temp/";
    public static String FEDEUI = "FEDEBOM_UI";
    public static String BOMInFEDE = "BOMinFEDE_v1.0_Collab_DEV";
    //xml formatting for the file string
    public static String start = "\t<classpathentry kind=\"lib\" path=\"";
    public static String end = "\"/>";
    //File location
    public static String AutoXML = "c:\\temp\\FileAutomationxml.txt";
    
    public static void main(String[] args) throws IOException {
        String path = "";
        String Whatsup = "";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(AutoXML)));
        
        //open xml code
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<classpath>");
        out.println("\t<classpathentry kind=\"src\" path=\"src\"/>");
        out.println("\t<classpathentry kind=\"src\" path=\"resources/inputjson\"/>");
        out.println("\t<classpathentry excluding=\"inputjson/\" kind=\"src\" path=\"resources\"/>");
	/*	
        //write file location with xml formating
        File buildLibs = new File(BOMinFEDELibs);
        File[] listOfBuildLibs = buildLibs.listFiles();
        for (File file : listOfBuildLibs){
            out.println(start + file + end);
        }
        File buildCore = new File(BOMinFEDECore);
        File[] listOfBuildCore = buildCore.listFiles();
        for (File file : listOfBuildCore){
            out.println(start + file + end);
        }
*/
        path = FEDEUIFile("core");
        Whatsup = "FEDE_UI Core DIrectory: " + path + "\n";
        File tempCore = new File(FEDEUICore);
        File[] listOfTempCore = tempCore.listFiles();
        for (File file : listOfTempCore){
            out.println(start + file + end);
        }
        path = FEDEUIFile("libs");
        Whatsup +="FEDE_UI libs Directory: " + path + "\n";
        File tempLibs = new File(path);
        File[] listOfTempLibs = tempLibs.listFiles();
        for (File file : listOfTempLibs){
            out.println(start + file + end);
        }
        //end xml code
        out.println("\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
        out.println("\t<classpathentry kind=\"output\" path=\"bin\"/>");
        out.println("</classpath>");		
        //close the write statement
        out.close();
        Whatsup += "Text file created her " + AutoXML;
        JOptionPane.showMessageDialog(null, Whatsup);
    }//main

    private static String BOMInFEDEFile(String folder){

        boolean foundFolder = false;
        String path = "";
        
        File Dir = new File(BOMinFEDEDir);
        
        File[] files = Dir.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                if (file.getName().equalsIgnoreCase(BOMInFEDE)){
                    path = file.getParent() + "\\" + file.getName();
                }//if match
            }//if dir
        }//for loop
        if (folder.equalsIgnoreCase("core"))
            path += "\\build\\distirbutions\\BOMClient\\Core\\";
        else if (folder.equalsIgnoreCase("libs"))
            path += "\\build\\distirbutions\\BOMClient\\libs\\";
        return path;
    }//findDirectory
    
    private static String FEDEUIFile(String folder){
        String FEDE = "FEDEBOM";
        String latestDir = "";
        String currentDir = "";
        double currentVersion = 0;
        double latestVersion = 0;
        File parentDir = null;
        //File path = null;
        String path;
        
        File dir = new File(FEDEDUIDir);
        File[] files = dir.listFiles();
        for (File file : files){
            if (file.isDirectory())
                if (file.getName().toLowerCase().contains(FEDEUI.toLowerCase())){
                    parentDir = file;
                    break;
                }
        }
        files = parentDir.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                currentDir = file.getName();
                if (currentDir.toLowerCase().contains(FEDE.toLowerCase())){
                    String[] split = file.getName().split(" ");
                    if (split.length > 1){
                        currentVersion = Double.parseDouble(split[1]);
                        if (currentVersion > latestVersion){
                            latestVersion = Double.parseDouble(split[1]);
                            latestDir = file.getParent() + "\\" + file.getName();
                        }
                    }//if split length
                }//if FEDEUI folder
            } //if checking for directory
        }//for loop
        if (folder.equalsIgnoreCase("core"))
            latestDir += "\\\bomclient\\core\\";
        else if (folder.equalsIgnoreCase("libs"))
            latestDir += "\\bomclient\\libs\\";
        System.out.println("Latest version: " + latestVersion);
        System.out.println("Dir: " + latestDir);
        return latestDir;
    }//latestVersion
    
    
    
}//class end
