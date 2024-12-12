package graphic;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import calculation.Calculation;

public class Graphic {
	public void graphicResults(ArrayList<Double> row1, ArrayList<Double> row2) {
		Calculation calculation = new Calculation();
		ArrayList<Double> total = calculation.multiplication(row1, row2);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < total.size(); i++) {
			dataset.addValue(total.get(i), "Multiplication", "Value " + (i + 1));
		}
		
		//create the graphic lines about the result multiplication
		JFreeChart chart = ChartFactory.createLineChart(
				"ArrayList Results", // Title of the graphic
				"Array position", //value x
				"Results multiplication", //value y
				dataset);
	
		
		ChartPanel chartPanel = new ChartPanel(chart);
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setContentPane(chartPanel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
