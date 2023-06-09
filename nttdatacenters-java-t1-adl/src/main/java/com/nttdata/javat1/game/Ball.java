package com.nttdata.javat1.game;

import java.util.Scanner;

/**
 * Clase que contiene informacion de la pelota de pinball. Utiliza el patron
 * Singleton para que solo pueda existir una unica instancia de pelota.
 * 
 * author adri
 *
 */
public class Ball {
	/**
	 * Instancia unica de la clase
	 */
	static Ball instance;
	/**
	 * Posicion de la pelota
	 */
	private int[] position = new int[2];
	/**
	 * Tipo de pelota caracter que la representa en el tablero
	 */
	private char type;

	/*
	 * Constructor privado para evitar la creacion de instancias directamente
	 */
	private Ball() {
	}

	/**
	 * Metodo estatico para obtener la instancia unica de la pelota.
	 * 
	 * @param sc el objeto Scanner utilizado para obtener la entrada del usuario
	 * @return la instancia unica de la pelota
	 */
	public static Ball getInstance(Scanner sc) {
		instance = new Ball();
		System.out.println("Introduce a continuacion el caracter que quieres que sea la pelota (Se recomienda una o)");
		instance.setTipo(sc.next().charAt(0));
		instance.setx(25);
		instance.sety(0);
		return instance;
	}

	/**
	 * Getter del atributo position
	 * 
	 * @return la posicion de la pelota
	 */
	public int[] getPosicion() {
		return position;
	}

	/**
	 * Setter del atributo position
	 * 
	 * @param posicion el nuevo valor para la posicion de la pelota
	 */
	public void setPosicion(int[] posicion) {
		this.position = posicion;
	}

	/**
	 * Getter de la coordenada x de la posicion de la pelota
	 * 
	 * @return la coordenada x de la posicion de la pelota
	 */
	public int getx() {
		return position[0];
	}

	/**
	 * Getter de la coordenada y de la posicion de la pelota
	 * 
	 * @return la coordenada y de la posicion de la pelota
	 */
	public int gety() {
		return position[1];
	}

	/**
	 * Setter de la coordenada x de la posicion de la pelota
	 * 
	 * @param x la nueva coordenada x de la posicion de la pelota
	 */
	public void setx(int x) {
		this.position[0] = x;
	}

	/**
	 * Setter de la coordenada y de la posicion de la pelota
	 * 
	 * @param y la nueva coordenada y de la posicion de la pelota
	 */
	public void sety(int y) {
		this.position[1] = y;
	}

	/**
	 * Getter del atributo type
	 * 
	 * @return el tipo de la pelota
	 */
	public char getTipo() {
		return type;
	}

	/**
	 * Setter del atributo type
	 * 
	 * @param tipo el nuevo tipo de la pelota
	 */
	public void setTipo(char tipo) {
		this.type = tipo;
	}

}
