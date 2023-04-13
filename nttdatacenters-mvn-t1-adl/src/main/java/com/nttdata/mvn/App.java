package com.nttdata.mvn;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Clase para probar la librería Apache Commonns Lang
 * 
 */
public class App {
	/**
	 * Método main en el que se va a llamar a algunos de los métodos del paquete
	 * RandomStringUtils perteneciente a la librería Apache Commons Lang
	 * 
	 */
	public static void main(String[] args) {

		System.out.println("10 letras aleatorias: " + RandomStringUtils.randomAlphabetic(10));

		System.out.println("10 caracteres ascii aleatorios: " + RandomStringUtils.randomAscii(10));

		System.out.println("10 numeros aleatorios: " + RandomStringUtils.randomNumeric(10));

		System.out.println("10 caracteres alfanumericos aleatorios: " + RandomStringUtils.random(10, true, true));

		System.out.println("10 vocales aleatorias: " + RandomStringUtils.random(10, "aeiou"));
	}
}
