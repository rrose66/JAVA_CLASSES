package dev.misc;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateSpreadsheet {

	private static final String FILE_NAME = "C:\\DEV\\UTILITIES_DATA\\FEDETestCaseResults.xlsx";

	private static Logger logger = Logger.getLogger(CreateSpreadsheet.class);

	public void createUpdateResultExcelSheet(String mode, String env, String testCaseId, String testCaseName, String operationResult,
			String startTime, String endTime, long duration, String errorMsg) {

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(new File(FILE_NAME));
		} catch (FileNotFoundException e1) {
			logger.error(e1.getMessage());
		}
		if (inputStream == null) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("FEDE Test Case results");
			Object[][] datatypes = {
					{ "Mode", "Envirnoment", "Test Case Id", "Test Case Name", "Result", "Start Date Time", "End Date Time",
							"Duration(ms)", "Results/Error Msg" },
					{ mode, env, testCaseId, testCaseName, operationResult, startTime, endTime, duration, errorMsg }

			};

			int rowNum = 0;

			for (Object[] datatype : datatypes) {
				Row row = sheet.createRow(rowNum++);
				int colNum = 0;
				for (Object field : datatype) {
					Cell cell = row.createCell(colNum++);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Long) {
						cell.setCellValue((Long) field);
					}
				}
			}

			try {
				outputStream = new FileOutputStream(FILE_NAME);
				workbook.write(outputStream);

			} catch (IOException | EncryptedDocumentException ex) {
				logger.error(ex.getMessage());
			} finally {
				try {
					if (workbook != null) {
						workbook.close();
					}
					if (inputStream != null) {
						inputStream.close();
					}
					if (outputStream != null) {
						outputStream.close();
					}
				} catch (IOException ex) {
					logger.error(ex.getMessage());
				}
			}
		} else {
			Workbook workbook = null;
			try {
				workbook = WorkbookFactory.create(inputStream);
			} catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
				logger.error(ex.getMessage());
			}

			Sheet sheet = workbook.getSheetAt(0);

			Object[][] datatypes = { { mode, env, testCaseId, testCaseName, operationResult, startTime, endTime, duration, errorMsg }

			};

			int rowCount = sheet.getLastRowNum();

			for (Object[] datatype : datatypes) {
				Row row = sheet.createRow(++rowCount);
				int colNum = 0;
				for (Object field : datatype) {
					Cell cell = row.createCell(colNum++);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Long) {
						cell.setCellValue((Long) field);
					}
				}
			}

			try {
				outputStream = new FileOutputStream(FILE_NAME);
				workbook.write(outputStream);
			} catch (IOException | EncryptedDocumentException ex) {
				logger.error(ex.getMessage());
			} finally {
				try {
					if (workbook != null) {
						workbook.close();
					}
					if (inputStream != null) {
						inputStream.close();
					}
					if (outputStream != null) {
						outputStream.close();
					}
				} catch (IOException ex) {
					logger.error(ex.getMessage());
				}
			}
		}
	}
}
