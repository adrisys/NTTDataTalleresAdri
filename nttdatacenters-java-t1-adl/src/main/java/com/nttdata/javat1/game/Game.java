package com.nttdata.javat1.game;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que contiene la logica de un partida
 * 
 * @author adri
 *
 */
public class Game {
	/**
	 * Objeto random para obtener numeros pseudo-aleatorios
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
	 * Multiplicador de puntuacion
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
	 * Camino actual que esta recorriendo la pelota.
	 */
	private int currentThread;

	/**
	 * Constructor unico, inicializa los atributos del juego
	 * 
	 * @param sc Scanner para leer la entrada del jugador
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
	 * Metodo que hace comenzar la partida
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 * @throws ThreadError          si se produce un error al asignar el camino
	 */
	public void launchAndStart() throws InterruptedException, ThreadError {
		this.startTime = System.currentTimeMillis();
		while (currentThread != 12) {
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
			case 11:
				camino11();
				break;
			default:
				throw new ThreadError("Error al asignar camino");
			}

		}
	}

	/**
	 * Metodo que obtiene el indice que representa una posicion concreta en
	 * StringBuilder a partir de las coordenadas cartesianas de la posicion de la
	 * pelota
	 * 
	 * @param x coordenada x
	 * @param y coordenada y
	 * @return indice de la posicion en StringBuilder
	 */
	private int getFieldIndex(int x, int y) {
		return ((field.getHeight() - (y + 1)) * (field.getWidth() + 1) + x + 1);
	}

	/**
	 * Metodo que suma la puntuacion correspondiente a un rebote
	 */
	private void bounce() {
		score += bonus * 1000;
	}

	/**
	 * Metodo que imprime un frame en un instante de la partida. Contiene tambie la
	 * logica para añadir la puntuacion correspondiente al paso del tiempo.
	 * 
	 * @param correccionVelocidad parametro que corrige la velocidad de la pelota
	 *                            segun como se mueva. El valor 1 corresponde a
	 *                            100ms y se considera que es lo que tarda la pelota
	 *                            en moverse una posicion hacia abajo
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 */
	private void printFrame(double correccionVelocidad) throws InterruptedException {
		long tiempoActual;
		StringBuilder frameBuilder = new StringBuilder(field.getField()); // Se carga el campo vacio
		frameBuilder.setCharAt(getFieldIndex(ball.getx(), ball.gety()), ball.getTipo()); // Se indica donde esta
																							// la pelota
		System.out.println(frameBuilder.toString()); // Se imprime el campo con la pelota
		tiempoActual = (System.currentTimeMillis() - startTime); // Se obtiene el tiempo actual
		score += (tiempoActual - lastTime) * bonus; // Se suma la puntuacion correspondiente al tiempo en
													// este tramo entre frames.
		lastTime = tiempoActual; // Se guarda el tiempo actual para usarlo en la proxima llamada
		System.out.println("La puntuacion actual es de: " + score); // Se imprime la puntuacion
		Thread.sleep((long) (100 * correccionVelocidad)); // Se esperan el tiempo correspondiente a como se mueva la
															// bola segun el parametro de correccion. La base son 100 ms
															// para poder visualizar el movimiento en la consola.

	}

	/**
	 * Metodo que hace que la pelota recorra el camino 1.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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
			printFrame(1.5); // Se aumenta el tiempo porque la pelota esta rebotando.
			currentThread = 3;
		}
	}

	/**
	 * Metodo que hace que la pelota recorra el camino 2.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 */
	private void camino2() throws InterruptedException {
		ball.setx(ball.getx() - 1);
		printFrame(1 + Math.sqrt(5)); // Se aumenta el tiempo porque la pelota esta rebotando. Preguntame el por que
										// de la operacion matematica y te lo explico.
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
		currentThread = 12; // Aqui no hay rebote porque el camino 12 es que la pelota ha llegado al suelo
		new Score(player, score);
	}

	/**
	 * Metodo que hace que la pelota recorra el camino 3.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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
	 * Metodo que hace que la pelota recorra el camino 4.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 */
	private void camino4() throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() + 1);
			printFrame(Math.sqrt(5));
		}
		bonus *= 2; // Al rebotar aqui se aumenta el multiplicador de puntuacion
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
	 * Metodo que hace que la pelota recorra el camino 5.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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
	 * Metodo que hace que la pelota recorra el camino 6.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 */
	private void camino6() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			ball.sety(ball.gety() - 1);
			ball.setx(ball.getx() + 1);
			printFrame(Math.sqrt(5));
		}
		bounce();
		if (r.nextDouble() > 0.35)
			currentThread = 7; // 65% de probabilidad de tomar el camino 7 y volver al camino 6, 7% de tomar
								// el camino 11 y 28% de tomar el camino 8.
		else if (r.nextDouble() < 0.2)
			currentThread = 11;
		else
			currentThread = 8;

	}

	/**
	 * Metodo que hace que la pelota recorra el camino 7.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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
	 * Metodo que hace que la pelota recorra el camino 8.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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
	 * Metodo que hace que la pelota recorra el camino 9.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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

		currentThread = 12;
		new Score(player, score);
	}

	/**
	 * Metodo que hace que la pelota recorra el camino 10.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
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

	/**
	 * Metodo que hace que la pelota recorra el camino 11.
	 * 
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 */
	private void camino11() throws InterruptedException {
		ball.setx(ball.getx() + 2);
		printFrame(2 * Math.sqrt(5));
		ball.sety(ball.gety() + 1);
		ball.setx(ball.getx() + 5);
		printFrame(Math.sqrt(26));
		bounce();

		for (int i = 0; i < 4; i++) {
			ball.sety(ball.gety() - 1);
			printFrame(1);
		}
		currentThread = 12;
		new Score(player, score);
	}

	// Getter y Setter para la puntuacion
	/**
	 * Obtiene la puntuacion actual del juego.
	 * 
	 * @return La puntuacion actual del juego.
	 */
	public long getPuntuacion() {
		return score;
	}

	/**
	 * Establece la puntuacion del juego.
	 * 
	 * @param puntuacion La nueva puntuacion del juego.
	 */
	public void setPuntuacion(long puntuacion) {
		this.score = puntuacion;
	}

	// Getter y Setter para el bonus
	/**
	 * Obtiene el valor actual del bonus del juego.
	 * 
	 * @return El valor actual del bonus del juego.
	 */
	public long getBonus() {
		return bonus;
	}

	/**
	 * Establece el valor del bonus del juego.
	 * 
	 * @param bonus El nuevo valor del bonus del juego.
	 */
	public void setBonus(long bonus) {
		this.bonus = bonus;
	}

	// Getter y Setter para el tiempo anterior
	/**
	 * Obtiene el tiempo anterior del juego.
	 * 
	 * @return El tiempo anterior del juego.
	 */
	public long getTiempoAnterior() {
		return lastTime;
	}

	/**
	 * Establece el tiempo anterior del juego.
	 * 
	 * @param tiempoAnterior El nuevo tiempo anterior del juego.
	 */
	public void setTiempoAnterior(long tiempoAnterior) {
		this.lastTime = tiempoAnterior;
	}

	// Getter y Setter para el tiempo inicial
	/**
	 * Obtiene el tiempo inicial del juego.
	 * 
	 * @return El tiempo inicial del juego.
	 */
	public long getTiempoInicial() {
		return startTime;
	}

	/**
	 * Establece el tiempo inicial del juego.
	 * 
	 * @param tiempoInicial El nuevo tiempo inicial del juego.
	 */
	public void setTiempoInicial(long tiempoInicial) {
		this.startTime = tiempoInicial;
	}

	// Getter y Setter para el camino actual
	/**
	 * Obtiene el camino actual del juego.
	 * 
	 * @return El camino actual del juego.
	 */
	public int getCaminoActual() {
		return currentThread;
	}

	/**
	 * Establece el camino actual del juego.
	 * 
	 * @param caminoActual El nuevo camino actual del juego.
	 */
	public void setCaminoActual(int caminoActual) {
		this.currentThread = caminoActual;
	}

	// Getter y Setter para el jugador
	/**
	 * Obtiene el nombre del jugador.
	 * 
	 * @return El nombre del jugador.
	 */
	public String getJugador() {
		return player;
	}

	/**
	 * Establece el nombre del jugador.
	 * 
	 * @param jugador El nuevo nombre del jugador.
	 */
	public void setJugador(String jugador) {
		this.player = jugador;
	}

	// Getter y Setter para la pelota
	/**
	 * Obtiene la instancia de la pelota actual en el juego.
	 * 
	 * @return La instancia de la pelota actual en el juego.
	 */
	public Ball getPelota() {
		return ball;
	}

	/**
	 * Establece la instancia de la pelota en el juego.
	 * 
	 * @param pelota La nueva instancia de la pelota en el juego.
	 */
	public void setPelota(Ball pelota) {
		this.ball = pelota;
	}

}
