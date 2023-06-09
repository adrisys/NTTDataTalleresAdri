package utils;

import java.util.Scanner;

import com.nttdata.javat3.data.entities.Student.Course;

/**
 * Clase que contien metodos utiles
 * 
 * @author adri
 *
 */
public class Utils {
	/**
	 * Se hace privado el constructor para no poder instanciar la clase
	 */
	private Utils() {

	}

	/**
	 * Scanner para leer datos por consola
	 */
	private static Scanner s = new Scanner(System.in);

	/**
	 * Metodo para leer una cadena de texto, mostrando antes un mensaje pidiendo el
	 * tipo de dato que se quiere
	 * 
	 * @param message mensaje para mostrar al usuario
	 * @return dato leido
	 */
	public static String readString(String message) {
		System.out.println(message);
		return s.next();
	}

	/**
	 * Metodo que lee un tipo de curso
	 * 
	 * @return tipo de curso.
	 */
	public static Course readCourse() {
		System.out.println("Introduce el curso (DAM o DAW)");
		return Course.valueOf(s.next());
	}

}
