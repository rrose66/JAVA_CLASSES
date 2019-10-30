import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BackUpTCresultsAndLogs {

	public static void main(String[] args) {
		String strCMD;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);;
		Date dateToday = new Date();
		final Calendar twoDaysAgo = Calendar.getInstance();
		twoDaysAgo.add(Calendar.DATE, -2);
		FileWriter newFile = null;
		BufferedWriter newTextBuffer = null;
		PrintWriter newTextPrinter = null;
		String strPartOfFileNameForToday;
		try
		{
			strPartOfFileNameForToday = dateFormat.format(dateToday.getTime());
			newFile = new FileWriter("C:\\PROJECTS\\EXECUTABLES\\BackUpTestCaseOutputs.bat",false);
			newTextBuffer = new BufferedWriter(newFile);
			newTextPrinter = new PrintWriter(newTextBuffer);

			//Add Part ----------------------------------------------------------
			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\application.log";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\ADD_PART_ANALYSIS\\applicationLog_"  + strPartOfFileNameForToday + ".TXT";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\application.log";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\applicationLog_addPart_"  + strPartOfFileNameForToday + ".TXT";
			newTextPrinter.println(strCMD);

			
			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\FEDETestCaseResults.xlsx";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\ADD_PART_ANALYSIS\\FEDETestCaseResults_"  + strPartOfFileNameForToday + ".xlsx";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMAddPart\\FEDETestCaseResults.xlsx";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\FEDETestCaseResults_addPart_"  + strPartOfFileNameForToday + ".xlsx";
			newTextPrinter.println(strCMD);

			
			//Edit Part ----------------------------------------------------------
			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\application.log";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\EDIT_PART_TEST_CASE_RESULTS_ANALYSIS\\applicationLog_"  + strPartOfFileNameForToday + ".TXT";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\application.log";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\applicationLog_editPart_"  + strPartOfFileNameForToday + ".TXT";
			newTextPrinter.println(strCMD);

			
			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\FEDETestCaseResults.xlsx";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\EDIT_PART_TEST_CASE_RESULTS_ANALYSIS\\FEDETestCaseResults_"  + strPartOfFileNameForToday + ".xlsx";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMEditPart\\FEDETestCaseResults.xlsx";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\FEDETestCaseResults__editPart_"  + strPartOfFileNameForToday + ".xlsx";
			newTextPrinter.println(strCMD);

			
			//WS AT_WEB_SERVICE_TESTING Part ----------------------------------------------------------
			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\application.log";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\AT_WEB_SERVICE_TESTING\\applicationLog_"  + strPartOfFileNameForToday + ".TXT";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\application.log";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\applicationLog_WS_"  + strPartOfFileNameForToday + ".TXT";
			newTextPrinter.println(strCMD);

			
			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\FEDETestCaseResults.xlsx";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\AT_WEB_SERVICE_TESTING\\FEDETestCaseResults_"  + strPartOfFileNameForToday + ".xlsx";
			newTextPrinter.println(strCMD);

			strCMD="";
			strCMD = strCMD + "COPY C:\\PROJECTS\\ACCUREV\\BOMinFEDE_TESTAUTOMATION_DEV_COLLAB_D04\\FEDEBOMAutomation\\Scripts\\FEDEBOMTestCaseAutomation\\FEDETestCaseResults.xlsx";
			strCMD = strCMD + "  C:\\PROJECTS\\DATA\\TEST_CASE_MONITORING\\FEDE_TEST_RESULTS_TODAY\\FEDETestCaseResults_WS_"  + strPartOfFileNameForToday + ".xlsx";
			newTextPrinter.println(strCMD);

			
			newTextPrinter.close();
		}
		catch (IOException allExceptions)
		{
			allExceptions.printStackTrace();
		}

	}

}
