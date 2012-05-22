package teachersV3.jFreeChart;

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

/**
 * Contains the implementation for jFreeChart (Pie chart).<br />
 * <br />
 * 
 * Copyright 2012 - This file is part of the Java Project : Teachers.<br />
 * <br />
 * 
 * Teachers is free software: you can redistribute it and/or modify it under the
 * terms of the zlib license.<br />
 * See the COPYING file.<br />
 * <br />
 * 
 * @author Jeremy LOR (jlor@etudiant.univ-mlv.fr)
 * @author Thomas LEROUX (tleroux@etudiant.univ-mlv.fr)
 */
public class PieChart extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Build the PieChart for the student (marks).
	 * 
	 * @param applicationTitle
	 *            Name of the application.
	 * @param chartTitle
	 *            Name of the chart.
	 * @param s
	 *            The student.
	 */
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

	/**
	 * Build the PieChart for the Promotion (average of students).
	 * 
	 * @param applicationTitle
	 *            Name of the application.
	 * @param chartTitle
	 *            Name of the chart.
	 * @param p
	 *            The promotion.
	 */
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
	 * Create datas for marks' student.
	 * 
	 * @param s
	 *            The student.
	 * @return a PieDataSet with datas (marks' values from 0 to 20).
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
					result.setValue("[0-8[", ++count1);

				} else if (mark >= 8 && mark <= 10) {
					result.setValue("[8-10[", ++count2);

				} else if (mark >= 10 && mark <= 12) {
					result.setValue("[10-12[", ++count3);

				} else if (mark >= 12 && mark <= 15) {
					result.setValue("[12-15[", ++count4);

				} else {
					result.setValue("[15-20[", ++count5);

				}
			}
		}
		return result;
	}

	/**
	 * Create datas for averages in a Promotion.
	 * 
	 * @param p
	 *            The promotion.
	 * @return a PieDataSet with datas (averages' values from 0 to 20 of the
	 *         promotion).
	 */
	private PieDataset createDatasetAveragePromotion(Promotion p) {
		DefaultPieDataset result = new DefaultPieDataset();

		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		result.setValue("[0-8[", count1);
		result.setValue("[8-10[", count2);
		result.setValue("[10-12[", count3);
		result.setValue("[12-15[", count4);
		result.setValue("[15-20[", count5);
		try {
			int i;
			for (i = 0; i < p.list.size(); i++) {
				int average = (int) (p.list.get(i).average());

				if (average >= 0 && average <= 8) {
					result.setValue("[0-8[", ++count1);

				} else if (average >= 8 && average <= 10) {
					result.setValue("[8-10[", ++count2);

				} else if (average >= 10 && average <= 12) {

					result.setValue("[10-12[", ++count3);

				} else if (average >= 12 && average <= 15) {
					result.setValue("[12-15[", ++count4);

				} else {
					result.setValue("[15-20[", ++count5);

				}
			}
		} catch (EmptyMarks e) {
			System.out.println("Someone has no marks in the Promotion !");
		}
		return result;
	}

	/**
	 * Build the frame for the Chart.
	 * 
	 * @param dataset
	 *            The datas.
	 * @param title
	 *            The title of the chart.
	 * @return a JFreeChart (window) to display the chart.
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