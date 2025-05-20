package com.edu.control.analisis;

public class TemperatureAnalysis {

	private String[] date;
	private double[] morningTemp;
	private double[] dayTemp;
	private double[] eveningTemp;
	private double[] averageTemp;

	public TemperatureAnalysis(String[] date, double[] morningTemp, double[] dayTemp, double[] eveningTemp) {
		this.date = date;
		this.morningTemp = morningTemp;
		this.dayTemp = dayTemp;
		this.eveningTemp = eveningTemp;
		this.averageTemp = calculateAverageTemp();
	}

	private double[] calculateAverageTemp() {
		double[] averageDayTemp = new double[dayTemp.length];

		for (int i = 0; i < dayTemp.length; i++) {
			averageDayTemp[i] = (morningTemp[i] + dayTemp[i] + eveningTemp[i]) / 3;
		}
		return averageDayTemp;
	}

	public int[] warmingPeriod() {
		int maxWarmLength = 1;
		int currentLength = 1;
		int startDay = 0;
		int maxStartDay = 0;

		for (int i = 1; i < averageTemp.length; i++) {
			if (averageTemp[i] > averageTemp[i - 1]) {
				currentLength++;
			} else {
				if (currentLength > maxWarmLength) {
					maxWarmLength = currentLength;
					maxStartDay = startDay;
				}
				currentLength = 1;
				startDay = i;
			}
		}

		if (currentLength > maxWarmLength) {
			maxWarmLength = currentLength;
			maxStartDay = startDay;
		}

		return new int[] { maxStartDay, maxWarmLength };
	}

	public String[] getDate() {
		return date;
	}

	public double[] getAverageTemp() {
		return averageTemp;
	}

}
