package teachersV3.jfreechart;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class Pie extends JFrame {

	private static final long serialVersionUID = 1L;

	public Pie(String applicationTitle, String chartTitle, int mode) {
		super(applicationTitle);
		// This will create the dataset
		if (mode == 0) {
			PieDataset dataset = createDatasetStudentMarks();
			// based on the dataset we create the chart
			JFreeChart chart = createChart(dataset, chartTitle);
			// we put the chart into a panel
			ChartPanel chartPanel = new ChartPanel(chart);
			// default size
			chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
			// add it to our application
			setContentPane(chartPanel);
		} else {
			PieDataset dataset = createDatasetPromotionAverage();
			// based on the dataset we create the chart
			JFreeChart chart = createChart(dataset, chartTitle);
			// we put the chart into a panel
			ChartPanel chartPanel = new ChartPanel(chart);
			// default size
			chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
			// add it to our application
			setContentPane(chartPanel);
		}

	}

	/**
	 * Creates a sample dataset
	 */

	private PieDataset createDatasetStudentMarks() {
		// [0,8[,[8-10[,[10-12[,12-15[,[15,20[
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("[0,8[", 2);
		result.setValue("[8-10[", 4);
		result.setValue("[10-12[", 4);
		result.setValue("[12-15[", 4);
		result.setValue("[15-20[", 4);
		return result;

	}

	/**
	 * Creates a sample dataset
	 */

	private PieDataset createDatasetPromotionAverage() {
		// [0,8[,[8-10[,[10-12[,12-15[,[15,20[
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("[0,8[", 2);
		result.setValue("[8-10[", 4);
		result.setValue("[10-12[", 4);
		result.setValue("[12-15[", 4);
		result.setValue("[15-20[", 4);
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
}