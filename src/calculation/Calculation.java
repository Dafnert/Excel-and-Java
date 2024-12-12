package calculation;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Calculation {

	// Create a new Array
	ArrayList<Double> total = new ArrayList<Double>();

	public ArrayList<Double> multiplication(ArrayList<Double> row1, ArrayList<Double> row2) {
		// Check if the two ArrayList can be multiplied
		if (row1.size() != row2.size()) {
			System.out.println("Can't multiply");
		}
		// The for loop to multiplication all cells
		for (int i = 0; i < row1.size(); i++) {
			double resultMultiply = row1.get(i) * row2.get(i);
			// adds the result of the multiplication in the array
			total.add(resultMultiply);
		}
		System.out.print("Result of the mupltiply: " + total + "\n");
		return total;
	}

	public double average() {
		// Average
		double sum = 0;
		// the for loop so that it adds up the numbers
		for (double number : total) {
			sum += number;
		}
		// The calculation of the average
		double average = (double) sum / total.size();
		// The result must have only two decimal
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("The average: " + df.format(average) + "\n");
		return average;
	}

	public double standardDeviation() {
		//The variable where the average is
		double average = average();
		double sum = 0;
		double deviation;
		//Calculation of the sum of squared differences 
		for (int i = 0; i < total.size(); i++) {
			sum += Math.pow(total.get(i) - average, 2);
		}
		//Calculate the variance 
		double variance = sum / (total.size() - 1);
		//Square root of variance
		deviation = Math.sqrt(variance);
		//The result must have only two decimal
		double roundUp = Math.rint(deviation * 100) / 100;
		System.out.println("Desviation Standard:" + roundUp);
		return roundUp;
	}

}
