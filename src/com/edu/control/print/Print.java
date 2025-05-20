package com.edu.control.print;

public class Print {

	public static void results(String[] date, double[] averageTemp, int maxStartDay, int maxWarmLength) {
		printAverageTemperatures(date, averageTemp);
		printLongestTrend(date, maxStartDay, maxWarmLength);
	}

	private static void printAverageTemperatures(String[] date, double[] averageTemp) {
		System.out.println("Средние температуры по дням:");
		for (int i = 0; i < date.length; i++) {
			System.out.printf("%s → %.1f%n", date[i], averageTemp[i]);
		}
		System.out.println();
	}

	private static void printLongestTrend(String[] date, int startDay, int length) {
		if (length > 1) {
			System.out.println("Самый длинный период повышения: " + length + " дней");
			System.out.println("С " + date[startDay] + " по " + date[startDay + length - 1]);
		} else {
			System.out.println("Не найдено периодов повышения температуры");
		}
	}
}
