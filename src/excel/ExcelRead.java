package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	// Create a two ArrayList empty because there is two rows in the excel
	ArrayList<Double> row1 = new ArrayList<>();
	ArrayList<Double> row2 = new ArrayList<>();

	public void readExcel(ArrayList<Double> row1, ArrayList<Double> row2) {

		try {
			// Excel for take out the information
			File file = new File("files/datos.xlsx");
			InputStream inputStream = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(inputStream);
			// Reference a sheet
			Sheet firstSheet = wb.getSheetAt(0);
			// getRow() returns the first row
			Row firstRow = firstSheet.getRow(0);
			// The for loop to loop through all cells
			for (Cell cell : firstRow) {
				row1.add(cell.getNumericCellValue());
			}
			// getRow() returns the second row
			Row secondRow = firstSheet.getRow(1);
			for (Cell cell : secondRow) {
				row2.add(cell.getNumericCellValue());
			}
			System.out.println("Row 1: " + row1);
			System.out.println("Row 2: " + row2);
			// Close the Workbook and InputStream
			wb.close();
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		}
	}

}
