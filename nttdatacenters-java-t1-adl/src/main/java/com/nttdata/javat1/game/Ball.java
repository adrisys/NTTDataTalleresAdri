package com.nttdata.javat1.game;

import java.util.Scanner;

/**
 * Clase que contiene información de la pelota de pinball. Utiliza el patrón
 * Singleton para que solo pueda existir una única instancia de pelota.
 * 
 * @author adri
 *
 */
public class Ball {
	/**
	 * Instancia única de la clase
	 */
	static Ball instance;
	/**
	 * Posición de la pelota
	 */
	private int[] position = new int[2];
	/**
	 * Tipo de pelota, carácter que la representa en el tablero
	 */
	private char type;

	// Constructor privado para evitar la creación de instancias directamente
	private Ball() {
	}

	// Método estático para obtener la instancia única
	public static Ball getInstance(Scanner sc) {
		instance = new Ball();
		System.out.println("Introduce a continuación el carácter que quieres que sea la pelota (Se recomienda una o)");
		instance.setTipo(sc.next().charAt(0));
		instance.setx(25);
		instance.sety(0);
		return instance;
	}

//Getters y Setters 
	public int[] getPosicion() {
		return position;
	}

	public void setPosicion(int[] posicion) {
		this.position = posicion;
	}

	public int getx() {
		return position[0];
	}

	public int gety() {
		return position[1];
	}

	public void setx(int x) {
		this.position[0] = x;
	}

	public void sety(int y) {
		this.position[1] = y;
	}

	public char getTipo() {
		return type;
	}

	public void setTipo(char tipo) {
		this.type = tipo;
	}

}
