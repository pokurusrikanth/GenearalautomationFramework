package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exception.PropertiesFileNotFoundException;
import exception.TestCaseNotFoundInDataFileException;

public class DataUtil {

	private static XSSFWorkbook getWorkBook(String filepath) {

		try {
			if (FileUtils.is_File_Exists(filepath)) {
				return new XSSFWorkbook(new FileInputStream(filepath));

			} else {
				return null;
			}

		} catch (IOException e) {
			return null;
		}

	}

	private static ArrayList<String> getAllColumns(XSSFSheet sheet) {
		ArrayList<String> list = new ArrayList<>();
		XSSFRow row = sheet.getRow(0);
		int allcolumns = row.getLastCellNum();

		for (int columns = 0; columns <= allcolumns - 1; columns++) {

			list.add(row.getCell(columns).toString().toUpperCase());
		}
		return list;
	}

	private static XSSFRow getTestCaseRow(XSSFSheet sheet, String testcaseid) {
		ArrayList<String> allColumns = getAllColumns(sheet);
		if (allColumns.contains("TC_ID")) {
			int colPos = allColumns.indexOf("TC_ID");
			int totalRows = sheet.getLastRowNum();
			for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				XSSFCell tcCell = row.getCell(colPos);
				if (tcCell != null) {
					String tc_id = tcCell.toString();
					if (tc_id.equalsIgnoreCase(testcaseid)) {
						return row;
					}

				}
			}
		} else {
			throw new TestCaseNotFoundInDataFileException("tc_id not found in the data file");
		}
		return null;

	}

	public static HashMap<String, Object> get_Data_From_Excel_To_Hashmap(String filepath, String strSheetName,
			String testcaseid) {

		XSSFWorkbook wb = getWorkBook(filepath);
		HashMap<String, Object> testCaseData = new HashMap<String, Object>();
		if (wb != null) {
			XSSFSheet sheet = getSheet(wb, strSheetName);
			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow tcRow = getTestCaseRow(sheet, testcaseid);
			int totalColumns = headerRow.getLastCellNum();
			for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
				String columnHeader = headerRow.getCell(columnIndex).toString().toUpperCase();
				XSSFCell tcDataCell = tcRow.getCell(columnIndex);
				if (tcDataCell != null) {
					testCaseData.put(columnHeader, tcDataCell);
				} else {
					testCaseData.put(columnHeader, "");
				}
			}
			try {
				wb.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return testCaseData;

	}

	public HashMap<String, String> get_Data_Properties_To_Map(String filePath) {
		HashMap<String, String> propData = new HashMap<String, String>();

		try {
			FileInputStream fis = new FileInputStream(filePath);
			Properties props = new Properties();
			props.load(fis);
			Set<Object> keyset = props.keySet();
			for (Object eachKey : keyset) {
				propData.put(eachKey.toString(), props.get(eachKey).toString());
			}
		} catch (IOException e) {
			throw new PropertiesFileNotFoundException(
					"the properties file" + filePath + "is not found in the given path ");
		}
		return propData;

	}

	public Object[][] get_Data_From_Excel_To_Array(String filepath, String sheetname) {
		Object[][] tcdata;
		XSSFWorkbook wb = getWorkBook(filepath);
		if (wb != null) {

			XSSFSheet sheet = getSheet(wb, sheetname);
			int totalrows = sheet.getLastRowNum();
			tcdata = new Object[totalrows + 1][];

			for (int rowindex = 0; rowindex <= totalrows; rowindex++) {
				XSSFRow row = sheet.getRow(rowindex);
				int totalcolumns = row.getLastCellNum();
				tcdata[rowindex] = new Object[totalcolumns];
				for (int columnindex = 0; columnindex < totalcolumns; columnindex++) {
					XSSFCell cell = row.getCell(columnindex);
					if (cell != null) {
						tcdata[rowindex][columnindex] = cell.toString();
					} else {
						tcdata[rowindex][columnindex] = null;
					}
				}
			}
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tcdata;
		} else {
			System.out.println("file" + filepath + "not exists");
		}
		return null;

	}

	private static XSSFSheet getSheet(XSSFWorkbook workbook, String sheetNmae) {

		int sheetindex = workbook.getSheetIndex(sheetNmae);
		if (sheetindex < 0) {
			return null;
		} else {
			return workbook.getSheet(sheetNmae);
		}

	}

}
