package teachersV3.jFreeChart;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import teachersV3.Promotion;
import teachersV3.Student;
import teachersV3.exceptions.EmptyMarks;

public class PieChart extends JFrame {

	private static final long serialVersionUID = 1L;

	public PieChart(String applicationTitle, String chartTitle, Student s) {
		super(applicationTitle);
		// This will create the dataset
		PieDataset dataset = createDatasetMarksStudent(s);
		// based on the dataset we create the chart
		JFreeChart chart = createChart(dataset, chartTitle);
		// we put the chart into a panel
		ChartPanel chartPanel = new ChartPanel(chart);
		// default size
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		// add it to our application
		setContentPane(chartPanel);

	}

	public PieChart(String applicationTitle, String chartTitle, Promotion p) {
		super(applicationTitle);
		// This will create the dataset
		PieDataset dataset = createDatasetAveragePromotion(p);
		// based on the dataset we create the chart
		JFreeChart chart = createChart(dataset, chartTitle);
		// we put the chart into a panel
		ChartPanel chartPanel = new ChartPanel(chart);
		// default size
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		// add it to our application
		setContentPane(chartPanel);
	}

	/**
	 * Creates a sample dataset
	 */

	private PieDataset createDatasetMarksStudent(Student s) {
		DefaultPieDataset result = new DefaultPieDataset();
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		result.setValue("[0-8[", count1);
		result.setValue("[8-10[", count2);
		result.setValue("[10-12[", count3);
		result.setValue("[12-15[", count4);
		result.setValue("[15-20[", count5);

		for (int i = 0; i < s.marks.length; i++) {
			if (s.getMarks()[i] != null) {
				int mark = (int) (s.marks[i].getValue());

				if (mark >= 0 && mark <= 8) {
					result.setValue("[0-8[", count1++);

				} else if (mark >= 8 && mark <= 10) {
					result.setValue("[8-10[", count2++);

				} else if (mark >= 10 && mark <= 12) {
					result.setValue("[10-12[", count3++);

				} else if (mark >= 12 && mark <= 15) {
					result.setValue("[12-15[", count4++);

				} else {
					result.setValue("[15-20[", count5++);

				}
			}
		}
		return result;
	}

	/**
	 * Creates a sample dataset
	 */

	private PieDataset createDatasetAveragePromotion(Promotion p) {
		DefaultPieDataset result = new DefaultPieDataset();
		try {
			int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

			result.setValue("[0-8[", count1);
			result.setValue("[8-10[", count2);
			result.setValue("[10-12[", count3);
			result.setValue("[12-15[", count4);
			result.setValue("[15-20[", count5);

			for (int i = 0; i < p.list.size(); i++) {
				int average = (int) (p.list.get(i).average());

				System.out.println(average);

				if (average >= 0 && average <= 8) {
					result.setValue("[0-8[", count1++);

				} else if (average >= 8 && average <= 10) {
					result.setValue("[8-10[", count2++);

				} else if (average >= 10 && average <= 12) {

					result.setValue("[10-12[", count3++);

				} else if (average >= 12 && average <= 15) {
					result.setValue("[12-15[", count4++);

				} else {
					result.setValue("[15-20[", count5++);

				}
			}
		} catch (EmptyMarks e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Creates a chart
	 */

	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, // chart title
				dataset, // data
				true, // include legend
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;

	}

	public void windowClosing(final WindowEvent evt) {
		if (evt.getWindow() == this) {
			dispose();

		}
	}
}