package main;



import java.util.ArrayList;

import calculation.Calculation;
import excel.ExcelRead;
import excel.ExcelWriter;
import graphic.Graphic;

public class Main {

	public static void main(String[] args) {
		// Create a two ArrayList empty because there is two rows in the excel
		ArrayList<Double> row1 = new ArrayList<>();
		ArrayList<Double> row2 = new ArrayList<>();
		// Read the excel in java
		ExcelRead excelRead = new ExcelRead();
		excelRead.readExcel(row1, row2);
		//Calculations the multiply, the average and desviacion
		Calculation calculation = new Calculation();
		calculation.multiplication(row1, row2);
		 calculation.average();		
		calculation.standardDeviation();	
		//Create a excel with data
		ExcelWriter excelWriter = new ExcelWriter();
		excelWriter.createExcel(row2, row1);
		//Graphic
		Graphic graphic = new Graphic();
		graphic.graphicResults(row1, row2);
		
	}
}
