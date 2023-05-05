package com.nttdata.logback.nttdatacenters_logback_t3_adl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of the project that contains the functionality of the program.
 * 
 * @author adri
 *
 */
public class App {
	private static final Random R = new Random();
	private static final Logger CONSOLE = LoggerFactory.getLogger("CONSOLE");
	public static final Logger FILE = LoggerFactory.getLogger("FILE");
	private static final String END_SENTENCE = " degrees.";

	/**
	 * Main method to initialize application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CONSOLE.debug("Program starts");
		try {
			load();
			userInterface();
		} catch (Exception ex) {
			CONSOLE.error(ex.getMessage());
		}
		CONSOLE.debug("Program ends");
	}

	/**
	 * Function that simulate temperature measurement for an hour and a relative
	 * heat value. Heat is a variable that increase or decrease overall temperature.
	 * 
	 * @param hour
	 * @param heat
	 * @return temperature value
	 */
	public static double tempSimulation(double hour, double minute, double heat) {
		// heat is a variable that increase or decrease overall temperature
		// 20 represents the average temperature during the day,
		// Math.cos(x) returns the trigonometric cosine of an angle that is in radians.
		// hour is a variable that determines the hour for which we simulate the
		// temperature.
		// 2*Math.PI represents the angle for completing a cycle.
		// 8 represents how much the temperature varies between the minimum and the
		// maximum,
		// 15 is the time at which the maximum temperature is reached,
		// 24 is the period of the oscillation (every 24 hours the function return to
		// initial state)
		return (heat + 20 + 8 * Math.cos((hour + (minute / 60) - 15) * 2 * Math.PI / 24));
	}

	/**
	 * Method to load data with random values . Cosine function is used to simulate
	 * the temperature variation during a day. It generates data for 3 days.
	 */
	public static void load() {
		CONSOLE.info("Loading data...");
		LocalDateTime time = LocalDateTime.now().minusDays(3).withHour(0); // Time of temperature measurement.
		double heat; // Variable that randomly increase or decrease temperature values to simulate
						// temperature randomness.
		for (int i = 0; i < 3; i++) {
			heat = R.nextDouble(12) - 4; // Each day there is a heat value. Randomly some days will be hotter than
											// others.
			for (int j = 0; j < 24; j++) {
				for (int k = 0; k < 60; k++) {
					new Measurement(time, tempSimulation(j, k, heat));
					time = time.plusMinutes(1);
				}
			}
		}
		CONSOLE.info("Succesfull load");
	}

	/**
	 * Method that provides user interface using eclipse console.
	 */
	public static void userInterface() {
		CONSOLE.trace("Printing menu");
		Scanner t = new Scanner(System.in);
		int e;
		do {

			System.out.println("---------------------Menu---------------------");
			System.out.println("1. New temperature register");
			System.out.println("2. Show stats");
			System.out.println("3. Save measurements");
			System.out.println("4. Close");

			e = t.nextInt();
			switch (e) {
			case 1:
				int month;
				int day;
				int hour;
				int minutes;
				int temp;
				System.out.println("Type month number");
				month = t.nextInt();
				monthControl(month);
				System.out.println("Type day number");
				day = t.nextInt();
				dayControl(day);
				System.out.println("Type hour of the day (no minutes)");
				hour = t.nextInt();
				hourControl(hour);
				System.out.println("Type minutes");
				minutes = t.nextInt();
				minutesControl(minutes);
				System.out.println("What value of temperature was measured? (ºC)");
				temp = t.nextInt();
				temperatureWarning(temp);
				new Measurement(LocalDateTime.of(2023, month, day, hour, minutes), temp);
				CONSOLE.info("Measurement registered");
				break;
			case 2:
				stats();
				break;
			case 3:
				String message;
				Collections.sort(Measurement.list);
				for (Measurement m : Measurement.list) {
					message = m.toString();
					FILE.info(message);
				}
				break;
			case 4:
				System.out.println("Have a nice day!");
				break;
			default:
				CONSOLE.error("You must Type number between 1 and 4");
				break;
			}

		} while (e != 4);
		t.close();
	}

//Warnings
	private static void temperatureWarning(int temp) {
		if (temp < 50 || temp < -20)
			CONSOLE.warn("Extreme temperature value");
	}

	private static void minutesControl(int minutes) {
		if (minutes < 0 || minutes > 59)
			CONSOLE.error("Invalid minutes value");
	}

	private static void hourControl(int hour) {
		if (hour < 0 || hour > 24)
			CONSOLE.error("Invalid hour value");
	}

	private static void dayControl(int day) {
		if (day < 1 || day > 31)
			CONSOLE.error("Invalid day value");
	}

	private static void monthControl(int month) {
		if (month < 1 || month > 12)
			CONSOLE.error("Invalid month value");
	}

	/**
	 * Method to show stats about data recorded
	 */
	public static void stats() {
		Scanner t = new Scanner(System.in);
		int month;
		int day;
		int e;
		System.out.println("For what day do you want to read stats?");
		System.out.println("Type month number");
		month = t.nextInt();
		monthControl(month);
		System.out.println("Type day number");
		day = t.nextInt();
		dayControl(day);
		Collections.sort(Measurement.list);
		try {
			LocalDateTime inputDate = LocalDateTime.of(2023, month, day, 0, 0);
			thereIsMeasurements(inputDate);
			CONSOLE.info("There are measurements for that day");

			do {
				System.out.println("Choose the stat");
				System.out.println("1. Max Temp");
				System.out.println("2. Min Temp");
				System.out.println("3. Temp Average");
				System.out.println("4. Go Back");
				e = t.nextInt();
				switch (e) {
				case 1:
					double max = Measurement.getMaxTemp(LocalDateTime.of(2023, month, day, 0, 0), 24, ChronoUnit.HOURS);
					System.out.println("That day maximum temperature was " + max + END_SENTENCE);
					break;
				case 2:
					double min = Measurement.getMinTemp(LocalDateTime.of(2023, month, day, 0, 0), 24, ChronoUnit.HOURS);
					System.out.println("That day minimum temperature was " + min + END_SENTENCE);
					break;
				case 3:
					int avg = Measurement.getAvg(LocalDateTime.of(2023, month, day, 0, 0), 24, ChronoUnit.HOURS);
					System.out.println("Temperatture avergae that day was " + avg + END_SENTENCE);
					break;
				case 4:
					break;
				default:
					CONSOLE.error("You must Type number between 1 and 4");
					break;
				}
			} while (e != 4);

		} catch (Exception ex) {
			CONSOLE.error(ex.getMessage());

		}

		t.close();
	}

	/**
	 * Method that checks if there is any measurement for the day indicated
	 * 
	 * @param inputDate
	 * @throws NoMeasurementException
	 */
	private static void thereIsMeasurements(LocalDateTime inputDate) throws NoMeasurementException {
		Collections.sort(Measurement.list);
		if (inputDate.isBefore(Measurement.list.get(0).gethour()))
			throw new NoMeasurementException();
	}

}
