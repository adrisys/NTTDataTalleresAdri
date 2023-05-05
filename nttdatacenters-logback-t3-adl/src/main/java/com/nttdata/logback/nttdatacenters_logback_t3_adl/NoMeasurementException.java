package com.nttdata.logback.nttdatacenters_logback_t3_adl;

/**
 * Class for an exception that appears if there is no data at specific date that
 * the program is trying to read.
 * 
 * @author adri
 *
 */
public class NoMeasurementException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoMeasurementException() {
		super("No data for that date");
	}
}
