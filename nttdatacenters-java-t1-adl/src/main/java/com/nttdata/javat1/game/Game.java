package com.nttdata.javat1.game;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que contiene la lógica de un partida
 * 
 * @author adri
 *
 */
public class Game {
	/**
	 * Objeto random para obtener números pseudo-aleatorios
	 */
	private static Random r = new Random();
	/**
	 * Tablero de juego
	 */
	private static final Field field = new Field();
	/**
	 * Puntuaciçon de la partida
	 */
	private long score;
	/**
	 * Multiplicador de puntuación
	 */
	private long bonus;
	/**
	 * Atributo que guarda el tiempo del tramo anterior al actual
	 */
	private long lastTime = 0;
	/**
	 * Atributo que guarda el instante en el que empieza la partida
	 */
	private long startTime;
	/**
	 * Nombre del jugador de la partida
	 */
	private String player;
	/**
	 * Pelota de pinball
	 */
	private Ball ball;
	/**
	 * Camino actual que está recorriendo la pelota.
	 */
	private int currentThread;

	/**
	 * Constructor único, inicializa los atributos del juego
	 * 
	 * @param sc
	 */
	public Game(Scanner sc) {
		this.score = 0;
		this.bonus = 1;
		System.out.println("Introduzca su nombre");
		this.player = sc.next();
		this.ball = Ball.getInstance(sc);
		this.currentThread = 1;
	}

	/**
	 * Método que hace comenzar la partida
	 * 
	 * @throws InterruptedException
	 * @throws ThreadError
	 * @throws Exception
	 */
	public void launchAndStart() throws InterruptedException, ThreadError {
		this.startTime = System.currentTimeMillis();
		while (currentThread != 11) {
			switch (currentThread) {
			case 1:
				camino1();
				break;
			case 2:
				camino2();
				break;
			case 3:
				camino3();
				break;
			case 4:
				camino4();
				break;
			case 5:
				camino5();
				break;
			case 6:
				camino6();
				break;
			case 7:
				camino7();
				break;
			case 8:
				camino8();
				break;
			case 9:
				camino9();
				break;
			case 10:
				camino10();
				break;
			default:
				throw new ThreadError("Error al asignar camino");
			}

		}
	}

	/**
	 * Método que obtiene el indice que representa una posicion concreta en
	 * StringBuilder a partir de las coordenadas cartesianas de la posición de la
	 * pelota
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private int getFieldIndex(int x, int y) {
		return ((field.getHeight() - (y + 1)) * (field.getWidth() + 1) + x + 1);
	}

	/**
	 * Método que suma la puntuación correspondiente a un rebote
	 */
	private void bounce() {
		score += bonus * 1000;
	}

	/**
	 * Método que imprime un frame en un instante de la partida. Contiene tambié la
	 * lógica para añadir la puntuación correspondiente al paso del tiempo.
	 * 
	 * @param correccionVelocidad parámetro que corrige la velocidad de la pelota
	 *                            según cómo se mueva. El valor 1 corresponde a
	 *                            100ms y se considera que es lo que tarda la pelota
	 *                            en moverse una posición hacia abajo
	 * @throws InterruptedException
	 */
	private void printFrame(double correccionVelocidad) throws InterruptedException {
		long tiempoActual;
		StringBuilder frameBuilder = new StringBuilder(field.getField()); // Se carga el campo vacío
		frameBuilder.setCharAt(getFieldIndex(ball.getx(), ball.gety()), ball.getTipo()); // Se indica donde está
																							// la pelota
		System.out.println(frameBuilder.toString()); // Se imprime el campo con la pelota
		tiempoActual = (System.currentTimeMillis() - startTime); // Se obtiene el tiempo actual
		score += (tiempoActual - lastTime) * bonus; // Se suma la puntuación correspondiente al tiempo en
													// este tramo entre frames.
		lastTime = tiempoActual; // Se guarda el tiempo actual para usarlo en la proxima llamada
		System.out.println("La puntuación actual es de: " + score); // Se imprime la puntuación
		Thread.sleep((long) (100 * correccionVelocidad)); // Se esperan el tiempo correspondiente a cómo se mueva la
															// bola según el parámetro de corrección. La base son 100 ms
															// para poder visualizar el movimiento en la consola.

	}

	/**
	 * Método que hace que la pelota recorra el camino 1.
	 * 
	 * @throws InterruptedException
	 */
	private void camino1() throws InterruptedException {
		for (int i = 0; i < 16; i++) {
			ball.sety(i + 1);
			printFrame(1);
		}
		bounce(); // Cuando un bucle termina es porque la pelota rebota
		if (r.nextDouble() > 0.8)
			currentThread = 2;
		else {
			ball.setx(ball.getx() - 1);
			ball.sety(ball.gety() + 1);
			printFrame(1.5); // Se aumenta el tiempo porque la pelota está rebotando.
			currentThread = 3;
		}
	}

