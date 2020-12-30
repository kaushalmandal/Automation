package coreFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;

/**
 * This class consists of all the methods required to interact with the test
 * data excel file
 * 
 * @author kapildev j
 * @version 1.0
 * @since 15-Dec-2015
 */
public class ExcelUtil extends ExtentManager{

	public static String filename = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\TestData.xlsx";
	public static String Milestonefilename = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Milestone.xlsx";
//	public static String testDataWorkSheetName = "Regression_Test_Data";
	public static String testDataWorkSheetName2 = "Test_Ouptut";
	public static String testDataWorkSheetName3 = "Testoutput";
	public static String testDataWorkSheetName4 = "Testoutput1";
	public static String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;

	/**
	 * This method is used to connect to excel. This is a constructor.
	 * 
	 * @param path
	 *            Test data file location
	 * @author kapildev j
	 */
	public ExcelUtil(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			  workbook = new XSSFWorkbook(fis);
			  sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method is used to get row count
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @return returns the row count in a sheet
	 * @author kapildev j
	 * @throws IOException 
	 */
	public static int getRowCount(String sheetName) throws IOException {
		try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	/**
	 * This method is used to get cell data
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @param colName
	 *            Column name
	 * @param rowNum
	 *            Row number
	 * @return returns the data from a cell
	 * @author kapildev j
	 */
	public static String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/**
	 * This method is used to get cell data
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @param colNum
	 *            Column number
	 * @param rowNum
	 *            Row number
	 * @return returns the data from a cell
	 * @author kapildev j
	 */

	public static String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			
			if (cell == null)
				return "";
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if ( cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				return cell.getRawValue();
			}
//			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC ) {
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	public String getCellData1(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}
	/**
	 * This method is used to get cell data
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @param colName
	 *            Column name
	 * @param rowNum
	 *            Row number
	 * @return returns the data from a cell
	 * @author 
	 */
	public static String getCellDataWithColName(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}


	/**
	 * This method is used to set string value in excel's cell
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @param colName
	 *            Column name
	 * @param rowNum
	 *            Row number
	 * @param data
	 *            Value to set should be a string
	 * @return returns true if data is set successfully else false
	 * @author kapildev j
	 */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j).getStringCellValue().trim().equals(colName))
					colNum = j;
//				break;
			}
			int colNum1 = -1;
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				if (row.getCell(j).getStringCellValue().trim().equals("Status"))
//					colNum1 = j;
//				sheet.autoSizeColumn(colNum1);
//				row = sheet.getRow(rowNum - 1);
//				if (cell == null)
//					cell = row.createCell(colNum1);
//					cell.setCellValue(App_CommonFunctions.orderNoFetch("Order_Status"));
//					break;
//			}
			
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);

			fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean setCellData1(String sheetName, String colName, int rowNum, String status) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(status);

			fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method is used to set url value in excel's cell
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @param colName
	 *            Column name
	 * @param rowNum
	 *            Row number
	 * @param data
	 *            Value to set should be a url
	 * @return returns true if data is set successfully else false
	 * @author kapildev j
	 */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);
			XSSFCreationHelper createHelper = (XSSFCreationHelper) workbook.getCreationHelper();

			CellStyle hlink_style = workbook.createCellStyle();
			XSSFFont hlink_font = workbook.createFont();
			hlink_font.setUnderline(XSSFFont.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);

			XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlink_style);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String SetCellData1(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	/**
	 * This method is used add work sheet
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @return returns true if sheet is successfully created else false
	 * @author kapildev j
	 */
	public boolean addSheet(String sheetname) {

		FileOutputStream fileOut;
		try {
			workbook.createSheet(sheetname);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method is used remove work sheet
	 * 
	 * @param sheetName
	 *            Sheet name in the excel
	 * @return returns true if sheet is successfully removed else false
	 * @author kapildev j
	 */
	public boolean removeSheet(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addColumn(String sheetName, String colName) {

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return false;

			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);

			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellStyle(style);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			@SuppressWarnings("unused")
			XSSFCreationHelper createHelper = (XSSFCreationHelper) workbook.getCreationHelper();
			style.setFillPattern(HSSFCellStyle.NO_FILL);

			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	public int getColumnCount(String sheetName) {

		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();
	}

	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url, String message) throws Exception {

		url = url.replace('\\', '/');
		if (!isSheetExist(sheetName))
			return false;

		sheet = workbook.getSheet(sheetName);

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {

				setCellData(sheetName, screenShotColName, i + index, message, url);
				break;
			}
		}

		return true;
	}

	public int getCellRowNum(String sheetName, String colName, String cellValue) throws Exception {

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}
	 public  static int RwNumber(String Sheetname,String rowTestCaseName) throws Exception{
		  int rowFlag = 0;
			int colnFlag = 0;
			int rowCount = getRowCount(Sheetname);
			int testcaserow = 0;
			for (int row = 1; row <= rowCount; row++) {
				String testNameInExcelRow = getCellData(Sheetname, 1, row);
				if (testNameInExcelRow.equals(rowTestCaseName)) {
					rowFlag = testcaserow;
					testcaserow=row;
					break;
				}
			}
		return testcaserow+1;
		  
	  }

	/**
	 * This method is used get data from the test data excel
	 * 
	 * @param rowTestCaseName
	 *            Test Case name in the test data
	 * @param columnName
	 *            Column name in the test data
	 * @return returns the value corresponding to the test case and the column
	 *         name
	 * @author kapildev j
	 * @throws IOException 
	 */
	public static String getDataFromExcel(String rowTestCaseName, String columnName) throws IOException {

		ExcelUtil dataTable = null;
		int rowFlag = 0;
		int colnFlag = 0;
		String testDataWorkSheetName=ORUtil.getConfigValue("testDataWorkSheetName");
		try {
			dataTable = null;
			dataTable = new ExcelUtil(filename);
			rowFlag = 0;
			colnFlag = 0;
			int rowCount = dataTable.getRowCount(testDataWorkSheetName);
			int columnCount = dataTable.getColumnCount(testDataWorkSheetName);

			for (int row = 1; row <= rowCount; row++) {
				String testNameInExcelRow = dataTable.getCellData(testDataWorkSheetName, 1, row);
				if (testNameInExcelRow.equals(rowTestCaseName)) {
					rowFlag = row;
					break;
				}
			}

			for (int col = 0; col <= columnCount; col++) {
				String testNameInExcelColn = dataTable.getCellData(testDataWorkSheetName, col, 1);
				if (testNameInExcelColn.equals(columnName)) {
					colnFlag = col;
					break;
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Error in finding test data in excel file");
//			ReportUtil.reporterEvent("fail", "Error in finding test data in excel file");
			e.printStackTrace();
		}

		return dataTable.getCellData(testDataWorkSheetName, colnFlag, rowFlag);

	}

	public String getDataFromExcelfromsheet(int sheetindex, int row, int column) {
		String data = null;
		sheet = workbook.getSheetAt(sheetindex);
		XSSFCell d = sheet.getRow(row).getCell(column);
		int type = d.getCellType();
		if (type == Cell.CELL_TYPE_NUMERIC) {
//			data = String.valueOf(d.getNumericCellValue());
//			if (HSSFDateUtil.isCellDateFormatted(d)) {
//
//				double d1 = cell.getNumericCellValue();
//
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(HSSFDateUtil.getJavaDate(d1));
//				data = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
//				data = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + data;
//				System.out.println(data);
//			}
			data = String.valueOf(d.getNumericCellValue());
			System.out.println("Data is :"+data);
			if (HSSFDateUtil.isCellDateFormatted(d)) {
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date data1 = d.getDateCellValue();
			System.out.println(data1);
			String Actualdate=df.format(data1);
			System.out.println(Actualdate);
			data=Actualdate;
			}
//			System.out.println("Actual Date:"+Actualdate);
////			
//			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
//			Date date = (Date)formatter.format(date data1);
//			System.out.println(date);        
//
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(date);
//			String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
//			System.out.println("formatedDate : " + formatedDate);    
		} else {
			data = d.getStringCellValue();
		}
		return data;

	}

	public static String getDataFromExcelfromsheet2() {

		ExcelUtil dataTable = null;

		String[] array = null;
		String row2 = null;

		try {
			dataTable = null;
			dataTable = new ExcelUtil(filename);

			int rowCount = dataTable.getRowCount(testDataWorkSheetName2);
			System.out.println(rowCount);
			int columnCount = dataTable.getColumnCount(testDataWorkSheetName2);
			System.out.println(columnCount);

			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(1);

			for (int row = 1; row <= rowCount; row++) {

				Row row1 = sheet.getRow(row);

				for (int col = 1; col <= row1.getLastCellNum(); col++) {

					row2 = sheet.getRow(row).getCell(col).getStringCellValue();

					System.out.println(row2);

				}
			}
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Error in finding test data in excel file");
			e.printStackTrace();
		}
		return row2;

	}

	public static boolean setDatatoExcel(String testsheetname,String rowTestCaseName, String columnName, String data) {

		ExcelUtil dataTable = null;
		int rowFlag = 0;
		int colnFlag = 0;
		try {
			dataTable = null;
			dataTable = new ExcelUtil(filename);
			rowFlag = 0;
			colnFlag = 0;
			int rowCount = dataTable.getRowCount(testsheetname);
			int columnCount = dataTable.getColumnCount(testsheetname);

			for (int row = 1; row <= rowCount; row++) {
				String testNameInExcelRow = dataTable.getCellData(testsheetname, 0, row);
				if (testNameInExcelRow.equals(rowTestCaseName)) {
					rowFlag = row;
					break;
					
				}
			}
			

		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Error in finding test data in excel file");
			e.printStackTrace();
		}
		
		return dataTable.setCellData(testsheetname, columnName, rowFlag, data);

	}

	public static boolean setDatatoExcel2(String rowTestCaseName, String columnName, String status) {

		ExcelUtil dataTable = null;
		int rowFlag = 0;
		int colnFlag = 0;
		try {
			dataTable = null;
			dataTable = new ExcelUtil(filename);
			rowFlag = 0;
			colnFlag = 0;
			int rowCount = dataTable.getRowCount(testDataWorkSheetName3);
			int columnCount = dataTable.getColumnCount(testDataWorkSheetName3);

			for (int row = 1; row <= rowCount; row++) {
				String testNameInExcelRow = dataTable.getCellData(testDataWorkSheetName3, 0, row);
				if (testNameInExcelRow.equals(rowTestCaseName)) {
					rowFlag = row;
					break;
				}
			}

		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Error in finding test data in excel file");
			e.printStackTrace();
		}

		return dataTable.setCellData1(testDataWorkSheetName3, columnName, rowFlag, status);

	}
	public static boolean setDatatoExcel3(String rowTestCaseName, String columnName, String status) {

		ExcelUtil dataTable = null;
		int rowFlag = 0;
		int colnFlag = 0;
		try {
			dataTable = null;
			dataTable = new ExcelUtil(Milestonefilename);
			rowFlag = 0;
			colnFlag = 0;
			int rowCount = dataTable.getRowCount("Milestone");
			int columnCount = dataTable.getColumnCount("Milestone");

			for (int row = 1; row <= rowCount; row++) {
				String testNameInExcelRow = dataTable.getCellData("Milestone", 1, row);
				if (testNameInExcelRow.equals(rowTestCaseName)) {
					rowFlag = row;
					break;
				}
			}

		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Error in finding test data in excel file");
			e.printStackTrace();
		}

		return dataTable.setCellData1("Milestone", columnName, rowFlag, status);

	}
	
	  public ArrayList TestcaseListTorun(int rowscount,String SheetName)
	  {
		  Map<String, String> hm = new TreeMap<String, String>();  
		  ArrayList<String> Runlist = new ArrayList<String>();
		  for(int i=1; i<=rowscount;i++){
			 hm.put(getCellDataWithColName(SheetName,"Test_Case",i),getCellDataWithColName(SheetName,"Run_Flag",i)); 
		  }
		  Set<String> keys = hm.keySet();
	      /*  for(String key: keys){
	        	if(hm.containsKey("Y")){
	            System.out.println("Value of "+key+" is: "+hm.get(key));
	        	}
	        }*/
		  for (Map.Entry<String,String> entry : hm.entrySet()) {
			  String key = entry.getKey();
			 
			  String value = entry.getValue();
			 
			  if(value.equalsIgnoreCase("Y")){
				 
				  Runlist.add(key);
//				  System.out.println(key);  
			  }
			  // do stuff
			}
		 
		return Runlist;
	  }

}
