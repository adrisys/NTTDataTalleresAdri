package com.nttdata.javat1.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa la puntuación de una partida
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
	 * Constructor único para guardar una puntuación
	 * 
	 * @param jugador
	 * @param puntuacion
	 */
	public Score(String jugador, long puntuacion) {
		this.player = jugador;
		this.scoreValue = puntuacion;
		scoreList.add(this);
	}

//Getters y setters
	public String getJugador() {
		return player;
	}

	public void setJugador(String jugador) {
		this.player = jugador;
	}

	public long getPuntuacion() {
		return scoreValue;
	}

	public void setPuntuacion(long puntuacion) {
		this.scoreValue = puntuacion;
	}

	public static List<Score> getPuntuaciones() {
		return scoreList;
	}

	public static void setPuntuaciones(List<Score> puntuaciones) {
		Score.scoreList = puntuaciones;
	}

	/**
	 * Método que imprime todas las puntuaciones registradas
	 */
	public static void imprimirPuntuaciones() {
		Collections.sort(scoreList);
		System.out.println("-----------SCOREBOARD-----------");
		for (Score s : scoreList) {
			System.out.println(s.toString());
		}
	}

//Sobreescritura de métodos de Object para implementar una lógica concreta de impresión y de comparación
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
