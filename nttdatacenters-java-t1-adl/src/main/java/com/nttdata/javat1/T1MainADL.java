package com.nttdata.javat1;

import java.util.Scanner;

import com.nttdata.javat1.game.Game;
import com.nttdata.javat1.game.Score;
import com.nttdata.javat1.game.ThreadError;

/**
 * Clase principal del programa, contiene el metodo main
 * 
 * @author adri
 *
 */
public class T1MainADL {
	/**
	 * Constructor privado para que no se instancie la clase.
	 */
	private T1MainADL() {

	}

	/**
	 * Metodo main
	 * 
	 * @param args lineas de comandos
	 * @throws InterruptedException si ocurre un error de interrupcion de hilo
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		boolean salida;
		do {
			Game game = new Game(s);
			try {
				game.launchAndStart();
			} catch (InterruptedException | ThreadError e) {
				e.printStackTrace();
				throw new InterruptedException();
			}
			Score.imprimirPuntuaciones();
			s.nextLine();
			System.out.println("pulse y para jugar otra vez");
			if ((s.next().equals("y")))
				salida = false;
			else
				salida = true;
		} while (!salida);
		s.close();
	}
}
