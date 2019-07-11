package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	public ExcelUtils(String excelPath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}

		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}



	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0, 0);
		getCellDataNumber(1, 1);
	}



	public static int getRowCount() {
		int rowCount = 0;

		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of RowCount:" +rowCount);
		}

		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}




	public static int  getColCount() {
		int colCount = 0;

		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of ColumnCount:" +colCount);
		}

		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}


	// Taking a String value to the excel sheet
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;

		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("CellDataString: " + cellData );
		}

		catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}



	// Taking a Integer value to the excel sheet
	public static void getCellDataNumber(int rowNum, int colNum) {

		try {
			double cellDataNumber = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("CellDataNumber :" +cellDataNumber);
		}

		catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}




}
