package com.nttdata.javat1.game;
/**
 * Clase que representa a un error relacionado con los caminos que recorre la pelota en el tablero, los cuales deben estar determinados según la lógica del programa.
 * @author adri
 *
 */
public class ThreadError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Constructor único de la clase
 * @param message
 */
	public ThreadError(String message) {
		super(message);
	}

}