	/**
	 * Método que hace que la pelota recorra el camino 2.
	 * 
	 * @throws InterruptedException
	 */
	private void camino2() throws InterruptedException {
		ball.setx(ball.getx() - 1);
		printFrame(1 + Math.sqrt(5)); // Se aumenta el tiempo porque la pelota está rebotando. Preguntame el por qué
										// de la operacion matemática y te lo explico.
		for (int i = 0; i < 3; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() - 2);
			printFrame(Math.sqrt(8));// Al moverse en diagonal 2unidades verticales y 1 horizontal o viceversa se
										// aplica un factor Sqrt(8)
		}
		bounce();
		for (int i = 0; i < 5; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() + 1);
			printFrame(Math.sqrt(5));
		}
		bounce();
		ball.sety(ball.gety() - 1);
		printFrame(Math.sqrt(5));

		for (int i = 0; i < 6; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() - 1);
			printFrame(Math.sqrt(5));
		}
		currentThread = 11; // Aquí no hay rebote porque el camino 11 es que la pelota ha llegado al suelo
		new Score(player, score);
	}

	/**
	 * Método que hace que la pelota recorra el camino 3.
	 * 
	 * @throws InterruptedException
	 */
	private void camino3() throws InterruptedException {

		for (int i = 0; i < 22; i++) {
			ball.setx(ball.getx() - 1);
			printFrame(0.5); // 1 unidad vertical corresponde a 2 unidades horizontales
		}
		bounce();
		if (r.nextBoolean())
			currentThread = 4; // 50% de probabilidad de tomar el camino 4 o el 5
		else
			currentThread = 5;
	}

	/**
	 * Método que hace que la pelota recorra el camino 4.
	 * 
	 * @throws InterruptedException
	 */
	private void camino4() throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() + 1);
			printFrame(Math.sqrt(5));
		}
		bonus *= 2; // Al rebotar aquí se aumenta el multiplicador de puntuación
		bounce();
		for (int i = 0; i < 4; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() - 1);
			printFrame(Math.sqrt(5));
		}
		bounce();
		currentThread = 6;
	}

	/**
	 * Método que hace que la pelota recorra el camino 5.
	 * 
	 * @throws InterruptedException
	 */
	private void camino5() throws InterruptedException {
		for (int i = 0; i < 8; i++) {
			ball.sety(ball.gety() - 1);
			printFrame(1);
		}
		bounce();
		currentThread = 6;
	}

	/**
	 * Método que hace que la pelota recorra el camino 6.
	 * 
	 * @throws InterruptedException
	 */
	private void camino6() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() + 1);
			printFrame(Math.sqrt(5));
		}
		bounce();
		if (r.nextDouble() > 0.35)
			currentThread = 7; // 65% de probabilidad de tomar el camino 7 y volver al camino 6, 35% de tomar
								// el camino 8.
		else
			currentThread = 8;

	}

	/**
	 * Método que hace que la pelota recorra el camino 7.
	 * 
	 * @throws InterruptedException
	 */
	private void camino7() throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			ball.sety(ball.gety() + 1);
			printFrame(1);
		}
		bounce();
		ball.setx(ball.getx() - 1);
		ball.sety(ball.gety() + 1);
		printFrame(Math.sqrt(5));
		for (int i = 0; i < 4; i++) {
			ball.setx(ball.getx() - 1);
			printFrame(0.5);
		}
		bounce();
		currentThread = 6;
	}

	/**
	 * Método que hace que la pelota recorra el camino 8.
	 * 
	 * @throws InterruptedException
	 */
	private void camino8() throws InterruptedException {
		ball.setx(ball.getx() + 2);
		printFrame(2 * Math.sqrt(5));
		for (int i = 0; i < 2; i++) {
			ball.sety(ball.gety() + 1);
			ball.setx(ball.getx() + 2);
			printFrame(Math.sqrt(8));
		}
		bounce();
		if (r.nextDouble() > 0.35)
			currentThread = 10; // 65% de probabilidad de tomar el camino 10 y volver al camino 3, 35% para
								// tomar el camino 9 y terminar
		else
			currentThread = 9;

	}

	/**
	 * Método que hace que la pelota recorra el camino 9.
	 * 
	 * @throws InterruptedException
	 */
	private void camino9() throws InterruptedException {

		for (int i = 0; i < 2; i++) {
			ball.sety(ball.gety() + 2);
			ball.setx(ball.getx() - 1);
			printFrame(Math.sqrt(17));
		}
		bounce();
		for (int i = 0; i < 9; i++) {
			ball.sety(ball.gety() - 1);
			printFrame(1);
		}

		currentThread = 11;
		new Score(player, score);
	}

	/**
	 * Método que hace que la pelota recorra el camino 10.
	 * 
	 * @throws InterruptedException
	 */
	private void camino10() throws InterruptedException {
		for (int i = 0; i < 9; i++) {
			ball.sety(ball.gety() + 1);
			ball.setx(ball.getx() + 1);
			printFrame(Math.sqrt(5));
		}
		bounce();
		if (r.nextBoolean()) {
			ball.sety(ball.gety() + 2);
			ball.setx(ball.getx() + 2);
			printFrame(Math.sqrt(20));
			currentThread = 3;
		} else {
			ball.sety(ball.gety() + 1);
			ball.setx(ball.getx() + 3);
			currentThread = 2;
		}

	}

//Getters y setters 
	public long getPuntuacion() {
		return score;
	}

	public void setPuntuacion(long puntuacion) {
		this.score = puntuacion;
	}

	public long getBonus() {
		return bonus;
	}

	public void setBonus(long bonus) {
		this.bonus = bonus;
	}

	public long getTiempoAnterior() {
		return lastTime;
	}

	public void setTiempoAnterior(long tiempoAnterior) {
		this.lastTime = tiempoAnterior;
	}

	public long getTiempoInicial() {
		return startTime;
	}

	public void setTiempoInicial(long tiempoInicial) {
		this.startTime = tiempoInicial;
	}

	public int getCaminoActual() {
		return currentThread;
	}

	public void setCaminoActual(int caminoActual) {
		this.currentThread = caminoActual;
	}

	public String getJugador() {
		return player;
	}

	public void setJugador(String jugador) {
		this.player = jugador;
	}

	public Ball getPelota() {
		return ball;
	}

	public void setPelota(Ball pelota) {
		this.ball = pelota;
	}

}
