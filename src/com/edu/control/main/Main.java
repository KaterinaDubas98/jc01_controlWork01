package com.edu.control.main;

import com.edu.control.analisis.TemperatureAnalysis;
import com.edu.control.print.Print;

public class Main {

	public static void main(String[] args) {
		String[] date = { "2024-04-24", "2024-04-25", "2024-04-26", "2024-04-27", "2024-04-28", "2024-04-29",
				"2024-04-30" };
		double[] morningTemp = { 10, 12, 11, 13, 15, 17, 16 };
		double[] dayTemp = { 15, 12, 15, 18, 20, 22, 21 };
		double[] eveningTemp = { 12, 13, 14, 15, 17, 19, 18 };

		TemperatureAnalysis analiz = new TemperatureAnalysis(date, morningTemp, dayTemp, eveningTemp);
		analiz.warmingPeriod();
		int[] warmInfo = analiz.warmingPeriod();

		Print.results(analiz.getDate(), analiz.getAverageTemp(), warmInfo[0], warmInfo[1]);

	}

}
