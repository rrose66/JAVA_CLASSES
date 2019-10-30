package dev.misc;

import java.io.File;

public class PathBuilder 
{
	public static void main(String[] args) 
	{
	      String first = "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_v1.0_Collab_DEV_D02\\build\\distributions\\BOMClient\\core\\";
	      String twice = "C:\\PROJECTS\\ACCUREV\\BOMinFEDE_v1.0_Collab_DEV_D02\\build\\distributions\\BOMClient\\libs\\";
	      String thrice = "C:\\temp\\FEDEBOM_UI\\FEDEBOM 2.56\\bomclient\\core\\";
	      String quad = "C:\\temp\\FEDEBOM_UI\\FEDEBOM 2.56\\bomclient\\libs\\";
	      String start = "\t<classpathentry kind=\"lib\" path=\"";
	      String end = "\"/>";
            // TODO Auto-generated method stub
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            System.out.println("<classpath>");
            System.out.println("\t<classpathentry kind=\"src\" path=\"src\"/>");
            System.out.println("\t<classpathentry kind=\"src\" path=\"resources/inputjson\"/>");
            System.out.println("\t<classpathentry excluding=\"inputjson/\" kind=\"src\" path=\"resources\"/>");

            File buildLibs = new File(first);
            File[] listOfBuildLibs = buildLibs.listFiles();
            //System.out.println("Accurev libs");
            for (File file : listOfBuildLibs){
                  System.out.println(start + file + end);
            }
            File buildCore = new File(twice);
            File[] listOfBuildCore = buildCore.listFiles();
            //System.out.println("Accurev core");
            for (File file : listOfBuildCore){
                  System.out.println(start + file + end);
            }
            File tempCore = new File(thrice);
            File[] listOfTempCore = tempCore.listFiles();
            //System.out.println("temp core");
            for (File file : listOfTempCore){
                  System.out.println(start + file + end);
            }
            File tempLibs = new File(quad);
            File[] listOfTempLibs = tempLibs.listFiles();
            //System.out.println("temp libs");
            for (File file : listOfTempLibs){
                  System.out.println(start + file + end);
            }

            System.out.println("\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
            System.out.println("\t<classpathentry kind=\"output\" path=\"bin\"/>");
            System.out.println("</classpath>");
	}

}
