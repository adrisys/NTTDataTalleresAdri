package com.nttdata.logback.nttdatacenters_logback_t3_adl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Class that represents a temperature measurement, contains information about
 * the temperature(ºC) and the time in which that measurement was taken.
 * 
 * @author adri
 *
 */
class Measurement implements Comparable<Measurement> {
	static List<Measurement> list = new ArrayList<>();
	private LocalDateTime hour;
	private double temp;

	/**
	 * Class constructor
	 * 
	 * @param hour
	 * @param temp
	 */
	public Measurement(LocalDateTime hour, double temp) {
		this.hour = hour;
		this.temp = temp;
		list.add(this);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "Day " + this.gethour().getDayOfMonth() + " of " + this.gethour().getMonth() + " at "
				+ this.gethour().format(DateTimeFormatter.ofPattern("HH:mm")) + " it was " + this.gettemp()
				+ " degrees.";
	}

	/**
	 * Method to list all measurements recorded
	 */
	public static void listAll() {
		for (Measurement r : list) {
			System.out.println(r.toString());
			System.out.println("");
		}
	}

	/**
	 * Method to obtain measurements recorded on certain time period.
	 * 
	 * @param start
	 * @param period
	 * @param units
	 * @return list with requested measurements.
	 */
	public static List<Measurement> obtainMeasurements(LocalDateTime start, long period, TemporalUnit units) {
		List<Measurement> output = new ArrayList<>();
		for (Measurement r : list) {
			if (r.hour.isAfter(start) && r.hour.isBefore(start.plus(period, units))) {
				output.add(r);
			}
		}
		return output;
	}

	/**
	 * Method to obtain max temp on certain time period
	 * 
	 * @param start
	 * @param period
	 * @param units
	 * @return max value
	 */
	public static double getMaxTemp(LocalDateTime start, long period, TemporalUnit units) {
		return Collections.max(obtainMeasurements(start, period, units)).gettemp();
	}

	/**
	 * Method to obtain min temp on certain time period
	 * 
	 * @param start
	 * @param period
	 * @param units
	 * @return min value
	 */
	public static double getMinTemp(LocalDateTime start, long period, TemporalUnit units) {
		return Collections.min(obtainMeasurements(start, period, units)).gettemp();
	}

	/**
	 * Method to obtain temperature average on certain time period
	 * 
	 * @param start
	 * @param period
	 * @param units
	 * @return valor de la temp media
	 */
	public static int getAvg(LocalDateTime start, long period, TemporalUnit units) {
		double sum = 0;
		int s = 1;

		for (Measurement r : obtainMeasurements(start, period, units)) {
			sum += r.gettemp();
			s++;
		}
		return (int) Math.round(sum / s);

	}

	// Setters y getters

	public LocalDateTime gethour() {
		return hour;
	}

	public void sethour(LocalDateTime hour) {
		this.hour = hour;
	}

	public double gettemp() {
		return temp;
	}

	public void settemp(int temp) {
		this.temp = temp;
	}

	@Override
	public int compareTo(Measurement o) {
		int output;
		if (this.gethour().equals(o.gethour()))
			output = 0;
		else if (this.gethour().isBefore(o.gethour()))
			output = -1;
		else
			output = 1;
		return output;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Measurement)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		Measurement other = (Measurement) obj;
		return new EqualsBuilder().append(hour, other.hour).append(temp, other.temp).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(hour).append(temp).toHashCode();
	}

}
