package com.nttdata.javat1.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa la puntuacion de una partida
 * 
 * @author adri
 *
 */
public class Score implements Comparable<Score> {
	/**
	 * Lista con las puntuaciones registradas
	 */
	private static List<Score> scoreList = new ArrayList<>();
	/**
	 * Nombre del jugador de la partida
	 */
	private String player;
	/**
	 * Puntuacion de la partida
	 */
	private long scoreValue;

	/**
	 * Constructor unico para guardar una puntuacion
	 * 
	 * @param jugador    jugador de la partida
	 * @param puntuacion puntuacion de la partida
	 */
	public Score(String jugador, long puntuacion) {
		this.player = jugador;
		this.scoreValue = puntuacion;
		scoreList.add(this);
	}

	// Getter y Setter para el jugador
	/**
	 * Obtiene el nombre del jugador actual.
	 *
	 * @return El nombre del jugador actual.
	 */
	public String getJugador() {
		return player;
	}

	/**
	 * Establece el nombre del jugador actual.
	 *
	 * @param jugador El nuevo nombre del jugador actual.
	 */
	public void setJugador(String jugador) {
		this.player = jugador;
	}

	// Getter y Setter para la puntuacion
	/**
	 * Obtiene el valor de la puntuacion actual.
	 *
	 * @return El valor de la puntuacion actual.
	 */
	public long getPuntuacion() {
		return scoreValue;
	}

	/**
	 * Establece el valor de la puntuacion actual.
	 *
	 * @param puntuacion El nuevo valor de la puntuacion actual.
	 */
	public void setPuntuacion(long puntuacion) {
		this.scoreValue = puntuacion;
	}

	// Getter y Setter para la lista de puntuaciones
	/**
	 * Obtiene la lista de puntuaciones.
	 *
	 * @return La lista de puntuaciones.
	 */
	public static List<Score> getPuntuaciones() {
		return scoreList;
	}

	/**
	 * Establece la lista de puntuaciones.
	 *
	 * @param puntuaciones La nueva lista de puntuaciones.
	 */
	public static void setPuntuaciones(List<Score> puntuaciones) {
		Score.scoreList = puntuaciones;
	}

	/**
	 * Metodo que imprime todas las puntuaciones registradas
	 */
	public static void imprimirPuntuaciones() {
		Collections.sort(scoreList);
		System.out.println("-----------SCOREBOARD-----------");
		for (Score s : scoreList) {
			System.out.println(s.toString());
		}
	}

//Sobreescritura de metodos de Object para implementar una logica concreta de impresion y de comparacion
	@Override
	public String toString() {
		return player + ": " + scoreValue + " puntos.";
	}

	@Override
	public int compareTo(Score other) {
		if (this.scoreValue > other.scoreValue) {
			return -1;
		} else if (this.scoreValue < other.scoreValue) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true; // Son la misma instancia, por lo tanto, son iguales
		}
		if (o == null || getClass() != o.getClass()) {
			return false; // El objeto es nulo o no es una instancia de Score, por lo tanto, no son
							// iguales
		}
		Score other = (Score) o;
		return (this.player.equals(other.getJugador()) && this.scoreValue == other.getPuntuacion());

	}

	@Override
	public int hashCode() {
		return (player.hashCode() + Long.hashCode(scoreValue));
	}
}
