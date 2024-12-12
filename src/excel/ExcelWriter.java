package excel;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import calculation.Calculation;

public class ExcelWriter {

	public void createExcel(ArrayList<Double> row1, ArrayList<Double> row2) {
		// Create a excel
		Workbook book = new XSSFWorkbook();
		// The name of the sheet
		Sheet sheet = book.createSheet("Results");
		// Create a row and put the value in the cells
		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("Multiplication");
		titleRow.createCell(1).setCellValue("Average");
		titleRow.createCell(2).setCellValue("Arithmetical deviation");

		// Call the methods
		Calculation calculation = new Calculation();
		ArrayList<Double> total = calculation.multiplication(row1, row2);
		double average = calculation.average();
		double desviacion = calculation.standardDeviation();
		//The for loop create the rows and put the values of the multiplication results in the cells
		for (int i = 0; i < total.size(); i++) {
			Row row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(total.get(i));
		}
		int lastRowIndex = total.size() + 1;
		Row resultRow = sheet.createRow(lastRowIndex);
		resultRow.createCell(1).setCellValue(average);
		resultRow.createCell(2).setCellValue(desviacion);
		try {
			FileOutputStream outputStream = new FileOutputStream("files/Results.xlsx");
			book.write(outputStream);
			book.close();
			System.out.println("Book save");
		} catch (FileNotFoundException ex) {
			System.out.println("Error de filenotfound");
		} catch (IOException ex) {
			System.out.println("Error de IOException");
		}
	}
}
