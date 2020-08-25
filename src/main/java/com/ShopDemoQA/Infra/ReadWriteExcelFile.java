package com.ShopDemoQA.Infra;

import java.io.FileOutputStream;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelFile {
	static String projectPath;
	static XSSFWorkbook workbook;
	static HSSFWorkbook workbook1;
	static XSSFSheet sheet;

	public ReadWriteExcelFile(String projectPath, String sheetName) {
		try {
			// Get Project Directory
			// projectPath = System.getProperty("user.dir");

			// Reference for new excel workbook format (xlxs)
			workbook = new XSSFWorkbook(projectPath);

			// Reference for old excel workbook format (xls)
			workbook1 = new HSSFWorkbook();

			// Reference for Worksheet
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void getRowCount() {
		try {

			// Get Excel Row Count
			int rowCount = sheet.getPhysicalNumberOfRows();
			// System.out.println("This is the Row Count " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public String userName(int rownum) {

		String userName = sheet.getRow(rownum).getCell(0).getStringCellValue();

		return userName;

	}

	public String password(int rownum) {
		String password = sheet.getRow(rownum).getCell(1).getStringCellValue();

		return password;

	}

	public void writeexcel(int rownum, String email, String path) {
		try {

			// Get Excel Row Count
			// int rowCount = sheet.getPhysicalNumberOfRows();
			sheet.getRow(rownum).createCell(1).setCellValue(email);

			FileOutputStream output = new FileOutputStream(path);
			workbook.write(output);

			// System.out.println("This is the Row Count " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

}
